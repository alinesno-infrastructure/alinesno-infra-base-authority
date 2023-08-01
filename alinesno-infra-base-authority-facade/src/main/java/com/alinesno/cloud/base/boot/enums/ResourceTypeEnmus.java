package com.alinesno.cloud.base.boot.enums;

/**
 * 菜单类型
 * 
 * @author WeiXiaoJin
 * @since 2019年1月14日 下午6:48:39
 */
public enum ResourceTypeEnmus {
	// * 菜单类型(0菜单|1分类|9平台标题)

	PLATFORM_RESOURCE_PARENT("0", "平台菜单");

	public String value; // 菜单值
	public String menuName; // 菜单名称

	ResourceTypeEnmus(String value, String menuName) {
		this.value = value;
		this.menuName = menuName;
	}
}
