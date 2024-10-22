package com.alinesno.infra.base.authority.service;

import com.alinesno.infra.base.authority.annotation.PermissionQuery;
import com.alinesno.infra.base.authority.entity.ManagerProjectEntity;
import com.alinesno.infra.base.authority.gateway.dto.ManagerProjectDto;
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
	 * @param query
	 * @return
	 */
	List<ManagerProjectEntity> latestList(PermissionQuery query);

	/**
	 * 获取到默认的内置基础应用列表
	 * @return
	 */
    String getBaseAuthorityProjectCode();

	/**
	 * 获取到默认的内置基础应用列表
	 * @return
	 */
	ManagerProjectEntity getBaseAuthorityProject();


	/**
	 * 初始化用户应用服务
	 * @param userId
	 */
	void initDefaultProject(long userId , long orgId);


	/**
	 * 获取用户当前应用
	 * @param userId
	 * @return
	 */
	ManagerProjectEntity getApplicationByAccountId(long userId);

	/**
	 * 生成项目信息
	 * @param dto
	 */
    void genProject(ManagerProjectDto dto);
}
