package com.alinesno.infra.base.authority.api.dto;

import java.util.Date;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： contract_sign_info
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ContractSignInfoDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "companyAddress"
	 */
	private String companyAddress;
	/**
	 * "companyName"
	 */
	private String companyName;
	/**
	 * "companyNature"
	 */
	private String companyNature;
	/**
	 * "contactName"
	 */
	private String contactName;
	/**
	 * "contactPhone"
	 */
	private String contactPhone;
	/**
	 * "contractNumber"
	 */
	private String contractNumber;
	/**
	 * "establishedTime"
	 */
	private Date establishedTime;
	/**
	 * "roleType"
	 */
	private String roleType;
	/**
	 * "signatoryContactId"
	 */
	private String signatoryContactId;
	/**
	 * "signatoryId"
	 */
	private String signatoryId;
	/**
	 * "sortNum"
	 */
	private Long sortNum;

	// getter and setter
	public String getCompanyAddress()

	{
		return this.companyAddress;
	}

	public ContractSignInfoDto setCompanyAddress(String arg) {
		this.companyAddress = arg;
		return this;
	}

	public String getCompanyName()

	{
		return this.companyName;
	}

	public ContractSignInfoDto setCompanyName(String arg) {
		this.companyName = arg;
		return this;
	}

	public String getCompanyNature()

	{
		return this.companyNature;
	}

	public ContractSignInfoDto setCompanyNature(String arg) {
		this.companyNature = arg;
		return this;
	}

	public String getContactName()

	{
		return this.contactName;
	}

	public ContractSignInfoDto setContactName(String arg) {
		this.contactName = arg;
		return this;
	}

	public String getContactPhone()

	{
		return this.contactPhone;
	}

	public ContractSignInfoDto setContactPhone(String arg) {
		this.contactPhone = arg;
		return this;
	}

	public String getContractNumber()

	{
		return this.contractNumber;
	}

	public ContractSignInfoDto setContractNumber(String arg) {
		this.contractNumber = arg;
		return this;
	}

	public Date getEstablishedTime()

	{
		return this.establishedTime;
	}

	public ContractSignInfoDto setEstablishedTime(Date arg) {
		this.establishedTime = arg;
		return this;
	}

	public String getRoleType()

	{
		return this.roleType;
	}

	public ContractSignInfoDto setRoleType(String arg) {
		this.roleType = arg;
		return this;
	}

	public String getSignatoryContactId()

	{
		return this.signatoryContactId;
	}

	public ContractSignInfoDto setSignatoryContactId(String arg) {
		this.signatoryContactId = arg;
		return this;
	}

	public String getSignatoryId()

	{
		return this.signatoryId;
	}

	public ContractSignInfoDto setSignatoryId(String arg) {
		this.signatoryId = arg;
		return this;
	}

	public Long getSortNum()

	{
		return this.sortNum;
	}

	public ContractSignInfoDto setSortNum(Long arg) {
		this.sortNum = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ContractSignInfoDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ContractSignInfoDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ContractSignInfoDto fromDto(ContractSignInfoDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ContractSignInfoDto.class);
	}

}
