package com.alinesno.infra.base.authority.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@Data
@TableName("manager_department")
public class ManagerDepartmentEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	@Excel(name = "所屬应用")
	@TableField("application_name")
	@ColumnType(length = 255)
	@ColumnComment("所屬应用")
	private String applicationName;

	/**
	 * 父部门id
	 */
	@TableField("pid")
	@ColumnType
	@ColumnComment("父部门id")
	private Long pid;

	/**
	 * 父级ids
	 */
	@TableField("pids")
	@ColumnType(length = 255)
	@ColumnComment("父级ids")
	private String pids;

	/**
	 * 简称
	 */
	@Excel(name = "简称")
	@TableField("simple_name")
	@ColumnType(length = 255)
	@ColumnComment("简称")
	private String simpleName;

	/**
	 * 全称
	 */
	@Excel(name = "部门名称")
	@TableField("full_name")
	@ColumnType(length = 255)
	@ColumnComment("全称")
	private String fullName;

	/**
	 * 描述
	 */
	@Excel(name = "部门描述")
	@ColumnType(length = 255)
	@ColumnComment("描述")
	@TableField("description")
	private String description;

	/**
	 * 版本（乐观锁保留字段）
	 */
	@TableField("versions")
	@ColumnType
	@ColumnComment("版本（乐观锁保留字段）")
	private Integer versions;

	/**
	 * 排序
	 */
	@TableField("sort")
	@ColumnType
	@ColumnComment("排序")
	private Integer sort;

}
