package com.alinesno.infra.base.identity.auth.config.strategy;

import cn.hutool.core.util.PhoneUtil;
import com.alibaba.fastjson.JSONObject;
import com.alinesno.infra.base.authority.gateway.dto.ManagerAccountDto;
import com.alinesno.infra.base.identity.auth.adapter.ManagerAccountConsumer;
import com.alinesno.infra.base.identity.auth.config.BaseLoginStrategy;
import com.alinesno.infra.base.identity.auth.domain.dto.LoginUser;
import com.alinesno.infra.common.facade.response.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * 短信登陆服务
 */
@Slf4j
@Service("smsLoginStrategy")
public class SmsLoginStrategy extends BaseLoginStrategy {

    @Autowired
    private ManagerAccountConsumer accountConsumer;

    @Override
    public ManagerAccountDto strategyDoLogin(LoginUser loginUser) {

        log.debug("手机验证码登陆.");

        String loginName = loginUser.getPhoneNumber();
        boolean isPhone = PhoneUtil.isPhone(loginName);

        Assert.isTrue(isPhone, "账号必须是手机号");

        // 判断用户是否已经存在，如果没有存在，则自动注册
        R<ManagerAccountDto> accountDtoR = accountConsumer.findByLoginNameWithRegister(loginUser.getPhoneNumber(), loginUser.getPassword());
        Assert.isTrue(accountDtoR.getCode() == 200, accountDtoR.getMsg());

        ManagerAccountDto accountDto = accountDtoR.getData();
        log.debug("accountDto = {}", JSONObject.toJSONString(accountDto));

        return accountDto;
    }

}


