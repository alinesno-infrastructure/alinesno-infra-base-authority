package com.alinesno.infra.base.authority.constants;

/**
 * 定义的变量信息
 */
/**
 * 认证模块常量接口。
 * 该接口定义了与认证相关的常量，用于在系统中表示各种认证相关的数据和配置。
 */
public interface AuthConstants {

    /**
     * 当前账号DTO的键名。
     * 用于存储和检索当前登录用户的账号信息。
     */
    String currentAccountDto = "CURRENT_ACCOUNT_DTO" ;

    /**
     * 默认base64头像
     */
    String defaultBase64Icon = "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" ;

    /**
     * 登录IP的键名。
     * 用于记录和存储用户登录时的IP地址。
     */
    String loginIP = "LOGIN_IP" ;

    /**
     * 登录IP所属地区的键名。
     * 用于记录和存储用户登录时的IP地址所属的地区信息。
     */
    String loginIP_AREA = "LOGIN_IP_AREA" ;

    /**
     * 用户浏览器的键名。
     * 用于记录和存储用户登录时使用的浏览器信息。
     */
    String browser = "BROWSER" ;

    /**
     * 用户操作系统的键名。
     * 用于记录和存储用户登录时使用的操作系统信息。
     */
    String osName = "OS_NAME" ;

    /**
     * 活跃会话超时时间的键名。
     * 用于配置和检索活跃会话的超时时间。
     */
    String activeTimeout = "ACTIVE_TIMEOUT" ;

    /**
     * 总会话超时时间的键名。
     * 用于配置和检索总会话的超时时间。
     */
    String totalTimeout = "TOTAL_TIMEOUT" ;

    /**
     * 手机验证码有效期，单位：分钟。
     * 定义了手机验证码的失效时间，过期的验证码将无法用于认证。
     */
    int PHONE_CODE_EXPIRATION = 2 ; // 验证码2分钟过期

    /**
     * 手机验证码的键名前缀。
     * 用于生成和存储手机验证码的键名，键名包含该前缀和用户的电话号码。
     */
    String PHONE_CODE_KEY = "phone_code_codes:";

}
