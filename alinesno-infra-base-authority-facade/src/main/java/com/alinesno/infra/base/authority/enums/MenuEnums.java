package com.alinesno.infra.base.authority.enums;

import lombok.Getter;

/**
 * 菜单类型
 * 
 * @author WeiXiaoJin
 * @since 2019年1月14日 下午6:48:39
 */
@Getter
public enum MenuEnums {

	// * 菜单类型(0菜单|1分类|9平台标题)
	MENU_PLATFORM("9", "平台菜单"),
	MENU_PACKAGE("1", "菜单分类"),
	MENU_ITEM("2", "普通菜单"),
	MENU_BUTTON("3", "按钮"),;

	public final String value; // 菜单值
	public final String menuName; // 菜单名称

	MenuEnums(String value, String menuName) {
		this.value = value;
		this.menuName = menuName;
	}
}
