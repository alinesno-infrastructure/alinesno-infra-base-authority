package com.alinesno.infra.base.authority.gateway.session;

import com.alinesno.infra.base.authority.entity.ManagerProjectEntity;
import com.alinesno.infra.base.authority.service.IManagerProjectAccountService;
import com.alinesno.infra.common.web.adapter.login.account.CurrentAccountJwt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 获取当前应用
 *
 * @author luoxiaodong
 * @since 1.0.0
 */
@Slf4j
@Component
public class CurrentProjectSession {

    // 注入管理项目账户服务
    @Autowired
    private IManagerProjectAccountService managerApplicationAccountService ;

    /**
     * 获取当前用户的项目实体
     *
     * @return ManagerProjectEntity 当前用户的项目实体
     */
    public ManagerProjectEntity get() {
        // 获取当前用户ID
        long userId = CurrentAccountJwt.getUserId();
        // 调用服务获取当前项目
        return managerApplicationAccountService.getCurrentProject(userId) ;
    }

    /**
     * 设置当前用户关联的项目
     *
     * @param projectId 需要设置为当前项目的项目ID
     */
    public void set(long projectId) {
        // 获取当前用户ID
        long userId = CurrentAccountJwt.getUserId();
        // 调用服务设置当前项目
        managerApplicationAccountService.setCurrentProject(projectId , userId);
    }

}

