package com.alinesno.infra.base.authority.service.impl;

import org.springframework.stereotype.Service;

import com.alinesno.infra.base.authority.entity.EnterpriseAccountEntity;
import com.alinesno.infra.base.authority.mapper.EnterpriseAccountMapper;
import com.alinesno.infra.base.authority.service.IEnterpriseAccountService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;

@Service
public class EnterpriseAccountServiceImpl extends IBaseServiceImpl<EnterpriseAccountEntity, EnterpriseAccountMapper> implements IEnterpriseAccountService {
}
