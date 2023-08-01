package com.alinesno.infra.base.authority.gateway.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： basic_settings
 * 
 * @author LuoAnDong ${authorEmail}
 * @date 2021-08-04 19:24:37
 */
public class BasicSettingsDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "currentUse"
	 */
	private String currentUse;
	/**
	 * "settingsDesc"
	 */
	private String settingsDesc;
	/**
	 * "settingsKey"
	 */
	private String settingsKey;
	/**
	 * "settingsName"
	 */
	private String settingsName;

	// getter and setter
	public String getCurrentUse()

	{
		return this.currentUse;
	}

	public BasicSettingsDto setCurrentUse(String arg) {
		this.currentUse = arg;
		return this;
	}

	public String getSettingsDesc()

	{
		return this.settingsDesc;
	}

	public BasicSettingsDto setSettingsDesc(String arg) {
		this.settingsDesc = arg;
		return this;
	}

	public String getSettingsKey()

	{
		return this.settingsKey;
	}

	public BasicSettingsDto setSettingsKey(String arg) {
		this.settingsKey = arg;
		return this;
	}

	public String getSettingsName()

	{
		return this.settingsName;
	}

	public BasicSettingsDto setSettingsName(String arg) {
		this.settingsName = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public BasicSettingsDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, BasicSettingsDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public BasicSettingsDto fromDto(BasicSettingsDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, BasicSettingsDto.class);
	}

}
