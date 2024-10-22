package com.alinesno.infra.base.authority.annotation;

import com.alinesno.infra.base.authority.enums.DataSourceScope;

import java.lang.annotation.*;

/**
 * 数据权限拦截
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataPermissionScope {

    /**
     * 自定义权限Bean过滤名称
     *
     * @return
     */
    public String roleBean() default "";

    /**
     * 数据权限范围
     */
    DataSourceScope scope() default DataSourceScope.ORGANIZATIONAL_SCOPE  ;

}
