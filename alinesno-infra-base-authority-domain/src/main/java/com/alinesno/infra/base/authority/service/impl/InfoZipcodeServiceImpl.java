package com.alinesno.infra.base.authority.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alinesno.infra.base.authority.entity.InfoZipcodeEntity;
import com.alinesno.infra.base.authority.mapper.InfoZipcodeMapper;
import com.alinesno.infra.base.authority.service.IInfoZipcodeService;
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
public class InfoZipcodeServiceImpl extends IBaseServiceImpl<InfoZipcodeEntity, InfoZipcodeMapper> implements IInfoZipcodeService {

	// 日志记录
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(InfoZipcodeServiceImpl.class);

}
