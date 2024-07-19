package com.alinesno.infra.base.identity.auth.enums;

import lombok.Getter;

/**
 * 登陆事件响应类型
 */
@Getter
public enum LoginEventType {

    LOGIN("doLogin", "每次登录时触发"),
    LOGIN_SUCCESS("doLoginSuccess", "用户登录成功"),
    LOGOUT("doLogout", "每次注销时触发"),
    KICKOUT("doKickout", "每次被踢下线时触发"),
    REPLACED("doReplaced", "每次被顶下线时触发"),
    DISABLE("doDisable", "每次被封禁时触发"),
    UNTIE_DISABLE("doUntieDisable", "每次被解封时触发"),
    OPEN_SAFE("doOpenSafe", "每次二级认证时触发"),
    CLOSE_SAFE("doCloseSafe", "每次退出二级认证时触发"),
    CREATE_SESSION("doCreateSession", "每次创建Session时触发"),
    LOGOUT_SESSION("doLogoutSession", "每次注销Session时触发"),
    RENEW_TIMEOUT("doRenewTimeout", "每次Token续期时触发");

    private final String value;
    private final String label;

    LoginEventType(String value, String label) {
        this.value = value;
        this.label = label;
    }

}
