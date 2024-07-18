package com.alinesno.infra.base.authority.config;

import com.alinesno.infra.base.authority.entity.ManagerAccountEntity;
import com.alinesno.infra.base.authority.initialize.IAuthorityInitService;
import com.alinesno.infra.base.authority.service.IManagerProjectService;
import com.alinesno.infra.common.facade.enable.EnableActable;
import com.alinesno.infra.common.web.adapter.sso.enable.EnableInfraSsoApi;
import com.alinesno.infra.common.web.log.aspect.LogAspect;
import com.dtflys.forest.annotation.Backend;
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
@EnableInfraSsoApi
@MapperScan("com.alinesno.infra.base.authority.mapper")
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

        // 初始化超级管理员
        ManagerAccountEntity managerAccount = authorityInitService.initSuperManager() ;

        // 初始化权限引擎服务的菜单权限
        authorityInitService.initData(null) ;
    }

}
