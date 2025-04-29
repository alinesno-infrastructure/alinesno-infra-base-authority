package com.alinesno.infra.base.authority.identity.service;

import com.alinesno.infra.base.authority.api.identity.IdentityConfigDto;
import com.alinesno.infra.base.authority.api.identity.IdentityUiConfigRequestDto;
import com.alinesno.infra.base.authority.api.identity.LoginConfigRequestDto;
import com.alinesno.infra.base.authority.api.identity.WxConfigRequestDto;
import com.alinesno.infra.base.authority.identity.domain.IdentityConfigEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

/**
 * 登录配置服务接口
 */
public interface IIdentityConfigService extends IBaseService<IdentityConfigEntity> {

    /**
     * 保存登录UI配置
     * @param dto
     */
    void saveLoginUiConfig(IdentityUiConfigRequestDto dto);

    /**
     * 保存登录配置
     * @param dto
     */
    void saveLoginConfig(LoginConfigRequestDto dto);

    /**
     * 保存微信配置
     * @param dto
     */
    void saveWxConfig(WxConfigRequestDto dto);

    /**
     * 获取登录配置
     * @return
     */
    IdentityConfigDto getIdentityConfigDetail();

}
