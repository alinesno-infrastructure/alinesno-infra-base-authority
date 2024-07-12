package com.alinesno.infra.base.identity.auth.domain.dto;

import cn.dev33.satoken.context.model.SaRequest;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginUser {

    public static final LoginUser ANON_USER = new LoginUser(0l , "anon_user");

    private long userId ;
    private String loginType;
    private String phoneNumber;
    private String phoneCode;
    private String username;
    private String password;
    private boolean rememberMe = false;
    private String code;
    private String uuid;

    private static Gson gson = new Gson();

    public LoginUser(long userId, String username) {
        this.userId = userId ;
        this.username = username ;
    }

    public static LoginUser convertParamListToUser(SaRequest request) {

        LoginUser user = JSONObject.parseObject(request.getParamNames().get(0) , LoginUser.class) ;
        log.debug("jsonObject = {}" , user);

        return user;
    }

}
