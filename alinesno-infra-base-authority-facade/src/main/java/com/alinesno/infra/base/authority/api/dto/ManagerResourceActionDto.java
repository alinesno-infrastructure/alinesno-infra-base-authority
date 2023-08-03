package com.alinesno.infra.base.authority.api.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： manager_resource_action
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ManagerResourceActionDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "resourceActionIcon"
	 */
	private String resourceActionIcon;
	/**
	 * "resourceActionMethod"
	 */
	private String resourceActionMethod;
	/**
	 * "resourceActionName"
	 */
	private String resourceActionName;
	/**
	 * "resourceActionOrder"
	 */
	private Long resourceActionOrder;
	/**
	 * "resourceActionStatus"
	 */
	private Integer resourceActionStatus;
	/**
	 * "resourceId"
	 */
	private String resourceId;

	// getter and setter
	public String getResourceActionIcon()

	{
		return this.resourceActionIcon;
	}

	public ManagerResourceActionDto setResourceActionIcon(String arg) {
		this.resourceActionIcon = arg;
		return this;
	}

	public String getResourceActionMethod()

	{
		return this.resourceActionMethod;
	}

	public ManagerResourceActionDto setResourceActionMethod(String arg) {
		this.resourceActionMethod = arg;
		return this;
	}

	public String getResourceActionName()

	{
		return this.resourceActionName;
	}

	public ManagerResourceActionDto setResourceActionName(String arg) {
		this.resourceActionName = arg;
		return this;
	}

	public Long getResourceActionOrder()

	{
		return this.resourceActionOrder;
	}

	public ManagerResourceActionDto setResourceActionOrder(Long arg) {
		this.resourceActionOrder = arg;
		return this;
	}

	public Integer getResourceActionStatus()

	{
		return this.resourceActionStatus;
	}

	public ManagerResourceActionDto setResourceActionStatus(Integer arg) {
		this.resourceActionStatus = arg;
		return this;
	}

	public String getResourceId()

	{
		return this.resourceId;
	}

	public ManagerResourceActionDto setResourceId(String arg) {
		this.resourceId = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerResourceActionDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ManagerResourceActionDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerResourceActionDto fromDto(ManagerResourceActionDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ManagerResourceActionDto.class);
	}

}
