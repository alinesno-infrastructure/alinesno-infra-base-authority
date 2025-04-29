// IRegisterLogService.java（接口）
package com.alinesno.infra.base.authority.identity.service;

import com.alinesno.infra.base.authority.identity.domain.RegisterLogEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

public interface IRegisterLogService extends IBaseService<RegisterLogEntity> {

    /**
     * 保存注册日志
     * @param phone
     * @param clientIp
     * @param isSuccess
     * @param message
     * @param errorDetail
     * @param exceptionStack
     * @param browserInfo
     * @param osInfo
     * @param sourceChannel
     */
    void saveRegisterLog(
            String phone,
            String clientIp,
            boolean isSuccess,
            String message,
            String errorDetail,
            String exceptionStack,
            String browserInfo,
            String osInfo,
            String sourceChannel
    );
}