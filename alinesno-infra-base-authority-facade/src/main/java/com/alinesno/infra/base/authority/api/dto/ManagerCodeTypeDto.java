package com.alinesno.infra.base.authority.api.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： manager_code_type
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ManagerCodeTypeDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "codeTypeName"
	 */
	private String codeTypeName;
	/**
	 * "codeTypeValue"
	 */
	private String codeTypeValue;

	// getter and setter
	public String getCodeTypeName()

	{
		return this.codeTypeName;
	}

	public ManagerCodeTypeDto setCodeTypeName(String arg) {
		this.codeTypeName = arg;
		return this;
	}

	public String getCodeTypeValue()

	{
		return this.codeTypeValue;
	}

	public ManagerCodeTypeDto setCodeTypeValue(String arg) {
		this.codeTypeValue = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerCodeTypeDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ManagerCodeTypeDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerCodeTypeDto fromDto(ManagerCodeTypeDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ManagerCodeTypeDto.class);
	}

}
