package com.alinesno.infra.base.authority.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * <p>
 * 企业配置
 * </p>
 *
 * @author ${author}
 * @version 1.0.0
 */
@TableName("enterprise_setting")
public class EnterpriseSettingEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;
	@Excel(name = "配置名称")
	@TableField("config_name")
	private String configName;
	/**
	 * 所属公司
	 */
	@Excel(name = "所属公司")
	@TableField("company")
	private String company;
	/**
	 * 公司地址
	 */
	@Excel(name = "公司地址")
	@TableField("company_address")
	private String companyAddress;
	/**
	 * 公司电话
	 */
	@Excel(name = "公司电话")
	@TableField("company_phone")
	private String companyPhone;
	/**
	 * 公司二维码
	 */
	@Excel(name = "公司二维码")
	@TableField("company_qrcode")
	private String companyQrcode;
	@TableField(exist = false)
	private String companyQrcodePath;
	/**
	 * 客服QQ
	 */
	@Excel(name = "客服QQ")
	@TableField("service_qq")
	private String serviceQq;

	/**
	 * logo
	 */
	@Excel(name = "logo")
	@TableField("logo")
	private String logo;

	@TableField(exist = false)
	private String logoPath;

	/**
	 * 公司邮箱
	 */
	@Excel(name = "公司邮箱")
	@TableField("company_email")
	private String companyEmail;
	/**
	 * 版权所有
	 */
	@Excel(name = "版权所有")
	@TableField("copy_right")
	private String copyRight;
	/**
	 * 技术支持
	 */
	@Excel(name = "技术支持")
	@TableField("tech_support")
	private String techSupport;

	/**
	 * 企业官网
	 */
	@TableField("website")
	private String website;

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyPhone() {
		return companyPhone;
	}

	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}

	public String getCompanyQrcode() {
		return companyQrcode;
	}

	public void setCompanyQrcode(String companyQrcode) {
		this.companyQrcode = companyQrcode;
	}

	public String getServiceQq() {
		return serviceQq;
	}

	public void setServiceQq(String serviceQq) {
		this.serviceQq = serviceQq;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getConfigName() {
		return configName;
	}

	public void setConfigName(String configName) {
		this.configName = configName;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public String getCopyRight() {
		return copyRight;
	}

	public void setCopyRight(String copyRight) {
		this.copyRight = copyRight;
	}

	public String getTechSupport() {
		return techSupport;
	}

	public void setTechSupport(String techSupport) {
		this.techSupport = techSupport;
	}

	public String getCompany() {
		return company;
	}

	public String getCompanyQrcodePath() {
		return companyQrcodePath;
	}

	public void setCompanyQrcodePath(String companyQrcodePath) {
		this.companyQrcodePath = companyQrcodePath;
	}

	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	@Override
	public String toString() {
		return "EnterpriseSettingEntity{" + "configName='" + configName + '\'' + ", company='" + company + '\''
				+ ", companyAddress='" + companyAddress + '\'' + ", companyPhone='" + companyPhone + '\''
				+ ", companyQrcode='" + companyQrcode + '\'' + ", companyQrcodePath='" + companyQrcodePath + '\''
				+ ", serviceQq='" + serviceQq + '\'' + ", logo='" + logo + '\'' + ", logoPath='" + logoPath + '\''
				+ ", companyEmail='" + companyEmail + '\'' + ", copyRight='" + copyRight + '\'' + ", techSupport='"
				+ techSupport + '\'' + '}';
	}
}
