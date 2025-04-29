package com.alinesno.infra.base.authority.identity.domain.dto;

import lombok.Data;

import java.util.Date;

/**
 * Controller层的日志封装类
 */
@Data
public class AuthWebLogDto {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 访问ip
     */
    private String accessIp;

    /**
     * 访问url
     */
    private String accessUrl;

    /**
     * 请求参数
     */
    private Object requestParam;

    /**
     * 执行类
     */
    private String className;

    /**
     * 执行方法
     */
    private String method;

    /**
     * 方法描述
     */
    private String description;

    /**
     * 执行结果
     */
    private Object response;

    /**
     * 执行时间
     */
    private Long executeTime;

    /**
     * 访问时间
     */
    private Date accessDateTime;

    /**
     * 推送时间
     */
    private Date pushDateTime;

    /**
     * 请求结果(success成功|fail失败)
     */
    private String status ;

}
