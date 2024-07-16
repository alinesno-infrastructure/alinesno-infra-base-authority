package com.alinesno.infra.base.authority.adapter;

import cn.dev33.satoken.util.SaResult;
import com.alinesno.infra.base.authority.api.SaSessionInfoDto;
import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Query;

import java.util.List;

/**
 * 单点登陆账户操作接口
 */
@BaseRequest(baseURL = "#{sa-token.host-path}" , connectTimeout = 30*1000)
public interface IdentityAccountConsumer {

    // 将指定账号强制注销
    @Get(url="/api/base/identity/auth/kickout/logout")
    SaResult logout(@Query String userId) ;

    // 将指定账号踢下线
    @Get(url="/api/base/identity/auth/kickout/kickout")
    SaResult kickout(@Query String userId) ;

    // 根据 Token 值踢人
    @Get(url="/api/base/identity/auth/kickout/kickoutByTokenValue")
    SaResult kickoutByTokenValue(@Query String tokenValue) ;

    // 封禁指定账号
    @Get(url = "/api/base/identity/auth/disable/disable")
    SaResult disable(@Query String userId);

    // 解封指定账号
    @Get(url = "/api/base/identity/auth/disable/untieDisable")
    SaResult untieDisable(@Query String userId);

    // 以 lambda 表达式的方式身份切换
    @Get(url = "/api/base/identity/auth/switchTo/toUser")
    SaResult toUser(@Query String userId);

    // 会话查询接口
    @Get(url="/api/base/identity/auth/search/getList")
    List<SaSessionInfoDto> getList(@Query("keyword") String keyword , @Query("start") int start, @Query("size") int size) ;
}
