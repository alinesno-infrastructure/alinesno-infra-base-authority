package com.alinesno.infra.base.authority.meta.service.impl;

import com.alinesno.infra.base.authority.meta.entity.EnterpriseAccountEntity;
import com.alinesno.infra.base.authority.meta.mapper.EnterpriseAccountMapper;
import com.alinesno.infra.base.authority.meta.service.IEnterpriseAccountService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class EnterpriseAccountServiceImpl extends IBaseServiceImpl<EnterpriseAccountEntity, EnterpriseAccountMapper> implements IEnterpriseAccountService {
}
