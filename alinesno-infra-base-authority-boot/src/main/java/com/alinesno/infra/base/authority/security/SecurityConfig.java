package com.alinesno.infra.base.authority.security;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import com.alinesno.infra.base.authority.security.properties.SecurityProperties;
import com.alinesno.infra.common.web.log.utils.SpringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
public class SecurityConfig implements WebMvcConfigurer {

    private final SecurityProperties securityProperties;

    /**
     * 注册sa-token的拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        log.debug("securityProperties = {}" , securityProperties.toString());

        String[] patterns = {
                "/*.html",
                "/**/*.html",
                "/**/*.css",
                "/**/*.js",
                "/favicon.ico",
                "/error",
                "/*/api-docs",
                "/*/api-docs/**",
                "/actuator",
                "/actuator/**",
                "/sso/**",
                "/v1/api/base/authority/account/**",
                "/v1/api/base/authority/organize/**",
                "/v1/api/base/authority/resource/**"
        };


        // 注册路由拦截器，自定义验证规则
        registry.addInterceptor(new SaInterceptor(handler -> {
                AllUrlHandler allUrlHandler = SpringUtils.getBean(AllUrlHandler.class);

//                for(String uri : allUrlHandler.getUrls()){
//                    log.debug("-->>> uri = {}", uri);
//                }

                // 登录验证 -- 排除多个路径
                SaRouter
                    // 获取所有的
                    .match(allUrlHandler.getUrls())
                    // 对未排除的路径进行检查
                    .check(() -> {

                        // 检查是否登录 是否有token
                        boolean isLogin = StpUtil.isLogin() ;
                        log.debug("isLogin = {}" , isLogin);

                        StpUtil.checkLogin();

                        // 检查 header 与 param 里的 clientid 与 token 里的是否一致
//                        String headerCid = ServletUtils.getRequest().getHeader(LoginHelper.CLIENT_KEY);
//                        String paramCid = ServletUtils.getParameter(LoginHelper.CLIENT_KEY);
//                        String clientId = StpUtil.getExtra(LoginHelper.CLIENT_KEY).toString();
//
//                        if (!StringUtils.equalsAny(clientId, headerCid, paramCid)) {
//                            // token 无效
//                            throw NotLoginException.newInstance(StpUtil.getLoginType(),
//                                "-100", "客户端ID与Token不匹配",
//                                StpUtil.getTokenValue());
//                        }

                        // 有效率影响 用于临时测试
                        log.debug("剩余有效时间: {} , 临时有效时间: {}", StpUtil.getTokenTimeout() , StpUtil.getTokenActiveTimeout());

                    });
            })).addPathPatterns("/**")
            // 排除不需要拦截的路径
//            .excludePathPatterns(securityProperties.getExcludes());
            .excludePathPatterns(patterns);
    }

}
