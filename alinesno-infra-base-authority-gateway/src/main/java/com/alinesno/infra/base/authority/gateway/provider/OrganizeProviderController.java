package com.alinesno.infra.base.authority.gateway.provider;

import com.alinesno.infra.base.authority.gateway.dto.DeptDto;
import com.alinesno.infra.base.authority.gateway.dto.ManagerApplicationDto;
import com.alinesno.infra.base.authority.gateway.dto.ManagerGroupDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/api/base/authority/organize")
public class OrganizeProviderController extends BaseProvider {

    /**
     * 查询机构
     *
     * @param ids
     * @return
     */
    public List<ManagerGroupDto> findTenantEntityByIds(List<String> ids){
        return null ;
    }

    /**
     * 通过ids查询应用
     *
     * @param ids
     * @return
     */
    public List<ManagerApplicationDto> findApplicationEntityByIds(List<String> ids){
        return null ;
    }

    /**
     * 查询应用部门
     *
     * @param applicationId
     * @param parentDeptId
     * @return
     */
    public List<DeptDto> findOrg(String applicationId, String parentDeptId){
        return null ;
    }
}
