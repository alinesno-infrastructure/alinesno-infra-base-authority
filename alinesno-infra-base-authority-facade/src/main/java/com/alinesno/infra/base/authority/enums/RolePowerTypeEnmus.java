package com.alinesno.infra.base.authority.enums;

/**
 * 菜单类型
 * 
 * @author WeiXiaoJin
 * @since 2019年1月14日 下午6:48:39
 */
public enum RolePowerTypeEnmus {
	// * 菜单类型(0菜单|1分类|9平台标题)

	MENU_ITEM("0", "普通菜单"), MENU_PACKAGE("1", "菜单分类"), MENU_PLATFORM("9", "平台菜单"),

	// 互联网默认角色
	ROLE_NETROLE("1", "互联网默认角色"), ROLE_NOT_NETROLE("0", "非互联网默认角色"),

	// 用户权限(9超级管理员/1租户权限/0用户权限)
	ROLE_ADMIN("9", "超级管理员"), ROLE_TENANT("1", "租户权限"), ROLE_USER("0", "用户权限"), ROLE_EDIT("2", "编辑权限"),;

	public String value; // 菜单值
	public String menuName; // 菜单名称

	RolePowerTypeEnmus(String value, String menuName) {
		this.value = value;
		this.menuName = menuName;
	}
}
