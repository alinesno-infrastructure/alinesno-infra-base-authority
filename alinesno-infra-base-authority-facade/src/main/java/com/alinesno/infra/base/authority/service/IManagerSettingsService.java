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

	ManagerSettingsEntity queryKey(String key, String applicationId);

	List<ManagerSettingsEntity> findByConfigKey(String configKey);

}
