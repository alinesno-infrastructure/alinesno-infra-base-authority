package com.alinesno.infra.base.authority.gateway.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 功能名： 【请填写功能名称】 数据表： enterprise_setting
 * 
 * @author luoxiaodong 
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class EnterpriseSettingDto extends BaseDto {
	/**
	 * "所属公司"
	 */
	private String company;
	/**
	 * "公司地址"
	 */
	private String companyAddress;
	/**
	 * "公司电话"
	 */
	private String companyPhone;
	/**
	 * "公司二维码"
	 */
	private String companyQrcode;
	/**
	 * "客服QQ"
	 */
	private String serviceQq;
	/**
	 * "logo"
	 */
	private String logo;
	/**
	 * "公司邮箱"
	 */
	private String companyEmail;
	/**
	 * "版权所有"
	 */
	private String copyRight;
	/**
	 * "技术支持"
	 */
	private String techSupport;
	/**
	 * "配置名称"
	 */
	private String configName;

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public EnterpriseSettingDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, EnterpriseSettingDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public EnterpriseSettingDto fromDto(EnterpriseSettingDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, EnterpriseSettingDto.class);
	}

}
