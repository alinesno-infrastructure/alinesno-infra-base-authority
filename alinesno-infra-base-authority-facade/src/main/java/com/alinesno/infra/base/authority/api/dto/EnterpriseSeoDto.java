package com.alinesno.infra.base.authority.api.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： enterprise_seo
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class EnterpriseSeoDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "seoDescription"
	 */
	private String seoDescription;
	/**
	 * "seoKeyword"
	 */
	private String seoKeyword;
	/**
	 * "seoTitle"
	 */
	private String seoTitle;
	/**
	 * "siteLanguage"
	 */
	private String siteLanguage;
	/**
	 * "siteName"
	 */
	private String siteName;
	/**
	 * "sitePath"
	 */
	private String sitePath;
	/**
	 * "configName"
	 */
	private String configName;

	// getter and setter
	public String getSeoDescription()

	{
		return this.seoDescription;
	}

	public EnterpriseSeoDto setSeoDescription(String arg) {
		this.seoDescription = arg;
		return this;
	}

	public String getSeoKeyword()

	{
		return this.seoKeyword;
	}

	public EnterpriseSeoDto setSeoKeyword(String arg) {
		this.seoKeyword = arg;
		return this;
	}

	public String getSeoTitle()

	{
		return this.seoTitle;
	}

	public EnterpriseSeoDto setSeoTitle(String arg) {
		this.seoTitle = arg;
		return this;
	}

	public String getSiteLanguage()

	{
		return this.siteLanguage;
	}

	public EnterpriseSeoDto setSiteLanguage(String arg) {
		this.siteLanguage = arg;
		return this;
	}

	public String getSiteName()

	{
		return this.siteName;
	}

	public EnterpriseSeoDto setSiteName(String arg) {
		this.siteName = arg;
		return this;
	}

	public String getSitePath()

	{
		return this.sitePath;
	}

	public EnterpriseSeoDto setSitePath(String arg) {
		this.sitePath = arg;
		return this;
	}

	public String getConfigName()

	{
		return this.configName;
	}

	public EnterpriseSeoDto setConfigName(String arg) {
		this.configName = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public EnterpriseSeoDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, EnterpriseSeoDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public EnterpriseSeoDto fromDto(EnterpriseSeoDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, EnterpriseSeoDto.class);
	}

}
