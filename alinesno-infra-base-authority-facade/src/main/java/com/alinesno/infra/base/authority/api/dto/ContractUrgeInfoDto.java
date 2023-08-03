package com.alinesno.infra.base.authority.api.dto;

import java.util.Date;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： contract_urge_info
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ContractUrgeInfoDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "actualFinishDate"
	 */
	private Date actualFinishDate;
	/**
	 * "contractNumber"
	 */
	private String contractNumber;
	/**
	 * "expectFinishDate"
	 */
	private Date expectFinishDate;
	/**
	 * "toUrgeUserId"
	 */
	private String toUrgeUserId;
	/**
	 * "urgeDate"
	 */
	private Date urgeDate;
	/**
	 * "urgeItems"
	 */
	private String urgeItems;
	/**
	 * "urgeProcess"
	 */
	private String urgeProcess;
	/**
	 * "urgeType"
	 */
	private String urgeType;
	/**
	 * "urgeUserId"
	 */
	private String urgeUserId;

	// getter and setter
	public Date getActualFinishDate()

	{
		return this.actualFinishDate;
	}

	public ContractUrgeInfoDto setActualFinishDate(Date arg) {
		this.actualFinishDate = arg;
		return this;
	}

	public String getContractNumber()

	{
		return this.contractNumber;
	}

	public ContractUrgeInfoDto setContractNumber(String arg) {
		this.contractNumber = arg;
		return this;
	}

	public Date getExpectFinishDate()

	{
		return this.expectFinishDate;
	}

	public ContractUrgeInfoDto setExpectFinishDate(Date arg) {
		this.expectFinishDate = arg;
		return this;
	}

	public String getToUrgeUserId()

	{
		return this.toUrgeUserId;
	}

	public ContractUrgeInfoDto setToUrgeUserId(String arg) {
		this.toUrgeUserId = arg;
		return this;
	}

	public Date getUrgeDate()

	{
		return this.urgeDate;
	}

	public ContractUrgeInfoDto setUrgeDate(Date arg) {
		this.urgeDate = arg;
		return this;
	}

	public String getUrgeItems()

	{
		return this.urgeItems;
	}

	public ContractUrgeInfoDto setUrgeItems(String arg) {
		this.urgeItems = arg;
		return this;
	}

	public String getUrgeProcess()

	{
		return this.urgeProcess;
	}

	public ContractUrgeInfoDto setUrgeProcess(String arg) {
		this.urgeProcess = arg;
		return this;
	}

	public String getUrgeType()

	{
		return this.urgeType;
	}

	public ContractUrgeInfoDto setUrgeType(String arg) {
		this.urgeType = arg;
		return this;
	}

	public String getUrgeUserId()

	{
		return this.urgeUserId;
	}

	public ContractUrgeInfoDto setUrgeUserId(String arg) {
		this.urgeUserId = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ContractUrgeInfoDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ContractUrgeInfoDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ContractUrgeInfoDto fromDto(ContractUrgeInfoDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ContractUrgeInfoDto.class);
	}

}
