package com.alinesno.infra.base.authority.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.alinesno.infra.base.authority.entity.ManagerAccountEntity;
import com.alinesno.infra.base.authority.entity.ManagerAccountRoleEntity;
import com.alinesno.infra.base.authority.entity.ManagerApplicationEntity;
import com.alinesno.infra.base.authority.entity.ManagerRoleEntity;
import com.alinesno.infra.base.authority.enums.MenuEnums;
import com.alinesno.infra.base.authority.mapper.ManagerApplicationMapper;
import com.alinesno.infra.base.authority.service.IManagerAccountRoleService;
import com.alinesno.infra.base.authority.service.IManagerAccountService;
import com.alinesno.infra.base.authority.service.IManagerApplicationService;
import com.alinesno.infra.base.authority.service.IManagerResourceService;
import com.alinesno.infra.base.authority.service.IManagerRoleService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.common.facade.wrapper.RpcWrapper;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@Service
public class ManagerApplicationServiceImpl extends IBaseServiceImpl<ManagerApplicationEntity, ManagerApplicationMapper> implements IManagerApplicationService {

	// 日志记录
	private static final Logger log = LoggerFactory.getLogger(ManagerApplicationServiceImpl.class);

	@Autowired
	private IManagerRoleService managerRoleService;

	@Autowired
	private ManagerApplicationMapper repository;

	@Autowired
	private IManagerResourceService managerResourceService;

	@Autowired
	private IManagerAccountRoleService managerAccountRoleService;

	@Autowired
	private IManagerAccountService managerAccountService;
 
	@Override
	public List<ManagerApplicationEntity> findAllByAccountId(Long accountId) {
		log.debug("accountId:{}", accountId);

		List<ManagerApplicationEntity> list = null;
		ManagerAccountEntity account = managerAccountService.getById(accountId);

		if (MenuEnums.MENU_PLATFORM.value.equals(account.getRolePower())) {
			list = findAllByFieldProp(MenuEnums.MENU_PLATFORM.value);

		} else {

			List<ManagerAccountRoleEntity> roleEntityList = managerAccountRoleService.findAllByAccountId(accountId);

			Map<Long, ManagerAccountRoleEntity> applicationMap = new HashMap<Long, ManagerAccountRoleEntity>();
			for (ManagerAccountRoleEntity m : roleEntityList) {
				applicationMap.put(m.getRoleId(), m);
			}

			List<ManagerRoleEntity> roleList = managerRoleService.listByIds(applicationMap.keySet());  
																										 
			Map<Long, ManagerRoleEntity> roleListMap = new HashMap<Long, ManagerRoleEntity>();
			for (ManagerRoleEntity m : roleList) {
				roleListMap.put(m.getApplicationId(), m);
			}

			list = listByIds(roleListMap.keySet()); 
		}

		return list; 
	}
 
	@Override
	public ManagerApplicationEntity findEntityByApplicationCode(String applicationCode) {
		Assert.hasLength(applicationCode, "应用代码不能为空.");
		RpcWrapper<ManagerApplicationEntity> wrapper = RpcWrapper.build();
		wrapper.eq("application_code", applicationCode);
		List<ManagerApplicationEntity> all = this.findAll(wrapper);
		return !all.isEmpty() ? all.get(0) : null;
	}

	@Override
	public ManagerApplicationEntity insert(ManagerApplicationEntity e) {
		repository.insert(e);
		return e;
	}

	@Override
	public int deleteByApplicationId(String ids) {
		Assert.hasLength(ids, "主键不能为空");

		String rowsIds[] = ids.split(",");
		// 删除菜单
		for (String id : rowsIds) {
			mapper.deleteById(id);
			managerResourceService.deleteByApplicationId(id);
		}
		return 0;
	}

	@Override
	public List<ManagerApplicationEntity> listByIds(Collection<? extends Serializable> idList) {
		if (null == idList || idList.isEmpty()) {
			return Collections.emptyList();
		} else {
			return super.listByIds(idList);
		}
	}
}
