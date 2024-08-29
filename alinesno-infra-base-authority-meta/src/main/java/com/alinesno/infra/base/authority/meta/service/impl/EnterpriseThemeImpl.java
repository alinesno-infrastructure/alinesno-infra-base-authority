package com.alinesno.infra.base.authority.meta.service.impl;

import com.alinesno.infra.base.authority.meta.entity.EnterpriseThemeEntity;
import com.alinesno.infra.base.authority.meta.mapper.EnterpriseThemeMapper;
import com.alinesno.infra.base.authority.meta.service.IEnterpriseThemeService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EnterpriseThemeImpl extends IBaseServiceImpl<EnterpriseThemeEntity, EnterpriseThemeMapper> implements IEnterpriseThemeService {
	
	// 日志记录
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(EnterpriseThemeImpl.class);

}
