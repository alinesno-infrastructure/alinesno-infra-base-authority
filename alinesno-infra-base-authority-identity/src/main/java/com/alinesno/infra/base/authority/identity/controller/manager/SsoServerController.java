package com.alinesno.infra.base.authority.identity.controller.manager;

import cn.dev33.satoken.sso.SaSsoProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 单点登陆服务端
 * @author luodong
 * @version 1.0.0
 */
@Slf4j
@RestController
public class SsoServerController {

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

}
