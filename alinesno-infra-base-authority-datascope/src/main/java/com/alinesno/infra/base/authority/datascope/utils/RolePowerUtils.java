package com.alinesno.infra.base.authority.datascope.utils;

import com.alinesno.infra.base.authority.enums.RolePowerTypeEnmus;

/**
 * 角色权限工具类
 */
public class RolePowerUtils {

    /**
     * 判断是否是管理员
     * @param rolePower
     * @return
     */
    public static boolean isAdmin(String rolePower){
        return RolePowerTypeEnmus.ROLE_ADMIN.getValue().equals(rolePower);
    }

}
