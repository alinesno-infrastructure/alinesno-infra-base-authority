package com.alinesno.infra.base.authority.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
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

	@TableField
	private String owners;

	@TableField("code_name")
	private String codeName;

	@TableField("code_type")
	private String codeType;

	@TableField("code_value")
	private String codeValue;

}
