package com.alinesno.infra.base.authority.service;

import com.alinesno.infra.base.authority.entity.ManagerApplicationEntity;
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

	/**
	 * 插入应用列表
	 * @param e
	 * @return
	 */
	ManagerApplicationEntity insert(ManagerApplicationEntity e);

	/**
	 * 获取最新的应用列表
	 * @param userId
	 * @return
	 */
	List<ManagerApplicationEntity> latestList(long userId);

}
