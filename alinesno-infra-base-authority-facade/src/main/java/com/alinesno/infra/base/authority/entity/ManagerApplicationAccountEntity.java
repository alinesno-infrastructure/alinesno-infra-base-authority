package com.alinesno.infra.base.authority.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;

/**
 * 账号与应用关联
 */
@Data
@TableName("manager_application_account")
public class ManagerApplicationAccountEntity extends InfraBaseEntity {

    /**
     * 账户ID
     */
    @TableField("account_id")
    @ColumnType(length = 20)
    @ColumnComment("账户ID")
    private Long accountId;

}
