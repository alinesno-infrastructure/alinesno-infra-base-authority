package com.alinesno.infra.base.authority.api.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： manager_code
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ManagerCodeDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "codeName"
	 */
	private String codeName;
	/**
	 * "codeTypeName"
	 */
	private String codeTypeName;
	/**
	 * "codeTypeValue"
	 */
	private String codeTypeValue;
	/**
	 * "codeValue"
	 */
	private String codeValue;
	/**
	 * "codeDesc"
	 */
	private String codeDesc;

	// getter and setter
	public String getCodeName()

	{
		return this.codeName;
	}

	public ManagerCodeDto setCodeName(String arg) {
		this.codeName = arg;
		return this;
	}

	public String getCodeTypeName()

	{
		return this.codeTypeName;
	}

	public ManagerCodeDto setCodeTypeName(String arg) {
		this.codeTypeName = arg;
		return this;
	}

	public String getCodeTypeValue()

	{
		return this.codeTypeValue;
	}

	public ManagerCodeDto setCodeTypeValue(String arg) {
		this.codeTypeValue = arg;
		return this;
	}

	public String getCodeValue()

	{
		return this.codeValue;
	}

	public ManagerCodeDto setCodeValue(String arg) {
		this.codeValue = arg;
		return this;
	}

	public String getCodeDesc()

	{
		return this.codeDesc;
	}

	public ManagerCodeDto setCodeDesc(String arg) {
		this.codeDesc = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerCodeDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ManagerCodeDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerCodeDto fromDto(ManagerCodeDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ManagerCodeDto.class);
	}

}
