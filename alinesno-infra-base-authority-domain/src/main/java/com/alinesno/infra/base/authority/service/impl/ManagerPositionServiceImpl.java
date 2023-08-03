package com.alinesno.infra.base.authority.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alinesno.infra.base.authority.entity.ManagerPositionEntity;
import com.alinesno.infra.base.authority.mapper.ManagerPositionMapper;
import com.alinesno.infra.base.authority.service.IManagerPositionService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;

@Service
public class ManagerPositionServiceImpl extends IBaseServiceImpl<ManagerPositionEntity, ManagerPositionMapper> implements IManagerPositionService {
	// 日志记录
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(ManagerPositionServiceImpl.class);
}
