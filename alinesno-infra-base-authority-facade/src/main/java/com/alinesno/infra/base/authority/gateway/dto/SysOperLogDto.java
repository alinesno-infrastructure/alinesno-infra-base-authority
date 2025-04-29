package com.alinesno.infra.base.authority.gateway.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 功能名： 【请填写功能名称】 数据表： sys_oper_log
 * 
 * @author luoxiaodong 
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SysOperLogDto extends BaseDto {
	// fields
	/**
	 * "agent"
	 */
	private String agent;
	/**
	 * "contractNumber"
	 */
	private String contractNumber;
	/**
	 * "dataId"
	 */
	private String dataId;
	/**
	 * "flowTaskId"
	 */
	private String flowTaskId;
	/**
	 * "ip"
	 */
	private String ip;
	/**
	 * "methodDesc"
	 */
	private String methodDesc;
	/**
	 * "operContent"
	 */
	private String operContent;
	/**
	 * "operOpinion"
	 */
	private String operOpinion;
	/**
	 * "operStatus"
	 */
	private String operStatus;
	/**
	 * "operTime"
	 */
	private Long operTime;
	/**
	 * "operUserId"
	 */
	private String operUserId;
	/**
	 * "operUserName"
	 */
	private String operUserName;
	/**
	 * "params"
	 */
	private String params;
	/**
	 * "recordType"
	 */
	private String recordType;
	/**
	 * "url"
	 */
	private String url;

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public SysOperLogDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, SysOperLogDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public SysOperLogDto fromDto(SysOperLogDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, SysOperLogDto.class);
	}

}
