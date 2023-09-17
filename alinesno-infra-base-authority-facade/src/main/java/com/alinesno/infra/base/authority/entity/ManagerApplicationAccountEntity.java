package com.alinesno.infra.base.authority.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 账号与应用关联
 */
@TableName("manager_application_account")
public class ManagerApplicationAccountEntity extends InfraBaseEntity {

    @TableField("account_id")
    private Long accountId ;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
