package com.alinesno.infra.base.authority.service;

import com.alinesno.infra.base.authority.entity.ManagerProjectAccountEntity;
import com.alinesno.infra.base.authority.entity.ManagerProjectEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
public interface IManagerProjectAccountService extends IBaseService<ManagerProjectAccountEntity> {

    /**
     * 获取用户当前应用
     * @param userId
     * @return
     */
    ManagerProjectEntity getApplicationByAccountId(long userId);

    /**
     * 初始化用户应用服务
     * @param userId
     */
    void initDefaultProject(long userId);
}
