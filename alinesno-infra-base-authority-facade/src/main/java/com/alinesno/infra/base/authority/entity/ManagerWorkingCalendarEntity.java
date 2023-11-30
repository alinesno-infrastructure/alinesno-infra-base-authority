package com.alinesno.infra.base.authority.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 个人工作日历
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@Data
@TableName("manager_working_calendar")
public class ManagerWorkingCalendarEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 工作开始时间
	 */
	@TableField("working_end_time")
	@ColumnType
	@ColumnComment("工作开始时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date workingEndTime;

	/**
	 * 工作内容
	 */
	@TableField("working_content")
	@ColumnType(length = 255)
	@ColumnComment("工作内容")
	private String workingContent;

	/**
	 * 工作结束时间
	 */
	@TableField("working_start_time")
	@ColumnType
	@ColumnComment("工作结束时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date workingStartTime;

	/**
	 * 工作类型
	 */
	@TableField("working_type")
	@ColumnType(length = 255)
	@ColumnComment("工作类型")
	private String workingType;

}
