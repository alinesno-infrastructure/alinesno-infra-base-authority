package com.alinesno.infra.base.authority.api.dto;

import java.util.Date;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： message_remind
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class MessageRemindDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "eventName"
	 */
	private String eventName;
	/**
	 * "reminderDate"
	 */
	private Date reminderDate;
	/**
	 * "reminders"
	 */
	private String reminders;
	/**
	 * "warningDate"
	 */
	private Date warningDate;

	// getter and setter
	public String getEventName()

	{
		return this.eventName;
	}

	public MessageRemindDto setEventName(String arg) {
		this.eventName = arg;
		return this;
	}

	public Date getReminderDate()

	{
		return this.reminderDate;
	}

	public MessageRemindDto setReminderDate(Date arg) {
		this.reminderDate = arg;
		return this;
	}

	public String getReminders()

	{
		return this.reminders;
	}

	public MessageRemindDto setReminders(String arg) {
		this.reminders = arg;
		return this;
	}

	public Date getWarningDate()

	{
		return this.warningDate;
	}

	public MessageRemindDto setWarningDate(Date arg) {
		this.warningDate = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public MessageRemindDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, MessageRemindDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public MessageRemindDto fromDto(MessageRemindDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, MessageRemindDto.class);
	}

}
