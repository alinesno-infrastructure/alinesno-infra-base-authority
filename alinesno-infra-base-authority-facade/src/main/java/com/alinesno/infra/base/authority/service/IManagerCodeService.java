package com.alinesno.infra.base.authority.service;

import com.alinesno.infra.base.authority.entity.ManagerCodeEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */

public interface IManagerCodeService extends IBaseService<ManagerCodeEntity> {

	/**
	 * 根据字典类型获取字典配置列表
	 *
	 * @param type          类型
	 * @param applicationId 应用id
	 * @return
	 */
	List<ManagerCodeEntity> codeListByType(String type, String applicationId);

}
