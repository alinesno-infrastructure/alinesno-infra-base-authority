package com.alinesno.infra.base.identity.auth.config.strategy;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.PhoneUtil;
import com.alibaba.fastjson.JSONObject;
import com.alinesno.infra.base.authority.gateway.dto.ManagerAccountDto;
import com.alinesno.infra.base.identity.auth.adapter.ManagerAccountConsumer;
import com.alinesno.infra.base.identity.auth.config.BaseLoginStrategy;
import com.alinesno.infra.base.identity.auth.domain.dto.LoginParamDto;
import com.alinesno.infra.base.identity.auth.domain.dto.LoginUser;
import com.alinesno.infra.common.core.utils.StringUtils;
import com.alinesno.infra.common.facade.response.R;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * 账号登陆服务
 */
@Slf4j
@Service("accountLoginStrategy")
public class AccountLoginStrategy extends BaseLoginStrategy {

    @Resource
    private ManagerAccountConsumer accountConsumer ;

    @Override
    public ManagerAccountDto strategyDoLogin(LoginUser loginUser) {

        log.debug("账号登陆.");

        String loginName = loginUser.getUsername();

        boolean isPhone =  PhoneUtil.isPhone(loginName) ;
        boolean isEmail = Validator.isEmail(loginName) ;

        Assert.isTrue(isPhone || isEmail , "账号必须是手机号或者邮箱") ;

        // 判断用户是否已经存在，如果没有存在，则自动注册
        R<ManagerAccountDto> accountDtoR = accountConsumer.findByLoginNameWithRegister(loginUser.getUsername() , loginUser.getPassword()) ;
        Assert.isTrue(accountDtoR.getCode() == 200, accountDtoR.getMsg());

        ManagerAccountDto accountDto = accountDtoR.getData() ;
        log.debug("accountDto = {}" , JSONObject.toJSONString(accountDto));

        return accountDto;
    }

}
