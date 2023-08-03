package com.alinesno.infra.base.authority.api.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： manager_role
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ManagerRoleDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "roleStatus"
	 */
	private Long roleStatus;
	/**
	 * "roleTitle"
	 */
	private String roleTitle;
	/**
	 * "roleName"
	 */
	private String roleName;
	/**
	 * "roleDesc"
	 */
	private String roleDesc;

	// getter and setter
	public Long getRoleStatus()

	{
		return this.roleStatus;
	}

	public ManagerRoleDto setRoleStatus(Long arg) {
		this.roleStatus = arg;
		return this;
	}

	public String getRoleTitle()

	{
		return this.roleTitle;
	}

	public ManagerRoleDto setRoleTitle(String arg) {
		this.roleTitle = arg;
		return this;
	}

	public String getRoleName()

	{
		return this.roleName;
	}

	public ManagerRoleDto setRoleName(String arg) {
		this.roleName = arg;
		return this;
	}

	public String getRoleDesc()

	{
		return this.roleDesc;
	}

	public ManagerRoleDto setRoleDesc(String arg) {
		this.roleDesc = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerRoleDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ManagerRoleDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerRoleDto fromDto(ManagerRoleDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ManagerRoleDto.class);
	}

}
