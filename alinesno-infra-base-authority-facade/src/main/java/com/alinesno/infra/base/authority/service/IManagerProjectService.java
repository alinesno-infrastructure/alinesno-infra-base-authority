package com.alinesno.infra.base.authority.service;

import com.alinesno.infra.base.authority.entity.ManagerProjectEntity;
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

public interface IManagerProjectService extends IBaseService<ManagerProjectEntity> {

	/**
	 * 查询用户应用
	 * 
	 * @param accountId
	 * @return
	 */
	List<ManagerProjectEntity> findAllByAccountId(Long accountId);

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
	ManagerProjectEntity findByProjectCode(String applicationCode);

	/**
	 * 插入应用列表
	 * @param e
	 * @return
	 */
	ManagerProjectEntity insert(ManagerProjectEntity e);

	/**
	 * 获取最新的应用列表
	 * @param userId
	 * @return
	 */
	List<ManagerProjectEntity> latestList(long userId);

}
