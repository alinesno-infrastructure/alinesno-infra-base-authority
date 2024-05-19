package com.alinesno.infra.common.web.adapter.login.controller;

import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.dto.LoginBodyDto;
import com.alinesno.infra.common.web.adapter.dto.menus.Menu;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class CommonLoginController {

    /**
     * 令牌
     */
    public static final String TOKEN = "token";

    /**
     * 登录方法
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBodyDto loginBody)
    {
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        String token = UUID.randomUUID().toString() ;
        ajax.put(TOKEN, token);
        return ajax;
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public AjaxResult getInfo() {

        Map<String, Object> data = new HashMap<>();
        // 将数据填充到data中...
        data.put("permissions", new String[]{"*:*:*"});

        Map<String, Object> user = new HashMap<>();
        user.put("createBy", "admin");
        user.put("createTime", "2023-04-23 16:11:38");
        user.put("updateBy", null);
        user.put("updateTime", null);
        user.put("remark", "管理员");
        user.put("userId", 1);
        user.put("deptId", 103);
        user.put("userName", "admin");
        user.put("nickName", "AIP技术团队");
        user.put("email", "aip-team@163.com");
        user.put("phonenumber", "15888888888");
        user.put("sex", "1");
        user.put("avatar", "");
        user.put("password", "");
        user.put("status", "0");
        user.put("delFlag", "0");
        user.put("loginIp", "");
        user.put("loginDate", "2023-09-21T16:54:12.000+08:00");

        Map<String, Object> dept = new HashMap<>();
        dept.put("createBy", null);
        dept.put("createTime", null);
        dept.put("updateBy", null);
        dept.put("updateTime", null);
        dept.put("remark", null);
        dept.put("deptId", 103);
        dept.put("parentId", 101);
        dept.put("ancestors", "0,100,101");
        dept.put("deptName", "研发部门");
        dept.put("orderNum", 1);
        dept.put("leader", "AIP技术团队");
        dept.put("phone", null);
        dept.put("email", null);
        dept.put("status", "0");
        dept.put("delFlag", null);
        dept.put("parentName", null);
        dept.put("children", new Object[]{});

        user.put("dept", dept);

        Map<String, Object> role = new HashMap<>();
        role.put("createBy", null);
        role.put("createTime", null);
        role.put("updateBy", null);
        role.put("updateTime", null);
        role.put("remark", null);
        role.put("roleId", 1);
        role.put("roleName", "超级管理员");
        role.put("roleKey", "admin");
        role.put("roleSort", 1);
        role.put("dataScope", "1");
        role.put("menuCheckStrictly", false);
        role.put("deptCheckStrictly", false);
        role.put("status", "0");
        role.put("delFlag", null);
        role.put("flag", false);
        role.put("menuIds", null);
        role.put("deptIds", null);
        role.put("permissions", null);
        role.put("admin", true);

        user.put("roles", new Object[]{role});

        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", user);
        ajax.put("roles", user.get("roles"));
        ajax.put("permissions", data.get("permissions"));

        return ajax;
    }

    /**
     * 获取路由信息
     *
     * @return 路由信息
     */
    @GetMapping("getRouters")
    public AjaxResult getRouters()
    {

        Menu dashboardMenu = new Menu("Dashboard", "/dashboard", false, "noRedirect", "Layout", true, new Menu.Meta("仪盘表", "dashboard", false, null), List.of(
                new Menu("Dashboard", "index", false, false , "dashboard", new Menu.Meta("概览", "dashboard", false, null)) ,
                new Menu("Application", "application/index", false, false , "application", new Menu.Meta("应用管理", "monitor", false, null))
        ));

        Menu systemMenu = new Menu("System", "/system", false, "noRedirect", "Layout", true, new Menu.Meta("系统管理", "post", false, null),
                List.of(
                        new Menu("Group", "system/group/index", false,false,  "system/group/index", new Menu.Meta("机构管理", "tree", false, null)),
                        new Menu("User", "system/user/index", false,false,  "system/user/index", new Menu.Meta("用户管理", "user", false, null)),
                        new Menu("Dept", "system/dept/index", false,false,  "system/dept/index", new Menu.Meta("部门管理", "tree", false, null)),
                        new Menu("Post", "system/post/index", false, false, "system/post/index", new Menu.Meta("岗位管理", "post", false, null)),
                        new Menu("Role", "system/role/index", false, false, "system/role/index", new Menu.Meta("角色管理", "peoples", false, null)), 
//                        new Menu("Menu", "system/menu/index", false,false,  "system/menu/index", new Menu.Meta("菜单管理", "tree-table", false, null)),
                        new Menu("Dict", "system/dict/index", false,false,  "system/dict/index", new Menu.Meta("字典管理", "dict", false, null)),
                        new Menu("Config", "system/config/index", false,false,  "system/config/index", new Menu.Meta("参数设置", "edit", false, null)),
                        new Menu("Notice", "system/notice/index", false,false,  "system/notice/index", new Menu.Meta("通知公告", "message", false, null))
                ));

        Menu loggerMenu = new Menu("Log", "/log", false, "noRedirect", "Layout", true, new Menu.Meta("日志管理", "log", false, null),
                        List.of(
                                new Menu("Operlog", "monitor/operlog/index", false,false, "log/operlog/index", new Menu.Meta("操作日志", "message", false, null)),
                                new Menu("Apilog", "monitor/apilog/index", false,false, "log/apilog/index", new Menu.Meta("接口日志", "form", false, null)),
                                new Menu("Logininfor", "monitor/logininfor/index", false,false, "log/logininfor/index", new Menu.Meta("登录日志", "logininfor", false, null))
                        ));

        Menu monitorMenu = new Menu("Monitor", "/monitor", false, "noRedirect", "Layout", true, new Menu.Meta("系统监控", "monitor", false, null),
                List.of(
                        new Menu("Server", "monitor/server/index", false,false, "monitor/server/index", new Menu.Meta("服务监控", "server", false, null)),
                        new Menu("Cache", "monitor/cache/index", false,false, "monitor/cache/index", new Menu.Meta("缓存监控", "redis", false, null)),
                        new Menu("CacheList", "monitor/cache/list", false, false,"monitor/cache/list", new Menu.Meta("缓存列表", "redis-list", false, null))
                ));

        Menu themeMenu = new Menu("Enterprise", "/enterprise", false, "noRedirect", "Layout", true, new Menu.Meta("团队主题", "tool", false, null),
                List.of(
                        new Menu("Setting", "enterprise/setting/index", false,false, "enterprise/setting/index", new Menu.Meta("系统主题", "build", false, null)),
                        new Menu("Theme", "enterprise/theme/index",false, false, "enterprise/theme/index", new Menu.Meta("登陆主题", "swagger", false, null))
                ));

        List<Menu> menus = List.of(dashboardMenu , systemMenu, monitorMenu, loggerMenu , themeMenu);

        return AjaxResult.success(menus) ;
    }
}
