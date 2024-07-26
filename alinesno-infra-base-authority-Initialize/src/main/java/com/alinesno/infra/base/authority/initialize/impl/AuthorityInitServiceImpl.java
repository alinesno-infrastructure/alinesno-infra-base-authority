package com.alinesno.infra.base.authority.initialize.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.digest.BCrypt;
import com.alinesno.infra.base.authority.constants.AuthorityConstants;
import com.alinesno.infra.base.authority.entity.*;
import com.alinesno.infra.base.authority.enums.*;
import com.alinesno.infra.base.authority.initialize.IAuthorityInitService;
import com.alinesno.infra.base.authority.sample.bean.MenuBean;
import com.alinesno.infra.base.authority.service.*;
import com.alinesno.infra.common.core.context.SpringContext;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * AuthorityInitServiceImpl 类是实现了 IAuthorityInitService 接口的权限初始化服务类。它负责初始化权限相关的数据。
 * 
 * @author luoxiaodong
 * @version 1.0.0
 */
@Slf4j
@Component
public class AuthorityInitServiceImpl implements IAuthorityInitService {

	private final IManagerProjectService managerProjectService;

	private final IManagerAccountService accountService;

	private final IManagerDepartmentService managerDepartmentMapper ;

	private final IManagerRoleService modelRoleMapper;

	private final IManagerSettingsService settingsService ;

	private final IManagerCodeTypeService codeTypeService ;

	private final IManagerCodeService codeService; ;

	private final IOrganizationService orgService;

	public AuthorityInitServiceImpl(@Lazy IManagerProjectService managerProjectService,
									@Lazy IManagerAccountService accountService,
									@Lazy IManagerDepartmentService managerDepartmentMapper,
									@Lazy IManagerRoleService modelRoleMapper,
									@Lazy IManagerSettingsService settingsService,
									@Lazy IManagerCodeTypeService codeTypeService,
									@Lazy IManagerCodeService codeService,
									@Lazy IOrganizationService orgService) {
		this.managerProjectService = managerProjectService;
		this.accountService = accountService;
		this.managerDepartmentMapper = managerDepartmentMapper;
		this.modelRoleMapper = modelRoleMapper;
		this.settingsService = settingsService;
		this.codeTypeService = codeTypeService;
		this.codeService = codeService;
		this.orgService = orgService;
	}


	@Override
	public ManagerProjectEntity initData(Long accountId , OrganizationEntity org) {
		LambdaQueryWrapper<ManagerProjectEntity> wrapper = new LambdaQueryWrapper<>() ;
		wrapper.eq(ManagerProjectEntity::getProjectCode, AuthorityConstants.BASE_AUTHORITY_PROJECT_CODE) ;

		ManagerProjectEntity e = managerProjectService.getOne(wrapper) ;

		if(e == null) {  // 应用为空
			e = new ManagerProjectEntity();

			String defaultIcon = "fa-solid fa-file-shield";

			e.setId(1L);
			e.setProjectIcons(defaultIcon);
			e.setProjectCode(AuthorityConstants.BASE_AUTHORITY_PROJECT_CODE);

			e.setProjectName("授权管理引擎服务");
			e.setProjectDesc("用于授权管理引擎配置管理，统一权限菜单的管理配置等，AIP平台基础配置管理服务");
			e.setFieldProp("default");
			e.setSystemInner(SystemInnerEnums.YES.getCode());

			e.setOrgId(org.getId());

			managerProjectService.saveOrUpdate(e);

			// 初始化应用菜单列表
			List<ManagerResourceEntity> es = genBaseAuthorityResources(org , e) ;
			SpringContext.getBean(IManagerResourceService.class).saveBatch(es);
		}

		return e ;
	}

	/**
	 * 生成系统菜单列表
	 * @return
	 */
	public static List<ManagerResourceEntity> genBaseAuthorityResources(OrganizationEntity org, ManagerProjectEntity project) {

		MenuBean dashboardMenu = new MenuBean("Dashboard", "/dashboard", false, "noRedirect", "Layout", true, new MenuBean.Meta("仪盘表", "dashboard", false, null), List.of(
				new MenuBean("Dashboard", "index", false, false , "dashboard", new MenuBean.Meta("概览", "dashboard", false, null)) ,
				new MenuBean("Project", "project/index", false, false , "project", new MenuBean.Meta("项目管理", "monitor", false, null),List.of(
						new MenuBean("system:project:query", new MenuBean.Meta("查询", "logininfor", false, null)),
						new MenuBean("system:project:add", new MenuBean.Meta("新增", "logininfor", false, null)),
						new MenuBean("system:project:edit", new MenuBean.Meta("修改", "logininfor", false, null)),
						new MenuBean("system:project:export", new MenuBean.Meta("导出", "logininfor", false, null)),
						new MenuBean("system:project:import", new MenuBean.Meta("导入", "logininfor", false, null)),
						new MenuBean("system:project:remove", new MenuBean.Meta("删除", "logininfor", false, null))
				))
		));

		MenuBean systemMenu = new MenuBean("System", "/system", false, "noRedirect", "Layout", true, new MenuBean.Meta("权限配置", "post", false, null),
				List.of(
						new MenuBean("Dept", "system/dept/index", false,false,  "system/dept/index", new MenuBean.Meta("部门管理", "tree", false, null),List.of(
								new MenuBean("system:dept:query", new MenuBean.Meta("查询", "logininfor", false, null)),
								new MenuBean("system:dept:add", new MenuBean.Meta("新增", "logininfor", false, null)),
								new MenuBean("system:dept:edit", new MenuBean.Meta("修改", "logininfor", false, null)),
								new MenuBean("system:dept:export", new MenuBean.Meta("导出", "logininfor", false, null)),
								new MenuBean("system:dept:import", new MenuBean.Meta("导入", "logininfor", false, null)),
								new MenuBean("system:dept:remove", new MenuBean.Meta("删除", "logininfor", false, null))
						)),
						new MenuBean("Post", "system/post/index", false, false, "system/post/index", new MenuBean.Meta("岗位管理", "post", false, null),List.of(
								new MenuBean("system:post:query", new MenuBean.Meta("查询", "logininfor", false, null)),
								new MenuBean("system:post:add", new MenuBean.Meta("新增", "logininfor", false, null)),
								new MenuBean("system:post:edit", new MenuBean.Meta("修改", "logininfor", false, null)),
								new MenuBean("system:post:export", new MenuBean.Meta("导出", "logininfor", false, null)),
								new MenuBean("system:post:import", new MenuBean.Meta("导入", "logininfor", false, null)),
								new MenuBean("system:post:remove", new MenuBean.Meta("删除", "logininfor", false, null))
						)),
						new MenuBean("Role", "system/role/index", false, false, "system/role/index", new MenuBean.Meta("角色管理", "peoples", false, null),List.of(
								new MenuBean("system:role:query", new MenuBean.Meta("查询", "logininfor", false, null)),
								new MenuBean("system:role:add", new MenuBean.Meta("新增", "logininfor", false, null)),
								new MenuBean("system:role:edit", new MenuBean.Meta("修改", "logininfor", false, null)),
								new MenuBean("system:role:export", new MenuBean.Meta("导出", "logininfor", false, null)),
								new MenuBean("system:role:import", new MenuBean.Meta("导入", "logininfor", false, null)),
								new MenuBean("system:role:remove", new MenuBean.Meta("删除", "logininfor", false, null))
						)),
						new MenuBean("Dict", "system/dict/index", false,false,  "system/dict/index", new MenuBean.Meta("字典管理", "dict", false, null),List.of(
								new MenuBean("system:dict:query", new MenuBean.Meta("查询", "logininfor", false, null)),
								new MenuBean("system:dict:add", new MenuBean.Meta("新增", "logininfor", false, null)),
								new MenuBean("system:dict:edit", new MenuBean.Meta("修改", "logininfor", false, null)),
								new MenuBean("system:dict:export", new MenuBean.Meta("导出", "logininfor", false, null)),
								new MenuBean("system:dict:import", new MenuBean.Meta("导入", "logininfor", false, null)),
								new MenuBean("system:dict:remove", new MenuBean.Meta("删除", "logininfor", false, null))
						)),
						new MenuBean("Config", "system/config/index", false,false,  "system/config/index", new MenuBean.Meta("参数设置", "edit", false, null),List.of(
								new MenuBean("system:config:query", new MenuBean.Meta("查询", "logininfor", false, null)),
								new MenuBean("system:config:add", new MenuBean.Meta("新增", "logininfor", false, null)),
								new MenuBean("system:config:edit", new MenuBean.Meta("修改", "logininfor", false, null)),
								new MenuBean("system:config:export", new MenuBean.Meta("导出", "logininfor", false, null)),
								new MenuBean("system:config:import", new MenuBean.Meta("导入", "logininfor", false, null)),
								new MenuBean("system:config:remove", new MenuBean.Meta("删除", "logininfor", false, null))
						)),
						new MenuBean("Notice", "system/notice/index", false,false,  "system/notice/index", new MenuBean.Meta("通知公告", "message", false, null),List.of(
								new MenuBean("system:notice:query", new MenuBean.Meta("查询", "logininfor", false, null)),
								new MenuBean("system:notice:add", new MenuBean.Meta("新增", "logininfor", false, null)),
								new MenuBean("system:notice:edit", new MenuBean.Meta("修改", "logininfor", false, null)),
								new MenuBean("system:notice:export", new MenuBean.Meta("导出", "logininfor", false, null)),
								new MenuBean("system:notice:import", new MenuBean.Meta("导入", "logininfor", false, null)),
								new MenuBean("system:notice:remove", new MenuBean.Meta("删除", "logininfor", false, null))
						))
				));

		MenuBean loggerMenu = new MenuBean("Log", "/log", false, "noRedirect", "Layout", true, new MenuBean.Meta("日志管理", "log", false, null),
				List.of(
						new MenuBean("Operlog", "monitor/operlog/index", false,false, "log/operlog/index", new MenuBean.Meta("操作日志", "message", false, null),List.of(
								new MenuBean("system:operlog:query", new MenuBean.Meta("查询", "logininfor", false, null)),
								new MenuBean("system:operlog:add", new MenuBean.Meta("新增", "logininfor", false, null)),
								new MenuBean("system:operlog:edit", new MenuBean.Meta("修改", "logininfor", false, null)),
								new MenuBean("system:operlog:export", new MenuBean.Meta("导出", "logininfor", false, null)),
								new MenuBean("system:operlog:import", new MenuBean.Meta("导入", "logininfor", false, null)),
								new MenuBean("system:operlog:remove", new MenuBean.Meta("删除", "logininfor", false, null))
						)),
						new MenuBean("Apilog", "monitor/apilog/index", false,false, "log/apilog/index", new MenuBean.Meta("接口日志", "form", false, null),List.of(
								new MenuBean("system:apilog:query", new MenuBean.Meta("查询", "logininfor", false, null)),
								new MenuBean("system:apilog:add", new MenuBean.Meta("新增", "logininfor", false, null)),
								new MenuBean("system:apilog:edit", new MenuBean.Meta("修改", "logininfor", false, null)),
								new MenuBean("system:apilog:export", new MenuBean.Meta("导出", "logininfor", false, null)),
								new MenuBean("system:apilog:import", new MenuBean.Meta("导入", "logininfor", false, null)),
								new MenuBean("system:apilog:remove", new MenuBean.Meta("删除", "logininfor", false, null))
						)),
						new MenuBean("Logininfor", "monitor/logininfor/index", false,false, "log/logininfor/index", new MenuBean.Meta("登录日志", "logininfor", false, null),List.of(
								new MenuBean("system:logininfor:query", new MenuBean.Meta("查询", "logininfor", false, null)),
								new MenuBean("system:logininfor:add", new MenuBean.Meta("新增", "logininfor", false, null)),
								new MenuBean("system:logininfor:edit", new MenuBean.Meta("修改", "logininfor", false, null)),
								new MenuBean("system:logininfor:export", new MenuBean.Meta("导出", "logininfor", false, null)),
								new MenuBean("system:logininfor:import", new MenuBean.Meta("导入", "logininfor", false, null)),
								new MenuBean("system:logininfor:remove", new MenuBean.Meta("删除", "logininfor", false, null))
						))
				));

		MenuBean monitorMenu = new MenuBean("Monitor", "/monitor", false, "noRedirect", "Layout", true, new MenuBean.Meta("系统监控", "monitor", false, null),
				List.of(
						new MenuBean("Online", "monitor/online/index", false,false, "monitor/online/index", new MenuBean.Meta("在线用户", "peoples", false, null),List.of(
								new MenuBean("system:online:query", new MenuBean.Meta("查询", "logininfor", false, null)),
								new MenuBean("system:online:add", new MenuBean.Meta("新增", "logininfor", false, null)),
								new MenuBean("system:online:edit", new MenuBean.Meta("修改", "logininfor", false, null)),
								new MenuBean("system:online:export", new MenuBean.Meta("导出", "logininfor", false, null)),
								new MenuBean("system:online:import", new MenuBean.Meta("导入", "logininfor", false, null)),
								new MenuBean("system:online:remove", new MenuBean.Meta("删除", "logininfor", false, null))
						)),
						new MenuBean("Server", "monitor/server/index", false,false, "monitor/server/index", new MenuBean.Meta("服务监控", "server", false, null),List.of(
								new MenuBean("system:server:query", new MenuBean.Meta("查询", "logininfor", false, null))
						)),
						new MenuBean("Cache", "monitor/cache/index", false,false, "monitor/cache/index", new MenuBean.Meta("缓存监控", "redis", false, null),List.of(
								new MenuBean("system:cache:query", new MenuBean.Meta("查询", "logininfor", false, null))
						)),
						new MenuBean("CacheList", "monitor/cache/list", false, false,"monitor/cache/list", new MenuBean.Meta("缓存列表", "redis-list", false, null),List.of(
								new MenuBean("system:cache:query", new MenuBean.Meta("查询", "logininfor", false, null)),
								new MenuBean("system:cache:add", new MenuBean.Meta("新增", "logininfor", false, null)),
								new MenuBean("system:cache:edit", new MenuBean.Meta("修改", "logininfor", false, null)),
								new MenuBean("system:cache:export", new MenuBean.Meta("导出", "logininfor", false, null)),
								new MenuBean("system:cache:import", new MenuBean.Meta("导入", "logininfor", false, null)),
								new MenuBean("system:cache:remove", new MenuBean.Meta("删除", "logininfor", false, null))
						))
				));

		MenuBean orgMenu = new MenuBean("Enterprise", "/enterprise", false, "noRedirect", "Layout", true, new MenuBean.Meta("组织管理", "tool", false, null),
				List.of(
						new MenuBean("Org", "org/index", false,false,  "org/index", new MenuBean.Meta("组织管理", "tree", false, null),List.of(
								new MenuBean("system:org:query", new MenuBean.Meta("查询", "logininfor", false, null)),
								new MenuBean("system:org:add", new MenuBean.Meta("新增", "logininfor", false, null)),
								new MenuBean("system:org:edit", new MenuBean.Meta("修改", "logininfor", false, null)),
								new MenuBean("system:org:export", new MenuBean.Meta("导出", "logininfor", false, null)),
								new MenuBean("system:org:import", new MenuBean.Meta("导入", "logininfor", false, null)),
								new MenuBean("system:org:remove", new MenuBean.Meta("删除", "logininfor", false, null))
						)),
						new MenuBean("User", "system/user/index", false,false,  "system/user/index", new MenuBean.Meta("用户管理", "user", false, null),List.of(
									new MenuBean("system:user:query", new MenuBean.Meta("查询", "logininfor", false, null)),
									new MenuBean("system:user:add", new MenuBean.Meta("新增", "logininfor", false, null)),
									new MenuBean("system:user:edit", new MenuBean.Meta("修改", "logininfor", false, null)),
									new MenuBean("system:user:export", new MenuBean.Meta("导出", "logininfor", false, null)),
									new MenuBean("system:user:import", new MenuBean.Meta("导入", "logininfor", false, null)),
									new MenuBean("system:user:resetPwd", new MenuBean.Meta("重置密码", "logininfor", false, null)),
									new MenuBean("system:user:remove", new MenuBean.Meta("删除", "logininfor", false, null))
								)),
						new MenuBean("AccountSync", "system/sync/index", false,false,  "system/sync/index", new MenuBean.Meta("账户同步", "message", false, null),List.of(
								new MenuBean("system:sync:query", new MenuBean.Meta("查询", "logininfor", false, null)),
								new MenuBean("system:sync:add", new MenuBean.Meta("新增", "logininfor", false, null)),
								new MenuBean("system:sync:edit", new MenuBean.Meta("修改", "logininfor", false, null)),
								new MenuBean("system:sync:export", new MenuBean.Meta("导出", "logininfor", false, null)),
								new MenuBean("system:sync:import", new MenuBean.Meta("导入", "logininfor", false, null)),
								new MenuBean("system:sync:remove", new MenuBean.Meta("删除", "logininfor", false, null))
						)),
						new MenuBean("Setting", "enterprise/setting/index", false,false, "enterprise/setting/index", new MenuBean.Meta("系统主题", "build", false, null),List.of(
								new MenuBean("system:setting:query", new MenuBean.Meta("查询", "logininfor", false, null)),
								new MenuBean("system:setting:add", new MenuBean.Meta("新增", "logininfor", false, null)),
								new MenuBean("system:setting:edit", new MenuBean.Meta("修改", "logininfor", false, null)),
								new MenuBean("system:setting:export", new MenuBean.Meta("导出", "logininfor", false, null)),
								new MenuBean("system:setting:import", new MenuBean.Meta("导入", "logininfor", false, null)),
								new MenuBean("system:setting:remove", new MenuBean.Meta("删除", "logininfor", false, null))
						)),
						new MenuBean("Theme", "enterprise/theme/index",false, false, "enterprise/theme/index", new MenuBean.Meta("登陆主题", "swagger", false, null),List.of(
								new MenuBean("system:theme:query", new MenuBean.Meta("查询", "logininfor", false, null)),
								new MenuBean("system:theme:add", new MenuBean.Meta("新增", "logininfor", false, null)),
								new MenuBean("system:theme:edit", new MenuBean.Meta("修改", "logininfor", false, null)),
								new MenuBean("system:theme:export", new MenuBean.Meta("导出", "logininfor", false, null)),
								new MenuBean("system:theme:import", new MenuBean.Meta("导入", "logininfor", false, null)),
								new MenuBean("system:theme:remove", new MenuBean.Meta("删除", "logininfor", false, null))
						))
				));

		List<MenuBean> menus = List.of(dashboardMenu , systemMenu, orgMenu, monitorMenu, loggerMenu);

		List<ManagerResourceEntity> es = new ArrayList<>() ;

		AtomicInteger pId = new AtomicInteger(1);
		menus.forEach(menu -> {
			System.out.println(menu.toString());

			pId.incrementAndGet();

			ManagerResourceEntity e = new ManagerResourceEntity() ;
			e.setOrgId(org.getId());

			e.setId(pId.longValue());
			e.setResourceName(menu.getMeta().getTitle());
			e.setResourceIcon(menu.getMeta().getIcon());
			e.setMenuType(MenuEnums.MENU_PACKAGE.getValue());  // 目录菜单
			e.setResourceLink(menu.getPath());
			e.setComponent(menu.getComponent());
			e.setResourceOrder(pId.get());
			e.setProjectId(project.getId());
			e.setResourceParent(project.getId());

			pId.incrementAndGet();

			es.add(e) ;

			List<MenuBean> subMenus = menu.getChildren();

			AtomicInteger pId2 = new AtomicInteger(100*pId.intValue());

			subMenus.forEach(item-> {
				System.out.println(item.toString());

				ManagerResourceEntity e2 = new ManagerResourceEntity() ;
				e2.setOrgId(org.getId());

				e2.setId(pId2.longValue()+pId.longValue());
				e2.setResourceName(item.getMeta().getTitle());
				e2.setResourceIcon(item.getMeta().getIcon());
				e2.setMenuType(MenuEnums.MENU_ITEM.getValue());  // 目录菜单
				e2.setResourceLink(item.getPath());
				e2.setComponent(item.getComponent());
				e2.setResourceOrder(pId2.get());
				e2.setProjectId(project.getId());
				e2.setResourceParent(e.getId());

				es.add(e2) ;

				pId2.incrementAndGet();

				List<MenuBean> subMenusBtn = item.getChildren();

				if(subMenusBtn != null && !subMenusBtn.isEmpty()){

					AtomicInteger pId3 = new AtomicInteger(10*pId2.intValue());
					subMenusBtn.forEach(itemBtn -> {

						ManagerResourceEntity e3 = new ManagerResourceEntity() ;

						e3.setOrgId(org.getId());
						e3.setProjectId(project.getId());
						e3.setResourceParent(e2.getId());

						e3.setId(pId3.longValue()+pId2.longValue());
						e3.setResourceName(itemBtn.getMeta().getTitle());
						e3.setPermission(itemBtn.getPerms());
						e3.setMenuType(MenuEnums.MENU_BUTTON.getValue());  // 目录菜单
						e3.setResourceOrder(pId2.get());


						es.add(e3) ;
						pId3.incrementAndGet();

					});
				}


			});
		});

		return es ;
	}

	// 整个平台有且只有一个超级管理员账号
	@Override
	public ManagerAccountEntity initSuperManager(OrganizationEntity org) {

		LambdaQueryWrapper<ManagerAccountEntity> wrapper = new LambdaQueryWrapper<>() ;
		wrapper.eq(ManagerAccountEntity::getRolePower, RolePowerTypeEnmus.ROLE_ADMIN.value) ;

		List<ManagerAccountEntity> count = accountService.list(wrapper) ;

		ManagerAccountEntity account = new ManagerAccountEntity();
		if(count.isEmpty()) {  // 超级管理员账号为空

			account.setId(1L);
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

			org.setId(1L);
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

		// 初始化公共级别系统代码
		List<ManagerCodeTypeEntity> codeTypes = new ArrayList<>();

		codeTypes.add(new ManagerCodeTypeEntity("用户性别", "sys_user_sex", "用户性别列表", DataSourceScope.COMMON_SCOPE.getValue()));
		codeTypes.add(new ManagerCodeTypeEntity("菜单状态", "sys_show_hide", "菜单状态列表", DataSourceScope.COMMON_SCOPE.getValue()));
		codeTypes.add(new ManagerCodeTypeEntity("系统开关", "sys_normal_disable", "系统开关列表", DataSourceScope.COMMON_SCOPE.getValue()));
		codeTypes.add(new ManagerCodeTypeEntity("任务状态", "sys_job_status", "任务状态列表", DataSourceScope.COMMON_SCOPE.getValue()));
		codeTypes.add(new ManagerCodeTypeEntity("任务分组", "sys_job_group", "任务分组列表", DataSourceScope.COMMON_SCOPE.getValue()));
		codeTypes.add(new ManagerCodeTypeEntity("系统是否", "sys_yes_no", "系统是否列表", DataSourceScope.COMMON_SCOPE.getValue()));
		codeTypes.add(new ManagerCodeTypeEntity("通知类型", "sys_notice_type", "通知类型列表", DataSourceScope.COMMON_SCOPE.getValue()));
		codeTypes.add(new ManagerCodeTypeEntity("通知状态", "sys_notice_status", "通知状态列表", DataSourceScope.COMMON_SCOPE.getValue()));
		codeTypes.add(new ManagerCodeTypeEntity("操作类型", "sys_oper_type", "操作类型列表", DataSourceScope.COMMON_SCOPE.getValue()));
		codeTypes.add(new ManagerCodeTypeEntity("系统状态", "sys_common_status", "登录状态列表", DataSourceScope.COMMON_SCOPE.getValue()));
		codeTypes.add(new ManagerCodeTypeEntity("数据范围", "sys_data_scope", "数据范围列表", DataSourceScope.COMMON_SCOPE.getValue()));

		AtomicLong id = new AtomicLong(450101L);

		codeTypes.forEach(s -> {
			id.getAndIncrement();

			s.setOrgId(org.getId());
			s.setId(id.get());

			s.setSystemInner(SystemInnerEnums.YES.getCode());
		});

		codeTypeService.saveOrUpdateBatch(codeTypes) ;

		List<ManagerCodeEntity> dataList = new ArrayList<>();

		// 用户性别
		dataList.add(new ManagerCodeEntity("男", "0", "sys_user_sex", 1, "性别男", DataSourceScope.COMMON_SCOPE.getValue()));
		dataList.add(new ManagerCodeEntity("女", "1", "sys_user_sex", 2, "性别女", DataSourceScope.COMMON_SCOPE.getValue()));
		dataList.add(new ManagerCodeEntity("未知", "2", "sys_user_sex", 3, "性别未知", DataSourceScope.COMMON_SCOPE.getValue()));

		// 菜单状态
		dataList.add(new ManagerCodeEntity("显示", "0", "sys_show_hide", 4, "显示菜单", DataSourceScope.COMMON_SCOPE.getValue()));
		dataList.add(new ManagerCodeEntity("隐藏", "1", "sys_show_hide", 5, "隐藏菜单", DataSourceScope.COMMON_SCOPE.getValue()));

		// 系统开关
		dataList.add(new ManagerCodeEntity("正常", "0", "sys_normal_disable", 6, "正常状态", DataSourceScope.COMMON_SCOPE.getValue()));
		dataList.add(new ManagerCodeEntity("停用", "1", "sys_normal_disable", 7, "停用状态", DataSourceScope.COMMON_SCOPE.getValue()));

		// 任务状态
		dataList.add(new ManagerCodeEntity("正常", "0", "sys_job_status", 8, "正常状态", DataSourceScope.COMMON_SCOPE.getValue()));
		dataList.add(new ManagerCodeEntity("暂停", "1", "sys_job_status", 9, "停用状态", DataSourceScope.COMMON_SCOPE.getValue()));

		// 任务分组
		dataList.add(new ManagerCodeEntity("默认", "DEFAULT", "sys_job_group", 10, "默认分组", DataSourceScope.COMMON_SCOPE.getValue()));
		dataList.add(new ManagerCodeEntity("系统", "SYSTEM", "sys_job_group", 11, "系统分组", DataSourceScope.COMMON_SCOPE.getValue()));

		// 系统是否
		dataList.add(new ManagerCodeEntity("是", "Y", "sys_yes_no", 12, "系统默认是", DataSourceScope.COMMON_SCOPE.getValue()));
		dataList.add(new ManagerCodeEntity("否", "N", "sys_yes_no", 13, "系统默认否", DataSourceScope.COMMON_SCOPE.getValue()));

		// 通知类型
		dataList.add(new ManagerCodeEntity("通知", "1", "sys_notice_type", 14, "通知", DataSourceScope.COMMON_SCOPE.getValue()));
		dataList.add(new ManagerCodeEntity("公告", "2", "sys_notice_type", 15, "公告", DataSourceScope.COMMON_SCOPE.getValue()));

		// 通知状态
		dataList.add(new ManagerCodeEntity("正常", "0", "sys_notice_status", 16, "正常状态", DataSourceScope.COMMON_SCOPE.getValue()));
		dataList.add(new ManagerCodeEntity("关闭", "1", "sys_notice_status", 17, "关闭状态", DataSourceScope.COMMON_SCOPE.getValue()));

		// 操作类型
		dataList.add(new ManagerCodeEntity("其他", "0", "sys_oper_type", 18, "其他操作", DataSourceScope.COMMON_SCOPE.getValue()));
		dataList.add(new ManagerCodeEntity("新增", "1", "sys_oper_type", 19, "新增操作", DataSourceScope.COMMON_SCOPE.getValue()));
		dataList.add(new ManagerCodeEntity("修改", "2", "sys_oper_type", 20, "修改操作", DataSourceScope.COMMON_SCOPE.getValue()));
		dataList.add(new ManagerCodeEntity("删除", "3", "sys_oper_type", 21, "删除操作", DataSourceScope.COMMON_SCOPE.getValue()));
		dataList.add(new ManagerCodeEntity("授权", "4", "sys_oper_type", 22, "授权操作", DataSourceScope.COMMON_SCOPE.getValue()));
		dataList.add(new ManagerCodeEntity("导出", "5", "sys_oper_type", 23, "导出操作", DataSourceScope.COMMON_SCOPE.getValue()));
		dataList.add(new ManagerCodeEntity("导入", "6", "sys_oper_type", 24, "导入操作", DataSourceScope.COMMON_SCOPE.getValue()));
		dataList.add(new ManagerCodeEntity("强退", "7", "sys_oper_type", 25, "强退操作", DataSourceScope.COMMON_SCOPE.getValue()));
		dataList.add(new ManagerCodeEntity("生成代码", "8", "sys_oper_type", 26, "生成操作", DataSourceScope.COMMON_SCOPE.getValue()));
		dataList.add(new ManagerCodeEntity("清空数据", "9", "sys_oper_type", 27, "清空操作", DataSourceScope.COMMON_SCOPE.getValue()));

		// 系统状态
		dataList.add(new ManagerCodeEntity("成功", "0", "sys_common_status", 28, "正常状态", DataSourceScope.COMMON_SCOPE.getValue()));
		dataList.add(new ManagerCodeEntity("失败", "1", "sys_common_status", 29, "停用状态", DataSourceScope.COMMON_SCOPE.getValue()));

		// 数据范围
		dataList.add(new ManagerCodeEntity("公共", "common", "sys_data_scope", 28, "公共范围，所有人都可以访问", DataSourceScope.COMMON_SCOPE.getValue()));
		dataList.add(new ManagerCodeEntity("组织", "org", "sys_data_scope", 29, "组织范围，仅限于特定组织内部成员", DataSourceScope.COMMON_SCOPE.getValue()));
		dataList.add(new ManagerCodeEntity("项目", "project", "sys_data_scope", 29, "项目范围，仅限于特定项目团队成", DataSourceScope.COMMON_SCOPE.getValue()));
		dataList.add(new ManagerCodeEntity("个人", "personal", "sys_data_scope", 29, "个人范围，仅限于用户本人", DataSourceScope.COMMON_SCOPE.getValue()));

		AtomicLong sort = new AtomicLong(1);
		dataList.forEach(s -> {

			sort.getAndIncrement();

			s.setOrgId(org.getId());
			s.setId(id.getAndIncrement());

			long codeTypeId =codeTypes.stream().filter(t->t.getCodeTypeValue().equals(s.getCodeTypeValue())).findFirst().get().getId();

			s.setCodeLabel("default");
			s.setCodeTypeId(codeTypeId);
			s.setDictSort(sort.get());

			s.setSystemInner(SystemInnerEnums.YES.getCode());
		});

		codeService.saveOrUpdateBatch(dataList);

	}

	@Override
	public void initManagerConfig(OrganizationEntity org) {

		// 初始化公共级别配置
		List<ManagerSettingsEntity> settings = new ArrayList<>();

		settings.add(new ManagerSettingsEntity("主框架页-默认皮肤样式名称", "sys.index.skinName", "skin-blue",  SystemInnerEnums.YES.getCode(), "蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow",  DataSourceScope.COMMON_SCOPE.getValue()));
		settings.add(new ManagerSettingsEntity("用户管理-账号初始密码", "sys.user.initPassword", "123456",  SystemInnerEnums.YES.getCode(), "初始化密码 123456",  DataSourceScope.COMMON_SCOPE.getValue()));
		settings.add(new ManagerSettingsEntity("主框架页-侧边栏主题", "sys.index.sideTheme", "theme-dark",  SystemInnerEnums.YES.getCode(), "深色主题 theme-dark，浅色主题 theme-light",  DataSourceScope.COMMON_SCOPE.getValue()));
		settings.add(new ManagerSettingsEntity("账号自助-验证码开关", "sys.account.captchaEnabled", "true",  SystemInnerEnums.YES.getCode(), "是否开启验证码功能（true开启，false关闭）",  DataSourceScope.COMMON_SCOPE.getValue()));
		settings.add(new ManagerSettingsEntity("账号自助-是否开启用户注册功能", "sys.account.registerUser", "false",  SystemInnerEnums.YES.getCode(), "是否开启注册用户功能（true开启，false关闭）",  DataSourceScope.COMMON_SCOPE.getValue()));
		settings.add(new ManagerSettingsEntity("用户登录-黑名单列表", "sys.login.blackIPList",  null, SystemInnerEnums.YES.getCode(), "设置登录IP黑名单限制，多个匹配项以;分隔，支持匹配（*通配、网段）",  DataSourceScope.COMMON_SCOPE.getValue()));

		// 继续在之前的settings列表上添加新的参数
		settings.add(new ManagerSettingsEntity("会话超时", "session.timeout", "30", SystemInnerEnums.YES.getCode(), "用户在多少分钟内无操作后会话过期。", DataSourceScope.COMMON_SCOPE.getValue()));
		settings.add(new ManagerSettingsEntity("最大上传文件大小", "upload.maxFileSize", "50MB", SystemInnerEnums.YES.getCode(), "单个文件上传的最大允许大小。", DataSourceScope.COMMON_SCOPE.getValue()));
		settings.add(new ManagerSettingsEntity("SMTP服务器配置", "smtp.server", "smtp.example.com", SystemInnerEnums.YES.getCode(), "邮件发送服务器地址。", DataSourceScope.COMMON_SCOPE.getValue()));
		settings.add(new ManagerSettingsEntity("邮件发送人", "email.from", "no-reply@example.com", SystemInnerEnums.YES.getCode(), "系统发出邮件的发件人地址。", DataSourceScope.COMMON_SCOPE.getValue()));
		settings.add(new ManagerSettingsEntity("数据库连接池配置", "db.pool.size", "min=5, max=20", SystemInnerEnums.YES.getCode(), "数据库连接池的最小和最大连接数量。", DataSourceScope.PROJECT_SCOPE.getValue()));
		settings.add(new ManagerSettingsEntity("缓存策略", "cache.strategy", "LRU", SystemInnerEnums.YES.getCode(), "缓存淘汰策略，如最近最少使用 (LRU)。", DataSourceScope.COMMON_SCOPE.getValue()));
		settings.add(new ManagerSettingsEntity("API限流", "api.rateLimit", "60", SystemInnerEnums.YES.getCode(), "每分钟允许的API请求次数。", DataSourceScope.COMMON_SCOPE.getValue()));
		settings.add(new ManagerSettingsEntity("错误重试次数", "error.retryCount", "3", SystemInnerEnums.YES.getCode(), "当请求失败时尝试重新发送的次数。", DataSourceScope.COMMON_SCOPE.getValue()));
		settings.add(new ManagerSettingsEntity("HTTPS启用", "https.enabled", "true", SystemInnerEnums.YES.getCode(), "是否启用HTTPS安全连接。", DataSourceScope.COMMON_SCOPE.getValue()));

		AtomicLong id = new AtomicLong(452226L);

		settings.forEach(s -> {
			id.getAndIncrement();
			s.setOrgId(org.getId());
			s.setId(id.get());
		});

		settingsService.saveOrUpdateBatch(settings) ;

//		ManagerSettingsEntity(String configName, String configKey, String configValue, String configType, String remark, String dataScope) {

		// 初始化组织对应参数

	}

	@Override
	public void initDeptAndPost(Long userId, OrganizationEntity org, ManagerProjectEntity project) {
		List<ManagerDepartmentEntity> departmentList = new ArrayList<>();

		// 创建智能体科技部门
		ManagerDepartmentEntity aipTech = new ManagerDepartmentEntity();
		aipTech.setId(IdUtil.getSnowflakeNextId());

		aipTech.setPid(project.getId());
		aipTech.setAncestors("");
		aipTech.setPids("");
		aipTech.setPid(project.getId());
		aipTech.setSimpleName("智能体科技");
		aipTech.setFullName("智能体科技");
		aipTech.setOrderNum(0);
		aipTech.setDataScope(DataSourceScope.PROJECT_SCOPE.getValue());

		// 创建南宁总公司部门
		ManagerDepartmentEntity nanningHeadquarters = new ManagerDepartmentEntity();
		nanningHeadquarters.setId(IdUtil.getSnowflakeNextId());

		nanningHeadquarters.setPid(aipTech.getId());
		nanningHeadquarters.setAncestors(aipTech.getAncestors() + aipTech.getId() + ",");
		nanningHeadquarters.setPids(aipTech.getPids() + aipTech.getId() + ",");
		nanningHeadquarters.setSimpleName("南宁总公司");
		nanningHeadquarters.setFullName("南宁总公司");
		nanningHeadquarters.setOrderNum(1);
		nanningHeadquarters.setDataScope(DataSourceScope.PROJECT_SCOPE.getValue());

		// 创建研发部门
		ManagerDepartmentEntity researchDept = new ManagerDepartmentEntity();
		researchDept.setId(IdUtil.getSnowflakeNextId());

		researchDept.setPid(nanningHeadquarters.getId()); // 假设getId()返回自动生成的主键ID
		researchDept.setAncestors(nanningHeadquarters.getAncestors() + nanningHeadquarters.getId() + ",");
		researchDept.setPids(nanningHeadquarters.getPids() + nanningHeadquarters.getId() + ",");
		researchDept.setSimpleName("研发部门");
		researchDept.setFullName("研发部门");
		researchDept.setOrderNum(1);
		researchDept.setDataScope(DataSourceScope.PROJECT_SCOPE.getValue());

		// 创建市场部门
		ManagerDepartmentEntity marketingDept = new ManagerDepartmentEntity();
		marketingDept.setId(IdUtil.getSnowflakeNextId());

		marketingDept.setPid(nanningHeadquarters.getId()); // 假设getId()返回自动生成的主键ID
		marketingDept.setAncestors(nanningHeadquarters.getAncestors() + nanningHeadquarters.getId() + ",");
		marketingDept.setPids(nanningHeadquarters.getPids() + nanningHeadquarters.getId() + ",");
		marketingDept.setSimpleName("市场部门");
		marketingDept.setFullName("市场部门");
		marketingDept.setOrderNum(2);
		marketingDept.setDataScope(DataSourceScope.PROJECT_SCOPE.getValue());

		// 创建测试部门
		ManagerDepartmentEntity testingDept = new ManagerDepartmentEntity();
		testingDept.setId(IdUtil.getSnowflakeNextId());

		testingDept.setPid(nanningHeadquarters.getId()); // 假设getId()返回自动生成的主键ID
		testingDept.setAncestors(nanningHeadquarters.getAncestors() + nanningHeadquarters.getId() + ",");
		testingDept.setPids(nanningHeadquarters.getPids() + nanningHeadquarters.getId() + ",");
		testingDept.setSimpleName("测试部门");
		testingDept.setFullName("测试部门");
		testingDept.setOrderNum(3);
		testingDept.setDataScope(DataSourceScope.PROJECT_SCOPE.getValue());

		// 创建财务部门
		ManagerDepartmentEntity financeDept = new ManagerDepartmentEntity();
		financeDept.setId(IdUtil.getSnowflakeNextId());

		financeDept.setPid(nanningHeadquarters.getId()); // 假设getId()返回自动生成的主键ID
		financeDept.setAncestors(nanningHeadquarters.getAncestors() + nanningHeadquarters.getId() + ",");
		financeDept.setPids(nanningHeadquarters.getPids() + nanningHeadquarters.getId() + ",");
		financeDept.setSimpleName("财务部门");
		financeDept.setFullName("财务部门");
		financeDept.setOrderNum(4);
		financeDept.setDataScope(DataSourceScope.PROJECT_SCOPE.getValue());

		// 创建运维部门
		ManagerDepartmentEntity operationDept = new ManagerDepartmentEntity();
		operationDept.setId(IdUtil.getSnowflakeNextId());

		operationDept.setPid(nanningHeadquarters.getId()); // 假设getId()返回自动生成的主键ID
		operationDept.setAncestors(nanningHeadquarters.getAncestors() + nanningHeadquarters.getId() + ",");
		operationDept.setPids(nanningHeadquarters.getPids() + nanningHeadquarters.getId() + ",");
		operationDept.setSimpleName("运维部门");
		operationDept.setFullName("运维部门");
		operationDept.setOrderNum(5);
		operationDept.setDataScope(DataSourceScope.PROJECT_SCOPE.getValue());

		// 创建柳州分公司部门
		ManagerDepartmentEntity liuzhouBranch = new ManagerDepartmentEntity();
		liuzhouBranch.setId(IdUtil.getSnowflakeNextId());

		liuzhouBranch.setPid(aipTech.getId()); // 假设getId()返回自动生成的主键ID
		liuzhouBranch.setAncestors(aipTech.getAncestors() + aipTech.getId() + ",");
		liuzhouBranch.setPids(aipTech.getPids() + aipTech.getId() + ",");
		liuzhouBranch.setSimpleName("柳州分公司");
		liuzhouBranch.setFullName("柳州分公司");
		liuzhouBranch.setOrderNum(2);
		liuzhouBranch.setDataScope(DataSourceScope.PROJECT_SCOPE.getValue());

		// 创建柳州分公司下的市场部门
		ManagerDepartmentEntity changshaMarketingDept = new ManagerDepartmentEntity();
		changshaMarketingDept.setId(IdUtil.getSnowflakeNextId());

		changshaMarketingDept.setPid(liuzhouBranch.getId()); // 假设getId()返回自动生成的主键ID
		changshaMarketingDept.setAncestors(liuzhouBranch.getAncestors() + liuzhouBranch.getId() + ",");
		changshaMarketingDept.setPids(liuzhouBranch.getPids() + liuzhouBranch.getId() + ",");
		changshaMarketingDept.setSimpleName("市场部门");
		changshaMarketingDept.setFullName("市场部门");
		changshaMarketingDept.setOrderNum(1);
		changshaMarketingDept.setDataScope(DataSourceScope.PROJECT_SCOPE.getValue());

		// 创建柳州分公司下的财务部门
		ManagerDepartmentEntity changshaFinanceDept = new ManagerDepartmentEntity();
		changshaFinanceDept.setId(IdUtil.getSnowflakeNextId());

		changshaFinanceDept.setPid(liuzhouBranch.getId()); // 假设getId()返回自动生成的主键ID
		changshaFinanceDept.setAncestors(liuzhouBranch.getAncestors() + liuzhouBranch.getId() + ",");
		changshaFinanceDept.setPids(liuzhouBranch.getPids() + liuzhouBranch.getId() + ",");
		changshaFinanceDept.setSimpleName("财务部门");
		changshaFinanceDept.setFullName("财务部门");
		changshaFinanceDept.setOrderNum(2);
		changshaFinanceDept.setDataScope(DataSourceScope.PROJECT_SCOPE.getValue());

		// 将部门添加到列表中
		departmentList.add(aipTech);
		departmentList.add(nanningHeadquarters);
		departmentList.add(researchDept);
		departmentList.add(marketingDept);
		departmentList.add(testingDept);
		departmentList.add(financeDept);
		departmentList.add(operationDept);
		departmentList.add(liuzhouBranch);
		departmentList.add(changshaMarketingDept);
		departmentList.add(changshaFinanceDept);

		// 输出或进一步处理 positionList
		departmentList.forEach(dept -> {

			dept.setOrgId(org.getId());
			dept.setOperatorId(userId);
			dept.setProjectId(project.getId());
		}) ;

		managerDepartmentMapper.saveBatch(departmentList);

		genRole(project, userId, org.getId()) ;
	}

	private void genRole(ManagerProjectEntity project, long userId, long orgId) {

		List<ManagerRoleEntity> roleList = new ArrayList<>();

		// 创建超级管理员角色
		ManagerRoleEntity adminRole = new ManagerRoleEntity();
		adminRole.setRoleName("超级管理员");
		adminRole.setRoleTitle("超级管理员");
		adminRole.setRoleKey("superman");
		adminRole.setRoleDesc("拥有授权管理平台所有权限的角色");
		adminRole.setRoleSort(1);
		adminRole.setRoleStatus(1);
		adminRole.setDefaultNetRole(0); // 假设0代表否
		adminRole.setDataScope(DataSourceScope.PROJECT_SCOPE.getValue());

		// 创建普通角色
		ManagerRoleEntity commonRole = new ManagerRoleEntity();
		commonRole.setRoleName("普通角色");
		commonRole.setRoleTitle("普通角色");
		commonRole.setRoleKey("common");
		commonRole.setRoleDesc("普通权限的角色");
		commonRole.setRoleSort(2);
		commonRole.setRoleStatus(1);
		commonRole.setDefaultNetRole(0); // 假设0代表否
		commonRole.setDataScope(DataSourceScope.PROJECT_SCOPE.getValue());

		// 将角色添加到列表中
		roleList.add(adminRole);
		roleList.add(commonRole);

		roleList.forEach(role -> {
			role.setOrgId(orgId);
			role.setOperatorId(userId);
			role.setProjectId(project.getId());
		}) ;

		modelRoleMapper.saveBatch(roleList);
	}

}
