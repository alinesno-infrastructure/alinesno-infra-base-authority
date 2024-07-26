package com.alinesno.infra.base.authority.service;

import com.alinesno.infra.base.authority.api.OrganizationDto;
import com.alinesno.infra.base.authority.entity.OrganizationAccountEntity;
import com.alinesno.infra.base.authority.entity.OrganizationEntity;
import com.alinesno.infra.base.authority.entity.OrganizationLogEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */

public interface IOrganizationAccountService extends IBaseService<OrganizationAccountEntity> {

    /**
     * 查询账号
     * @param id
     * @param orgId
     * @return
     */
    OrganizationAccountEntity getByAccountIdAndOrgId(Long id, long orgId);

    /**
     * 查询账号所在组织列表
     * @param id
     * @return
     */
    List<OrganizationDto> listByAccountId(Long id);

}
