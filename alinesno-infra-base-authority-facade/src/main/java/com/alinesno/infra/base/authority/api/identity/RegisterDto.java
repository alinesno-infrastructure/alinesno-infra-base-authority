package com.alinesno.infra.base.authority.api.identity;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 注册请求参数
 */
@Data
public class RegisterDto {
    /**
     * 手机号，用于用户注册时的身份标识
     */
    @NotBlank(message = "手机号不能为空")
    private String phone;

    /**
     * 密码，用户注册时设置的账户密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 确认密码，用于确认用户注册时输入的密码是否一致
     */
    @NotBlank(message = "确认密码不能为空")
    private String confirmPassword;
}
