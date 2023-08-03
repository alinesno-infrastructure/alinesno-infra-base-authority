package com.alinesno.infra.base.authority.api.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： enterprise_theme
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class EnterpriseThemeDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "登录SEO标题"
	 */
	private String loginSeoTitle;
	/**
	 * "登录SEO描述"
	 */
	private String loginSeoDescription;
	/**
	 * "登录SEO关键字"
	 */
	private String loginSeoKeyword;
	/**
	 * "登录LOGO"
	 */
	private String loginLogo;
	/**
	 * "登录背景图"
	 */
	private String logoBackground;
	/**
	 * "登录标题"
	 */
	private String logoTitle;
	/**
	 * "配置名称"
	 */
	private String configName;
	/**
	 * "loginDescription"
	 */
	private String loginDescription;
	/**
	 * "登录主题色"
	 */
	private String loginColor;

	// getter and setter
	public String getLoginSeoTitle()

	{
		return this.loginSeoTitle;
	}

	public EnterpriseThemeDto setLoginSeoTitle(String arg) {
		this.loginSeoTitle = arg;
		return this;
	}

	public String getLoginSeoDescription()

	{
		return this.loginSeoDescription;
	}

	public EnterpriseThemeDto setLoginSeoDescription(String arg) {
		this.loginSeoDescription = arg;
		return this;
	}

	public String getLoginSeoKeyword()

	{
		return this.loginSeoKeyword;
	}

	public EnterpriseThemeDto setLoginSeoKeyword(String arg) {
		this.loginSeoKeyword = arg;
		return this;
	}

	public String getLoginLogo()

	{
		return this.loginLogo;
	}

	public EnterpriseThemeDto setLoginLogo(String arg) {
		this.loginLogo = arg;
		return this;
	}

	public String getLogoBackground()

	{
		return this.logoBackground;
	}

	public EnterpriseThemeDto setLogoBackground(String arg) {
		this.logoBackground = arg;
		return this;
	}

	public String getLogoTitle()

	{
		return this.logoTitle;
	}

	public EnterpriseThemeDto setLogoTitle(String arg) {
		this.logoTitle = arg;
		return this;
	}

	public String getConfigName()

	{
		return this.configName;
	}

	public EnterpriseThemeDto setConfigName(String arg) {
		this.configName = arg;
		return this;
	}

	public String getLoginDescription()

	{
		return this.loginDescription;
	}

	public EnterpriseThemeDto setLoginDescription(String arg) {
		this.loginDescription = arg;
		return this;
	}

	public String getLoginColor()

	{
		return this.loginColor;
	}

	public EnterpriseThemeDto setLoginColor(String arg) {
		this.loginColor = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public EnterpriseThemeDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, EnterpriseThemeDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public EnterpriseThemeDto fromDto(EnterpriseThemeDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, EnterpriseThemeDto.class);
	}

}
