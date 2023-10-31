package com.alinesno.infra.base.authority.entity;

import java.util.Date;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.afterturn.easypoi.excel.annotation.Excel;
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
@SuppressWarnings("serial")
@TableName("content_post_type")
public class ContentPostTypeEntity extends InfraBaseEntity {

	/**
	 * 类型名称
	 */
	@ColumnType(length = 100)
	@ColumnComment("类型名称")
	@TableField("type_name")
	@Excel(name = "类型名称")
	private String typeName;

	/**
	 * 添加时间
	 */
	@ColumnType
	@ColumnComment("添加时间")
	@TableField("type_add_time")
	private Date typeAddTime;

	/**
	 * 类型状态
	 */
	@ColumnType
	@ColumnComment("类型状态")
	@TableField("type_status")
	private Integer typeStatus;

	/**
	 * 父类主键
	 */
	@ColumnType
	@ColumnComment("父类主键")
	@TableField
	private Long pid = 0L; // ResourceTypeEnmus.PLATFORM_RESOURCE_PARENT.value ;
}
