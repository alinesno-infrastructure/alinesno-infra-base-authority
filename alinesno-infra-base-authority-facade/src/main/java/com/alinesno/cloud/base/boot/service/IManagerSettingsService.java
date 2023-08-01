package com.alinesno.cloud.base.boot.service;

import java.util.List;

import com.alinesno.cloud.base.boot.entity.ManagerSettingsEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

/**
 * <p>
 * 参数配置表 服务类
 * </p>
 *
 * @author WeiXiaoJin
 * @since 2019-07-06 15:47:49
 */

public interface IManagerSettingsService extends IBaseService<ManagerSettingsEntity> {

	ManagerSettingsEntity queryKey(String key, String applicationId);

	List<ManagerSettingsEntity> findByConfigKey(String configKey);

}
