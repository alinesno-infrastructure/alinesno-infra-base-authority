package com.alinesno.infra.base.authority.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.json.JSONUtil;
import com.alinesno.infra.base.authority.entity.ManagerAccountEntity;
import com.alinesno.infra.base.authority.gateway.dto.ManagerResourceDto;
import com.alinesno.infra.base.authority.service.IManagerAccountService;
import com.alinesno.infra.base.authority.service.IManagerResourceService;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.base.dto.LoginBodyDto;
import com.alinesno.infra.common.web.adapter.login.account.CurrentAccountBean;
import com.alinesno.infra.common.web.adapter.login.account.CurrentAccountJwt;
import com.alinesno.infra.common.web.adapter.login.annotation.CurrentAccount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@RestController
public class AuthCommonLoginController {

    @Value("${spring.application.id:projectCode}")
    private String projectCode ;

    @Autowired
    private IManagerResourceService managerResourceService ;

    @Autowired
    private IManagerAccountService accountService;

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
    public AjaxResult login(@RequestBody LoginBodyDto loginBody) {
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        String token = UUID.randomUUID().toString() ;
        ajax.put(TOKEN, token);
        return ajax;
    }

    /**
     * 退出登陆
     * @return
     */
    @PostMapping("/logout")
    public AjaxResult logout() {
        StpUtil.logout();
        return AjaxResult.success();
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public AjaxResult getInfo(@CurrentAccount CurrentAccountBean account) {

        log.debug("account : {}" , account);

        long userId = CurrentAccountJwt.getUserId() ;
        Assert.notNull(userId , "用户未登录") ;

        ManagerAccountEntity accountEntity = accountService.getById(userId) ;

        Map<String, Object> data = new HashMap<>();

        // 将数据填充到data中...
        data.put("permissions", new String[]{"*:*:*"});

        Map<String, Object> user = new HashMap<>();
        user.put("userId", userId);
        user.put("deptId", accountEntity.getDepartment());
        user.put("userName", accountEntity.getLoginName());
        user.put("nickName", accountEntity.getName());
        user.put("email", accountEntity.getEmail());
        user.put("phoneNumber", accountEntity.getPhone());
        user.put("sex", accountEntity.getSex());
        user.put("avatar", accountEntity.getAvatarPath());

        Map<String, Object> dept = new HashMap<>();
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
    public AjaxResult getRouters() {

        // 查询代码不为空，提示配置spring.application.id
        if (projectCode != null && projectCode.isEmpty()) {
            return AjaxResult.error("项目代码不能为空，请在application.yml配置spring.application.id") ;
        }

        long accountId = CurrentAccountJwt.getUserId() ;

        ManagerResourceDto resourceDto = managerResourceService.findMenusByProjectCode(projectCode , accountId) ;
        log.debug("resourceDto : {}" , JSONUtil.toJsonPrettyStr(resourceDto));

        return AjaxResult.success(resourceDto.getChildren()) ;
    }

}
