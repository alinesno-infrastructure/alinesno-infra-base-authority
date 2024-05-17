package com.alinesno.infra.base.authority.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("manager_application")
public class ManagerApplicationEntity extends InfraBaseEntity {

	/**
	 * 应用名称
	 */
	@Excel(name = "应用名称")
	@TableField("application_name")
	@ColumnType(length = 255)
	@ColumnComment("应用名称")
	private String applicationName;

	@Excel(name = "应用代码")
	@TableField("application_code")
	@ColumnType(length = 255)
	@ColumnComment("应用代码")
	private String applicationCode;

	/**
	 * 应用描述
	 */
	@Excel(name = "应用描述")
	@TableField("application_desc")
	@ColumnType(length = 255)
	@ColumnComment("应用描述")
	private String applicationDesc;

	/**
	 * 应用图标
	 */
	@TableField("application_icons")
	@ColumnType(length = 255)
	@ColumnComment("应用图标")
	private String applicationIcons;

	/**
	 * 应用链接
	 */
	@Excel(name = "应用链接")
	@TableField("application_link")
	@ColumnType(length = 255)
	@ColumnComment("应用链接")
	private String applicationLink;

	/**
	 * 父类id
	 */
	@TableField
	@ColumnType(length = 255)
	@ColumnComment("父类id")
	private String pid;

}
