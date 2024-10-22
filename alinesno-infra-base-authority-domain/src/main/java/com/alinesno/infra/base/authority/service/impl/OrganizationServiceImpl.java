package com.alinesno.infra.base.authority.service.impl;

import com.alinesno.infra.base.authority.annotation.PermissionQuery;
import com.alinesno.infra.base.authority.api.OrganizationDto;
import com.alinesno.infra.base.authority.entity.ManagerAccountEntity;
import com.alinesno.infra.base.authority.entity.OrganizationAccountEntity;
import com.alinesno.infra.base.authority.entity.OrganizationEntity;
import com.alinesno.infra.base.authority.enums.AccountOrganizationType;
import com.alinesno.infra.base.authority.mapper.ManagerAccountMapper;
import com.alinesno.infra.base.authority.mapper.OrganizationAccountMapper;
import com.alinesno.infra.base.authority.mapper.OrganizationMapper;
import com.alinesno.infra.base.authority.service.IOrganizationService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@Slf4j
@Service
public class OrganizationServiceImpl extends IBaseServiceImpl<OrganizationEntity, OrganizationMapper> implements IOrganizationService {

	@Autowired
	private OrganizationAccountMapper organizationAccountMapper;

	@Autowired
	private ManagerAccountMapper managerAccountMapper ;

	@Override
	public void saveOrganizationAccount(OrganizationAccountEntity orgAccount) {
		organizationAccountMapper.insert(orgAccount);
	}

	@Override
	public TableDataInfo queryOrganization(DatatablesPageBean page, long accountId) {

		TableDataInfo tableDataInfo = new TableDataInfo();

		LambdaQueryWrapper<OrganizationAccountEntity> queryOrgAccountWrapper = new LambdaQueryWrapper<>() ;
		queryOrgAccountWrapper.eq(OrganizationAccountEntity::getAccountId, accountId) ;

		List<OrganizationAccountEntity> list = organizationAccountMapper.selectList(queryOrgAccountWrapper) ;

		LambdaQueryWrapper<OrganizationEntity> queryWrapper = new LambdaQueryWrapper<>() ;
		queryWrapper.in(OrganizationEntity::getId, list.stream().map(OrganizationAccountEntity::getOrgId).toList()) ;
		queryWrapper.orderByDesc(OrganizationEntity::getAddTime) ;

		Page<OrganizationEntity> mpPage = new Page<>(page.getPageNum(), page.getPageSize());
		mpPage = page(mpPage , queryWrapper) ;

		List<OrganizationDto> dtoRecords = new ArrayList<>() ;

		List<OrganizationEntity> records = mpPage.getRecords() ;
		records.forEach(e -> {
			OrganizationDto dto = new OrganizationDto() ;

			dto.setMemberCount(getAccountMemberCount(e.getId()));
			BeanUtils.copyProperties(e , dto);

			dtoRecords.add(dto) ;
		});

		tableDataInfo.setRows(dtoRecords);
		tableDataInfo.setTotal(mpPage.getTotal());

		return tableDataInfo;
	}

	private long getAccountMemberCount(Long id) {

		LambdaQueryWrapper<OrganizationAccountEntity> wrapper = new LambdaQueryWrapper<>() ;
		wrapper.eq(OrganizationAccountEntity::getOrgId, id);

		return organizationAccountMapper.selectCount(wrapper) ;
	}

	@Override
	public OrganizationEntity checkUserInOrg(long accountId , long orgId) {

		// 判断组织是否存在
		checkAccountInfo(accountId, orgId);

		LambdaUpdateWrapper<OrganizationAccountEntity> wrapper = new LambdaUpdateWrapper<>();
		wrapper.eq(OrganizationAccountEntity::getAccountId, accountId);
		wrapper.eq(OrganizationAccountEntity::getOrgId, orgId);

		List<OrganizationAccountEntity> list = organizationAccountMapper.selectList(wrapper);

		return list.isEmpty() ? null : getById(orgId) ;
	}

	@Override
	public OrganizationAccountEntity getByAccountIdAndOrgId(Long id, long orgId) {

		LambdaQueryWrapper<OrganizationAccountEntity> queryWrapper = new LambdaQueryWrapper<>() ;
		queryWrapper.eq(OrganizationAccountEntity::getAccountId, id)
				.eq(OrganizationAccountEntity::getOrgId, orgId) ;

		return organizationAccountMapper.selectOne(queryWrapper) ;
	}

	@Override
	public List<OrganizationDto> listByAccountId(Long id) {

		LambdaQueryWrapper<OrganizationAccountEntity> queryWrapper = new LambdaQueryWrapper<>() ;
		queryWrapper.eq(OrganizationAccountEntity::getAccountId, id) ;

		List<OrganizationAccountEntity> list = organizationAccountMapper.selectList(queryWrapper) ;

		LambdaQueryWrapper<OrganizationEntity> orgQueryWrapper = new LambdaQueryWrapper<>() ;
		if(list != null && !list.isEmpty()){
			orgQueryWrapper.in(OrganizationEntity::getId, list.stream()
					.map(OrganizationAccountEntity::getOrgId)
					.toList()) ;
		}

		List<OrganizationEntity> orgList = mapper.selectList(orgQueryWrapper) ;

		List<OrganizationDto>  orgDtoList = new ArrayList<>() ;

		if(!orgList.isEmpty()){
			orgList.forEach(org -> {
				OrganizationDto dto = new OrganizationDto() ;
				BeanUtils.copyProperties(org, dto);

				// 设置组织角色类型
				// int accountType = list.stream().filter(item -> item.getOrgId().equals(org.getId())).findFirst().get().getOrgType() ;

				orgDtoList.add(dto) ;
			});
		}

		return orgDtoList ;
	}

	@Override
	public void createOrJoinOrg(OrganizationDto dto, long accountId) {
		int type = dto.getType();

		String doorplateNumber = dto.getJoinDoorplateNumber() ;

		if(type == 1){  // 加入组织(成为成员)

			LambdaQueryWrapper<OrganizationEntity> wrapper = new LambdaQueryWrapper<>();
			wrapper.eq(OrganizationEntity::getDoorplateNumber, doorplateNumber);
			long joinOrgId = getOne(wrapper).getId();

			this.joinOrg(accountId, joinOrgId);
		}else if(type == 0){ // 创建组织(则成为管理员)

			ManagerAccountEntity managerAccountEntity = managerAccountMapper.selectById(accountId);

			OrganizationEntity entity = new OrganizationEntity();
			BeanUtils.copyProperties(dto, entity);

			// 联系人设置成管理员
			entity.setOrgPhone(managerAccountEntity.getPhone());
			entity.setSystemInner("N");

			save(entity) ;

			OrganizationAccountEntity organizationAccountEntity = new OrganizationAccountEntity();

			organizationAccountEntity.setAccountId(accountId);
			organizationAccountEntity.setOrgId(entity.getId());
			organizationAccountEntity.setOrgType(AccountOrganizationType.ADMINISTRATOR.getType());

			organizationAccountMapper.insert(organizationAccountEntity);

		}
	}

	@Override
	public OrganizationAccountEntity getByAccountId(long accountId) {
		OrganizationAccountEntity entity = organizationAccountMapper.selectOne(new LambdaQueryWrapper<OrganizationAccountEntity>()
				.eq(OrganizationAccountEntity::getAccountId, accountId)) ;

		if(entity != null){
			OrganizationEntity e = getById(entity.getOrgId());
			entity.setOrganizationEntity(e);
			return entity ;
		}

		return null;
	}

	@Override
	public void joinOrg(long accountId, long orgId) {

		// 判断组织是否存在
		checkAccountInfo(accountId, orgId);

		// 判断之前是否已经存在组织
		OrganizationAccountEntity entity = organizationAccountMapper.selectOne(new LambdaQueryWrapper<OrganizationAccountEntity>()
				.eq(OrganizationAccountEntity::getAccountId, accountId)
				.eq(OrganizationAccountEntity::getOrgId, orgId));
		Assert.isNull(entity, "用户已经存在该组织");

		OrganizationAccountEntity organizationAccountEntity = new OrganizationAccountEntity();

		organizationAccountEntity.setAccountId(accountId);
		organizationAccountEntity.setOrgId(orgId);
		organizationAccountEntity.setOrgType(AccountOrganizationType.REGULAR_USER.getType());

		organizationAccountMapper.insert(organizationAccountEntity);
	}

	private void checkAccountInfo(long accountId, long orgId) {
		// 判断用户是否存在
		LambdaQueryWrapper<OrganizationEntity> queryWrapper = new LambdaQueryWrapper<>() ;
		queryWrapper.eq(OrganizationEntity::getId, orgId);
		OrganizationEntity org = mapper.selectOne(queryWrapper);
		Assert.notNull(org , "组织不存在");

		// 判断用户是否存在
		ManagerAccountEntity account = managerAccountMapper.selectById(accountId);
		Assert.notNull(account , "用户不存在");
	}

	@Override
	public void quitOrg(long accountId , long orgId) {

		// 从组织中退出
		organizationAccountMapper.delete(new LambdaQueryWrapper<OrganizationAccountEntity>()
				.eq(OrganizationAccountEntity::getAccountId, accountId)
				.eq(OrganizationAccountEntity::getOrgId, orgId));
	}
}
