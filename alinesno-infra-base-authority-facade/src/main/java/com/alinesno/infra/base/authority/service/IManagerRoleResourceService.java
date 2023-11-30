package com.alinesno.infra.base.authority.service;

import com.alinesno.infra.base.authority.entity.ManagerRoleResourceEntity;
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

public interface IManagerRoleResourceService extends IBaseService<ManagerRoleResourceEntity> {

	void deleteByRoleId(Long roleId);

	int saveAll(List<ManagerRoleResourceEntity> list);

	/**
	 * 为角色授权
	 * 
	 * @param roleId
	 * @param resourceId
	 */
	void authRole(Long roleId, List<String> resourceId);
}
