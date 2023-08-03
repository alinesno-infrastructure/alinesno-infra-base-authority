package com.alinesno.infra.base.authority.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alinesno.infra.base.authority.entity.EnterpriseThemeEntity;
import com.alinesno.infra.base.authority.mapper.EnterpriseThemeMapper;
import com.alinesno.infra.base.authority.service.IEnterpriseThemeService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;

@Service
public class EnterpriseThemeImpl extends IBaseServiceImpl<EnterpriseThemeEntity, EnterpriseThemeMapper> implements IEnterpriseThemeService {
	
	// 日志记录
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(EnterpriseThemeImpl.class);

}
