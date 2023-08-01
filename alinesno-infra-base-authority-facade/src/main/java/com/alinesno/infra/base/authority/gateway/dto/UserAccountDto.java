package com.alinesno.infra.base.authority.gateway.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： user_account
 * 
 * @author LuoAnDong ${authorEmail}
 * @date 2023-08-04 19:24:39
 */
public class UserAccountDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "accountStatus"
	 */
	private Long accountStatus;
	/**
	 * "loginAccount"
	 */
	private String loginAccount;
	/**
	 * "loginPassword"
	 */
	private String loginPassword;
	/**
	 * "phoneCode"
	 */
	private String phoneCode;
	/**
	 * "salt"
	 */
	private String salt;

	// getter and setter
	public Long getAccountStatus()

	{
		return this.accountStatus;
	}

	public UserAccountDto setAccountStatus(Long arg) {
		this.accountStatus = arg;
		return this;
	}

	public String getLoginAccount()

	{
		return this.loginAccount;
	}

	public UserAccountDto setLoginAccount(String arg) {
		this.loginAccount = arg;
		return this;
	}

	public String getLoginPassword()

	{
		return this.loginPassword;
	}

	public UserAccountDto setLoginPassword(String arg) {
		this.loginPassword = arg;
		return this;
	}

	public String getPhoneCode()

	{
		return this.phoneCode;
	}

	public UserAccountDto setPhoneCode(String arg) {
		this.phoneCode = arg;
		return this;
	}

	public String getSalt()

	{
		return this.salt;
	}

	public UserAccountDto setSalt(String arg) {
		this.salt = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public UserAccountDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, UserAccountDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public UserAccountDto fromDto(UserAccountDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, UserAccountDto.class);
	}

}
