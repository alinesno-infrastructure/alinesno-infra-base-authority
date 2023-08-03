package com.alinesno.infra.base.authority.entity;

import java.util.Set;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * <p>
 *
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@SuppressWarnings("serial")
@TableName("manager_account")
public class ManagerAccountEntity extends InfraBaseEntity {

	/**
	 * 所属者
	 */
	@TableField
	private String owners;
	/**
	 * 账户状态
	 */
	@TableField("account_status")
	private String accountStatus;

	/**
	 * 用户头像
	 */
	@Excel(name = "用户头像")
	@TableField("avator_path")
	private String avatorPath;

	/**
	 * 最后登陆ip
	 */
	@Excel(name = "最后登陆IP")
	@TableField("last_login_ip")
	private String lastLoginIp;
	/**
	 * 最后登陆时间
	 */
	@Excel(name = "最后登陆时间")
	@TableField("last_login_time")
	private String lastLoginTime;
	/**
	 * 登陆名称
	 */
	@Excel(name = "登陆名")
	@TableField("login_name")
	private String loginName;
	/**
	 * 登陆密码
	 */
	@TableField("password")
	private String password;

	/**
	 * 加密字符
	 */
	@TableField("salt")
	private String salt;
	/**
	 * 用户信息id
	 */
	@TableField("user_id")
	private String userId;
	/**
	 * 所属角色
	 */
	@Excel(name = "角色ID")
	@TableField("role_id")
	private String roleId;

	/**
	 * 用户名称.
	 */
	@Excel(name = "用户名称")
	@TableField
	private String name;
	/**
	 * 用户权限(9超级管理员/1租户权限/0用户权限)
	 */
	@Excel(name = "用户权限", replace = { "超级管理员_9", "租户权限_1", "用户权限_0" })
	@TableField("role_power")
	private String rolePower;

	/**
	 * 用户手机号
	 */
	@Excel(name = "手机号")
	@TableField("phone")
	private String phone;

	/**
	 * 用户邮箱
	 */
	@Excel(name = "邮箱")
	@TableField("email")
	private String email;

	/**
	 * 是否包含编辑权限
	 */
	@TableField("has_editor")
	private String hasEditor;

	/**
	 * 性别
	 */
	@Excel(name = "性别", replace = { "男_1", "女_0" })
	@TableField("sex")
	private String sex;
	@TableField("cas_account_id")
	private String casAccountId;
	/**
	 * 所属部门
	 */
	@TableField("department")
	private String department;

	/**
	 * 企业属性(1=企业用户|0普通用户)
	 */
	@Excel(name = "企业属性", replace = { "企业用户_1", "普通用户_0" })
	@TableField("enterprise_properties")
	private String enterpriseProperties = "0";
	/**
	 * 委托人
	 */
	@Excel(name = "委托人")
	@TableField("bailor")
	private String bailor;

	/**
	 * 所属岗位
	 */
	@TableField("position_id")
	private String positionId;

	/**
	 * 首页属性(用于设置默认首页)，用于放置选择应用
	 */
	@TableField("portal_prop")
	private String portalProp;

	@TableField(exist = false)
	private Set<String> role;

	@TableField(exist = false)
	private Set<String> permission;

	public String getPortalProp() {
		return portalProp;
	}

	public void setPortalProp(String portalProp) {
		this.portalProp = portalProp;
	}

	public String getAvatorPath() {
		return avatorPath;
	}

	public void setAvatorPath(String avatorPath) {
		this.avatorPath = avatorPath;
	}

	public String getEnterpriseProperties() {
		return enterpriseProperties;
	}

	public void setEnterpriseProperties(String enterpriseProperties) {
		this.enterpriseProperties = enterpriseProperties;
	}

	public String getHasEditor() {
		return hasEditor;
	}

	public void setHasEditor(String hasEditor) {
		this.hasEditor = hasEditor;
	}

	public Set<String> getRole() {
		return role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}

	public Set<String> getPermission() {
		return permission;
	}

	public void setPermission(Set<String> permission) {
		this.permission = permission;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getOwners() {
		return owners;
	}

	public void setOwners(String owners) {
		this.owners = owners;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRolePower() {
		return rolePower;
	}

	public void setRolePower(String rolePower) {
		this.rolePower = rolePower;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBailor() {
		return bailor;
	}

	public void setBailor(String bailor) {
		this.bailor = bailor;
	}

	public String getPositionId() {
		return positionId;
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	public String getCasAccountId() {
		return casAccountId;
	}

	public void setCasAccountId(String casAccountId) {
		this.casAccountId = casAccountId;
	}

	@Override
	public String toString() {
		return "ManagerAccountEntity{" + "owners='" + owners + '\'' + ", accountStatus='" + accountStatus + '\''
				+ ", avatorPath='" + avatorPath + '\'' + ", lastLoginIp='" + lastLoginIp + '\'' + ", lastLoginTime='"
				+ lastLoginTime + '\'' + ", loginName='" + loginName + '\'' + ", password='" + password + '\''
				+ ", salt='" + salt + '\'' + ", userId='" + userId + '\'' + ", roleId='" + roleId + '\'' + ", name='"
				+ name + '\'' + ", rolePower='" + rolePower + '\'' + ", phone='" + phone + '\'' + ", email='" + email
				+ '\'' + ", hasEditor='" + hasEditor + '\'' + ", sex='" + sex + '\'' + ", casAccountId='" + casAccountId
				+ '\'' + ", department='" + department + '\'' + ", enterpriseProperties='" + enterpriseProperties + '\''
				+ ", bailor='" + bailor + '\'' + ", positionId='" + positionId + '\'' + ", portalProp='" + portalProp
				+ '\'' + ", role=" + role + ", permission=" + permission + '}';
	}
}
