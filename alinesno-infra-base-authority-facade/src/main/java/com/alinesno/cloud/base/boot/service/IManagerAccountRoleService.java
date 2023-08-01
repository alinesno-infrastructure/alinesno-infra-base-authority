package com.alinesno.cloud.base.boot.service;

import java.util.List;

import com.alinesno.cloud.base.boot.entity.ManagerAccountRoleEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author WeiXiaoJin
 * @since 2019-04-08 08:14:52
 */

public interface IManagerAccountRoleService extends IBaseService<ManagerAccountRoleEntity> {

	List<ManagerAccountRoleEntity> findAllByAccountId(String accountId);

	void AuthorizeUsers(List<String> roleIds, String accountId);

	void deleteByAccountId(String id);

	void authorizeUsers(List<String> roleIds, String accountId, String applicationCode);

}
