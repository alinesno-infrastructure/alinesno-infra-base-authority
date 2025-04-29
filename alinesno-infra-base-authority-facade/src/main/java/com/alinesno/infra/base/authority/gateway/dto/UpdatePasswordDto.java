package com.alinesno.infra.base.authority.gateway.dto;

import lombok.Data;

/**
 * 密码dto
 * 
 * @author luoxiaodong
 * @since 2022年3月17日 下午10:23:43
 */
@Data
public class UpdatePasswordDto {

    /**
     * 用户id，用于标识需要更新密码的用户
     */
    private String accountId;

    /**
     * 旧密码，用于验证用户身份
     */
    private String oldPassword;

    /**
     * 新密码，用户希望设置的新密码
     */
    private String newPassword;

    /**
     * 确认密码，用于确认用户输入的新密码是否一致
     */
    private String confirmPassword;

}
