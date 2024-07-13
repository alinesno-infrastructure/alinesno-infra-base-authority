package com.alinesno.infra.base.identity.auth.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Sa-Token 权限认证示例 
 * 
 * @author click33
 * @since 2022-10-13
 */
@RestController
@RequestMapping("/api/base/identity/auth/kickout/")
public class KickoutController {

	// 将指定账号强制注销   ---- http://localhost:8081/kickout/logout?userId=10001
	@GetMapping("logout")
	public SaResult logout(long userId) {
		
		// 强制注销等价于对方主动调用了注销方法，再次访问会提示：Token无效。
		StpUtil.logout(userId);
		
		// 返回
		return SaResult.ok();
	}

	// 将指定账号踢下线   ---- http://localhost:8081/kickout/kickout?userId=10001
	@GetMapping("kickout")
	public SaResult kickout(long userId) {
		
		// 踢人下线不会清除Token信息，而是将其打上特定标记，再次访问会提示：Token已被踢下线。
		StpUtil.kickout(userId);
		
		// 返回
		return SaResult.ok();
	}
	
	// 根据Token值踢人    ---- http://localhost:8081/kickout/kickoutByTokenValue?tokenValue=xxxx-xxxx-xxxx-xxxx已登录账号的token值
	@GetMapping("kickoutByTokenValue")
	public SaResult kickoutByTokenValue(String tokenValue) {
		
		StpUtil.kickoutByTokenValue(tokenValue);
		
		// 返回
		return SaResult.ok();
	}
	
}
