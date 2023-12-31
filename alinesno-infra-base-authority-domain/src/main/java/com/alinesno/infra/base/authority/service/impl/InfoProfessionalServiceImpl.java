package com.alinesno.infra.base.authority.service.impl;

import com.alinesno.infra.base.authority.entity.InfoProfessionalEntity;
import com.alinesno.infra.base.authority.mapper.InfoProfessionalMapper;
import com.alinesno.infra.base.authority.service.IInfoProfessionalService;
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
public class InfoProfessionalServiceImpl extends IBaseServiceImpl<InfoProfessionalEntity, InfoProfessionalMapper> implements IInfoProfessionalService {

	// 日志记录
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(InfoProfessionalServiceImpl.class);

}
