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

	MENU_PLATFORM("P", "平台菜单"),
	MENU_FOLDER("M", "菜单分类"),
	MENU_ITEM("C", "普通菜单"),
	MENU_BUTTON("F", "平台按钮")
	;

	public final String value; // 菜单值
	public final String menuName; // 菜单名称

	MenuEnums(String value, String menuName) {
		this.value = value;
		this.menuName = menuName;
	}
}
