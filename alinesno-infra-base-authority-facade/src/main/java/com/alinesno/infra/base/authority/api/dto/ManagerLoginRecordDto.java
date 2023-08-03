package com.alinesno.infra.base.authority.api.dto;

import java.util.Date;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： manager_login_record
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ManagerLoginRecordDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "emailCode"
	 */
	private String emailCode;
	/**
	 * "errorPassword"
	 */
	private String errorPassword;
	/**
	 * "loginBrowser"
	 */
	private String loginBrowser;
	/**
	 * "loginIp"
	 */
	private String loginIp;
	/**
	 * "loginName"
	 */
	private String loginName;
	/**
	 * "loginRemark"
	 */
	private String loginRemark;
	/**
	 * "loginSrc"
	 */
	private String loginSrc;
	/**
	 * "loginStatus"
	 */
	private String loginStatus;
	/**
	 * "loginTime"
	 */
	private Date loginTime;
	/**
	 * "phoneCode"
	 */
	private String phoneCode;
	/**
	 * "signOutTime"
	 */
	private Date signOutTime;

	// getter and setter
	public String getEmailCode()

	{
		return this.emailCode;
	}

	public ManagerLoginRecordDto setEmailCode(String arg) {
		this.emailCode = arg;
		return this;
	}

	public String getErrorPassword()

	{
		return this.errorPassword;
	}

	public ManagerLoginRecordDto setErrorPassword(String arg) {
		this.errorPassword = arg;
		return this;
	}

	public String getLoginBrowser()

	{
		return this.loginBrowser;
	}

	public ManagerLoginRecordDto setLoginBrowser(String arg) {
		this.loginBrowser = arg;
		return this;
	}

	public String getLoginIp()

	{
		return this.loginIp;
	}

	public ManagerLoginRecordDto setLoginIp(String arg) {
		this.loginIp = arg;
		return this;
	}

	public String getLoginName()

	{
		return this.loginName;
	}

	public ManagerLoginRecordDto setLoginName(String arg) {
		this.loginName = arg;
		return this;
	}

	public String getLoginRemark()

	{
		return this.loginRemark;
	}

	public ManagerLoginRecordDto setLoginRemark(String arg) {
		this.loginRemark = arg;
		return this;
	}

	public String getLoginSrc()

	{
		return this.loginSrc;
	}

	public ManagerLoginRecordDto setLoginSrc(String arg) {
		this.loginSrc = arg;
		return this;
	}

	public String getLoginStatus()

	{
		return this.loginStatus;
	}

	public ManagerLoginRecordDto setLoginStatus(String arg) {
		this.loginStatus = arg;
		return this;
	}

	public Date getLoginTime()

	{
		return this.loginTime;
	}

	public ManagerLoginRecordDto setLoginTime(Date arg) {
		this.loginTime = arg;
		return this;
	}

	public String getPhoneCode()

	{
		return this.phoneCode;
	}

	public ManagerLoginRecordDto setPhoneCode(String arg) {
		this.phoneCode = arg;
		return this;
	}

	public Date getSignOutTime()

	{
		return this.signOutTime;
	}

	public ManagerLoginRecordDto setSignOutTime(Date arg) {
		this.signOutTime = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerLoginRecordDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ManagerLoginRecordDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerLoginRecordDto fromDto(ManagerLoginRecordDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ManagerLoginRecordDto.class);
	}

}
