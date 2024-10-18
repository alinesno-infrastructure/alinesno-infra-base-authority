package com.alinesno.infra.base.authority.security;

/**
 * 登陆认证异常
 */
public class LoginAuthException extends RuntimeException {

    public LoginAuthException(Throwable cause) {
        super(cause);
    }

}
