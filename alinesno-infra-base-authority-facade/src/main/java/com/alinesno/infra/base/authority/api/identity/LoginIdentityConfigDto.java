package com.alinesno.infra.base.authority.api.identity;

import lombok.Data;

/**
 * 该类表示单点登录服务的配置数据传输对象（DTO）。
 * 包含了单点登录服务的相关配置信息，如背景图片、logo、系统名称等。
 */
@Data
public class LoginIdentityConfigDto {

    private String backgroundImage; // 登录页面的背景图片 URL
    private String logo; // 系统的 logo 图片 URL
    private String systemName; // 系统的名称，即单点登录服务的名称
    private String bannerInfo; // 登录页面横幅的信息描述
    private String version; // 系统的版本号
    private String copyrightYear; // 版权年份范围
    private String copyrightLabel; // 版权标签，包含版权所有信息和 ICP 证号
    private String portalSite; // 系统门户的站点 URL

    // 微信登陆
    private String wxAppId ; // 微信开放平台appId
    private String wxState ; // 返回的标识
    private String callbackUrl ; // 回调地址

    private boolean enableWxLogin ; // 是否支持微信登录
    private boolean enableAccountLogin ; // 是否支持账号密码登录
    private boolean enableEmailLogin ; // 是否支持邮箱登录
    private boolean enableSmsLogin ; // 是否支持短信登录

    // 获取到默认的配置信息
    public static LoginIdentityConfigDto getDefaultConfig() {

        LoginIdentityConfigDto config = new LoginIdentityConfigDto();

        config.setLogo("http://data.linesno.com/logo_2.png");
        config.setSystemName("单点登陆服务");
        config.setBannerInfo("用户一次可通过登录凭证登入会话,在该次会话期间无需再次登录");
        config.setVersion("1.0.0-SNAPSHOT");
        config.setCopyrightYear("2021-2024");
        config.setCopyrightLabel("portal.infra.linesno.com 版权所有 ICP证：桂ICP备15005934号-1");
        config.setPortalSite("http://portal.infra.linesno.com");

        return config ;

    }

}