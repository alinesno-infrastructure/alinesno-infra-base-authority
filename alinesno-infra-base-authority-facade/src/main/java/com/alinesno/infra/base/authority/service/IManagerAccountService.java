package com.alinesno.infra.base.authority.service;

import java.util.List;
import java.util.Set;

import com.alinesno.infra.base.authority.api.dto.ManagerAccountDto;
import com.alinesno.infra.base.authority.entity.ManagerAccountEntity;
import com.alinesno.infra.common.facade.services.IBaseService;
import com.alinesno.infra.common.facade.wrapper.RpcWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */

public interface IManagerAccountService extends IBaseService<ManagerAccountEntity> {

	/**
	 * 通过用户名查询用户信息
	 *
	 * @return
	 */
	ManagerAccountEntity findByLoginName(String loginName);

	/**
	 * 重置用户密码
	 *
	 * @param id
	 * @param newPassword
	 * @param oldPassword
	 * @return
	 */
	boolean resetPassword(String id, String newPassword, String oldPassword);

	/**
	 * 重置密码
	 * 
	 * @param id          用户id
	 * @param newPassword
	 * @param isEncode    是否加密
	 * @return
	 */
	void resetPassword(String id, String newPassword, boolean isEncode);

	/**
	 * 注册用户
	 *
	 * @param loginName 邮箱
	 * @param password  密码
	 * @param phoneCode 验证码
	 * @return
	 */
	boolean registAccount(String loginName, String password, String phoneCode, String salt, String phone);

	/**
	 * 判断用户是否有超级管理员
	 *
	 * @param dto
	 * @return
	 */
	boolean isAdmin(ManagerAccountEntity dto);

	/**
	 * 获取所有角色值 ，用于后期用户权限权限判断
	 *
	 * @param dto
	 * @return
	 */
	Set<String> findRoles(ManagerAccountEntity dto);

	/**
	 * 获取用户权限
	 *
	 * @param dto
	 * @return
	 */
	Set<String> findPermissions(ManagerAccountEntity dto);

	/**
	 * 更新头像路径
	 *
	 * @param path
	 * @param id
	 */
	void updateAvator(String path, String id);

	/**
	 * 验证是否为唯一邮箱
	 *
	 * @param email
	 * @param userId
	 * @return 是true|不是false
	 */
	boolean checkEmailUnique(String email, String userId);

	/**
	 * 验证是否为唯一手机号
	 *
	 * @param phone
	 * @param userId
	 * @return 是true|不是false
	 */
	boolean checkPhoneUnique(String phone, String userId);

	/**
	 * 根据用户所在角色分页查询
	 *
	 * @param roleId
	 * @return
	 */
	Page<ManagerAccountEntity> findRoleMemberPage(String roleId, RpcWrapper<ManagerAccountEntity> restWrapper);

	/**
	 * 保存账号并授予角色
	 *
	 * @param entity          用户实体
	 * @param rolesIds        角色列表
	 * @param applicationCode 应用码
	 */
	void saveAccountAndAuthRole(ManagerAccountEntity entity, List<Long> rolesIds, String applicationCode,
			boolean isEncode);

	void updateAccountAndAuthRole(ManagerAccountEntity entity, List<Long> rolesIds, String applicationCode,
			boolean isEncode);

	/**
	 * 校验账号是否存在
	 * 
	 * @param LoginName
	 * @param applicationCode
	 * @return true_存在
	 */
	boolean checkLoginName(String LoginName, String applicationCode);

	/**
	 * 用户注册账号密码
	 * 
	 * @param e
	 * @param authRole
	 * @param applicationName
	 */
	void registerAccount(ManagerAccountEntity e, List<Long> authRole, String applicationName);

	/**
	 * 平台互联网用户信息
	 * 
	 * @param dto
	 */
	void internetRegisterAccount(ManagerAccountDto dto);

}
