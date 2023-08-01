package com.alinesno.infra.base.authority.service;

import com.alinesno.infra.base.authority.entity.UserAccountEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

/**
 * <p>
 * 基础账户表 服务类
 * </p>
 *
 * @author WeiXiaoJin
 * @since 2018-12-16 17:53:19
 */

public interface IUserAccountService extends IBaseService<UserAccountEntity> {

	/**
	 * 注册用户账号
	 * 
	 * @param phone     手机号
	 * @param password  密码
	 * @param phoneCode 电话
	 * @return
	 */
	boolean registUser(String phone, String password, String phoneCode);

}
