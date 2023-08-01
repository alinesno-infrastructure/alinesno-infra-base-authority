package com.alinesno.cloud.base.boot.gateway.dto;

import com.alinesno.infra.common.facade.base.BaseDto;

/**
 * 企业信息账户管理
 * 
 * @author LuoAnDong
 * @since 2021年10月27日 下午3:05:15
 */
public class EnterpriseAccountDto extends BaseDto {

	private String enterpriseId; // 企业id
	private String creditCode; // 企业信用代码
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
