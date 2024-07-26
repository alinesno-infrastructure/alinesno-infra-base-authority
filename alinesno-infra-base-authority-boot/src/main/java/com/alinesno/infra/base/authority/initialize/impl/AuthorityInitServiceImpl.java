package com.alinesno.infra.base.authority.initialize.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.digest.BCrypt;
import com.alinesno.infra.base.authority.constants.AuthorityConstants;
import com.alinesno.infra.base.authority.entity.*;
import com.alinesno.infra.base.authority.enums.*;
import com.alinesno.infra.base.authority.initialize.IAuthorityInitService;
import com.alinesno.infra.base.authority.service.*;
import com.alinesno.infra.common.core.context.SpringContext;
import com.alinesno.infra.common.web.adapter.dto.menus.Menu;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private IManagerProjectService managerProjectService;

	@Autowired
	private IManagerAccountService accountService;

	@Autowired
	private IManagerSettingsService settingsService ;

	@Autowired
	private IManagerCodeTypeService codeTypeService ;

	@Autowired
	private IManagerCodeService codeService; ;

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
	}

	/**
	 * 生成系统菜单列表
	 * @return
	 */
	public static List<ManagerResourceEntity> genBaseAuthorityResources(OrganizationEntity org, ManagerProjectEntity project) {

		Menu dashboardMenu = new Menu("Dashboard", "/dashboard", false, "noRedirect", "Layout", true, new Menu.Meta("仪盘表", "dashboard", false, null), List.of(
				new Menu("Dashboard", "index", false, false , "dashboard", new Menu.Meta("概览", "dashboard", false, null)) ,
				new Menu("Project", "project/index", false, false , "project", new Menu.Meta("项目管理", "monitor", false, null),List.of(
						new Menu("system:project:query", new Menu.Meta("查询", "logininfor", false, null)),
						new Menu("system:project:add", new Menu.Meta("新增", "logininfor", false, null)),
						new Menu("system:project:edit", new Menu.Meta("修改", "logininfor", false, null)),
						new Menu("system:project:export", new Menu.Meta("导出", "logininfor", false, null)),
						new Menu("system:project:import", new Menu.Meta("导入", "logininfor", false, null)),
						new Menu("system:project:remove", new Menu.Meta("删除", "logininfor", false, null))
				))
		));

		Menu systemMenu = new Menu("System", "/system", false, "noRedirect", "Layout", true, new Menu.Meta("权限配置", "post", false, null),
				List.of(
						new Menu("Dept", "system/dept/index", false,false,  "system/dept/index", new Menu.Meta("部门管理", "tree", false, null),List.of(
								new Menu("system:dept:query", new Menu.Meta("查询", "logininfor", false, null)),
								new Menu("system:dept:add", new Menu.Meta("新增", "logininfor", false, null)),
								new Menu("system:dept:edit", new Menu.Meta("修改", "logininfor", false, null)),
								new Menu("system:dept:export", new Menu.Meta("导出", "logininfor", false, null)),
								new Menu("system:dept:import", new Menu.Meta("导入", "logininfor", false, null)),
								new Menu("system:dept:remove", new Menu.Meta("删除", "logininfor", false, null))
						)),
						new Menu("Post", "system/post/index", false, false, "system/post/index", new Menu.Meta("岗位管理", "post", false, null),List.of(
								new Menu("system:post:query", new Menu.Meta("查询", "logininfor", false, null)),
								new Menu("system:post:add", new Menu.Meta("新增", "logininfor", false, null)),
								new Menu("system:post:edit", new Menu.Meta("修改", "logininfor", false, null)),
								new Menu("system:post:export", new Menu.Meta("导出", "logininfor", false, null)),
								new Menu("system:post:import", new Menu.Meta("导入", "logininfor", false, null)),
								new Menu("system:post:remove", new Menu.Meta("删除", "logininfor", false, null))
						)),
						new Menu("Role", "system/role/index", false, false, "system/role/index", new Menu.Meta("角色管理", "peoples", false, null),List.of(
								new Menu("system:role:query", new Menu.Meta("查询", "logininfor", false, null)),
								new Menu("system:role:add", new Menu.Meta("新增", "logininfor", false, null)),
								new Menu("system:role:edit", new Menu.Meta("修改", "logininfor", false, null)),
								new Menu("system:role:export", new Menu.Meta("导出", "logininfor", false, null)),
								new Menu("system:role:import", new Menu.Meta("导入", "logininfor", false, null)),
								new Menu("system:role:remove", new Menu.Meta("删除", "logininfor", false, null))
						)),
						new Menu("Dict", "system/dict/index", false,false,  "system/dict/index", new Menu.Meta("字典管理", "dict", false, null),List.of(
								new Menu("system:dict:query", new Menu.Meta("查询", "logininfor", false, null)),
								new Menu("system:dict:add", new Menu.Meta("新增", "logininfor", false, null)),
								new Menu("system:dict:edit", new Menu.Meta("修改", "logininfor", false, null)),
								new Menu("system:dict:export", new Menu.Meta("导出", "logininfor", false, null)),
								new Menu("system:dict:import", new Menu.Meta("导入", "logininfor", false, null)),
								new Menu("system:dict:remove", new Menu.Meta("删除", "logininfor", false, null))
						)),
						new Menu("Config", "system/config/index", false,false,  "system/config/index", new Menu.Meta("参数设置", "edit", false, null),List.of(
								new Menu("system:config:query", new Menu.Meta("查询", "logininfor", false, null)),
								new Menu("system:config:add", new Menu.Meta("新增", "logininfor", false, null)),
								new Menu("system:config:edit", new Menu.Meta("修改", "logininfor", false, null)),
								new Menu("system:config:export", new Menu.Meta("导出", "logininfor", false, null)),
								new Menu("system:config:import", new Menu.Meta("导入", "logininfor", false, null)),
								new Menu("system:config:remove", new Menu.Meta("删除", "logininfor", false, null))
						)),
						new Menu("Notice", "system/notice/index", false,false,  "system/notice/index", new Menu.Meta("通知公告", "message", false, null),List.of(
								new Menu("system:notice:query", new Menu.Meta("查询", "logininfor", false, null)),
								new Menu("system:notice:add", new Menu.Meta("新增", "logininfor", false, null)),
								new Menu("system:notice:edit", new Menu.Meta("修改", "logininfor", false, null)),
								new Menu("system:notice:export", new Menu.Meta("导出", "logininfor", false, null)),
								new Menu("system:notice:import", new Menu.Meta("导入", "logininfor", false, null)),
								new Menu("system:notice:remove", new Menu.Meta("删除", "logininfor", false, null))
						))
				));

		Menu loggerMenu = new Menu("Log", "/log", false, "noRedirect", "Layout", true, new Menu.Meta("日志管理", "log", false, null),
				List.of(
						new Menu("Operlog", "monitor/operlog/index", false,false, "log/operlog/index", new Menu.Meta("操作日志", "message", false, null),List.of(
								new Menu("system:operlog:query", new Menu.Meta("查询", "logininfor", false, null)),
								new Menu("system:operlog:add", new Menu.Meta("新增", "logininfor", false, null)),
								new Menu("system:operlog:edit", new Menu.Meta("修改", "logininfor", false, null)),
								new Menu("system:operlog:export", new Menu.Meta("导出", "logininfor", false, null)),
								new Menu("system:operlog:import", new Menu.Meta("导入", "logininfor", false, null)),
								new Menu("system:operlog:remove", new Menu.Meta("删除", "logininfor", false, null))
						)),
						new Menu("Apilog", "monitor/apilog/index", false,false, "log/apilog/index", new Menu.Meta("接口日志", "form", false, null),List.of(
								new Menu("system:apilog:query", new Menu.Meta("查询", "logininfor", false, null)),
								new Menu("system:apilog:add", new Menu.Meta("新增", "logininfor", false, null)),
								new Menu("system:apilog:edit", new Menu.Meta("修改", "logininfor", false, null)),
								new Menu("system:apilog:export", new Menu.Meta("导出", "logininfor", false, null)),
								new Menu("system:apilog:import", new Menu.Meta("导入", "logininfor", false, null)),
								new Menu("system:apilog:remove", new Menu.Meta("删除", "logininfor", false, null))
						)),
						new Menu("Logininfor", "monitor/logininfor/index", false,false, "log/logininfor/index", new Menu.Meta("登录日志", "logininfor", false, null),List.of(
								new Menu("system:logininfor:query", new Menu.Meta("查询", "logininfor", false, null)),
								new Menu("system:logininfor:add", new Menu.Meta("新增", "logininfor", false, null)),
								new Menu("system:logininfor:edit", new Menu.Meta("修改", "logininfor", false, null)),
								new Menu("system:logininfor:export", new Menu.Meta("导出", "logininfor", false, null)),
								new Menu("system:logininfor:import", new Menu.Meta("导入", "logininfor", false, null)),
								new Menu("system:logininfor:remove", new Menu.Meta("删除", "logininfor", false, null))
						))
				));

		Menu monitorMenu = new Menu("Monitor", "/monitor", false, "noRedirect", "Layout", true, new Menu.Meta("系统监控", "monitor", false, null),
				List.of(
						new Menu("Online", "monitor/online/index", false,false, "monitor/online/index", new Menu.Meta("在线用户", "peoples", false, null),List.of(
								new Menu("system:online:query", new Menu.Meta("查询", "logininfor", false, null)),
								new Menu("system:online:add", new Menu.Meta("新增", "logininfor", false, null)),
								new Menu("system:online:edit", new Menu.Meta("修改", "logininfor", false, null)),
								new Menu("system:online:export", new Menu.Meta("导出", "logininfor", false, null)),
								new Menu("system:online:import", new Menu.Meta("导入", "logininfor", false, null)),
								new Menu("system:online:remove", new Menu.Meta("删除", "logininfor", false, null))
						)),
						new Menu("Server", "monitor/server/index", false,false, "monitor/server/index", new Menu.Meta("服务监控", "server", false, null),List.of(
								new Menu("system:server:query", new Menu.Meta("查询", "logininfor", false, null))
						)),
						new Menu("Cache", "monitor/cache/index", false,false, "monitor/cache/index", new Menu.Meta("缓存监控", "redis", false, null),List.of(
								new Menu("system:cache:query", new Menu.Meta("查询", "logininfor", false, null))
						)),
						new Menu("CacheList", "monitor/cache/list", false, false,"monitor/cache/list", new Menu.Meta("缓存列表", "redis-list", false, null),List.of(
								new Menu("system:cache:query", new Menu.Meta("查询", "logininfor", false, null)),
								new Menu("system:cache:add", new Menu.Meta("新增", "logininfor", false, null)),
								new Menu("system:cache:edit", new Menu.Meta("修改", "logininfor", false, null)),
								new Menu("system:cache:export", new Menu.Meta("导出", "logininfor", false, null)),
								new Menu("system:cache:import", new Menu.Meta("导入", "logininfor", false, null)),
								new Menu("system:cache:remove", new Menu.Meta("删除", "logininfor", false, null))
						))
				));

		Menu orgMenu = new Menu("Enterprise", "/enterprise", false, "noRedirect", "Layout", true, new Menu.Meta("组织管理", "tool", false, null),
				List.of(
						new Menu("Org", "org/index", false,false,  "org/index", new Menu.Meta("组织管理", "tree", false, null),List.of(
								new Menu("system:org:query", new Menu.Meta("查询", "logininfor", false, null)),
								new Menu("system:org:add", new Menu.Meta("新增", "logininfor", false, null)),
								new Menu("system:org:edit", new Menu.Meta("修改", "logininfor", false, null)),
								new Menu("system:org:export", new Menu.Meta("导出", "logininfor", false, null)),
								new Menu("system:org:import", new Menu.Meta("导入", "logininfor", false, null)),
								new Menu("system:org:remove", new Menu.Meta("删除", "logininfor", false, null))
						)),
						new Menu("User", "system/user/index", false,false,  "system/user/index", new Menu.Meta("用户管理", "user", false, null),List.of(
									new Menu("system:user:query", new Menu.Meta("查询", "logininfor", false, null)),
									new Menu("system:user:add", new Menu.Meta("新增", "logininfor", false, null)),
									new Menu("system:user:edit", new Menu.Meta("修改", "logininfor", false, null)),
									new Menu("system:user:export", new Menu.Meta("导出", "logininfor", false, null)),
									new Menu("system:user:import", new Menu.Meta("导入", "logininfor", false, null)),
									new Menu("system:user:resetPwd", new Menu.Meta("重置密码", "logininfor", false, null)),
									new Menu("system:user:remove", new Menu.Meta("删除", "logininfor", false, null))
								)),
						new Menu("AccountSync", "system/sync/index", false,false,  "system/sync/index", new Menu.Meta("账户同步", "message", false, null),List.of(
								new Menu("system:sync:query", new Menu.Meta("查询", "logininfor", false, null)),
								new Menu("system:sync:add", new Menu.Meta("新增", "logininfor", false, null)),
								new Menu("system:sync:edit", new Menu.Meta("修改", "logininfor", false, null)),
								new Menu("system:sync:export", new Menu.Meta("导出", "logininfor", false, null)),
								new Menu("system:sync:import", new Menu.Meta("导入", "logininfor", false, null)),
								new Menu("system:sync:remove", new Menu.Meta("删除", "logininfor", false, null))
						)),
						new Menu("Setting", "enterprise/setting/index", false,false, "enterprise/setting/index", new Menu.Meta("系统主题", "build", false, null),List.of(
								new Menu("system:setting:query", new Menu.Meta("查询", "logininfor", false, null)),
								new Menu("system:setting:add", new Menu.Meta("新增", "logininfor", false, null)),
								new Menu("system:setting:edit", new Menu.Meta("修改", "logininfor", false, null)),
								new Menu("system:setting:export", new Menu.Meta("导出", "logininfor", false, null)),
								new Menu("system:setting:import", new Menu.Meta("导入", "logininfor", false, null)),
								new Menu("system:setting:remove", new Menu.Meta("删除", "logininfor", false, null))
						)),
						new Menu("Theme", "enterprise/theme/index",false, false, "enterprise/theme/index", new Menu.Meta("登陆主题", "swagger", false, null),List.of(
								new Menu("system:theme:query", new Menu.Meta("查询", "logininfor", false, null)),
								new Menu("system:theme:add", new Menu.Meta("新增", "logininfor", false, null)),
								new Menu("system:theme:edit", new Menu.Meta("修改", "logininfor", false, null)),
								new Menu("system:theme:export", new Menu.Meta("导出", "logininfor", false, null)),
								new Menu("system:theme:import", new Menu.Meta("导入", "logininfor", false, null)),
								new Menu("system:theme:remove", new Menu.Meta("删除", "logininfor", false, null))
						))
				));

		List<Menu> menus = List.of(dashboardMenu , systemMenu, orgMenu, monitorMenu, loggerMenu);

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

			List<Menu> subMenus = menu.getChildren();

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

				List<Menu> subMenusBtn = item.getChildren();

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

}
