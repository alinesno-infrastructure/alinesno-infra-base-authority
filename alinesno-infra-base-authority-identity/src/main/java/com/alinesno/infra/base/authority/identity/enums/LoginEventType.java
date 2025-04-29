package com.alinesno.infra.base.authority.identity.enums;

import lombok.Getter;

/**
 * 登陆事件响应类型
 */
@Getter
public enum LoginEventType {

    LOGIN("doLogin", "登录"),
    LOGIN_SUCCESS("doLoginSuccess", "用户登录成功"),
    LOGOUT("doLogout", "注销"),
    KICKOUT("doKickout", "被踢下线"),
    REPLACED("doReplaced", "被顶下线"),
    DISABLE("doDisable", "被封禁"),
    UNTIE_DISABLE("doUntieDisable", "被解封"),
    OPEN_SAFE("doOpenSafe", "二级认证"),
    CLOSE_SAFE("doCloseSafe", "退出二级认证"),
    CREATE_SESSION("doCreateSession", "创建Session"),
    LOGOUT_SESSION("doLogoutSession", "注销Session"),
    RENEW_TIMEOUT("doRenewTimeout", "Token续期");

    private final String value;
    private final String label;

    LoginEventType(String value, String label) {
        this.value = value;
        this.label = label;
    }

}
