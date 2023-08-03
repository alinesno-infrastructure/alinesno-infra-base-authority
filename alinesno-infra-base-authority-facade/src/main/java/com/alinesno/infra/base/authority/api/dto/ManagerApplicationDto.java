package com.alinesno.infra.base.authority.api.dto;

import org.hibernate.validator.constraints.Length;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.validation.constraints.NotBlank;

/**
 * 功能名： 【请填写功能名称】 数据表： manager_application
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ManagerApplicationDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	// fields
	/**
	 * "applicationDesc"
	 */
	@NotBlank(message = "应用描述为空")
	@Length(min = 4, max = 128, message = "应用描述最小长度为{min} 最大长度为{max}")
	private String applicationDesc;

	@NotBlank(message = "应用名称为空")
	@Length(min = 4, max = 32, message = "应用名称最小长度为{min} 最大长度为{max}")
	private String applicationName; // 应用名称，唯一性，用于做应用标识【最好与springboot的applicaiotn.name对应】

	/**
	 * "applicationIcons"
	 */
	private String applicationIcons;
	/**
	 * "父类Id"
	 */
	private String pid;
	/**
	 * "applicationLink"
	 */
	private String applicationLink;
	/**
	 * "applicationCode"
	 */
	@NotBlank(message = "应用代码为空")
	@Length(min = 4, max = 40, message = "应用代码最小长度为{min} 最大长度为{max}")
	private String applicationCode;

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	// getter and setter
	public String getApplicationDesc()

	{
		return this.applicationDesc;
	}

	public ManagerApplicationDto setApplicationDesc(String arg) {
		this.applicationDesc = arg;
		return this;
	}

	public String getApplicationIcons()

	{
		return this.applicationIcons;
	}

	public ManagerApplicationDto setApplicationIcons(String arg) {
		this.applicationIcons = arg;
		return this;
	}

	public String getPid()

	{
		return this.pid;
	}

	public ManagerApplicationDto setPid(String arg) {
		this.pid = arg;
		return this;
	}

	public String getApplicationLink()

	{
		return this.applicationLink;
	}

	public ManagerApplicationDto setApplicationLink(String arg) {
		this.applicationLink = arg;
		return this;
	}

	public String getApplicationCode()

	{
		return this.applicationCode;
	}

	public ManagerApplicationDto setApplicationCode(String arg) {
		this.applicationCode = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerApplicationDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ManagerApplicationDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerApplicationDto fromDto(ManagerApplicationDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ManagerApplicationDto.class);
	}

}
