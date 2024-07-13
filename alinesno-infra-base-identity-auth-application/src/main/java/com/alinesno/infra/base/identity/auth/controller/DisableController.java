package com.alinesno.infra.base.identity.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;

/**
 * Sa-Token 账号封禁示例 
 * 
 * @author click33
 * @since 2022-10-17 
 */
@RestController
@RequestMapping("/api/base/identity/auth/disable/")
public class DisableController {

	/*
	 * 测试步骤：
	 	1、访问登录接口，可以正常登录    ---- http://localhost:8081/disable/login?userId=10001
	 	2、注销登录    ---- http://localhost:8081/disable/logout
	 	3、禁用账号    ---- http://localhost:8081/disable/disable?userId=10001
	 	4、再次访问登录接口，登录失败    ---- http://localhost:8081/disable/login?userId=10001
	 	5、解封账号    ---- http://localhost:8081/disable/untieDisable?userId=10001
	 	6、再次访问登录接口，登录成功    ---- http://localhost:8081/disable/login?userId=10001
	 */
	// 封禁指定账号  ---- http://localhost:8081/disable/disable?userId=10001
	@GetMapping("disable")
	public SaResult disable(long userId) {
		/*
		 * 账号封禁：
		 * 	参数1：要封禁的账号id
		 * 	参数2：要封禁的时间，单位：秒，86400秒=1天
		 */
		StpUtil.disable(userId, 86400);
		return SaResult.ok("账号 " + userId + " 封禁成功");
	}

	// 解封指定账号  ---- http://localhost:8081/disable/untieDisable?userId=10001
	@GetMapping("untieDisable")
	public SaResult untieDisable(long userId) {
		StpUtil.untieDisable(userId);
		return SaResult.ok("账号 " + userId + " 解封成功");
	}

}
