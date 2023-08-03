package com.alinesno.infra.base.authority.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 *
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */

@TableName("info_professional")
public class InfoProfessionalEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	@TableField
	private String owners;

	@TableField("professional_name")
	private String professionalName;

	@TableField("professional_prop")
	private String professionalProp;

	public String getOwners() {
		return owners;
	}

	public void setOwners(String owners) {
		this.owners = owners;
	}

	public String getProfessionalName() {
		return professionalName;
	}

	public void setProfessionalName(String professionalName) {
		this.professionalName = professionalName;
	}

	public String getProfessionalProp() {
		return professionalProp;
	}

	public void setProfessionalProp(String professionalProp) {
		this.professionalProp = professionalProp;
	}

	@Override
	public String toString() {
		return "InfoProfessionalEntity{" + "owners=" + owners + ", professionalName=" + professionalName
				+ ", professionalProp=" + professionalProp + "}";
	}
}
