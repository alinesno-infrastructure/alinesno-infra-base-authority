package com.alinesno.infra.base.identity.auth.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Sa-Token 身份切换 
 * 
 * @author click33
 * @since 2022-10-17 
 */
@Slf4j
@RestController
@RequestMapping("/api/base/identity/auth/switchTo/")
public class SwitchToController {

	// 以lambda表达式的方式身份切换    ---- http://localhost:8081/SwitchTo/switchTo2?userId=10044
	@GetMapping("toUser")
	public SaResult toUser(long userId) {
		
		// 输出 10001
		log.debug("------- [身份临时切换] 调用前，当前登录账号id是：" + StpUtil.getLoginId());
		
		// 以 lambda 表达式的方式身份切换，作用范围只在这个 lambda 表达式内有效 
		StpUtil.switchTo(userId, () -> {
		    log.debug("是否正在身份临时切换中: " + StpUtil.isSwitch());  // 输出 true
		    log.debug("获取当前登录账号id: " + StpUtil.getLoginId());   // 输出 10044
		});
		
		// 结束后，再次获取当前登录账号，输出10001
		log.debug("------- [身份临时切换] 调用结束，当前登录账号id是：" + StpUtil.getLoginId()); 

		return SaResult.ok();
	}
	
}

