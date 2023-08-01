package com.alinesno.infra.base.authority.gateway.dto;

import java.util.Date;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： user_calendar
 * 
 * @author LuoAnDong ${authorEmail}
 * @date 2021-08-04 19:24:39
 */
public class UserCalendarDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "用户id"
	 */
	private Long userId;
	/**
	 * "事务内容"
	 */
	private String titledetail;
	/**
	 * "标题"
	 */
	private String title;
	/**
	 * "全天"
	 */
	private Long allDay;
	/**
	 * "开始时间"
	 */
	private Date startDate;
	/**
	 * "结束时间"
	 */
	private Date endDate;
	/**
	 * "url"
	 */
	private String url;
	/**
	 * "类名"
	 */
	private String className;
	/**
	 * "编辑表内容"
	 */
	private String editTable;
	/**
	 * "来源"
	 */
	private String source;
	/**
	 * "扩展"
	 */
	private String extInfo;
	/**
	 * "事务类型(1.工作事务 2.个人事务)"
	 */
	private String transactionType;
	/**
	 * "参与者"
	 */
	private String participant;
	/**
	 * "重复类型(1.按天重复 2.按周重复 3.按月重复 4.按年重复 5.按工作日重复)"
	 */
	private Long repeaTypes;
	/**
	 * "重复时间"
	 */
	private Date echoTime;
	/**
	 * "状态(1.未进行 2.进行中 3.已完成 4.已超时)"
	 */
	private Long status;
	/**
	 * "titleDetail"
	 */
	private String titleDetail;

	// getter and setter
	public Long getUserId()

	{
		return this.userId;
	}

	public UserCalendarDto setUserId(Long arg) {
		this.userId = arg;
		return this;
	}

	public String getTitledetail()

	{
		return this.titledetail;
	}

	public UserCalendarDto setTitledetail(String arg) {
		this.titledetail = arg;
		return this;
	}

	public String getTitle()

	{
		return this.title;
	}

	public UserCalendarDto setTitle(String arg) {
		this.title = arg;
		return this;
	}

	public Long getAllDay()

	{
		return this.allDay;
	}

	public UserCalendarDto setAllDay(Long arg) {
		this.allDay = arg;
		return this;
	}

	public Date getStartDate()

	{
		return this.startDate;
	}

	public UserCalendarDto setStartDate(Date arg) {
		this.startDate = arg;
		return this;
	}

	public Date getEndDate()

	{
		return this.endDate;
	}

	public UserCalendarDto setEndDate(Date arg) {
		this.endDate = arg;
		return this;
	}

	public String getUrl()

	{
		return this.url;
	}

	public UserCalendarDto setUrl(String arg) {
		this.url = arg;
		return this;
	}

	public String getClassName()

	{
		return this.className;
	}

	public UserCalendarDto setClassName(String arg) {
		this.className = arg;
		return this;
	}

	public String getEditTable()

	{
		return this.editTable;
	}

	public UserCalendarDto setEditTable(String arg) {
		this.editTable = arg;
		return this;
	}

	public String getSource()

	{
		return this.source;
	}

	public UserCalendarDto setSource(String arg) {
		this.source = arg;
		return this;
	}

	public String getExtInfo()

	{
		return this.extInfo;
	}

	public UserCalendarDto setExtInfo(String arg) {
		this.extInfo = arg;
		return this;
	}

	public String getTransactionType()

	{
		return this.transactionType;
	}

	public UserCalendarDto setTransactionType(String arg) {
		this.transactionType = arg;
		return this;
	}

	public String getParticipant()

	{
		return this.participant;
	}

	public UserCalendarDto setParticipant(String arg) {
		this.participant = arg;
		return this;
	}

	public Long getRepeaTypes()

	{
		return this.repeaTypes;
	}

	public UserCalendarDto setRepeaTypes(Long arg) {
		this.repeaTypes = arg;
		return this;
	}

	public Date getEchoTime()

	{
		return this.echoTime;
	}

	public UserCalendarDto setEchoTime(Date arg) {
		this.echoTime = arg;
		return this;
	}

	public Long getStatus()

	{
		return this.status;
	}

	public UserCalendarDto setStatus(Long arg) {
		this.status = arg;
		return this;
	}

	public String getTitleDetail()

	{
		return this.titleDetail;
	}

	public UserCalendarDto setTitleDetail(String arg) {
		this.titleDetail = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public UserCalendarDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, UserCalendarDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public UserCalendarDto fromDto(UserCalendarDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, UserCalendarDto.class);
	}

}
