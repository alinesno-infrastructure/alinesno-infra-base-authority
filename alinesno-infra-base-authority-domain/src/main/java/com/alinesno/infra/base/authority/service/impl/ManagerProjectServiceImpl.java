package com.alinesno.infra.base.authority.service.impl;

import com.alinesno.infra.base.authority.entity.ManagerAccountEntity;
import com.alinesno.infra.base.authority.entity.ManagerAccountRoleEntity;
import com.alinesno.infra.base.authority.entity.ManagerProjectEntity;
import com.alinesno.infra.base.authority.entity.ManagerRoleEntity;
import com.alinesno.infra.base.authority.enums.MenuEnums;
import com.alinesno.infra.base.authority.mapper.ManagerProjectMapper;
import com.alinesno.infra.base.authority.service.IManagerProjectService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.common.facade.wrapper.RpcWrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.*;

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
public class ManagerProjectServiceImpl extends IBaseServiceImpl<ManagerProjectEntity, ManagerProjectMapper> implements IManagerProjectService {

//	@Autowired
//	private IManagerRoleService managerRoleService;

//	@Autowired
//	private ManagerProjectMapper repository;

//	@Autowired
//	private IManagerResourceService managerResourceService;

//	@Autowired
//	private IManagerAccountRoleService managerAccountRoleService;

//	@Autowired
//	private IManagerAccountService managerAccountService;
 
	@Override
	public List<ManagerProjectEntity> findAllByAccountId(Long accountId) {
		log.debug("accountId:{}", accountId);

		List<ManagerProjectEntity> list = null;
		ManagerAccountEntity account = null ; // TODO  managerAccountService.getById(accountId);

		if (MenuEnums.MENU_PLATFORM.value.equals(account.getRolePower())) {
			list = findAllByFieldProp(MenuEnums.MENU_PLATFORM.value);

		} else {

			List<ManagerAccountRoleEntity> roleEntityList = null ; // TODO managerAccountRoleService.findAllByAccountId(accountId);

			Map<Long, ManagerAccountRoleEntity> applicationMap = new HashMap<Long, ManagerAccountRoleEntity>();
			for (ManagerAccountRoleEntity m : roleEntityList) {
				applicationMap.put(m.getRoleId(), m);
			}

			List<ManagerRoleEntity> roleList = null ; // TODO  managerRoleService.listByIds(applicationMap.keySet());
																										 
			Map<Long, ManagerRoleEntity> roleListMap = new HashMap<Long, ManagerRoleEntity>();
			for (ManagerRoleEntity m : roleList) {
				roleListMap.put(m.getApplicationId(), m);
			}

			list = listByIds(roleListMap.keySet()); 
		}

		return list; 
	}
 
	@Override
	public ManagerProjectEntity findEntityByApplicationCode(String applicationCode) {
		Assert.hasLength(applicationCode, "应用代码不能为空.");
		RpcWrapper<ManagerProjectEntity> wrapper = RpcWrapper.build();
		wrapper.eq("application_code", applicationCode);
		List<ManagerProjectEntity> all = this.findAll(wrapper);
		return !all.isEmpty() ? all.get(0) : null;
	}

	@Override
	public ManagerProjectEntity insert(ManagerProjectEntity e) {
		save(e);
		return e;
	}

	@Override
	public List<ManagerProjectEntity> latestList(long userId) {

		LambdaQueryWrapper<ManagerProjectEntity> wrapper = new LambdaQueryWrapper<>() ;
//		wrapper.eq(ManagerProjectEntity::getOperatorId , userId) ;
		wrapper.orderByDesc(ManagerProjectEntity::getAddTime) ;

		return list(wrapper) ;
	}

	@Override
	public int deleteByApplicationId(String ids) {
		Assert.hasLength(ids, "主键不能为空");

		String rowsIds[] = ids.split(",");
		// 删除菜单
		for (String id : rowsIds) {
			mapper.deleteById(id);

//			TODO
//			managerResourceService.deleteByApplicationId(id);
		}
		return 0;
	}

	@Override
	public List<ManagerProjectEntity> listByIds(Collection<? extends Serializable> idList) {
		if (null == idList || idList.isEmpty()) {
			return Collections.emptyList();
		} else {
			return super.listByIds(idList);
		}
	}
}
