package com.alinesno.infra.base.authority.identity.utils;

import com.alibaba.fastjson.JSONObject;
import com.alinesno.infra.base.authority.api.identity.IdentityConfigDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * 微信工具类
 */
@Slf4j
public class WechatUtils {

    private static final RestTemplate restTemplate = new RestTemplate();

    // 微信获取 access_token 接口
    private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token";

    // 微信获取用户信息接口
    private static final String USER_INFO_URL = "https://api.weixin.qq.com/sns/userinfo";

    /**
     * 通过 code 获取 access_token
     * @param code 授权码
     * @return 包含 access_token 信息的 JSONObject
     */
    public static JSONObject getAccessToken(String code , String appId , String appSecret) {

        String url = ACCESS_TOKEN_URL +
                "?appid=" + appId +
                "&secret=" + appSecret +
                "&code=" + code +
                "&grant_type=authorization_code";
        log.debug("url = {}" , url);

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class) ;
        if (response.getStatusCode() != HttpStatus.OK) {
            log.error("获取 access_token 请求失败，状态码: {}", response.getStatusCode());
            return null;
        }

        JSONObject result = JSONObject.parseObject(response.getBody());
        if (result.containsKey("errcode")) {
            log.error("获取 access_token 失败: {}", result.getString("errmsg"));
        }
        return result;
    }

    /**
     * 通过 access_token 和 openid 获取用户信息
     * @param accessToken 访问令牌
     * @param openid 用户唯一标识
     * @return 包含用户信息的 JSONObject
     */
    public static JSONObject getUserInfo(String accessToken, String openid) {
        String url = USER_INFO_URL + "?access_token="+accessToken+"&openid=" + openid;

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class) ;
        if (response.getStatusCode() != HttpStatus.OK) {
            log.error("获取用户信息请求失败，状态码: {}", response.getStatusCode());
            return null;
        }

        JSONObject result = JSONObject.parseObject(response.getBody());
        if (result.containsKey("errcode")) {
            log.error("获取用户信息失败: {}", result.getString("errmsg"));
        }
        return result;
    }

}
