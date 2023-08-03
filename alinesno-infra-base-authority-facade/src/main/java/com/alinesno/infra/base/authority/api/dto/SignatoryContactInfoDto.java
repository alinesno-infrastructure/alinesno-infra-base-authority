package com.alinesno.infra.base.authority.api.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： signatory_contact_info
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class SignatoryContactInfoDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "contactAddress"
	 */
	private String contactAddress;
	/**
	 * "contactName"
	 */
	private String contactName;
	/**
	 * "contactPhone"
	 */
	private String contactPhone;
	/**
	 * "postalCode"
	 */
	private String postalCode;
	/**
	 * "signatoryId"
	 */
	private String signatoryId;

	// getter and setter
	public String getContactAddress()

	{
		return this.contactAddress;
	}

	public SignatoryContactInfoDto setContactAddress(String arg) {
		this.contactAddress = arg;
		return this;
	}

	public String getContactName()

	{
		return this.contactName;
	}

	public SignatoryContactInfoDto setContactName(String arg) {
		this.contactName = arg;
		return this;
	}

	public String getContactPhone()

	{
		return this.contactPhone;
	}

	public SignatoryContactInfoDto setContactPhone(String arg) {
		this.contactPhone = arg;
		return this;
	}

	public String getPostalCode()

	{
		return this.postalCode;
	}

	public SignatoryContactInfoDto setPostalCode(String arg) {
		this.postalCode = arg;
		return this;
	}

	public String getSignatoryId()

	{
		return this.signatoryId;
	}

	public SignatoryContactInfoDto setSignatoryId(String arg) {
		this.signatoryId = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public SignatoryContactInfoDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, SignatoryContactInfoDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public SignatoryContactInfoDto fromDto(SignatoryContactInfoDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, SignatoryContactInfoDto.class);
	}

}
