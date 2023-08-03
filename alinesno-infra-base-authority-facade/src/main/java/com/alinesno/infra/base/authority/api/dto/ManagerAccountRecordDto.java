package com.alinesno.infra.base.authority.api.dto;

import java.util.Date;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： manager_account_record
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ManagerAccountRecordDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "accountId"
	 */
	private String accountId;
	/**
	 * "accountName"
	 */
	private String accountName;
	/**
	 * "agent"
	 */
	private String agent;
	/**
	 * "createTime"
	 */
	private Date createTime;
	/**
	 * "ip"
	 */
	private String ip;
	/**
	 * "loginName"
	 */
	private String loginName;
	/**
	 * "method"
	 */
	private String method;
	/**
	 * "methodDesc"
	 */
	private String methodDesc;
	/**
	 * "methodTime"
	 */
	private Long methodTime;
	/**
	 * "operation"
	 */
	private String operation;
	/**
	 * "params"
	 */
	private String params;
	/**
	 * "rolePower"
	 */
	private String rolePower;
	/**
	 * "url"
	 */
	private String url;
	/**
	 * "recordType"
	 */
	private String recordType;

	// getter and setter
	public String getAccountId()

	{
		return this.accountId;
	}

	public ManagerAccountRecordDto setAccountId(String arg) {
		this.accountId = arg;
		return this;
	}

	public String getAccountName()

	{
		return this.accountName;
	}

	public ManagerAccountRecordDto setAccountName(String arg) {
		this.accountName = arg;
		return this;
	}

	public String getAgent()

	{
		return this.agent;
	}

	public ManagerAccountRecordDto setAgent(String arg) {
		this.agent = arg;
		return this;
	}

	public Date getCreateTime()

	{
		return this.createTime;
	}

	public ManagerAccountRecordDto setCreateTime(Date arg) {
		this.createTime = arg;
		return this;
	}

	public String getIp()

	{
		return this.ip;
	}

	public ManagerAccountRecordDto setIp(String arg) {
		this.ip = arg;
		return this;
	}

	public String getLoginName()

	{
		return this.loginName;
	}

	public ManagerAccountRecordDto setLoginName(String arg) {
		this.loginName = arg;
		return this;
	}

	public String getMethod()

	{
		return this.method;
	}

	public ManagerAccountRecordDto setMethod(String arg) {
		this.method = arg;
		return this;
	}

	public String getMethodDesc()

	{
		return this.methodDesc;
	}

	public ManagerAccountRecordDto setMethodDesc(String arg) {
		this.methodDesc = arg;
		return this;
	}

	public Long getMethodTime()

	{
		return this.methodTime;
	}

	public ManagerAccountRecordDto setMethodTime(Long arg) {
		this.methodTime = arg;
		return this;
	}

	public String getOperation()

	{
		return this.operation;
	}

	public ManagerAccountRecordDto setOperation(String arg) {
		this.operation = arg;
		return this;
	}

	public String getParams()

	{
		return this.params;
	}

	public ManagerAccountRecordDto setParams(String arg) {
		this.params = arg;
		return this;
	}

	public String getRolePower()

	{
		return this.rolePower;
	}

	public ManagerAccountRecordDto setRolePower(String arg) {
		this.rolePower = arg;
		return this;
	}

	public String getUrl()

	{
		return this.url;
	}

	public ManagerAccountRecordDto setUrl(String arg) {
		this.url = arg;
		return this;
	}

	public String getRecordType()

	{
		return this.recordType;
	}

	public ManagerAccountRecordDto setRecordType(String arg) {
		this.recordType = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerAccountRecordDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ManagerAccountRecordDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerAccountRecordDto fromDto(ManagerAccountRecordDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ManagerAccountRecordDto.class);
	}

}
