package com.alinesno.infra.base.authority.api.dto;

import java.util.Date;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： manager_tenant_log
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ManagerTenantLogDto extends BaseDto {
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

	public ManagerTenantLogDto setActionType(String arg) {
		this.actionType = arg;
		return this;
	}

	public Date getEndTime()

	{
		return this.endTime;
	}

	public ManagerTenantLogDto setEndTime(Date arg) {
		this.endTime = arg;
		return this;
	}

	public String getLogBusinessId()

	{
		return this.logBusinessId;
	}

	public ManagerTenantLogDto setLogBusinessId(String arg) {
		this.logBusinessId = arg;
		return this;
	}

	public String getLogChannel()

	{
		return this.logChannel;
	}

	public ManagerTenantLogDto setLogChannel(String arg) {
		this.logChannel = arg;
		return this;
	}

	public String getLogContent()

	{
		return this.logContent;
	}

	public ManagerTenantLogDto setLogContent(String arg) {
		this.logContent = arg;
		return this;
	}

	public String getLogIp()

	{
		return this.logIp;
	}

	public ManagerTenantLogDto setLogIp(String arg) {
		this.logIp = arg;
		return this;
	}

	public String getLogMachine()

	{
		return this.logMachine;
	}

	public ManagerTenantLogDto setLogMachine(String arg) {
		this.logMachine = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerTenantLogDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ManagerTenantLogDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerTenantLogDto fromDto(ManagerTenantLogDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ManagerTenantLogDto.class);
	}

}
