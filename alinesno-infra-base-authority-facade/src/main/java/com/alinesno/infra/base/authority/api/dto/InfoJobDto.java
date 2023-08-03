package com.alinesno.infra.base.authority.api.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： info_job
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class InfoJobDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "jobName"
	 */
	private String jobName;
	/**
	 * "jobParent"
	 */
	private String jobParent;
	/**
	 * "jobType"
	 */
	private String jobType;
	/**
	 * "owners"
	 */
	private String owners;

	// getter and setter
	public String getJobName()

	{
		return this.jobName;
	}

	public InfoJobDto setJobName(String arg) {
		this.jobName = arg;
		return this;
	}

	public String getJobParent()

	{
		return this.jobParent;
	}

	public InfoJobDto setJobParent(String arg) {
		this.jobParent = arg;
		return this;
	}

	public String getJobType()

	{
		return this.jobType;
	}

	public InfoJobDto setJobType(String arg) {
		this.jobType = arg;
		return this;
	}

	public String getOwners()

	{
		return this.owners;
	}

	public InfoJobDto setOwners(String arg) {
		this.owners = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public InfoJobDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, InfoJobDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public InfoJobDto fromDto(InfoJobDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, InfoJobDto.class);
	}

}
