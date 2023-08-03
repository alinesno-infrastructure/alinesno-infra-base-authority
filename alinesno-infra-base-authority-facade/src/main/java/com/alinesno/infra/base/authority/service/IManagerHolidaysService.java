package com.alinesno.infra.base.authority.service;

import com.alinesno.infra.base.authority.entity.ManagerHolidaysEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

/**
 * <p>
 * 节假日设置 服务类
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */

public interface IManagerHolidaysService extends IBaseService<ManagerHolidaysEntity> {
	boolean CheckHolidays(String holidays, String operatorId);
}
