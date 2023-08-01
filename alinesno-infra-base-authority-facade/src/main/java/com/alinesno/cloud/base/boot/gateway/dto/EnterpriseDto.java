package com.alinesno.cloud.base.boot.gateway.dto;

import com.alinesno.infra.common.facade.base.BaseDto;

/**
 * 企业信息管理
 * 
 * @author LuoAnDong
 * @since 2021年10月27日 下午3:05:15
 */
@SuppressWarnings("serial")
public class EnterpriseDto extends BaseDto {

	private String name; // 企业名称
	private String logo; // 企业logo
	private String enDesc; // 企业描述
	private String domainName; // 企业域名
	private String creditCode; // 企业信用代码
	private String saasUrl; // 工作台地址

	public String getSaasUrl() {
		return saasUrl;
	}

	public void setSaasUrl(String saasUrl) {
		this.saasUrl = saasUrl;
	}

	public String getCreditCode() {
		return creditCode;
	}

	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getEnDesc() {
		return enDesc;
	}

	public void setEnDesc(String enDesc) {
		this.enDesc = enDesc;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	@Override
	public String toString() {
		return "EnterpriseDto [name=" + name + ", logo=" + logo + ", enDesc=" + enDesc + ", domainName=" + domainName
				+ ", creditCode=" + creditCode + "]";
	}

}
