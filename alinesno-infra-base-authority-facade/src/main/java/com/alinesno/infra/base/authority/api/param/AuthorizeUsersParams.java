package com.alinesno.infra.base.authority.api.param;

import java.io.Serializable;
import java.util.List;

import com.alinesno.infra.base.authority.entity.ManagerRoleEntity;

@SuppressWarnings("serial")
public class AuthorizeUsersParams implements Serializable {
	private List<ManagerRoleEntity> roles;
	private String accountId;

	public List<ManagerRoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<ManagerRoleEntity> roles) {
		this.roles = roles;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
}
