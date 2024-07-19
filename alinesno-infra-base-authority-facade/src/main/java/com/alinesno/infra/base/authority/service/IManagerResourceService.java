package com.alinesno.infra.base.authority.service;

import com.alinesno.infra.base.authority.api.dto.TreeSelect;
import com.alinesno.infra.base.authority.entity.ManagerResourceEntity;
import com.alinesno.infra.base.authority.gateway.dto.ManagerResourceDto;
import com.alinesno.infra.common.facade.services.IBaseService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */

public interface IManagerResourceService extends IBaseService<ManagerResourceEntity> {

	/**
	 * 初始化应用菜单
	 * @param platformId
	 */
	void initApplicationMenu(Long platformId);

	/**
	 * 查询应用所有菜单
	 * @param projectId
	 * @return
	 */
	List<ManagerResourceEntity> findAllByProject(Long projectId);

	/**
	 * 查询菜单列表
	 *
	 * @param userId
	 * @param projectId
	 * @return
	 */
	List<ManagerResourceEntity> selectMenuList(long userId, long projectId);

	/**
	 * 构建树形菜单
	 * @param menus
	 * @return
	 */
	List<TreeSelect> buildMenuTreeSelect(List<ManagerResourceEntity> menus);

	/**
	 * 通过项目编码查询菜单
	 * @param projectCode
	 * @param accountId
	 * @return
	 */
	ManagerResourceDto findMenusByProjectCode(String projectCode, long accountId);

	/**
	 * 通过角色id查询菜单
	 * @param roleId
	 * @return
	 */
	List<Long> selectMenuListByRoleId(Long roleId);

}
