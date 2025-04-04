package com.alinesno.infra.base.authority.service.impl;

import com.alinesno.infra.base.authority.entity.ManagerAccountRoleEntity;
import com.alinesno.infra.base.authority.entity.ManagerProjectEntity;
import com.alinesno.infra.base.authority.mapper.ManagerAccountRoleMapper;
import com.alinesno.infra.base.authority.service.IManagerAccountRoleService;
import com.alinesno.infra.base.authority.service.IManagerProjectService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.common.facade.wrapper.mybatis.WrapperGenerator;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
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
public class ManagerAccountRoleServiceImpl extends IBaseServiceImpl<ManagerAccountRoleEntity, ManagerAccountRoleMapper> implements IManagerAccountRoleService {

	@Autowired
	private ManagerAccountRoleMapper managerAccountRoleMapper;
	
	@Autowired
	private IManagerProjectService iManagerProjectService;

	@Override
	public List<ManagerAccountRoleEntity> findAllByAccountId(Long accountId) { 
		QueryWrapper<ManagerAccountRoleEntity> w = WrapperGenerator.build();
		w.eq("account_id", accountId); 
		return managerAccountRoleMapper.selectList(w);
	}

	@Override
	public void AuthorizeUsers(List<Long> roleIds, Long accountId) {
		List<ManagerAccountRoleEntity> saveList = new ArrayList<>(); 
		deleteByAccountId(accountId);
		for (Long roleId : roleIds) {
			ManagerAccountRoleEntity entity = new ManagerAccountRoleEntity();
			entity.setRoleId(roleId);
			entity.setAccountId(accountId);
			entity.setAddTime(new Date());
			saveList.add(entity);
		}
		if (!saveList.isEmpty()) {
			saveBatch(saveList);
		}
	}

	@Override
	public void deleteByAccountId(Long id) {
 
		QueryWrapper<ManagerAccountRoleEntity> wrapper = WrapperGenerator.build();
		wrapper.eq("account_id", id);

		managerAccountRoleMapper.delete(wrapper);
	}

	@Override
	public void authorizeUsers(List<Long> roleIds, Long accountId, String projectCode) {
		 
		ManagerProjectEntity application = iManagerProjectService.findByProjectCode(projectCode);
		 
		if (CollectionUtils.isEmpty(roleIds)) {
			return;
		}
	 
		// 删除角色
		if (CollectionUtils.isEmpty(roleIds)) {
			return;
		}
		LambdaQueryWrapper<ManagerAccountRoleEntity> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(ManagerAccountRoleEntity::getAccountId, accountId);
		wrapper.eq(ManagerAccountRoleEntity::getApplicationId, application.getId());
		this.getBaseMapper().delete(wrapper);

		// 添加新角色
		List<ManagerAccountRoleEntity> list = new ArrayList<>();
		roleIds.forEach(id -> {
			ManagerAccountRoleEntity e = new ManagerAccountRoleEntity();
			e.setRoleId(id);
			e.setAccountId(accountId);
			e.setApplicationId(application.getId());
			list.add(e);
		});

		if (!CollectionUtils.isEmpty(list)) {
			this.saveBatch(list);
		}
	}

}
