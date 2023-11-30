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
@TableName("manager_tenant_log")
public class ManagerTenantLogEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 租户操作类型(0登陆/1退出/2充值/3提取)
	 */
	@TableField("action_type")
	@ColumnType(length = 1)
	@ColumnComment("租户操作类型(0登陆/1退出/2充值/3提取)")
	private String actionType;

	/**
	 * 日志内容
	 */
	@TableField("log_content")
	@ColumnType(length = 255)
	@ColumnComment("日志内容")
	private String logContent;

	/**
	 * 结束时间
	 */
	@TableField("end_time")
	@ColumnType
	@ColumnComment("结束时间")
	private Date endTime;

	/**
	 * 日志渠道
	 */
	@TableField("log_channel")
	@ColumnType(length = 255)
	@ColumnComment("日志渠道")
	private String logChannel;

	/**
	 * 详细ip
	 */
	@TableField("log_ip")
	@ColumnType(length = 255)
	@ColumnComment("详细ip")
	private String logIp;

	/**
	 * 日志机器码
	 */
	@TableField("log_machine")
	@ColumnType(length = 255)
	@ColumnComment("日志机器码")
	private String logMachine;

	/**
	 * 业务id
	 */
	@TableField("log_business_id")
	@ColumnType(length = 255)
	@ColumnComment("业务id")
	private String logBusinessId;

}
