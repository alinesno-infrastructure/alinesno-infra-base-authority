package com.alinesno.infra.base.authority.gateway.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 功能名： 【请填写功能名称】 数据表： enterprise_theme
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class EnterpriseThemeDto extends BaseDto {
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
