package com.alinesno.infra.base.authority.api.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： content_postmeta
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ContentPostmetaDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "metaKey"
	 */
	private String metaKey;
	/**
	 * "metaValue"
	 */
	private String metaValue;
	/**
	 * "postId"
	 */
	private Long postId;

	// getter and setter
	public String getMetaKey()

	{
		return this.metaKey;
	}

	public ContentPostmetaDto setMetaKey(String arg) {
		this.metaKey = arg;
		return this;
	}

	public String getMetaValue()

	{
		return this.metaValue;
	}

	public ContentPostmetaDto setMetaValue(String arg) {
		this.metaValue = arg;
		return this;
	}

	public Long getPostId()

	{
		return this.postId;
	}

	public ContentPostmetaDto setPostId(Long arg) {
		this.postId = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ContentPostmetaDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ContentPostmetaDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ContentPostmetaDto fromDto(ContentPostmetaDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ContentPostmetaDto.class);
	}

}
