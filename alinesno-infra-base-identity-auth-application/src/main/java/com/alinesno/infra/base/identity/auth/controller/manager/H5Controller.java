package com.alinesno.infra.base.identity.auth.controller.manager;

import cn.dev33.satoken.sso.SaSsoUtil;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.alinesno.infra.base.identity.auth.domain.dto.LoginDetailsDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 前后台分离架构下集成SSO所需的代码 （SSO-Server端）
 * <p>（注：如果不需要前后端分离架构下集成SSO，可删除此包下所有代码）</p>
 * @author click33
 *
 */
@Slf4j
@RestController
public class H5Controller {
	
	/**
	 * 获取 redirectUrl 
	 */
	@PostMapping("/sso/getRedirectUrl")
	private Object getRedirectUrl(@RequestBody LoginDetailsDTO loginDetailsDTO) {

		log.debug("loginDetailsDTO = {} , StpUtil.isLogin = {}" , loginDetailsDTO.toString() , StpUtil.isLogin());

		// 未登录情况下，返回 code=401
		if(!StpUtil.isLogin()) {
			SaResult result = SaResult.code(200);

			Map<String , Object> map = new HashMap<>() ;
			map.put("sso_login" , false);
			map.put("redirect_url" , loginDetailsDTO.getRedirect()) ;

			result.setMap(map) ;

			return result ;
		}

		String redirectUrl = SaSsoUtil.buildRedirectUrl(StpUtil.getLoginId(), loginDetailsDTO.getClient(), loginDetailsDTO.getRedirect());
		SaResult result = SaResult.data(redirectUrl);

		Map<String , Object> map = new HashMap<>() ;
		map.put("sso_login" , true);
		map.put("redirect_url" , loginDetailsDTO.getRedirect());
		result.setMap(map) ;

		return result ;
	}

	// 全局异常拦截 
	@ExceptionHandler
	public SaResult handlerException(Exception e) {
		return SaResult.error(e.getMessage());
	}
	
}
