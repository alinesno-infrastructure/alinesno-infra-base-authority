package com.alinesno.infra.base.authority.adapter;

import com.alinesno.infra.common.facade.response.AjaxResult;
import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Query;

/**
 * 单点登陆账户操作接口
 */
//@BaseRequest(baseURL = "#{alinesno.infra.gateway.base-identity-auth.host}" , connectTimeout = 30*1000)
@BaseRequest(baseURL = "http://alinesno-infra-base-identity-auth-application.beta.base.infra.linesno.com" , connectTimeout = 30*1000)
public interface IdentityAccountConsumer {

    // 将指定账号强制注销
    @Get(url="/api/base/identity/auth/kickout/logout")
    AjaxResult logout(@Query String userId) ;

    // 将指定账号踢下线
    @Get(url="/api/base/identity/auth/kickout/kickout")
    AjaxResult kickout(@Query String userId) ;

    // 根据 Token 值踢人
    @Get(url="/api/base/identity/auth/kickout/kickoutByTokenValue")
    AjaxResult kickoutByTokenValue(@Query String tokenValue) ;

    // 封禁指定账号
    @Get(url = "/api/base/identity/auth/disable/disable")
    AjaxResult disable(@Query String userId);

    // 解封指定账号
    @Get(url = "/api/base/identity/auth/disable/untieDisable")
    AjaxResult untieDisable(@Query String userId);

    // 以 lambda 表达式的方式身份切换
    @Get(url = "/api/base/identity/auth/switchTo/toUser")
    AjaxResult toUser(@Query String userId);

    // 会话查询接口
    @Get(url="/api/base/identity/auth/search/getList")
    AjaxResult getList(@Query("keyword") String keyword , @Query("start") int start, @Query("size") int size) ;
}
