package com.alinesno.infra.base.authority.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 区域表
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@Data
@TableName("info_address")
public class InfoAddressEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	@ColumnType
	@ColumnComment("父ID")
	@TableField("parent_id")
	private Long parentId;

	@ColumnType(length = 100)
	@ColumnComment("区域名称")
	@Excel(name = "区域名称")
	@TableField("district_name")
	private String districtName;

	@ColumnType(length = 100)
	@ColumnComment("简称")
	@Excel(name = "简称")
	@TableField("short_name")
	private String shortName;

	@ColumnType
	@ColumnComment("经度")
	@Excel(name = "经度")
	@TableField
	private BigDecimal longitude;

	@ColumnType
	@ColumnComment("维度")
	@Excel(name = "维度")
	@TableField
	private BigDecimal latitude;

	@ColumnType
	@ColumnComment("等级")
	@Excel(name = "等级")
	@TableField
	private Integer level;

	@ColumnType
	@ColumnComment("排序")
	@Excel(name = "排序")
	@TableField
	private Integer sort;

	@ColumnType
	@ColumnComment("删除标志: 0未删除，1已删除")
	@TableField("is_deleted")
	private Integer isDeleted;

	@ColumnType
	@ColumnComment("创建时间")
	@Excel(name = "创建时间")
	@TableField("create_time")
	private Date createTime;

}
