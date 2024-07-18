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

    public static List<ManagerResourceEntity> genBaseAuthorityResources() {

//        ManagerResourceDto dashboardMenu = new ManagerResourceDto("Dashboard", "/dashboard", false, "noRedirect", "Layout", true, new ManagerResourceDto.Meta("仪盘表", "dashboard", false, null), List.of(
//                new ManagerResourceDto("Dashboard", "index", false, false , "dashboard", new ManagerResourceDto.Meta("概览", "dashboard", false, null)) ,
//                new ManagerResourceDto("Project", "project/index", false, false , "project", new ManagerResourceDto.Meta("项目管理", "monitor", false, null))
//        ));

//        Menu systemMenu = new Menu("System", "/system", false, "noRedirect", "Layout", true, new Menu.Meta("系统管理", "post", false, null),
//                List.of(
//                        new Menu("Group", "system/group/index", false,false,  "system/group/index", new Menu.Meta("机构管理", "tree", false, null)),
//                        new Menu("User", "system/user/index", false,false,  "system/user/index", new Menu.Meta("用户管理", "user", false, null)),
//                        new Menu("Dept", "system/dept/index", false,false,  "system/dept/index", new Menu.Meta("部门管理", "tree", false, null)),
//                        new Menu("Post", "system/post/index", false, false, "system/post/index", new Menu.Meta("岗位管理", "post", false, null)),
//                        new Menu("Role", "system/role/index", false, false, "system/role/index", new Menu.Meta("角色管理", "peoples", false, null)),
//                        new Menu("Dict", "system/dict/index", false,false,  "system/dict/index", new Menu.Meta("字典管理", "dict", false, null)),
//                        new Menu("Config", "system/config/index", false,false,  "system/config/index", new Menu.Meta("参数设置", "edit", false, null)),
//                        new Menu("Notice", "system/notice/index", false,false,  "system/notice/index", new Menu.Meta("通知公告", "message", false, null))
//                ));
//
//        Menu loggerMenu = new Menu("Log", "/log", false, "noRedirect", "Layout", true, new Menu.Meta("日志管理", "log", false, null),
//                List.of(
//                        new Menu("Operlog", "monitor/operlog/index", false,false, "log/operlog/index", new Menu.Meta("操作日志", "message", false, null)),
//                        new Menu("Apilog", "monitor/apilog/index", false,false, "log/apilog/index", new Menu.Meta("接口日志", "form", false, null)),
//                        new Menu("Logininfor", "monitor/logininfor/index", false,false, "log/logininfor/index", new Menu.Meta("登录日志", "logininfor", false, null))
//                ));
//
//        Menu monitorMenu = new Menu("Monitor", "/monitor", false, "noRedirect", "Layout", true, new Menu.Meta("系统监控", "monitor", false, null),
//                List.of(
//                        new Menu("Online", "monitor/online/index", false,false, "monitor/online/index", new Menu.Meta("在线用户", "peoples", false, null)),
//                        new Menu("Server", "monitor/server/index", false,false, "monitor/server/index", new Menu.Meta("服务监控", "server", false, null)),
//                        new Menu("Cache", "monitor/cache/index", false,false, "monitor/cache/index", new Menu.Meta("缓存监控", "redis", false, null)),
//                        new Menu("CacheList", "monitor/cache/list", false, false,"monitor/cache/list", new Menu.Meta("缓存列表", "redis-list", false, null))
//                ));
//
//        Menu themeMenu = new Menu("Enterprise", "/enterprise", false, "noRedirect", "Layout", true, new Menu.Meta("登陆配置", "tool", false, null),
//                List.of(
//                        new Menu("AccountSync", "system/accountSync/index", false,false,  "system/accountSync/index", new Menu.Meta("账户同步", "message", false, null)),
//                        new Menu("Setting", "enterprise/setting/index", false,false, "enterprise/setting/index", new Menu.Meta("系统主题", "build", false, null)),
//                        new Menu("Theme", "enterprise/theme/index",false, false, "enterprise/theme/index", new Menu.Meta("登陆主题", "swagger", false, null))
//                ));

        return null ;
    }
}

