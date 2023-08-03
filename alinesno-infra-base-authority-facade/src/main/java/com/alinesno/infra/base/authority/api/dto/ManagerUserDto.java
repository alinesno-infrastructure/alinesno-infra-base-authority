package com.alinesno.infra.base.authority.api.dto;

import java.util.Date;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： manager_user
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ManagerUserDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "userAccount"
	 */
	private String userAccount;
	/**
	 * "userAddtime"
	 */
	private Date userAddtime;
	/**
	 * "userPassword"
	 */
	private String userPassword;
	/**
	 * "userRole"
	 */
	private String userRole;
	/**
	 * "userSalt"
	 */
	private String userSalt;
	/**
	 * "userStatus"
	 */
	private Integer userStatus;
	/**
	 * "userType"
	 */
	private Integer userType;
	/**
	 * "userName"
	 */
	private String userName;

	// getter and setter
	public String getUserAccount()

	{
		return this.userAccount;
	}

	public ManagerUserDto setUserAccount(String arg) {
		this.userAccount = arg;
		return this;
	}

	public Date getUserAddtime()

	{
		return this.userAddtime;
	}

	public ManagerUserDto setUserAddtime(Date arg) {
		this.userAddtime = arg;
		return this;
	}

	public String getUserPassword()

	{
		return this.userPassword;
	}

	public ManagerUserDto setUserPassword(String arg) {
		this.userPassword = arg;
		return this;
	}

	public String getUserRole()

	{
		return this.userRole;
	}

	public ManagerUserDto setUserRole(String arg) {
		this.userRole = arg;
		return this;
	}

	public String getUserSalt()

	{
		return this.userSalt;
	}

	public ManagerUserDto setUserSalt(String arg) {
		this.userSalt = arg;
		return this;
	}

	public Integer getUserStatus()

	{
		return this.userStatus;
	}

	public ManagerUserDto setUserStatus(Integer arg) {
		this.userStatus = arg;
		return this;
	}

	public Integer getUserType()

	{
		return this.userType;
	}

	public ManagerUserDto setUserType(Integer arg) {
		this.userType = arg;
		return this;
	}

	public String getUserName()

	{
		return this.userName;
	}

	public ManagerUserDto setUserName(String arg) {
		this.userName = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerUserDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ManagerUserDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerUserDto fromDto(ManagerUserDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ManagerUserDto.class);
	}

}
