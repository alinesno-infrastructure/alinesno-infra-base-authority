package com.alinesno.infra.base.authority.identity.config.strategy;

import cn.hutool.core.util.PhoneUtil;
import com.alinesno.infra.base.authority.enums.LoginTypeEnums;
import com.alinesno.infra.base.authority.gateway.dto.AuthManagerAccountDto;
import com.alinesno.infra.base.authority.identity.config.BaseLoginStrategy;
import com.alinesno.infra.base.authority.identity.domain.dto.LoginUser;
import com.alinesno.infra.base.authority.service.IManagerAccountService;
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
    private IManagerAccountService accountConsumer;

    @Override
    public AuthManagerAccountDto strategyDoLogin(LoginUser loginUser) {

        log.debug("手机验证码登陆.");

        String loginName = loginUser.getPhoneNumber();
        boolean isPhone = PhoneUtil.isPhone(loginName);

        Assert.isTrue(isPhone, "账号必须是手机号");

        return accountConsumer.findByLoginNameWithRegister(
                loginUser.getPhoneNumber(),
                loginUser.getPassword() ,
                LoginTypeEnums.SMS.getType());
    }

}


