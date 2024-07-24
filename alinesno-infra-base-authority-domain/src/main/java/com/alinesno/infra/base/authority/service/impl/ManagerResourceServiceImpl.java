package com.alinesno.infra.base.authority.service.impl;

import com.alinesno.infra.base.authority.api.dto.TreeSelect;
import com.alinesno.infra.base.authority.entity.ManagerAccountEntity;
import com.alinesno.infra.base.authority.entity.ManagerProjectEntity;
import com.alinesno.infra.base.authority.entity.ManagerResourceEntity;
import com.alinesno.infra.base.authority.entity.ManagerRoleEntity;
import com.alinesno.infra.base.authority.enums.MenuEnums;
import com.alinesno.infra.base.authority.enums.RolePowerTypeEnmus;
import com.alinesno.infra.base.authority.gateway.dto.ManagerResourceDto;
import com.alinesno.infra.base.authority.mapper.ManagerResourceMapper;
import com.alinesno.infra.base.authority.mapper.ManagerRoleMapper;
import com.alinesno.infra.base.authority.service.IManagerAccountService;
import com.alinesno.infra.base.authority.service.IManagerProjectService;
import com.alinesno.infra.base.authority.service.IManagerResourceService;
import com.alinesno.infra.base.authority.service.IManagerRoleService;
import com.alinesno.infra.base.authority.utils.ManagerResourceUtils;
import com.alinesno.infra.common.core.context.SpringContext;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.common.facade.enums.HasStatusEnums;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
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
public class ManagerResourceServiceImpl extends IBaseServiceImpl<ManagerResourceEntity, ManagerResourceMapper> implements IManagerResourceService {

	@Autowired
	private IManagerRoleService managerRoleService ;

	@Autowired
	private IManagerAccountService accountService;

	@Autowired
	private ManagerRoleMapper roleMapper ;

	@Override
	public void initApplicationMenu(Long projectId) {
//		LambdaQueryWrapper<ManagerResourceEntity> wrapper = new LambdaQueryWrapper<>() ;
//
//		wrapper.eq(ManagerResourceEntity::getMenuType , MenuEnums.MENU_PLATFORM.value)
//				.eq(ManagerResourceEntity::getProjectId , projectId);
//
//		long count = count(wrapper) ;
//		if(count > 0){
//			return ;
//		}
//
//		ManagerProjectEntity project = SpringContext.getBean(IManagerProjectService.class).getById(projectId) ;
//
//		ManagerResourceEntity platformMenu = new ManagerResourceEntity() ;
//
//		platformMenu.setMenuType(MenuEnums.MENU_PLATFORM.value);
//		platformMenu.setResourceName(project.getProjectName());
//		platformMenu.setProjectId(projectId);
//		platformMenu.setResourceIcon("icon");
//
//		save(platformMenu) ;
	}

	@Override
	public List<ManagerResourceEntity> findAllByProject(Long projectId) {
		LambdaQueryWrapper<ManagerResourceEntity> wrapper = new LambdaQueryWrapper<>() ;
		wrapper.eq(ManagerResourceEntity::getProjectId , projectId) ;

		return list(wrapper) ;
	}

	@Override
	public List<ManagerResourceEntity> selectMenuList(long userId, long projectId) {
		List<ManagerResourceEntity> menuList = null;

		LambdaQueryWrapper<ManagerResourceEntity> wrapper = new LambdaQueryWrapper<>() ;
		wrapper.eq(ManagerResourceEntity::getProjectId , projectId) ;

		menuList = list(wrapper) ;

		return menuList ;
	}

	@Override
	public List<TreeSelect> buildMenuTreeSelect(List<ManagerResourceEntity> menus) {

//		List<ManagerResourceEntity> menuTrees = buildMenuTree(menus);
//		return menuTrees.stream().map(TreeSelect::new).collect(Collectors.toList());

		return null ;
	}

	@Override
	public ManagerResourceDto findMenusByProjectCode(String projectCode, long accountId) {

		ManagerAccountEntity account = accountService.findById(accountId);
		ManagerProjectEntity project = SpringContext.getBean(IManagerProjectService.class).findByProjectCode(projectCode);

		// 临时开发验证
		account.setRolePower(RolePowerTypeEnmus.ROLE_ADMIN.getValue());

		// 1. 查询用户信息，判断用户是否为超级管理员
		if(RolePowerTypeEnmus.ROLE_ADMIN.getValue().equals(account.getRolePower())){

			LambdaQueryWrapper<ManagerResourceEntity> queryWrapper = new LambdaQueryWrapper<>() ;
			queryWrapper.eq(ManagerResourceEntity::getProjectId , project.getId())
					.eq(ManagerResourceEntity::getHasStatus, HasStatusEnums.LEGAL.value);

			List<ManagerResourceEntity> resources = list(queryWrapper) ;

			return ManagerResourceUtils.treeResource(resources) ;
		}else{
			// 2. TODO 获取用户的角色信息，根据角色获取到角色的菜单列表
			return null ;
		}

	}

	@Override
	public List<Long> selectMenuListByRoleId(Long roleId) {

		ManagerRoleEntity role = roleMapper.selectById(roleId) ;

//		SysRole role = roleMapper.selectRoleById(roleId);
//		return menuMapper.selectMenuListByRoleId(roleId, role.isMenuCheckStrictly());

		return new ArrayList<>();

	}

}
