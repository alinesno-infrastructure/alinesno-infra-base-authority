package com.alinesno.cloud.base.boot.service;

import java.util.List;

import com.alinesno.cloud.base.boot.dto.AccountRoleDto;
import com.alinesno.cloud.base.boot.entity.ManagerAccountEntity;
import com.alinesno.cloud.base.boot.entity.ManagerRoleEntity;
import com.alinesno.infra.common.facade.services.IBaseService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author WeiXiaoJin
 * @since 2018-12-16 17:53:19
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
	boolean authAccount(ManagerAccountEntity accountEntity, String[] rolesId);

	/**
	 * 查询用户所有角色
	 *
	 * @param accountId
	 * @return
	 */
	List<ManagerRoleEntity> findByAccountId(String accountId);

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
	 * @param accountId
	 * @param roleId 
	 */
	void apendAccountRole(String accountId, String[] roleId);

	/**
	 * 配置默认互联网用户
	 * @param applicationId
	 * @param field
	 * @param value
	 */
	void updateDefaultNetrole(String applicationId, String fieldId, String value);


}
