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

@TableName("user_pic")
public class UserPicEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	private String owners;
	@TableField("is_use")
	private String isUse;
	@TableField("pic_name")
	private String picName;
	@TableField("pic_path")
	private String picPath;
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

	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
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
		return "UserPicEntity{" + "owners=" + owners + ", isUse=" + isUse + ", picName=" + picName + ", picPath="
				+ picPath + ", useEndTime=" + useEndTime + ", useStartTime=" + useStartTime + ", userId=" + userId
				+ "}";
	}
}
