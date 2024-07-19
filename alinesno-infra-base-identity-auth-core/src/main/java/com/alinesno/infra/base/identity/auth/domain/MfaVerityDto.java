package com.alinesno.infra.base.identity.auth.domain;

import lombok.Data;
import lombok.ToString;

/**
 * 多因素认证验证数据传输对象
 * 该类用于封装多因素认证（MFA）验证过程中的必要信息，包括用户输入的验证码和登录名。
 */
@ToString
@Data
public class MfaVerityDto {

    /**
     * 验证码
     * 用户通过多因素认证设备（如手机应用）生成的验证码，用于二次验证用户身份。
     */
    private String mfaCode;

    /**
     * 登录名
     * 用户用于登录的标识符，可以是邮箱、手机号或其他注册时使用的登录名。
     */
    private String loginName;
}

