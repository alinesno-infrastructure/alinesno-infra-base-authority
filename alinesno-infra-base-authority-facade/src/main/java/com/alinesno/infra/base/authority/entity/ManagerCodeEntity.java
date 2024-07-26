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
@TableName("manager_code")
public class ManagerCodeEntity extends InfraBaseEntity {

	@Excel(name = "字典名称")
	@TableField("code_name")
	@ColumnType(length = 255)
	@ColumnComment("字典名称")
	private String codeName;

	@Excel(name = "字典值")
	@TableField("code_value")
	@ColumnType(length = 255)
	@ColumnComment("字典值")
	private String codeValue;

	@Excel(name = "标签值")
	@TableField("code_label")
	@ColumnType(length = 255)
	@ColumnComment("标签值")
	private String codeLabel ;

	@Excel(name = "字典类型值")
	@TableField("code_type_value")
	@ColumnType(length = 255)
	@ColumnComment("字典类型值")
	private String codeTypeValue;

	@Excel(name = "字典所属类型")
	@TableField("code_type_id")
	@ColumnType(length = 255)
	@ColumnComment("字典类型值")
	private long codeTypeId;

	@Excel(name = "样式属性")
	@TableField("css_class")
	@ColumnType(length = 255)
	@ColumnComment("样式属性")
	private String cssClass;

	@Excel(name = "表格字典样式")
	@TableField("list_class")
	@ColumnType(length = 255)
	@ColumnComment("表格字典样式")
	private String listClass;

	@Excel(name = "是否默认")
	@ColumnType(length = 255)
	@ColumnComment("是否默认")
	@TableField("is_default")
	private String isDefault;

	@Excel(name = "字典排序")
	@TableField("dict_sort")
	@ColumnType(length = 255)
	@ColumnComment("字典排序")
	private Long dictSort;

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



	public ManagerCodeEntity(String codeName, String codeValue, String codeTypeValue, long codeTypeId, String remark, String dataScope) {
		this.codeName = codeName;
		this.codeValue = codeValue;
		this.codeTypeValue = codeTypeValue;
		this.codeTypeId = codeTypeId;
		this.remark = remark;
		this.dataScope = dataScope;
	}

}
