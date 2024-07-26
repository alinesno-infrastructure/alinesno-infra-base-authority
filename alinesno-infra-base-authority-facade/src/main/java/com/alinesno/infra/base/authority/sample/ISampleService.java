package com.alinesno.infra.base.authority.sample;

import com.alinesno.infra.base.authority.entity.ManagerProjectEntity;
import com.alinesno.infra.base.authority.service.IManagerProjectService;

public interface ISampleService {

    void genSimpleProjectData(long userId, long orgId);

    void genSimpleProjectData(ManagerProjectEntity project, long userId, long orgId);

}
