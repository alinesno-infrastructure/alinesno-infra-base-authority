package com.alinesno.infra.base.authority.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@Data
@TableName("manager_search")
public class ManagerSearchEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 资源Id
	 */
	@TableField("resource_id")
	@ColumnType(length = 255)
	@ColumnComment("资源Id")
	private String resourceId;

	/**
	 * 显示名称
	 */
	@ColumnType(length = 255)
	@ColumnComment("显示名称")
	private String label;

	/**
	 * 字段名称
	 */
	@ColumnType(length = 255)
	@ColumnComment("字段名称")
	private String name;

	/**
	 * 字段属性
	 */
	@TableField("option_json")
	@ColumnType(length = 255)
	@ColumnComment("字段属性")
	private String optionJson;

	/**
	 * 操作类型(input/select),默认为input
	 */
	@TableField("search_type")
	@ColumnType(length = 255)
	@ColumnComment("操作类型(input/select)，默认为input")
	private String searchType;

	/**
	 * 默认值
	 */
	@TableField("default_value")
	@ColumnType(length = 255)
	@ColumnComment("默认值")
	private String defaultValue;

	/**
	 * 是否为日期(空则不是|否则是)
	 */
	@TableField("has_date")
	@ColumnType(length = 255)
	@ColumnComment("是否为日期(空则不是|否则是)")
	private String hasDate;

	/**
	 * 响应脚本
	 */
	@TableField("search_script")
	@ColumnType(length = 255)
	@ColumnComment("响应脚本")
	private String searchScript;

	/**
	 * 字典类型
	 */
	@TableField("dict")
	@ColumnType(length = 255)
	@ColumnComment("字典类型")
	private String dictType;

}
