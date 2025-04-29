package com.alinesno.infra.base.authority.gateway.dto;

import lombok.Data;

/**
 * 机构机构人员
 * 
 * @author luoxiaodong
 * @since 2023年8月23日 下午8:11:14
 */
@Data
public class AccountDeptDto {

	private String src;  
	private Long userId; 
	private String userName;  
	private String deptId; 

}
