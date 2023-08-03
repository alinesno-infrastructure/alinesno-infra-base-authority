package com.alinesno.infra.base.authority.api.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： info_zipcode
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class InfoZipcodeDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "area"
	 */
	private String area;
	/**
	 * "owners"
	 */
	private String owners;
	/**
	 * "zipCode"
	 */
	private String zipCode;

	// getter and setter
	public String getArea()

	{
		return this.area;
	}

	public InfoZipcodeDto setArea(String arg) {
		this.area = arg;
		return this;
	}

	public String getOwners()

	{
		return this.owners;
	}

	public InfoZipcodeDto setOwners(String arg) {
		this.owners = arg;
		return this;
	}

	public String getZipCode()

	{
		return this.zipCode;
	}

	public InfoZipcodeDto setZipCode(String arg) {
		this.zipCode = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public InfoZipcodeDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, InfoZipcodeDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public InfoZipcodeDto fromDto(InfoZipcodeDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, InfoZipcodeDto.class);
	}

}
