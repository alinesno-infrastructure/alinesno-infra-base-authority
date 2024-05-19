package com.alinesno.infra.base.authority.service;

import com.alinesno.infra.base.authority.entity.ManagerApplicationAccountEntity;
import com.alinesno.infra.base.authority.entity.ManagerApplicationEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
public interface IManagerApplicationAccountService extends IBaseService<ManagerApplicationAccountEntity> {

    /**
     * 获取用户当前应用
     * @param userId
     * @return
     */
    ManagerApplicationEntity getApplicationByAccountId(long userId);

    /**
     * 初始化用户应用服务
     * @param userId
     */
    void initDefaultProject(long userId);
}
