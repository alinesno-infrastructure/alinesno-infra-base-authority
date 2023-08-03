package com.alinesno.infra.base.authority.service;

import java.util.List;

import com.alinesno.infra.base.authority.entity.ManagerApplicationEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */

public interface IManagerApplicationService extends IBaseService<ManagerApplicationEntity> {

	/**
	 * 查询用户应用
	 * 
	 * @param accountId
	 * @return
	 */
	List<ManagerApplicationEntity> findAllByAccountId(Long accountId);

	/**
	 * 删除应用同步删除菜单资源
	 * 
	 * @param ids
	 * @return
	 */
	int deleteByApplicationId(String ids);

	/**
	 * 通过应用代码查询应用
	 * 
	 * @param applicationCode
	 * @return
	 */
	ManagerApplicationEntity findEntityByApplicationCode(String applicationCode);

	ManagerApplicationEntity insert(ManagerApplicationEntity e);
}
