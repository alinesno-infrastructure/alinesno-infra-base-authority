package com.alinesno.infra.base.authority.service;

import java.util.List;

import com.alinesno.infra.base.authority.entity.ManagerApplicationEntity;
import com.alinesno.infra.base.authority.entity.ManagerDepartmentEntity;
import com.alinesno.infra.common.facade.services.IBaseService;
import com.alinesno.infra.common.facade.wrapper.RpcWrapper;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */

public interface IManagerDepartmentService extends IBaseService<ManagerDepartmentEntity> {

	List<ManagerDepartmentEntity> findAllWithApplication(RpcWrapper<ManagerDepartmentEntity> dw,
			RpcWrapper<ManagerApplicationEntity> aw);

	/**
	 * 通过应用id查询部门相关人员
	 * 
	 * @param applicationId
	 * @param parentDeptId
	 * @return
	 */
	Object findDepByApplication(String applicationId, String parentDeptId);

	/**
	 * 通过查询部门相关人员
	 * 
	 * @param applicationId
	 * @param parentDeptId
	 * @return
	 */
	Object findDepByDeptId(String parentDeptId);

}
