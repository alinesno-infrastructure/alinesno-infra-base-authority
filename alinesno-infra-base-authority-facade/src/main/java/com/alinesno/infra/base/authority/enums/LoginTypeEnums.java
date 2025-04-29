package com.alinesno.infra.base.authority.enums;

import lombok.Getter;

/**
 * 登陆类型
 */
@Getter
public enum LoginTypeEnums {

    SMS("sms" , "短信登陆") ,
    WECHAT("wechat" , "微信登陆") ,
    EMAIL("email" , "邮箱登陆") ,
    ACCOUNT("account" , "短信登陆") ;

    private final String type ;
    private final String label ;

    LoginTypeEnums(String type, String label) {
        this.type = type;
        this.label = label;
    }

}
