package com.alinesno.infra.base.authority.enums;

/**
 * 用户角色枚举类
 */
public enum ManagerRoleEnums {

	SYSTEM_MANAGER("system_manager", "系统管理员"), COMPANY_MANAGER("company_manager", "公司管理员"),
	DEPARTMENT_MANAGER("department_manager", "部门管理员"), ORDINARY_USER("ordinary_user", "普通用户");

	public String value; // 角色值
	public String roleName; // 角色名称

	ManagerRoleEnums(String value, String roleName) {
		this.value = value;
		this.roleName = roleName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
