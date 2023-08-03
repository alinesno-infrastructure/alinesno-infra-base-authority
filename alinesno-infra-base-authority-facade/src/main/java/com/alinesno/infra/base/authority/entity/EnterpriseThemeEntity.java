package com.alinesno.infra.base.authority.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * <p>
 * 企业主题配置
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@TableName("enterprise_theme")
public class EnterpriseThemeEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 登录SEO标题
	 */
	@Excel(name = "登录SEO标题")
	@TableField("login_seo_title")
	private String loginSeoTitle;
	/**
	 * 登录SEO描述
	 */
	@Excel(name = "登录SEO描述")
	@TableField("login_seo_description")
	private String loginSeoDescription;
	/**
	 * 登录SEO关键字
	 */
	@Excel(name = "登录SEO关键字")
	@TableField("login_seo_keyword")
	private String loginSeoKeyword;
	/**
	 * 登录LOGO
	 */
	@Excel(name = "登录LOGO")
	@TableField("login_logo")
	private String loginLogo;
	@TableField(exist = false)
	private String loginLogoPath;
	/**
	 * 登录背景图
	 */
	@Excel(name = "登录背景图")
	@TableField("logo_background")
	private String logoBackground;
	@TableField(exist = false)
	private String logoBackgroundPath;
	/**
	 * 登录标题
	 */
	@Excel(name = "登录标题")
	@TableField("logo_title")
	private String logoTitle;
	/**
	 * 配置名称
	 */
	@Excel(name = "配置名称")
	@TableField("config_name")
	private String configName;

	@Excel(name = "主题颜色")
	@TableField("login_color")
	private String loginColor;

	@TableField("login_description")
	private String loginDescription;

	// 权限声明
	@TableField("power_desc")
	private String powerDesc;

	// 是否存在验证码登陆
	@TableField("has_qr_login")
	private int hasQrLogin;

	public String getPowerDesc() {
		return powerDesc;
	}

	public void setPowerDesc(String powerDesc) {
		this.powerDesc = powerDesc;
	}

	public int getHasQrLogin() {
		return hasQrLogin;
	}

	public void setHasQrLogin(int hasQrLogin) {
		this.hasQrLogin = hasQrLogin;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getLoginColor() {
		return loginColor;
	}

	public void setLoginColor(String loginColor) {
		this.loginColor = loginColor;
	}

	public String getLoginDescription() {
		return loginDescription;
	}

	public void setLoginDescription(String loginDescription) {
		this.loginDescription = loginDescription;
	}

	public String getLoginSeoTitle() {
		return loginSeoTitle;
	}

	public void setLoginSeoTitle(String loginSeoTitle) {
		this.loginSeoTitle = loginSeoTitle;
	}

	public String getLoginSeoDescription() {
		return loginSeoDescription;
	}

	public void setLoginSeoDescription(String loginSeoDescription) {
		this.loginSeoDescription = loginSeoDescription;
	}

	public String getLoginSeoKeyword() {
		return loginSeoKeyword;
	}

	public void setLoginSeoKeyword(String loginSeoKeyword) {
		this.loginSeoKeyword = loginSeoKeyword;
	}

	public String getLoginLogo() {
		return loginLogo;
	}

	public void setLoginLogo(String loginLogo) {
		this.loginLogo = loginLogo;
	}

	public String getLogoBackground() {
		return logoBackground;
	}

	public void setLogoBackground(String logoBackground) {
		this.logoBackground = logoBackground;
	}

	public String getLogoTitle() {
		return logoTitle;
	}

	public void setLogoTitle(String logoTitle) {
		this.logoTitle = logoTitle;
	}

	public String getConfigName() {
		return configName;
	}

	public String getLoginLogoPath() {
		return loginLogoPath;
	}

	public void setLoginLogoPath(String loginLogoPath) {
		this.loginLogoPath = loginLogoPath;
	}

	public String getLogoBackgroundPath() {
		return logoBackgroundPath;
	}

	public void setLogoBackgroundPath(String logoBackgroundPath) {
		this.logoBackgroundPath = logoBackgroundPath;
	}

	public void setConfigName(String configName) {
		this.configName = configName;
	}

	@Override
	public String toString() {
		return "EnterpriseThemeEntity{" + "loginSeoTitle='" + loginSeoTitle + '\'' + ", loginSeoDescription='"
				+ loginSeoDescription + '\'' + ", loginSeoKeyword='" + loginSeoKeyword + '\'' + ", loginLogo='"
				+ loginLogo + '\'' + ", loginLogoPath='" + loginLogoPath + '\'' + ", logoBackground='" + logoBackground
				+ '\'' + ", logoBackgroundPath='" + logoBackgroundPath + '\'' + ", logoTitle='" + logoTitle + '\''
				+ ", configName='" + configName + '\'' + '}';
	}
}
