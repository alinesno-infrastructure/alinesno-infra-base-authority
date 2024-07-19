package com.alinesno.infra.base.identity.auth.constants;

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
