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

@TableName("manager_department")
public class ManagerDepartmentEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	@Excel(name = "所屬应用")
	private String applicationName;
	/**
	 * 父部门id
	 */
	@TableField
	private Long pid;
	/**
	 * 父级ids
	 */
	@TableField
	private String pids;
	/**
	 * 简称
	 */
	@Excel(name = "简称")
	@TableField("simple_name")
	private String simpleName;
	/**
	 * 全称
	 */
	@Excel(name = "部门名称")
	@TableField("full_name")
	private String fullName;
	/**
	 * 描述
	 */
	@Excel(name = "部门描述")
	private String description;

	/**
	 * 版本（乐观锁保留字段）
	 */
	@TableField
	private Integer versions;
	/**
	 * 排序
	 */
	@TableField
	private Integer sort;

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getPids() {
		return pids;
	}

	public void setPids(String pids) {
		this.pids = pids;
	}

	public String getSimpleName() {
		return simpleName;
	}

	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getVersions() {
		return versions;
	}

	public void setVersions(Integer versions) {
		this.versions = versions;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	@Override
	public String getApplicationName() {
		return applicationName;
	}

	@Override
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ManagerDepartmentEntity{" + "applicationName='" + applicationName + '\'' + ", pid='" + pid + '\''
				+ ", pids='" + pids + '\'' + ", simpleName='" + simpleName + '\'' + ", fullName='" + fullName + '\''
				+ ", description='" + description + '\'' + ", versions=" + versions + ", sort=" + sort + '}';
	}
}
