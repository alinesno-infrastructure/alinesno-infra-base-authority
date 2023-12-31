package com.alinesno.infra.base.authority.service.impl;

import com.alinesno.infra.base.authority.entity.ManagerTenantLogEntity;
import com.alinesno.infra.base.authority.mapper.ManagerTenantLogMapper;
import com.alinesno.infra.base.authority.service.IManagerTenantLogService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@Service
public class ManagerTenantLogServiceImpl extends IBaseServiceImpl<ManagerTenantLogEntity, ManagerTenantLogMapper> implements IManagerTenantLogService {

	// 日志记录
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(ManagerTenantLogServiceImpl.class);

}
