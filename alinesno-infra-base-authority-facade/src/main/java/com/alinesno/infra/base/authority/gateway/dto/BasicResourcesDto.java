package com.alinesno.infra.base.authority.gateway.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： basic_resources
 * 
 * @author LuoAnDong ${authorEmail}
 * @date 2023-08-04 19:24:37
 */
public class BasicResourcesDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "menuType"
	 */
	private String menuType;
	/**
	 * "openTarget"
	 */
	private String openTarget;
	/**
	 * "permission"
	 */
	private String permission;
	/**
	 * "permissionScript"
	 */
	private String permissionScript;
	/**
	 * "resourceIcon"
	 */
	private String resourceIcon;
	/**
	 * "resourceLink"
	 */
	private String resourceLink;
	/**
	 * "resourceName"
	 */
	private String resourceName;
	/**
	 * "resourceOrder"
	 */
	private Long resourceOrder;
	/**
	 * "resourceParent"
	 */
	private String resourceParent;

	// getter and setter
	public String getMenuType()

	{
		return this.menuType;
	}

	public BasicResourcesDto setMenuType(String arg) {
		this.menuType = arg;
		return this;
	}

	public String getOpenTarget()

	{
		return this.openTarget;
	}

	public BasicResourcesDto setOpenTarget(String arg) {
		this.openTarget = arg;
		return this;
	}

	public String getPermission()

	{
		return this.permission;
	}

	public BasicResourcesDto setPermission(String arg) {
		this.permission = arg;
		return this;
	}

	public String getPermissionScript()

	{
		return this.permissionScript;
	}

	public BasicResourcesDto setPermissionScript(String arg) {
		this.permissionScript = arg;
		return this;
	}

	public String getResourceIcon()

	{
		return this.resourceIcon;
	}

	public BasicResourcesDto setResourceIcon(String arg) {
		this.resourceIcon = arg;
		return this;
	}

	public String getResourceLink()

	{
		return this.resourceLink;
	}

	public BasicResourcesDto setResourceLink(String arg) {
		this.resourceLink = arg;
		return this;
	}

	public String getResourceName()

	{
		return this.resourceName;
	}

	public BasicResourcesDto setResourceName(String arg) {
		this.resourceName = arg;
		return this;
	}

	public Long getResourceOrder()

	{
		return this.resourceOrder;
	}

	public BasicResourcesDto setResourceOrder(Long arg) {
		this.resourceOrder = arg;
		return this;
	}

	public String getResourceParent()

	{
		return this.resourceParent;
	}

	public BasicResourcesDto setResourceParent(String arg) {
		this.resourceParent = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public BasicResourcesDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, BasicResourcesDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public BasicResourcesDto fromDto(BasicResourcesDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, BasicResourcesDto.class);
	}

}
