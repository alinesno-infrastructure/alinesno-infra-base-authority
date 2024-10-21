package com.alinesno.infra.base.authority.config;

import com.alinesno.infra.base.authority.entity.ManagerAccountEntity;
import com.alinesno.infra.base.authority.entity.ManagerProjectEntity;
import com.alinesno.infra.base.authority.entity.OrganizationEntity;
import com.alinesno.infra.base.authority.initialize.IAuthorityInitService;
import com.alinesno.infra.common.facade.enable.EnableActable;
import com.alinesno.infra.common.web.log.aspect.LogAspect;
import com.dtflys.forest.springboot.annotation.ForestScan;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 统一配置服务
 */
@Slf4j
@EnableActable
@ForestScan({"com.alinesno.infra.common.web.adapter.base.consumer" , "com.alinesno.infra.base.authority.adapter"})
@MapperScan({"com.alinesno.infra.base.authority.mapper" , "com.alinesno.infra.base.authority.meta.mapper"})
@EnableInfraAuthorityApi
@Configuration
public class AppConfiguration implements CommandLineRunner {

    @Autowired
    private IAuthorityInitService  authorityInitService;

    @Bean
    public LogAspect getLogAspect() {
        return new LogAspect();
    }

    @Override
    public void run(String... args) throws Exception {
        log.debug("项目启动初始化");

        // 初始化平台默认组织
        OrganizationEntity org = authorityInitService.initOrganization() ;

        // 初始化平台默认参数和字典
        authorityInitService.initManagerCode(org) ;
        authorityInitService.initManagerConfig(org) ;

        // 初始化超级管理员
        ManagerAccountEntity managerAccount = authorityInitService.initSuperManager(org) ;

        // 初始化权限引擎服务的菜单权限
        ManagerProjectEntity project = authorityInitService.initData(managerAccount.getId() , org) ;

        // 初始化部门和岗位数据
        authorityInitService.initDeptAndPost(managerAccount.getId() , org , project) ;
    }

}
