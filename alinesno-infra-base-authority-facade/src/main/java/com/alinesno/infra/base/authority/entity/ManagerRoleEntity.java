package com.alinesno.infra.base.authority.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * <p>
 *
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */

@TableName("manager_role")
public class ManagerRoleEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	@Excel(name = "所属应用")
	private String applicationName;
	/**
	 * 角色名称
	 */
	@Excel(name = "角色名称")
	@TableField("role_name")
	private String roleName;

	@TableField("role_title")
	private String roleTitle;

	/**
	 * 角色描述
	 */
	@Excel(name = "角色描述")
	@TableField("role_desc")
	private String roleDesc;

	/**
	 * 角色状态(1正常/0非法)
	 */
	@TableField("role_status")
	private Integer roleStatus;

	/**
	 * 是否是互联网默认角色
	 */
	@Excel(name = "互联网默认角色")
	@TableField("default_netrole")
	private Integer defaultNetRole;

	public Integer getDefaultNetRole() {
		return defaultNetRole;
	}

	public void setDefaultNetRole(Integer defaultNetRole) {
		this.defaultNetRole = defaultNetRole;
	}

	public String getRoleTitle() {
		return roleTitle;
	}

	public void setRoleTitle(String roleTitle) {
		this.roleTitle = roleTitle;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getRoleStatus() {
		return roleStatus;
	}

	public void setRoleStatus(Integer roleStatus) {
		this.roleStatus = roleStatus;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	@Override
	public String getApplicationName() {
		return applicationName;
	}

	@Override
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	@Override
	public String toString() {
		return "ManagerRoleEntity{" + "roleName='" + roleName + '\'' + ", roleTitle='" + roleTitle + '\''
				+ ", roleDesc='" + roleDesc + '\'' + ", applicationName='" + applicationName + '\'' + ", roleStatus="
				+ roleStatus + '}';
	}
}
