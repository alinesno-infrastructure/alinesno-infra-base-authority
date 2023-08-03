package com.alinesno.infra.base.authority.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alinesno.infra.base.authority.entity.ManagerWorkingCalendarEntity;
import com.alinesno.infra.base.authority.mapper.ManagerWorkingCalendarMapper;
import com.alinesno.infra.base.authority.service.IManagerWorkingCalendarService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;

/**
 * <p>
 * 个人工作日历 服务实现类
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@Service
public class ManagerWorkingCalendarServiceImpl extends IBaseServiceImpl<ManagerWorkingCalendarEntity, ManagerWorkingCalendarMapper> implements IManagerWorkingCalendarService {

	// 日志记录
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(ManagerWorkingCalendarServiceImpl.class);

}
