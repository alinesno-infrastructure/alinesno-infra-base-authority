package com.alinesno.infra.base.authority.api.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： sys_oper_log
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class SysOperLogDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "agent"
	 */
	private String agent;
	/**
	 * "contractNumber"
	 */
	private String contractNumber;
	/**
	 * "dataId"
	 */
	private String dataId;
	/**
	 * "flowTaskId"
	 */
	private String flowTaskId;
	/**
	 * "ip"
	 */
	private String ip;
	/**
	 * "methodDesc"
	 */
	private String methodDesc;
	/**
	 * "operContent"
	 */
	private String operContent;
	/**
	 * "operOpinion"
	 */
	private String operOpinion;
	/**
	 * "operStatus"
	 */
	private String operStatus;
	/**
	 * "operTime"
	 */
	private Long operTime;
	/**
	 * "operUserId"
	 */
	private String operUserId;
	/**
	 * "operUserName"
	 */
	private String operUserName;
	/**
	 * "params"
	 */
	private String params;
	/**
	 * "recordType"
	 */
	private String recordType;
	/**
	 * "url"
	 */
	private String url;

	// getter and setter
	public String getAgent()

	{
		return this.agent;
	}

	public SysOperLogDto setAgent(String arg) {
		this.agent = arg;
		return this;
	}

	public String getContractNumber()

	{
		return this.contractNumber;
	}

	public SysOperLogDto setContractNumber(String arg) {
		this.contractNumber = arg;
		return this;
	}

	public String getDataId()

	{
		return this.dataId;
	}

	public SysOperLogDto setDataId(String arg) {
		this.dataId = arg;
		return this;
	}

	public String getFlowTaskId()

	{
		return this.flowTaskId;
	}

	public SysOperLogDto setFlowTaskId(String arg) {
		this.flowTaskId = arg;
		return this;
	}

	public String getIp()

	{
		return this.ip;
	}

	public SysOperLogDto setIp(String arg) {
		this.ip = arg;
		return this;
	}

	public String getMethodDesc()

	{
		return this.methodDesc;
	}

	public SysOperLogDto setMethodDesc(String arg) {
		this.methodDesc = arg;
		return this;
	}

	public String getOperContent()

	{
		return this.operContent;
	}

	public SysOperLogDto setOperContent(String arg) {
		this.operContent = arg;
		return this;
	}

	public String getOperOpinion()

	{
		return this.operOpinion;
	}

	public SysOperLogDto setOperOpinion(String arg) {
		this.operOpinion = arg;
		return this;
	}

	public String getOperStatus()

	{
		return this.operStatus;
	}

	public SysOperLogDto setOperStatus(String arg) {
		this.operStatus = arg;
		return this;
	}

	public Long getOperTime()

	{
		return this.operTime;
	}

	public SysOperLogDto setOperTime(Long arg) {
		this.operTime = arg;
		return this;
	}

	public String getOperUserId()

	{
		return this.operUserId;
	}

	public SysOperLogDto setOperUserId(String arg) {
		this.operUserId = arg;
		return this;
	}

	public String getOperUserName()

	{
		return this.operUserName;
	}

	public SysOperLogDto setOperUserName(String arg) {
		this.operUserName = arg;
		return this;
	}

	public String getParams()

	{
		return this.params;
	}

	public SysOperLogDto setParams(String arg) {
		this.params = arg;
		return this;
	}

	public String getRecordType()

	{
		return this.recordType;
	}

	public SysOperLogDto setRecordType(String arg) {
		this.recordType = arg;
		return this;
	}

	public String getUrl()

	{
		return this.url;
	}

	public SysOperLogDto setUrl(String arg) {
		this.url = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public SysOperLogDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, SysOperLogDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public SysOperLogDto fromDto(SysOperLogDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, SysOperLogDto.class);
	}

}
