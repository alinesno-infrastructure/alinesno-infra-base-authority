package com.alinesno.infra.base.authority.meta.service.impl;

import com.alinesno.infra.base.authority.meta.entity.EnterpriseSettingEntity;
import com.alinesno.infra.base.authority.meta.mapper.EnterpriseSettingMapper;
import com.alinesno.infra.base.authority.meta.service.IEnterpriseSettingService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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
