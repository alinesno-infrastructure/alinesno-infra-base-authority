package com.alinesno.infra.base.authority.api.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： signatory_attachment_info
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class SignatoryAttachmentInfoDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "attachmentClassify"
	 */
	private String attachmentClassify;
	/**
	 * "attachmentLink"
	 */
	private String attachmentLink;
	/**
	 * "attachmentName"
	 */
	private String attachmentName;
	/**
	 * "attachmentType"
	 */
	private String attachmentType;
	/**
	 * "signatoryId"
	 */
	private String signatoryId;

	// getter and setter
	public String getAttachmentClassify()

	{
		return this.attachmentClassify;
	}

	public SignatoryAttachmentInfoDto setAttachmentClassify(String arg) {
		this.attachmentClassify = arg;
		return this;
	}

	public String getAttachmentLink()

	{
		return this.attachmentLink;
	}

	public SignatoryAttachmentInfoDto setAttachmentLink(String arg) {
		this.attachmentLink = arg;
		return this;
	}

	public String getAttachmentName()

	{
		return this.attachmentName;
	}

	public SignatoryAttachmentInfoDto setAttachmentName(String arg) {
		this.attachmentName = arg;
		return this;
	}

	public String getAttachmentType()

	{
		return this.attachmentType;
	}

	public SignatoryAttachmentInfoDto setAttachmentType(String arg) {
		this.attachmentType = arg;
		return this;
	}

	public String getSignatoryId()

	{
		return this.signatoryId;
	}

	public SignatoryAttachmentInfoDto setSignatoryId(String arg) {
		this.signatoryId = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public SignatoryAttachmentInfoDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, SignatoryAttachmentInfoDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public SignatoryAttachmentInfoDto fromDto(SignatoryAttachmentInfoDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, SignatoryAttachmentInfoDto.class);
	}

}
