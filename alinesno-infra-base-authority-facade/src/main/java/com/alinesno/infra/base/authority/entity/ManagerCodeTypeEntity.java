package com.alinesno.infra.base.authority.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.base.authority.enums.DataSourceScope;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("manager_code_type")
public class ManagerCodeTypeEntity extends InfraBaseEntity {

	@Excel(name = "字典类型名称")
	@TableField("code_type_name")
	@ColumnType(length = 255)
	@ColumnComment("字典类型名称")
	private String codeTypeName;

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

	@Excel(name = "系统内置（Y是 N否）")
	@TableField("system_inner")
	@ColumnType(length = 1)
	@ColumnComment("系统内置（Y是 N否）")
	private String systemInner ;

	@Excel(name = "数据范围")
	@TableField("data_scope")
	@ColumnType(length = 12)
	@ColumnComment("数据范围")
	private String dataScope = DataSourceScope.PROJECT_SCOPE.getValue();

	public ManagerCodeTypeEntity(String codeTypeName, String codeTypeValue, String remark, String dataScope) {
		this.codeTypeName = codeTypeName;
		this.codeTypeValue = codeTypeValue;
		this.remark = remark;
		this.dataScope = dataScope;
	}

}
