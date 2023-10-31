package com.alinesno.infra.base.authority.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;

/**
 * <p>
 * 企业主题配置
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@Data
@TableName("enterprise_theme")
public class EnterpriseThemeEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	@ColumnType(length = 100)
	@ColumnComment("登录SEO标题")
	@TableField("login_seo_title")
	@Excel(name = "登录SEO标题")
	private String loginSeoTitle;

	@ColumnType(length = 200)
	@ColumnComment("登录SEO描述")
	@TableField("login_seo_description")
	@Excel(name = "登录SEO描述")
	private String loginSeoDescription;

	@ColumnType(length = 100)
	@ColumnComment("登录SEO关键字")
	@TableField("login_seo_keyword")
	@Excel(name = "登录SEO关键字")
	private String loginSeoKeyword;

	@ColumnType(length = 100)
	@ColumnComment("登录LOGO")
	@TableField("login_logo")
	@Excel(name = "登录LOGO")
	private String loginLogo;

	@ColumnComment("登录LOGO路径")
	@TableField(exist = false)
	private String loginLogoPath;

	@ColumnType(length = 100)
	@ColumnComment("登录背景图")
	@TableField("logo_background")
	@Excel(name = "登录背景图")
	private String logoBackground;

	@ColumnComment("登录背景图路径")
	@TableField(exist = false)
	private String logoBackgroundPath;

	@ColumnType(length = 100)
	@ColumnComment("登录标题")
	@TableField("logo_title")
	@Excel(name = "登录标题")
	private String logoTitle;

	@ColumnType(length = 100)
	@ColumnComment("配置名称")
	@TableField("config_name")
	@Excel(name = "配置名称")
	private String configName;

	@ColumnType(length = 100)
	@ColumnComment("主题颜色")
	@TableField("login_color")
	@Excel(name = "主题颜色")
	private String loginColor;

	@TableField("login_description")
	private String loginDescription;

	@TableField("power_desc")
	private String powerDesc;

	@TableField("has_qr_login")
	private int hasQrLogin;

}
