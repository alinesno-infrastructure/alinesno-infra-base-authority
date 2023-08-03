package com.alinesno.infra.base.authority.api.dto;

import java.util.List;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： manager_account
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ManagerAccountDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "账户状态"
	 */
	private String accountStatus;
	/**
	 * "最后登陆IP"
	 */
	private String lastLoginIp;
	/**
	 * "lastLoginTime"
	 */
	private String lastLoginTime;
	/**
	 * "loginName"
	 */
	private String loginName;
	/**
	 * "name"
	 */
	private String name;
	/**
	 * "所属者"
	 */
	private String owners;
	/**
	 * "password"
	 */
	private String password;
	/**
	 * "roleId"
	 */
	private String roleId;
	/**
	 * "rolePower"
	 */
	private String rolePower;
	/**
	 * "salt"
	 */
	private String salt;
	/**
	 * "userId"
	 */
	private String userId;
	/**
	 * "department"
	 */
	private String department;
	/**
	 * "email"
	 */
	private String email;
	/**
	 * "phone"
	 */
	private String phone;
	/**
	 * "sex"
	 */
	private String sex;
	/**
	 * "hasEditor"
	 */
	private String hasEditor;
	/**
	 * "用户头像"
	 */
	private String avatorPath;
	/**
	 * "企业属性"
	 */
	private String enterpriseProperties;
	/**
	 * "portalProp"
	 */
	private String portalProp;
	/**
	 * "岗位id"
	 */
	private String positionId;
	/**
	 * "委托人"
	 */
	private String bailor;
	/**
	 * "cas用户Id"
	 */
	private String casAccountId;

	// 默认授权信息
	private List<String> authRole;

	public List<String> getAuthRole() {
		return authRole;
	}

	public void setAuthRole(List<String> authRole) {
		this.authRole = authRole;
	}

	// getter and setter
	public String getAccountStatus()

	{
		return this.accountStatus;
	}

	public ManagerAccountDto setAccountStatus(String arg) {
		this.accountStatus = arg;
		return this;
	}

	public String getLastLoginIp()

	{
		return this.lastLoginIp;
	}

	public ManagerAccountDto setLastLoginIp(String arg) {
		this.lastLoginIp = arg;
		return this;
	}

	public String getLastLoginTime()

	{
		return this.lastLoginTime;
	}

	public ManagerAccountDto setLastLoginTime(String arg) {
		this.lastLoginTime = arg;
		return this;
	}

	public String getLoginName()

	{
		return this.loginName;
	}

	public ManagerAccountDto setLoginName(String arg) {
		this.loginName = arg;
		return this;
	}

	public String getName()

	{
		return this.name;
	}

	public ManagerAccountDto setName(String arg) {
		this.name = arg;
		return this;
	}

	public String getOwners()

	{
		return this.owners;
	}

	public ManagerAccountDto setOwners(String arg) {
		this.owners = arg;
		return this;
	}

	public String getPassword()

	{
		return this.password;
	}

	public ManagerAccountDto setPassword(String arg) {
		this.password = arg;
		return this;
	}

	public String getRoleId()

	{
		return this.roleId;
	}

	public ManagerAccountDto setRoleId(String arg) {
		this.roleId = arg;
		return this;
	}

	public String getRolePower()

	{
		return this.rolePower;
	}

	public ManagerAccountDto setRolePower(String arg) {
		this.rolePower = arg;
		return this;
	}

	public String getSalt()

	{
		return this.salt;
	}

	public ManagerAccountDto setSalt(String arg) {
		this.salt = arg;
		return this;
	}

	public String getUserId()

	{
		return this.userId;
	}

	public ManagerAccountDto setUserId(String arg) {
		this.userId = arg;
		return this;
	}

	public String getDepartment()

	{
		return this.department;
	}

	public ManagerAccountDto setDepartment(String arg) {
		this.department = arg;
		return this;
	}

	public String getEmail()

	{
		return this.email;
	}

	public ManagerAccountDto setEmail(String arg) {
		this.email = arg;
		return this;
	}

	public String getPhone()

	{
		return this.phone;
	}

	public ManagerAccountDto setPhone(String arg) {
		this.phone = arg;
		return this;
	}

	public String getSex()

	{
		return this.sex;
	}

	public ManagerAccountDto setSex(String arg) {
		this.sex = arg;
		return this;
	}

	public String getHasEditor()

	{
		return this.hasEditor;
	}

	public ManagerAccountDto setHasEditor(String arg) {
		this.hasEditor = arg;
		return this;
	}

	public String getAvatorPath()

	{
		return this.avatorPath;
	}

	public ManagerAccountDto setAvatorPath(String arg) {
		this.avatorPath = arg;
		return this;
	}

	public String getEnterpriseProperties()

	{
		return this.enterpriseProperties;
	}

	public ManagerAccountDto setEnterpriseProperties(String arg) {
		this.enterpriseProperties = arg;
		return this;
	}

	public String getPortalProp()

	{
		return this.portalProp;
	}

	public ManagerAccountDto setPortalProp(String arg) {
		this.portalProp = arg;
		return this;
	}

	public String getPositionId()

	{
		return this.positionId;
	}

	public ManagerAccountDto setPositionId(String arg) {
		this.positionId = arg;
		return this;
	}

	public String getBailor()

	{
		return this.bailor;
	}

	public ManagerAccountDto setBailor(String arg) {
		this.bailor = arg;
		return this;
	}

	public String getCasAccountId()

	{
		return this.casAccountId;
	}

	public ManagerAccountDto setCasAccountId(String arg) {
		this.casAccountId = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerAccountDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ManagerAccountDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerAccountDto fromDto(ManagerAccountDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ManagerAccountDto.class);
	}

}
