package com.alinesno.infra.base.authority.service;

import com.alinesno.infra.base.authority.entity.ManagerSettingsEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

import java.util.List;

/**
 * <p>
 * 参数配置表 服务类
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */

public interface IManagerSettingsService extends IBaseService<ManagerSettingsEntity> {

	/**
	 * 查询应用参数
	 * @param key
	 * @param projectId
	 * @return
	 */
	ManagerSettingsEntity queryKey(String key, String projectId);

	/**
	 * 通过参数名称获取参数
	 * @param configKey
	 * @return
	 */
	List<ManagerSettingsEntity> findByConfigKey(String configKey);

	/**
	 * 刷新参数配置缓存
	 */
    void resetConfigCache();

	/**
	 * 加载参数缓存数据
	 */
	void loadingConfigCache();

	/**
	 * 清空参数缓存数据
	 */
	void clearConfigCache();

}
