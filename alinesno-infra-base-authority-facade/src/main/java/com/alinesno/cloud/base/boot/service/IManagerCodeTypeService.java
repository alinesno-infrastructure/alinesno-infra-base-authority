package com.alinesno.cloud.base.boot.service;

import java.util.List;

import com.alinesno.cloud.base.boot.entity.ManagerCodeTypeEntity;
import com.alinesno.infra.common.facade.services.IBaseService;
import com.alinesno.infra.common.facade.wrapper.LambadaRpcWrapper;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author WeiXiaoJin
 * @since 2019-02-07 21:16:11
 */

public interface IManagerCodeTypeService extends IBaseService<ManagerCodeTypeEntity> {

	ManagerCodeTypeEntity findByCodeTypeValue(String codeTypeValue);

	List<ManagerCodeTypeEntity> list(LambadaRpcWrapper<ManagerCodeTypeEntity> queryWrapper);
}
