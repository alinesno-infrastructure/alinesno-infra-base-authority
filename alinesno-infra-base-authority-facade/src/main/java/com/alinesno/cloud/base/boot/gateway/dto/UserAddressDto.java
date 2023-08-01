package com.alinesno.cloud.base.boot.gateway.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： user_address
 * 
 * @author LuoAnDong ${authorEmail}
 * @date 2021-08-04 19:24:39
 */
public class UserAddressDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "addressName"
	 */
	private String addressName;
	/**
	 * "floor"
	 */
	private String floor;
	/**
	 * "isUse"
	 */
	private String isUse;
	/**
	 * "owners"
	 */
	private String owners;
	/**
	 * "roomNum"
	 */
	private String roomNum;
	/**
	 * "useEndTime"
	 */
	private String useEndTime;
	/**
	 * "useStartTime"
	 */
	private String useStartTime;
	/**
	 * "userId"
	 */
	private String userId;

	// getter and setter
	public String getAddressName()

	{
		return this.addressName;
	}

	public UserAddressDto setAddressName(String arg) {
		this.addressName = arg;
		return this;
	}

	public String getFloor()

	{
		return this.floor;
	}

	public UserAddressDto setFloor(String arg) {
		this.floor = arg;
		return this;
	}

	public String getIsUse()

	{
		return this.isUse;
	}

	public UserAddressDto setIsUse(String arg) {
		this.isUse = arg;
		return this;
	}

	public String getOwners()

	{
		return this.owners;
	}

	public UserAddressDto setOwners(String arg) {
		this.owners = arg;
		return this;
	}

	public String getRoomNum()

	{
		return this.roomNum;
	}

	public UserAddressDto setRoomNum(String arg) {
		this.roomNum = arg;
		return this;
	}

	public String getUseEndTime()

	{
		return this.useEndTime;
	}

	public UserAddressDto setUseEndTime(String arg) {
		this.useEndTime = arg;
		return this;
	}

	public String getUseStartTime()

	{
		return this.useStartTime;
	}

	public UserAddressDto setUseStartTime(String arg) {
		this.useStartTime = arg;
		return this;
	}

	public String getUserId()

	{
		return this.userId;
	}

	public UserAddressDto setUserId(String arg) {
		this.userId = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public UserAddressDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, UserAddressDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public UserAddressDto fromDto(UserAddressDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, UserAddressDto.class);
	}

}
