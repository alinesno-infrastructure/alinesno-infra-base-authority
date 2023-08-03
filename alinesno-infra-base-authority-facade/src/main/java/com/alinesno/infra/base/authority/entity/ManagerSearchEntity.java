package com.alinesno.infra.base.authority.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */

@TableName("manager_search")
public class ManagerSearchEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 资源Id
	 */
	@TableField("resource_id")
	private String resourceId;
	/**
	 * 显示名称
	 */
	private String label;
	/**
	 * 字段名称
	 */
	private String name;
	/**
	 * 字段属性
	 */
	@TableField("option_json")
	private String optionJson;
	/**
	 * 操作类型(input/select),默认为input
	 */
	@TableField("search_type")
	private String searchType;
	/**
	 * 默认值
	 */
	@TableField("default_value")
	private String defaultValue;
	/**
	 * 是否为日期(空则不是|否则是)
	 */
	@TableField("has_date")
	private String hasDate;

	/**
	 * 响应脚本
	 */
	@TableField("search_script")
	private String searchScript;

	/**
	 * 字典类型
	 */
	@TableField("dict")
	private String dictType;

	public String getSearchScript() {
		return searchScript;
	}

	public void setSearchScript(String searchScript) {
		this.searchScript = searchScript;
	}

	public String getDictType() {
		return dictType;
	}

	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOptionJson() {
		return optionJson;
	}

	public void setOptionJson(String optionJson) {
		this.optionJson = optionJson;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getHasDate() {
		return hasDate;
	}

	public void setHasDate(String hasDate) {
		this.hasDate = hasDate;
	}

	@Override
	public String toString() {
		return "ManagerSearchEntity{" + "resourceId=" + resourceId + ", label=" + label + ", name=" + name
				+ ", optionJson=" + optionJson + ", searchType=" + searchType + ", defaultValue=" + defaultValue
				+ ", hasDate=" + hasDate + "}";
	}
}
