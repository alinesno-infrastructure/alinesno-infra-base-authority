package com.alinesno.infra.base.authority.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

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
@TableName("manager_group")
public class ManagerGroupEntity extends InfraBaseEntity {

	/**
	 * 机构名称
	 */
	@Excel(name = "机构名称")
	@TableField("group_name")
	@ColumnType(length = 32)
	@ColumnComment("机构名称")
	private String groupName;

	@Excel(name = "机构代码")
	@TableField("group_code")
	@ColumnType(length = 32)
	@ColumnComment("机构代码")
	private String groupCode;

	@Excel(name = "机构描述")
	@TableField("remark")
	@ColumnType(length = 255)
	@ColumnComment("机构描述")
	private String remark;

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
	 * 机构状态(1正常/0禁止)
	 */
	@TableField("group_status")
	@ColumnType(length = 1)
	@ColumnComment("机构状态(1正常/0禁止)")
	private String groupStatus;

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
	 * 机构地址
	 */
	@Excel(name = "机构地址")
	@TableField("group_address")
	@ColumnType(length = 255)
	@ColumnComment("机构地址")
	private String groupAddress;

	/**
	 * 机构联系电话
	 */
	@Excel(name = "机构联系电话")
	@TableField("group_phone")
	@ColumnType(length = 255)
	@ColumnComment("机构联系电话")
	private String groupPhone;

}
