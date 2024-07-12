package com.alinesno.infra.base.identity.auth.config;

import com.alinesno.infra.base.authority.gateway.dto.ManagerAccountDto;
import com.alinesno.infra.base.identity.auth.constants.AuthConstants;
import com.alinesno.infra.base.identity.auth.domain.dto.LoginUser;
import com.alinesno.infra.base.identity.auth.enums.LoginTypeEnums;
import com.alinesno.infra.common.core.cache.RedisUtils;
import com.alinesno.infra.common.core.constants.CacheConstants;
import com.alinesno.infra.common.core.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

/**
 * 用户登陆基础类，实现多种登陆策略父类
 */
@Slf4j
public abstract class BaseLoginStrategy {

    /**
     * 用户登陆
     * @return
     */
    public ManagerAccountDto doLogin(LoginUser loginUser){

        // 验证登陆信息是否正确
        validateLoginKey(loginUser) ;

        return strategyDoLogin(loginUser) ;
    }

    /**
     * 自定义登陆
     * @param loginUser
     * @return
     */
    public abstract ManagerAccountDto strategyDoLogin(LoginUser loginUser) ;

    /**
     * 处理登陆验证的问题
     * @param loginUser
     */
    public void validateLoginKey(LoginUser loginUser){

        // 验证手机验证码是否过期
        if(loginUser.getLoginType().equals(LoginTypeEnums.SMS.getType())){

            String phoneVerifyKey = AuthConstants.PHONE_CODE_KEY +  loginUser.getPhoneNumber();
            String phoneCaptcha = RedisUtils.getCacheObject(phoneVerifyKey);

            log.debug("Redis缓存手机验证码 = {}" , phoneCaptcha);

            RedisUtils.deleteObject(phoneVerifyKey);

            Assert.notNull(phoneCaptcha , "手机验证码已过期，请重新发送验证码");
            Assert.isTrue(loginUser.getPhoneCode().equalsIgnoreCase(phoneCaptcha) , "手机验证码不正确");

        }else if(loginUser.getLoginType().equals(LoginTypeEnums.ACCOUNT.getType())){  // 账号密码登陆

            // 验证系统验证码是否过期
            String verifyKey = CacheConstants.CAPTCHA_CODE_KEY + StringUtils.nvl(loginUser.getUuid(), "");
            String captcha = RedisUtils.getCacheObject(verifyKey);

            log.debug("Redis缓存系统验证码 = {}" , captcha);

            RedisUtils.deleteObject(verifyKey);

            Assert.notNull(captcha , "系统验证码已过期");
            Assert.isTrue(loginUser.getCode().equalsIgnoreCase(captcha) , "系统验证码不正确");
        }

    }

}
