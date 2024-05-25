package com.alinesno.infra.base.authority.gateway.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 * 功能名： 【请填写功能名称】 数据表： manager_project
 * 
 * @author luoxiaodong 
 * @version 1.0.0
 */
public class ManagerProjectDto extends BaseDto {

	// fields
	/**
	 * "projectDesc"
	 */
	@NotBlank(message = "应用描述为空")
	@Length(min = 4, max = 128, message = "应用描述最小长度为{min} 最大长度为{max}")
	private String projectDesc;

	@NotBlank(message = "应用名称为空")
	@Length(min = 4, max = 32, message = "应用名称最小长度为{min} 最大长度为{max}")
	private String projectName; // 应用名称，唯一性，用于做应用标识【最好与springboot的applicaiotn.name对应】

	/**
	 * "projectIcons"
	 */
	private String projectIcons;
	/**
	 * "父类Id"
	 */
	private String pid;
	/**
	 * "projectLink"
	 */
	private String projectLink;
	/**
	 * "projectCode"
	 */
	@NotBlank(message = "应用代码为空")
	@Length(min = 4, max = 40, message = "应用代码最小长度为{min} 最大长度为{max}")
	private String projectCode;

	public String getApplicationName() {
		return projectName;
	}

	public void setApplicationName(String projectName) {
		this.projectName = projectName;
	}

	// getter and setter
	public String getApplicationDesc()

	{
		return this.projectDesc;
	}

	public ManagerProjectDto setApplicationDesc(String arg) {
		this.projectDesc = arg;
		return this;
	}

	public String getApplicationIcons()

	{
		return this.projectIcons;
	}

	public ManagerProjectDto setApplicationIcons(String arg) {
		this.projectIcons = arg;
		return this;
	}

	public String getPid()

	{
		return this.pid;
	}

	public ManagerProjectDto setPid(String arg) {
		this.pid = arg;
		return this;
	}

	public String getApplicationLink()

	{
		return this.projectLink;
	}

	public ManagerProjectDto setApplicationLink(String arg) {
		this.projectLink = arg;
		return this;
	}

	public String getApplicationCode()

	{
		return this.projectCode;
	}

	public ManagerProjectDto setApplicationCode(String arg) {
		this.projectCode = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerProjectDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ManagerProjectDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerProjectDto fromDto(ManagerProjectDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ManagerProjectDto.class);
	}

}
