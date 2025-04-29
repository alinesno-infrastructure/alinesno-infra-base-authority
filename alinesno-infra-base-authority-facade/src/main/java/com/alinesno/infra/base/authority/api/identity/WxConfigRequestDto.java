package com.alinesno.infra.base.authority.api.identity;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class WxConfigRequestDto {

    @NotBlank(message = "微信AppId不能为空")
    private String wxAppId; // 微信公众号 AppID

    @NotBlank(message = "微信AppSecret不能为空")
    private String wxAppSecret; // 微信公众号 AppSecret

    @NotBlank(message = "微信回调地址不能为空")
    private String wxCallbackUrl ; // 回调地址

}
