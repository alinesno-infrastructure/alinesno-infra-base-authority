package com.alinesno.infra.base.authority.service;

import com.alinesno.infra.base.authority.api.dto.TreeSelect;
import com.alinesno.infra.base.authority.entity.ManagerProjectEntity;
import com.alinesno.infra.base.authority.entity.ManagerDepartmentEntity;
import com.alinesno.infra.common.facade.services.IBaseService;
import com.alinesno.infra.common.facade.wrapper.RpcWrapper;

import java.util.List;

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
			RpcWrapper<ManagerProjectEntity> aw);

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
	 * @param parentDeptId
	 * @return
	 */
	Object findDepByDeptId(String parentDeptId);

	/**
	 * 初始化部门应用
	 * @param projectId
	 */
    void initDept(Long projectId);

	/**
	 * 查询应用部门列表
	 *
	 * @return
	 */
    List<TreeSelect> selectDeptTreeList();

	/**
	 * 列出服务应用列表
	 *
	 * @param managerDepartmentEntity
	 * @param projectId
	 * @return
	 */
	List<ManagerDepartmentEntity> selectDeptList(ManagerDepartmentEntity managerDepartmentEntity, long projectId);
}
