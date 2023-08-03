package com.alinesno.infra.base.authority.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */

@TableName("manager_role_resource")
public class ManagerRoleResourceEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 角色id
	 */
	@TableField("role_id")
	private Long roleId;
	/**
	 * 资源id
	 */
	@TableField("resource_id")
	private String resourceId;
	/**
	 * 资源类型(resource/action)
	 */
	@TableField("resource_type")
	private String resourceType;
	/**
	 * 角色类型(role角色|tenant商户|account账户)
	 */
	@TableField("role_type")
	private String roleType;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	@Override
	public String toString() {
		return "ManagerRoleResourceEntity{" + "roleId=" + roleId + ", resourceId=" + resourceId + ", resourceType="
				+ resourceType + ", roleType=" + roleType + "}";
	}
}
