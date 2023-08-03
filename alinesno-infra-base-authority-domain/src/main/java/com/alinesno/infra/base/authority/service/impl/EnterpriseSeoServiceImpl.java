package com.alinesno.infra.base.authority.service.impl;

import org.springframework.stereotype.Service;

import com.alinesno.infra.base.authority.entity.EnterpriseSeoEntity;
import com.alinesno.infra.base.authority.mapper.EnterpriseSeoMapper;
import com.alinesno.infra.base.authority.service.IEnterpriseSeoService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;

@Service
public class EnterpriseSeoServiceImpl extends IBaseServiceImpl<EnterpriseSeoEntity, EnterpriseSeoMapper> implements IEnterpriseSeoService {
}
