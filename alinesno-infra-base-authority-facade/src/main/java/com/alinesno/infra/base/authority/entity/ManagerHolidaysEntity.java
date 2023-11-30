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
 * 节假日设置
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@Data
@TableName("manager_holidays")
public class ManagerHolidaysEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 日期字符
	 */
	@Excel(name = "日期", format = "yyyy-MM-dd HH:mm:ss", width = 25)
	@TableField("holidays_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@ColumnType
	@ColumnComment("日期字符")
	private Date holidaysDate;

	/**
	 * 是否为节假日(1节假日|0非节假日)
	 */
	@Excel(name = "是否节假日", replace = { "否_0", "是_1" })
	@TableField("holidays")
	@ColumnType(length = 1)
	@ColumnComment("是否节假日(1节假日|0非节假日)")
	private String holidays;

}
