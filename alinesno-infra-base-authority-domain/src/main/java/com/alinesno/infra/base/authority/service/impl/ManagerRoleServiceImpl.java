package com.alinesno.infra.base.authority.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.alibaba.fastjson.JSONObject;
import com.alinesno.infra.base.authority.api.dto.AccountRoleDto;
import com.alinesno.infra.base.authority.entity.ManagerAccountEntity;
import com.alinesno.infra.base.authority.entity.ManagerAccountRoleEntity;
import com.alinesno.infra.base.authority.entity.ManagerApplicationEntity;
import com.alinesno.infra.base.authority.entity.ManagerRoleEntity;
import com.alinesno.infra.base.authority.entity.ManagerRoleResourceEntity;
import com.alinesno.infra.base.authority.enums.RolePowerTypeEnmus;
import com.alinesno.infra.base.authority.mapper.ManagerRoleMapper;
import com.alinesno.infra.base.authority.service.IManagerAccountRoleService;
import com.alinesno.infra.base.authority.service.IManagerApplicationService;
import com.alinesno.infra.base.authority.service.IManagerRoleResourceService;
import com.alinesno.infra.base.authority.service.IManagerRoleService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.common.facade.constants.FieldConstants;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;

import cn.hutool.core.util.StrUtil;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@Service
public class ManagerRoleServiceImpl extends IBaseServiceImpl<ManagerRoleEntity, ManagerRoleMapper> implements IManagerRoleService {

	// 日志记录
	private static final Logger log = LoggerFactory.getLogger(ManagerRoleServiceImpl.class);

	@Autowired
	private IManagerRoleResourceService managerRoleResourceService;

	@Autowired
	private IManagerAccountRoleService managerAccountRoleService;
	@Autowired
	private IManagerApplicationService iManagerApplicationService;

	@Override
	public boolean saveRole(ManagerRoleEntity e, String functionIds) {
		Assert.hasLength(functionIds, "角色功能不为空.");

		// 保存角色
//        int tag = mapper.insert(e); // .save(e) ;
		int tag = saveOrUpdate(e) ? 1 : 0;
		Assert.isTrue(tag == 1, "数据[" + e.toString() + "]保存失败.");

		// 保存角色资源
		managerRoleResourceService.deleteByRoleId(e.getId());

		String[] functionArr = functionIds.split(",");
		List<ManagerRoleResourceEntity> rrList = new ArrayList<ManagerRoleResourceEntity>();
		for (String f : functionArr) {
			ManagerRoleResourceEntity rr = new ManagerRoleResourceEntity();
			rr.setRoleId(e.getId());
			rr.setApplicationId(e.getApplicationId());
			rr.setResourceId(f);
			rrList.add(rr);
		}

//		managerRoleResourceService.saveBatch(rrList); // .saveAll(rrList) ;
		managerRoleResourceService.saveAll(rrList);
		return true;
	}

	@Transactional
	public void deleteRoleByIds(String ids) { 

		// 1. 删除角色的权限
		for (String roleIdStr : ids.split(",")) {
			Long roleId = Long.parseLong(roleIdStr) ; 
			mapper.deleteById(roleId);
			managerRoleResourceService.deleteByRoleId(roleId);
		}
	}
  
	@Transactional
	@Override
	public boolean authAccount(ManagerAccountEntity accountEntity, Long[] roleArr) {

		log.debug("rolesId:{} , accountEntity:{}", roleArr, accountEntity); 
		// 删除用户之前的角色
		managerAccountRoleService.deleteByAccountId(accountEntity.getId());

		// 添加新角色
		List<ManagerAccountRoleEntity> entities = new ArrayList<ManagerAccountRoleEntity>();
		for (Long r : roleArr) {

			ManagerAccountRoleEntity e = new ManagerAccountRoleEntity();
			e.setRoleId(r);
			e.setAccountId(accountEntity.getId());

			entities.add(e);
		}

		Object o = managerAccountRoleService.saveBatch(entities);
		return o == null ? false : true;
	}

	@Override
	public List<ManagerRoleEntity> findByAccountId(Long accountId) {

		List<ManagerAccountRoleEntity> accountRoles = managerAccountRoleService.findAllByAccountId(accountId);
		List<Long> roleIds = new ArrayList<Long>();

		for (ManagerAccountRoleEntity m : accountRoles) {
			roleIds.add(m.getRoleId());
		}

//		return findAllById(roleIds);

		if (roleIds.isEmpty()) {
			return Collections.emptyList();
		}
		return listByIds(roleIds);
	}

	@Override
	public List<AccountRoleDto> findByAccountIds(List<String> accountIds, String applicationCode) {
		if (CollectionUtils.isEmpty(accountIds)) {
			return new ArrayList<>();
		}
		return mapper.findByAccountIds(accountIds, applicationCode);
	}

	@Override
	public List<ManagerRoleEntity> listByIds(Collection<? extends Serializable> idList) {
		if (null == idList || idList.isEmpty()) {
			return Collections.emptyList();
		} else {
			return super.listByIds(idList);
		}
	}

	@Override
	public void authAccount(ManagerAccountEntity accountEntity, String rolesId) {
		String[] roleArr = rolesId.split(",");
		  
		Long[] longArr = new Long[roleArr.length];

		for (int i = 0; i < roleArr.length; i++) {
		    longArr[i] = Long.parseLong(roleArr[i]);
		}
 
		this.authAccount(accountEntity, longArr);
	}

	@Override
	public List<ManagerRoleEntity> findAllByApplicationCode(String applicationCode) {
		List<ManagerRoleEntity> list = new ArrayList<>();
		if (StrUtil.isEmpty(applicationCode)) {
			return list;
		}
		ManagerApplicationEntity application = iManagerApplicationService.findEntityByApplicationCode(applicationCode);
		if (application == null) {
			return list;
		}
		Long id = application.getId(); 
		
		return this.lambdaQuery().eq(ManagerRoleEntity::getApplicationId, id).list();
	}

	@Override
	public void apendAccountRole(Long accountId, Long[] roleId) {
		
		// 添加新角色
		List<ManagerAccountRoleEntity> entities = new ArrayList<ManagerAccountRoleEntity>();
		for (Long r : roleId) {

			ManagerAccountRoleEntity e = new ManagerAccountRoleEntity();
			e.setRoleId(r);
			e.setAccountId(accountId) ; 

			entities.add(e);
		}

		Object o = managerAccountRoleService.saveBatch(entities);
		log.debug("追求用户{}权限{}结果:{}" , accountId , JSONObject.toJSON(roleId), o);
	}

	@Override
	public void updateDefaultNetrole(String applicationId, String fieldId, String value) {
		
		// 1. 把所有的都配置成非默认的
		UpdateWrapper<ManagerRoleEntity> updateAllRoleWrapper = new UpdateWrapper<ManagerRoleEntity>();
		updateAllRoleWrapper.eq(FieldConstants.APPLICATION_ID, applicationId) ; 
		
		updateAllRoleWrapper.set("default_netrole", RolePowerTypeEnmus.ROLE_NOT_NETROLE.value);
		
		this.update(updateAllRoleWrapper);

		// 2. 设置成默认的
		UpdateWrapper<ManagerRoleEntity> updateWrapper = new UpdateWrapper<ManagerRoleEntity>();
		updateWrapper.set("default_netrole", value) ; 
		updateWrapper.eq("id", fieldId);

		this.update(updateWrapper);

	}
}
