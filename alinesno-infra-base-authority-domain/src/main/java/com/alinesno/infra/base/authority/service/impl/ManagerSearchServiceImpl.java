package com.alinesno.infra.base.authority.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alinesno.infra.base.authority.entity.ManagerSearchEntity;
import com.alinesno.infra.base.authority.mapper.ManagerSearchMapper;
import com.alinesno.infra.base.authority.service.IManagerSearchService;
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
public class ManagerSearchServiceImpl extends IBaseServiceImpl<ManagerSearchEntity, ManagerSearchMapper> implements IManagerSearchService {

	// 日志记录
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(ManagerSearchServiceImpl.class);

}
