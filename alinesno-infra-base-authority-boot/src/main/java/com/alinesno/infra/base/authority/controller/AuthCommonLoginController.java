package com.alinesno.infra.base.authority.controller;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.crypto.digest.BCrypt;
import com.alinesno.infra.base.authority.core.utils.DeviceTypeUtils;
import com.alinesno.infra.base.authority.gateway.dto.AuthManagerAccountDto;
import com.alinesno.infra.base.authority.gateway.dto.ManagerResourceDto;
import com.alinesno.infra.base.authority.service.IManagerAccountService;
import com.alinesno.infra.base.authority.service.IManagerResourceService;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.base.dto.LoginBodyDto;
import com.alinesno.infra.common.web.adapter.base.dto.ManagerAccountDto;
import com.alinesno.infra.common.web.adapter.login.account.CurrentAccountBean;
import com.alinesno.infra.common.web.adapter.login.account.CurrentAccountJwt;
import com.alinesno.infra.common.web.adapter.login.annotation.CurrentAccount;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
public class AuthCommonLoginController {

    @Value("${spring.application.id:projectCode}")
    private String projectCode ;

    @Autowired
    private IManagerResourceService managerResourceService ;

    @Autowired
    private IManagerAccountService accountService;

    /**
     * 令牌
     */
    public static final String TOKEN = "token";

    /**
     * 登录方法
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBodyDto loginBody , HttpServletRequest request) {
        AjaxResult ajax = AjaxResult.success();

        // 验证密码是否正确
        Assert.notNull(loginBody.getUsername() , "用户名不能为空") ;
        Assert.notNull(loginBody.getPassword() , "密码不能为空") ;

        AuthManagerAccountDto accountDto = accountService.findByLoginNameWithRegister(
                loginBody.getUsername() ,
                loginBody.getPassword() ,
                "account");

        boolean isMatch = BCrypt.checkpw(loginBody.getPassword() , accountDto.getPassword()) ;
        org.springframework.util.Assert.isTrue(isMatch , "登陆密码不正确");

        StpUtil.login(accountDto.getId() , DeviceTypeUtils.getDeviceType(request));

        ajax.put("token" , StpUtil.getTokenValue()) ;

        return ajax;
    }

    /**
     * 退出登陆
     * @return
     */
    @PostMapping("/logout")
    public AjaxResult logout() {
        StpUtil.logout();
        return AjaxResult.success();
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public AjaxResult getInfo(@CurrentAccount CurrentAccountBean account) {

        log.debug("account : {}" , account);

        long accountId = CurrentAccountJwt.getUserId() ;
        Assert.notNull(accountId , "用户未登录") ;

        Map<String, Object> accountInfo = accountService.getAccountInfo(accountId) ;

        SaSession session = StpUtil.getSession();

        // TODO 待处理重名的问题
        AuthManagerAccountDto dto = accountService.getManagerAccountDto(accountId) ;
        ManagerAccountDto dto2 = new ManagerAccountDto() ;
        BeanUtils.copyProperties(dto, dto2);

        session.set("CURRENT_ACCOUNT_DTO", dto2);

        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", accountInfo.get("user"));
        ajax.put("roles", accountInfo.get("roles"));
        ajax.put("permissions", accountInfo.get("permissions"));

        return ajax;
    }

    /**
     * 获取路由信息
     *
     * @return 路由信息
     */
    @GetMapping("getRouters")
    public AjaxResult getRouters() {

        // 查询代码不为空，提示配置spring.application.id
        if (projectCode != null && projectCode.isEmpty()) {
            return AjaxResult.error("项目代码不能为空，请在application.yml配置spring.application.id") ;
        }

        long accountId = CurrentAccountJwt.getUserId() ;

        ManagerResourceDto resourceDto = managerResourceService.findMenusByProjectCode(projectCode , accountId) ;

        return AjaxResult.success(resourceDto.getChildren()) ;
    }

}
