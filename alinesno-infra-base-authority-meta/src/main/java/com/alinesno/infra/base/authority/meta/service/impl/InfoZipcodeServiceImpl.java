package com.alinesno.infra.base.authority.meta.service.impl;

import com.alinesno.infra.base.authority.meta.entity.InfoZipcodeEntity;
import com.alinesno.infra.base.authority.meta.mapper.InfoZipcodeMapper;
import com.alinesno.infra.base.authority.meta.service.IInfoZipcodeService;
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
public class InfoZipcodeServiceImpl extends IBaseServiceImpl<InfoZipcodeEntity, InfoZipcodeMapper> implements IInfoZipcodeService {

	// 日志记录
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(InfoZipcodeServiceImpl.class);

}
