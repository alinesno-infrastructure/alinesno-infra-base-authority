package com.alinesno.infra.base.authority.identity.service.impl;

import com.alinesno.infra.base.authority.identity.domain.LoginEventEntity;
import com.alinesno.infra.base.authority.identity.mapper.LoginEventMapper;
import com.alinesno.infra.base.authority.identity.service.ILoginEventService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoginEventServiceImpl extends IBaseServiceImpl<LoginEventEntity, LoginEventMapper> implements ILoginEventService {
}
