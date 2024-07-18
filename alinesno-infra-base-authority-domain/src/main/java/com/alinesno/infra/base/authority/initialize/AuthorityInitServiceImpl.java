package com.alinesno.infra.base.authority.initialize;

import com.alinesno.infra.base.authority.constants.AuthorityConstants;
import com.alinesno.infra.base.authority.entity.ManagerAccountEntity;
import com.alinesno.infra.base.authority.entity.ManagerProjectEntity;
import com.alinesno.infra.base.authority.entity.ManagerResourceEntity;
import com.alinesno.infra.base.authority.enums.RolePowerTypeEnmus;
import com.alinesno.infra.base.authority.enums.SystemInnerEnums;
import com.alinesno.infra.base.authority.service.IManagerAccountService;
import com.alinesno.infra.base.authority.service.IManagerProjectService;
import com.alinesno.infra.base.authority.service.IManagerResourceService;
import com.alinesno.infra.base.authority.utils.ManagerResourceUtils;
import com.alinesno.infra.common.core.context.SpringContext;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	@Override
	public void initData(Long accountId) {
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

			managerProjectService.save(e);

			// 初始化应用菜单列表
			List<ManagerResourceEntity> es = ManagerResourceUtils.genBaseAuthorityResources() ;
			SpringContext.getBean(IManagerResourceService.class).saveBatch(es);
		}
	}

	// 整个平台有且只有一个超级管理员账号
	@Override
	public ManagerAccountEntity initSuperManager() {

		LambdaQueryWrapper<ManagerAccountEntity> wrapper = new LambdaQueryWrapper<>() ;
		wrapper.eq(ManagerAccountEntity::getRolePower, RolePowerTypeEnmus.ROLE_ADMIN.value) ;

		List<ManagerAccountEntity> count = accountService.list(wrapper) ;

		ManagerAccountEntity account = new ManagerAccountEntity();
		if(count.isEmpty()) {  // 超级管理员账号为空

			account.setName("AIP超级管理员");

			account.setPhone("12345678901");
			account.setLoginName("aipmanager@linesno.com");
			account.setEmail("aipmanager@linesno.com");

			account.setPassword("123456");
			account.setSex("1");
			account.setAccountStatus(1);

			account.setRolePower(RolePowerTypeEnmus.ROLE_ADMIN.value);

			accountService.save(account);
		}else{
			account = count.get(0);
		}

		return account ;
	}

}
