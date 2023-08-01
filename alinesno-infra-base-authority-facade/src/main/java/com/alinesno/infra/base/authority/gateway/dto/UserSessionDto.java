package com.alinesno.infra.base.authority.gateway.dto;

import java.util.Date;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： user_session
 * 
 * @author LuoAnDong ${authorEmail}
 * @date 2021-08-04 19:24:39
 */
public class UserSessionDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "browser"
	 */
	private String browser;
	/**
	 * "os"
	 */
	private String os;
	/**
	 * "deptName"
	 */
	private String deptName;
	/**
	 * "lastAccessTime"
	 */
	private Date lastAccessTime;
	/**
	 * "loginLocation"
	 */
	private String loginLocation;
	/**
	 * "loginName"
	 */
	private String loginName;
	/**
	 * "sessionId"
	 */
	private String sessionId;
	/**
	 * "ipAddr"
	 */
	private String ipAddr;
	/**
	 * "startTimeStamp"
	 */
	private Date startTimeStamp;

	// getter and setter
	public String getBrowser()

	{
		return this.browser;
	}

	public UserSessionDto setBrowser(String arg) {
		this.browser = arg;
		return this;
	}

	public String getOs()

	{
		return this.os;
	}

	public UserSessionDto setOs(String arg) {
		this.os = arg;
		return this;
	}

	public String getDeptName()

	{
		return this.deptName;
	}

	public UserSessionDto setDeptName(String arg) {
		this.deptName = arg;
		return this;
	}

	public Date getLastAccessTime()

	{
		return this.lastAccessTime;
	}

	public UserSessionDto setLastAccessTime(Date arg) {
		this.lastAccessTime = arg;
		return this;
	}

	public String getLoginLocation()

	{
		return this.loginLocation;
	}

	public UserSessionDto setLoginLocation(String arg) {
		this.loginLocation = arg;
		return this;
	}

	public String getLoginName()

	{
		return this.loginName;
	}

	public UserSessionDto setLoginName(String arg) {
		this.loginName = arg;
		return this;
	}

	public String getSessionId()

	{
		return this.sessionId;
	}

	public UserSessionDto setSessionId(String arg) {
		this.sessionId = arg;
		return this;
	}

	public String getIpAddr()

	{
		return this.ipAddr;
	}

	public UserSessionDto setIpAddr(String arg) {
		this.ipAddr = arg;
		return this;
	}

	public Date getStartTimeStamp()

	{
		return this.startTimeStamp;
	}

	public UserSessionDto setStartTimeStamp(Date arg) {
		this.startTimeStamp = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public UserSessionDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, UserSessionDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public UserSessionDto fromDto(UserSessionDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, UserSessionDto.class);
	}

}
