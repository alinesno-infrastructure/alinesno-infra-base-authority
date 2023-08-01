package com.alinesno.infra.base.authority.service;

import com.alinesno.infra.base.authority.entity.EnterpriseEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

/**
 * <p>
 * 企业配置
 * </p>
 * 
 * @author yangboot
 * @since 2021-03-01 14:50:53
 */
public interface IEnterpriseService extends IBaseService<EnterpriseEntity> {

	/**
	 * 保存企业用户信息，第1个的为企业管理员，其它的，为企业普通成员
	 * 
	 * @param e
	 */
	void registerEnterprise(EnterpriseEntity e);

	/**
	 * 更新企业信息
	 * 
	 * @param e
	 */
	void modifyEnterprise(EnterpriseEntity e);

}