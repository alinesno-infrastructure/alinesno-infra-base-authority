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
@TableName("info_professional")
public class InfoProfessionalEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	@ColumnType
	@ColumnComment("所有者")
	@TableField
	private String owners;

	@ColumnType(length = 100)
	@ColumnComment("专业名称")
	@TableField("professional_name")
	private String professionalName;

	@ColumnType(length = 100)
	@ColumnComment("专业属性")
	@TableField("professional_prop")
	private String professionalProp;

}
