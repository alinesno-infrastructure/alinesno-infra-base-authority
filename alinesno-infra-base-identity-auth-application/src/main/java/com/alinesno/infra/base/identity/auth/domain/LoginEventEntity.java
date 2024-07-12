package com.alinesno.infra.base.identity.auth.domain;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import com.gitee.sunchenbin.mybatis.actable.annotation.TableComment;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用于记录事件响应的实体类
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("login_event")
@TableComment("登陆事件响应信息")
public class LoginEventEntity extends InfraBaseEntity {

    // 登录类型
    @TableField
    @ColumnType(length=255)
    @ColumnComment("登陆类型")
    private String loginType;

    // 登录标识
    @ColumnType(length=255)
    @TableField
    @ColumnComment("登陆标识")
    private String loginId;

    // Token 值
    @ColumnType(length=255)
    @TableField
    @ColumnComment("Token值")
    private String tokenValue;

    // 设备信息
    @ColumnType(length=255)
    @TableField
    @ColumnComment("设备信息")
    private String device;

    // 是否为持久化 Cookie
    @ColumnType(length=255)
    @TableField
    @ColumnComment("是否为持久化Cookie")
    private boolean isLastingCookie = true;

    // 超时时间
    @ColumnType(length=255)
    @TableField
    @ColumnComment("超时时间")
    private Long timeout;

    // 活动超时时间
    @ColumnType(length=255)
    @TableField
    @ColumnComment("活动超时时间")
    private Long activeTimeout;

    // 额外数据
    @ColumnType(length=255)
    @TableField
    @ColumnComment("额外数据")
    private String extraData;

    // Token
    @ColumnType(length=255)
    @TableField
    @ColumnComment("Token")
    private String token;

    // 是否写入头部
    @ColumnType(length=255)
    @TableField
    @ColumnComment("是否写入头部")
    private boolean isWriteHeader;

    // Token 签名标记
    @ColumnType(length=255)
    @TableField
    @ColumnComment("Token签名标记")
    private String tokenSignTag;

    // 事件类型
    @ColumnType(length=255)
    @TableField
    @ColumnComment("事件类型")
    private String eventType ;

}
