package com.alinesno.infra.base.authority.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
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
@TableName("manager_code")
public class ManagerCodeEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 字典名称
	 */
	@Excel(name = "字典名称")
	@TableField("code_name")
	@ColumnType(length = 255)
	@ColumnComment("字典名称")
	private String codeName;

	@TableField("code_desc")
	@ColumnType(length = 255)
	@ColumnComment("字典描述")
	private String codeDesc;

	/**
	 * 字典值
	 */
	@Excel(name = "字典值")
	@TableField("code_value")
	@ColumnType(length = 255)
	@ColumnComment("字典值")
	private String codeValue;

	/**
	 * 字典类型值
	 */
	@Excel(name = "字典类型值")
	@TableField("code_type_value")
	@ColumnType(length = 255)
	@ColumnComment("字典类型值")
	private String codeTypeValue;

	/**
	 * 字典类型名称
	 */
	@Excel(name = "字典类型名称")
	@TableField("code_type_name")
	@ColumnType(length = 255)
	@ColumnComment("字典类型名称")
	private String codeTypeName;

}
