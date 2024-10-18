package com.alinesno.infra.common.web.adapter.sso.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置SaToken
 *
 * @author luoxiaodong
 * @since 2023年8月2日 上午6:23:43
 */
@Slf4j
@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {

//	// 注册拦截器
////	@Override
////	public void addInterceptors(InterceptorRegistry registry) {
////		// 注册 Sa-Token 拦截器，打开注解式鉴权功能
////		// registry.addInterceptor(new SaInterceptor()).addPathPatterns("/**");
////	}
//
//	// Sa-Token 整合 jwt
//	@Bean
//	public StpLogic getStpLogicJwt() {
//		return new StpLogicJwtForSimple();
//	}
//
//	/**
//	 * 注册 [Sa-Token全局过滤器]
//	 */
////	@Bean
////	public SaServletFilter getSaServletFilter() {
////		return new SaServletFilter()
////
////				// 指定 拦截路由 与 放行路由
////				.addInclude("/**").addExclude("/favicon.ico") /* 排除掉 /favicon.ico */
////
////				// 认证函数: 每次请求执行
////				.setAuth(obj -> {
////					log.debug("---------- 进入Sa-Token全局认证 -----------");
////
////					// 登录认证 -- 拦截所有路由，并排除/user/doLogin 用于开放登录
////					SaRouter.match("/**", "/user/doLogin", StpUtil::checkLogin);
////
////					// 更多拦截处理方式，请参考“路由拦截式鉴权”章节 */
////				})
////
////				// 异常处理函数：每次认证函数发生异常时执行此函数
////				.setError(e -> {
////					log.debug("---------- 进入Sa-Token异常处理 -----------");
////					return SaResult.error(e.getMessage());
////				})
////
////				// 前置函数：在每次认证函数之前执行（BeforeAuth 不受 includeList 与 excludeList 的限制，所有请求都会进入）
////				.setBeforeAuth(r -> {
////					// ---------- 设置一些安全响应头 ----------
////					SaHolder.getResponse()
////							// 服务器名称
////							.setServer("sa-server")
////							// 是否可以在iframe显示视图： DENY=不可以 | SAMEORIGIN=同域下可以 | ALLOW-FROM uri=指定域名下可以
////							.setHeader("X-Frame-Options", "SAMEORIGIN")
////							// 是否启用浏览器默认XSS防护： 0=禁用 | 1=启用 | 1; mode=block 启用, 并在检查到XSS攻击时，停止渲染页面
////							.setHeader("X-XSS-Protection", "1; mode=block")
////							// 禁用浏览器内容嗅探
////							.setHeader("X-Content-Type-Options", "nosniff");
////				});
////	}
//
//	/**
//	 * 重写 Sa-Token 框架内部算法策略
//	 */
//	@Autowired
//	public void rewriteSaStrategy() {
//		// 重写 Token 生成策略
//		SaStrategy.instance.createToken = (loginId, loginType) -> {
//			return SaFoxUtil.getRandomString(60); // 随机60位长度字符串
//		};
//	}
}
