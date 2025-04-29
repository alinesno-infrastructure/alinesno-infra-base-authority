package com.alinesno.infra.base.authority.identity.controller.manager;

import cn.hutool.core.util.IdUtil;
import com.alinesno.infra.base.authority.api.identity.IdentityConfigDto;
import com.alinesno.infra.base.authority.api.identity.LoginIdentityConfigDto;
import com.alinesno.infra.base.authority.identity.service.IIdentityConfigService;
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

    @Autowired
    private IIdentityConfigService identityConfigService ;

    /**
     * 访问首页，提示语
     */
    @RequestMapping("/")
    public String index() {
        return StringUtils.format("你好，我是AIP单点登陆系统") ;
    }

    /**
     * 访问首页，提示语
     */
    @SneakyThrows
    @RequestMapping("/identityInfo")
    public AjaxResult identityInfo() {

        LoginIdentityConfigDto dto = LoginIdentityConfigDto.getDefaultConfig() ;

        IdentityConfigDto configDto = identityConfigService.getIdentityConfigDetail() ;
        if(configDto.isWxLogin()){
            // 微信登陆配置
            dto.setWxAppId(configDto.getWxAppId()) ;
            dto.setWxState(IdUtil.getSnowflakeNextIdStr());
            dto.setCallbackUrl(configDto.getWxCallbackUrl()); ;
        }

        // 判断登陆类型
        dto.setEnableAccountLogin(configDto.isAccountLogin());
        dto.setEnableEmailLogin(configDto.isEmailLogin());
        dto.setEnableSmsLogin(configDto.isSmsLogin());
        dto.setEnableWxLogin(configDto.isWxLogin());

        return AjaxResult.success(dto) ;
    }

}
