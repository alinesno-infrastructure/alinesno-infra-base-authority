package com.alinesno.infra.base.authority.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alinesno.infra.base.authority.entity.ManagerAccountEntity;
import com.alinesno.infra.base.authority.entity.ManagerResourceEntity;
import com.alinesno.infra.base.authority.entity.ManagerRoleEntity;
import com.alinesno.infra.base.authority.enums.RolePowerTypeEnmus;
import com.alinesno.infra.base.authority.mapper.ManagerResourceMapper;
import com.alinesno.infra.base.authority.service.IManagerResourceService;
import com.alinesno.infra.base.authority.service.IManagerRoleService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.common.facade.constants.FieldConstants;
import com.alinesno.infra.common.facade.enums.HasDeleteEnums;
import com.alinesno.infra.common.facade.enums.HasStatusEnums;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.wrapper.Condition;
import com.alinesno.infra.common.facade.wrapper.RpcWrapper;
import com.alinesno.infra.common.facade.wrapper.Wrapper;
import com.alinesno.infra.common.facade.wrapper.mybatis.WrapperGenerator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@Service
public class ManagerResourceServiceImpl extends IBaseServiceImpl<ManagerResourceEntity, ManagerResourceMapper> implements IManagerResourceService {

	// 日志记录
	private static final Logger log = LoggerFactory.getLogger(ManagerResourceServiceImpl.class);
  
	@Autowired
	private IManagerRoleService managerRoleService ; 

	/**
	 * 通过一级目录构建菜单
	 */
	@Override
	public ManagerResourceEntity findMenus(Long resourceParent, Long applicationId) {
		return this.findMenus(resourceParent, applicationId, null);
	}

	@Override
	public ManagerResourceEntity findMenus(Long resourceParent, Long applicationId, Long accountId) {
	 

		return null;
	}
   
	@Override
	public void deleteByApplicationId(String id) { 

		RpcWrapper<ManagerResourceEntity> w = RpcWrapper.build();
		w.eq(FieldConstants.APPLICATION_ID, id);

		deleteByWrapper(w);
	}

	@Override
	public ManagerResourceEntity findMenusByApplicationAndAccount(Long resourceParent, Long applicationId, Long accountId) {
		ManagerResourceEntity e = this.findMenus(resourceParent, applicationId, accountId);

		log.debug("e:{}", e);
	
		// 如果解决角色为空，判断是否应用角色中是否包含互联网默认角色，有则用户直接关联授权
		if(e == null || (e.getSubResource() == null || e.getSubResource().size() == 0)) {
			
			QueryWrapper<ManagerRoleEntity> wrapper = new QueryWrapper<ManagerRoleEntity>() ; 
			wrapper.eq(FieldConstants.APPLICATION_ID, applicationId) 
				   .eq("default_netrole", RolePowerTypeEnmus.ROLE_NETROLE.value) ; 
			
			List<ManagerRoleEntity> netroleList = managerRoleService.list(wrapper) ;
			if(netroleList != null && netroleList.size() > 0) {
				ManagerRoleEntity netRole = netroleList.get(0) ;  // 默认取0
				managerRoleService.apendAccountRole(accountId, new Long[] {netRole.getId()}) ; 
				
				// 重新查询返回菜单
				e = this.findMenus(resourceParent, applicationId, accountId);
			}
			
		}

		return e;
	}

	@Override
	public List<ManagerResourceEntity> findResoucePermission(ManagerAccountEntity account, Long pageId) {
 
		QueryWrapper<ManagerResourceEntity> w = WrapperGenerator.build();
		w.eq("resource_parent", pageId);

		List<ManagerResourceEntity> list = list(w);  

		return list;
	}

	@Override
	public List<ManagerResourceEntity> resourceData(DatatablesPageBean page) {
		RpcWrapper<ManagerResourceEntity> wrapper = RpcWrapper.build();

		if (page != null) {
			wrapper = page.buildWrapper();
		}

		// 删除框架自带的排序条件
		List<Condition> condition = wrapper.getCondition();
		if (condition != null && !condition.isEmpty()) {
			condition = condition.stream().filter(item -> (!item.getCondition().equals(Wrapper.ORDER_BY)))
					.collect(Collectors.toList());
			wrapper.setCondition(condition);
		}

		// 条件查询
		QueryWrapper<ManagerResourceEntity> queryWrapper = wrapper.toQueryWrapper();
		queryWrapper.eq("has_status", HasStatusEnums.LEGAL.value);
		queryWrapper.eq("has_delete", HasDeleteEnums.LEGAL.value);

		queryWrapper.orderByAsc("resource_parent");
		queryWrapper.orderByDesc("resource_order");
		queryWrapper.orderByDesc("add_time");
		return mapper.selectList(queryWrapper);

	}

}
