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
@TableName("manager_role")
public class ManagerRoleEntity extends InfraBaseEntity {

	/**
	 * 角色名称
	 */
	@Excel(name = "角色名称")
	@TableField("role_name")
	@ColumnType(length = 64)
	@ColumnComment("角色名称")
	private String roleName;

	@TableField("role_title")
	@ColumnType(length = 255)
	@ColumnComment("角色标题")
	private String roleTitle;

	@TableField("role_key")
	@ColumnType(length = 32)
	@ColumnComment("角色标识")
	private String roleKey ;

	/**
	 * 角色描述
	 */
	@Excel(name = "角色描述")
	@TableField("role_desc")
	@ColumnType(length = 255)
	@ColumnComment("角色描述")
	private String roleDesc;

	/**
	 * 显示顺序
	 */
	@TableField("role_sort")
	@ColumnType
	@ColumnComment("显示顺序")
	private Integer roleSort;

	/**
	 * 角色状态(1正常/0非法)
	 */
	@TableField("role_status")
	@ColumnType
	@ColumnComment("角色状态(1正常/0非法)")
	private Integer roleStatus;

	/**
	 * 是否是互联网默认角色
	 */
	@Excel(name = "互联网默认角色")
	@TableField("default_netrole")
	@ColumnType
	@ColumnComment("是否是互联网默认角色")
	private Integer defaultNetRole;

	@TableField("project_id")
	@ColumnType(length = 64)
	@ColumnComment("所属项目")
	private Long projectId;


	@Excel(name = "数据权限")
	@TableField("data_permissions")
	@ColumnType(length = 12)
	@ColumnComment("数据权限，用于定义角色所在的系统部门数据权限")
	private String dataPermissions ;

	@Excel(name = "数据范围")
	@TableField("data_scope")
	@ColumnType(length = 12)
	@ColumnComment("数据范围，用于定义组织数据范围处理")
	private String dataScope = DataSourceScope.PROJECT_SCOPE.getValue();

}
