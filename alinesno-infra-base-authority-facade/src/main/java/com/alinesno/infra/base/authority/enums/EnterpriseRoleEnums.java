package com.alinesno.infra.base.authority.enums;

/**
 * 企业角色类型
 * 
 * @author LuoAnDong
 * @since 2021年10月28日 上午11:41:34
 */
public enum EnterpriseRoleEnums {

	FA_REN("fa_ren", "法人"), GU_YUAN("gu_yuan", "雇员");

	private String code;
	private String name;

	EnterpriseRoleEnums(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

}
