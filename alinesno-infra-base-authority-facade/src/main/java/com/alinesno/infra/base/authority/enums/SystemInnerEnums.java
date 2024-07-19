package com.alinesno.infra.base.authority.enums;

import lombok.Getter;

@Getter
public enum SystemInnerEnums {

    YES("Y", "是"),
    NO("N", "否");

    private final String code;
    private final String name;

    SystemInnerEnums(String code, String name) {
        this.code = code;
        this.name = name;
    }

}
