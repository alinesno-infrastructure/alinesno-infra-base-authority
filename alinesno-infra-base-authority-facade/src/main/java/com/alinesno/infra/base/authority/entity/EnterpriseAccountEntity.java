package com.alinesno.infra.base.authority.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 企业信息账户管理
 * 
 * @author LuoAnDong
 * @since 2021年10月27日 下午3:05:15
 */
@SuppressWarnings("serial")
@TableName("enterprise_account")
public class EnterpriseAccountEntity extends InfraBaseEntity {

	@TableField("enterprise_id")
	private String enterpriseId; // 企业id

	@TableField("credit_code")
	private String creditCode; // 企业信用代码

	@TableField("account_id")
	private String accountId; // 账号id

	public String getCreditCode() {
		return creditCode;
	}

	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}

	public String getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

}
