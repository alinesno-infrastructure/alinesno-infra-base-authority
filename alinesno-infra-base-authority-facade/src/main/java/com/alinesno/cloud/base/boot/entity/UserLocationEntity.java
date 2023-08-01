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

@TableName("user_location")
public class UserLocationEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	private String owners;
	private String latitude;
	private String longitude;
	private String precisions;
	@TableField("user_id")
	private String userId;

	public String getOwners() {
		return owners;
	}

	public void setOwners(String owners) {
		this.owners = owners;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getPrecisions() {
		return precisions;
	}

	public void setPrecisions(String precisions) {
		this.precisions = precisions;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserLocationEntity{" + "owners=" + owners + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", precisions=" + precisions + ", userId=" + userId + "}";
	}
}
