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
 * 
 * </p>
 *
 * @author ${author}
 * @version 1.0.0
 */
@Data
@TableName("enterprise_seo")
public class EnterpriseSeoEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	@ColumnType(length = 200)
	@ColumnComment("SEO描述")
	@TableField("seo_description")
	@Excel(name = "SEO描述")
	private String seoDescription;

	@ColumnType(length = 200)
	@ColumnComment("SEO关键字")
	@TableField("seo_keyword")
	@Excel(name = "SEO关键字")
	private String seoKeyword;

	@ColumnType(length = 100)
	@ColumnComment("SEO标题")
	@TableField("seo_title")
	@Excel(name = "SEO标题")
	private String seoTitle;

	@ColumnType(length = 50)
	@ColumnComment("站点语言")
	@TableField("site_language")
	@Excel(name = "站点语言")
	private String siteLanguage;

	@ColumnType(length = 100)
	@ColumnComment("站点名称")
	@TableField("site_name")
	@Excel(name = "站点名称")
	private String siteName;

	@ColumnType(length = 100)
	@ColumnComment("站点路径")
	@TableField("site_path")
	@Excel(name = "站点路径")
	private String sitePath;

	@ColumnType(length = 100)
	@ColumnComment("配置名称")
	@TableField("config_name")
	@Excel(name = "配置名称")
	private String configName;

}
