package com.alinesno.infra.base.authority.identity.enums;

import lombok.Getter;

@Getter
public enum WxLoginStatusEnum {

    UNSCANNED("未扫描"),
    SCANNED("已扫描"),
    CONFIRMED("已确认");
    
    private final String desc;

    WxLoginStatusEnum(String desc) {
        this.desc = desc;
    }
}