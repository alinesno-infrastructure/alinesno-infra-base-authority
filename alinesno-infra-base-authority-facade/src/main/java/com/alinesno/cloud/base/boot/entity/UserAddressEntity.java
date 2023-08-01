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

@TableName("user_address")
public class UserAddressEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 所属者
	 */
	@TableField("owners")
	private String owners;
	/**
	 * 地址名称
	 */
	@TableField("address_name")
	private String addressName;
	/**
	 * 是否使用
	 */
	@TableField("is_use")
	private String isUse;
	/**
	 * 结束使用时间
	 */
	@TableField("use_end_time")
	private String useEndTime;
	/**
	 * 开始使用时间
	 */
	@TableField("use_start_time")
	private String useStartTime;
	/**
	 * 所属用户
	 */
	@TableField("user_id")
	private String userId;
	/**
	 * 楼层
	 */
	@TableField
	private String floor;
	/**
	 * 房间号
	 */
	@TableField("room_num")
	private String roomNum;

	public String getOwners() {
		return owners;
	}

	public void setOwners(String owners) {
		this.owners = owners;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getIsUse() {
		return isUse;
	}

	public void setIsUse(String isUse) {
		this.isUse = isUse;
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

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	@Override
	public String toString() {
		return "UserAddressEntity{" + "owners=" + owners + ", addressName=" + addressName + ", isUse=" + isUse
				+ ", useEndTime=" + useEndTime + ", useStartTime=" + useStartTime + ", userId=" + userId + ", floor="
				+ floor + ", roomNum=" + roomNum + "}";
	}
}
