package com.alinesno.infra.base.authority.entity;

import java.util.Date;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */

@TableName("manager_user")
public class ManagerUserEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 登陆账户
	 */
	@TableField("user_account")
	private String userAccount;
	/**
	 * 用户密码
	 */
	@TableField("user_password")
	private String userPassword;
	/**
	 * 用户加密字段
	 */
	@TableField("user_salt")
	private String userSalt;
	/**
	 * 添加时间
	 */
	@TableField("user_addtime")
	private Date userAddtime;
	/**
	 * 状态(1正常/0非法)
	 */
	@TableField("user_status")
	private Boolean userStatus;
	/**
	 * 用户角色
	 */
	@TableField("user_role")
	private String userRole;
	/**
	 * 用户类型(1超级管理员/0普通管理员)
	 */
	@TableField("user_type")
	private Boolean userType;
	/**
	 * 用户名称
	 */
	@TableField("user_name")
	private String userName;

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserSalt() {
		return userSalt;
	}

	public void setUserSalt(String userSalt) {
		this.userSalt = userSalt;
	}

	public Date getUserAddtime() {
		return userAddtime;
	}

	public void setUserAddtime(Date userAddtime) {
		this.userAddtime = userAddtime;
	}

	public Boolean isUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Boolean userStatus) {
		this.userStatus = userStatus;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public Boolean isUserType() {
		return userType;
	}

	public void setUserType(Boolean userType) {
		this.userType = userType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Boolean getUserStatus() {
		return userStatus;
	}

	public Boolean getUserType() {
		return userType;
	}

	@Override
	public String toString() {
		return "ManagerUserEntity{" + "userAccount=" + userAccount + ", userPassword=" + userPassword + ", userSalt="
				+ userSalt + ", userAddtime=" + userAddtime + ", userStatus=" + userStatus + ", userRole=" + userRole
				+ ", userType=" + userType + ", userName=" + userName + "}";
	}
}
