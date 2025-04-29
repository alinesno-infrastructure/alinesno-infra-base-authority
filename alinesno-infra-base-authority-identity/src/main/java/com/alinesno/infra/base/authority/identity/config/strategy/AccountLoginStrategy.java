package com.alinesno.infra.base.authority.identity.config.strategy;

import cn.hutool.core.util.PhoneUtil;
import cn.hutool.crypto.digest.BCrypt;
import com.alinesno.infra.base.authority.enums.LoginTypeEnums;
import com.alinesno.infra.base.authority.gateway.dto.AuthManagerAccountDto;
import com.alinesno.infra.base.authority.identity.config.BaseLoginStrategy;
import com.alinesno.infra.base.authority.identity.domain.dto.LoginUser;
import com.alinesno.infra.base.authority.service.IManagerAccountService;
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
    private IManagerAccountService accountConsumer ;

    @Override
    public AuthManagerAccountDto strategyDoLogin(LoginUser loginUser) {

        log.debug("账号登陆.");

        String loginName = loginUser.getUsername();

        boolean isPhone =  PhoneUtil.isPhone(loginName) ;
        Assert.isTrue(isPhone, "登陆账号必须是手机号") ;

        AuthManagerAccountDto account = accountConsumer.findByLoginNameWithRegister(
                loginUser.getUsername() ,
                loginUser.getPassword() ,
                LoginTypeEnums.ACCOUNT.getType());

        Assert.notNull(account , "账号["+loginUser.getUsername()+"]不存在");

        boolean isMatch = BCrypt.checkpw(loginUser.getPassword() , account.getPassword()) ;
        Assert.isTrue(isMatch , "登陆密码不正确");

        return account ;
    }

}
