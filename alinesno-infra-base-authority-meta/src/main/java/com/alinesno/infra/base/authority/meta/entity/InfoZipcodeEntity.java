package com.alinesno.infra.base.authority.meta.entity;

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
@TableName("info_zipcode")
public class InfoZipcodeEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	@ColumnType
	@ColumnComment("所有者")
	@TableField
	private String owners;

	@ColumnType
	@ColumnComment("地区")
	@TableField
	private String area;

	@ColumnType
	@ColumnComment("邮编")
	@TableField("zip_code")
	private String zipCode;

}
