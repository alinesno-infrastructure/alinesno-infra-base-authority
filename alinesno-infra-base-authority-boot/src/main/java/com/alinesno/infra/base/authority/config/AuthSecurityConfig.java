package com.alinesno.infra.base.authority.config;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.stp.StpUtil;
import com.alinesno.infra.common.web.adapter.login.security.SecurityProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 权限安全配置
 *
 * @author Lion Li
 * @author luoxiaodong
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
@RequiredArgsConstructor
public class AuthSecurityConfig implements WebMvcConfigurer {

    private final SecurityProperties securityProperties;

    @Autowired
    private AuthCurrentAccountMethodArgumentResolver currentAccountMethodArgumentResolver ;

    //把自定义解析器添加到解析器集合当中
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(currentAccountMethodArgumentResolver);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        log.debug("securityProperties = {}", securityProperties.toString());

        String[] patterns = securityProperties.getExcludes() ;

        // 注册 Sa-Token 拦截器，校验规则为 StpUtil.checkLogin() 登录校验。
        registry.addInterceptor(new SaInterceptor(handle -> {

            try {
                StpUtil.checkLogin();
            } catch (NotLoginException e) {
                log.error("未登录，跳转登录页面");
                throw e ;
            }

            long loginId = StpUtil.getLoginIdAsLong();
            log.debug("loginId = {}", loginId);
        }))
        .addPathPatterns("/**")
        .excludePathPatterns(patterns);
    }

}
