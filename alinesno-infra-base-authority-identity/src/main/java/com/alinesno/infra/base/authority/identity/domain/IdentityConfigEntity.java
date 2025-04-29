package com.alinesno.infra.base.authority.identity.domain;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.alinesno.infra.common.security.mapper.AESEncryptHandler;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import com.gitee.sunchenbin.mybatis.actable.annotation.TableComment;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
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
@TableName(value = "identity_config" , autoResultMap = true)
@TableComment("单点登陆配置")
public class IdentityConfigEntity extends InfraBaseEntity {

    @ColumnType(value = MySqlTypeConstant.VARCHAR, length = 32)
    @TableField
    @ColumnComment("配置名称")
    private String configName;

    @ColumnType(value = MySqlTypeConstant.VARCHAR, length = 255)
    @TableField
    @ColumnComment("背景图片地址")
    private String backgroundImage;

    @ColumnType(value = MySqlTypeConstant.VARCHAR, length = 255)
    @TableField
    @ColumnComment("logo地址")
    private String logo;

    @ColumnType(value = MySqlTypeConstant.VARCHAR, length = 32)
    @TableField
    @ColumnComment("系统名称")
    private String systemName;

    @ColumnType(value = MySqlTypeConstant.VARCHAR, length = 255)
    @TableField
    @ColumnComment("横幅信息")
    private String bannerInfo;

    @ColumnType(value = MySqlTypeConstant.VARCHAR, length = 32)
    @TableField
    @ColumnComment("版本号")
    private String version;

    @ColumnType(value = MySqlTypeConstant.VARCHAR, length = 32)
    @TableField
    @ColumnComment("版权年份")
    private String copyrightYear;

    @ColumnType(value = MySqlTypeConstant.VARCHAR, length = 255)
    @TableField
    @ColumnComment("版权声明标签")
    private String copyrightLabel;

    @ColumnType(value = MySqlTypeConstant.VARCHAR, length = 255)
    @TableField
    @ColumnComment("门户站点地址")
    private String portalSite;

    @ColumnType(value = MySqlTypeConstant.VARCHAR, length = 64)
    @TableField
    @ColumnComment("登录策略列表")
    private String loginStrategies;

    @ColumnType(value = MySqlTypeConstant.TINYINT, length = 1)
    @TableField
    @ColumnComment("是否禁用登录")
    private boolean loginDisabled;

    @ColumnType(value = MySqlTypeConstant.INT, length = 11)
    @TableField
    @ColumnComment("异常登录次数")
    private int abnormalLoginCount;

    @ColumnType(value = MySqlTypeConstant.INT, length = 11)
    @TableField
    @ColumnComment("封禁时长（分钟）")
    private int blockDuration;

    @ColumnType(value = MySqlTypeConstant.TEXT)
    @TableField
    @ColumnComment("登录协议内容")
    private String loginAgreement;

    @ColumnType(value = MySqlTypeConstant.VARCHAR, length = 16)
    @TableField
    @ColumnComment("密码强度")
    private String passwordStrength;

    @ColumnType(value = MySqlTypeConstant.TINYINT, length = 1)
    @TableField
    @ColumnComment("是否启用验证码")
    private boolean captchaEnabled;

    @ColumnType(value = MySqlTypeConstant.INT, length = 11)
    @TableField
    @ColumnComment("验证码错误限制次数")
    private int captchaErrorLimit;

    @ColumnType(value = MySqlTypeConstant.INT, length = 11)
    @TableField
    @ColumnComment("记住我过期天数")
    private int rememberMeExpireDays;

    @ColumnType(value = MySqlTypeConstant.VARCHAR, length = 255)
    @TableField
    @ColumnComment("登录失败提示信息")
    private String loginFailureMessage;

    // --->>>>>>>>>>>>>>> 微信开放平台 >>>>>>>>>>>>>>>
    @ColumnType(value = MySqlTypeConstant.VARCHAR, length = 128)
    @TableField(typeHandler = AESEncryptHandler.class)
    @ColumnComment("微信开放平台appId")
    private String wxAppId;

    @ColumnType(value = MySqlTypeConstant.VARCHAR, length = 128)
    @TableField(typeHandler = AESEncryptHandler.class)
    @ColumnComment("微信开放平台appSecret")
    private String wxAppSecret;

    @ColumnType(value = MySqlTypeConstant.VARCHAR, length = 128)
    @TableField
    @ColumnComment("微信开放平台回调地址")
    private String wxCallbackUrl ;

    // --->>>>>>>>>>>>>>> 邮箱配置项 >>>>>>>>>>>>>>>
    @ColumnType(value = MySqlTypeConstant.VARCHAR, length = 128)
    @TableField(typeHandler = AESEncryptHandler.class)
    @ColumnComment("邮箱服务器地址")
    private String emailServer;

    @ColumnType(value = MySqlTypeConstant.VARCHAR, length = 64)
    @TableField
    @ColumnComment("邮箱服务器端口")
    private String emailPort;

    @ColumnType(value = MySqlTypeConstant.VARCHAR, length = 128)
    @TableField(typeHandler = AESEncryptHandler.class)
    @ColumnComment("邮箱用户名")
    private String emailUsername;

    @ColumnType(value = MySqlTypeConstant.VARCHAR, length = 128)
    @TableField(typeHandler = AESEncryptHandler.class)
    @ColumnComment("邮箱密码或授权码")
    private String emailPassword;

    // --->>>>>>>>>>>>>>> 短信配置项 >>>>>>>>>>>>>>>
    @ColumnType(value = MySqlTypeConstant.VARCHAR, length = 64)
    @TableField
    @ColumnComment("短信平台名称")
    private String smsPlatform;

    @ColumnType(value = MySqlTypeConstant.VARCHAR, length = 128)
    @TableField(typeHandler = AESEncryptHandler.class)
    @ColumnComment("短信平台访问密钥ID")
    private String smsAccessKeyId;

    @ColumnType(value = MySqlTypeConstant.VARCHAR, length = 128)
    @TableField(typeHandler = AESEncryptHandler.class)
    @ColumnComment("短信平台访问密钥Secret")
    private String smsAccessKeySecret;

    @ColumnType(value = MySqlTypeConstant.VARCHAR, length = 32)
    @TableField
    @ColumnComment("短信签名")
    private String smsSignature;

    @ColumnType(value = MySqlTypeConstant.VARCHAR, length = 32)
    @TableField
    @ColumnComment("短信模板ID")
    private String smsTemplateId;
}