package com.alinesno.infra.base.authority.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alinesno.infra.base.authority.entity.EnterpriseSettingEntity;
import com.alinesno.infra.base.authority.mapper.EnterpriseSettingMapper;
import com.alinesno.infra.base.authority.service.IEnterpriseSettingService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yangboot
 * @version 1.0.0
 */
@Service
public class EnterpriseSettingServiceImpl extends IBaseServiceImpl<EnterpriseSettingEntity, EnterpriseSettingMapper> implements IEnterpriseSettingService {

	// 日志记录
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(EnterpriseSettingServiceImpl.class);

}
