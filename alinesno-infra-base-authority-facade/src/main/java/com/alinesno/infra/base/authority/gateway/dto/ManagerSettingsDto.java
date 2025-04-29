package com.alinesno.infra.base.authority.gateway.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 功能名： 【请填写功能名称】 数据表： manager_settings
 * 
 * @author luoxiaodong 
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ManagerSettingsDto extends BaseDto {

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
