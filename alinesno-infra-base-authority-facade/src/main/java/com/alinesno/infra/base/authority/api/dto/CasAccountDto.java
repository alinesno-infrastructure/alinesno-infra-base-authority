package com.alinesno.infra.base.authority.api.dto;

import java.util.Date;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： cas_account
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class CasAccountDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "account"
	 */
	private String account;
	/**
	 * "businessTime"
	 */
	private Date businessTime;
	/**
	 * "email"
	 */
	private String email;
	/**
	 * "hasStatusLabel"
	 */
	private String hasStatusLabel;
	/**
	 * "password"
	 */
	private String password;
	/**
	 * "phone"
	 */
	private String phone;

	// getter and setter
	public String getAccount()

	{
		return this.account;
	}

	public CasAccountDto setAccount(String arg) {
		this.account = arg;
		return this;
	}

	public Date getBusinessTime()

	{
		return this.businessTime;
	}

	public CasAccountDto setBusinessTime(Date arg) {
		this.businessTime = arg;
		return this;
	}

	public String getEmail()

	{
		return this.email;
	}

	public CasAccountDto setEmail(String arg) {
		this.email = arg;
		return this;
	}

	public String getHasStatusLabel()

	{
		return this.hasStatusLabel;
	}

	public CasAccountDto setHasStatusLabel(String arg) {
		this.hasStatusLabel = arg;
		return this;
	}

	public String getPassword()

	{
		return this.password;
	}

	public CasAccountDto setPassword(String arg) {
		this.password = arg;
		return this;
	}

	public String getPhone()

	{
		return this.phone;
	}

	public CasAccountDto setPhone(String arg) {
		this.phone = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public CasAccountDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, CasAccountDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public CasAccountDto fromDto(CasAccountDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, CasAccountDto.class);
	}

}
