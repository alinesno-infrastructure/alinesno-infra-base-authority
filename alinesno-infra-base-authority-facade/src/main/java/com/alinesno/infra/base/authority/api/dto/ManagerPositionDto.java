package com.alinesno.infra.base.authority.api.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： manager_position
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ManagerPositionDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "岗位名称"
	 */
	private String positionName;
	/**
	 * "岗位级别"
	 */
	private String positionRank;

	// getter and setter
	public String getPositionName()

	{
		return this.positionName;
	}

	public ManagerPositionDto setPositionName(String arg) {
		this.positionName = arg;
		return this;
	}

	public String getPositionRank()

	{
		return this.positionRank;
	}

	public ManagerPositionDto setPositionRank(String arg) {
		this.positionRank = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerPositionDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ManagerPositionDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerPositionDto fromDto(ManagerPositionDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ManagerPositionDto.class);
	}

}
