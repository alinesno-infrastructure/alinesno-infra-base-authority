package com.alinesno.infra.base.identity.auth.config.strategy;

import com.alibaba.fastjson.JSONObject;
import com.alinesno.infra.base.authority.gateway.dto.ManagerAccountDto;
import com.alinesno.infra.base.identity.auth.config.BaseLoginStrategy;
import com.alinesno.infra.base.identity.auth.adapter.ManagerAccountConsumer;
import com.alinesno.infra.base.identity.auth.domain.dto.LoginUser;
import com.alinesno.infra.common.core.utils.StringUtils;
import com.alinesno.infra.common.web.adapter.utils.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 短信登陆服务
 */
@Slf4j
@Service("smsLoginStrategy")
public class SmsLoginStrategy extends BaseLoginStrategy {

    @Autowired
    private ManagerAccountConsumer accountConsumer ;

    @Override
    public ManagerAccountDto strategyDoLogin(LoginUser loginUser) {

        log.debug("手机验证码登陆.");

        // 判断用户是否已经存在，如果没有存在，则自动注册
        ManagerAccountDto accountDto = accountConsumer.findByLoginName(loginUser.getPhoneNumber()) ;
        if(accountDto == null || StringUtils.isBlank(accountDto.getLoginName())){

            accountDto = new ManagerAccountDto() ;

            String loginName = loginUser.getPhoneNumber() ;
            String password = MD5Util.encode(loginUser.getPhoneNumber()) ;  // 设置临时密码
            String phone = loginUser.getPhoneNumber() ;

            accountDto.setLoginName(loginName);
            accountDto.setPassword(password);
            accountDto.setPhone(phone);

            accountConsumer.registerAccount(accountDto) ;
        }

        // 获取登陆用户
        accountDto = accountConsumer.findByLoginName(loginUser.getPhoneNumber()) ;
        log.debug("accountDto = {}" , JSONObject.toJSONString(accountDto));

        return accountDto;
    }

}


