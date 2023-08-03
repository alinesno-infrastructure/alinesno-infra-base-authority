package com.alinesno.infra.base.authority.entity;

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
@TableName("manager_position")
public class ManagerPositionEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 岗位名称
	 */
	@Excel(name = "岗位名称")
	@TableField("position_name")
	private String positionName;
	/**
	 * 岗位级别
	 */
	@Excel(name = "岗位级别")
	@TableField("position_rank")
	private String positionRank;

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getPositionRank() {
		return positionRank;
	}

	public void setPositionRank(String positionRank) {
		this.positionRank = positionRank;
	}

	@Override
	public String toString() {
		return "ManagerPositionEntity{" + "positionName='" + positionName + '\'' + ", positionRank='" + positionRank
				+ '\'' + '}';
	}
}
