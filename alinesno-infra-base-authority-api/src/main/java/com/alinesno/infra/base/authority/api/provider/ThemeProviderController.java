package com.alinesno.infra.base.authority.api.provider;

import com.alinesno.infra.base.authority.api.dto.EnterpriseDto;
import com.alinesno.infra.base.authority.api.dto.EnterpriseThemeDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/api/base/authority/theme")
public class ThemeProviderController extends BaseProvider {


    /**
     * 获取应用登陆主题信息
     * @return
     */
    public EnterpriseThemeDto getLoginTheme(String springApplication){
        return null ;
    }

    /**
     * 通过用户信息获取企业信息，比如标题，主题色等
     * @return
     */
    public EnterpriseDto getEnterpriseByUserId(String userId , String springApplication){
        return null ;
    }

}
