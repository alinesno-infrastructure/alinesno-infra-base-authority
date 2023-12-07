package com.alinesno.infra.base.authority.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alinesno.infra.base.authority.entity.SysDeptEntity;
import com.alinesno.infra.base.authority.mapper.SysDeptMapper;
import com.alinesno.infra.base.authority.service.ISysDeptService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author LuoXiaoDong
 * @version 1.0.0
 */
@Service
public class SysDeptServiceImpl extends IBaseServiceImpl<SysDeptEntity, SysDeptMapper> implements ISysDeptService {

	// 日志记录
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(SysDeptServiceImpl.class);

}