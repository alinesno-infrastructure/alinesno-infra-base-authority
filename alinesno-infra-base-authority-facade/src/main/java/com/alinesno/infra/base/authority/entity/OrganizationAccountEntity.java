package com.alinesno.infra.base.authority.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * <p>
 * 组织与账号对应关系
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("organization_account")
public class OrganizationAccountEntity extends InfraBaseEntity {

	@TableField("org_id")
	@ColumnType
	@ColumnComment("机构id")
	private Long orgId ;  // 机构id

	@ColumnType
	@ColumnComment("账号id")
	@TableField("account_id")
	private long accountId ; // 账号id

}
