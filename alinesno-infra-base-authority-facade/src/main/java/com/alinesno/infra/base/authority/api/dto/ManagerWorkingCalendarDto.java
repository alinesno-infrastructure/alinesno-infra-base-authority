package com.alinesno.infra.base.authority.api.dto;

import java.util.Date;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： manager_working_calendar
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ManagerWorkingCalendarDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "workingStartTime"
	 */
	private Date workingStartTime;
	/**
	 * "workingContent"
	 */
	private String workingContent;
	/**
	 * "workingEndTime"
	 */
	private Date workingEndTime;
	/**
	 * "workingType"
	 */
	private String workingType;

	// getter and setter
	public Date getWorkingStartTime()

	{
		return this.workingStartTime;
	}

	public ManagerWorkingCalendarDto setWorkingStartTime(Date arg) {
		this.workingStartTime = arg;
		return this;
	}

	public String getWorkingContent()

	{
		return this.workingContent;
	}

	public ManagerWorkingCalendarDto setWorkingContent(String arg) {
		this.workingContent = arg;
		return this;
	}

	public Date getWorkingEndTime()

	{
		return this.workingEndTime;
	}

	public ManagerWorkingCalendarDto setWorkingEndTime(Date arg) {
		this.workingEndTime = arg;
		return this;
	}

	public String getWorkingType()

	{
		return this.workingType;
	}

	public ManagerWorkingCalendarDto setWorkingType(String arg) {
		this.workingType = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerWorkingCalendarDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ManagerWorkingCalendarDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerWorkingCalendarDto fromDto(ManagerWorkingCalendarDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ManagerWorkingCalendarDto.class);
	}

}
