package com.alinesno.infra.base.authority.entity;

import java.util.List;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.alinesno.infra.common.facade.mapper.id.SnowflakeIdWorker;
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

@TableName("manager_resource")
public class ManagerResourceEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 资源名称
	 */
	@Excel(name = "资源名称")
	@TableField("resource_name")
	private String resourceName;
	/**
	 * 资源链接
	 */
	@Excel(name = "资源链接")
	@TableField("resource_link")
	private String resourceLink;
	/**
	 * 资源图标
	 */
	@Excel(name = "资源图标")
	@TableField("resource_icon")
	private String resourceIcon;
	/**
	 * 资源父类
	 */
	@Excel(name = "资源父类")
	@TableField("resource_parent")
	private Long resourceParent = 0l;
	/**
	 * 资源排序
	 */
	@Excel(name = "资源排序")
	@TableField("resource_order")
	private Integer resourceOrder;

	/**
	 * 菜单类型(0菜单|1小标题|9平台标题)
	 */
	@Excel(name = "菜单类型(0菜单|1小标题|9平台标题)")
	@TableField("menu_type")
	private String menuType = "0"; // MenuEnums.MENU_ITEM.value ;

	/**
	 * 链接打开方式
	 */
	@TableField("open_target")
	private String openTarget;

	/**
	 * 权限标识
	 */
	@Excel(name = "权限标识")
	@TableField("permission")
	private String permission;

	/**
	 * 权限脚本
	 */
	@TableField("permission_script")
	private String permissionScript;

	/**
	 * 是否可见
	 */
	@Excel(name = "是否可见", replace = { "隐藏_0", "显示_1" })
	@TableField("visible")
	private String visible;

	/**
	 * 菜单子类
	 */
	@TableField(exist = false)
	private List<ManagerResourceEntity> subResource;

	public String getVisible() {
		return visible;
	}

	public void setVisible(String visible) {
		this.visible = visible;
	}

	public String getOpenTarget() {
		return openTarget;
	}

	public void setOpenTarget(String openTarget) {
		this.openTarget = openTarget;
	}

	public String getPermissionScript() {
		return permissionScript;
	}

	public void setPermissionScript(String permissionScript) {
		this.permissionScript = permissionScript;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public ManagerResourceEntity() {
		super();
	}

	public ManagerResourceEntity(String resourceName, String menuTypeTitle, Long applicationId) {
		this.resourceName = resourceName;
		this.menuType = menuTypeTitle;
		this.setApplicationId(applicationId);
		this.setId(SnowflakeIdWorker.getId());
	}

	public ManagerResourceEntity(String resourceName, String resourceLink, String menuType,
			ManagerResourceEntity parent) {
		this.resourceName = resourceName;
		this.menuType = menuType;
		this.resourceLink = resourceLink;
		this.setResourceParent(parent.getId());
		this.setResourceIcon("fa fa-envelope-open");
		this.setApplicationId(parent.getApplicationId());
		this.setId(SnowflakeIdWorker.getId());
	}

	public List<ManagerResourceEntity> getSubResource() {
		return subResource;
	}

	public void setSubResource(List<ManagerResourceEntity> subResource) {
		this.subResource = subResource;
	}

	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceLink() {
		return resourceLink;
	}

	public void setResourceLink(String resourceLink) {
		this.resourceLink = resourceLink;
	}

	public String getResourceIcon() {
		return resourceIcon;
	}

	public void setResourceIcon(String resourceIcon) {
		this.resourceIcon = resourceIcon;
	}

	public Long getResourceParent() {
		return resourceParent;
	}

	public void setResourceParent(Long resourceParent) {
		this.resourceParent = resourceParent;
	}

	public Integer getResourceOrder() {
		return resourceOrder;
	}

	public void setResourceOrder(Integer resourceOrder) {
		this.resourceOrder = resourceOrder;
	}

	@Override
	public String toString() {
		return "ManagerResourceEntity{" + "resourceName=" + resourceName + ", resourceLink=" + resourceLink
				+ ", resourceIcon=" + resourceIcon + ", resourceParent=" + resourceParent + ", resourceOrder="
				+ resourceOrder + "}";
	}
}
