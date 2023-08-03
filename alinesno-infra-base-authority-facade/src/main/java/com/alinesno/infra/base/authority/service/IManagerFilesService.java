package com.alinesno.infra.base.authority.service;

import com.alinesno.infra.base.authority.entity.ManagerFilesEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

public interface IManagerFilesService extends IBaseService<ManagerFilesEntity> {
	
	ManagerFilesEntity saveOne(ManagerFilesEntity entity);
 

}
