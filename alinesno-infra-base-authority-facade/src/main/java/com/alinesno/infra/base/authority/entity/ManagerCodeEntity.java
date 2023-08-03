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

@TableName("manager_code")
public class ManagerCodeEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 代码名称
	 */
	@Excel(name = "代码名称")
	@TableField("code_name")
	private String codeName;

	@TableField("code_desc")
	private String codeDesc;

	/**
	 * 代码值
	 */
	@Excel(name = "代码值")
	@TableField("code_value")
	private String codeValue;
	/**
	 * 代码类型值
	 */
	@Excel(name = "代码类型值")
	@TableField("code_type_value")
	private String codeTypeValue;
	/**
	 * 代码类型名称
	 */
	@Excel(name = "代码类型名称")
	@TableField("code_type_name")
	private String codeTypeName;

	public String getCodeDesc() {
		return codeDesc;
	}

	public void setCodeDesc(String codeDesc) {
		this.codeDesc = codeDesc;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getCodeValue() {
		return codeValue;
	}

	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}

	public String getCodeTypeValue() {
		return codeTypeValue;
	}

	public void setCodeTypeValue(String codeTypeValue) {
		this.codeTypeValue = codeTypeValue;
	}

	public String getCodeTypeName() {
		return codeTypeName;
	}

	public void setCodeTypeName(String codeTypeName) {
		this.codeTypeName = codeTypeName;
	}

	@Override
	public String toString() {
		return "ManagerCodeEntity{" + "codeName=" + codeName + ", codeValue=" + codeValue + ", codeTypeValue="
				+ codeTypeValue + ", codeTypeName=" + codeTypeName + "}";
	}
}
