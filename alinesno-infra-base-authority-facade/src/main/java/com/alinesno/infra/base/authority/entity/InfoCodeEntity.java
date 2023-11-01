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
@TableName("info_code")
public class InfoCodeEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	@ColumnType
	@ColumnComment("所有者")
	@TableField
	private String owners;

	@ColumnType(length = 100)
	@ColumnComment("代码名称")
	@TableField("code_name")
	private String codeName;

	@ColumnType(length = 100)
	@ColumnComment("代码类型")
	@TableField("code_type")
	private String codeType;

	@ColumnType(length = 100)
	@ColumnComment("代码值")
	@TableField("code_value")
	private String codeValue;

}
