package com.alinesno.infra.base.authority.gateway.param;

import com.alinesno.infra.base.authority.entity.ManagerRoleEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AuthorizeUsersParams implements Serializable {

	private List<ManagerRoleEntity> roles;
	private String accountId;

}
