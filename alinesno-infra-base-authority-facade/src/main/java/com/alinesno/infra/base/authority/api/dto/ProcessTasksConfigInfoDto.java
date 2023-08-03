package com.alinesno.infra.base.authority.api.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： process_tasks_config_info
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ProcessTasksConfigInfoDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "currentTaskId"
	 */
	private String currentTaskId;
	/**
	 * "inputKey"
	 */
	private String inputKey;
	/**
	 * "inputValue"
	 */
	private String inputValue;
	/**
	 * "nextTaskId"
	 */
	private String nextTaskId;
	/**
	 * "outputKey"
	 */
	private String outputKey;
	/**
	 * "outputValue"
	 */
	private String outputValue;
	/**
	 * "previousTaskId"
	 */
	private String previousTaskId;
	/**
	 * "processId"
	 */
	private String processId;
	/**
	 * "taskName"
	 */
	private String taskName;
	/**
	 * "taskType"
	 */
	private String taskType;

	// getter and setter
	public String getCurrentTaskId()

	{
		return this.currentTaskId;
	}

	public ProcessTasksConfigInfoDto setCurrentTaskId(String arg) {
		this.currentTaskId = arg;
		return this;
	}

	public String getInputKey()

	{
		return this.inputKey;
	}

	public ProcessTasksConfigInfoDto setInputKey(String arg) {
		this.inputKey = arg;
		return this;
	}

	public String getInputValue()

	{
		return this.inputValue;
	}

	public ProcessTasksConfigInfoDto setInputValue(String arg) {
		this.inputValue = arg;
		return this;
	}

	public String getNextTaskId()

	{
		return this.nextTaskId;
	}

	public ProcessTasksConfigInfoDto setNextTaskId(String arg) {
		this.nextTaskId = arg;
		return this;
	}

	public String getOutputKey()

	{
		return this.outputKey;
	}

	public ProcessTasksConfigInfoDto setOutputKey(String arg) {
		this.outputKey = arg;
		return this;
	}

	public String getOutputValue()

	{
		return this.outputValue;
	}

	public ProcessTasksConfigInfoDto setOutputValue(String arg) {
		this.outputValue = arg;
		return this;
	}

	public String getPreviousTaskId()

	{
		return this.previousTaskId;
	}

	public ProcessTasksConfigInfoDto setPreviousTaskId(String arg) {
		this.previousTaskId = arg;
		return this;
	}

	public String getProcessId()

	{
		return this.processId;
	}

	public ProcessTasksConfigInfoDto setProcessId(String arg) {
		this.processId = arg;
		return this;
	}

	public String getTaskName()

	{
		return this.taskName;
	}

	public ProcessTasksConfigInfoDto setTaskName(String arg) {
		this.taskName = arg;
		return this;
	}

	public String getTaskType()

	{
		return this.taskType;
	}

	public ProcessTasksConfigInfoDto setTaskType(String arg) {
		this.taskType = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ProcessTasksConfigInfoDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ProcessTasksConfigInfoDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ProcessTasksConfigInfoDto fromDto(ProcessTasksConfigInfoDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ProcessTasksConfigInfoDto.class);
	}

}
