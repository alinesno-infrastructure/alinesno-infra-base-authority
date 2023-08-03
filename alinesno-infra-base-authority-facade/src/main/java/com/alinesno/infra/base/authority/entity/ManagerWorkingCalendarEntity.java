package com.alinesno.infra.base.authority.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 个人工作日历
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */

@TableName("manager_working_calendar")
public class ManagerWorkingCalendarEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 工作开始时间
	 */
	@TableField("working_end_time")
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date workingEndTime;
	/**
	 * 工作内容
	 */
	@TableField("working_content")
	private String workingContent;
	/**
	 * 工作结束时间
	 */
	@TableField("working_start_time")
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date workingStartTime;
	/**
	 * 工作类型
	 */
	@TableField("working_type")
	private String workingType;

	public Date getWorkingEndTime() {
		return workingEndTime;
	}

	public void setWorkingEndTime(Date workingEndTime) {
		this.workingEndTime = workingEndTime;
	}

	public String getWorkingContent() {
		return workingContent;
	}

	public void setWorkingContent(String workingContent) {
		this.workingContent = workingContent;
	}

	public Date getWorkingStartTime() {
		return workingStartTime;
	}

	public void setWorkingStartTime(Date workingStartTime) {
		this.workingStartTime = workingStartTime;
	}

	public String getWorkingType() {
		return workingType;
	}

	public void setWorkingType(String workingType) {
		this.workingType = workingType;
	}

	@Override
	public String toString() {
		return "ManagerWorkingCalendarEntity{" + "workingEndTime=" + workingEndTime + ", workingContent="
				+ workingContent + ", workingStartTime=" + workingStartTime + ", workingType=" + workingType + "}";
	}
}
