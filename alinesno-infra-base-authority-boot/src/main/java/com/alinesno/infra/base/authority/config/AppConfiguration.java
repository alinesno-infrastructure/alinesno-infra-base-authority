package com.alinesno.infra.base.authority.config;

import com.alinesno.infra.common.facade.enable.EnableActable;
import com.alinesno.infra.common.security.api.enable.EnableInfraApiSecurity;
import com.alinesno.infra.common.web.log.aspect.LogAspect;
import com.dtflys.forest.springboot.annotation.ForestScan;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 统一配置服务
 */
@Slf4j
@EnableActable
@ForestScan({
    "com.alinesno.infra.common.web.adapter.base.consumer" ,
    "com.alinesno.infra.base.authority.adapter"
})
@MapperScan({
    "com.alinesno.infra.base.authority.mapper" ,
    "com.alinesno.infra.base.authority.identity.mapper"
})
@EnableInfraAuthorityApi
@Configuration
public class AppConfiguration {

    @Bean
    public LogAspect getLogAspect() {
        return new LogAspect();
    }

}
