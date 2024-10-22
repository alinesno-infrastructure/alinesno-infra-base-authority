package com.alinesno.infra.base.authority.enums;

import lombok.Getter;

/**
 * 数据源范围枚举
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Getter
public enum DataSourceScope {

    // 部门权限/自定义权限
    CUSTOM_SCOPE("custom", "自定义范围，仅限于特定用户。" , null),
    DEPARTMENT_SCOPE("department", "部门范围，仅限于特定部门成员。", "departmentId"),
    COMMON_SCOPE("common", "公共范围，所有人都可以访问。" , null),
    ORGANIZATIONAL_SCOPE("org", "组织范围，仅限于特定组织内部成员。" , "orgId"),
    PROJECT_SCOPE("project", "项目范围，仅限于特定项目团队成员。" , "applicationId"),
    PERSONAL_SCOPE("personal", "个人范围，仅限于用户本人。" , "operationId") ;

    private final String value;
    private final String desc;
    private final String field ;

    DataSourceScope(String value, String desc , String field) {
        this.value = value;
        this.desc = desc;
        this.field = field;
    }

}