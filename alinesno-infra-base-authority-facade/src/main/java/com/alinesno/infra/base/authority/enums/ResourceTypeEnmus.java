package com.alinesno.infra.base.authority.enums;

/**
 * 菜单类型
 * 
 * @author WeiXiaoJin
 * @since 2019年1月14日 下午6:48:39
 */
public enum ResourceTypeEnmus {
	// * 菜单类型(0菜单|1分类|9平台标题)

	PLATFORM_RESOURCE_PARENT(0l, "平台菜单");

	public Long value; // 菜单值
	public String menuName; // 菜单名称

	ResourceTypeEnmus(Long value, String menuName) {
		this.value = value;
		this.menuName = menuName;
	}
}
