package com.alinesno.infra.base.authority.api.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： manager_role_resource
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ManagerRoleResourceDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "resourceId"
	 */
	private String resourceId;
	/**
	 * "resourceType"
	 */
	private String resourceType;
	/**
	 * "roleId"
	 */
	private String roleId;
	/**
	 * "roleType"
	 */
	private String roleType;

	// getter and setter
	public String getResourceId()

	{
		return this.resourceId;
	}

	public ManagerRoleResourceDto setResourceId(String arg) {
		this.resourceId = arg;
		return this;
	}

	public String getResourceType()

	{
		return this.resourceType;
	}

	public ManagerRoleResourceDto setResourceType(String arg) {
		this.resourceType = arg;
		return this;
	}

	public String getRoleId()

	{
		return this.roleId;
	}

	public ManagerRoleResourceDto setRoleId(String arg) {
		this.roleId = arg;
		return this;
	}

	public String getRoleType()

	{
		return this.roleType;
	}

	public ManagerRoleResourceDto setRoleType(String arg) {
		this.roleType = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerRoleResourceDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ManagerRoleResourceDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerRoleResourceDto fromDto(ManagerRoleResourceDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ManagerRoleResourceDto.class);
	}

}
