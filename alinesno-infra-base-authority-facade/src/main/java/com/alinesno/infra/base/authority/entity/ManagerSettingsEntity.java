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
 * 参数配置表
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@Data
@TableName("manager_settings")
public class ManagerSettingsEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 参数名称
	 */
	@Excel(name = "参数名称")
	@TableField("config_name")
	@ColumnType(length = 255)
	@ColumnComment("参数名称")
	private String configName;

	/**
	 * 参数键名
	 */
	@Excel(name = "参数键名")
	@TableField("config_key")
	@ColumnType(length = 255)
	@ColumnComment("参数键名")
	private String configKey;

	/**
	 * 参数键值
	 */
	@Excel(name = "参数键值")
	@TableField("config_value")
	@ColumnType(length = 255)
	@ColumnComment("参数键值")
	private String configValue;

	/**
	 * 系统内置（Y是 N否）
	 */
	@Excel(name = "系统内置（Y是 N否）")
	@TableField("config_type")
	@ColumnType(length = 1)
	@ColumnComment("系统内置（Y是 N否）")
	private String configType;

	/**
	 * 备注
	 */
	@Excel(name = "备注")
	@TableField("config_remark")
	@ColumnType(length = 255)
	@ColumnComment("备注")
	private String configRemark;

}
