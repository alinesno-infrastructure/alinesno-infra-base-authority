package com.alinesno.infra.base.authority.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * <p>
 * 
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */

@TableName("manager_code_type")
public class ManagerCodeTypeEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 代码类型名称
	 */
	@Excel(name = "代码类型名称")
	@TableField("code_type_name")
	private String codeTypeName;
	/**
	 * 代码类型值
	 */
	@Excel(name = "代码类型值")
	@TableField("code_type_value")
	private String codeTypeValue;

	public String getCodeTypeName() {
		return codeTypeName;
	}

	public void setCodeTypeName(String codeTypeName) {
		this.codeTypeName = codeTypeName;
	}

	public String getCodeTypeValue() {
		return codeTypeValue;
	}

	public void setCodeTypeValue(String codeTypeValue) {
		this.codeTypeValue = codeTypeValue;
	}

	@Override
	public String toString() {
		return "ManagerCodeTypeEntity{" + "codeTypeName=" + codeTypeName + ", codeTypeValue=" + codeTypeValue + "}";
	}
}
