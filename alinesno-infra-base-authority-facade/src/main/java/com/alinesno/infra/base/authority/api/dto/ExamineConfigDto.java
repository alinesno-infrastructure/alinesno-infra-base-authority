package com.alinesno.infra.base.authority.api.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： examine_config
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ExamineConfigDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "taskId"
	 */
	private String taskId;
	/**
	 * "userId"
	 */
	private String userId;

	// getter and setter
	public String getTaskId()

	{
		return this.taskId;
	}

	public ExamineConfigDto setTaskId(String arg) {
		this.taskId = arg;
		return this;
	}

	public String getUserId()

	{
		return this.userId;
	}

	public ExamineConfigDto setUserId(String arg) {
		this.userId = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ExamineConfigDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ExamineConfigDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ExamineConfigDto fromDto(ExamineConfigDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ExamineConfigDto.class);
	}

}
