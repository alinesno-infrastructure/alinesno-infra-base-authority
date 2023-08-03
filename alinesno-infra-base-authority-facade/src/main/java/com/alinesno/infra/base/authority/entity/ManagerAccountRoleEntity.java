package com.alinesno.infra.base.authority.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */

@TableName("manager_account_role")
public class ManagerAccountRoleEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 角色Id
	 */
	@TableField("role_id")
	private Long roleId;

	/**
	 * 账户id
	 */
	@TableField("account_id")
	private Long accountId;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

}
