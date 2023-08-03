package com.alinesno.infra.base.authority.api.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： manager_department
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ManagerDepartmentDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "pid"
	 */
	private String pid;
	/**
	 * "pids"
	 */
	private String pids;
	/**
	 * "simpleName"
	 */
	private String simpleName;
	/**
	 * "fullName"
	 */
	private String fullName;
	/**
	 * "versions"
	 */
	private Long versions;
	/**
	 * "sort"
	 */
	private Long sort;
	/**
	 * "description"
	 */
	private String description;

	// getter and setter
	public String getPid()

	{
		return this.pid;
	}

	public ManagerDepartmentDto setPid(String arg) {
		this.pid = arg;
		return this;
	}

	public String getPids()

	{
		return this.pids;
	}

	public ManagerDepartmentDto setPids(String arg) {
		this.pids = arg;
		return this;
	}

	public String getSimpleName()

	{
		return this.simpleName;
	}

	public ManagerDepartmentDto setSimpleName(String arg) {
		this.simpleName = arg;
		return this;
	}

	public String getFullName()

	{
		return this.fullName;
	}

	public ManagerDepartmentDto setFullName(String arg) {
		this.fullName = arg;
		return this;
	}

	public Long getVersions()

	{
		return this.versions;
	}

	public ManagerDepartmentDto setVersions(Long arg) {
		this.versions = arg;
		return this;
	}

	public Long getSort()

	{
		return this.sort;
	}

	public ManagerDepartmentDto setSort(Long arg) {
		this.sort = arg;
		return this;
	}

	public String getDescription()

	{
		return this.description;
	}

	public ManagerDepartmentDto setDescription(String arg) {
		this.description = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerDepartmentDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ManagerDepartmentDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerDepartmentDto fromDto(ManagerDepartmentDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ManagerDepartmentDto.class);
	}

}
