package com.alinesno.infra.base.authority.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alinesno.infra.base.authority.entity.InfoSchoolEntity;
import com.alinesno.infra.base.authority.mapper.InfoSchoolMapper;
import com.alinesno.infra.base.authority.service.IInfoSchoolService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@Service
public class InfoSchoolServiceImpl extends IBaseServiceImpl<InfoSchoolEntity, InfoSchoolMapper> implements IInfoSchoolService {

	// 日志记录
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(InfoSchoolServiceImpl.class);

}
