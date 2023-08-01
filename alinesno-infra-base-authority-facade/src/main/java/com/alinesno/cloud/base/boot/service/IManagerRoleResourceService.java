package com.alinesno.cloud.base.boot.service;

import java.util.List;

import com.alinesno.cloud.base.boot.entity.ManagerRoleResourceEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author WeiXiaoJin
 * @since 2018-12-16 17:53:19
 */

public interface IManagerRoleResourceService extends IBaseService<ManagerRoleResourceEntity> {

	void deleteByRoleId(String roleId);

	int saveAll(List<ManagerRoleResourceEntity> list);

	/**
	 * 为角色授权
	 * 
	 * @param roleId
	 * @param resourceId
	 */
	void authRole(String roleId, List<String> resourceId);
}
