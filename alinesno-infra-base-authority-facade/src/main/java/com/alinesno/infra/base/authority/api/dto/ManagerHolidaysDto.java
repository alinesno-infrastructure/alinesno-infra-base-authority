package com.alinesno.infra.base.authority.api.dto;

import java.util.Date;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： manager_holidays
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ManagerHolidaysDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "holidays"
	 */
	private String holidays;
	/**
	 * "holidaysDate"
	 */
	private Date holidaysDate;

	// getter and setter
	public String getHolidays()

	{
		return this.holidays;
	}

	public ManagerHolidaysDto setHolidays(String arg) {
		this.holidays = arg;
		return this;
	}

	public Date getHolidaysDate()

	{
		return this.holidaysDate;
	}

	public ManagerHolidaysDto setHolidaysDate(Date arg) {
		this.holidaysDate = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerHolidaysDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ManagerHolidaysDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerHolidaysDto fromDto(ManagerHolidaysDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ManagerHolidaysDto.class);
	}

}
