package com.alinesno.infra.base.authority.api.dto;

import java.util.Date;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： manager_template
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ManagerTemplateDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "resourceId"
	 */
	private String resourceId;
	/**
	 * "templateAddtime"
	 */
	private Date templateAddtime;
	/**
	 * "templateContent"
	 */
	private String templateContent;
	/**
	 * "templateData"
	 */
	private String templateData;
	/**
	 * "templateName"
	 */
	private String templateName;
	/**
	 * "templateOwner"
	 */
	private String templateOwner;
	/**
	 * "templateStatus"
	 */
	private String templateStatus;

	// getter and setter
	public String getResourceId()

	{
		return this.resourceId;
	}

	public ManagerTemplateDto setResourceId(String arg) {
		this.resourceId = arg;
		return this;
	}

	public Date getTemplateAddtime()

	{
		return this.templateAddtime;
	}

	public ManagerTemplateDto setTemplateAddtime(Date arg) {
		this.templateAddtime = arg;
		return this;
	}

	public String getTemplateContent()

	{
		return this.templateContent;
	}

	public ManagerTemplateDto setTemplateContent(String arg) {
		this.templateContent = arg;
		return this;
	}

	public String getTemplateData()

	{
		return this.templateData;
	}

	public ManagerTemplateDto setTemplateData(String arg) {
		this.templateData = arg;
		return this;
	}

	public String getTemplateName()

	{
		return this.templateName;
	}

	public ManagerTemplateDto setTemplateName(String arg) {
		this.templateName = arg;
		return this;
	}

	public String getTemplateOwner()

	{
		return this.templateOwner;
	}

	public ManagerTemplateDto setTemplateOwner(String arg) {
		this.templateOwner = arg;
		return this;
	}

	public String getTemplateStatus()

	{
		return this.templateStatus;
	}

	public ManagerTemplateDto setTemplateStatus(String arg) {
		this.templateStatus = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerTemplateDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ManagerTemplateDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerTemplateDto fromDto(ManagerTemplateDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ManagerTemplateDto.class);
	}

}
