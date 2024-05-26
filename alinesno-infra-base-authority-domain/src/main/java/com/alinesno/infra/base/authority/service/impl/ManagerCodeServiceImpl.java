package com.alinesno.infra.base.authority.service.impl;

import com.alinesno.infra.base.authority.entity.ManagerCodeEntity;
import com.alinesno.infra.base.authority.mapper.ManagerCodeMapper;
import com.alinesno.infra.base.authority.service.IManagerCodeService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@Slf4j
@Service
public class ManagerCodeServiceImpl extends IBaseServiceImpl<ManagerCodeEntity, ManagerCodeMapper> implements IManagerCodeService {

	@Override
	public List<ManagerCodeEntity> codeListByType(String type, String applicationId) { 
		return null;
	}
 
}
