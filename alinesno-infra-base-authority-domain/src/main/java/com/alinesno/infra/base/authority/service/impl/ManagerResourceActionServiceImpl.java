package com.alinesno.infra.base.authority.service.impl;

import com.alinesno.infra.base.authority.entity.ManagerResourceActionEntity;
import com.alinesno.infra.base.authority.mapper.ManagerResourceActionMapper;
import com.alinesno.infra.base.authority.service.IManagerResourceActionService;
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
public class ManagerResourceActionServiceImpl extends IBaseServiceImpl<ManagerResourceActionEntity, ManagerResourceActionMapper> implements IManagerResourceActionService {

	// 日志记录
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(ManagerResourceActionServiceImpl.class);

}
