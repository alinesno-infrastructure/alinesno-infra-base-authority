package com.alinesno.infra.base.authority.enums;

import lombok.Getter;

/**
 * 账户组织类型枚举。
 * 该枚举定义了账户在组织中的角色类型，包括管理员和普通用户。
 */
@Getter
public enum AccountOrganizationType {

    // 管理员角色类型
    ADMINISTRATOR("管理员" , 1),
    // 普通成员角色类型
    REGULAR_USER("成员" , 2);

    // 角色类型的整数表示
    private final int type;
    private final String name;

    // 构造函数，初始化角色类型的整数表示
    AccountOrganizationType(String name , int type) {
        this.name = name;
        this.type = type;
    }

    /**
     * 根据类型值获取枚举实例。
     * 该方法允许通过整数类型值来获取对应的枚举常量。
     * 如果没有匹配的枚举常量，则抛出IllegalArgumentException。
     *
     * @param type 角色类型的整数表示
     * @return 对应的枚举常量
     * @throws IllegalArgumentException 如果给定的类型值无效
     */
    // 可选方法: 通过类型值查找枚举实例
    public static AccountOrganizationType fromType(int type) {
        for (AccountOrganizationType userType : AccountOrganizationType.values()) {
            if (userType.getType() == type) {
                return userType;
            }
        }
        throw new IllegalArgumentException("Invalid user type: " + type);
    }
}
