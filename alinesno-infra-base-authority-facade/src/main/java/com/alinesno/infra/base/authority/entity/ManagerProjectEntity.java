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
@TableName("manager_project")
public class ManagerProjectEntity extends InfraBaseEntity {

	/**
	 * 项目名称
	 */
	@Excel(name = "项目名称")
	@TableField("project_name")
	@ColumnType(length = 255)
	@ColumnComment("项目名称")
	private String projectName;

	@Excel(name = "项目代码")
	@TableField("project_code")
	@ColumnType(length = 255)
	@ColumnComment("项目代码")
	private String projectCode;

	/**
	 * 项目描述
	 */
	@Excel(name = "项目描述")
	@TableField("project_desc")
	@ColumnType(length = 255)
	@ColumnComment("项目描述")
	private String projectDesc;

	/**
	 * 项目图标
	 */
	@TableField("project_icons")
	@ColumnType(length = 64)
	@ColumnComment("项目图标")
	private String projectIcons;

	/**
	 * 项目链接
	 */
	@Excel(name = "项目链接")
	@TableField("project_link")
	@ColumnType(length = 64)
	@ColumnComment("项目链接")
	private String projectLink;

	@TableField("component")
	@ColumnType(length = 64)
	@ColumnComment("组件链接")
	private String component;

	/** 权限字符串 */
	@TableField("perms")
	@ColumnType(length = 64)
	@ColumnComment("权限字符串")
	private String perms;

	/**
	 * 父类id
	 */
	@TableField
	@ColumnType(length = 255)
	@ColumnComment("父类id")
	private String pid;

	@TableField
	@ColumnType(length = 255)
	@ColumnComment("系统内置(Y是|N否)")
	private String systemInner;

}
