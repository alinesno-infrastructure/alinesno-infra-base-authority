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

	void initDeptAndPost(Long id, OrganizationEntity org, ManagerProjectEntity project);
}
