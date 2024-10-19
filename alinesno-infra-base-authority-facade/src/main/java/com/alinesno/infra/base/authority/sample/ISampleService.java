package com.alinesno.infra.base.authority.sample;

import com.alinesno.infra.base.authority.entity.ManagerProjectEntity;

public interface ISampleService {

    void genSimpleProjectData(long userId, long orgId);

    void genSimpleProjectData(ManagerProjectEntity project, long userId, long orgId);

}
