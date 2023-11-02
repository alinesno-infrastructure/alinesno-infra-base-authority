package com.alinesno.infra.base.authority.entity;

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
@TableName("manager_role_resource")
public class ManagerRoleResourceEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 角色id
	 */
	@TableField("role_id")
	@ColumnType
	@ColumnComment("角色id")
	private Long roleId;

	/**
	 * 资源id
	 */
	@TableField("resource_id")
	@ColumnType(length = 255)
	@ColumnComment("资源id")
	private String resourceId;

	/**
	 * 资源类型(resource/action)
	 */
	@TableField("resource_type")
	@ColumnType(length = 255)
	@ColumnComment("资源类型(resource/action)")
	private String resourceType;

	/**
	 * 角色类型(role角色|tenant商户|account账户)
	 */
	@TableField("role_type")
	@ColumnType(length = 255)
	@ColumnComment("角色类型(role角色|tenant商户|account账户)")
	private String roleType;

}
