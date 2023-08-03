package com.alinesno.infra.base.authority.entity;

import java.util.Date;

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

@TableName("manager_template")
public class ManagerTemplateEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 模板名称
	 */
	@TableField("template_name")
	private String templateName;
	/**
	 * 模板内容
	 */
	@TableField("template_content")
	private String templateContent;
	/**
	 * 模板数据
	 */
	@TableField("template_data")
	private String templateData;
	/**
	 * 模板时间
	 */
	@TableField("template_addtime")
	private Date templateAddtime;
	/**
	 * 模板状态
	 */
	@TableField("template_status")
	private String templateStatus;
	/**
	 * 所属菜单
	 */
	@TableField("resource_id")
	private String resourceId;
	/**
	 * 模板作者
	 */
	@TableField("template_owner")
	private String templateOwner;

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getTemplateContent() {
		return templateContent;
	}

	public void setTemplateContent(String templateContent) {
		this.templateContent = templateContent;
	}

	public String getTemplateData() {
		return templateData;
	}

	public void setTemplateData(String templateData) {
		this.templateData = templateData;
	}

	public Date getTemplateAddtime() {
		return templateAddtime;
	}

	public void setTemplateAddtime(Date templateAddtime) {
		this.templateAddtime = templateAddtime;
	}

	public String getTemplateStatus() {
		return templateStatus;
	}

	public void setTemplateStatus(String templateStatus) {
		this.templateStatus = templateStatus;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getTemplateOwner() {
		return templateOwner;
	}

	public void setTemplateOwner(String templateOwner) {
		this.templateOwner = templateOwner;
	}

	@Override
	public String toString() {
		return "ManagerTemplateEntity{" + "templateName=" + templateName + ", templateContent=" + templateContent
				+ ", templateData=" + templateData + ", templateAddtime=" + templateAddtime + ", templateStatus="
				+ templateStatus + ", resourceId=" + resourceId + ", templateOwner=" + templateOwner + "}";
	}
}
