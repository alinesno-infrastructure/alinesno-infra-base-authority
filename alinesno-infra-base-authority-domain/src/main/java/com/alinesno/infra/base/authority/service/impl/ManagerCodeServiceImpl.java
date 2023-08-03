package com.alinesno.infra.base.authority.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alinesno.infra.base.authority.entity.ManagerCodeEntity;
import com.alinesno.infra.base.authority.mapper.ManagerCodeMapper;
import com.alinesno.infra.base.authority.service.IManagerCodeService;
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
public class ManagerCodeServiceImpl extends IBaseServiceImpl<ManagerCodeEntity, ManagerCodeMapper> implements IManagerCodeService {

	// 日志记录
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(ManagerCodeServiceImpl.class);

	@Override
	public List<ManagerCodeEntity> codeListByType(String type, String applicationId) { 
		return null;
	}
 
}
