package com.alinesno.infra.base.authority.gateway.aspect;

import com.alinesno.infra.common.facade.pageable.ConditionDto;
import com.alinesno.infra.common.web.adapter.base.dto.ManagerAccountDto;

/**
 * 自定义数据权限拦截
 * 
 * @author LuoAnDong
 * @since 2020年3月22日 下午5:56:47
 */
public interface DataPermissionParent {

	/**
	 * 前端参数
	 * 
	 * @param dto 参数
	 * @param account  当前登录用户
	 */
	void filterMap(ConditionDto dto , ManagerAccountDto account);

}
