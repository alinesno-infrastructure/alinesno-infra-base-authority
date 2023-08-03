package com.alinesno.infra.base.authority.api.dto;

import java.util.Date;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： content_notice
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ContentNoticeDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "noticeAuthor"
	 */
	private String noticeAuthor;
	/**
	 * "noticeContent"
	 */
	private String noticeContent;
	/**
	 * "noticeDate"
	 */
	private Date noticeDate;
	/**
	 * "noticeModifield"
	 */
	private Date noticeModifield;
	/**
	 * "noticeName"
	 */
	private String noticeName;
	/**
	 * "noticePassword"
	 */
	private String noticePassword;
	/**
	 * "noticeStatus"
	 */
	private Long noticeStatus;
	/**
	 * "noticeTitle"
	 */
	private String noticeTitle;
	/**
	 * "noticeType"
	 */
	private String noticeType;

	// getter and setter
	public String getNoticeAuthor()

	{
		return this.noticeAuthor;
	}

	public ContentNoticeDto setNoticeAuthor(String arg) {
		this.noticeAuthor = arg;
		return this;
	}

	public String getNoticeContent()

	{
		return this.noticeContent;
	}

	public ContentNoticeDto setNoticeContent(String arg) {
		this.noticeContent = arg;
		return this;
	}

	public Date getNoticeDate()

	{
		return this.noticeDate;
	}

	public ContentNoticeDto setNoticeDate(Date arg) {
		this.noticeDate = arg;
		return this;
	}

	public Date getNoticeModifield()

	{
		return this.noticeModifield;
	}

	public ContentNoticeDto setNoticeModifield(Date arg) {
		this.noticeModifield = arg;
		return this;
	}

	public String getNoticeName()

	{
		return this.noticeName;
	}

	public ContentNoticeDto setNoticeName(String arg) {
		this.noticeName = arg;
		return this;
	}

	public String getNoticePassword()

	{
		return this.noticePassword;
	}

	public ContentNoticeDto setNoticePassword(String arg) {
		this.noticePassword = arg;
		return this;
	}

	public Long getNoticeStatus()

	{
		return this.noticeStatus;
	}

	public ContentNoticeDto setNoticeStatus(Long arg) {
		this.noticeStatus = arg;
		return this;
	}

	public String getNoticeTitle()

	{
		return this.noticeTitle;
	}

	public ContentNoticeDto setNoticeTitle(String arg) {
		this.noticeTitle = arg;
		return this;
	}

	public String getNoticeType()

	{
		return this.noticeType;
	}

	public ContentNoticeDto setNoticeType(String arg) {
		this.noticeType = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ContentNoticeDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ContentNoticeDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ContentNoticeDto fromDto(ContentNoticeDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ContentNoticeDto.class);
	}

}
