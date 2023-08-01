package com.alinesno.cloud.base.boot.service;

import java.util.List;

import com.alinesno.cloud.base.boot.entity.ManagerApplicationEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author WeiXiaoJin
 * @since 2018-12-16 17:53:19
 */

public interface IManagerApplicationService extends IBaseService<ManagerApplicationEntity> {

	/**
	 * 查询用户应用
	 * 
	 * @param accountId
	 * @return
	 */
	List<ManagerApplicationEntity> findAllByAccountId(String accountId);

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
