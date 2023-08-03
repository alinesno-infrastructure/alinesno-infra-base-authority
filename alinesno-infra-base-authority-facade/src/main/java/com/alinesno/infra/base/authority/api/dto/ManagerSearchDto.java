package com.alinesno.infra.base.authority.api.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： manager_search
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ManagerSearchDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "defaultValue"
	 */
	private String defaultValue;
	/**
	 * "hasDate"
	 */
	private String hasDate;
	/**
	 * "optionJson"
	 */
	private String optionJson;
	/**
	 * "resourceId"
	 */
	private String resourceId;
	/**
	 * "searchType"
	 */
	private String searchType;
	/**
	 * "dict"
	 */
	private String dict;
	/**
	 * "searchScript"
	 */
	private String searchScript;

	// getter and setter
	public String getDefaultValue()

	{
		return this.defaultValue;
	}

	public ManagerSearchDto setDefaultValue(String arg) {
		this.defaultValue = arg;
		return this;
	}

	public String getHasDate()

	{
		return this.hasDate;
	}

	public ManagerSearchDto setHasDate(String arg) {
		this.hasDate = arg;
		return this;
	}

	public String getOptionJson()

	{
		return this.optionJson;
	}

	public ManagerSearchDto setOptionJson(String arg) {
		this.optionJson = arg;
		return this;
	}

	public String getResourceId()

	{
		return this.resourceId;
	}

	public ManagerSearchDto setResourceId(String arg) {
		this.resourceId = arg;
		return this;
	}

	public String getSearchType()

	{
		return this.searchType;
	}

	public ManagerSearchDto setSearchType(String arg) {
		this.searchType = arg;
		return this;
	}

	public String getDict()

	{
		return this.dict;
	}

	public ManagerSearchDto setDict(String arg) {
		this.dict = arg;
		return this;
	}

	public String getSearchScript()

	{
		return this.searchScript;
	}

	public ManagerSearchDto setSearchScript(String arg) {
		this.searchScript = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerSearchDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ManagerSearchDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerSearchDto fromDto(ManagerSearchDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ManagerSearchDto.class);
	}

}
