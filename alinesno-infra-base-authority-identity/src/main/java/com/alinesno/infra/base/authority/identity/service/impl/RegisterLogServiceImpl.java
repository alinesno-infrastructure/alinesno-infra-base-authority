// RegisterLogServiceImpl.java（实现类）
package com.alinesno.infra.base.authority.identity.service.impl;

import com.alinesno.infra.base.authority.identity.domain.RegisterLogEntity;
import com.alinesno.infra.base.authority.identity.mapper.RegisterLogMapper;
import com.alinesno.infra.base.authority.identity.service.IRegisterLogService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RegisterLogServiceImpl extends IBaseServiceImpl<RegisterLogEntity, RegisterLogMapper>
        implements IRegisterLogService {

    @Override
    public void saveRegisterLog(
            String phone,
            String clientIp,
            boolean isSuccess,
            String message,
            String errorDetail,
            String exceptionStack,
            String browserInfo,
            String osInfo,
            String sourceChannel) {
        RegisterLogEntity logEntity = new RegisterLogEntity();

        logEntity.setPhone(phone);
        logEntity.setClientIp(clientIp);
        logEntity.setIsSuccess(isSuccess ? 1 : 0); // 数据库存储0/1
        logEntity.setMessage(message);
        logEntity.setErrorDetail(errorDetail);
        logEntity.setExceptionStack(exceptionStack);
        logEntity.setBrowserInfo(browserInfo);
        logEntity.setOsInfo(osInfo);
        logEntity.setSourceChannel(sourceChannel);
        logEntity.setAddTime(new Date());

        // 风险等级可后续结合风控规则（如高频注册IP、异常User-Agent）动态设置
        logEntity.setRiskLevel("LOW");
        this.save(logEntity);
    }
}