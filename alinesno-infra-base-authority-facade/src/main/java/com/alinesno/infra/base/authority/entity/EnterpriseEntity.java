package com.alinesno.infra.base.authority.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 企业信息管理
 * 
 * @author LuoAnDong
 * @since 2023年10月27日 下午3:05:15
 */
@SuppressWarnings("serial")
@TableName("enterprise")
public class EnterpriseEntity extends InfraBaseEntity {

	@TableField("name")
	private String name; // 企业名称

	@TableField("logo")
	private String logo; // 企业logo

	@TableField("en_desc")
	private String enDesc; // 企业描述

	@TableField("domain_name")
	private String domainName; // 企业域名

	@TableField("credit_code")
	private String creditCode; // 企业信用代码
	
	@TableField("saas_url")
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

}
