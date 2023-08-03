package com.alinesno.infra.base.authority.api.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： contract_examine_info
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ContractExamineInfoDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "approverId"
	 */
	private String approverId;
	/**
	 * "contractNumber"
	 */
	private String contractNumber;
	/**
	 * "currentTaskId"
	 */
	private String currentTaskId;
	/**
	 * "examineOpinion"
	 */
	private String examineOpinion;
	/**
	 * "examineStatus"
	 */
	private String examineStatus;
	/**
	 * "nextTaskDefKey"
	 */
	private String nextTaskDefKey;

	// getter and setter
	public String getApproverId()

	{
		return this.approverId;
	}

	public ContractExamineInfoDto setApproverId(String arg) {
		this.approverId = arg;
		return this;
	}

	public String getContractNumber()

	{
		return this.contractNumber;
	}

	public ContractExamineInfoDto setContractNumber(String arg) {
		this.contractNumber = arg;
		return this;
	}

	public String getCurrentTaskId()

	{
		return this.currentTaskId;
	}

	public ContractExamineInfoDto setCurrentTaskId(String arg) {
		this.currentTaskId = arg;
		return this;
	}

	public String getExamineOpinion()

	{
		return this.examineOpinion;
	}

	public ContractExamineInfoDto setExamineOpinion(String arg) {
		this.examineOpinion = arg;
		return this;
	}

	public String getExamineStatus()

	{
		return this.examineStatus;
	}

	public ContractExamineInfoDto setExamineStatus(String arg) {
		this.examineStatus = arg;
		return this;
	}

	public String getNextTaskDefKey()

	{
		return this.nextTaskDefKey;
	}

	public ContractExamineInfoDto setNextTaskDefKey(String arg) {
		this.nextTaskDefKey = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ContractExamineInfoDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ContractExamineInfoDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ContractExamineInfoDto fromDto(ContractExamineInfoDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ContractExamineInfoDto.class);
	}

}
