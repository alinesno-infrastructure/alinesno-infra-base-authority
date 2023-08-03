package com.alinesno.infra.base.authority.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @version 1.0.0
 */
@TableName("enterprise_seo")
public class EnterpriseSeoEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;
	@Excel(name = "SEO描述")
	@TableField("seo_description")
	private String seoDescription;

	@Excel(name = "SEO关键字")
	@TableField("seo_keyword")
	private String seoKeyword;

	@Excel(name = "SEO标题")
	@TableField("seo_title")
	private String seoTitle;

	@Excel(name = "站点语言")
	@TableField("site_language")
	private String siteLanguage;

	@Excel(name = "站点名称")
	@TableField("site_name")
	private String siteName;

	@Excel(name = "站点路径")
	@TableField("site_path")
	private String sitePath;

	@Excel(name = "配置名称")
	@TableField("config_name")
	private String configName;

	public String getSeoDescription() {
		return seoDescription;
	}

	public void setSeoDescription(String seoDescription) {
		this.seoDescription = seoDescription;
	}

	public String getSeoKeyword() {
		return seoKeyword;
	}

	public void setSeoKeyword(String seoKeyword) {
		this.seoKeyword = seoKeyword;
	}

	public String getSeoTitle() {
		return seoTitle;
	}

	public void setSeoTitle(String seoTitle) {
		this.seoTitle = seoTitle;
	}

	public String getSiteLanguage() {
		return siteLanguage;
	}

	public void setSiteLanguage(String siteLanguage) {
		this.siteLanguage = siteLanguage;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getSitePath() {
		return sitePath;
	}

	public void setSitePath(String sitePath) {
		this.sitePath = sitePath;
	}

	public String getConfigName() {
		return configName;
	}

	public void setConfigName(String configName) {
		this.configName = configName;
	}

	@Override
	public String toString() {
		return "EnterpriseSeoEntity{" + "seoDescription=" + seoDescription + ", seoKeyword=" + seoKeyword
				+ ", seoTitle=" + seoTitle + ", siteLanguage=" + siteLanguage + ", siteName=" + siteName + ", sitePath="
				+ sitePath + ", configName=" + configName + "}";
	}
}
