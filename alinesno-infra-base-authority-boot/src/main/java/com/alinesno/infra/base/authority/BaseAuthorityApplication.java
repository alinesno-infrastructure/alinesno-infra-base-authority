package com.alinesno.infra.base.authority;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/**
 * 集成一个Java开发示例工具
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@ConfigurationPropertiesScan
@SpringBootApplication
public class BaseAuthorityApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseAuthorityApplication.class, args);
	}

}