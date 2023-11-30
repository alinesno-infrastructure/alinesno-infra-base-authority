package com.alinesno.infra.base.authority.service.impl;

import com.alinesno.infra.base.authority.entity.EnterpriseSeoEntity;
import com.alinesno.infra.base.authority.mapper.EnterpriseSeoMapper;
import com.alinesno.infra.base.authority.service.IEnterpriseSeoService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class EnterpriseSeoServiceImpl extends IBaseServiceImpl<EnterpriseSeoEntity, EnterpriseSeoMapper> implements IEnterpriseSeoService {
}
