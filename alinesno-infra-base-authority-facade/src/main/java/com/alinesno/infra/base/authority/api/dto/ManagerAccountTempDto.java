package com.alinesno.infra.base.authority.api.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： manager_account_temp
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ManagerAccountTempDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "accountStatus"
	 */
	private String accountStatus;
	/**
	 * "lastLoginIp"
	 */
	private String lastLoginIp;
	/**
	 * "lastLoginTime"
	 */
	private String lastLoginTime;
	/**
	 * "委托人"
	 */
	private String bailor;
	/**
	 * "loginName"
	 */
	private String loginName;
	/**
	 * "name"
	 */
	private String name;
	/**
	 * "owners"
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
	 * "avatorPath"
	 */
	private String avatorPath;
	/**
	 * "enterpriseProperties"
	 */
	private String enterpriseProperties;
	/**
	 * "portalProp"
	 */
	private String portalProp;

	// getter and setter
	public String getAccountStatus()

	{
		return this.accountStatus;
	}

	public ManagerAccountTempDto setAccountStatus(String arg) {
		this.accountStatus = arg;
		return this;
	}

	public String getLastLoginIp()

	{
		return this.lastLoginIp;
	}

	public ManagerAccountTempDto setLastLoginIp(String arg) {
		this.lastLoginIp = arg;
		return this;
	}

	public String getLastLoginTime()

	{
		return this.lastLoginTime;
	}

	public ManagerAccountTempDto setLastLoginTime(String arg) {
		this.lastLoginTime = arg;
		return this;
	}

	public String getBailor()

	{
		return this.bailor;
	}

	public ManagerAccountTempDto setBailor(String arg) {
		this.bailor = arg;
		return this;
	}

	public String getLoginName()

	{
		return this.loginName;
	}

	public ManagerAccountTempDto setLoginName(String arg) {
		this.loginName = arg;
		return this;
	}

	public String getName()

	{
		return this.name;
	}

	public ManagerAccountTempDto setName(String arg) {
		this.name = arg;
		return this;
	}

	public String getOwners()

	{
		return this.owners;
	}

	public ManagerAccountTempDto setOwners(String arg) {
		this.owners = arg;
		return this;
	}

	public String getPassword()

	{
		return this.password;
	}

	public ManagerAccountTempDto setPassword(String arg) {
		this.password = arg;
		return this;
	}

	public String getRoleId()

	{
		return this.roleId;
	}

	public ManagerAccountTempDto setRoleId(String arg) {
		this.roleId = arg;
		return this;
	}

	public String getRolePower()

	{
		return this.rolePower;
	}

	public ManagerAccountTempDto setRolePower(String arg) {
		this.rolePower = arg;
		return this;
	}

	public String getSalt()

	{
		return this.salt;
	}

	public ManagerAccountTempDto setSalt(String arg) {
		this.salt = arg;
		return this;
	}

	public String getUserId()

	{
		return this.userId;
	}

	public ManagerAccountTempDto setUserId(String arg) {
		this.userId = arg;
		return this;
	}

	public String getDepartment()

	{
		return this.department;
	}

	public ManagerAccountTempDto setDepartment(String arg) {
		this.department = arg;
		return this;
	}

	public String getEmail()

	{
		return this.email;
	}

	public ManagerAccountTempDto setEmail(String arg) {
		this.email = arg;
		return this;
	}

	public String getPhone()

	{
		return this.phone;
	}

	public ManagerAccountTempDto setPhone(String arg) {
		this.phone = arg;
		return this;
	}

	public String getSex()

	{
		return this.sex;
	}

	public ManagerAccountTempDto setSex(String arg) {
		this.sex = arg;
		return this;
	}

	public String getHasEditor()

	{
		return this.hasEditor;
	}

	public ManagerAccountTempDto setHasEditor(String arg) {
		this.hasEditor = arg;
		return this;
	}

	public String getAvatorPath()

	{
		return this.avatorPath;
	}

	public ManagerAccountTempDto setAvatorPath(String arg) {
		this.avatorPath = arg;
		return this;
	}

	public String getEnterpriseProperties()

	{
		return this.enterpriseProperties;
	}

	public ManagerAccountTempDto setEnterpriseProperties(String arg) {
		this.enterpriseProperties = arg;
		return this;
	}

	public String getPortalProp()

	{
		return this.portalProp;
	}

	public ManagerAccountTempDto setPortalProp(String arg) {
		this.portalProp = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerAccountTempDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ManagerAccountTempDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerAccountTempDto fromDto(ManagerAccountTempDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ManagerAccountTempDto.class);
	}

}
