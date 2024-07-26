package com.alinesno.infra.base.authority.service.impl;

import com.alinesno.infra.base.authority.api.OrganizationDto;
import com.alinesno.infra.base.authority.entity.OrganizationAccountEntity;
import com.alinesno.infra.base.authority.entity.OrganizationEntity;
import com.alinesno.infra.base.authority.mapper.OrganizationAccountMapper;
import com.alinesno.infra.base.authority.mapper.OrganizationMapper;
import com.alinesno.infra.base.authority.service.IOrganizationService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public void saveOrganizationAccount(OrganizationAccountEntity orgAccount) {
		organizationAccountMapper.insert(orgAccount);
	}

	@Override
	public TableDataInfo queryOrganization(DatatablesPageBean page) {

		TableDataInfo tableDataInfo = new TableDataInfo();

		LambdaQueryWrapper<OrganizationEntity> queryWrapper = new LambdaQueryWrapper<>() ;
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
}
