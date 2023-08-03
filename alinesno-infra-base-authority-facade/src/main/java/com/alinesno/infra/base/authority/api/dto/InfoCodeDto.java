package com.alinesno.infra.base.authority.api.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： info_code
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class InfoCodeDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "codeName"
	 */
	private String codeName;
	/**
	 * "codeType"
	 */
	private String codeType;
	/**
	 * "codeValue"
	 */
	private String codeValue;
	/**
	 * "owners"
	 */
	private String owners;

	// getter and setter
	public String getCodeName()

	{
		return this.codeName;
	}

	public InfoCodeDto setCodeName(String arg) {
		this.codeName = arg;
		return this;
	}

	public String getCodeType()

	{
		return this.codeType;
	}

	public InfoCodeDto setCodeType(String arg) {
		this.codeType = arg;
		return this;
	}

	public String getCodeValue()

	{
		return this.codeValue;
	}

	public InfoCodeDto setCodeValue(String arg) {
		this.codeValue = arg;
		return this;
	}

	public String getOwners()

	{
		return this.owners;
	}

	public InfoCodeDto setOwners(String arg) {
		this.owners = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public InfoCodeDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, InfoCodeDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public InfoCodeDto fromDto(InfoCodeDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, InfoCodeDto.class);
	}

}
