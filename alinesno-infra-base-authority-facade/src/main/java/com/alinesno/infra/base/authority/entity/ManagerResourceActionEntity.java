package com.alinesno.infra.base.authority.entity;

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
@TableName("manager_resource_action")
public class ManagerResourceActionEntity extends InfraBaseEntity {

	/**
	 * 操作名称
	 */
	@TableField("resource_action_name")
	@ColumnType(length = 255)
	@ColumnComment("操作名称")
	private String resourceActionName;

	/**
	 * 操作方法名称
	 */
	@TableField("resource_action_method")
	@ColumnType(length = 255)
	@ColumnComment("操作方法名称")
	private String resourceActionMethod;

	/**
	 * 操作图标
	 */
	@TableField("resource_action_icon")
	@ColumnType(length = 255)
	@ColumnComment("操作图标")
	private String resourceActionIcon;

	/**
	 * 操作状态(1正常/0非法)
	 */
	@TableField("resource_action_status")
	@ColumnType
	@ColumnComment("操作状态(1正常/0非法)")
	private Boolean resourceActionStatus;

	/**
	 * 所属资源
	 */
	@TableField("resource_id")
	@ColumnType(length = 255)
	@ColumnComment("所属资源")
	private String resourceId;

	/**
	 * 排列顺序
	 */
	@TableField("resource_action_order")
	@ColumnType
	@ColumnComment("排列顺序")
	private Integer resourceActionOrder;

}
