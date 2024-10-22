package com.alinesno.infra.base.authority.service;

import com.alinesno.infra.base.authority.annotation.PermissionQuery;
import com.alinesno.infra.base.authority.api.OrganizationDto;
import com.alinesno.infra.base.authority.entity.OrganizationAccountEntity;
import com.alinesno.infra.base.authority.entity.OrganizationEntity;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
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

public interface IOrganizationService extends IBaseService<OrganizationEntity> {

    /**
     * 保存账户组织关系
     * @param orgAccount
     */
    void saveOrganizationAccount(OrganizationAccountEntity orgAccount);

    /**
     * 分页查询组织信息
     *
     * @param page
     * @param accountId
     * @return
     */
    TableDataInfo queryOrganization(DatatablesPageBean page, long accountId);

    /**
     * 判断用户是否存在组织,在的话则返回组织信息，不在则返回null
     */
    OrganizationEntity checkUserInOrg(long accountId , long orgId);

    /**
     * 用户加入组织
     */
    void joinOrg(long accountId, long orgId);

    /**
     * 用户退出组织
     */
    void quitOrg(long accountId , long orgId);

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

    /**
     * 创建或者加入组织
     * @param dto
     */
    void createOrJoinOrg(OrganizationDto dto, long accountId);

    /**
     * 通过用户id查询出用户所在组织信息
     * @param accountId
     * @return
     */
    OrganizationAccountEntity getByAccountId(long accountId);
}
