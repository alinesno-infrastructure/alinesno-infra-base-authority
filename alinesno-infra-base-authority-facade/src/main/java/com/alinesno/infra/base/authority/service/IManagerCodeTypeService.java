package com.alinesno.infra.base.authority.service;

import com.alinesno.infra.base.authority.entity.ManagerCodeTypeEntity;
import com.alinesno.infra.common.facade.services.IBaseService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */

public interface IManagerCodeTypeService extends IBaseService<ManagerCodeTypeEntity> {

	ManagerCodeTypeEntity findByCodeTypeValue(String codeTypeValue);

	List<ManagerCodeTypeEntity> list(QueryWrapper<ManagerCodeTypeEntity> queryWrapper);
}
