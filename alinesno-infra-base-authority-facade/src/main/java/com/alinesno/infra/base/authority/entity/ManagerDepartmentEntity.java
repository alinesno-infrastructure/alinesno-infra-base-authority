package com.alinesno.infra.base.authority.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.base.authority.enums.DataSourceScope;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

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
@TableName("manager_department")
public class ManagerDepartmentEntity extends InfraBaseEntity {

	@TableField("pid")
	@ColumnType
	@ColumnComment("父部门id")
	private Long pid;

	@TableField("ancestors")
	@ColumnType
	@ColumnComment("祖级列表")
	private String ancestors;

	@TableField("pids")
	@ColumnType(length = 255)
	@ColumnComment("父级ids")
	private String pids;

	@Excel(name = "简称")
	@TableField("simple_name")
	@ColumnType(length = 255)
	@ColumnComment("简称")
	private String simpleName;

	@Excel(name = "部门名称")
	@TableField("full_name")
	@ColumnType(length = 255)
	@ColumnComment("全称")
	private String fullName;

	@TableField("leader")
	@ColumnType(length = 32)
	@ColumnComment("负责人")
	private String leader ;

	@TableField("phone")
	@ColumnType(length = 11)
	@ColumnComment("手机号")
	private String phone;

	@TableField("email")
	@ColumnType(length = 32)
	@ColumnComment("邮箱")
	private String email;

	@Excel(name = "部门描述")
	@ColumnType(length = 255)
	@ColumnComment("描述")
	@TableField("description")
	private String description;

	@TableField("versions")
	@ColumnType
	@ColumnComment("版本（乐观锁保留字段）")
	private Integer versions;

	@TableField("order_num")
	@ColumnType
	@ColumnComment("排序")
	private Integer orderNum;

	@TableField("project_id")
	@ColumnType(length = 64)
	@ColumnComment("所属项目")
	private Long projectId;

	/** 子部门 */
	@TableField(exist = false)
	private List<ManagerDepartmentEntity> children = new ArrayList<ManagerDepartmentEntity>();

	@Excel(name = "数据范围")
	@TableField("data_scope")
	@ColumnType(length = 12)
	@ColumnComment("数据范围")
	private String dataScope = DataSourceScope.PROJECT_SCOPE.getValue();
}
