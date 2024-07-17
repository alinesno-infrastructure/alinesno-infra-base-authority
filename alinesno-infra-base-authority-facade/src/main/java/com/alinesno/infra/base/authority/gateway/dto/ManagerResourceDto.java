package com.alinesno.infra.base.authority.gateway.dto;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 类定义了管理资源的实体属性。
 * 这些属性包括资源的名称、链接、图标、父资源ID、组件、资源排序、菜单类型、打开目标、权限、权限脚本、可见性和子资源。
 * 该实体用于在系统中表示和管理各种资源，如菜单、按钮等。
 *
 * @author luoxiaodong 
 * @version 1.0.0
 */
@Data
public class ManagerResourceDto implements Serializable {

	private long id ; // 资源ID
	private String resourceName; // 资源的名称
	private String resourceLink; // 资源的链接地址
	private String resourceIcon; // 资源的图标
	private String component; // 资源对应的组件
	private String menuType ; // 菜单类型，默认为0，表示菜单项
	private String openTarget; // 资源打开的方式，如新窗口、当前窗口等
	private String permission; // 资源的权限标识
	private String permissionScript; // 资源的权限脚本
	private String visible; // 资源的可见性，控制资源是否在界面上显示
	private Long projectId; // 资源所属的项目ID
	private Long resourceParent ; // 资源的父资源ID，0表示顶级资源
	private Integer resourceOrder; // 资源的排序值

	private List<ManagerResourceDto> subResource = new ArrayList<>(); // 资源的子资源列表，用于表示资源的层级关系

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerResourceDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ManagerResourceDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerResourceDto fromDto(ManagerResourceDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ManagerResourceDto.class);
	}

}
