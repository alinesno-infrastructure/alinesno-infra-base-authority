package com.alinesno.infra.base.authority.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * <p>
 * 节假日设置
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */

@TableName("manager_holidays")
public class ManagerHolidaysEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 日期字符
	 */
	@Excel(name = "日期", format = "yyyy-MM-dd HH:mm:ss", width = 25)
	@TableField("holidays_date")
	@JSONField(format = "yyyy-MM-dd")
	private Date holidaysDate;
	/**
	 * 是否为节假日(1节假日|0非节假日)
	 */
	@Excel(name = "是否节假日", replace = { "否_0", "是_1" })
	@TableField
	private String holidays;

	public Date getHolidaysDate() {
		return holidaysDate;
	}

	public void setHolidaysDate(Date holidaysDate) {
		this.holidaysDate = holidaysDate;
	}

	public String getHolidays() {
		return holidays;
	}

	public void setHolidays(String holidays) {
		this.holidays = holidays;
	}

	@Override
	public String toString() {
		return "ManagerHolidaysEntity{" + "holidaysDate=" + holidaysDate + ", holidays=" + holidays + "}";
	}
}
