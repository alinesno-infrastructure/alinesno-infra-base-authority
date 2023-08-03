package com.alinesno.infra.base.authority.service;

import java.util.List;

import com.alinesno.infra.base.authority.entity.ManagerCodeTypeEntity;
import com.alinesno.infra.common.facade.services.IBaseService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

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
