package com.alinesno.infra.base.authority.enums;

import lombok.Getter;

/**
 * 用户角色枚举类
 */
@Getter
public enum ManagerRoleEnums {

	SYSTEM_MANAGER("system_manager", "系统管理员"),
	COMPANY_MANAGER("company_manager", "公司管理员"),
	DEPARTMENT_MANAGER("department_manager", "部门管理员"),
	ORDINARY_USER("ordinary_user", "普通用户");

	public final String value; // 角色值
	public final String roleName; // 角色名称

	ManagerRoleEnums(String value, String roleName) {
		this.value = value;
		this.roleName = roleName;
	}

}
