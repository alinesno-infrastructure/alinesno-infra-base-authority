package com.alinesno.infra.base.authority.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@Data
@TableName("manager_position")
public class ManagerPositionEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 岗位名称
	 */
	@Excel(name = "岗位名称")
	@TableField("position_name")
	@ColumnType(length = 255)
	@ColumnComment("岗位名称")
	private String positionName;

	/**
	 * 岗位级别
	 */
	@Excel(name = "岗位级别")
	@TableField("position_rank")
	@ColumnType(length = 255)
	@ColumnComment("岗位级别")
	private String positionRank;

}
