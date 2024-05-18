package com.alinesno.infra.base.authority.service.impl;

import com.alinesno.infra.base.authority.entity.ManagerGroupEntity;
import com.alinesno.infra.base.authority.mapper.ManagerGroupMapper;
import com.alinesno.infra.base.authority.service.IManagerGroupService;
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
public class ManagerGroupServiceImpl extends IBaseServiceImpl<ManagerGroupEntity, ManagerGroupMapper> implements IManagerGroupService {

	// 日志记录
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(ManagerGroupServiceImpl.class); 
 

}
