package com.alinesno.infra.base.authority.service.impl;

import com.alinesno.infra.base.authority.entity.InfoAddressEntity;
import com.alinesno.infra.base.authority.mapper.InfoAddressMapper;
import com.alinesno.infra.base.authority.service.IInfoAddressService;
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
public class InfoAddressServiceImpl extends IBaseServiceImpl<InfoAddressEntity, InfoAddressMapper> implements IInfoAddressService {

	// 日志记录
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(InfoAddressServiceImpl.class);

}
