package com.alinesno.infra.base.authority.identity.domain;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("register_log")
public class RegisterLogEntity extends InfraBaseEntity {

    // 注册手机号
    @ColumnType(value = MySqlTypeConstant.VARCHAR, length = 32)
    @ColumnComment("注册手机号")
    @TableField("phone")
    private String phone;

    // 客户端IP
    @ColumnType(value = MySqlTypeConstant.VARCHAR, length = 32)
    @ColumnComment("客户端IP")
    @TableField("client_ip")
    private String clientIp;

    // 是否成功（1成功，0失败）
    @ColumnType(value = MySqlTypeConstant.TINYINT, length = 1)
    @ColumnComment("是否成功（1成功，0失败）")
    @TableField("is_success")
    private Integer isSuccess;

    // 操作结果描述
    @ColumnType(value = MySqlTypeConstant.VARCHAR, length = 512)
    @ColumnComment("操作结果描述")
    @TableField("message")
    private String message;

    // 错误详情（更详细的错误原因）
    @ColumnType(value = MySqlTypeConstant.VARCHAR, length = 512)
    @ColumnComment("错误详情（更详细的错误原因）")
    @TableField("error_detail")
    private String errorDetail;

    // 异常堆栈（开发环境记录，生产环境可脱敏）
    @ColumnType(value = MySqlTypeConstant.TEXT)
    @ColumnComment("异常堆栈（开发环境记录，生产环境可脱敏）")
    @TableField("exception_stack")
    private String exceptionStack;

    // 浏览器信息（如Chrome 110）
    @ColumnType(value = MySqlTypeConstant.VARCHAR, length = 64)
    @ColumnComment("浏览器信息（如Chrome 110）")
    @TableField("browser_info")
    private String browserInfo;

    // 操作系统（如Windows 10、iOS 16）
    @ColumnType(value = MySqlTypeConstant.VARCHAR, length = 64)
    @ColumnComment("操作系统（如Windows 10、iOS 16）")
    @TableField("os_info")
    private String osInfo;

    // 来源渠道（APP/PC/H5，可通过请求头或前端传递）
    @ColumnType(value = MySqlTypeConstant.VARCHAR, length = 32)
    @ColumnComment("来源渠道(APP/PC/H5，可通过请求头或前端传递)")
    @TableField("source_channel")
    private String sourceChannel;

    // 风险等级（低/中/高，后续可结合风控规则动态计算）
    @ColumnType(value = MySqlTypeConstant.VARCHAR, length = 16)
    @ColumnComment("风险等级（低/中/高，后续可结合风控规则动态计算）")
    @TableField("risk_level")
    private String riskLevel;
}