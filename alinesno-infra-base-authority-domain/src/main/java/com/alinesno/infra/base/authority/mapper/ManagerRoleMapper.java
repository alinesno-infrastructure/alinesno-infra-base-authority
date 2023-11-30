package com.alinesno.infra.base.authority.mapper;

import com.alinesno.infra.base.authority.api.dto.AccountRoleDto;
import com.alinesno.infra.base.authority.entity.ManagerRoleEntity;
import com.alinesno.infra.common.facade.mapper.repository.IBaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
