package com.alinesno.infra.base.identity.auth.event.controller;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.sign.SaSignUtil;
import cn.dev33.satoken.sso.SaSsoProcessor;
import cn.dev33.satoken.util.SaResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 单点登陆服务端
 * @author luodong
 * @version 1.0.0
 */
@Slf4j
@RestController
public class ServerController {

	/*
	 * SSO-Server端：处理所有SSO相关请求 
	 * 		http://{host}:{port}/sso/auth			-- 单点登录授权地址，接受参数：redirect=授权重定向地址 
	 * 		http://{host}:{port}/sso/doLogin		-- 账号密码登录接口，接受参数：name、pwd 
	 * 		http://{host}:{port}/sso/checkTicket	-- Ticket校验接口（isHttp=true时打开），接受参数：ticket=ticket码、ssoLogoutCall=单点注销回调地址 [可选] 
	 * 		http://{host}:{port}/sso/signout		-- 单点注销地址（isSlo=true时打开），接受参数：loginId=账号id、secretkey=接口调用秘钥 
	 */
	@GetMapping("/sso/*")
	public Object ssoRequestForGet() {
		return SaSsoProcessor.instance.serverDister();
	}

	@PostMapping("/sso/*")
	public Object ssoRequestForPost() {
		return SaSsoProcessor.instance.serverDister();
	}

	@PutMapping("/sso/*")
	public Object ssoRequestForPut() {
		return SaSsoProcessor.instance.serverDister();
	}

	@DeleteMapping("/sso/*")
	public Object ssoRequestForDelete() {
		return SaSsoProcessor.instance.serverDister();
	}

	// 示例：获取数据接口（用于在模式三下，为 client 端开放拉取数据的接口）
	@GetMapping("/sso/getData")
	public SaResult getData(String apiType, String loginId) {
		System.out.println("---------------- 获取数据 ----------------");
		System.out.println("apiType=" + apiType);
		System.out.println("loginId=" + loginId);

		// 校验签名：只有拥有正确秘钥发起的请求才能通过校验
		SaSignUtil.checkRequest(SaHolder.getRequest());

		// 自定义返回结果（模拟）
		return SaResult.ok()
				.set("id", loginId)
				.set("name", "LinXiaoYu")
				.set("sex", "女")
				.set("age", 18);
	}

}
