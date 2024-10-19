package com.alinesno.infra.base.identity.auth.notices.impl;

import com.alinesno.infra.base.identity.auth.enums.SmsProviderEnums;
import com.alinesno.infra.base.identity.auth.notices.SmsService;
import lombok.extern.slf4j.Slf4j;
import org.dromara.sms4j.api.SmsBlend;
import org.dromara.sms4j.api.entity.SmsResponse;
import org.dromara.sms4j.core.factory.SmsFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * 发送短信服务
 */
@Slf4j
@Component
public class SmsServiceImpl implements SmsService {

    @Override
    public SmsResponse sendMessage(String phone, String message, String configId) {

        if(!StringUtils.hasLength(configId)){
            configId = SmsProviderEnums.ALIYUN.getCode() ;
        }

        SmsBlend smsBlend = SmsFactory.getSmsBlend(configId);
        Assert.notNull(smsBlend, "短信服务配置[" + configId + "]不存在");

        SmsResponse smsResponse = smsBlend.sendMessage(phone, message);

        log.debug("smsResponse = {}", smsResponse.getData());

        return smsResponse ;
    }

}