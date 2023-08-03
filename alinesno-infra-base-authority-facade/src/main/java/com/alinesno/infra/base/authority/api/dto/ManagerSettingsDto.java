package com.alinesno.infra.base.authority.api.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： manager_settings
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ManagerSettingsDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "configName"
	 */
	private String configName;
	/**
	 * "configKey"
	 */
	private String configKey;
	/**
	 * "configValue"
	 */
	private String configValue;
	/**
	 * "configType"
	 */
	private String configType;
	/**
	 * "configRemark"
	 */
	private String configRemark;

	// getter and setter
	public String getConfigName()

	{
		return this.configName;
	}

	public ManagerSettingsDto setConfigName(String arg) {
		this.configName = arg;
		return this;
	}

	public String getConfigKey()

	{
		return this.configKey;
	}

	public ManagerSettingsDto setConfigKey(String arg) {
		this.configKey = arg;
		return this;
	}

	public String getConfigValue()

	{
		return this.configValue;
	}

	public ManagerSettingsDto setConfigValue(String arg) {
		this.configValue = arg;
		return this;
	}

	public String getConfigType()

	{
		return this.configType;
	}

	public ManagerSettingsDto setConfigType(String arg) {
		this.configType = arg;
		return this;
	}

	public String getConfigRemark()

	{
		return this.configRemark;
	}

	public ManagerSettingsDto setConfigRemark(String arg) {
		this.configRemark = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerSettingsDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ManagerSettingsDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerSettingsDto fromDto(ManagerSettingsDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ManagerSettingsDto.class);
	}

}
