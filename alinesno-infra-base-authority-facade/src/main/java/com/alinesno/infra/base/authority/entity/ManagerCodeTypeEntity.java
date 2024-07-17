package com.alinesno.infra.base.authority.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("manager_code_type")
public class ManagerCodeTypeEntity extends InfraBaseEntity {

	/**
	 * 字典类型名称
	 */
	@Excel(name = "字典类型名称")
	@TableField("code_type_name")
	@ColumnType(length = 255)
	@ColumnComment("字典类型名称")
	private String codeTypeName;

	/**
	 * 字典类型值
	 */
	@Excel(name = "字典类型值")
	@TableField("code_type_value")
	@ColumnType(length = 255)
	@ColumnComment("字典类型值")
	private String codeTypeValue;

	@Excel(name = "备注")
	@TableField("remark")
	@ColumnType(length = 255)
	@ColumnComment("备注")
	private String remark ;

}
