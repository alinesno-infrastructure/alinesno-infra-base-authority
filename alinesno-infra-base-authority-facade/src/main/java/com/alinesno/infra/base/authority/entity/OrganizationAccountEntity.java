package com.alinesno.infra.base.authority.entity;

import com.alinesno.infra.base.authority.enums.AccountOrganizationType;
import com.alinesno.infra.common.facade.mapper.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
public class OrganizationAccountEntity extends BaseEntity {

	@TableField("org_id")
	@ColumnType
	@ColumnComment("机构id")
	private Long orgId ;  // 机构id

	@ColumnType
	@ColumnComment("账号id")
	@TableField("account_id")
	private Long accountId ; // 账号id

	@ColumnType
	@ColumnComment("组织用户类型(1管理员|2普通用户)")
	@TableField("org_type")
	private Integer orgType = AccountOrganizationType.REGULAR_USER.getType() ; // 组织用户类型

	@TableField(exist = false)
	private OrganizationEntity organizationEntity ;

}
