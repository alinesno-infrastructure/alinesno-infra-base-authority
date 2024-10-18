package com.alinesno.infra.base.authority.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.crypto.digest.BCrypt;
import com.alinesno.infra.base.authority.entity.ManagerAccountEntity;
import com.alinesno.infra.base.authority.enums.RolePowerTypeEnmus;
import com.alinesno.infra.base.authority.gateway.dto.ManagerAccountDto;
import com.alinesno.infra.base.authority.mapper.ManagerAccountMapper;
import com.alinesno.infra.base.authority.mapper.OrganizationAccountMapper;
import com.alinesno.infra.base.authority.mapper.OrganizationMapper;
import com.alinesno.infra.base.authority.service.IManagerAccountRoleService;
import com.alinesno.infra.base.authority.service.IManagerAccountService;
import com.alinesno.infra.base.authority.service.IManagerRoleResourceService;
import com.alinesno.infra.base.authority.service.IManagerRoleService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.common.facade.exception.ServiceException;
import com.alinesno.infra.common.facade.wrapper.RpcWrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@Slf4j
@Service
public class ManagerAccountServiceImpl extends IBaseServiceImpl<ManagerAccountEntity, ManagerAccountMapper> implements IManagerAccountService {

	@Autowired
	private ManagerAccountMapper managerAccountMapper; 
	
	@Autowired
	private IManagerRoleService managerRoleService;

	@Autowired
	private OrganizationAccountMapper organizationAccountMapper;

	@Autowired
	private OrganizationMapper organizationMapper;

	@Autowired
	private IManagerAccountRoleService iManagerAccountRoleService;

	@Autowired
	private IManagerRoleResourceService managerRoleResourceService;

	@Override
	public ManagerAccountEntity findByLoginName(String loginName) {
		log.debug("login name:{}", loginName);

		LambdaQueryWrapper<ManagerAccountEntity> wrapper = new LambdaQueryWrapper<>() ;
		wrapper.eq(ManagerAccountEntity::getLoginName , loginName);

		ManagerAccountEntity account = getOne(wrapper);

		Assert.notNull(account, "账号【" + loginName + "】查询为空.");

		if (!RolePowerTypeEnmus.ROLE_ADMIN.value.equals(account.getRolePower())) {
			account.setPermission(this.findPermissions(account));
			account.setRole(this.findRoles(account));
		}

		return account;

	}

	@Override
	public ManagerAccountDto registAccount(String loginName, String password, String phone) {

		Assert.hasLength(loginName , "注册登陆名为空");
		Assert.hasLength(password , "注册登陆密码为空");
		Assert.hasLength(phone , "注册手机号为空");

		loginName = StringUtils.hasLength(loginName)?loginName:phone ;

		LambdaQueryWrapper<ManagerAccountEntity> wrapper = new LambdaQueryWrapper<>() ;
		wrapper.eq(ManagerAccountEntity::getLoginName, loginName) ;
		long count = count(wrapper) ;
		Assert.isTrue(count == 0 , "登陆名已存在.");

		wrapper = new LambdaQueryWrapper<>() ;
		wrapper.eq(ManagerAccountEntity::getPhone , phone) ;
		count = count(wrapper) ;
		Assert.isTrue(count == 0 , "手机号已存在.");

		ManagerAccountEntity account = new ManagerAccountEntity() ;
		account.setLoginName(StringUtils.hasLength(loginName)?loginName:phone);
		account.setPassword(BCrypt.hashpw(password));
		account.setPhone(phone);
		account.setName(genDefaultName(phone));

		this.save(account);

		wrapper = new LambdaQueryWrapper<>() ;
		wrapper.eq(ManagerAccountEntity::getLoginName, loginName) ;
		ManagerAccountEntity entity = getOne(wrapper) ;

		ManagerAccountDto dto = new ManagerAccountDto() ;
		BeanUtils.copyProperties(entity , dto);

		return dto ;
	}

	/**
	 * 生成默认的用户名称
	 * @param phone
	 * @return
	 */
	private String genDefaultName(String phone) {
		// 提取手机号码的前三位
		String prefix = phone.substring(0, 3);

		// 使用随机数生成后四位
		Random random = new Random();
		String suffix = String.valueOf(random.nextInt(1000));

		// 拼接昵称
		return prefix + "***" + suffix;
	}

	@Override
	public boolean isAdmin(ManagerAccountEntity dto) { 
		return RolePowerTypeEnmus.ROLE_ADMIN.value.equals(dto.getRolePower());
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

		return permission;
	}

	@Override
	public void updateAvator(String path, String id) {
		ManagerAccountEntity e = findEntityById(id);
		e.setAvatarPath(path);

		this.update(e);
	}

	@Override
	public boolean checkEmailUnique(String email, String accountId) {

		return true;
	}

	@Override
	public boolean checkPhoneUnique(String phone, String accountId) {
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
		log.info("用户信息{}:" , entity);

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
		return !byLoginName.isEmpty();
	}

	@Override
	public void registerAccountAuthRole(ManagerAccountEntity e, List<Long> authRole, String applicationName) {

		// 保存用户信息
		this.save(e);

		if (authRole != null) {
			// 用户授权
			iManagerAccountRoleService.authorizeUsers(authRole, e.getId(), applicationName);
		}
	}

	@Override
	public ManagerAccountDto loginAccount(String username, String password) {

		LambdaQueryWrapper<ManagerAccountEntity> wrapper = new LambdaQueryWrapper<>() ;
		wrapper.eq(ManagerAccountEntity::getLoginName , username) ;
		ManagerAccountEntity entity = getOne(wrapper) ;

		Assert.notNull(entity , username + "用户查询为空");

		boolean checkpw = BCrypt.checkpw(password, entity.getPassword());
		log.debug("checkpw = {}" , checkpw);

		Assert.isTrue(checkpw , "登陆密码不正确");

		ManagerAccountDto dto = new ManagerAccountDto() ;
		BeanUtils.copyProperties(entity , dto);

		return dto ;
	}

	@Override
	public void checkUserAllowed(ManagerAccountEntity user) {
		if (StringUtils.hasLength(user.getUserId()) && user.getRolePower().equals(RolePowerTypeEnmus.ROLE_ADMIN.getValue()) ) {
			throw new ServiceException("不允许操作超级管理员用户");
		}
	}

	@Override
	public void checkUserDataScope(String accountId) {
//		if (!SysUser.isAdmin(SecurityUtils.getUserId())) {
//			SysUser user = new SysUser();
//			user.setUserId(accountId);
//			List<SysUser> users = SpringUtils.getAopProxy(this).selectUserList(user);
//			if (StringUtils.isEmpty(users))
//			{
//				throw new ServiceException("没有权限访问用户数据！");
//			}
//		}
	}

	@Override
	public int updateUserStatus(ManagerAccountEntity user) {

//		// 删除用户与角色关联
//		userRoleMapper.deleteUserRoleByUserId(accountId);
//		// 新增用户与角色管理
//		insertUserRole(user);
//		// 删除用户与岗位关联
//		userPostMapper.deleteUserPostByUserId(accountId);
//		// 新增用户与岗位管理
//		insertUserPost(user);

		LambdaUpdateWrapper<ManagerAccountEntity> updateWrapper = new LambdaUpdateWrapper<>();
		updateWrapper.eq(ManagerAccountEntity::getId, user.getId());

		return mapper.update(user, updateWrapper);
	}

	@Override
	public boolean resetPassword(String id, String newPassword, String oldPassword) {
		return false;
	}

	@Override
	public void resetPassword(String id, String newPassword, boolean isEncode) {

	}
}
