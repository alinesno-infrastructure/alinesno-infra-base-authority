package com.alinesno.infra.base.authority.api.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： contract_change_record
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ContractChangeRecordDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "contractNumber"
	 */
	private String contractNumber;
	/**
	 * "materialChangeId"
	 */
	private String materialChangeId;
	/**
	 * "operatorName"
	 */
	private String operatorName;
	/**
	 * "replenishContent"
	 */
	private String replenishContent;
	/**
	 * "replenishName"
	 */
	private String replenishName;
	/**
	 * "replenishReason"
	 */
	private String replenishReason;

	// getter and setter
	public String getContractNumber()

	{
		return this.contractNumber;
	}

	public ContractChangeRecordDto setContractNumber(String arg) {
		this.contractNumber = arg;
		return this;
	}

	public String getMaterialChangeId()

	{
		return this.materialChangeId;
	}

	public ContractChangeRecordDto setMaterialChangeId(String arg) {
		this.materialChangeId = arg;
		return this;
	}

	public String getOperatorName()

	{
		return this.operatorName;
	}

	public ContractChangeRecordDto setOperatorName(String arg) {
		this.operatorName = arg;
		return this;
	}

	public String getReplenishContent()

	{
		return this.replenishContent;
	}

	public ContractChangeRecordDto setReplenishContent(String arg) {
		this.replenishContent = arg;
		return this;
	}

	public String getReplenishName()

	{
		return this.replenishName;
	}

	public ContractChangeRecordDto setReplenishName(String arg) {
		this.replenishName = arg;
		return this;
	}

	public String getReplenishReason()

	{
		return this.replenishReason;
	}

	public ContractChangeRecordDto setReplenishReason(String arg) {
		this.replenishReason = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ContractChangeRecordDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ContractChangeRecordDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ContractChangeRecordDto fromDto(ContractChangeRecordDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ContractChangeRecordDto.class);
	}

}
