package com.alinesno.infra.base.authority.identity.config;

import cn.dev33.satoken.config.SaSsoConfig;
import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.alinesno.infra.base.authority.gateway.dto.AuthManagerAccountDto;
import com.alinesno.infra.base.authority.identity.domain.dto.LoginUser;
import com.alinesno.infra.base.authority.identity.event.PublishService;
import com.alinesno.infra.common.core.context.SpringContext;
import com.dtflys.forest.Forest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
@Slf4j
public class SaTokenConfigure {

    @Autowired
    private PublishService publishService;

    // 配置SSO相关参数
    @Autowired
    private void configSso(SaSsoConfig sso) {

        // 配置：未登录时返回的View
        sso.setNotLoginView(() -> {
            return new ModelAndView("index.html");
        });

        // 配置：登录处理函数
        sso.setDoLoginHandle((name, pwd) -> {

            LoginUser loginUser = LoginUser.convertParamListToUser(SaHolder.getRequest()) ;

            BaseLoginStrategy loginStrategy = (BaseLoginStrategy) SpringContext.getBean(loginUser.getLoginType() + "LoginStrategy");
            AuthManagerAccountDto accountDto = loginStrategy.doLogin(loginUser) ;

            log.debug("accountDto = {}" , accountDto);

            accountDto.setPassword(null);
            StpUtil.login(accountDto.getId());

            return SaResult.ok("登录成功！").setData(StpUtil.getTokenValue());
        });

        // 配置 Http 请求处理器 （在模式三的单点注销功能下用到，如不需要可以注释掉）
        sso.setSendHttp(url -> {
            try {
                return Forest.get(url).executeAsString();
            } catch (Exception e) {
                log.error("发起请求异常:{}" , e.getMessage());
                return null;
            }
        });
    }
}
