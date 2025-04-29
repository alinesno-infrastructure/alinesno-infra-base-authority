package com.alinesno.infra.base.authority.gateway.provider;

import cn.hutool.crypto.digest.BCrypt;
import com.alinesno.infra.base.authority.api.OrganizationDto;
import com.alinesno.infra.base.authority.entity.ManagerAccountEntity;
import com.alinesno.infra.base.authority.entity.OrganizationAccountEntity;
import com.alinesno.infra.base.authority.gateway.dto.AuthManagerAccountDto;
import com.alinesno.infra.base.authority.service.IManagerAccountService;
import com.alinesno.infra.base.authority.service.IOrganizationService;
import com.alinesno.infra.common.facade.response.R;
import com.alinesno.infra.common.web.adapter.base.dto.LoginBodyDto;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;
import java.util.List;
import java.util.Map;

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
    @GetMapping("/getManagerAccountDto")
    public R<AuthManagerAccountDto> getManagerAccountDto(long id) {
        AuthManagerAccountDto dto = managerAccountService.getManagerAccountDto(id);
        return R.ok(dto) ;
    }

    /**
     * 通过id获取到用户信息getById
     */
    @GetMapping("/getAccountInfo")
    public R<Map<String, Object>> getAccountInfo(long id) {
        Map<String, Object> dto = managerAccountService.getAccountInfo(id);
        return R.ok(dto) ;
    }


    /**
     * 用户注册信息，用于前端业务用户注册
     *
     * @param dto
     * @return
     */
    @PostMapping("/registerAccount")
    public AuthManagerAccountDto registerAccount(@RequestBody AuthManagerAccountDto dto) {

        String loginName = dto.getLoginName();
        String password = BCrypt.hashpw(dto.getPassword());  // 密钥加密
        String phone = dto.getPhone();

        AuthManagerAccountDto b = managerAccountService.registAccount(loginName, password, phone);
        log.debug("registerAccount = {}", b);

        return b;
    }

    /**
     * 用户登陆
     *
     * @return
     */
    @PostMapping("/login")
    public AuthManagerAccountDto login(@RequestBody LoginBodyDto loginBodyDto) {

        AuthManagerAccountDto dto = managerAccountService.loginAccount(loginBodyDto.getUsername(), loginBodyDto.getPassword());
        log.debug("login account = {}", dto);

        return dto;
    }

//    /**
//     * 查询用户菜单
//     *
//     * @param projectCode
//     * @param accountId
//     * @return
//     */
//    public ManagerResourceDto findMenusByProjectCode(String projectCode, String accountId) {
//        return null;
//    }

    /**
     * 通过用户名查询用户
     *
     * @param loginName
     * @return
     */
    @GetMapping("/findByLoginName")
    public AuthManagerAccountDto findByLoginName(String loginName) {
        Assert.hasLength(loginName, "用户名称为空");

        ManagerAccountEntity e = managerAccountService.findByLoginName(loginName);

        AuthManagerAccountDto dto = new AuthManagerAccountDto();
        BeanUtils.copyProperties(e, dto);
        dto.setPassword(null);

        // 设置组织信息
        OrganizationAccountEntity org = organizationService.getByAccountId(e.getId()) ;
        dto.setOrgId(org.getId());
        dto.setOrgType(org.getOrgType());

        return dto;
    }

    /**
     * 通过用户名查询，如果不存在则自动注册
     */
    @GetMapping("/findByLoginNameWithRegister")
    public R<AuthManagerAccountDto> findByLoginNameWithRegister(String loginName , String password , String loginType) {

        log.debug("loginName = {} , password = {} , loginType = {}" , loginName , password , loginType);
        Assert.hasLength(loginName, "用户名称为空");

        try{
            AuthManagerAccountDto dto = managerAccountService.findByLoginNameWithRegister(loginName , password , loginType);
            return R.ok(dto);
        }catch (Exception e){
            log.error("findByLoginNameWithRegister error", e);
            return R.fail(e.getMessage());
        }

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

    /**
     * 更新账号信息
     * @param dto
     * @return
     */
    @PutMapping("/updateProfile")
    public R<String> updateProfile(@RequestBody AuthManagerAccountDto dto) {
        managerAccountService.updateAccount(dto);
        return R.ok() ;
    }

    /**
     * 更新头像
     * @param avatarfile
     * @param userId
     * @return
     */
    @SneakyThrows
    @PostMapping("/updateAvatar")
    public R<String> updateAvatar(@RequestParam("avatarfile") MultipartFile avatarfile, long userId) {

        byte[] bytes = avatarfile.getBytes();
        String base64Encoded = Base64.getEncoder().encodeToString(bytes);

        managerAccountService.updateAvatarBase64(base64Encoded, userId);
        return R.ok(base64Encoded) ;
    }
}
