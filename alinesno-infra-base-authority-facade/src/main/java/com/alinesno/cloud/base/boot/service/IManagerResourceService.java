package com.alinesno.cloud.base.boot.service;

import java.util.List;

import com.alinesno.cloud.base.boot.entity.ManagerAccountEntity;
import com.alinesno.cloud.base.boot.entity.ManagerResourceEntity;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.services.IBaseService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author WeiXiaoJin
 * @since 2018-12-16 17:53:19
 */

public interface IManagerResourceService extends IBaseService<ManagerResourceEntity> {

	/**
	 * 通过一级目录构建菜单
	 * 
	 * @param resourceParent
	 * @param applicationId
	 * @return
	 */
	ManagerResourceEntity findMenus(String resourceParent, String applicationId);

	/**
	 * 通过一级目录构建菜单
	 * 
	 * @param resourceParent
	 * @param applicationId
	 * @return
	 */
	ManagerResourceEntity findMenus(String resourceParent, String applicationId, String accountId);

	/**
	 * 通过所属应用id删除
	 * 
	 * @param id
	 */
	void deleteByApplicationId(String id);

	/**
	 * 查询所有应用菜单
	 * 
	 * @param resourceParent
	 * @param applicationId
	 * @param id
	 * @return
	 */
	ManagerResourceEntity findMenusByApplicationAndAccount(String resourceParent, String applicationId, String id);

	/**
	 * 查询菜单的操作按钮
	 * 
	 * @param account
	 * @return
	 */
	List<ManagerResourceEntity> findResoucePermission(ManagerAccountEntity account, String pageId);

	/**
	 * 查询菜单雷彪
	 * 
	 * @param page
	 * @return
	 */
	List<ManagerResourceEntity> resourceData(DatatablesPageBean page);
}
