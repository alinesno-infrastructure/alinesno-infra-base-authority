package com.alinesno.infra.base.authority.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alinesno.infra.base.authority.entity.ManagerSettingsEntity;
import com.alinesno.infra.base.authority.mapper.ManagerSettingsMapper;
import com.alinesno.infra.base.authority.service.IManagerSettingsService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.common.facade.constants.FieldConstants;
import com.alinesno.infra.common.facade.wrapper.mybatis.WrapperGenerator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * <p>
 * 参数配置表 服务实现类
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@Service
public class ManagerSettingsServiceImpl extends IBaseServiceImpl<ManagerSettingsEntity, ManagerSettingsMapper> implements IManagerSettingsService {

	// 日志记录
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(ManagerSettingsServiceImpl.class);

	@Autowired
	private ManagerSettingsMapper managerSettingsMapper;
 
	@Override
	public ManagerSettingsEntity queryKey(String key, String applicationId) { 
		
		QueryWrapper<ManagerSettingsEntity> w = WrapperGenerator.build();
		w.eq("config_key", key).eq(FieldConstants.APPLICATION_ID, applicationId);

		return getOne(w);
	}

	public List<ManagerSettingsEntity> findByConfigKey(String configKey) {

		QueryWrapper<ManagerSettingsEntity> w = WrapperGenerator.build();
		w.eq("config_key", configKey);

		return managerSettingsMapper.selectList(w);
	}

}
