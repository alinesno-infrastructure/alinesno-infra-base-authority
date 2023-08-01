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
 * @since 2018-12-16 17:53:19
 */

@TableName("user_professional")
public class UserProfessionalEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	private String owners;
	@TableField("is_use")
	private String isUse;
	@TableField("professional_name")
	private String professionalName;
	@TableField("use_end_time")
	private String useEndTime;
	@TableField("use_start_time")
	private String useStartTime;
	@TableField("user_id")
	private String userId;

	public String getOwners() {
		return owners;
	}

	public void setOwners(String owners) {
		this.owners = owners;
	}

	public String getIsUse() {
		return isUse;
	}

	public void setIsUse(String isUse) {
		this.isUse = isUse;
	}

	public String getProfessionalName() {
		return professionalName;
	}

	public void setProfessionalName(String professionalName) {
		this.professionalName = professionalName;
	}

	public String getUseEndTime() {
		return useEndTime;
	}

	public void setUseEndTime(String useEndTime) {
		this.useEndTime = useEndTime;
	}

	public String getUseStartTime() {
		return useStartTime;
	}

	public void setUseStartTime(String useStartTime) {
		this.useStartTime = useStartTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserProfessionalEntity{" + "owners=" + owners + ", isUse=" + isUse + ", professionalName="
				+ professionalName + ", useEndTime=" + useEndTime + ", useStartTime=" + useStartTime + ", userId="
				+ userId + "}";
	}
}
