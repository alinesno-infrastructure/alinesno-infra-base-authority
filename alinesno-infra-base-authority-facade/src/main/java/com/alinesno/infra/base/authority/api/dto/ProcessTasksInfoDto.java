package com.alinesno.infra.base.authority.api.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： process_tasks_info
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ProcessTasksInfoDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "contractNumber"
	 */
	private String contractNumber;
	/**
	 * "processId"
	 */
	private String processId;
	/**
	 * "processStatus"
	 */
	private String processStatus;
	/**
	 * "processType"
	 */
	private String processType;
	/**
	 * "taskId"
	 */
	private String taskId;
	/**
	 * "userId"
	 */
	private String userId;

	// getter and setter
	public String getContractNumber()

	{
		return this.contractNumber;
	}

	public ProcessTasksInfoDto setContractNumber(String arg) {
		this.contractNumber = arg;
		return this;
	}

	public String getProcessId()

	{
		return this.processId;
	}

	public ProcessTasksInfoDto setProcessId(String arg) {
		this.processId = arg;
		return this;
	}

	public String getProcessStatus()

	{
		return this.processStatus;
	}

	public ProcessTasksInfoDto setProcessStatus(String arg) {
		this.processStatus = arg;
		return this;
	}

	public String getProcessType()

	{
		return this.processType;
	}

	public ProcessTasksInfoDto setProcessType(String arg) {
		this.processType = arg;
		return this;
	}

	public String getTaskId()

	{
		return this.taskId;
	}

	public ProcessTasksInfoDto setTaskId(String arg) {
		this.taskId = arg;
		return this;
	}

	public String getUserId()

	{
		return this.userId;
	}

	public ProcessTasksInfoDto setUserId(String arg) {
		this.userId = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ProcessTasksInfoDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ProcessTasksInfoDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ProcessTasksInfoDto fromDto(ProcessTasksInfoDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ProcessTasksInfoDto.class);
	}

}
