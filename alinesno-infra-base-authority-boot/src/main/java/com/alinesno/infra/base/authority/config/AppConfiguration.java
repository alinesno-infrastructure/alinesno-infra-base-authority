package com.alinesno.infra.base.authority.config;

import com.alinesno.infra.common.facade.enable.EnableActable;
import com.alinesno.infra.common.web.adapter.sso.enable.EnableInfraSsoApi;
import com.alinesno.infra.common.web.log.aspect.LogAspect;
import com.dtflys.forest.annotation.Backend;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 统一配置服务
 */
@EnableActable
@EnableInfraSsoApi
@MapperScan("com.alinesno.infra.base.authority.mapper")
@Configuration
public class AppConfiguration {

    @Bean
    public LogAspect getLogAspect() {
        return new LogAspect();
    }

}
