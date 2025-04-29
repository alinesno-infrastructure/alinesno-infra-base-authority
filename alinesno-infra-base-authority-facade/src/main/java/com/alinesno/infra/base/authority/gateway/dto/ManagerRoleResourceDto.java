package com.alinesno.infra.base.authority.gateway.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 功能名： 【请填写功能名称】 数据表： manager_role_resource
 * 
 * @author luoxiaodong 
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ManagerRoleResourceDto extends BaseDto {
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
