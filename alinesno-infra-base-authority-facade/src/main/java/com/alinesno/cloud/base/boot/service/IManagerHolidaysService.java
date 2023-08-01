package com.alinesno.cloud.base.boot.service;

import com.alinesno.cloud.base.boot.entity.ManagerHolidaysEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

/**
 * <p>
 * 节假日设置 服务类
 * </p>
 *
 * @author WeiXiaoJin
 * @since 2019-12-28 09:37:21
 */

public interface IManagerHolidaysService extends IBaseService<ManagerHolidaysEntity> {
	boolean CheckHolidays(String holidays, String operatorId);
}
