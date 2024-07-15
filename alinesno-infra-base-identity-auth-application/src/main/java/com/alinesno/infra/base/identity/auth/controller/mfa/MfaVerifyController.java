package com.alinesno.infra.base.identity.auth.controller.mfa;

import com.alinesno.infra.base.identity.auth.adapter.ManagerAccountConsumer;
import com.alinesno.infra.base.identity.auth.domain.MfaVerityDto;
import com.alinesno.infra.base.identity.auth.totp.code.CodeVerifier;
import com.alinesno.infra.common.facade.response.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 多因素认证设置控制器。
 * 该控制器负责处理与TOTP（时间同步一次性密码）相关的认证流程，提供初始化和验证TOTP的功能。
 *
 * @author luoxiaodong
 * @version 1.0.0
 *
 */
@Slf4j
@RestController
@RequestMapping("/mfa/")
public class MfaVerifyController {

    @Autowired
    private ManagerAccountConsumer managerAccountConsumer ;

    @Autowired
    private CodeVerifier verifier;

    @PostMapping("/verify")
    @ResponseBody
    public AjaxResult verify(@RequestBody MfaVerityDto dto) {

        log.debug("dto = {}" , dto);

        String code = dto.getMfaCode() ;
        String loginName = dto.getLoginName() ;

        String secret = managerAccountConsumer.queryMfaSecret(loginName) ;

        if (verifier.isValidCode(secret, code)) {
            return AjaxResult.error("认证不正确");
        }

        return AjaxResult.success() ;
    }

}