package com.alinesno.infra.base.authority.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alinesno.infra.base.authority.entity.ManagerCodeTypeEntity;
import com.alinesno.infra.base.authority.mapper.ManagerCodeTypeMapper;
import com.alinesno.infra.base.authority.service.IManagerCodeTypeService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.common.facade.wrapper.mybatis.WrapperGenerator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@Service
public class ManagerCodeTypeServiceImpl extends IBaseServiceImpl<ManagerCodeTypeEntity, ManagerCodeTypeMapper> implements IManagerCodeTypeService {

	// 日志记录
	private static final Logger log = LoggerFactory.getLogger(ManagerCodeTypeServiceImpl.class);
  
	@Override
	public ManagerCodeTypeEntity findByCodeTypeValue(String codeTypeValue) { 

		log.debug("CodeTypeValue:{}", codeTypeValue);

		QueryWrapper<ManagerCodeTypeEntity> w = WrapperGenerator.build();
		w.eq("code_type_ualue", codeTypeValue);

		return getOne(w);

	}

	@Override
	public List<ManagerCodeTypeEntity> list(QueryWrapper<ManagerCodeTypeEntity> queryWrapper) {
		return list(queryWrapper);
	}

}
