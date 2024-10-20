package com.alinesno.infra.base.authority.gateway.provider;

import com.alinesno.infra.base.authority.gateway.dto.ManagerResourceDto;
import com.alinesno.infra.base.authority.service.IManagerResourceService;
import com.alinesno.infra.common.facade.response.R;
import io.jsonwebtoken.lang.Assert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/api/base/authority/resource")
public class ResourceProviderController extends BaseProvider {

    @Autowired
    private IManagerResourceService managerResourceService ;

    /**
     * 查询用户菜单，分两种情况：
     * 1. 超级管理员直接返回所有菜单
     * 2. 非超级管理员根据权限返回所有菜单
     *
     * @param projectCode
     * @param accountId
     *
     * @return
     */
    @GetMapping("/findMenusByProjectCode")
    public R<List<ManagerResourceDto>> findMenusByProjectCode(
            @RequestParam String projectCode,
            @RequestParam long accountId) {

        Assert.hasLength(projectCode,  "项目标识为空");
        Assert.hasLength(accountId+"",  "用户标识代码为空");

        return R.ok(managerResourceService.findMenusByProjectCode(projectCode , accountId).getChildren()) ;
    }


}
