package com.alinesno.infra.base.authority.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.BCrypt;
import com.alinesno.infra.base.authority.constants.AuthConstants;
import com.alinesno.infra.base.authority.entity.ManagerAccountAvatarEntity;
import com.alinesno.infra.base.authority.entity.ManagerAccountEntity;
import com.alinesno.infra.base.authority.entity.OrganizationAccountEntity;
import com.alinesno.infra.base.authority.entity.OrganizationEntity;
import com.alinesno.infra.base.authority.enums.AccountOrganizationType;
import com.alinesno.infra.base.authority.enums.RolePowerTypeEnmus;
import com.alinesno.infra.base.authority.gateway.dto.AuthManagerAccountDto;
import com.alinesno.infra.base.authority.mapper.ManagerAccountAvatarMapper;
import com.alinesno.infra.base.authority.mapper.ManagerAccountMapper;
import com.alinesno.infra.base.authority.mapper.OrganizationAccountMapper;
import com.alinesno.infra.base.authority.service.*;
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

import java.security.SecureRandom;
import java.util.*;

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
	private ManagerAccountAvatarMapper managerAccountAvatarMapper;

	@Autowired
	private IManagerRoleService managerRoleService;

	@Autowired
	private OrganizationAccountMapper organizationAccountMapper;

	@Autowired
	private IOrganizationService organizationService;

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
	public AuthManagerAccountDto registAccount(String loginName, String password, String phone) {

		Assert.hasLength(loginName , "注册登陆名为空");
		Assert.hasLength(password , "注册登陆密码为空");
		Assert.hasLength(phone , "注册手机号为空");

		loginName = StringUtils.hasLength(loginName)?loginName:phone ;

		LambdaQueryWrapper<ManagerAccountEntity> wrapper = new LambdaQueryWrapper<>() ;
		wrapper.eq(ManagerAccountEntity::getLoginName, loginName) ;
		long count = count(wrapper) ;
		Assert.isTrue(count == 0 , "登陆名["+phone+"]已存在.");

		LambdaQueryWrapper<ManagerAccountEntity> phoneWrapper = new LambdaQueryWrapper<>() ;
		phoneWrapper.eq(ManagerAccountEntity::getPhone , phone) ;
		long phoneCount = count(phoneWrapper) ;
		Assert.isTrue(phoneCount == 0 , "手机号["+phone+"]已存在.");

		ManagerAccountEntity account = new ManagerAccountEntity() ;
		account.setLoginName(StringUtils.hasLength(loginName)?loginName:phone);
		account.setPassword(BCrypt.hashpw(password));
		account.setPhone(phone);
		account.setName(genDefaultName());
		account.setAvatarPath("");

		this.save(account);

		wrapper = new LambdaQueryWrapper<>() ;
		wrapper.eq(ManagerAccountEntity::getLoginName, loginName) ;
		ManagerAccountEntity entity = getOne(wrapper) ;

		AuthManagerAccountDto dto = new AuthManagerAccountDto() ;
		BeanUtils.copyProperties(entity , dto);

		return dto ;
	}

	/**
	 * 生成默认的用户名称
	 * @return
	 */
	private String genDefaultName() {

//		// 提取手机号码的前三位
//		String prefix = phone.substring(0, 3);
//
//		// 使用随机数生成后四位
//		Random random = new Random();
//		String suffix = String.valueOf(random.nextInt(1000));
//
//		// 拼接昵称
//		return prefix + "***" + suffix;

		String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		int NAME_LENGTH = 8;
		SecureRandom RANDOM = new SecureRandom();

		StringBuilder sb = new StringBuilder(NAME_LENGTH);
		for (int i = 0; i < NAME_LENGTH; i++) {
			int randomIndex = RANDOM.nextInt(CHARACTERS.length());
			sb.append(CHARACTERS.charAt(randomIndex));
		}

		return sb.toString();
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
//		RpcWrapper<ManagerAccountEntity> nameWrapper = RpcWrapper.build();
//		nameWrapper.eq("login_name", LoginName);
//		List<ManagerAccountEntity> byLoginName = this.findAll(nameWrapper);
//		return !byLoginName.isEmpty();

		LambdaQueryWrapper<ManagerAccountEntity> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(ManagerAccountEntity::getLoginName, LoginName);
		return count(wrapper) > 0;
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
	public AuthManagerAccountDto loginAccount(String username, String password) {

		LambdaQueryWrapper<ManagerAccountEntity> wrapper = new LambdaQueryWrapper<>() ;
		wrapper.eq(ManagerAccountEntity::getLoginName , username) ;
		ManagerAccountEntity entity = getOne(wrapper) ;

		Assert.notNull(entity , username + "用户查询为空");

		boolean checkpw = BCrypt.checkpw(password, entity.getPassword());
		log.debug("checkpw = {}" , checkpw);

		Assert.isTrue(checkpw , "登陆密码不正确");

		AuthManagerAccountDto dto = new AuthManagerAccountDto() ;
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

		LambdaUpdateWrapper<ManagerAccountEntity> updateWrapper = new LambdaUpdateWrapper<>();
		updateWrapper.eq(ManagerAccountEntity::getId, user.getId());

		return mapper.update(user, updateWrapper);
	}

	@Override
	public Map<String, Object> getAccountInfo(long accountId) {

        ManagerAccountEntity accountEntity = getById(accountId) ;
		OrganizationAccountEntity orgAccount = organizationService.getByAccountId(accountId) ;

		// 头像信息
		LambdaQueryWrapper<ManagerAccountAvatarEntity> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(ManagerAccountAvatarEntity::getAccountId , accountId);
		ManagerAccountAvatarEntity avatar = managerAccountAvatarMapper.selectOne(wrapper);
		if(avatar != null){
			accountEntity.setAvatarPath(avatar.getAvatarBase64());
		}else{
			accountEntity.setAvatarPath(AuthConstants.defaultBase64Icon) ;
		}

		Map<String, Object> data = new HashMap<>();

		Map<String, Object> user = new HashMap<>();
		user.put("userId", accountId);
		user.put("deptId", accountEntity.getDepartment());
		user.put("userName", accountEntity.getLoginName());
		user.put("nickName", accountEntity.getName());
		user.put("email", accountEntity.getEmail());
		user.put("phoneNumber", accountEntity.getPhone());
		user.put("sex", accountEntity.getSex());
		user.put("avatar", accountEntity.getAvatarPath());

		// --->>>>>>>>>> 组织
		if(orgAccount != null){

			OrganizationEntity organizationDto =  orgAccount.getOrganizationEntity() ;

			Map<String, Object> org = new HashMap<>();
			org.put("orgId", organizationDto.getId());
			org.put("orgName", organizationDto.getOrgName());
			org.put("roleType", orgAccount.getOrgType());
			org.put("roleName", AccountOrganizationType.fromType(orgAccount.getOrgType()).getName());
			user.put("org", org);
		}

		// --->>>>>>>>>> 部门
		Map<String, Object> dept = new HashMap<>();
		dept.put("deptId", 103);
		dept.put("parentId", 101);
		dept.put("ancestors", "0,100,101");
		dept.put("deptName", "研发部门");
		dept.put("orderNum", 1);
		dept.put("leader", "AIP技术团队");
		dept.put("phone", null);
		dept.put("email", null);
		dept.put("status", "0");
		dept.put("delFlag", null);
		dept.put("parentName", null);
		dept.put("children", new Object[]{});

		user.put("dept", dept);

		Map<String, Object> role = new HashMap<>();
		role.put("remark", null);
		role.put("roleId", 1);
		role.put("roleName", "超级管理员");
		role.put("roleKey", "admin");
		role.put("roleSort", 1);
		role.put("dataScope", "1");
		role.put("menuCheckStrictly", false);
		role.put("deptCheckStrictly", false);
		role.put("status", "0");
		role.put("delFlag", null);
		role.put("flag", false);
		role.put("menuIds", null);
		role.put("deptIds", null);
		role.put("permissions", null);
		role.put("admin", true);

		// 数据返回
		data.put("user", user) ;
		data.put("roles", new Object[]{role});
		data.put("permissions", new String[]{"*:*:*"});

		return data;
	}

	@Override
	public AuthManagerAccountDto getManagerAccountDto(long id) {

		ManagerAccountEntity e = getById(id);

		AuthManagerAccountDto dto = new AuthManagerAccountDto();
		BeanUtils.copyProperties(e, dto);

		// 头像信息
		LambdaQueryWrapper<ManagerAccountAvatarEntity> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(ManagerAccountAvatarEntity::getAccountId , id);
		ManagerAccountAvatarEntity avatar = managerAccountAvatarMapper.selectOne(wrapper);
		if(avatar != null){
			dto.setAvatarPath(avatar.getAvatarBase64());
		}else{
			dto.setAvatarPath(AuthConstants.defaultBase64Icon) ;
		}

		// 设置组织信息
		OrganizationAccountEntity org = organizationService.getByAccountId(id) ;
		if(org != null){
			dto.setOrgId(org.getOrgId());
			dto.setOrgType(org.getOrgType());
		}

		dto.setPassword(null);
		return dto;
	}

	@Override
	public AuthManagerAccountDto findByLoginNameWithRegister(String loginName, String password , String loginType) {

		AuthManagerAccountDto dto;

		if (!checkLoginName(loginName)) {  // 如果用户不存在，则自动注册

			if("sms".equals(loginType)){ // 手机注册则动态生成6位随机密码
				password = RandomUtil.randomNumbers(6) ;
			}

			dto =  this.registAccount(loginName, password, loginName) ;
		}else{  // 如果存在则直接查询返回
			ManagerAccountEntity e = findByLoginName(loginName);
			dto = new AuthManagerAccountDto() ;
			BeanUtils.copyProperties(e, dto);
		}

		// dto.setPassword(null);

		return dto ;
	}

	@Override
	public void updateAccount(AuthManagerAccountDto dto) {

		ManagerAccountEntity e = new ManagerAccountEntity() ;
		BeanUtils.copyProperties(dto, e , new String[]{
				"password",
				"addTime",
				"avatarPath"
		});
		updateById(e);

	}

	@Override
	public void updateAvatarBase64(String base64Encoded, long userId) {

		// 删除之前的头像
		managerAccountAvatarMapper.delete(new LambdaUpdateWrapper<ManagerAccountAvatarEntity>()
				.eq(ManagerAccountAvatarEntity::getAccountId, userId));

		// 添加新的头像
		ManagerAccountAvatarEntity avatarEntity = new ManagerAccountAvatarEntity() ;
		avatarEntity.setAccountId(userId);
		avatarEntity.setAvatarBase64(base64Encoded);

		managerAccountAvatarMapper.insert(avatarEntity) ;
	}

	@Override
	public boolean isPhoneExists(String phone) {
		if (StringUtils.hasLength(phone)) {
			LambdaQueryWrapper<ManagerAccountEntity> wrapper = new LambdaQueryWrapper<>();
			wrapper.eq(ManagerAccountEntity::getPhone, phone);
			return managerAccountMapper.exists(wrapper);
		}
		return false;
	}

	@Override
	public String resetUserPwd(Long userId) {

		ManagerAccountEntity account = getById(userId);

		String newPassword = IdUtil.nanoId(8);
		account.setPassword(BCrypt.hashpw(newPassword));
		account.setPasswordStatus(1);  // 系统重置的密码(用户登陆之后，需要提示更新)

		updateById(account);

		return newPassword;
	}

	@Override
	public boolean hasAvatar(Long id) {
		LambdaQueryWrapper<ManagerAccountAvatarEntity> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(ManagerAccountAvatarEntity::getAccountId, id);
		return managerAccountAvatarMapper.exists(wrapper);
	}

	@Override
	public boolean resetPassword(String id, String newPassword, String oldPassword) {
		return false;
	}

	@Override
	public void resetPassword(String id, String newPassword, boolean isEncode) {

	}
}
