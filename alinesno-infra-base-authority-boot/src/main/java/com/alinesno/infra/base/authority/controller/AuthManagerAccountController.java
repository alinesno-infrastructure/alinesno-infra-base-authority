package com.alinesno.infra.base.authority.controller;

import com.alinesno.infra.base.authority.gateway.dto.ManagerAccountDto;
import com.alinesno.infra.base.authority.gateway.provider.AccountProviderController;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.facade.response.R;
import com.alinesno.infra.common.web.adapter.login.account.CurrentAccountJwt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/system/user")
public class AuthManagerAccountController {

    @Autowired
    private AccountProviderController accountProviderController ;

    /**
     * 账号信息 profile
     */
    @GetMapping(value = "/profile")
    public AjaxResult profile() {
        ManagerAccountDto dto = accountProviderController.getManagerAccountDto(CurrentAccountJwt.getUserId()).getData();
        return AjaxResult.success(dto);
    }

    /**
     * 更新账号信息
     */
    @PutMapping(value = "/profile")
    public AjaxResult updateProfile(@RequestBody ManagerAccountDto dto) {
        R<String> r = accountProviderController.updateProfile(dto) ;
        return AjaxResult.success();
    }

    /**
     * 更新头像
     */
    @PostMapping(value = "/profile/avatar")
    public AjaxResult avatar(@RequestParam("avatarfile") MultipartFile file) {
        R<String> r = accountProviderController.updateAvatar(file, CurrentAccountJwt.getUserId()) ;
        return AjaxResult.success("操作成功" , r.getData());
    }

}
