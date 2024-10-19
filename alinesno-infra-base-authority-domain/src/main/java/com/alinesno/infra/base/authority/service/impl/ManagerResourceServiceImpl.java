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
import org.springframework.context.annotation.Lazy;
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

	private final IManagerProjectService managerProjectService ;

	public ManagerResourceServiceImpl(@Lazy IManagerProjectService managerProjectService) {
		this.managerProjectService = managerProjectService;
	}

	@Override
	public void initApplicationMenu(Long projectId) {
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

		// 查询出用户所有数据权限项目
		LambdaQueryWrapper<ManagerProjectEntity> projectionWrapper =  new LambdaQueryWrapper<>() ;
		List<ManagerProjectEntity> projects = managerProjectService.list(projectionWrapper) ;

		List<Long> projectIds = projects.stream().map(ManagerProjectEntity::getId).toList() ;

		LambdaQueryWrapper<ManagerResourceEntity> wrapper = new LambdaQueryWrapper<>() ;
		wrapper.in(ManagerResourceEntity::getProjectId , projectIds) ;

		menuList = list(wrapper) ;

		// 将三个项目放到主菜单当中
		for(ManagerProjectEntity p : projects){
			ManagerResourceEntity menu = new ManagerResourceEntity() ;

			menu.setId(p.getId()) ;
			menu.setResourceName(p.getProjectName()) ;
			menu.setComponent(p.getProjectIcons()) ;
			menu.setResourceLink(p.getProjectLink()) ;
			menu.setMenuType(MenuEnums.MENU_PLATFORM.getValue()) ;
			menu.setVisible(true) ;
			menu.setResourceOrder(0) ;
			menu.setResourceParent(0L) ;
			menu.setHasStatus(HasStatusEnums.LEGAL.value) ;

			menuList.add(menu) ;
		}

		return menuList ;
	}

	@Override
	public List<TreeSelect> buildMenuTreeSelect(List<ManagerResourceEntity> menus) {
		// 构建树形菜单
        return TreeSelect.buildTree(menus);
	}

	@Override
	public ManagerResourceDto findMenusByProjectCode(String projectCode, long accountId) {

		ManagerAccountEntity account = accountService.findById(accountId);

		if(account == null){
			return null ;
		}

		ManagerProjectEntity project = SpringContext.getBean(IManagerProjectService.class).findByProjectCode(projectCode);

		// 临时开发验证
		account.setRolePower(RolePowerTypeEnmus.ROLE_ADMIN.getValue());

		// 1. 查询用户信息，判断用户是否为超级管理员
		if(RolePowerTypeEnmus.ROLE_ADMIN.getValue().equals(account.getRolePower())){

			LambdaQueryWrapper<ManagerResourceEntity> queryWrapper = new LambdaQueryWrapper<>() ;
			queryWrapper.eq(ManagerResourceEntity::getProjectId , project.getId())
					.eq(ManagerResourceEntity::getHasStatus, HasStatusEnums.LEGAL.value);

			List<ManagerResourceEntity> resources = list(queryWrapper) ;

			// 构建父类节点
			ManagerResourceEntity root = new ManagerResourceEntity() ;
			root.setId(project.getId());
			root.setResourceName(project.getProjectName());

			return ManagerResourceUtils.treeResource(resources , root) ;
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
