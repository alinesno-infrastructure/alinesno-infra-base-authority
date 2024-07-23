package com.alinesno.infra.base.authority.initialize;

import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.digest.BCrypt;
import com.alinesno.infra.base.authority.constants.AuthorityConstants;
import com.alinesno.infra.base.authority.entity.*;
import com.alinesno.infra.base.authority.enums.AccountOrganizationType;
import com.alinesno.infra.base.authority.enums.RolePowerTypeEnmus;
import com.alinesno.infra.base.authority.enums.SystemInnerEnums;
import com.alinesno.infra.base.authority.service.IManagerAccountService;
import com.alinesno.infra.base.authority.service.IManagerProjectService;
import com.alinesno.infra.base.authority.service.IManagerResourceService;
import com.alinesno.infra.base.authority.service.IOrganizationService;
import com.alinesno.infra.base.authority.utils.ManagerResourceUtils;
import com.alinesno.infra.common.core.context.SpringContext;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * AuthorityInitServiceImpl 类是实现了 IAuthorityInitService 接口的权限初始化服务类。它负责初始化权限相关的数据。
 * 
 * @author luoxiaodong
 * @version 1.0.0
 */
@Slf4j
@Component
public class AuthorityInitServiceImpl implements IAuthorityInitService {

	@Autowired
	private IManagerProjectService managerProjectService;

	@Autowired
	private IManagerAccountService accountService;

	@Autowired
	private IOrganizationService orgService;
	
	@Override
	public void initData(Long accountId , OrganizationEntity org) {
		LambdaQueryWrapper<ManagerProjectEntity> wrapper = new LambdaQueryWrapper<>() ;
		wrapper.eq(ManagerProjectEntity::getProjectCode, AuthorityConstants.BASE_AUTHORITY_PROJECT_CODE) ;

		long count = managerProjectService.count(wrapper) ;

		if(count == 0) {  // 应用为空
			ManagerProjectEntity e = new ManagerProjectEntity();

			String defaultIcon = "fa-solid fa-file-shield";

			e.setProjectIcons(defaultIcon);
			e.setProjectCode(AuthorityConstants.BASE_AUTHORITY_PROJECT_CODE);

			e.setProjectName("授权管理引擎服务");
			e.setProjectDesc("用于授权管理引擎配置管理，统一权限菜单的管理配置等");
			e.setFieldProp("default");
			e.setSystemInner(SystemInnerEnums.YES.getCode());

			e.setOrgId(org.getId());

			managerProjectService.save(e);

			// 初始化应用菜单列表
			List<ManagerResourceEntity> es = ManagerResourceUtils.genBaseAuthorityResources() ;
			SpringContext.getBean(IManagerResourceService.class).saveBatch(es);
		}
	}

	// 整个平台有且只有一个超级管理员账号
	@Override
	public ManagerAccountEntity initSuperManager(OrganizationEntity org) {

		LambdaQueryWrapper<ManagerAccountEntity> wrapper = new LambdaQueryWrapper<>() ;
		wrapper.eq(ManagerAccountEntity::getRolePower, RolePowerTypeEnmus.ROLE_ADMIN.value) ;

		List<ManagerAccountEntity> count = accountService.list(wrapper) ;

		ManagerAccountEntity account = new ManagerAccountEntity();
		if(count.isEmpty()) {  // 超级管理员账号为空

			account.setName("AIP超级管理员");

			account.setPhone("12345678901");
			account.setLoginName("aipmanager@linesno.com");
			account.setEmail("aipmanager@linesno.com");

			account.setPassword(BCrypt.hashpw("admin")) ;
			account.setSex("1");
			account.setAccountStatus(1);

			account.setRolePower(RolePowerTypeEnmus.ROLE_ADMIN.value);
			account.setOrgId(org.getId());

			// 添加账户与组织关系
			accountService.save(account);

			OrganizationAccountEntity orgAccount = new OrganizationAccountEntity();
			orgAccount.setAccountId(account.getId());
			orgAccount.setOrgId(org.getId());
			orgAccount.setOrgType(AccountOrganizationType.ADMINISTRATOR.getType());  // 设置成管理员

			orgService.saveOrganizationAccount(orgAccount);

		}else{
			account = count.get(0);
		}

		return account ;
	}

	@Override
	public OrganizationEntity initOrganization() {

		LambdaQueryWrapper<OrganizationEntity> queryWrapper = new LambdaQueryWrapper<>() ;
		queryWrapper.eq(OrganizationEntity::getOrganizationId, AuthorityConstants.BASE_AUTHORITY_ORGANIZATION_CODE) ;

		long count = orgService.count(queryWrapper) ;
		if(count == 0){
			OrganizationEntity org = new OrganizationEntity() ;

			org.setOrgName("AIP智能体平台管理组");
			org.setRemark("用于AIP智能体平台的管理配置");
			org.setOrgPhone("12345678901");
			org.setLogoUrl("http://portal.infra.linesno.com/logo.png");

			org.setOrganizationId(AuthorityConstants.BASE_AUTHORITY_ORGANIZATION_CODE);
			org.setDoorplateNumber(IdUtil.nanoId(8));
			org.setSystemInner(SystemInnerEnums.YES.getCode());

			orgService.save(org);

			return org ;
		}else{
			return orgService.getOne(queryWrapper) ;
		}

	}

	@Override
	public void initManagerCode(OrganizationEntity org) {

	}

	@Override
	public void initManagerConfig(OrganizationEntity org) {

	}

}
