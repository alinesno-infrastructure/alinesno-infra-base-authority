package com.alinesno.infra.base.authority.api.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： info_address
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class InfoAddressDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "parentId"
	 */
	private Long parentId;
	/**
	 * "districtName"
	 */
	private String districtName;
	/**
	 * "shortName"
	 */
	private String shortName;
	/**
	 * "longitude"
	 */
	private BigDecimal longitude;
	/**
	 * "latitude"
	 */
	private BigDecimal latitude;
	/**
	 * "level"
	 */
	private Long level;
	/**
	 * "sort"
	 */
	private Long sort;
	/**
	 * "isDeleted"
	 */
	private Long isDeleted;
	/**
	 * "createTime"
	 */
	private Date createTime;

	// getter and setter
	public Long getParentId()

	{
		return this.parentId;
	}

	public InfoAddressDto setParentId(Long arg) {
		this.parentId = arg;
		return this;
	}

	public String getDistrictName()

	{
		return this.districtName;
	}

	public InfoAddressDto setDistrictName(String arg) {
		this.districtName = arg;
		return this;
	}

	public String getShortName()

	{
		return this.shortName;
	}

	public InfoAddressDto setShortName(String arg) {
		this.shortName = arg;
		return this;
	}

	public BigDecimal getLongitude()

	{
		return this.longitude;
	}

	public InfoAddressDto setLongitude(BigDecimal arg) {
		this.longitude = arg;
		return this;
	}

	public BigDecimal getLatitude()

	{
		return this.latitude;
	}

	public InfoAddressDto setLatitude(BigDecimal arg) {
		this.latitude = arg;
		return this;
	}

	public Long getLevel()

	{
		return this.level;
	}

	public InfoAddressDto setLevel(Long arg) {
		this.level = arg;
		return this;
	}

	public Long getSort()

	{
		return this.sort;
	}

	public InfoAddressDto setSort(Long arg) {
		this.sort = arg;
		return this;
	}

	public Long getIsDeleted()

	{
		return this.isDeleted;
	}

	public InfoAddressDto setIsDeleted(Long arg) {
		this.isDeleted = arg;
		return this;
	}

	public Date getCreateTime()

	{
		return this.createTime;
	}

	public InfoAddressDto setCreateTime(Date arg) {
		this.createTime = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public InfoAddressDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, InfoAddressDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public InfoAddressDto fromDto(InfoAddressDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, InfoAddressDto.class);
	}

}
