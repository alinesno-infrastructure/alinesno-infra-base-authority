package com.alinesno.infra.base.identity.auth.event.controller;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.session.TokenSign;
import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSONObject;
import com.alinesno.infra.base.authority.gateway.dto.ManagerAccountDto;
import com.alinesno.infra.base.identity.auth.constants.AuthConstants;
import com.alinesno.infra.base.identity.auth.domain.dto.SaSessionInfoDto;
import com.alinesno.infra.base.identity.auth.domain.dto.TokenSignDto;
import com.alinesno.infra.common.facade.response.AjaxResult;
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
	public AjaxResult getList(int start, int size , String keyword) {

		keyword = StringUtils.isNotBlank(keyword)?keyword:"" ;

		// 创建集合
		List<SaSessionInfoDto> sessionList = new ArrayList<>();

		// 分页查询数据 
		List<String> sessionIdList = StpUtil.searchSessionId(keyword, start, size, false);
		for (String sessionId: sessionIdList) {

			SaSession session = StpUtil.getSessionBySessionId(sessionId);

			if(session.get(AuthConstants.CURRENT_ACCOUNT_DTO) != null){
				SaSessionInfoDto sessionDto = getSaSessionInfoDto(session);
				sessionList.add(sessionDto);
			}
		}

		// 返回 
		return AjaxResult.success(sessionList);
	}

	@NotNull
	private static SaSessionInfoDto getSaSessionInfoDto(SaSession session) {
		ManagerAccountDto managerAccountDto = (ManagerAccountDto) session.get(AuthConstants.CURRENT_ACCOUNT_DTO);
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

		sessionDto.setTokenSignList(signDtos);
		return sessionDto;
	}

}
