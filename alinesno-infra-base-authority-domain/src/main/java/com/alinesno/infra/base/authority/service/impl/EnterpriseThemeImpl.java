package com.alinesno.infra.base.authority.service.impl;

import com.alinesno.infra.base.authority.entity.EnterpriseThemeEntity;
import com.alinesno.infra.base.authority.mapper.EnterpriseThemeMapper;
import com.alinesno.infra.base.authority.service.IEnterpriseThemeService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EnterpriseThemeImpl extends IBaseServiceImpl<EnterpriseThemeEntity, EnterpriseThemeMapper> implements IEnterpriseThemeService {
}
