package com.alinesno.infra.base.authority.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.alinesno.infra.base.authority.api.dto.AccountRoleDto;
import com.alinesno.infra.base.authority.entity.ManagerRoleEntity;
import com.alinesno.infra.common.facade.mapper.repository.IBaseMapper;

/**
 * <p>
 * 持久层接口
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
public interface ManagerRoleMapper extends IBaseMapper<ManagerRoleEntity> {
	
	List<AccountRoleDto> findByAccountIds(@Param("accountIds") List<String> accountIds,
			@Param("applicationCode") String applicationCode);

}
