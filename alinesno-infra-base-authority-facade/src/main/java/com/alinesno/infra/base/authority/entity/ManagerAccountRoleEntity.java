package com.alinesno.infra.base.authority.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@Data
@TableName("manager_account_role")
public class ManagerAccountRoleEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 角色Id
	 */
	@TableField("role_id")
	@ColumnType(length = 20)
	@ColumnComment("角色Id")
	private Long roleId;

	/**
	 * 账户id
	 */
	@TableField("account_id")
	@ColumnType(length = 20)
	@ColumnComment("账户id")
	private Long accountId;
}
