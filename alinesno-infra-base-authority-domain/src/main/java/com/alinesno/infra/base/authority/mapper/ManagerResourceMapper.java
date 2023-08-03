package com.alinesno.infra.base.authority.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.alinesno.infra.base.authority.entity.ManagerResourceEntity;
import com.alinesno.infra.common.facade.mapper.repository.IBaseMapper;

/**
 * <p>
 * 持久层接口
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
public interface ManagerResourceMapper extends IBaseMapper<ManagerResourceEntity> {
 
	/**
	 * 查询账户在某个应用下的权限
	 * 
	 * @param applicationId
	 * @param accountId
	 * @return
	 */
	List<ManagerResourceEntity> findAllByApplicationAndAccount(@Param("applicationId") String applicationId,
			@Param("accountId") String accountId);
 
}
