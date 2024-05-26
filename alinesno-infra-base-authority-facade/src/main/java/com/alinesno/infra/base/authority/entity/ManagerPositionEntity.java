package com.alinesno.infra.base.authority.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@TableName("manager_position")
public class ManagerPositionEntity extends InfraBaseEntity {

	@TableField("position_code")
	@ColumnType(length = 32)
	@ColumnComment("岗位代码")
	private String positionCode ;

	@TableField("position_name")
	@ColumnType(length = 64)
	@ColumnComment("岗位名称")
	private String positionName;

	@TableField("position_rank")
	@ColumnType(length = 11)
	@ColumnComment("岗位级别")
	private String positionRank;

	@TableField("position_sort")
	@ColumnType(length = 11)
	@ColumnComment("岗位顺序")
	private String positionSort;

	@TableField("remark")
	@ColumnType(length = 128)
	@ColumnComment("备注")
	private String remark;

}
