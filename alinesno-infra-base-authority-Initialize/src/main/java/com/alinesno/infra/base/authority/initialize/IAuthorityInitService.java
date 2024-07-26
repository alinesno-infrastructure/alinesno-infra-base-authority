package com.alinesno.infra.base.authority.initialize;

import com.alinesno.infra.base.authority.entity.ManagerAccountEntity;
import com.alinesno.infra.base.authority.entity.ManagerProjectEntity;
import com.alinesno.infra.base.authority.entity.OrganizationEntity;

/**
 * 初始化应用程序
 * 
 * @author luoxiaodong
 * @since 2022年3月15日 下午10:23:43
 */
public interface IAuthorityInitService {

	/**
	 * 初始化应用程序，如果初用户没有应用，则添加一些示例
	 *
	 * @param accountId
	 * @return
	 */
	ManagerProjectEntity initData(Long accountId , OrganizationEntity org);

	/**
	 * 初始化超级管理员
	 * @return
	 */
	ManagerAccountEntity initSuperManager(OrganizationEntity org);

	/**
	 * 初始化平台默认组织
	 * @return
	 */
    OrganizationEntity initOrganization();

	/**
	 * 初始化数据字典
	 */
	void initManagerCode(OrganizationEntity org);

	/**
	 * 初始化系统参数
	 */
	void initManagerConfig(OrganizationEntity org);

	/**
	 * 初始化部门和岗位信息。
	 * <p>
	 * 该方法用于根据给定的组织实体，初始化相应的部门和岗位数据。通过传入的ID和组织实体，
	 * 方法将进行相应的业务逻辑处理，以确保部门和岗位数据在系统中的正确性和一致性。
	 *
	 * @param id      部门或岗位的唯一标识符。这个ID用于在组织实体中定位特定的部门或岗位。
	 * @param org     组织实体，包含了部门和岗位的相关信息。这个实体用于方法内部的业务逻辑处理，
	 *                通过解析实体中的数据，来完成部门和岗位的初始化工作。
	 * @param project
	 */
	void initDeptAndPost(Long id, OrganizationEntity org, ManagerProjectEntity project);
}
