package com.alinesno.infra.base.authority.service.impl;

import com.alinesno.infra.base.authority.api.dto.TreeSelect;
import com.alinesno.infra.base.authority.entity.ManagerAccountEntity;
import com.alinesno.infra.base.authority.entity.ManagerProjectEntity;
import com.alinesno.infra.base.authority.entity.ManagerResourceEntity;
import com.alinesno.infra.base.authority.entity.ManagerRoleEntity;
import com.alinesno.infra.base.authority.enums.MenuEnums;
import com.alinesno.infra.base.authority.enums.RolePowerTypeEnmus;
import com.alinesno.infra.base.authority.mapper.ManagerResourceMapper;
import com.alinesno.infra.base.authority.service.IManagerProjectService;
import com.alinesno.infra.base.authority.service.IManagerResourceService;
import com.alinesno.infra.base.authority.service.IManagerRoleService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.common.facade.constants.FieldConstants;
import com.alinesno.infra.common.facade.enums.HasDeleteEnums;
import com.alinesno.infra.common.facade.enums.HasStatusEnums;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.wrapper.RpcWrapper;
import com.alinesno.infra.common.facade.wrapper.mybatis.WrapperGenerator;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

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
	private IManagerProjectService applicationService ;

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
			if(netroleList != null && !netroleList.isEmpty()) {
				ManagerRoleEntity netRole = netroleList.get(0) ;  // 默认取0
				managerRoleService.appendAccountRole(accountId, new Long[] {netRole.getId()}) ;
				
				// 重新查询返回菜单
				e = this.findMenus(resourceParent, applicationId, accountId);
			}
			
		}

		return e;
	}

	@Override
	public List<ManagerResourceEntity> findResourcePermission(ManagerAccountEntity account, Long pageId) {
 
		QueryWrapper<ManagerResourceEntity> w = WrapperGenerator.build();
		w.eq("resource_parent", pageId);

        return list(w);
	}

	@Override
	public List<ManagerResourceEntity> resourceData(DatatablesPageBean page) {
		RpcWrapper<ManagerResourceEntity> wrapper = RpcWrapper.build();

//		if (page != null) {
//			wrapper = page.buildWrapper();
//		}
//
//		// 删除框架自带的排序条件
//		List<Condition> condition = wrapper.getCondition();
//		if (condition != null && !condition.isEmpty()) {
//			condition = condition.stream().filter(item -> (!item.getCondition().equals(Wrapper.ORDER_BY)))
//					.collect(Collectors.toList());
//			wrapper.setCondition(condition);
//		}

		// 条件查询
		QueryWrapper<ManagerResourceEntity> queryWrapper = wrapper.toQueryWrapper();
		queryWrapper.eq("has_status", HasStatusEnums.LEGAL.value);
		queryWrapper.eq("has_delete", HasDeleteEnums.LEGAL.value);

		queryWrapper.orderByAsc("resource_parent");
		queryWrapper.orderByDesc("resource_order");
		queryWrapper.orderByDesc("add_time");
		return mapper.selectList(queryWrapper);

	}

	/**
	 * 根据用户查询系统菜单列表
	 *
	 * @param userId    用户ID
	 * @param projectId
	 * @return 菜单列表
	 */
	@Override
	public List<ManagerResourceEntity> selectMenuList(ManagerResourceEntity menu, long userId, long projectId) {
		List<ManagerResourceEntity> menuList = null;

		// 管理员显示所有菜单信息
//		if (SysUser.isAdmin(userId)) {
//			menuList = menuMapper.selectMenuList(menu);
//		} else {
//			menu.getParams().put("userId", userId);
//			menuList = menuMapper.selectMenuListByUserId(menu);
//		}
//		return menuList;

		LambdaQueryWrapper<ManagerResourceEntity> wrapper = new LambdaQueryWrapper<>() ;
		wrapper.eq(ManagerResourceEntity::getProjectId , projectId) ;

		menuList = list(wrapper) ;

		return menuList ;
	}


	@Override
	public List<TreeSelect> buildMenuTreeSelect(List<ManagerResourceEntity> menus) {
		List<ManagerResourceEntity> menuTrees = buildMenuTree(menus);
		return menuTrees.stream().map(TreeSelect::new).collect(Collectors.toList());
	}

	@Override
	public void initApplicationMenu(Long projectId) {

		LambdaQueryWrapper<ManagerResourceEntity> wrapper = new LambdaQueryWrapper<>() ;

		wrapper.eq(ManagerResourceEntity::getMenuType , MenuEnums.MENU_PLATFORM.value)
			   .eq(ManagerResourceEntity::getProjectId , projectId);

		long count = count(wrapper) ;
		if(count > 0){
			return ;
		}

		ManagerProjectEntity project = applicationService.getById(projectId) ;

		ManagerResourceEntity platformMenu = new ManagerResourceEntity() ;

		platformMenu.setMenuType(MenuEnums.MENU_PLATFORM.value);
		platformMenu.setResourceName(project.getProjectName());
		platformMenu.setProjectId(projectId);
		platformMenu.setResourceIcon("icon");

		save(platformMenu) ;
	}

	/**
	 * 查询所有项目菜单
	 * @param projectId
	 * @return
	 */
	@Override
	public List<ManagerResourceEntity> findAllByProject(Long projectId) {

		LambdaQueryWrapper<ManagerResourceEntity> wrapper = new LambdaQueryWrapper<>() ;
		wrapper.eq(ManagerResourceEntity::getProjectId , projectId) ;

		return list(wrapper) ;
	}

	/**
	 * 构建前端所需要树结构
	 *
	 * @param menus 菜单列表
	 * @return 树结构列表
	 */
	public List<ManagerResourceEntity> buildMenuTree(List<ManagerResourceEntity> menus)
	{
		List<ManagerResourceEntity> returnList = new ArrayList<>();
		List<Long> tempList = menus.stream().map(ManagerResourceEntity::getId).collect(Collectors.toList());
		for (Iterator<ManagerResourceEntity> iterator = menus.iterator(); iterator.hasNext();) {
			ManagerResourceEntity menu = (ManagerResourceEntity) iterator.next();
			// 如果是顶级节点, 遍历该父节点的所有子节点
			if (!tempList.contains(menu.getResourceParent())) {
				recursionFn(menus, menu);
				returnList.add(menu);
			}
		}
		if (returnList.isEmpty())
		{
			returnList = menus;
		}
		return returnList;
	}

	/**
	 * 递归列表
	 *
	 * @param list 分类表
	 * @param t 子节点
	 */
	private void recursionFn(List<ManagerResourceEntity> list, ManagerResourceEntity t) {
		// 得到子节点列表
		List<ManagerResourceEntity> childList = getChildList(list, t);
		t.setSubResource(childList);
		for (ManagerResourceEntity tChild : childList) {
			if (hasChild(list, tChild)) {
				recursionFn(list, tChild);
			}
		}
	}

	/**
	 * 得到子节点列表
	 */
	private List<ManagerResourceEntity> getChildList(List<ManagerResourceEntity> list, ManagerResourceEntity t) {
		List<ManagerResourceEntity> tlist = new ArrayList<ManagerResourceEntity>();
		Iterator<ManagerResourceEntity> it = list.iterator();
		while (it.hasNext()) {
			ManagerResourceEntity n = (ManagerResourceEntity) it.next();
			if (n.getResourceParent().longValue() == t.getId().longValue()) {
				tlist.add(n);
			}
		}
		return tlist;
	}

	/**
	 * 判断是否有子节点
	 */
	private boolean hasChild(List<ManagerResourceEntity> list, ManagerResourceEntity t) {
		return !getChildList(list, t).isEmpty();
	}

}
