package com.alinesno.infra.base.identity.auth.event.controller;

import cn.hutool.core.codec.Base64;
import com.alinesno.infra.base.identity.auth.constants.AuthConstants;
import com.alinesno.infra.base.identity.auth.domain.dto.SmsSendDto;
import com.alinesno.infra.base.identity.auth.notices.SmsNoticeResponse;
import com.alinesno.infra.base.identity.auth.notices.SmsService;
import com.alinesno.infra.common.core.cache.RedisUtils;
import com.alinesno.infra.common.core.constants.CacheConstants;
import com.alinesno.infra.common.core.constants.Constants;
import com.alinesno.infra.common.core.utils.StringUtils;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.security.api.annotation.RateLimiter;
import com.alinesno.infra.common.security.api.enums.LimitType;
import com.alinesno.infra.common.web.adapter.utils.IdUtils;
import com.google.code.kaptcha.Producer;
import io.jsonwebtoken.lang.Assert;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.dromara.sms4j.api.entity.SmsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.Duration;

/**
 * 生成验证二维码
 */
@Slf4j
@RestController
public class CaptchaController {

    @Resource(name = "captchaProducer")
    private Producer captchaProducer;

    @Resource(name = "captchaProducerMath")
    private Producer captchaProducerMath;

    @Autowired
    private SmsService smsService ;

    /**
     * 获取手机验证码
     */
    // 发送短信
    @RateLimiter(key = "#smsSend.phone" ,count = 1 , time = 60 , limitType = LimitType.CLUSTER , message = "请求过于频繁请一分钟后尝试.")
    @GetMapping("/registerCode")
    public AjaxResult registerCode(String phone , String code , String uuid) {

        Assert.hasLength(phone , "手机号为空.");
        Assert.hasLength(code , "系统验证码为空.");
        Assert.hasLength(uuid , "认证唯一标识为空.");

        // 验证手机验证码
        verifyCaptchaCode(code, uuid);

        String phoneCode = String.valueOf((int)((Math.random() * 9 + 1) * Math.pow(10,5)));

        // 保存验证码信息
        String verifyKey = AuthConstants.PHONE_CODE_KEY +  phone;
        SmsResponse result = smsService.sendMessage(phone , phoneCode , null) ;

        log.debug("sendMessagePhoneCode = {} , result = {}" , phone + ":" + phoneCode ,result);

        RedisUtils.setCacheObject(verifyKey, phoneCode, Duration.ofMinutes(AuthConstants.PHONE_CODE_EXPIRATION));

        return AjaxResult.success() ;
    }

    /**
     * 验证系统验证码
     * @param code
     * @param uuid
     */
    private static void verifyCaptchaCode(String code, String uuid) {
        // 验证系统验证码是否正确
        String verifyKey = CacheConstants.CAPTCHA_CODE_KEY + StringUtils.nvl(uuid, "");
        String captcha = RedisUtils.getCacheObject(verifyKey);

        log.debug("Redis缓存系统验证码 = {}" , captcha);

        RedisUtils.deleteObject(verifyKey);

        Assert.notNull(captcha , "系统验证码已过期");
        Assert.isTrue(code.equalsIgnoreCase(captcha) , "系统验证码不正确，请先输入正确系统验证码");
    }

    /**
     * 生成验证码
     */
    @GetMapping("/captchaImage")
    public AjaxResult captchaImage() throws IOException {
        AjaxResult ajax = AjaxResult.success();

        // 保存验证码信息
        String uuid = IdUtils.simpleUUID();
        String verifyKey = CacheConstants.CAPTCHA_CODE_KEY + uuid;

        // 生成验证码
        String capText = captchaProducerMath.createText();
        String capStr = capText.substring(0, capText.lastIndexOf("@"));
        String code = capText.substring(capText.lastIndexOf("@") + 1);
        BufferedImage image = captchaProducerMath.createImage(capStr);

        RedisUtils.setCacheObject(verifyKey, code, Duration.ofMinutes(Constants.CAPTCHA_EXPIRATION));

        // 转换流信息写出
        FastByteArrayOutputStream os = new FastByteArrayOutputStream();
        try {
            ImageIO.write(image, "jpg", os);
        } catch (IOException e) {
            return AjaxResult.error(e.getMessage());
        }

        ajax.put("uuid", uuid);
        ajax.put("img", Base64.encode(os.toByteArray()));

        return ajax;
    }
}