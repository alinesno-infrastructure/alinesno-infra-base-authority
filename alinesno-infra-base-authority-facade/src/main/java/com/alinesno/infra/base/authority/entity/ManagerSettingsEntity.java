package com.alinesno.infra.base.authority.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.base.authority.enums.DataSourceScope;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 参数配置表
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("manager_settings")
public class ManagerSettingsEntity extends InfraBaseEntity {

	@Excel(name = "参数名称")
	@TableField("config_name")
	@ColumnType(length = 255)
	@ColumnComment("参数名称")
	private String configName;

	@Excel(name = "参数键名")
	@TableField("config_key")
	@ColumnType(length = 255)
	@ColumnComment("参数键名")
	private String configKey;

	@Excel(name = "参数键值")
	@TableField("config_value")
	@ColumnType(length = 255)
	@ColumnComment("参数键值")
	private String configValue;

	@Excel(name = "系统内置（Y是 N否）")
	@TableField("config_type")
	@ColumnType(length = 1)
	@ColumnComment("系统内置（Y是 N否）")
	private String configType;

	@Excel(name = "备注")
	@TableField("remark")
	@ColumnType(length = 128)
	@ColumnComment("备注")
	private String remark;

	@Excel(name = "数据范围")
	@TableField("data_scope")
	@ColumnType(length = 12)
	@ColumnComment("数据范围")
	private String dataScope = DataSourceScope.PROJECT_SCOPE.getValue();

	public ManagerSettingsEntity(String configName, String configKey, String configValue, String configType, String remark, String dataScope) {
		this.configName = configName;
		this.configKey = configKey;
		this.configValue = configValue;
		this.configType = configType;
		this.remark = remark;
		this.dataScope = dataScope;

	}
}
