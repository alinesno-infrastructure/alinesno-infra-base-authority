package com.alinesno.infra.base.authority.api.dto;

import com.alinesno.infra.base.authority.entity.ManagerDepartmentEntity;
import com.alinesno.infra.base.authority.entity.ManagerResourceEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Treeselect树结构实体类
 * 
 * @author ruoyi
 * @author luoxiaodong
 *
 */
@Data
@NoArgsConstructor
public class TreeSelect implements Serializable {

    /** 节点ID */
    private Long id;

    /** 节点名称 */
    private String label;

    /** 子节点 */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TreeSelect> children;

    public TreeSelect(ManagerDepartmentEntity dept) {
        this.id = dept.getId();
        this.label = dept.getSimpleName() ;
        if (dept.getChildren() != null) {
            this.children = dept.getChildren().stream().map(TreeSelect::new).collect(Collectors.toList());
        }
    }

    public TreeSelect(ManagerResourceEntity menu) {
        this.id = menu.getId();
        this.label = menu.getResourceName();
        if (menu.getSubResource() != null) {
            this.children = menu.getSubResource().stream().map(TreeSelect::new).collect(Collectors.toList());
        }
    }

    /**
     * 构建树形结构
     * @param menuList 菜单列表
     * @return 树形结构
     */
    public static List<TreeSelect> buildTree(List<ManagerResourceEntity> menuList) {
        return menuList.stream()
                .filter(menu -> menu.getResourceParent() == 0L)
                .map(TreeSelect::new)
                .peek(menu -> menu.setChildren(menuList.stream()
                        .filter(subMenu -> subMenu.getResourceParent().equals(menu.getId()))
                        .map(TreeSelect::new)
                        .peek(subMenu -> subMenu.setChildren(buildSubMenu(menuList, subMenu)))
                        .collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

    /**
     * 根据给定的父菜单项，从菜单列表中构建子菜单项的列表。
     * 该方法使用了流式编程，以递归的方式处理菜单的层级关系，构建树状结构。
     *
     * @param menuList 菜单列表，包含所有菜单项的信息。
     * @param menu 当前处理的菜单项，用于查找其子菜单项。
     * @return 返回一个列表，包含当前菜单项的所有子菜单项。
     */
    private static List<TreeSelect> buildSubMenu(List<ManagerResourceEntity> menuList, TreeSelect menu) {
        // 使用流式编程过滤出当前菜单项的所有子菜单项
        return menuList.stream()
                .filter(subMenu -> subMenu.getResourceParent().equals(menu.getId()))
                .map(TreeSelect::new)
                .peek(subMenu -> subMenu.setChildren(buildSubMenu(menuList, subMenu)))
                .collect(Collectors.toList());
    }

    public static List<TreeSelect> buildDeptTree(List<ManagerDepartmentEntity> depts) {
        return depts.stream()
                .filter(menu -> menu.getPid() == 0L)
                .map(TreeSelect::new)
                .peek(menu -> menu.setChildren(depts.stream()
                        .filter(subMenu -> subMenu.getPid().equals(menu.getId()))
                        .map(TreeSelect::new)
                        .peek(subMenu -> subMenu.setChildren(buildDeptSubMenu(depts, subMenu)))
                        .collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

    private static List<TreeSelect> buildDeptSubMenu(List<ManagerDepartmentEntity> menuList, TreeSelect menu) {
        // 使用流式编程过滤出当前菜单项的所有子菜单项
        return menuList.stream()
                .filter(subMenu -> subMenu.getPid().equals(menu.getId()))
                .map(TreeSelect::new)
                .peek(subMenu -> subMenu.setChildren(buildDeptSubMenu(menuList, subMenu)))
                .collect(Collectors.toList());
    }

}
