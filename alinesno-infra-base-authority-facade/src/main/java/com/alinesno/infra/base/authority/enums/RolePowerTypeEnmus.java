package com.alinesno.infra.base.authority.enums;

import lombok.Getter;

/**
 * 菜单类型
 * 
 * @author WeiXiaoJin
 * @since 2019年1月14日 下午6:48:39
 */
@Getter
public enum RolePowerTypeEnmus {

	ROLE_ADMIN("9", "超级管理员"),
	ROLE_USER("0", "用户权限"),
	ROLE_GROUP("1", "组织权限"),
	ROLE_EDIT("2", "编辑权限"),;

	public final String value; // 菜单值
	public final String menuName; // 菜单名称

	RolePowerTypeEnmus(String value, String menuName) {
		this.value = value;
		this.menuName = menuName;
	}
}
