package com.alinesno.infra.base.authority.api.dto;

import com.alinesno.infra.base.authority.entity.ManagerDepartmentEntity;
import com.alinesno.infra.base.authority.entity.ManagerResourceEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

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
public class TreeSelect implements Serializable {

    /** 节点ID */
    private Long id;

    /** 节点名称 */
    private String label;

    /** 子节点 */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TreeSelect> children;

    public TreeSelect() {

    }

    public TreeSelect(ManagerDepartmentEntity dept) {
        this.id = dept.getId();
        this.label = dept.getSimpleName();
        this.children = dept.getChildren().stream().map(TreeSelect::new).collect(Collectors.toList());
    }

    public TreeSelect(ManagerResourceEntity menu) {
        this.id = menu.getId();
        this.label = menu.getResourceName();
        if(menu.getSubResource() != null){
            this.children = menu.getSubResource().stream().map(TreeSelect::new).collect(Collectors.toList());
        }
    }

}
