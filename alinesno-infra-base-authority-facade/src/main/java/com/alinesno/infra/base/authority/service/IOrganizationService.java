package com.alinesno.infra.base.authority.service;

import com.alinesno.infra.base.authority.entity.OrganizationAccountEntity;
import com.alinesno.infra.base.authority.entity.OrganizationEntity;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.facade.services.IBaseService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */

public interface IOrganizationService extends IBaseService<OrganizationEntity> {

    /**
     * 保存账户组织关系
     * @param orgAccount
     */
    void saveOrganizationAccount(OrganizationAccountEntity orgAccount);

    /**
     * 分页查询组织信息
     * @param page
     * @return
     */
    TableDataInfo queryOrganization(DatatablesPageBean page);

}
