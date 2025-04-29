package com.alinesno.infra.base.authority.api.identity;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;
import java.util.regex.Pattern;

@Data
public class WechatUserDto {

    /**
     * 普通用户的标识，对当前开发者账号唯一
     */
    @NotBlank(message = "openid不能为空")
    private String openid;

    /**
     * 普通用户昵称
     */
    @NotBlank(message = "昵称不能为空")
    private String nickname;

    /**
     * 手机号
     */
    @NotBlank(message = "手机号不能为空")
    private String phone;

    /**
     * 普通用户性别，1为男性，2为女性
     */
    private int sex;

    /**
     * 普通用户个人资料填写的省份
     */
    private String province;

    /**
     * 普通用户个人资料填写的城市
     */
    private String city;

    /**
     * 国家，如中国为CN
     */
    private String country;

    /**
     * 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空
     */
    @NotBlank(message = "头像链接不能为空")
    private String headimgurl;

    /**
     * 用户统一标识。针对一个微信开放平台账号下的应用，同一用户的unionid是唯一的。
     */
    @NotBlank(message = "用户统一标识不能为空")
    private String unionid;


}