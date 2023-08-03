package com.alinesno.infra.base.authority.mapper;

import org.apache.ibatis.annotations.Param;

import com.alinesno.infra.base.authority.entity.ManagerAccountEntity;
import com.alinesno.infra.common.facade.mapper.repository.IBaseMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 持久层接口
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
public interface ManagerAccountMapper extends IBaseMapper<ManagerAccountEntity> {
	
	Page<ManagerAccountEntity> findRoleMemberByPage(@Param(Constants.WRAPPER) QueryWrapper<ManagerAccountEntity> wrapper);

}
