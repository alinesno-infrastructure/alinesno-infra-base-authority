package com.alinesno.infra.base.authority.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@Data
@TableName("manager_template")
public class ManagerTemplateEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 模板名称
	 */
	@TableField("template_name")
	@ColumnType(length = 255)
	@ColumnComment("模板名称")
	private String templateName;

	/**
	 * 模板内容
	 */
	@TableField("template_content")
	@ColumnType
	@ColumnComment("模板内容")
	private String templateContent;

	/**
	 * 模板数据
	 */
	@TableField("template_data")
	@ColumnType
	@ColumnComment("模板数据")
	private String templateData;

	/**
	 * 模板时间
	 */
	@TableField("template_addtime")
	@ColumnType
	@ColumnComment("模板时间")
	private Date templateAddtime;

	/**
	 * 模板状态
	 */
	@TableField("template_status")
	@ColumnType(length = 255)
	@ColumnComment("模板状态")
	private String templateStatus;

	/**
	 * 所属菜单
	 */
	@TableField("resource_id")
	@ColumnType(length = 255)
	@ColumnComment("所属菜单")
	private String resourceId;

	/**
	 * 模板作者
	 */
	@TableField("template_owner")
	@ColumnType(length = 255)
	@ColumnComment("模板作者")
	private String templateOwner;

}
