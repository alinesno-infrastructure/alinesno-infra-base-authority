package com.alinesno.infra.base.authority.identity.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.alinesno.infra.base.authority.api.identity.IdentityConfigDto;
import com.alinesno.infra.base.authority.api.identity.IdentityUiConfigRequestDto;
import com.alinesno.infra.base.authority.api.identity.LoginConfigRequestDto;
import com.alinesno.infra.base.authority.api.identity.WxConfigRequestDto;
import com.alinesno.infra.base.authority.identity.domain.IdentityConfigEntity;
import com.alinesno.infra.base.authority.identity.mapper.IdentityConfigMapper;
import com.alinesno.infra.base.authority.identity.service.IIdentityConfigService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 登陆配置信息认证
 */
@Slf4j
@Service
public class IdentityConfigServiceImpl extends IBaseServiceImpl<IdentityConfigEntity, IdentityConfigMapper> implements IIdentityConfigService {

    @Override
    public void saveLoginUiConfig(IdentityUiConfigRequestDto dto) {
        IdentityConfigEntity entity = getIdentityConfigEntity();

        // 设置登录页面的背景图片
        entity.setBackgroundImage(dto.getBackgroundImage());
        // 设置登录页面的 logo
        entity.setLogo(dto.getLogo());
        // 设置系统名称
        entity.setSystemName(dto.getSystemName());
        // 设置登录页面的横幅信息
        entity.setBannerInfo(dto.getBannerInfo());
        // 设置系统版本
        entity.setVersion(dto.getVersion());
        // 设置版权年份
        entity.setCopyrightYear(dto.getCopyrightYear());
        // 设置版权标签
        entity.setCopyrightLabel(dto.getCopyrightLabel());
        // 设置门户站点
        entity.setPortalSite(dto.getPortalSite());

        saveOrUpdate(entity);
    }

    @Override
    public void saveLoginConfig(LoginConfigRequestDto dto) {
        IdentityConfigEntity entity = getIdentityConfigEntity();

        // 设置登录策略列表
        entity.setLoginStrategies(dto.getLoginStrategiesStr());
        // 设置异常登录次数
        entity.setAbnormalLoginCount(dto.getAbnormalLoginCount());
        // 设置封禁时长
        entity.setBlockDuration(dto.getBlockDuration());
        // 设置登录协议
        entity.setLoginAgreement(dto.getLoginAgreement());
        // 设置密码强度
        entity.setPasswordStrength(dto.getPasswordStrength());
        // 设置验证码错误限制次数
        entity.setCaptchaErrorLimit(dto.getCaptchaErrorLimit());
        // 设置记住我过期天数
        entity.setRememberMeExpireDays(dto.getRememberMeExpireDays());
        // 设置登录失败消息
        entity.setLoginFailureMessage(dto.getLoginFailureMessage());

        saveOrUpdate(entity);
    }

    @Override
    public void saveWxConfig(WxConfigRequestDto dto) {

        IdentityConfigEntity entity = getIdentityConfigEntity();
        entity.setWxAppId(dto.getWxAppId());
        entity.setWxAppSecret(dto.getWxAppSecret());
        entity.setWxCallbackUrl(dto.getWxCallbackUrl());

        saveOrUpdate(entity);
    }

    @Override
    public IdentityConfigDto getIdentityConfigDetail() {
        IdentityConfigEntity e = getIdentityConfigEntity() ;
        IdentityConfigDto dto = new IdentityConfigDto();

        CopyOptions copyOptions = CopyOptions.create().ignoreNullValue();
        BeanUtil.copyProperties(e, dto ,copyOptions) ;
        String loginStrategies = e.getLoginStrategies();
        if(loginStrategies != null){
            dto.setLoginStrategies(List.of(loginStrategies.split(",")));
        }

        return dto ;
    }

    /**
     * 获取登陆配置信息(全局只有一个数据配置项)
     * @return
     */
    private IdentityConfigEntity getIdentityConfigEntity() {
        LambdaQueryWrapper<IdentityConfigEntity> queryWrapper = new LambdaQueryWrapper<>();
        List<IdentityConfigEntity> list = list(queryWrapper);
        if(!list.isEmpty()){
            return list.get(0);
        }else {
            return new IdentityConfigEntity();
        }
    }

}