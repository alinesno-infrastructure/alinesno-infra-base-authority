package com.alinesno.infra.base.authority.gateway.provider;

import cn.hutool.crypto.digest.BCrypt;
import com.alinesno.infra.base.authority.api.OrganizationDto;
import com.alinesno.infra.base.authority.entity.ManagerAccountEntity;
import com.alinesno.infra.base.authority.gateway.dto.ManagerAccountDto;
import com.alinesno.infra.base.authority.gateway.dto.ManagerResourceDto;
import com.alinesno.infra.base.authority.service.IManagerAccountService;
import com.alinesno.infra.base.authority.service.IOrganizationService;
import com.alinesno.infra.common.facade.response.R;
import com.alinesno.infra.common.web.adapter.base.dto.LoginBodyDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/api/base/authority/account")
public class AccountProviderController extends BaseProvider {

    @Autowired
    private IManagerAccountService managerAccountService;

    @Autowired
    private IOrganizationService organizationService;

    /**
     * 通过id获取到用户信息getById
     */
    @GetMapping("/getById")
    public R<ManagerAccountDto> getById(long id) {
        ManagerAccountEntity e = managerAccountService.getById(id);
        ManagerAccountDto dto = new ManagerAccountDto();
        BeanUtils.copyProperties(e, dto);
        dto.setPassword(null);
        return R.ok(dto) ;
    }

    /**
     * 用户注册信息，用于前端业务用户注册
     *
     * @param dto
     * @return
     */
    @PostMapping("/registerAccount")
    public ManagerAccountDto registerAccount(@RequestBody ManagerAccountDto dto) {

        String loginName = dto.getLoginName();
        String password = BCrypt.hashpw(dto.getPassword());  // 密钥加密
        String phone = dto.getPhone();

        ManagerAccountDto b = managerAccountService.registAccount(loginName, password, phone);
        log.debug("registerAccount = {}", b);

        return b;
    }

    /**
     * 用户登陆
     *
     * @return
     */
    @PostMapping("/login")
    public ManagerAccountDto login(@RequestBody LoginBodyDto loginBodyDto) {

        ManagerAccountDto dto = managerAccountService.loginAccount(loginBodyDto.getUsername(), loginBodyDto.getPassword());
        log.debug("login account = {}", dto);

        return dto;
    }

    /**
     * 查询用户菜单
     *
     * @param projectCode
     * @param accountId
     * @return
     */
    public ManagerResourceDto findMenusByProjectCode(String projectCode, String accountId) {
        return null;
    }

    /**
     * 通过用户名查询用户
     *
     * @param loginName
     * @return
     */
    @GetMapping("/findByLoginName")
    public ManagerAccountDto findByLoginName(String loginName) {
        Assert.hasLength(loginName, "用户名称为空");

        ManagerAccountEntity e = managerAccountService.findByLoginName(loginName);

        ManagerAccountDto dto = new ManagerAccountDto();
        BeanUtils.copyProperties(e, dto);
        dto.setPassword(null);

        return dto;
    }

    /**
     * 获取用户组织
     */
    @GetMapping("/findOrg")
    public R<List<OrganizationDto>> findOrg(long accountId) {
        List<OrganizationDto> list = organizationService.listByAccountId(accountId);
        return R.ok(list);
    }

    /**
     * 加入组织
     */
    @GetMapping("/joinOrg")
    public R<String> joinOrg(long accountId, long orgId) {
        organizationService.joinOrg(accountId, orgId);
        return R.ok();
    }

    /**
     * 退出组织
     *
     * @param accountId
     * @param orgId
     * @return
     */
    @GetMapping("/quitOrg")
    public R<String> quitOrg(long accountId, long orgId) {
        organizationService.quitOrg(accountId, orgId);
        return R.ok();
    }

}
