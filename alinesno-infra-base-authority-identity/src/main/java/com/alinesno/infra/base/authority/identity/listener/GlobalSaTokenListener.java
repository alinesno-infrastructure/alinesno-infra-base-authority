package com.alinesno.infra.base.authority.identity.listener;

import cn.dev33.satoken.listener.SaTokenListener;
import cn.dev33.satoken.stp.SaLoginModel;
import cn.hutool.core.thread.ThreadUtil;
import com.alinesno.infra.base.authority.entity.ManagerAccountEntity;
import com.alinesno.infra.base.authority.identity.domain.LoginEventEntity;
import com.alinesno.infra.base.authority.identity.enums.LoginEventType;
import com.alinesno.infra.base.authority.identity.service.ILoginEventService;
import com.alinesno.infra.base.authority.service.IManagerAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 自定义侦听器的实现
 */
@Slf4j
@Component
public class GlobalSaTokenListener implements SaTokenListener {

    @Autowired
    private ILoginEventService loginEventService;

    @Autowired
    private IManagerAccountService managerAccountService ;

    /** 每次登录时触发 */
    @Override
    public void doLogin(String loginType, Object loginId, String tokenValue, SaLoginModel loginModel) {
        String eventDesc = String.format("账号 %s 登录成功 (loginType=%s), 会话凭证 token=%s", loginId, loginType, tokenValue);
        eventRecord(eventDesc, loginId, tokenValue, loginModel, LoginEventType.LOGIN);
    }

    /** 每次注销时触发 */
    @Override
    public void doLogout(String loginType, Object loginId, String tokenValue) {
        String eventDesc = String.format("账号 %s 注销登录 (loginType=%s), 会话凭证 token=%s", loginId, loginType, tokenValue);
        eventRecord(eventDesc, loginId, tokenValue, null, LoginEventType.LOGOUT);
    }

    /** 每次被踢下线时触发 */
    @Override
    public void doKickout(String loginType, Object loginId, String tokenValue) {
        String eventDesc = String.format("账号 %s 被踢下线 (loginType=%s), 会话凭证 token=%s", loginId, loginType, tokenValue);
        eventRecord(eventDesc, loginId, tokenValue, null, LoginEventType.KICKOUT);
    }

    /** 每次被顶下线时触发 */
    @Override
    public void doReplaced(String loginType, Object loginId, String tokenValue) {
        String eventDesc = String.format("账号 %s 被顶下线 (loginType=%s), 会话凭证 token=%s", loginId, loginType, tokenValue);
        eventRecord(eventDesc, loginId, tokenValue, null, LoginEventType.REPLACED);
    }

    /** 每次被封禁时触发 */
    @Override
    public void doDisable(String loginType, Object loginId, String service, int level, long disableTime) {
        String eventDesc = String.format("账号 %s [%s服务] 被封禁 (loginType=%s), 封禁等级=%d, 解封时间为 %s", loginId, service, loginType, level, new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(System.currentTimeMillis() + disableTime * 1000)));
        eventRecord(eventDesc, loginId, null, null, LoginEventType.DISABLE);
    }

    /** 每次被解封时触发 */
    @Override
    public void doUntieDisable(String loginType, Object loginId, String service) {
        String eventDesc = String.format("账号 %s [%s服务] 解封成功 (loginType=%s)", loginId, service, loginType);
        eventRecord(eventDesc, loginId, null, null, LoginEventType.UNTIE_DISABLE);
    }

    /** 每次二级认证时触发 */
    @Override
    public void doOpenSafe(String loginType, String tokenValue, String service, long safeTime) {
        String eventDesc = String.format("token 二级认证成功, 业务标识=%s, 有效期=%d秒, Token值=%s", service, safeTime, tokenValue);
        eventRecord(eventDesc, null, tokenValue, null, LoginEventType.OPEN_SAFE);
    }

    /** 每次退出二级认证时触发 */
    @Override
    public void doCloseSafe(String loginType, String tokenValue, String service) {
        String eventDesc = String.format("token 二级认证关闭, 业务标识=%s, Token值=%s", service, tokenValue);
        eventRecord(eventDesc, null, tokenValue, null, LoginEventType.CLOSE_SAFE);
    }

    /** 每次创建Session时触发 */
    @Override
    public void doCreateSession(String id) {
        String eventDesc = String.format("SaSession [%s] 创建成功", id);
        eventRecord(eventDesc, id, null, null, LoginEventType.CREATE_SESSION);
    }

    /** 每次注销Session时触发 */
    @Override
    public void doLogoutSession(String id) {
        String eventDesc = String.format("SaSession [%s] 注销成功", id);
        eventRecord(eventDesc, id, null, null, LoginEventType.LOGOUT_SESSION);
    }

    /** 每次Token续期时触发 */
    @Override
    public void doRenewTimeout(String tokenValue, Object loginId, long timeout) {
        String eventDesc = String.format("token 续期成功, %d 秒后到期, 帐号=%s, token值=%s ", timeout, loginId, tokenValue);
        eventRecord(eventDesc, loginId, tokenValue, null, LoginEventType.RENEW_TIMEOUT);
    }

    /**
     * 记录登陆类型
     *
     * @param eventDesc
     * @param loginId
     * @param tokenValue
     * @param loginModel
     * @param type
     */
    private void eventRecord(String eventDesc, Object loginId, String tokenValue, SaLoginModel loginModel, LoginEventType type) {

        ThreadUtil.execAsync(() -> {
            try{
                LoginEventEntity entity = new LoginEventEntity();
                entity.setLoginId(loginId != null ? loginId.toString() : null);
                entity.setEventDesc(eventDesc);

                if(entity.getLoginId() != null){
                    ManagerAccountEntity accountEntity = managerAccountService.getById(entity.getLoginId());
                    entity.setAccountName(accountEntity != null ? accountEntity.getName() : null);
                    entity.setAccountLoginName(accountEntity != null ? accountEntity.getLoginName() + ":"+ accountEntity.getPhone() : null);
                }

                entity.setTokenValue(tokenValue);
                if (loginModel != null) {
                    entity.setDevice(loginModel.getDevice());
                    entity.setLastingCookie(loginModel.getIsLastingCookie());
                    entity.setExtraData(loginModel.getExtraData() != null ? loginModel.getExtraData().toString() : null);
                    entity.setToken(loginModel.getToken());
                    entity.setTokenSignTag(loginModel.getTokenSignTag() + "");
                }
                entity.setEventType(type.getValue());
                entity.setEventTypeLabel(type.getLabel());

                loginEventService.save(entity);
            }catch(Exception e){
                log.error("记录登陆类型异常", e);
            }
        });
    }
}