package com.alinesno.infra.base.authority.service;

import java.util.List;

import com.alinesno.infra.base.authority.entity.ManagerAccountEntity;
import com.alinesno.infra.base.authority.entity.ManagerResourceEntity;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.services.IBaseService;

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
	 * 通过一级目录构建菜单
	 * 
	 * @param resourceParent
	 * @param applicationId
	 * @return
	 */
	ManagerResourceEntity findMenus(Long resourceParent, Long applicationId);

	/**
	 * 通过一级目录构建菜单
	 * 
	 * @param resourceParent
	 * @param applicationId
	 * @return
	 */
	ManagerResourceEntity findMenus(Long resourceParent, Long applicationId, Long accountId);

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
	ManagerResourceEntity findMenusByApplicationAndAccount(Long resourceParent, Long applicationId, Long id);

	/**
	 * 查询菜单的操作按钮
	 * 
	 * @param account
	 * @return
	 */
	List<ManagerResourceEntity> findResoucePermission(ManagerAccountEntity account, Long pageId);

	/**
	 * 查询菜单 
	 * 
	 * @param page
	 * @return
	 */
	List<ManagerResourceEntity> resourceData(DatatablesPageBean page);
}
