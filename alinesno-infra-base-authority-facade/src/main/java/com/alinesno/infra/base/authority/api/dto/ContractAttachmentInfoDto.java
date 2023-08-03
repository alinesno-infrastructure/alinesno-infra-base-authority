package com.alinesno.infra.base.authority.api.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： contract_attachment_info
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ContractAttachmentInfoDto extends BaseDto {
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
	 * "attachmentRemark"
	 */
	private String attachmentRemark;
	/**
	 * "attachmentSize"
	 */
	private String attachmentSize;
	/**
	 * "attachmentType"
	 */
	private String attachmentType;
	/**
	 * "changeRecordId"
	 */
	private String changeRecordId;
	/**
	 * "contractNumber"
	 */
	private String contractNumber;

	// getter and setter
	public String getAttachmentClassify()

	{
		return this.attachmentClassify;
	}

	public ContractAttachmentInfoDto setAttachmentClassify(String arg) {
		this.attachmentClassify = arg;
		return this;
	}

	public String getAttachmentLink()

	{
		return this.attachmentLink;
	}

	public ContractAttachmentInfoDto setAttachmentLink(String arg) {
		this.attachmentLink = arg;
		return this;
	}

	public String getAttachmentName()

	{
		return this.attachmentName;
	}

	public ContractAttachmentInfoDto setAttachmentName(String arg) {
		this.attachmentName = arg;
		return this;
	}

	public String getAttachmentRemark()

	{
		return this.attachmentRemark;
	}

	public ContractAttachmentInfoDto setAttachmentRemark(String arg) {
		this.attachmentRemark = arg;
		return this;
	}

	public String getAttachmentSize()

	{
		return this.attachmentSize;
	}

	public ContractAttachmentInfoDto setAttachmentSize(String arg) {
		this.attachmentSize = arg;
		return this;
	}

	public String getAttachmentType()

	{
		return this.attachmentType;
	}

	public ContractAttachmentInfoDto setAttachmentType(String arg) {
		this.attachmentType = arg;
		return this;
	}

	public String getChangeRecordId()

	{
		return this.changeRecordId;
	}

	public ContractAttachmentInfoDto setChangeRecordId(String arg) {
		this.changeRecordId = arg;
		return this;
	}

	public String getContractNumber()

	{
		return this.contractNumber;
	}

	public ContractAttachmentInfoDto setContractNumber(String arg) {
		this.contractNumber = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ContractAttachmentInfoDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ContractAttachmentInfoDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ContractAttachmentInfoDto fromDto(ContractAttachmentInfoDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ContractAttachmentInfoDto.class);
	}

}
