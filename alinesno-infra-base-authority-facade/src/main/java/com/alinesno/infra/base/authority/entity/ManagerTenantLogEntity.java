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

@TableName("manager_tenant_log")
public class ManagerTenantLogEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 租户操作类型(0登陆/1退出/2充值/3提取)
	 */
	@TableField("action_type")
	private String actionType;
	/**
	 * 日志内容
	 */
	@TableField("log_content")
	private String logContent;
	/**
	 * 结束时间
	 */
	@TableField("end_time")
	private Date endTime;
	/**
	 * 日志渠道
	 */
	@TableField("log_channel")
	private String logChannel;
	/**
	 * 详细ip
	 */
	@TableField("log_ip")
	private String logIp;
	/**
	 * 日志机器码
	 */
	@TableField("log_machine")
	private String logMachine;
	/**
	 * 业务id
	 */
	@TableField("log_business_id")
	private String logBusinessId;

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getLogContent() {
		return logContent;
	}

	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getLogChannel() {
		return logChannel;
	}

	public void setLogChannel(String logChannel) {
		this.logChannel = logChannel;
	}

	public String getLogIp() {
		return logIp;
	}

	public void setLogIp(String logIp) {
		this.logIp = logIp;
	}

	public String getLogMachine() {
		return logMachine;
	}

	public void setLogMachine(String logMachine) {
		this.logMachine = logMachine;
	}

	public String getLogBusinessId() {
		return logBusinessId;
	}

	public void setLogBusinessId(String logBusinessId) {
		this.logBusinessId = logBusinessId;
	}

	@Override
	public String toString() {
		return "ManagerTenantLogEntity{" + "actionType=" + actionType + ", logContent=" + logContent + ", endTime="
				+ endTime + ", logChannel=" + logChannel + ", logIp=" + logIp + ", logMachine=" + logMachine
				+ ", logBusinessId=" + logBusinessId + "}";
	}
}
