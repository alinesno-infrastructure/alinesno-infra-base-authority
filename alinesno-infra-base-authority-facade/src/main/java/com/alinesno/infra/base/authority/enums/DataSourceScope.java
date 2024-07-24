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

    COMMON_SCOPE("common", "公共范围，所有人都可以访问。"),
    ORGANIZATIONAL_SCOPE("org", "组织范围，仅限于特定组织内部成员。"),
    PROJECT_SCOPE("project", "项目范围，仅限于特定项目团队成员。"),
    PERSONAL_SCOPE("personal", "个人范围，仅限于用户本人。");

    private final String value;
    private final String desc;

    DataSourceScope(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

}