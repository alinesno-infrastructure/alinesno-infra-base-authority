package com.alinesno.cloud.base.boot.dto;

import com.alinesno.cloud.base.boot.entity.ManagerRoleEntity;

public class AccountRoleDto extends ManagerRoleEntity {
	String accountId;
	String loginName;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
}
