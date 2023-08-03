package com.alinesno.infra.base.authority.api.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： enterprise_setting
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class EnterpriseSettingDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
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

	// getter and setter
	public String getCompany()

	{
		return this.company;
	}

	public EnterpriseSettingDto setCompany(String arg) {
		this.company = arg;
		return this;
	}

	public String getCompanyAddress()

	{
		return this.companyAddress;
	}

	public EnterpriseSettingDto setCompanyAddress(String arg) {
		this.companyAddress = arg;
		return this;
	}

	public String getCompanyPhone()

	{
		return this.companyPhone;
	}

	public EnterpriseSettingDto setCompanyPhone(String arg) {
		this.companyPhone = arg;
		return this;
	}

	public String getCompanyQrcode()

	{
		return this.companyQrcode;
	}

	public EnterpriseSettingDto setCompanyQrcode(String arg) {
		this.companyQrcode = arg;
		return this;
	}

	public String getServiceQq()

	{
		return this.serviceQq;
	}

	public EnterpriseSettingDto setServiceQq(String arg) {
		this.serviceQq = arg;
		return this;
	}

	public String getLogo()

	{
		return this.logo;
	}

	public EnterpriseSettingDto setLogo(String arg) {
		this.logo = arg;
		return this;
	}

	public String getCompanyEmail()

	{
		return this.companyEmail;
	}

	public EnterpriseSettingDto setCompanyEmail(String arg) {
		this.companyEmail = arg;
		return this;
	}

	public String getCopyRight()

	{
		return this.copyRight;
	}

	public EnterpriseSettingDto setCopyRight(String arg) {
		this.copyRight = arg;
		return this;
	}

	public String getTechSupport()

	{
		return this.techSupport;
	}

	public EnterpriseSettingDto setTechSupport(String arg) {
		this.techSupport = arg;
		return this;
	}

	public String getConfigName()

	{
		return this.configName;
	}

	public EnterpriseSettingDto setConfigName(String arg) {
		this.configName = arg;
		return this;
	}

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
