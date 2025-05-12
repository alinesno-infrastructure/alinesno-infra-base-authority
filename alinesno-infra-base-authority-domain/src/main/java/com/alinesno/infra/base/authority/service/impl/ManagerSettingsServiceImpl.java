package com.alinesno.infra.base.authority.service.impl;

import com.alinesno.infra.base.authority.entity.ManagerSettingsEntity;
import com.alinesno.infra.base.authority.mapper.ManagerSettingsMapper;
import com.alinesno.infra.base.authority.service.IManagerSettingsService;
import com.alinesno.infra.base.authority.utils.RedisCache;
import com.alinesno.infra.common.core.constants.CacheConstants;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.common.facade.constants.FieldConstants;
import com.alinesno.infra.common.facade.wrapper.mybatis.WrapperGenerator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 参数配置表 服务实现类
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@Slf4j
@Service
public class ManagerSettingsServiceImpl extends IBaseServiceImpl<ManagerSettingsEntity, ManagerSettingsMapper> implements IManagerSettingsService {

	@Autowired
	private RedisCache redisCache;

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

	@Override
	public void resetConfigCache() {
		clearConfigCache();
		loadingConfigCache();
	}

	/**
	 * 加载参数缓存数据
	 */
	@Override
	public void loadingConfigCache() {
		List<ManagerSettingsEntity> configsList = list() ;
		for (ManagerSettingsEntity config : configsList) {
			redisCache.setCacheObject(getCacheKey(config.getConfigKey()), config.getConfigValue());
		}
	}

	/**
	 * 清空参数缓存数据
	 */
	@Override
	public void clearConfigCache() {
		Collection<String> keys = redisCache.keys(CacheConstants.SYS_CONFIG_KEY + "*");
		redisCache.deleteObject(keys);
	}

	/**
	 * 设置cache key
	 *
	 * @param configKey 参数键
	 * @return 缓存键key
	 */
	private String getCacheKey(String configKey) {
		return CacheConstants.SYS_CONFIG_KEY + configKey;
	}
}
