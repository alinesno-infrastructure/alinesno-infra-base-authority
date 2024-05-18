package com.alinesno.infra.base.authority.gateway.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;

/**
 * 功能名： 【请填写功能名称】 数据表： manager_group
 * 
 * @author luoxiaodong 
 * @version 1.0.0
 */
public class ManagerGroupDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "cityId"
	 */
	private String cityId;
	/**
	 * "endTime"
	 */
	private Date endTime;
	/**
	 * "provinceId"
	 */
	private String provinceId;
	/**
	 * "startTime"
	 */
	private Date startTime;
	/**
	 * "groupAccount"
	 */
	private String groupAccount;
	/**
	 * "groupAddress"
	 */
	private String groupAddress;
	/**
	 * "groupCost"
	 */
	private Long groupCost;
	/**
	 * "groupName"
	 */
	private String groupName;
	/**
	 * "groupPhone"
	 */
	private String groupPhone;
	/**
	 * "groupStatus"
	 */
	private String groupStatus;

	// getter and setter
	public String getCityId()

	{
		return this.cityId;
	}

	public ManagerGroupDto setCityId(String arg) {
		this.cityId = arg;
		return this;
	}

	public Date getEndTime()

	{
		return this.endTime;
	}

	public ManagerGroupDto setEndTime(Date arg) {
		this.endTime = arg;
		return this;
	}

	public String getProvinceId()

	{
		return this.provinceId;
	}

	public ManagerGroupDto setProvinceId(String arg) {
		this.provinceId = arg;
		return this;
	}

	public Date getStartTime()

	{
		return this.startTime;
	}

	public ManagerGroupDto setStartTime(Date arg) {
		this.startTime = arg;
		return this;
	}

	public String getTenantAccount()

	{
		return this.groupAccount;
	}

	public ManagerGroupDto setTenantAccount(String arg) {
		this.groupAccount = arg;
		return this;
	}

	public String getTenantAddress()

	{
		return this.groupAddress;
	}

	public ManagerGroupDto setTenantAddress(String arg) {
		this.groupAddress = arg;
		return this;
	}

	public Long getTenantCost()

	{
		return this.groupCost;
	}

	public ManagerGroupDto setTenantCost(Long arg) {
		this.groupCost = arg;
		return this;
	}

	public String getTenantName()

	{
		return this.groupName;
	}

	public ManagerGroupDto setTenantName(String arg) {
		this.groupName = arg;
		return this;
	}

	public String getTenantPhone()

	{
		return this.groupPhone;
	}

	public ManagerGroupDto setTenantPhone(String arg) {
		this.groupPhone = arg;
		return this;
	}

	public String getTenantStatus()

	{
		return this.groupStatus;
	}

	public ManagerGroupDto setTenantStatus(String arg) {
		this.groupStatus = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerGroupDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ManagerGroupDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerGroupDto fromDto(ManagerGroupDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ManagerGroupDto.class);
	}

}
