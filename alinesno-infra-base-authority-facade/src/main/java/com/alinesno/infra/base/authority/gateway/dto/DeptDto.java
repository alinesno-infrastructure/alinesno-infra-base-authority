package com.alinesno.infra.base.authority.gateway.dto;

import lombok.Data;

/**
 * 机构机构
 *
 * @author luoxiaodong
 * @since 2023年8月23日 下午8:10:43
 */
@Data
public class DeptDto {

	private Long deptId;
	private String deptName;
	private Long parentDeptId;

}
