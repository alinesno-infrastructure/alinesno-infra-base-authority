package com.alinesno.infra.base.authority.meta.service.impl;

import com.alinesno.infra.base.authority.meta.entity.InfoSettingsEntity;
import com.alinesno.infra.base.authority.meta.mapper.InfoSettingsMapper;
import com.alinesno.infra.base.authority.meta.service.IInfoSettingsService;
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
public class InfoSettingsServiceImpl extends IBaseServiceImpl<InfoSettingsEntity, InfoSettingsMapper> implements IInfoSettingsService {

	// 日志记录
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(InfoSettingsServiceImpl.class);

}
