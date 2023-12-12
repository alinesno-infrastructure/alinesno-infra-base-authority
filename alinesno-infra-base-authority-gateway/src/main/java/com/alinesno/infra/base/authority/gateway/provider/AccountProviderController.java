package com.alinesno.infra.base.authority.gateway.provider;

import com.alinesno.infra.base.authority.gateway.dto.*;
import com.alinesno.infra.common.facade.response.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/api/base/authority/account")
public class AccountProviderController extends BaseProvider {

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
    public ManagerApplicationDto findEntityByApplicationCode(String springApplication){
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
    public ManagerAccountDto findByLoginName(String loginName) {
        return null ;
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
