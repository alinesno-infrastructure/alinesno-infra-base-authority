package com.alinesno.infra.base.authority.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.alinesno.infra.base.authority.api.dto.ManagerAccountDto;
import com.alinesno.infra.base.authority.entity.ManagerAccountEntity;
import com.alinesno.infra.base.authority.entity.ManagerResourceEntity;
import com.alinesno.infra.base.authority.entity.ManagerRoleEntity;
import com.alinesno.infra.base.authority.entity.ManagerRoleResourceEntity;
import com.alinesno.infra.base.authority.enums.MenuEnums;
import com.alinesno.infra.base.authority.enums.RolePowerTypeEnmus;
import com.alinesno.infra.base.authority.mapper.ManagerAccountMapper;
import com.alinesno.infra.base.authority.service.IManagerAccountRoleService;
import com.alinesno.infra.base.authority.service.IManagerAccountService;
import com.alinesno.infra.base.authority.service.IManagerResourceService;
import com.alinesno.infra.base.authority.service.IManagerRoleResourceService;
import com.alinesno.infra.base.authority.service.IManagerRoleService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.common.facade.enums.HasStatusEnums;
import com.alinesno.infra.common.facade.wrapper.RpcWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.hutool.core.bean.BeanUtil;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@Service
public class ManagerAccountServiceImpl extends IBaseServiceImpl<ManagerAccountEntity, ManagerAccountMapper> implements IManagerAccountService {

	// 日志记录
	private static final Logger log = LoggerFactory.getLogger(ManagerAccountServiceImpl.class);

	@Autowired
	private ManagerAccountMapper managerAccountMapper; 
	
	@Autowired
	private IManagerRoleService managerRoleService;
	
	@Autowired
	private IManagerAccountRoleService iManagerAccountRoleService;

	@Autowired
	private IManagerResourceService managerResourceService;

	@Autowired
	private IManagerRoleResourceService managerRoleResourceService;

	@Override
	public ManagerAccountEntity findByLoginName(String loginName) {
		log.debug("login name:{}", loginName);

		RpcWrapper<ManagerAccountEntity> wrapper = RpcWrapper.build();
		wrapper.eq("login_name", loginName);

		ManagerAccountEntity account = findOne(wrapper);

		Assert.notNull(account, "账号【" + loginName + "】查询为空.");

		if (!RolePowerTypeEnmus.ROLE_ADMIN.value.equals(account.getRolePower())) {
			account.setPermission(this.findPermissions(account));
			account.setRole(this.findRoles(account));
		}

		return account;

	}

	@Override
	public boolean registAccount(String loginName, String password, String phoneCode, String salt, String phone) {

		return true;
	}
 
	@Override
	public boolean isAdmin(ManagerAccountEntity dto) { 
		return RolePowerTypeEnmus.ROLE_ADMIN.value.equals(dto.getRolePower()) ? true : false;
	}

	@Override
	public Set<String> findRoles(ManagerAccountEntity dto) {
		Set<String> role = new HashSet<String>();

		// TODO 待处理用户角色问题
		role.add("admin");

		return role;
	}

	/**
	 * 查询所有操作权限,Shiro为我们定义了一个抽象的权限描述字串：<br/>
	 * [资源]:[模块]:[操作] ===> 如: sys:user:add
	 */
	@Override
	public Set<String> findPermissions(ManagerAccountEntity dto) {
		Set<String> permission = new HashSet<String>();

		Long uId = dto.getId();
		List<ManagerRoleEntity> roles = managerRoleService.findByAccountId(uId);

		List<Long> roleIdList = new ArrayList<Long>();
		for (ManagerRoleEntity r : roles) {
			roleIdList.add(r.getId());
		}

		QueryWrapper<ManagerRoleResourceEntity> wrapper = new QueryWrapper<ManagerRoleResourceEntity>()
				.in("role_id", roleIdList).eq("has_status", HasStatusEnums.LEGAL.value);
		List<ManagerRoleResourceEntity> mrs = managerRoleResourceService.list(wrapper);

		List<String> resourceIdIdList = new ArrayList<String>();
		for (ManagerRoleResourceEntity r : mrs) {
			resourceIdIdList.add(r.getResourceId());
		}
		QueryWrapper<ManagerResourceEntity> rolewrapper = new QueryWrapper<ManagerResourceEntity>().in("id",
				resourceIdIdList);
		List<ManagerResourceEntity> reList = managerResourceService.list(rolewrapper);

		for (ManagerResourceEntity re : reList) {
			// 如果是按钮
			if (re != null) {
				if (MenuEnums.MENU_BUTTON.value.equals(re.getMenuType())) {
					permission.add(re.getPermission());
				}
			}
		}

		return permission;
	}

	@Override
	public void updateAvator(String path, String id) {
		ManagerAccountEntity e = findEntityById(id);
		e.setAvatorPath(path);

		this.update(e);
	}

	@Override
	public boolean checkEmailUnique(String email, String userId) {

		return true;
	}

	@Override
	public boolean checkPhoneUnique(String phone, String userId) {
		return true;
	}

	@Override
	public boolean checkLoginName(String LoginName, String applicationCode) {

		return true;
	}

	@Override
	public void saveAccountAndAuthRole(ManagerAccountEntity entity, List<Long> roleIds, String applicationCode,
			boolean isEncode) {
		log.debug("添加账号:{}", "ManagerAccountEntity:{}" + ToStringBuilder.reflectionToString(entity) + "/n roles:{}"
				+ roleIds + "  /n applicationCode" + applicationCode);

		// 数据校验
		validateAccount(entity);

		cn.hutool.core.lang.Assert.isFalse(checkLoginName(entity.getLoginName(), applicationCode), "用户名已存在");

		// 密文
		if (isEncode) {
		}
		managerAccountMapper.insert(entity);
		log.info("用户信息{}:" + entity);

		iManagerAccountRoleService.authorizeUsers(roleIds, entity.getId(), applicationCode);

	}

	/**
	 * 数据校验
	 *
	 * @param entity
	 */
	private void validateAccount(ManagerAccountEntity entity) {
		Assert.notNull(entity, "用户不能为空");
		Assert.hasLength(entity.getPassword(), "密码不能为空");
		Assert.hasLength(entity.getLoginName(), "登录名不能为空");
		Assert.hasLength(entity.getPassword(), "密码不能为空");
		Assert.hasLength(entity.getApplicationId() + "", "所属应用不能为空");
	}

	@Override
	public void updateAccountAndAuthRole(ManagerAccountEntity entity, List<Long> rolesIds, String applicationCode,
			boolean isEncode) {
		validateAccount(entity);
		ManagerAccountEntity oldBean = findEntityById(entity.getId());
		if (isEncode && !entity.getPassword().equals(oldBean.getPassword())) {

		}
		if (!oldBean.getLoginName().equals(entity.getLoginName())) {
			cn.hutool.core.lang.Assert.isFalse(checkLoginName(entity.getLoginName(), applicationCode), "账号已存在");
		}
		BeanUtil.copyProperties(entity, oldBean, true);
		this.update(oldBean);
		iManagerAccountRoleService.authorizeUsers(rolesIds, entity.getId(), applicationCode);
	}

	@Override
	public Page<ManagerAccountEntity> findRoleMemberPage(String roleId, RpcWrapper<ManagerAccountEntity> wrapper) {
//		 t1.roleId=?1 and t2.id IS NOT NULL 

		wrapper.eq("t1.roleId", roleId).isNotNull("t2.id");
		return managerAccountMapper.findRoleMemberByPage(wrapper.toQueryWrapper());
	}

	public boolean checkLoginName(String LoginName) {
		// 数据校验
		RpcWrapper<ManagerAccountEntity> namewrapper = RpcWrapper.build();
		namewrapper.eq("login_name", LoginName);
		List<ManagerAccountEntity> byLoginName = this.findAll(namewrapper);
		return byLoginName.size() > 0;
	}

	@Override
	public void registerAccount(ManagerAccountEntity e, List<Long> authRole, String applicationName) {

		// 保存用户信息
		this.save(e);

		if (authRole != null) {
			// 用户授权
			iManagerAccountRoleService.authorizeUsers(authRole, e.getId(), applicationName);
		}
	}

	@Override
	public void internetRegisterAccount(ManagerAccountDto dto) {

	}

	@Override
	public boolean resetPassword(String id, String newPassword, String oldPassword) {
		return false;
	}

	@Override
	public void resetPassword(String id, String newPassword, boolean isEncode) {

	}

}
