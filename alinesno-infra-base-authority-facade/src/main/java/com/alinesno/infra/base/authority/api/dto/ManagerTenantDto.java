package com.alinesno.infra.base.authority.api.dto;

import java.util.Date;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： manager_tenant
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ManagerTenantDto extends BaseDto {
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
	 * "tenantAccount"
	 */
	private String tenantAccount;
	/**
	 * "tenantAddress"
	 */
	private String tenantAddress;
	/**
	 * "tenantCost"
	 */
	private Long tenantCost;
	/**
	 * "tenantName"
	 */
	private String tenantName;
	/**
	 * "tenantPhone"
	 */
	private String tenantPhone;
	/**
	 * "tenantStatus"
	 */
	private String tenantStatus;

	// getter and setter
	public String getCityId()

	{
		return this.cityId;
	}

	public ManagerTenantDto setCityId(String arg) {
		this.cityId = arg;
		return this;
	}

	public Date getEndTime()

	{
		return this.endTime;
	}

	public ManagerTenantDto setEndTime(Date arg) {
		this.endTime = arg;
		return this;
	}

	public String getProvinceId()

	{
		return this.provinceId;
	}

	public ManagerTenantDto setProvinceId(String arg) {
		this.provinceId = arg;
		return this;
	}

	public Date getStartTime()

	{
		return this.startTime;
	}

	public ManagerTenantDto setStartTime(Date arg) {
		this.startTime = arg;
		return this;
	}

	public String getTenantAccount()

	{
		return this.tenantAccount;
	}

	public ManagerTenantDto setTenantAccount(String arg) {
		this.tenantAccount = arg;
		return this;
	}

	public String getTenantAddress()

	{
		return this.tenantAddress;
	}

	public ManagerTenantDto setTenantAddress(String arg) {
		this.tenantAddress = arg;
		return this;
	}

	public Long getTenantCost()

	{
		return this.tenantCost;
	}

	public ManagerTenantDto setTenantCost(Long arg) {
		this.tenantCost = arg;
		return this;
	}

	public String getTenantName()

	{
		return this.tenantName;
	}

	public ManagerTenantDto setTenantName(String arg) {
		this.tenantName = arg;
		return this;
	}

	public String getTenantPhone()

	{
		return this.tenantPhone;
	}

	public ManagerTenantDto setTenantPhone(String arg) {
		this.tenantPhone = arg;
		return this;
	}

	public String getTenantStatus()

	{
		return this.tenantStatus;
	}

	public ManagerTenantDto setTenantStatus(String arg) {
		this.tenantStatus = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerTenantDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ManagerTenantDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerTenantDto fromDto(ManagerTenantDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ManagerTenantDto.class);
	}

}
