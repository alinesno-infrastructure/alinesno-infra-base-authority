package com.alinesno.infra.base.authority.gateway.param;

import com.alinesno.infra.base.authority.entity.ManagerRoleEntity;

import java.io.Serializable;
import java.util.List;

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
