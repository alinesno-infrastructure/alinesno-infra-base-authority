package com.alinesno.infra.base.authority.service;

import com.alinesno.infra.base.authority.entity.ManagerFilesEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

public interface IManagerFilesService extends IBaseService<ManagerFilesEntity> {
	ManagerFilesEntity saveOne(ManagerFilesEntity entity);

	/**
	 * 文件路径
	 * 
	 * @param fileId
	 * @return
	 */
	String display(String fileId);

	/**
	 * 文件路径(绝对路径)
	 * 
	 * @param fileId
	 * @return
	 */
	String displayAbsolutePath(String fileId);

	String download(String fileId);

}
