package com.alinesno.infra.base.authority;

import com.alinesno.infra.common.facade.enable.EnableActable;
import com.alinesno.infra.common.web.adapter.sso.enable.EnableInfraSsoApi;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 集成一个Java开发示例工具
 * @author luoxiaodong
 * @since 2023年8月3日 上午6:23:43
 */
@EnableActable
@EnableInfraSsoApi
@MapperScan("com.alinesno.infra.base.authority.mapper")
@SpringBootApplication
public class BaseAuthorityApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseAuthorityApplication.class, args);
	}

}