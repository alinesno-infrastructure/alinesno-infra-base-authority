package com.alinesno.infra.base.authority.service;

import com.alinesno.infra.base.authority.entity.ManagerProjectAccountEntity;
import com.alinesno.infra.base.authority.entity.ManagerProjectEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

/**
 * IManagerProjectAccountService接口扩展了IBaseService，专门用于处理项目经理账户相关的服务
 * 它提供了设置和获取当前项目的功能，以便在系统中跟踪项目经理当前正在处理的项目
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
public interface IManagerProjectAccountService extends IBaseService<ManagerProjectAccountEntity> {

    /**
     * 为指定用户设置当前项目
     * 这个方法允许系统记录一个项目经理当前正在操作的项目，从而在用户界面或其他服务中显示相关信息
     *
     * @param userId 用户ID，用于标识项目经理
     * @param id 项目ID，用于标识项目经理当前正在操作的项目
     */
    void setCurrentProject(long userId, long id);

    /**
     * 获取指定用户当前操作的项目信息
     * 通过这个方法，系统可以查询并显示项目经理当前正在处理的项目详情
     *
     * @param userId 用户ID，用于标识项目经理
     * @return 返回ManagerProjectEntity对象，包含项目经理当前正在操作的项目信息
     */
    ManagerProjectEntity getCurrentProject(long userId);
}

