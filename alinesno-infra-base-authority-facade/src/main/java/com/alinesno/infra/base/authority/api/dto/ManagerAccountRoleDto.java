package com.alinesno.infra.base.authority.api.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： manager_account_role
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ManagerAccountRoleDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "accountId"
	 */
	private String accountId;
	/**
	 * "roleId"
	 */
	private String roleId;

	// getter and setter
	public String getAccountId()

	{
		return this.accountId;
	}

	public ManagerAccountRoleDto setAccountId(String arg) {
		this.accountId = arg;
		return this;
	}

	public String getRoleId()

	{
		return this.roleId;
	}

	public ManagerAccountRoleDto setRoleId(String arg) {
		this.roleId = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerAccountRoleDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ManagerAccountRoleDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerAccountRoleDto fromDto(ManagerAccountRoleDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ManagerAccountRoleDto.class);
	}

}
