package com.alinesno.infra.base.authority.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * <p>
 * 
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */

@TableName("manager_application")
public class ManagerApplicationEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 应用名称
	 */
	@Excel(name = "应用名称")
	@TableField("application_name")
	private String applicationName;

	@Excel(name = "应用代码")
	@TableField("application_code")
	private String applicationCode;

	/**
	 * 应用描述
	 */
	@Excel(name = "应用描述")
	@TableField("application_desc")
	private String applicationDesc;

	/**
	 * 应用图标
	 */
	@TableField("application_icons")
	private String applicationIcons;

	/**
	 * 应用链接
	 */
	@Excel(name = "应用链接")
	@TableField("application_link")
	private String applicationLink;

	/**
	 * 父类id
	 */
	@TableField
	private String pid;

	public String getApplicationCode() {
		return applicationCode;
	}

	public void setApplicationCode(String applicationCode) {
		this.applicationCode = applicationCode;
	}

	public String getApplicationLink() {
		return applicationLink;
	}

	public void setApplicationLink(String applicationLink) {
		this.applicationLink = applicationLink;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getApplicationDesc() {
		return applicationDesc;
	}

	public void setApplicationDesc(String applicationDesc) {
		this.applicationDesc = applicationDesc;
	}

	public String getApplicationIcons() {
		return applicationIcons;
	}

	public void setApplicationIcons(String applicationIcons) {
		this.applicationIcons = applicationIcons;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "ManagerApplicationEntity{" + ", applicationDesc=" + applicationDesc + ", applicationIcons="
				+ applicationIcons + ", pid=" + pid + "}";
	}
}
