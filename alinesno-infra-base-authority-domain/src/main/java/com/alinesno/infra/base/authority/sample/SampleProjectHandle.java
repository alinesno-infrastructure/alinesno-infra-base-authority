package com.alinesno.infra.base.authority.sample;

import cn.hutool.core.util.IdUtil;
import com.alinesno.infra.base.authority.entity.*;
import com.alinesno.infra.base.authority.enums.DataSourceScope;
import com.alinesno.infra.base.authority.mapper.ManagerDepartmentMapper;
import com.alinesno.infra.base.authority.mapper.ManagerPositionMapper;
import com.alinesno.infra.base.authority.mapper.ManagerRoleMapper;
import com.alinesno.infra.base.authority.sample.bean.MenuBean;
import com.alinesno.infra.base.authority.enums.MenuEnums;
import com.alinesno.infra.base.authority.enums.SystemInnerEnums;
import com.alinesno.infra.base.authority.mapper.ManagerResourceMapper;
import com.alinesno.infra.base.authority.service.IManagerProjectAccountService;
import com.alinesno.infra.base.authority.service.impl.ManagerProjectServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生成示例数据服务
 */
@Data
@Component
public class SampleProjectHandle {

    @Autowired
    private IManagerProjectAccountService managerApplicationAccountService;

    @Autowired
    private ManagerResourceMapper resourceMapper ;

    @Autowired
    private ManagerRoleMapper modelRoleMapper;

    @Autowired
    private ManagerPositionMapper managerPositionMapper ;

    @Autowired
    private ManagerDepartmentMapper managerDepartmentMapper ;

    public void genSimpleProjectData(ManagerProjectServiceImpl managerProjectService, long userId, long orgId){

        // 创建示例应用
        ManagerProjectEntity project = genProject(managerProjectService , userId , orgId) ;

        // 创建示例菜单
        genMenu(project , managerProjectService , userId , orgId) ;

        // 创建示例角色
        genRole(project , managerProjectService , userId , orgId) ;

        // 创建示例部门
        genDept(project , managerProjectService , userId , orgId) ;

        // 创建示例岗位
        genPost(project , managerProjectService , userId , orgId) ;

        // 创建示例字典
        genManagerCode() ;

        // 创建示例系统参数
        genManagerSystem() ;

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

    private ManagerProjectEntity genProject(ManagerProjectServiceImpl managerProjectService, long userId, long orgId) {
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

    private void genMenu(ManagerProjectEntity project, ManagerProjectServiceImpl managerProjectService, long userId, long orgId) {
        // 初始化菜单
        List<MenuBean> menus = getMenuBeans();

        List<ManagerResourceEntity> es = new ArrayList<>() ;

        AtomicInteger pId = new AtomicInteger(1001);
        menus.forEach(menu -> {
            System.out.println(menu.toString());

            pId.incrementAndGet();

            ManagerResourceEntity e = new ManagerResourceEntity() ;
            e.setOrgId(orgId);

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
                e2.setOrgId(orgId);

                e2.setId(pId2.longValue()+pId.longValue());
                e2.setResourceName(item.getMeta().getTitle());
                e2.setResourceIcon(item.getMeta().getIcon());
                e2.setMenuType(MenuEnums.MENU_ITEM.getValue());  // 目录菜单
                e2.setResourceLink(item.getPath());
                e2.setComponent(item.getComponent());
                e2.setResourceOrder(pId2.get()/100);
                e2.setProjectId(project.getId());
                e2.setResourceParent(e.getId());

                es.add(e2) ;

                pId2.incrementAndGet();

                List<MenuBean> subMenusBtn = item.getChildren();

                if(subMenusBtn != null && !subMenusBtn.isEmpty()){

                    AtomicInteger pId3 = new AtomicInteger(10*pId2.intValue());
                    subMenusBtn.forEach(itemBtn -> {

                        ManagerResourceEntity e3 = new ManagerResourceEntity() ;

                        e3.setOrgId(orgId);
                        e3.setProjectId(project.getId());
                        e3.setResourceParent(e2.getId());

                        e3.setId(pId3.longValue()+pId2.longValue());
                        e3.setResourceName(itemBtn.getMeta().getTitle());
                        e3.setPermission(itemBtn.getPerms());
                        e3.setMenuType(MenuEnums.MENU_BUTTON.getValue());  // 目录菜单
                        e3.setResourceOrder(pId2.get()/10/100);

                        es.add(e3) ;
                        pId3.incrementAndGet();

                    });
                }


            });
        });

        es.forEach(e->{
            resourceMapper.insert(e);
        });
    }

    private void genRole(ManagerProjectEntity project, ManagerProjectServiceImpl managerProjectService, long userId, long orgId) {

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

            modelRoleMapper.insert(role);
        }) ;
    }

    private void genDept(ManagerProjectEntity project, ManagerProjectServiceImpl managerProjectService, long userId, long orgId) {

        List<ManagerDepartmentEntity> departmentList = new ArrayList<>();

        // 创建智能体科技部门
        ManagerDepartmentEntity aipTech = new ManagerDepartmentEntity();
        aipTech.setPid(project.getId());
        aipTech.setAncestors("");
        aipTech.setPids("");
        aipTech.setSimpleName("智能体科技");
        aipTech.setFullName("智能体科技");
        aipTech.setOrderNum(0);
        aipTech.setDataScope(DataSourceScope.PROJECT_SCOPE.getValue());

        // 创建南宁总公司部门
        ManagerDepartmentEntity nanningHeadquarters = new ManagerDepartmentEntity();
        nanningHeadquarters.setPid(aipTech.getId()); // 假设getId()返回自动生成的主键ID
        nanningHeadquarters.setAncestors(aipTech.getAncestors() + aipTech.getId() + ",");
        nanningHeadquarters.setPids(aipTech.getPids() + aipTech.getId() + ",");
        nanningHeadquarters.setSimpleName("南宁总公司");
        nanningHeadquarters.setFullName("南宁总公司");
        nanningHeadquarters.setOrderNum(1);
        nanningHeadquarters.setDataScope(DataSourceScope.PROJECT_SCOPE.getValue());

        // 创建研发部门
        ManagerDepartmentEntity researchDept = new ManagerDepartmentEntity();
        researchDept.setPid(nanningHeadquarters.getId()); // 假设getId()返回自动生成的主键ID
        researchDept.setAncestors(nanningHeadquarters.getAncestors() + nanningHeadquarters.getId() + ",");
        researchDept.setPids(nanningHeadquarters.getPids() + nanningHeadquarters.getId() + ",");
        researchDept.setSimpleName("研发部门");
        researchDept.setFullName("研发部门");
        researchDept.setOrderNum(1);
        researchDept.setDataScope(DataSourceScope.PROJECT_SCOPE.getValue());

        // 创建市场部门
        ManagerDepartmentEntity marketingDept = new ManagerDepartmentEntity();
        marketingDept.setPid(nanningHeadquarters.getId()); // 假设getId()返回自动生成的主键ID
        marketingDept.setAncestors(nanningHeadquarters.getAncestors() + nanningHeadquarters.getId() + ",");
        marketingDept.setPids(nanningHeadquarters.getPids() + nanningHeadquarters.getId() + ",");
        marketingDept.setSimpleName("市场部门");
        marketingDept.setFullName("市场部门");
        marketingDept.setOrderNum(2);
        marketingDept.setDataScope(DataSourceScope.PROJECT_SCOPE.getValue());

        // 创建测试部门
        ManagerDepartmentEntity testingDept = new ManagerDepartmentEntity();
        testingDept.setPid(nanningHeadquarters.getId()); // 假设getId()返回自动生成的主键ID
        testingDept.setAncestors(nanningHeadquarters.getAncestors() + nanningHeadquarters.getId() + ",");
        testingDept.setPids(nanningHeadquarters.getPids() + nanningHeadquarters.getId() + ",");
        testingDept.setSimpleName("测试部门");
        testingDept.setFullName("测试部门");
        testingDept.setOrderNum(3);
        testingDept.setDataScope(DataSourceScope.PROJECT_SCOPE.getValue());

        // 创建财务部门
        ManagerDepartmentEntity financeDept = new ManagerDepartmentEntity();
        financeDept.setPid(nanningHeadquarters.getId()); // 假设getId()返回自动生成的主键ID
        financeDept.setAncestors(nanningHeadquarters.getAncestors() + nanningHeadquarters.getId() + ",");
        financeDept.setPids(nanningHeadquarters.getPids() + nanningHeadquarters.getId() + ",");
        financeDept.setSimpleName("财务部门");
        financeDept.setFullName("财务部门");
        financeDept.setOrderNum(4);
        financeDept.setDataScope(DataSourceScope.PROJECT_SCOPE.getValue());

        // 创建运维部门
        ManagerDepartmentEntity operationDept = new ManagerDepartmentEntity();
        operationDept.setPid(nanningHeadquarters.getId()); // 假设getId()返回自动生成的主键ID
        operationDept.setAncestors(nanningHeadquarters.getAncestors() + nanningHeadquarters.getId() + ",");
        operationDept.setPids(nanningHeadquarters.getPids() + nanningHeadquarters.getId() + ",");
        operationDept.setSimpleName("运维部门");
        operationDept.setFullName("运维部门");
        operationDept.setOrderNum(5);
        operationDept.setDataScope(DataSourceScope.PROJECT_SCOPE.getValue());

        // 创建柳州分公司部门
        ManagerDepartmentEntity liuzhouBranch = new ManagerDepartmentEntity();
        liuzhouBranch.setPid(aipTech.getId()); // 假设getId()返回自动生成的主键ID
        liuzhouBranch.setAncestors(aipTech.getAncestors() + aipTech.getId() + ",");
        liuzhouBranch.setPids(aipTech.getPids() + aipTech.getId() + ",");
        liuzhouBranch.setSimpleName("柳州分公司");
        liuzhouBranch.setFullName("柳州分公司");
        liuzhouBranch.setOrderNum(2);
        liuzhouBranch.setDataScope(DataSourceScope.PROJECT_SCOPE.getValue());

        // 创建柳州分公司下的市场部门
        ManagerDepartmentEntity changshaMarketingDept = new ManagerDepartmentEntity();
        changshaMarketingDept.setPid(liuzhouBranch.getId()); // 假设getId()返回自动生成的主键ID
        changshaMarketingDept.setAncestors(liuzhouBranch.getAncestors() + liuzhouBranch.getId() + ",");
        changshaMarketingDept.setPids(liuzhouBranch.getPids() + liuzhouBranch.getId() + ",");
        changshaMarketingDept.setSimpleName("市场部门");
        changshaMarketingDept.setFullName("市场部门");
        changshaMarketingDept.setOrderNum(1);
        changshaMarketingDept.setDataScope(DataSourceScope.PROJECT_SCOPE.getValue());

        // 创建柳州分公司下的财务部门
        ManagerDepartmentEntity changshaFinanceDept = new ManagerDepartmentEntity();
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

            managerDepartmentMapper.insert(dept);
        }) ;

    }

    private void genPost(ManagerProjectEntity project, ManagerProjectServiceImpl managerProjectService, long userId, long orgId) {

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

            managerPositionMapper.insert(role);
        }) ;
    }

    private void genManagerCode() {
    }

    private void genManagerSystem() {
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
