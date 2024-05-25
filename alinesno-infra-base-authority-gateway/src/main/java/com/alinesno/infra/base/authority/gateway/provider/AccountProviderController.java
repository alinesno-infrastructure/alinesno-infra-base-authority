package com.alinesno.infra.base.authority.gateway.provider;

import com.alinesno.infra.base.authority.entity.ManagerAccountEntity;
import com.alinesno.infra.base.authority.gateway.dto.*;
import com.alinesno.infra.base.authority.service.IManagerAccountService;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.dto.LoginBodyDto;
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
    private IManagerAccountService managerAccountService ;

    /**
     * 用户注册信息，用于前端业务用户注册
     * @param dto
     * @return
     */
    @PostMapping("/registerAccount")
    public ManagerAccountDto registerAccount(@RequestBody ManagerAccountDto dto){

        String loginName = dto.getLoginName() ;
        String password = dto.getPassword() ;
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
     * 查询账户
     *
     * @param ids
     * @return
     */
    public List<ManagerAccountDto> findAccountEntityByIds(List<String> ids){
        return null ;
    }


    /**
     * 通过用户实体查询用户信息
     *
     * @param springApplication
     * @return
     */
    public ManagerProjectDto findEntityByApplicationCode(String springApplication){
        return null ;
    }

    /**
     * 查询用户菜单
     *
     * @param resourceParent
     * @param applicationId
     * @param userId
     * @return
     */
    public ManagerResourceDto findMenusByApplicationAndAccount(String resourceParent, String applicationId, String userId) {
        return null ;
    }


    /**
     * 通过id查询用户
     *
     * @param id
     * @return
     */
    public ManagerAccountDto findById(String id){
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

    /**
     * 部门代码查询
     *
     * @param ids
     * @return
     */
    public List<ManagerDepartmentDto> findDepartmentByIds(List<String> ids){
        return null ;
    }


    /**
     * 更新用户信息
     * @param user
     * @return
     */
    public AjaxResult updateManagerAccount(ManagerAccountDto user){
        return AjaxResult.success() ;
    }

    /**
     * 更新用户密码
     * @param pwdDto
     * @return
     */
    public AjaxResult updatePwd(UpdatePasswordDto pwdDto) {
        return AjaxResult.success();
    }

    /**
     * 更新用户头像
     */
    public AjaxResult updateAvator(String avatorId, String accountId) {
        return AjaxResult.success();
    }
}
