package com.alinesno.infra.base.authority.entity;

import java.util.Date;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * <p>
 * 
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */

@SuppressWarnings("serial")
@TableName("content_post_type")
public class ContentPostTypeEntity extends InfraBaseEntity {
 
	/**
	 * 类型名称
	 */
	@Excel(name = "类型名称")
	@TableField("type_name")
	private String typeName;
	/**
	 * 添加时间
	 */
	@TableField("type_add_time")
	private Date typeAddTime;
	/**
	 * 类型状态
	 */
	@TableField("type_status")
	private Integer typeStatus;

	/**
	 * 父类主键
	 */
	@TableField
	private Long pid = 0l; // ResourceTypeEnmus.PLATFORM_RESOURCE_PARENT.value ;

 
	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Date getTypeAddTime() {
		return typeAddTime;
	}

	public void setTypeAddTime(Date typeAddTime) {
		this.typeAddTime = typeAddTime;
	}

	public Integer getTypeStatus() {
		return typeStatus;
	}

	public void setTypeStatus(Integer typeStatus) {
		this.typeStatus = typeStatus;
	}

	@Override
	public String toString() {
		return "ContentPostTypeEntity{" + "typeName=" + typeName + ", typeAddTime=" + typeAddTime + ", typeStatus="
				+ typeStatus + "}";
	}
}
