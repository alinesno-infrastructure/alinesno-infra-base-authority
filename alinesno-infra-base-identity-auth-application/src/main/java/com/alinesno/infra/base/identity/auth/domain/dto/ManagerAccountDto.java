package com.alinesno.infra.base.identity.auth.domain.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 这个类表示管理员账户数据传输对象（DTO）。
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ManagerAccountDto extends BaseDto {

    // 表示管理员账户的用户名字段
    private String username;

    // 表示管理员账户的密码字段
    private String password;

    // 表示管理员账户的头像字段
    private String avatar;

    // 表示管理员账户的简介字段
    private String intro;

    // 表示管理员账户的年龄字段
    private int age;

    // 表示管理员账户的性别字段
    private int sex;

    // 表示管理员账户的电话字段
    private String phone;

    // 表示管理员账户的电子邮件字段
    private String email;

    // 表示管理员账户的状态字段
    private int status;

    // 表示管理员账户的创建时间字段
    private String createTime;

    // 表示管理员账户的登录时间字段
    private String loginTime;

    // 表示管理员账户的登录IP字段
    private String loginIp;

    // 表示管理员账户的登录次数字段
    private int loginCount;

    // 表示管理员账户是否被删除的字段
    private int isDel;

}
