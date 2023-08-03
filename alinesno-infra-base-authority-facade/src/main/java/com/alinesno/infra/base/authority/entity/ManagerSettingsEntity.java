package com.alinesno.infra.base.authority.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * <p>
 * 参数配置表
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */

@TableName("manager_settings")
public class ManagerSettingsEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 参数名称
	 */
	@Excel(name = "参数名称")
	@TableField("config_name")
	private String configName;
	/**
	 * 参数键名
	 */
	@Excel(name = "参数键名")
	@TableField("config_key")
	private String configKey;
	/**
	 * 参数键值
	 */
	@Excel(name = "参数键值")
	@TableField("config_value")
	private String configValue;
	/**
	 * 系统内置（Y是 N否）
	 */
	@Excel(name = "系统内置（Y是 N否）")
	@TableField("config_type")
	private String configType;
	/**
	 * 备注
	 */
	@Excel(name = "备注")
	@TableField("config_remark")
	private String configRemark;

	public String getConfigName() {
		return configName;
	}

	public void setConfigName(String configName) {
		this.configName = configName;
	}

	public String getConfigKey() {
		return configKey;
	}

	public void setConfigKey(String configKey) {
		this.configKey = configKey;
	}

	public String getConfigValue() {
		return configValue;
	}

	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}

	public String getConfigType() {
		return configType;
	}

	public void setConfigType(String configType) {
		this.configType = configType;
	}

	public String getConfigRemark() {
		return configRemark;
	}

	public void setConfigRemark(String configRemark) {
		this.configRemark = configRemark;
	}

	@Override
	public String toString() {
		return "ManagerSettingsEntity{" + "configName=" + configName + ", configKey=" + configKey + ", configValue="
				+ configValue + ", configType=" + configType + ", configRemark=" + configRemark + "}";
	}
}
