package com.alinesno.infra.base.authority.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 头像直接存储到数据库中，规避循环依赖的问题
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("manager_account_avatar")
public class ManagerAccountAvatarEntity extends InfraBaseEntity {

	@TableField("account_id")
	@ColumnType(length = 32)
	@ColumnComment("账号ID")
	private long accountId;

	@TableField("avatar_base64")
	@ColumnType(value = MySqlTypeConstant.LONGTEXT)
	@ColumnComment("头像base64")
	private String avatarBase64 ;

}
