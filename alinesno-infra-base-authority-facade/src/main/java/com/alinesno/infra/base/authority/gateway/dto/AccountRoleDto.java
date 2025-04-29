package com.alinesno.infra.base.authority.gateway.dto;

import com.alinesno.infra.base.authority.entity.ManagerRoleEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AccountRoleDto extends ManagerRoleEntity {
	String accountId;
	String loginName;
}
