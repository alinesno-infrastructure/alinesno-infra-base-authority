package com.alinesno.infra.base.authority.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alinesno.infra.base.authority.entity.ManagerFilesEntity;
import com.alinesno.infra.base.authority.mapper.ManagerFilesMapper;
import com.alinesno.infra.base.authority.service.IManagerFilesService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;

@Service
public class ManagerFilesServiceImpl extends IBaseServiceImpl<ManagerFilesEntity, ManagerFilesMapper> implements IManagerFilesService {

	// 日志记录
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(ManagerFilesServiceImpl.class);

	@Override
	public ManagerFilesEntity saveOne(ManagerFilesEntity entity) { 
		return null;
	}
	  
}
