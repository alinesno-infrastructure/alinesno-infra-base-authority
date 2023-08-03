package com.alinesno.infra.base.authority.api.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： info_professional
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class InfoProfessionalDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "owners"
	 */
	private String owners;
	/**
	 * "professionalName"
	 */
	private String professionalName;
	/**
	 * "professionalProp"
	 */
	private String professionalProp;

	// getter and setter
	public String getOwners()

	{
		return this.owners;
	}

	public InfoProfessionalDto setOwners(String arg) {
		this.owners = arg;
		return this;
	}

	public String getProfessionalName()

	{
		return this.professionalName;
	}

	public InfoProfessionalDto setProfessionalName(String arg) {
		this.professionalName = arg;
		return this;
	}

	public String getProfessionalProp()

	{
		return this.professionalProp;
	}

	public InfoProfessionalDto setProfessionalProp(String arg) {
		this.professionalProp = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public InfoProfessionalDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, InfoProfessionalDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public InfoProfessionalDto fromDto(InfoProfessionalDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, InfoProfessionalDto.class);
	}

}
