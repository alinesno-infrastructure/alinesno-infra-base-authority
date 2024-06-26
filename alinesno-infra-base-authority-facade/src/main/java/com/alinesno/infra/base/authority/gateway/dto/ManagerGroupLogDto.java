package com.alinesno.infra.base.authority.gateway.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;

/**
 * 功能名： 【请填写功能名称】 数据表： manager_group_log
 * 
 * @author luoxiaodong 
 * @version 1.0.0
 */
public class ManagerGroupLogDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "actionType"
	 */
	private String actionType;
	/**
	 * "endTime"
	 */
	private Date endTime;
	/**
	 * "logBusinessId"
	 */
	private String logBusinessId;
	/**
	 * "logChannel"
	 */
	private String logChannel;
	/**
	 * "logContent"
	 */
	private String logContent;
	/**
	 * "logIp"
	 */
	private String logIp;
	/**
	 * "logMachine"
	 */
	private String logMachine;

	// getter and setter
	public String getActionType()

	{
		return this.actionType;
	}

	public ManagerGroupLogDto setActionType(String arg) {
		this.actionType = arg;
		return this;
	}

	public Date getEndTime()

	{
		return this.endTime;
	}

	public ManagerGroupLogDto setEndTime(Date arg) {
		this.endTime = arg;
		return this;
	}

	public String getLogBusinessId()

	{
		return this.logBusinessId;
	}

	public ManagerGroupLogDto setLogBusinessId(String arg) {
		this.logBusinessId = arg;
		return this;
	}

	public String getLogChannel()

	{
		return this.logChannel;
	}

	public ManagerGroupLogDto setLogChannel(String arg) {
		this.logChannel = arg;
		return this;
	}

	public String getLogContent()

	{
		return this.logContent;
	}

	public ManagerGroupLogDto setLogContent(String arg) {
		this.logContent = arg;
		return this;
	}

	public String getLogIp()

	{
		return this.logIp;
	}

	public ManagerGroupLogDto setLogIp(String arg) {
		this.logIp = arg;
		return this;
	}

	public String getLogMachine()

	{
		return this.logMachine;
	}

	public ManagerGroupLogDto setLogMachine(String arg) {
		this.logMachine = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerGroupLogDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ManagerGroupLogDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerGroupLogDto fromDto(ManagerGroupLogDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ManagerGroupLogDto.class);
	}

}
