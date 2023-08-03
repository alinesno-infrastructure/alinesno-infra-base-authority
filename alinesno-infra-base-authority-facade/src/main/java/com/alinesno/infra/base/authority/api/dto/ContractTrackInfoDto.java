package com.alinesno.infra.base.authority.api.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： contract_track_info
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ContractTrackInfoDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "contractNumber"
	 */
	private String contractNumber;
	/**
	 * "trackStatus"
	 */
	private String trackStatus;
	/**
	 * "userId"
	 */
	private String userId;

	// getter and setter
	public String getContractNumber()

	{
		return this.contractNumber;
	}

	public ContractTrackInfoDto setContractNumber(String arg) {
		this.contractNumber = arg;
		return this;
	}

	public String getTrackStatus()

	{
		return this.trackStatus;
	}

	public ContractTrackInfoDto setTrackStatus(String arg) {
		this.trackStatus = arg;
		return this;
	}

	public String getUserId()

	{
		return this.userId;
	}

	public ContractTrackInfoDto setUserId(String arg) {
		this.userId = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ContractTrackInfoDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ContractTrackInfoDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ContractTrackInfoDto fromDto(ContractTrackInfoDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ContractTrackInfoDto.class);
	}

}
