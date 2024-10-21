package com.alinesno.infra.base.authority.gateway.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 功能名： 【请填写功能名称】 数据表： manager_project
 * 
 * @author luoxiaodong 
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ManagerProjectDto extends BaseDto {

	// 项目名称
	private String projectName;
	// 项目代码
	private String projectCode;
	// 项目描述
	private String projectDesc;
	// 项目图标链接
	private String projectIcons;
	// 项目链接
	private String projectLink;
	// 项目所使用的组件
	private String component;
	// 项目权限设置
	private String perms;
	// 项目父ID
	private String pid;
	// 是否为内部系统项目
	private String systemInner;
	// 是否生成演示示例
	private String genDemo;
//	// 所在组织id
//	private long orgId ;

}
