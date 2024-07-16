package com.alinesno.infra.base.identity.auth;

import com.alinesno.infra.common.core.auto.EnableCore;
import com.dtflys.forest.springboot.annotation.ForestScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 集成一个Java开发示例工具
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@ForestScan(basePackages="com.alinesno.infra.base.identity.auth.adapter")
@EnableCore
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class IdentityAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdentityAuthApplication.class, args);
	}

}