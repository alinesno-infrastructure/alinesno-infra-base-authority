package com.alinesno.infra.base.authority.api.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： info_school
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class InfoSchoolDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "owners"
	 */
	private String owners;
	/**
	 * "schoolAddress"
	 */
	private String schoolAddress;
	/**
	 * "schoolCode"
	 */
	private String schoolCode;
	/**
	 * "schoolName"
	 */
	private String schoolName;
	/**
	 * "schoolOwner"
	 */
	private String schoolOwner;
	/**
	 * "schoolOwnerCode"
	 */
	private String schoolOwnerCode;
	/**
	 * "schoolProperties"
	 */
	private String schoolProperties;
	/**
	 * "schoolPropertiesCode"
	 */
	private String schoolPropertiesCode;
	/**
	 * "schoolProvince"
	 */
	private String schoolProvince;
	/**
	 * "schoolProvinceCode"
	 */
	private String schoolProvinceCode;
	/**
	 * "schoolType"
	 */
	private String schoolType;
	/**
	 * "schoolTypeName"
	 */
	private String schoolTypeName;

	// getter and setter
	public String getOwners()

	{
		return this.owners;
	}

	public InfoSchoolDto setOwners(String arg) {
		this.owners = arg;
		return this;
	}

	public String getSchoolAddress()

	{
		return this.schoolAddress;
	}

	public InfoSchoolDto setSchoolAddress(String arg) {
		this.schoolAddress = arg;
		return this;
	}

	public String getSchoolCode()

	{
		return this.schoolCode;
	}

	public InfoSchoolDto setSchoolCode(String arg) {
		this.schoolCode = arg;
		return this;
	}

	public String getSchoolName()

	{
		return this.schoolName;
	}

	public InfoSchoolDto setSchoolName(String arg) {
		this.schoolName = arg;
		return this;
	}

	public String getSchoolOwner()

	{
		return this.schoolOwner;
	}

	public InfoSchoolDto setSchoolOwner(String arg) {
		this.schoolOwner = arg;
		return this;
	}

	public String getSchoolOwnerCode()

	{
		return this.schoolOwnerCode;
	}

	public InfoSchoolDto setSchoolOwnerCode(String arg) {
		this.schoolOwnerCode = arg;
		return this;
	}

	public String getSchoolProperties()

	{
		return this.schoolProperties;
	}

	public InfoSchoolDto setSchoolProperties(String arg) {
		this.schoolProperties = arg;
		return this;
	}

	public String getSchoolPropertiesCode()

	{
		return this.schoolPropertiesCode;
	}

	public InfoSchoolDto setSchoolPropertiesCode(String arg) {
		this.schoolPropertiesCode = arg;
		return this;
	}

	public String getSchoolProvince()

	{
		return this.schoolProvince;
	}

	public InfoSchoolDto setSchoolProvince(String arg) {
		this.schoolProvince = arg;
		return this;
	}

	public String getSchoolProvinceCode()

	{
		return this.schoolProvinceCode;
	}

	public InfoSchoolDto setSchoolProvinceCode(String arg) {
		this.schoolProvinceCode = arg;
		return this;
	}

	public String getSchoolType()

	{
		return this.schoolType;
	}

	public InfoSchoolDto setSchoolType(String arg) {
		this.schoolType = arg;
		return this;
	}

	public String getSchoolTypeName()

	{
		return this.schoolTypeName;
	}

	public InfoSchoolDto setSchoolTypeName(String arg) {
		this.schoolTypeName = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public InfoSchoolDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, InfoSchoolDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public InfoSchoolDto fromDto(InfoSchoolDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, InfoSchoolDto.class);
	}

}
