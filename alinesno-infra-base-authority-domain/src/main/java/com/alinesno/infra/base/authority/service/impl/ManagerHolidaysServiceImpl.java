package com.alinesno.infra.base.authority.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alinesno.infra.base.authority.entity.ManagerHolidaysEntity;
import com.alinesno.infra.base.authority.mapper.ManagerHolidaysMapper;
import com.alinesno.infra.base.authority.service.IManagerHolidaysService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;

/**
 * <p>
 * 节假日设置 服务实现类
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@Service
public class ManagerHolidaysServiceImpl extends IBaseServiceImpl<ManagerHolidaysEntity, ManagerHolidaysMapper> implements IManagerHolidaysService {
	
	// 日志记录
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(ManagerHolidaysServiceImpl.class);
 
	@Override
	public boolean CheckHolidays(String holidays, String operatorId) {
 
		return false;
	}

}
