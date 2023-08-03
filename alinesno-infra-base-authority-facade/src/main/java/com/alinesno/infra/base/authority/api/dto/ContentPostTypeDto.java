package com.alinesno.infra.base.authority.api.dto;

import java.util.Date;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： content_post_type
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ContentPostTypeDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "typeAddTime"
	 */
	private Date typeAddTime;
	/**
	 * "typeName"
	 */
	private String typeName;
	/**
	 * "typeStatus"
	 */
	private Long typeStatus;
	/**
	 * "pid"
	 */
	private String pid;

	// getter and setter
	public Date getTypeAddTime()

	{
		return this.typeAddTime;
	}

	public ContentPostTypeDto setTypeAddTime(Date arg) {
		this.typeAddTime = arg;
		return this;
	}

	public String getTypeName()

	{
		return this.typeName;
	}

	public ContentPostTypeDto setTypeName(String arg) {
		this.typeName = arg;
		return this;
	}

	public Long getTypeStatus()

	{
		return this.typeStatus;
	}

	public ContentPostTypeDto setTypeStatus(Long arg) {
		this.typeStatus = arg;
		return this;
	}

	public String getPid()

	{
		return this.pid;
	}

	public ContentPostTypeDto setPid(String arg) {
		this.pid = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ContentPostTypeDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ContentPostTypeDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ContentPostTypeDto fromDto(ContentPostTypeDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ContentPostTypeDto.class);
	}

}
