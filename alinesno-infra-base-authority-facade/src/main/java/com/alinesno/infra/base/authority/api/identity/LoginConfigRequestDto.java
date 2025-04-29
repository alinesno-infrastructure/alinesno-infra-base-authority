package com.alinesno.infra.base.authority.api.identity;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
public class LoginConfigRequestDto {

    @NotNull(message = "登录策略不能为 null 或空字符串")
    private List<@NotNull String> loginStrategies;

    // 此为布尔类型，无需额外校验

    // 异常登录次数不能为负数
    @Min(value = 0, message = "异常登录次数不能为负数")
    private int abnormalLoginCount;

    // 封禁时长不能为负数
    @Min(value = 0, message = "封禁时长不能为负数")
    private int blockDuration;

    // 登录协议可以为空，但如果有值，长度不能超过 2000
    @Size(max = 2000, message = "登录协议长度不能超过 2000 个字符")
    private String loginAgreement;

    // 密码强度必须是指定的几种值之一
    @Pattern(regexp = "^(low|medium|high)$", message = "密码强度必须是 low、medium 或 high")
    private String passwordStrength;

    // 此为布尔类型，无需额外校验

    // 验证码错误限制次数不能为负数
    @Min(value = 0, message = "验证码错误限制次数不能为负数")
    private int captchaErrorLimit;

    // 记住我过期天数不能为负数
    @Min(value = 0, message = "记住我过期天数不能为负数")
    private int rememberMeExpireDays;

    // 登录失败消息可以为空，但如果有值，长度不能超过 100
    @Size(max = 100, message = "登录失败消息长度不能超过 100 个字符")
    private String loginFailureMessage;

    // 是否启用验证码
    @NotNull(message = "是否启用验证码不能为 null 或空字符串")
    private boolean captchaEnabled;

    // 是否关闭登录
    @NotNull(message = "是否关闭登录不能为 null 或空字符串")
    private boolean loginDisabled;

    public String getLoginStrategiesStr() {
        StringBuilder str = new StringBuilder();
        for (String s : loginStrategies) {
            str.append(s).append(",");
            // 如果需要去掉最后一个逗号，可以执行以下操作
            if (loginStrategies.size() > 1) {
                str.append(",");
            }
        }
        return str.toString();
    }
}