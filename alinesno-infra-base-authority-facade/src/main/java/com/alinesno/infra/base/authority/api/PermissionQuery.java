package com.alinesno.infra.base.authority.api;

import com.alinesno.infra.base.authority.enums.DataSourceScope;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户查询信息
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PermissionQuery extends InfraBaseEntity {

    private boolean isAdmin ; // 是否是管理员
    private DataSourceScope type ;

    public <T extends InfraBaseEntity> void toWrapper(LambdaQueryWrapper<T> wrapper) {

        if(isAdmin){
            return ;
        }

        if (type == DataSourceScope.PERSONAL_SCOPE) { // 用户权限
            wrapper.eq(T::getOperatorId , this.getOperatorId()) ;
        } else if (type == DataSourceScope.DEPARTMENT_SCOPE) { // 部门权限
            wrapper.eq(T::getDepartmentId , this.getDepartmentId()) ;
        } else if (type == DataSourceScope.ORGANIZATIONAL_SCOPE) { // 组织权限
            wrapper.eq(T::getOrgId , this.getOrgId()) ;
        } else if (type == DataSourceScope.PROJECT_SCOPE) { // 应用权限
            wrapper.eq(T::getApplicationId , this.getApplicationId()) ;
        }

    }

}
