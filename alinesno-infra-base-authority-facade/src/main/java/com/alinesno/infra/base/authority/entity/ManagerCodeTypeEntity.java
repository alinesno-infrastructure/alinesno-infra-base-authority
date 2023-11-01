package com.alinesno.infra.base.authority.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.afterturn.easypoi.excel.annotation.Excel;
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
@TableName("manager_code_type")
public class ManagerCodeTypeEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 代码类型名称
	 */
	@Excel(name = "代码类型名称")
	@TableField("code_type_name")
	@ColumnType(length = 255)
	@ColumnComment("代码类型名称")
	private String codeTypeName;

	/**
	 * 代码类型值
	 */
	@Excel(name = "代码类型值")
	@TableField("code_type_value")
	@ColumnType(length = 255)
	@ColumnComment("代码类型值")
	private String codeTypeValue;

}
