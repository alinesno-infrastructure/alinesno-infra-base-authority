package com.alinesno.infra.base.authority.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author LuoXiaoDong
 * @version 1.0.0
 */
@Data
@TableName("sys_dept")
public class SysDeptEntity extends InfraBaseEntity {

    @TableField
    @ColumnType(length = 255)
    @ColumnComment("deptId")
    private Long deptId;

    @TableField
    @ColumnType(length = 255)
    @ColumnComment("tenantId")
    private String tenantId;

    @TableField
    @ColumnType(length = 255)
    @ColumnComment("parentId")
    private Long parentId;

    @TableField
    @ColumnType(length = 255)
    @ColumnComment("ancestors")
    private String ancestors;

    @TableField
    @ColumnType(length = 255)
    @ColumnComment("deptName")
    private String deptName;

    @TableField
    @ColumnType(length = 255)
    @ColumnComment("orderNum")
    private Integer orderNum;

    @TableField
    @ColumnType(length = 255)
    @ColumnComment("leader")
    private Long leader;

    @TableField
    @ColumnType(length = 255)
    @ColumnComment("phone")
    private String phone;

    @TableField
    @ColumnType(length = 255)
    @ColumnComment("email")
    private String email;

    @TableField
    @ColumnType(length = 255)
    @ColumnComment("status")
    private String status;

    @TableField
    @ColumnType(length = 255)
    @ColumnComment("delFlag")
    private String delFlag;

    @TableField
    @ColumnType(length = 255)
    @ColumnComment("createDept")
    private Long createDept;

    @TableField
    @ColumnType(length = 255)
    @ColumnComment("createBy")
    private Long createBy;

    @TableField
    @ColumnType(length = 255)
    @ColumnComment("createTime")
    private Date createTime;

    @TableField
    @ColumnType(length = 255)
    @ColumnComment("updateBy")
    private Long updateBy;


}