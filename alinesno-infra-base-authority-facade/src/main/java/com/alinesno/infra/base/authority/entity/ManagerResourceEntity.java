package com.alinesno.infra.base.authority.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.alinesno.infra.common.facade.mapper.id.SnowflakeIdWorker;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("manager_resource")
public class ManagerResourceEntity extends InfraBaseEntity {

	@Excel(name = "资源名称")
	@TableField("resource_name")
	@ColumnType(length = 255)
	@ColumnComment("资源名称")
	private String resourceName;

	@Excel(name = "资源链接")
	@TableField("resource_link")
	@ColumnType(length = 255)
	@ColumnComment("资源链接")
	private String resourceLink;

	@Excel(name = "资源图标")
	@TableField("resource_icon")
	@ColumnType(length = 255)
	@ColumnComment("资源图标")
	private String resourceIcon;

	@Excel(name = "资源父类")
	@TableField("resource_parent")
	@ColumnType
	@ColumnComment("资源父类")
	private Long resourceParent = 0L;

	@Excel(name = "组件路径")
	@TableField("component")
	@ColumnType
	@ColumnComment("组件路径")
	private String component;

	@Excel(name = "资源排序")
	@TableField("resource_order")
	@ColumnType
	@ColumnComment("资源排序")
	private Integer resourceOrder;

	@Excel(name = "菜单类型(0菜单|1小标题|9平台标题)")
	@TableField("menu_type")
	@ColumnType(length = 255)
	@ColumnComment("菜单类型(0菜单|1小标题|9平台标题)")
	private String menuType = "0"; // MenuEnums.MENU_ITEM.value ;

	@TableField("open_target")
	@ColumnType(length = 255)
	@ColumnComment("链接打开方式")
	private String openTarget;

	@Excel(name = "权限标识")
	@TableField("permission")
	@ColumnType(length = 255)
	@ColumnComment("权限标识")
	private String permission;

	@TableField("permission_script")
	@ColumnType(length = 255)
	@ColumnComment("权限脚本")
	private String permissionScript;

	@Excel(name = "是否可见", replace = {"隐藏_0", "显示_1"})
	@TableField("visible")
	@ColumnType
	@ColumnComment("是否可见")
	private boolean visible = true;

	@TableField("project_id")
	@ColumnType(length = 64)
	@ColumnComment("所属项目")
	private Long projectId;

	/**
	 * 菜单子类
	 */
	@TableField(exist = false)
	private List<ManagerResourceEntity> subResource;


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

}
