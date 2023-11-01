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
@TableName("info_school")
public class InfoSchoolEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	@ColumnType
	@ColumnComment("所属者")
	@TableField("owners")
	private String owners;

	@ColumnType(length = 100)
	@ColumnComment("学校地址")
	@TableField("school_address")
	private String schoolAddress;

	@ColumnType(length = 100)
	@ColumnComment("学校名称")
	@TableField("school_name")
	private String schoolName;

	@ColumnType(length = 100)
	@ColumnComment("办学类型代码")
	@TableField("school_type")
	private String schoolType;

	@ColumnType(length = 100)
	@ColumnComment("学校代码")
	@TableField("school_code")
	private String schoolCode;

	@ColumnType(length = 100)
	@ColumnComment("学校所在省份")
	@TableField("school_province")
	private String schoolProvince;

	@ColumnType(length = 100)
	@ColumnComment("学校所在省份代码")
	@TableField("school_province_code")
	private String schoolProvinceCode;

	@ColumnType(length = 100)
	@ColumnComment("办学类型名称")
	@TableField("school_type_name")
	private String schoolTypeName;

	@ColumnType(length = 100)
	@ColumnComment("学校性质类型")
	@TableField("school_properties")
	private String schoolProperties;

	@ColumnType(length = 100)
	@ColumnComment("办学性质类型代码")
	@TableField("school_properties_code")
	private String schoolPropertiesCode;

	@ColumnType(length = 100)
	@ColumnComment("学校举办者")
	@TableField("school_owner")
	private String schoolOwner;

	@ColumnType(length = 100)
	@ColumnComment("学校举办者代码")
	@TableField("school_owner_code")
	private String schoolOwnerCode;

}
