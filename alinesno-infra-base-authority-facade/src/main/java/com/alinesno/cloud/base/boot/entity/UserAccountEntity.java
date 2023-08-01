package com.alinesno.cloud.base.boot.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 基础账户表
 * </p>
 *
 * @author WeiXiaoJin
 * @since 2018-12-16 17:53:19
 */

@TableName("user_account")
public class UserAccountEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 登陆账户
	 */
	@TableField("login_account")
	private String loginAccount;
	/**
	 * 登陆密码
	 */
	@TableField("login_password")
	private String loginPassword;
	/**
	 * 账户状态(1正常/0禁止)
	 */
	@TableField("account_status")
	private Integer accountStatus;

	/**
	 * 手机验证码
	 */
	@TableField("phone_code")
	private String phoneCode;

	/**
	 * 保密盐
	 */
	@TableField("salt")
	private String salt;

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getPhoneCode() {
		return phoneCode;
	}

	public void setPhoneCode(String phoneCode) {
		this.phoneCode = phoneCode;
	}

	public String getLoginAccount() {
		return loginAccount;
	}

	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public Integer getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(Integer accountStatus) {
		this.accountStatus = accountStatus;
	}

	@Override
	public String toString() {
		return "UserAccountEntity{" + "loginAccount=" + loginAccount + ", loginPassword=" + loginPassword
				+ ", accountStatus=" + accountStatus + "}";
	}
}
