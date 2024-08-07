package com.alinesno.infra.base.authority.gateway.provider;

import cn.hutool.crypto.digest.BCrypt;
import com.alinesno.infra.base.authority.entity.ManagerAccountEntity;
import com.alinesno.infra.base.authority.gateway.dto.ManagerAccountDto;
import com.alinesno.infra.base.authority.gateway.dto.ManagerResourceDto;
import com.alinesno.infra.base.authority.service.IManagerAccountService;
import com.alinesno.infra.common.web.adapter.dto.LoginBodyDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/api/base/authority/account")
public class AccountProviderController extends BaseProvider {

    @Autowired
    private IManagerAccountService managerAccountService ;

    /**
     * 用户注册信息，用于前端业务用户注册
     * @param dto
     * @return
     */
    @PostMapping("/registerAccount")
    public ManagerAccountDto registerAccount(@RequestBody ManagerAccountDto dto){

        String loginName = dto.getLoginName() ;
        String password = BCrypt.hashpw(dto.getPassword()) ;  // 密钥加密
        String phone = dto.getPhone() ;

        ManagerAccountDto b = managerAccountService.registAccount(loginName , password , phone) ;
        log.debug("registerAccount = {}" , b);

        return b ;
    }

    /**
     * 用户登陆
     * @return
     */
    @PostMapping("/login")
    public ManagerAccountDto login(@RequestBody LoginBodyDto loginBodyDto){

        ManagerAccountDto dto = managerAccountService.loginAccount(loginBodyDto.getUsername() , loginBodyDto.getPassword()) ;
        log.debug("login account = {}" , dto);

        return dto ;
    }

    /**
     * 查询用户菜单
     *
     * @param projectCode
     * @param userId
     * @return
     */
    public ManagerResourceDto findMenusByProjectCode(String projectCode, String userId) {
        return null ;
    }


    /**
     * 通过用户名查询用户
     *
     * @param loginName
     * @return
     */
    @GetMapping("/findByLoginName")
    public ManagerAccountDto findByLoginName(String loginName) {
        Assert.hasLength(loginName , "用户名称为空");

        ManagerAccountEntity e = managerAccountService.findByLoginName(loginName) ;

        ManagerAccountDto dto = new ManagerAccountDto() ;
        BeanUtils.copyProperties(e , dto);
        dto.setPassword(null);

        return dto ;
    }

}
