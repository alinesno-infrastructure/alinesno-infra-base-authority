package com.alinesno.infra.base.authority.meta.service.impl;

import com.alinesno.infra.base.authority.meta.entity.EnterpriseSeoEntity;
import com.alinesno.infra.base.authority.meta.mapper.EnterpriseSeoMapper;
import com.alinesno.infra.base.authority.meta.service.IEnterpriseSeoService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class EnterpriseSeoServiceImpl extends IBaseServiceImpl<EnterpriseSeoEntity, EnterpriseSeoMapper> implements IEnterpriseSeoService {
}
