package com.alinesno.infra.base.identity.auth.controller.manager;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.session.TokenSign;
import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSONObject;
import com.alinesno.infra.base.authority.api.SaSessionInfoDto;
import com.alinesno.infra.base.authority.api.TokenSignDto;
import com.alinesno.infra.base.authority.gateway.dto.ManagerAccountDto;
import com.alinesno.infra.base.identity.auth.constants.AuthConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Sa-Token 会话查询示例 
 * 
 * @author click33
 * @since 2022-10-17 
 */
@Slf4j
@RestController
@RequestMapping("/api/base/identity/auth/search/")
public class SearchSessionController {

	// 会话查询接口
	@GetMapping("getList")
	public List<SaSessionInfoDto> getList(int start, int size , String keyword) {

		keyword = StringUtils.isNotBlank(keyword)?keyword:"" ;

		// 创建集合
		List<SaSessionInfoDto> sessionList = new ArrayList<>();

		// 分页查询数据 
		List<String> sessionIdList = StpUtil.searchSessionId(keyword, start, size, false);
		for (String sessionId: sessionIdList) {

			SaSession session = StpUtil.getSessionBySessionId(sessionId);

			if(session.get(AuthConstants.currentAccountDto) != null){
				SaSessionInfoDto sessionDto = getSaSessionInfoDto(session);
				sessionList.add(sessionDto);
			}
		}

		// 返回 
		return sessionList ;
	}

	@NotNull
	private static SaSessionInfoDto getSaSessionInfoDto(SaSession session) {
		ManagerAccountDto managerAccountDto = (ManagerAccountDto) session.get(AuthConstants.currentAccountDto);
		log.debug("-->>> managerAccountDto = {}" , JSONObject.toJSONString(managerAccountDto));

		SaSessionInfoDto sessionDto = new SaSessionInfoDto() ;
		BeanUtils.copyProperties(managerAccountDto , sessionDto);
		BeanUtils.copyProperties(session, sessionDto);
		sessionDto.setUserId(managerAccountDto.getId());

		List<TokenSign> signs = session.getTokenSignList() ;
		List<TokenSignDto> signDtos = new ArrayList<>() ;

		for(TokenSign tokenSign : signs){
			TokenSignDto signDto = new TokenSignDto() ;
			BeanUtils.copyProperties(tokenSign, signDto);
			signDtos.add(signDto) ;
		}

		String token = session.getToken() ;
		long tokenTimeout = StpUtil.getTokenTimeout(token) ;
		long sessionTimeout = session.getTimeout() ;
		long disableTime = StpUtil.getDisableTime(token) ;

		String browser = session.getString(AuthConstants.browser) ;
		String osName =  session.getString(AuthConstants.osName) ;
		String loginIP = session.getString(AuthConstants.loginIP) ;
		String loginArea = session.getString(AuthConstants.loginIP_AREA) ;

		// 登陆信息
		sessionDto.setBrowser(browser);
		sessionDto.setOsName(osName);
		sessionDto.setLoginIP(loginIP);
		sessionDto.setLoginArea(loginArea);

		// 浏览器信息
		sessionDto.setTokenTimeout(tokenTimeout);
		sessionDto.setSessionTimeout(sessionTimeout);
		sessionDto.setDisableTime(disableTime);

		sessionDto.setTokenSignList(signDtos);

		return sessionDto;
	}

}
