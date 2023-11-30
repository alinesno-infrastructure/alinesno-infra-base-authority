package com.alinesno.infra.base.authority.service;

import com.alinesno.infra.base.authority.entity.ManagerAccountRoleEntity;
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

public interface IManagerAccountRoleService extends IBaseService<ManagerAccountRoleEntity> {

	List<ManagerAccountRoleEntity> findAllByAccountId(Long accountId);

	void AuthorizeUsers(List<Long> roleIds, Long accountId);

	void deleteByAccountId(Long id);

	void authorizeUsers(List<Long> roleIds, Long accountId, String applicationCode);

}
