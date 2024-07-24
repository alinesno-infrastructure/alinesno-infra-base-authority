package com.alinesno.infra.base.authority.utils;

import com.alinesno.infra.base.authority.entity.ManagerResourceEntity;
import com.alinesno.infra.base.authority.enums.MenuEnums;
import com.alinesno.infra.base.authority.gateway.dto.ManagerResourceDto;
import org.springframework.beans.BeanUtils;

import java.awt.*;
import java.util.List;

/**
 * 管理员资源工具类，提供资源树的构建方法。
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
public class ManagerResourceUtils {

    /**
     * 根据资源列表构建资源树。
     *
     * @param resources 资源实体列表，代表所有待构建树的资源。
     * @return ManagerResourceDto 对象，包含构建好的资源树。
     */
    public static ManagerResourceDto treeResource(List<ManagerResourceEntity> resources) {
        // 创建 ManagerResourceDto 实例，用于存储构建好的资源树
        ManagerResourceDto dto = new ManagerResourceDto() ;

        // 寻找平台级别的资源作为树的根节点
        ManagerResourceEntity parentResource = null ;
        for(ManagerResourceEntity item : resources){
            if(item.getMenuType().equals(MenuEnums.MENU_PLATFORM.getValue())){  // 平台级菜单
                parentResource = item ;
                break ;
            }
        }

        if(parentResource != null){
            // 递归处理子菜单，构建资源树
            BeanUtils.copyProperties(parentResource , dto);
            handleSubmenus(parentResource , resources , dto) ;
        }

        return dto ;
    }

    /**
     * 递归处理子菜单，构建资源树的辅助方法。
     *
     * @param parentResource 父资源实体，用于构建资源树的节点。
     * @param resources
     * @param dto            ManagerResourceDto 对象，用于存储构建好的资源树。
     */
    private static void handleSubmenus(ManagerResourceEntity parentResource, List<ManagerResourceEntity> resources, ManagerResourceDto dto) {

        List<ManagerResourceEntity> subResources = resources.stream()
                .filter(item -> item.getResourceParent() != null && item.getResourceParent().equals(parentResource.getId()))
                .toList();

        for (ManagerResourceEntity subResource : subResources) {

            // 创建一个新的 ManagerResourceDto 实例来存储当前子资源的信息
            ManagerResourceDto childDto =  new ManagerResourceDto();
            BeanUtils.copyProperties(subResource, childDto);

            // 递归处理当前子资源的子资源
            handleSubmenus(subResource, resources, childDto);

            // 将当前子资源的 DTO 添加到父资源 DTO 的子资源列表中
            dto.getSubResource().add(childDto);
        }

    }


}

