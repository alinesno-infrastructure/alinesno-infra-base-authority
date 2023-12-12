package com.alinesno.infra.base.authority.gateway.dto;

/**
 * 组织机构人员
 * 
 * @author LuoAnDong
 * @since 2023年8月23日 下午8:11:14
 */
public class AccountDeptDto {

	private String src;  
	private Long userId; 
	private String userName;  
	private String deptId; 

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
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
