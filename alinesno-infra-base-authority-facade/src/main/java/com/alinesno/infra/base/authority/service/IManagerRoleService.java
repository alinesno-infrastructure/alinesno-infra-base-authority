package com.alinesno.infra.base.authority.service;

import com.alinesno.infra.base.authority.entity.ManagerAccountEntity;
import com.alinesno.infra.base.authority.entity.ManagerRoleEntity;
import com.alinesno.infra.base.authority.gateway.dto.AccountRoleDto;
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

public interface IManagerRoleService extends IBaseService<ManagerRoleEntity> {

	/**
	 * 保存用户权限
	 *
	 * @param managerRoleEntity
	 * @param functiondIds
	 * @return
	 */
	boolean saveRole(ManagerRoleEntity managerRoleEntity, String functionIds);

	/**
	 * 保存用户角色
	 *
	 * @param accountEntity
	 * @param rolesId
	 * @return
	 */
	boolean authAccount(ManagerAccountEntity accountEntity, Long[] rolesId);

	/**
	 * 查询用户所有角色
	 *
	 * @param accountId
	 * @return
	 */
	List<ManagerRoleEntity> findByAccountId(Long accountId);

	/**
	 * 查询用户所有角色
	 * 
	 * @param accountIds
	 * @param applicationCode （非必填）
	 * @return
	 */
	List<AccountRoleDto> findByAccountIds(List<String> accountIds, String applicationCode);

	/**
	 * 删除用户角色
	 *
	 * @param ids
	 */
	void deleteRoleByIds(String ids);

	/**
	 * 用户权限
	 *
	 * @param configValue
	 */
	void authAccount(ManagerAccountEntity accountEntity, String configValue);

	List<ManagerRoleEntity> findAllByApplicationCode(String applicationId);

	/**
	 * 追加用户权限
	 * 
	 * @param accountId
	 * @param roleId
	 */
	void appendAccountRole(Long accountId, Long[] roleId);

//	/**
//	 * 配置默认互联网用户
//	 *
//	 * @param applicationId
//	 * @param fieldId
//	 * @param value
//	 */
//	void updateDefaultNetrole(String applicationId, String fieldId, String value);

	/**
	 * 校验角色是否允许操作
	 *
	 * @param role 角色信息
	 */
    void checkRoleAllowed(ManagerRoleEntity role);

	/**
	 * 通过角色ID查询角色使用数量
	 *
	 * @param roleId 角色ID
	 * @return 结果
	 */
	void checkRoleDataScope(Long roleId);

	/**
	 * 修改角色状态
	 *
	 * @param id 角色ID
	 * @param hasStatus 角色状态
	 * @return 结果
	 */
	int updateRoleStatus(Long id, int hasStatus);
}
