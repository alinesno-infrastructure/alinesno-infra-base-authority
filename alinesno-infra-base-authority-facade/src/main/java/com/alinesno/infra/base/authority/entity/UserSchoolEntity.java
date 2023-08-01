package com.alinesno.infra.base.authority.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 
 * </p>
 *
 * @author WeiXiaoJin
 * @since 2018-12-16 17:53:19
 */

@TableName("user_school")
public class UserSchoolEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	private String owners;

	public String getOwners() {
		return owners;
	}

	public void setOwners(String owners) {
		this.owners = owners;
	}

	@Override
	public String toString() {
		return "UserSchoolEntity{" + "owners=" + owners + "}";
	}
}
