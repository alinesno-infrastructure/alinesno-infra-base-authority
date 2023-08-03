package com.alinesno.infra.base.authority.api.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： manager_resource
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ManagerResourceDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "menuType"
	 */
	private String menuType;
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
	 * "visible"
	 */
	private String visible;

	// getter and setter
	public String getMenuType()

	{
		return this.menuType;
	}

	public ManagerResourceDto setMenuType(String arg) {
		this.menuType = arg;
		return this;
	}

	public String getResourceIcon()

	{
		return this.resourceIcon;
	}

	public ManagerResourceDto setResourceIcon(String arg) {
		this.resourceIcon = arg;
		return this;
	}

	public String getResourceLink()

	{
		return this.resourceLink;
	}

	public ManagerResourceDto setResourceLink(String arg) {
		this.resourceLink = arg;
		return this;
	}

	public String getResourceName()

	{
		return this.resourceName;
	}

	public ManagerResourceDto setResourceName(String arg) {
		this.resourceName = arg;
		return this;
	}

	public Long getResourceOrder()

	{
		return this.resourceOrder;
	}

	public ManagerResourceDto setResourceOrder(Long arg) {
		this.resourceOrder = arg;
		return this;
	}

	public String getResourceParent()

	{
		return this.resourceParent;
	}

	public ManagerResourceDto setResourceParent(String arg) {
		this.resourceParent = arg;
		return this;
	}

	public String getOpenTarget()

	{
		return this.openTarget;
	}

	public ManagerResourceDto setOpenTarget(String arg) {
		this.openTarget = arg;
		return this;
	}

	public String getPermission()

	{
		return this.permission;
	}

	public ManagerResourceDto setPermission(String arg) {
		this.permission = arg;
		return this;
	}

	public String getPermissionScript()

	{
		return this.permissionScript;
	}

	public ManagerResourceDto setPermissionScript(String arg) {
		this.permissionScript = arg;
		return this;
	}

	public String getVisible()

	{
		return this.visible;
	}

	public ManagerResourceDto setVisible(String arg) {
		this.visible = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerResourceDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ManagerResourceDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerResourceDto fromDto(ManagerResourceDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ManagerResourceDto.class);
	}

}
