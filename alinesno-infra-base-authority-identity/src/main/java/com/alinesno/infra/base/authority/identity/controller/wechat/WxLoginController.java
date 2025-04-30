package com.alinesno.infra.base.authority.identity.controller.wechat;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.PhoneUtil;
import com.alibaba.fastjson.JSONObject;
import com.alinesno.infra.base.authority.api.identity.IdentityConfigDto;
import com.alinesno.infra.base.authority.api.identity.WechatUserDto;
import com.alinesno.infra.base.authority.constants.AuthConstants;
import com.alinesno.infra.base.authority.identity.domain.WechatUserEntity;
import com.alinesno.infra.base.authority.identity.service.IIdentityConfigService;
import com.alinesno.infra.base.authority.identity.service.IWechatUserService;
import com.alinesno.infra.base.authority.identity.utils.WechatUtils;
import com.alinesno.infra.base.authority.service.IManagerAccountService;
import com.alinesno.infra.common.core.cache.RedisUtils;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.facade.response.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;

/**
 * 微信扫码登陆接口，微信登陆成功之后，进行账号绑定
 */
@Slf4j
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/wechat")
public class WxLoginController {

    private static final String SA_TOKEN_NAME = "satoken";

    @Autowired
    private IIdentityConfigService identityConfigService;

    @Autowired
    private IWechatUserService wechatUserService ;

    @Autowired
    private IManagerAccountService managerAccountService ;

    /**
     * 微信回调方法
     */
    @GetMapping("/callback")
    public AjaxResult callback(String code, String state) {
        log.info("微信回调方法 , code = {} , state = {}", code, state);

        IdentityConfigDto identityConfigDto = identityConfigService.getIdentityConfigDetail() ;

        // 获取 access_token
        JSONObject accessTokenResult = WechatUtils.getAccessToken(code , identityConfigDto.getWxAppId(), identityConfigDto.getWxAppSecret());
        if (accessTokenResult == null || accessTokenResult.containsKey("errcode")) {
            return AjaxResult.error("获取 access_token 失败，请重新登陆");
        }

        String accessToken = accessTokenResult.getString("access_token");
        String openid = accessTokenResult.getString("openid");

        // 将 accessToken 存储到 Redis 中，设置过期时间为 10 分钟（可根据需求调整）
        RedisUtils.setCacheObject(AuthConstants.WECHAT_ACCESS_KEY + openid, accessToken, Duration.ofMinutes(10));

        boolean isBing =  wechatUserService.isBindOpenId(openid) ;
        if (isBing) {
            WechatUserEntity user = wechatUserService.getByOpenId(openid);
            StpUtil.login(user.getAccountId()) ;
            AjaxResult result = AjaxResult.success("该微信已绑定账号，正在登陆") ;
            result.put("isBind" , true);
            result.put(SA_TOKEN_NAME , StpUtil.getTokenValue());
            return result ;
        }

        // 获取用户信息
        JSONObject userInfoResult = WechatUtils.getUserInfo(accessToken, openid);
        if (userInfoResult == null || userInfoResult.containsKey("errcode")) {
            return AjaxResult.error("获取用户信息失败");
        }

        return AjaxResult.success("获取用户信息成功", userInfoResult);
    }

    /**
     * 绑定系统内账号
     */
    @PostMapping("/bindPhone")
    public AjaxResult bindPhone(@RequestBody @Validated WechatUserDto dto) {

        // 检查 openid 是否存在于 Redis 中，即是否通过微信回调获取了 accessToken
        if (!RedisUtils.hasKey(AuthConstants.WECHAT_ACCESS_KEY + dto.getOpenid())) {
            return AjaxResult.error("非法请求，未获取到有效的 accessToken");
        }

        // 从 Redis 中获取 accessToken 并检查其有效性
        String accessToken = RedisUtils.getCacheObject(AuthConstants.WECHAT_ACCESS_KEY + dto.getOpenid());
        if (accessToken == null) {
            return AjaxResult.error("accessToken 已过期，请重新进行微信登录");
        }

        Assert.isTrue(PhoneUtil.isPhone(dto.getPhone()) , "手机号格式不正确");
        Assert.isTrue(managerAccountService.isPhoneExists(dto.getPhone()) , "登陆手机号不存在") ;
        Assert.isTrue(!wechatUserService.isBindPhone(dto.getOpenid() , dto.getPhone()) , "手机号已经被绑定") ;

        WechatUserEntity user = wechatUserService.saveWechatUser(dto);
        StpUtil.login(user.getAccountId()) ;

        AjaxResult result = AjaxResult.success("绑定成功") ;
        result.put(SA_TOKEN_NAME , StpUtil.getTokenValue());

        return result ;
    }

}