package com.alinesno.infra.base.authority.service;

import java.util.List;

import com.alinesno.infra.base.authority.entity.ManagerAccountRoleEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */

public interface IManagerAccountRoleService extends IBaseService<ManagerAccountRoleEntity> {

	List<ManagerAccountRoleEntity> findAllByAccountId(Long accountId);

	void AuthorizeUsers(List<Long> roleIds, Long accountId);

	void deleteByAccountId(Long id);

	void authorizeUsers(List<Long> roleIds, Long accountId, String applicationCode);

}
