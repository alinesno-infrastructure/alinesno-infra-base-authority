package com.alinesno.infra.base.authority.api.identity;

import com.alinesno.infra.base.authority.enums.LoginTypeEnums;
import com.alinesno.infra.common.facade.base.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * 登陆配置实体
 */ 
@EqualsAndHashCode(callSuper = true)
@Data
@ToString 
public class IdentityConfigDto extends BaseDto {

    // 配置名称
    private String configName;

    // 背景图片地址
    private String backgroundImage;

    // logo地址
    private String logo;

    // 系统名称
    private String systemName;

    // 横幅信息
    private String bannerInfo;

    // 版本号
    private String version;

    // 版权年份
    private String copyrightYear;

    // 版权声明标签
    private String copyrightLabel;

    // 门户站点地址
    private String portalSite;

    // 登录策略列表
    private List<String> loginStrategies = List.of("account" , "wechat");

    // 是否禁用登录
    private boolean loginDisabled;

    // 异常登录次数
    private int abnormalLoginCount = 3;

    // 封禁时长（分钟）
    private int blockDuration = 24;

    // 登录协议内容
    private String loginAgreement;

    // 密码强度
    private String passwordStrength = "low";

    // 是否启用验证码
    private boolean captchaEnabled = true;

    // 验证码错误限制次数
    private int captchaErrorLimit = 3;

    // 记住我过期天数
    private int rememberMeExpireDays = 7;

    // 登录失败提示信息
    private String loginFailureMessage;

    // --->>>>>>>>>>>>>>> 微信开放平台 >>>>>>>>>>>>>>>
    // 微信开放平台appId
    private String wxAppId;

    // 微信开放平台appSecret
    private String wxAppSecret;

    // 微信开放平台回调地址
    private String wxCallbackUrl;

    // --->>>>>>>>>>>>>>> 邮箱配置项 >>>>>>>>>>>>>>>
    // 邮箱服务器地址
    private String emailServer;

    // 邮箱服务器端口
    private String emailPort;

    // 邮箱用户名
    private String emailUsername;

    // 邮箱密码或授权码
    private String emailPassword;

    // --->>>>>>>>>>>>>>> 短信配置项 >>>>>>>>>>>>>>>
    // 短信平台名称
    private String smsPlatform;

    // 短信平台访问密钥ID
    private String smsAccessKeyId;

    // 短信平台访问密钥Secret
    private String smsAccessKeySecret;

    // 短信签名
    private String smsSignature;

    // 短信模板ID
    private String smsTemplateId;


    /**
     * 是否微信登录
     * @return
     */
    public boolean isWxLogin() {
        return loginStrategies.contains(LoginTypeEnums.WECHAT.getType());
    }

    /**
     * 是否账号密码登录
     * @return
     */
    public boolean isAccountLogin() {
        return loginStrategies.contains(LoginTypeEnums.ACCOUNT.getType());
    }

    /**
     * 是否邮箱登录
     * @return
     */
    public boolean isEmailLogin() {
        return loginStrategies.contains(LoginTypeEnums.EMAIL.getType());
    }

    /**
     * 是否短信登录
     * @return
     */
    public boolean isSmsLogin() {
        return loginStrategies.contains(LoginTypeEnums.SMS.getType());
    }

}
















