package com.alinesno.infra.base.authority.sample;

import cn.hutool.core.util.IdUtil;
import com.alinesno.infra.base.authority.entity.*;
import com.alinesno.infra.base.authority.enums.DataSourceScope;
import com.alinesno.infra.base.authority.enums.MenuEnums;
import com.alinesno.infra.base.authority.enums.SystemInnerEnums;
import com.alinesno.infra.base.authority.sample.bean.MenuBean;
import com.alinesno.infra.base.authority.service.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.Data;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 生成示例数据服务
 */
@Data
@Component
public class SampleProjectHandle implements ISampleService {

    private final IManagerProjectAccountService managerApplicationAccountService;

    private final IManagerResourceService resourceMapper ;

    private final IManagerRoleService modelRoleMapper;

    private final IManagerPositionService managerPositionMapper ;

    private final IManagerDepartmentService managerDepartmentMapper ;

    private final IManagerSettingsService settingsService ;

    private final IManagerCodeTypeService codeTypeService ;

    private final IManagerProjectService managerProjectService ;

    private final IManagerCodeService codeService; ;

    public SampleProjectHandle(@Lazy IManagerProjectAccountService managerApplicationAccountService,
                               @Lazy IManagerResourceService resourceMapper,
                               @Lazy IManagerRoleService modelRoleMapper,
                               @Lazy IManagerPositionService managerPositionMapper,
                               @Lazy IManagerDepartmentService managerDepartmentMapper,
                               @Lazy IManagerSettingsService settingsService,
                               @Lazy IManagerCodeTypeService codeTypeService,
                               @Lazy IManagerProjectService managerProjectService,
                               @Lazy IManagerCodeService codeService) {
        this.managerApplicationAccountService = managerApplicationAccountService;
        this.resourceMapper = resourceMapper;
        this.modelRoleMapper = modelRoleMapper;
        this.managerPositionMapper = managerPositionMapper;
        this.managerDepartmentMapper = managerDepartmentMapper;
        this.settingsService = settingsService;
        this.codeTypeService = codeTypeService;
        this.managerProjectService = managerProjectService;
        this.codeService = codeService;
    }

    @Override
    public void genSimpleProjectData(long userId, long orgId){

        // 创建示例应用
        ManagerProjectEntity project = genProject(managerProjectService , userId , orgId) ;

        genSimpleProjectData(project , userId , orgId) ;

    }

    @Override
    public void genSimpleProjectData(ManagerProjectEntity project, long userId, long orgId) {
        // 创建示例菜单
        genMenu(project , managerProjectService , userId , orgId) ;

        // 创建示例角色
        genRole(project , managerProjectService , userId , orgId) ;

        // 创建示例部门
        genDept(project , managerProjectService , userId , orgId) ;

        // 创建示例岗位
        genPost(project , managerProjectService , userId , orgId) ;

        // 创建示例字典
        genManagerCode(project , managerProjectService , userId , orgId) ;

        // 创建示例系统参数
        genManagerSystem(project , managerProjectService , userId , orgId) ;

        // 创建示例公告
        genManagerNotice() ;

        // 初始化应用的默认应用
        LambdaQueryWrapper<ManagerProjectAccountEntity>	maaWrapper = new LambdaQueryWrapper<>() ;
        long countMaa = managerApplicationAccountService.count(maaWrapper.eq(ManagerProjectAccountEntity::getAccountId , userId)) ;

        ManagerProjectAccountEntity maa = new ManagerProjectAccountEntity() ;
        maa.setAccountId(userId);
        maa.setApplicationId(project.getId());
        maa.setAppOrder(countMaa + 1L);

        managerApplicationAccountService.save(maa) ;
    }

    private ManagerProjectEntity genProject(IManagerProjectService managerProjectService, long userId, long orgId) {
        // 初始化应用
        ManagerProjectEntity project = new ManagerProjectEntity() ;

        String defaultIcon = "fa-solid fa-file-shield" ;

        project.setProjectIcons(defaultIcon);
        project.setProjectCode(IdUtil.getSnowflakeNextIdStr());

        project.setProjectName("示例雇员管理服务");
        project.setProjectDesc("默认的初始应用服务，用于默认应用示例和演示服务使用，勿使用生产");
        project.setFieldProp("default");
        project.setOperatorId(userId);
        project.setSystemInner(SystemInnerEnums.YES.getCode());

        managerProjectService.save(project) ;

        return project ;
    }

    private void genMenu(ManagerProjectEntity project, IManagerProjectService managerProjectService, long userId, long orgId) {
        // 初始化菜单
        List<MenuBean> menus = getMenuBeans();

        List<ManagerResourceEntity> es = new ArrayList<>() ;

        AtomicInteger orderId = new AtomicInteger(1);

        menus.forEach(menu -> {
            System.out.println(menu.toString());

            ManagerResourceEntity e = new ManagerResourceEntity() ;
            e.setOrgId(orgId);

            e.setId(IdUtil.getSnowflakeNextId());
            e.setResourceName(menu.getMeta().getTitle());
            e.setResourceIcon(menu.getMeta().getIcon());
            e.setMenuType(MenuEnums.MENU_PACKAGE.getValue());  // 目录菜单
            e.setResourceLink(menu.getPath());
            e.setComponent(menu.getComponent());
            e.setResourceOrder(orderId.get());

            e.setProjectId(project.getId());
            e.setResourceParent(project.getId());

            orderId.incrementAndGet();

            es.add(e) ;

            List<MenuBean> subMenus = menu.getChildren();

            AtomicInteger orderId2 = new AtomicInteger(1);

            subMenus.forEach(item-> {
                System.out.println(item.toString());

                ManagerResourceEntity e2 = new ManagerResourceEntity() ;
                e2.setOrgId(orgId);
                e2.setId(IdUtil.getSnowflakeNextId()) ;

                e2.setResourceName(item.getMeta().getTitle());
                e2.setResourceIcon(item.getMeta().getIcon());
                e2.setMenuType(MenuEnums.MENU_ITEM.getValue());  // 目录菜单
                e2.setResourceLink(item.getPath());
                e2.setComponent(item.getComponent());
                e2.setResourceOrder(orderId2.get());
                e2.setProjectId(project.getId());
                e2.setResourceParent(e.getId());

                es.add(e2) ;

                orderId2.incrementAndGet();

                List<MenuBean> subMenusBtn = item.getChildren();

                if(subMenusBtn != null && !subMenusBtn.isEmpty()){

                    AtomicInteger orderId3 = new AtomicInteger(1);

                    subMenusBtn.forEach(itemBtn -> {

                        ManagerResourceEntity e3 = new ManagerResourceEntity() ;

                        e3.setOrgId(orgId);
                        e3.setProjectId(project.getId());
                        e3.setResourceParent(e2.getId());
                        e3.setId(IdUtil.getSnowflakeNextId()) ;

                        e3.setResourceName(itemBtn.getMeta().getTitle());
                        e3.setPermission(itemBtn.getPerms());
                        e3.setMenuType(MenuEnums.MENU_BUTTON.getValue());  // 目录菜单
                        e3.setResourceOrder(orderId3.get());

                        es.add(e3) ;
                        orderId3.incrementAndGet();

                    });
                }


            });
        });

//        es.forEach(e->{
//            resourceMapper.insert(e);
//        });

        resourceMapper.saveBatch(es) ;
    }

    private void genRole(ManagerProjectEntity project, IManagerProjectService managerProjectService, long userId, long orgId) {

        List<ManagerRoleEntity> roleList = new ArrayList<>();

        // 创建超级管理员角色
        ManagerRoleEntity adminRole = new ManagerRoleEntity();
        adminRole.setRoleName("项目管理员");
        adminRole.setRoleTitle("项目管理员");
        adminRole.setRoleKey("admin");
        adminRole.setRoleDesc("拥有项目所有权限的角色");
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

    private void genDept(ManagerProjectEntity project, IManagerProjectService managerProjectService, long userId, long orgId) {

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

            dept.setOrgId(orgId);
            dept.setOperatorId(userId);
            dept.setProjectId(project.getId());
        }) ;

        managerDepartmentMapper.saveBatch(departmentList);
    }

    private void genPost(ManagerProjectEntity project, IManagerProjectService managerProjectService, long userId, long orgId) {

        List<ManagerPositionEntity> positionList = new ArrayList<>();

        // 创建CEO岗位
        ManagerPositionEntity ceoPosition = new ManagerPositionEntity();
        ceoPosition.setPositionCode("ceo");
        ceoPosition.setPositionName("董事长");
        ceoPosition.setPositionRank("1");
        ceoPosition.setPositionSort("1");
        ceoPosition.setRemark("公司最高领导者");
        ceoPosition.setDataScope(DataSourceScope.PROJECT_SCOPE.getValue());

        // 创建SE（项目经理）岗位
        ManagerPositionEntity sePosition = new ManagerPositionEntity();
        sePosition.setPositionCode("se");
        sePosition.setPositionName("项目经理");
        sePosition.setPositionRank("2");
        sePosition.setPositionSort("2");
        sePosition.setRemark("负责项目管理和团队协调");
        sePosition.setDataScope(DataSourceScope.PROJECT_SCOPE.getValue());

        // 创建HR（人力资源）岗位
        ManagerPositionEntity hrPosition = new ManagerPositionEntity();
        hrPosition.setPositionCode("hr");
        hrPosition.setPositionName("人力资源");
        hrPosition.setPositionRank("3");
        hrPosition.setPositionSort("3");
        hrPosition.setRemark("负责招聘、培训和员工关系");
        hrPosition.setDataScope(DataSourceScope.PROJECT_SCOPE.getValue());

        // 创建普通员工岗位
        ManagerPositionEntity userPosition = new ManagerPositionEntity();
        userPosition.setPositionCode("user");
        userPosition.setPositionName("普通员工");
        userPosition.setPositionRank("4");
        userPosition.setPositionSort("4");
        userPosition.setRemark("一线员工，执行具体工作任务");
        userPosition.setDataScope(DataSourceScope.PROJECT_SCOPE.getValue());

        // 将岗位添加到列表中
        positionList.add(ceoPosition);
        positionList.add(sePosition);
        positionList.add(hrPosition);
        positionList.add(userPosition);

        // 输出或进一步处理 positionList
        positionList.forEach(role -> {
            role.setOrgId(orgId);
            role.setOperatorId(userId);
            role.setProjectId(project.getId());
        }) ;

        managerPositionMapper.saveBatch(positionList);
    }

    private void genManagerCode(ManagerProjectEntity project, IManagerProjectService managerProjectService, long userId, long orgId) {

        // 初始化公共级别系统代码
        List<ManagerCodeTypeEntity> codeTypes = new ArrayList<>();

        codeTypes.add(new ManagerCodeTypeEntity("政务面貌", "sys_political_status", "政务面貌列表", DataSourceScope.PROJECT_SCOPE.getValue()));
        codeTypes.add(new ManagerCodeTypeEntity("学历", "sys_education", "学历列表", DataSourceScope.PROJECT_SCOPE.getValue()));

        AtomicLong id = new AtomicLong(IdUtil.getSnowflakeNextId());

        codeTypes.forEach(s -> {
            id.getAndIncrement();

            s.setOrgId(orgId);
            s.setId(id.get());

            s.setSystemInner(SystemInnerEnums.YES.getCode());
        });

        codeTypeService.saveOrUpdateBatch(codeTypes) ;

        List<ManagerCodeEntity> dataList = new ArrayList<>();

        // 政务面貌
        dataList.add(new ManagerCodeEntity("中共党员", "0", "sys_political_status", 1, "中共党员", DataSourceScope.PROJECT_SCOPE.getValue()));
        dataList.add(new ManagerCodeEntity("预备党员", "1", "sys_political_status", 2, "预备党员", DataSourceScope.PROJECT_SCOPE.getValue()));
        dataList.add(new ManagerCodeEntity("共青团员", "2", "sys_political_status", 3, "共青团员", DataSourceScope.PROJECT_SCOPE.getValue()));
        dataList.add(new ManagerCodeEntity("群众", "3", "sys_political_status", 4, "群众", DataSourceScope.PROJECT_SCOPE.getValue()));

        // 学历
        dataList.add(new ManagerCodeEntity("博士研究生", "0", "sys_education", 1, "博士研究生", DataSourceScope.PROJECT_SCOPE.getValue()));
        dataList.add(new ManagerCodeEntity("硕士研究生", "1", "sys_education", 2, "硕士研究生", DataSourceScope.PROJECT_SCOPE.getValue()));
        dataList.add(new ManagerCodeEntity("本科", "2", "sys_education", 3, "本科学历", DataSourceScope.PROJECT_SCOPE.getValue()));
        dataList.add(new ManagerCodeEntity("大专", "3", "sys_education", 4, "专科学历", DataSourceScope.PROJECT_SCOPE.getValue()));
        dataList.add(new ManagerCodeEntity("高中及以下", "4", "sys_education", 5, "高中及以下学历", DataSourceScope.PROJECT_SCOPE.getValue()));


        AtomicLong sort = new AtomicLong(IdUtil.getSnowflakeNextId());
        dataList.forEach(s -> {

            sort.getAndIncrement();

            s.setOrgId(orgId);
            s.setId(id.getAndIncrement());

            long codeTypeId =codeTypes.stream().filter(t->t.getCodeTypeValue().equals(s.getCodeTypeValue())).findFirst().get().getId();

            s.setCodeLabel("default");
            s.setCodeTypeId(codeTypeId);
            s.setDictSort(sort.get());

            s.setSystemInner(SystemInnerEnums.YES.getCode());
        });

        codeService.saveOrUpdateBatch(dataList);

    }

    private void genManagerSystem(ManagerProjectEntity project, IManagerProjectService managerProjectService, long userId, long orgId) {

        List<ManagerSettingsEntity> settings = new ArrayList<>();

        // 添加雇员管理系统相关的系统参数
        settings.add(new ManagerSettingsEntity("员工入职通知", "employee.onboarding.notification", "true", SystemInnerEnums.YES.getCode(), "是否开启新员工入职自动发送欢迎邮件。", DataSourceScope.PROJECT_SCOPE.getValue()));
        settings.add(new ManagerSettingsEntity("员工离职通知",  "employee.departure.notification", "true", SystemInnerEnums.YES.getCode(), "是否开启员工离职自动发送告别邮件。", DataSourceScope.PROJECT_SCOPE.getValue()));
        settings.add(new ManagerSettingsEntity("绩效评估周期", "performance.review.period", "6", SystemInnerEnums.YES.getCode(), "绩效评估的周期（单位：个月）。默认每半年进行一次绩效评估。", DataSourceScope.PROJECT_SCOPE.getValue()));
        settings.add(new ManagerSettingsEntity("休假申请审批时间", "leave.application.approval.time", "3", SystemInnerEnums.YES.getCode(), "休假申请需要在多少个工作日内完成审批。", DataSourceScope.PROJECT_SCOPE.getValue()));
        settings.add(new ManagerSettingsEntity("加班申请审批时间", "overtime.application.approval.time", "2", SystemInnerEnums.YES.getCode(), "加班申请需要在多少个工作日内完成审批。", DataSourceScope.PROJECT_SCOPE.getValue()));

        AtomicLong id = new AtomicLong(IdUtil.getSnowflakeNextId());

        settings.forEach(s -> {
            id.getAndIncrement();
            s.setOrgId(orgId);
            s.setId(id.get());
        });

        settingsService.saveOrUpdateBatch(settings) ;

    }

    private void genManagerNotice() {
    }

    private static List<MenuBean> getMenuBeans() {
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

        MenuBean employeeMenu = new MenuBean("Employee Management", "/employee", false, "noRedirect", "Layout", true,
                new MenuBean.Meta("员工管理", "team", false, null),
                List.of(
                        new MenuBean("Employee List", "employee/index", false, false, "employee",
                                new MenuBean.Meta("员工列表", "tree", false, null),
                                List.of(
                                        new MenuBean("system:employee:query", new MenuBean.Meta("查询", "search", false, null)),
                                        new MenuBean("system:employee:add", new MenuBean.Meta("新增", "plus", false, null)),
                                        new MenuBean("system:employee:edit", new MenuBean.Meta("修改", "edit", false, null)),
                                        new MenuBean("system:employee:export", new MenuBean.Meta("导出", "download", false, null)),
                                        new MenuBean("system:employee:import", new MenuBean.Meta("导入", "upload", false, null)),
                                        new MenuBean("system:employee:remove", new MenuBean.Meta("删除", "delete", false, null)),
                                        new MenuBean("system:employee:view", new MenuBean.Meta("查看详情", "eye", false, null))
                                )),
                        new MenuBean("Attendance", "attendance/index", false, false, "attendance",
                                new MenuBean.Meta("考勤管理", "user", false, null),
                                List.of(
                                        new MenuBean("system:attendance:query", new MenuBean.Meta("查询", "search", false, null)),
                                        new MenuBean("system:attendance:add", new MenuBean.Meta("新增", "plus", false, null)),
                                        new MenuBean("system:attendance:edit", new MenuBean.Meta("修改", "edit", false, null)),
                                        new MenuBean("system:attendance:export", new MenuBean.Meta("导出", "download", false, null)),
                                        new MenuBean("system:attendance:import", new MenuBean.Meta("导入", "upload", false, null)),
                                        new MenuBean("system:attendance:remove", new MenuBean.Meta("删除", "delete", false, null))
                                )),
                        new MenuBean("Salary", "salary/index", false, false, "salary",
                                new MenuBean.Meta("薪资管理", "swagger", false, null),
                                List.of(
                                        new MenuBean("system:salary:query", new MenuBean.Meta("查询", "search", false, null)),
                                        new MenuBean("system:salary:add", new MenuBean.Meta("新增", "plus", false, null)),
                                        new MenuBean("system:salary:edit", new MenuBean.Meta("修改", "edit", false, null)),
                                        new MenuBean("system:salary:export", new MenuBean.Meta("导出", "download", false, null)),
                                        new MenuBean("system:salary:import", new MenuBean.Meta("导入", "upload", false, null)),
                                        new MenuBean("system:salary:remove", new MenuBean.Meta("删除", "delete", false, null))
                                )),
                        new MenuBean("Benefits", "benefits/index", false, false, "benefits",
                                new MenuBean.Meta("福利管理", "message", false, null),
                                List.of(
                                        new MenuBean("system:benefits:query", new MenuBean.Meta("查询", "search", false, null)),
                                        new MenuBean("system:benefits:add", new MenuBean.Meta("新增", "plus", false, null)),
                                        new MenuBean("system:benefits:edit", new MenuBean.Meta("修改", "edit", false, null)),
                                        new MenuBean("system:benefits:export", new MenuBean.Meta("导出", "download", false, null)),
                                        new MenuBean("system:benefits:import", new MenuBean.Meta("导入", "upload", false, null)),
                                        new MenuBean("system:benefits:remove", new MenuBean.Meta("删除", "delete", false, null))
                                ))
                ));

        return List.of(dashboardMenu , employeeMenu);
    }


}
