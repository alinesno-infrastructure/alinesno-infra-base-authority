package com.alinesno.infra.base.authority.gateway.dto;

/**
 * 机构机构
 * 
 * @author luoxiaodong
 * @since 2023年8月23日 下午8:10:43
 */
public class DeptDto {

	private Long deptId;  
	private String deptName;  
	private Long parentDeptId;  

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Long getParentDeptId() {
		return parentDeptId;
	}

	public void setParentDeptId(Long parentDeptId) {
		this.parentDeptId = parentDeptId;
	}

}
