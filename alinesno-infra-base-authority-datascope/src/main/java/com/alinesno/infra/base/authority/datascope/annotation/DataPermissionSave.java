package com.alinesno.infra.base.authority.datascope.annotation;

import java.lang.annotation.*;

/**
 * 数据权限保存注入
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataPermissionSave {

}
