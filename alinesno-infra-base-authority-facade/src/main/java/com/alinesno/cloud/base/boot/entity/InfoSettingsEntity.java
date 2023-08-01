package com.alinesno.cloud.base.boot.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 *
 * </p>
 *
 * @author WeiXiaoJin
 * @since 2018-12-16 17:53:19
 */

@TableName("info_settings")
public class InfoSettingsEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	@TableField
	private String owners;

	public String getOwners() {
		return owners;
	}

	public void setOwners(String owners) {
		this.owners = owners;
	}

	@Override
	public String toString() {
		return "InfoSettingsEntity{" + "owners=" + owners + "}";
	}
}
