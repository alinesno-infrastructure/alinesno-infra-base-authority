package com.alinesno.infra.base.identity.auth.listener;

import cn.dev33.satoken.listener.SaTokenListener;
import cn.dev33.satoken.stp.SaLoginModel;
import com.alinesno.infra.base.identity.auth.domain.LoginEventEntity;
import com.alinesno.infra.base.identity.auth.event.LoginTypeEvent;
import com.alinesno.infra.base.identity.auth.event.PublishService;
import com.alinesno.infra.base.identity.auth.enums.LoginEventType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

/**
 * 自定义侦听器的实现 
 */
@Slf4j
@Component
public class GlobalSaTokenListener implements SaTokenListener {

    @Autowired
    private PublishService publishService;

    /** 每次登录时触发 */
    @Override
    public void doLogin(String loginType, Object loginId, String tokenValue, SaLoginModel loginModel) {
        log.debug("---------- 自定义侦听器实现 doLogin");
        eventRecord(loginType , loginId , tokenValue , loginModel , LoginEventType.LOGIN) ;
    }

    /** 每次注销时触发 */
    @Override
    public void doLogout(String loginType, Object loginId, String tokenValue) {
        log.debug("---------- 自定义侦听器实现 doLogout");
        eventRecord(loginType , loginId , tokenValue , null, LoginEventType.LOGOUT) ;
    }

    /** 每次被踢下线时触发 */
    @Override
    public void doKickout(String loginType, Object loginId, String tokenValue) {
        log.debug("---------- 自定义侦听器实现 doKickout");
        eventRecord(loginType , loginId , tokenValue , null , LoginEventType.KICKOUT) ;
    }

    /** 每次被顶下线时触发 */
    @Override
    public void doReplaced(String loginType, Object loginId, String tokenValue) {
        log.debug("---------- 自定义侦听器实现 doReplaced");
        eventRecord(loginType , loginId , tokenValue , null , LoginEventType.REPLACED) ;
    }

    /** 每次被封禁时触发 */
    @Override
    public void doDisable(String loginType, Object loginId, String service, int level, long disableTime) {
        log.debug("---------- 自定义侦听器实现 doDisable");
        eventRecord(loginType , loginId , null , null , LoginEventType.DISABLE) ;
    }

    /** 每次被解封时触发 */
    @Override
    public void doUntieDisable(String loginType, Object loginId, String service) {
        log.debug("---------- 自定义侦听器实现 doUntieDisable");
        eventRecord(loginType , loginId , null , null , LoginEventType.UNTIE_DISABLE) ;
    }

    /** 每次二级认证时触发 */
    @Override
    public void doOpenSafe(String loginType, String tokenValue, String service, long safeTime) {
        log.debug("---------- 自定义侦听器实现 doOpenSafe");
        eventRecord(loginType , null, tokenValue , null , LoginEventType.OPEN_SAFE) ;
    }

    /** 每次退出二级认证时触发 */
    @Override
    public void doCloseSafe(String loginType, String tokenValue, String service) {
        log.debug("---------- 自定义侦听器实现 doCloseSafe");
        eventRecord(loginType , null , tokenValue , null , LoginEventType.CLOSE_SAFE) ;
    }

    /** 每次创建Session时触发 */
    @Override
    public void doCreateSession(String id) {
        log.debug("---------- 自定义侦听器实现 doCreateSession");
    }

    /** 每次注销Session时触发 */
    @Override
    public void doLogoutSession(String id) {
        log.debug("---------- 自定义侦听器实现 doLogoutSession");
    }

    /** 每次Token续期时触发 */
    @Override
    public void doRenewTimeout(String tokenValue, Object loginId, long timeout) {
        log.debug("---------- 自定义侦听器实现 doRenewTimeout");
    }

    /**
     * 记录登陆类型
     *
     * @param loginType
     * @param loginId
     * @param tokenValue
     * @param loginModel
     * @param type
     */
    private void eventRecord(String loginType, Object loginId, String tokenValue, SaLoginModel loginModel, LoginEventType type) {

        LoginEventEntity entity = new LoginEventEntity() ;
        entity.setEventType(type.getLabel() + ":" + type.getValue());

        LoginTypeEvent loginTypeEvent = new LoginTypeEvent(entity) ;

        CompletableFuture.runAsync(() -> {
            publishService.publishEvent(loginTypeEvent);
        });

    }
}
