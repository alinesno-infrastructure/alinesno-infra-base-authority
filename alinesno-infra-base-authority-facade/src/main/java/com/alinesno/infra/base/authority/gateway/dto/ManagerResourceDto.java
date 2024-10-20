package com.alinesno.infra.base.authority.gateway.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
@ToString
@Data
@NoArgsConstructor
public class ManagerResourceDto implements Serializable {

    private String name; // 菜单名称
    private String path; // 菜单路径
    private boolean hidden; // 是否隐藏菜单
    private String redirect; // 重定向路径
    private String component; // 组件路径
    private boolean alwaysShow; // 是否总是显示
    private Meta meta; // 菜单元信息
    private String perms ; // 权限标识
    private List<ManagerResourceDto> children = new ArrayList<>(); // 子菜单列表

}
