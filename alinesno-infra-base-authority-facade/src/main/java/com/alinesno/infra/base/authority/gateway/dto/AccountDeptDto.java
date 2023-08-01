package com.alinesno.infra.base.authority.gateway.dto;

/**
 * 组织机构人员
 * 
 * @author LuoAnDong
 * @since 2021年8月23日 下午8:11:14
 */
public class AccountDeptDto {

	private String src; // ":
						// "https://gtd.alicdn.com/sns_logo/i1/TB1_f_PLXXXXXbVXpXXSutbFXXX.jpg_240x240xz.jpg",
	private String userId; // ": 40,
	private String userName; // ": "王五",
	private String deptId; // ": 3

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

}
