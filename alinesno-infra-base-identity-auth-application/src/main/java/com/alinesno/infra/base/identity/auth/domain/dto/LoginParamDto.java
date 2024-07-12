package com.alinesno.infra.base.identity.auth.domain.dto;

import lombok.Data;

@Data
public class LoginParamDto {
	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 用户密码
	 */
	private String password;

	/**
	 * 验证码
	 */
	private String code;

	/**
	 * 唯一标识
	 */
	private String uuid = "";

}
