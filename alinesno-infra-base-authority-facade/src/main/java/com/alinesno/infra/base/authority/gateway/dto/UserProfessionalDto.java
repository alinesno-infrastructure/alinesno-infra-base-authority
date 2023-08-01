package com.alinesno.infra.base.authority.gateway.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： user_professional
 * 
 * @author LuoAnDong ${authorEmail}
 * @date 2023-08-04 19:24:39
 */
public class UserProfessionalDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "isUse"
	 */
	private String isUse;
	/**
	 * "professionalName"
	 */
	private String professionalName;
	/**
	 * "useEndTime"
	 */
	private String useEndTime;
	/**
	 * "useStartTime"
	 */
	private String useStartTime;
	/**
	 * "userId"
	 */
	private String userId;

	// getter and setter
	public String getIsUse()

	{
		return this.isUse;
	}

	public UserProfessionalDto setIsUse(String arg) {
		this.isUse = arg;
		return this;
	}

	public String getProfessionalName()

	{
		return this.professionalName;
	}

	public UserProfessionalDto setProfessionalName(String arg) {
		this.professionalName = arg;
		return this;
	}

	public String getUseEndTime()

	{
		return this.useEndTime;
	}

	public UserProfessionalDto setUseEndTime(String arg) {
		this.useEndTime = arg;
		return this;
	}

	public String getUseStartTime()

	{
		return this.useStartTime;
	}

	public UserProfessionalDto setUseStartTime(String arg) {
		this.useStartTime = arg;
		return this;
	}

	public String getUserId()

	{
		return this.userId;
	}

	public UserProfessionalDto setUserId(String arg) {
		this.userId = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public UserProfessionalDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, UserProfessionalDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public UserProfessionalDto fromDto(UserProfessionalDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, UserProfessionalDto.class);
	}

}
