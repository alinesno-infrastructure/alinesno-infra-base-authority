package com.alinesno.infra.base.authority.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
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
 * 
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@Data
@TableName("manager_tenant")
public class ManagerTenantEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 租户名称
	 */
	@Excel(name = "租户名称")
	@TableField("tenant_name")
	@ColumnType(length = 255)
	@ColumnComment("租户名称")
	private String tenantName;

	/**
	 * 开始时间
	 */
	@Excel(name = "开始时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@TableField("start_time")
	@ColumnType
	@ColumnComment("开始时间")
	private Date startTime;

	/**
	 * 结束时间
	 */
	@Excel(name = "结束时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@TableField("end_time")
	@ColumnType
	@ColumnComment("结束时间")
	private Date endTime;

	/**
	 * 租户状态(1正常/0禁止)
	 */
	@TableField("tenant_status")
	@ColumnType(length = 1)
	@ColumnComment("租户状态(1正常/0禁止)")
	private String tenantStatus;

	/**
	 * 租户账户
	 */
	@TableField("tenant_account")
	@ColumnType(length = 255)
	@ColumnComment("租户账户")
	private String tenantAccount;

	/**
	 * 租房费用
	 */
	@Excel(name = "租房费用")
	@TableField("tenant_cost")
	@ColumnType
	@ColumnComment("租房费用")
	private Integer tenantCost;

	/**
	 * 所属城市
	 */
	@TableField("city_id")
	@ColumnType(length = 255)
	@ColumnComment("所属城市")
	private String cityId;

	/**
	 * 所属省份
	 */
	@TableField("province_id")
	@ColumnType(length = 255)
	@ColumnComment("所属省份")
	private String provinceId;

	/**
	 * 租户地址
	 */
	@Excel(name = "租户地址")
	@TableField("tenant_address")
	@ColumnType(length = 255)
	@ColumnComment("租户地址")
	private String tenantAddress;

	/**
	 * 租户联系电话
	 */
	@Excel(name = "租户联系电话")
	@TableField("tenant_phone")
	@ColumnType(length = 255)
	@ColumnComment("租户联系电话")
	private String tenantPhone;

}
