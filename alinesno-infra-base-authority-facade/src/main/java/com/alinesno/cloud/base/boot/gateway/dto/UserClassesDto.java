package com.alinesno.cloud.base.boot.gateway.dto;

import java.util.Date;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： user_classes
 * 
 * @author LuoAnDong ${authorEmail}
 * @date 2021-08-04 19:24:39
 */
public class UserClassesDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "classes"
	 */
	private String classes;
	/**
	 * "collgeName"
	 */
	private String collgeName;
	/**
	 * "education"
	 */
	private String education;
	/**
	 * "isUse"
	 */
	private String isUse;
	/**
	 * "owners"
	 */
	private String owners;
	/**
	 * "professionalName"
	 */
	private String professionalName;
	/**
	 * "schoolEndTime"
	 */
	private Date schoolEndTime;
	/**
	 * "schoolId"
	 */
	private String schoolId;
	/**
	 * "schoolName"
	 */
	private String schoolName;
	/**
	 * "schoolNum"
	 */
	private String schoolNum;
	/**
	 * "schoolStartTime"
	 */
	private Date schoolStartTime;
	/**
	 * "shoolJob"
	 */
	private String shoolJob;
	/**
	 * "useEndTime"
	 */
	private String useEndTime;
	/**
	 * "useStartTime"
	 */
	private String useStartTime;
	/**
	 * "userId"
	 */
	private String userId;

	// getter and setter
	public String getClasses()

	{
		return this.classes;
	}

	public UserClassesDto setClasses(String arg) {
		this.classes = arg;
		return this;
	}

	public String getCollgeName()

	{
		return this.collgeName;
	}

	public UserClassesDto setCollgeName(String arg) {
		this.collgeName = arg;
		return this;
	}

	public String getEducation()

	{
		return this.education;
	}

	public UserClassesDto setEducation(String arg) {
		this.education = arg;
		return this;
	}

	public String getIsUse()

	{
		return this.isUse;
	}

	public UserClassesDto setIsUse(String arg) {
		this.isUse = arg;
		return this;
	}

	public String getOwners()

	{
		return this.owners;
	}

	public UserClassesDto setOwners(String arg) {
		this.owners = arg;
		return this;
	}

	public String getProfessionalName()

	{
		return this.professionalName;
	}

	public UserClassesDto setProfessionalName(String arg) {
		this.professionalName = arg;
		return this;
	}

	public Date getSchoolEndTime()

	{
		return this.schoolEndTime;
	}

	public UserClassesDto setSchoolEndTime(Date arg) {
		this.schoolEndTime = arg;
		return this;
	}

	public String getSchoolId()

	{
		return this.schoolId;
	}

	public UserClassesDto setSchoolId(String arg) {
		this.schoolId = arg;
		return this;
	}

	public String getSchoolName()

	{
		return this.schoolName;
	}

	public UserClassesDto setSchoolName(String arg) {
		this.schoolName = arg;
		return this;
	}

	public String getSchoolNum()

	{
		return this.schoolNum;
	}

	public UserClassesDto setSchoolNum(String arg) {
		this.schoolNum = arg;
		return this;
	}

	public Date getSchoolStartTime()

	{
		return this.schoolStartTime;
	}

	public UserClassesDto setSchoolStartTime(Date arg) {
		this.schoolStartTime = arg;
		return this;
	}

	public String getShoolJob()

	{
		return this.shoolJob;
	}

	public UserClassesDto setShoolJob(String arg) {
		this.shoolJob = arg;
		return this;
	}

	public String getUseEndTime()

	{
		return this.useEndTime;
	}

	public UserClassesDto setUseEndTime(String arg) {
		this.useEndTime = arg;
		return this;
	}

	public String getUseStartTime()

	{
		return this.useStartTime;
	}

	public UserClassesDto setUseStartTime(String arg) {
		this.useStartTime = arg;
		return this;
	}

	public String getUserId()

	{
		return this.userId;
	}

	public UserClassesDto setUserId(String arg) {
		this.userId = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public UserClassesDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, UserClassesDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public UserClassesDto fromDto(UserClassesDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, UserClassesDto.class);
	}

}
