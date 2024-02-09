package com.alinesno.infra.base.authority.config;

import com.alinesno.infra.common.facade.enable.EnableActable;
import com.alinesno.infra.common.web.adapter.sso.enable.EnableInfraSsoApi;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 统一配置服务
 */
@EnableActable
@EnableInfraSsoApi
@MapperScan("com.alinesno.infra.base.authority.mapper")
@Configuration
public class AppConfiguration {

}
