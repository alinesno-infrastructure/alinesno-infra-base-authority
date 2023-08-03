package com.alinesno.infra.base.authority.api.dto;

import java.util.Date;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： signatory_info
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class SignatoryInfoDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "attachmentId"
	 */
	private String attachmentId;
	/**
	 * "bankAccount"
	 */
	private String bankAccount;
	/**
	 * "businessScope"
	 */
	private String businessScope;
	/**
	 * "companyAddress"
	 */
	private String companyAddress;
	/**
	 * "companyArea"
	 */
	private String companyArea;
	/**
	 * "companyName"
	 */
	private String companyName;
	/**
	 * "companyNature"
	 */
	private String companyNature;
	/**
	 * "depositBank"
	 */
	private String depositBank;
	/**
	 * "establishedTime"
	 */
	private Date establishedTime;
	/**
	 * "identificationNumber"
	 */
	private String identificationNumber;
	/**
	 * "registeredCapital"
	 */
	private Long registeredCapital;
	/**
	 * "representativeName"
	 */
	private String representativeName;

	// getter and setter
	public String getAttachmentId()

	{
		return this.attachmentId;
	}

	public SignatoryInfoDto setAttachmentId(String arg) {
		this.attachmentId = arg;
		return this;
	}

	public String getBankAccount()

	{
		return this.bankAccount;
	}

	public SignatoryInfoDto setBankAccount(String arg) {
		this.bankAccount = arg;
		return this;
	}

	public String getBusinessScope()

	{
		return this.businessScope;
	}

	public SignatoryInfoDto setBusinessScope(String arg) {
		this.businessScope = arg;
		return this;
	}

	public String getCompanyAddress()

	{
		return this.companyAddress;
	}

	public SignatoryInfoDto setCompanyAddress(String arg) {
		this.companyAddress = arg;
		return this;
	}

	public String getCompanyArea()

	{
		return this.companyArea;
	}

	public SignatoryInfoDto setCompanyArea(String arg) {
		this.companyArea = arg;
		return this;
	}

	public String getCompanyName()

	{
		return this.companyName;
	}

	public SignatoryInfoDto setCompanyName(String arg) {
		this.companyName = arg;
		return this;
	}

	public String getCompanyNature()

	{
		return this.companyNature;
	}

	public SignatoryInfoDto setCompanyNature(String arg) {
		this.companyNature = arg;
		return this;
	}

	public String getDepositBank()

	{
		return this.depositBank;
	}

	public SignatoryInfoDto setDepositBank(String arg) {
		this.depositBank = arg;
		return this;
	}

	public Date getEstablishedTime()

	{
		return this.establishedTime;
	}

	public SignatoryInfoDto setEstablishedTime(Date arg) {
		this.establishedTime = arg;
		return this;
	}

	public String getIdentificationNumber()

	{
		return this.identificationNumber;
	}

	public SignatoryInfoDto setIdentificationNumber(String arg) {
		this.identificationNumber = arg;
		return this;
	}

	public Long getRegisteredCapital()

	{
		return this.registeredCapital;
	}

	public SignatoryInfoDto setRegisteredCapital(Long arg) {
		this.registeredCapital = arg;
		return this;
	}

	public String getRepresentativeName()

	{
		return this.representativeName;
	}

	public SignatoryInfoDto setRepresentativeName(String arg) {
		this.representativeName = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public SignatoryInfoDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, SignatoryInfoDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public SignatoryInfoDto fromDto(SignatoryInfoDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, SignatoryInfoDto.class);
	}

}
