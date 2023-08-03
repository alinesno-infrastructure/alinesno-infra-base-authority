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

@TableName("manager_resource_action")
public class ManagerResourceActionEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 操作名称
	 */
	@TableField("resource_action_name")
	private String resourceActionName;
	/**
	 * 操作方法名称
	 */
	@TableField("resource_action_method")
	private String resourceActionMethod;
	/**
	 * 操作图标
	 */
	@TableField("resource_action_icon")
	private String resourceActionIcon;
	/**
	 * 操作状态(1正常/0非法)
	 */
	@TableField("resource_action_status")
	private Boolean resourceActionStatus;
	/**
	 * 所属资源
	 */
	@TableField("resource_id")
	private String resourceId;
	/**
	 * 排列顺序
	 */
	@TableField("resource_action_order")
	private Integer resourceActionOrder;

	public String getResourceActionName() {
		return resourceActionName;
	}

	public void setResourceActionName(String resourceActionName) {
		this.resourceActionName = resourceActionName;
	}

	public String getResourceActionMethod() {
		return resourceActionMethod;
	}

	public void setResourceActionMethod(String resourceActionMethod) {
		this.resourceActionMethod = resourceActionMethod;
	}

	public String getResourceActionIcon() {
		return resourceActionIcon;
	}

	public void setResourceActionIcon(String resourceActionIcon) {
		this.resourceActionIcon = resourceActionIcon;
	}

	public Boolean isResourceActionStatus() {
		return resourceActionStatus;
	}

	public void setResourceActionStatus(Boolean resourceActionStatus) {
		this.resourceActionStatus = resourceActionStatus;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public Integer getResourceActionOrder() {
		return resourceActionOrder;
	}

	public void setResourceActionOrder(Integer resourceActionOrder) {
		this.resourceActionOrder = resourceActionOrder;
	}

	@Override
	public String toString() {
		return "ManagerResourceActionEntity{" + "resourceActionName=" + resourceActionName + ", resourceActionMethod="
				+ resourceActionMethod + ", resourceActionIcon=" + resourceActionIcon + ", resourceActionStatus="
				+ resourceActionStatus + ", resourceId=" + resourceId + ", resourceActionOrder=" + resourceActionOrder
				+ "}";
	}
}
