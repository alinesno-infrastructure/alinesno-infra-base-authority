package com.alinesno.infra.base.authority;

import com.alinesno.infra.common.core.auto.EnableCore;
import com.alinesno.infra.common.web.adapter.exception.GlobalExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 集成一个Java开发示例工具
 * @author luoxiaodong
 * @since 2023年8月3日 上午6:23:43
 */
@SpringBootApplication
public class BaseAuthorityApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BaseAuthorityApplication.class, args);
		System.out.println("context = " + context.getBean(GlobalExceptionHandler.class));
	}

}