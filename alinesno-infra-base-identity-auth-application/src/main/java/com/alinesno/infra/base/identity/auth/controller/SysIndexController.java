package com.alinesno.infra.base.identity.auth.controller;

import com.alinesno.infra.base.identity.auth.config.IdentityAuthConfig;
import com.alinesno.infra.common.core.utils.StringUtils;
import com.alinesno.infra.common.facade.response.AjaxResult;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页
 *
 * @author luoxiaodong
 */
@RestController
public class SysIndexController {

    /** 系统基础配置 */
    @Autowired
    private IdentityAuthConfig identityConfig;

    /**
     * 访问首页，提示语
     */
    @RequestMapping("/")
    public String index() {
        return StringUtils.format("欢迎使用【{}】后台管理框架，当前版本：v{}，请通过前端地址访问。", identityConfig.getSystemName(), identityConfig.getVersion());
    }

    /**
     * 访问首页，提示语
     */
    @SneakyThrows
    @RequestMapping("/identityInfo")
    public AjaxResult identityInfo() {
        return AjaxResult.success(identityConfig) ;
    }

}
