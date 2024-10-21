package com.alinesno.infra.base.authority.config;

import com.alinesno.infra.common.core.auto.EnableCore;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 登陆初始化
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@EnableCore
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({ AuthorityApiConfigurationSelector.class })
public @interface EnableInfraAuthorityApi {

}
