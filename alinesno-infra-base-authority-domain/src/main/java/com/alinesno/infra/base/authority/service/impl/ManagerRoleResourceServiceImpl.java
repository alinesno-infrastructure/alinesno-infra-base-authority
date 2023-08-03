package com.alinesno.infra.base.authority.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alinesno.infra.base.authority.entity.ManagerRoleResourceEntity;
import com.alinesno.infra.base.authority.mapper.ManagerRoleResourceMapper;
import com.alinesno.infra.base.authority.service.IManagerRoleResourceService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.common.facade.wrapper.RpcWrapper;
import com.alinesno.infra.common.facade.wrapper.mybatis.WrapperGenerator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import cn.hutool.core.util.StrUtil;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@Service
public class ManagerRoleResourceServiceImpl extends IBaseServiceImpl<ManagerRoleResourceEntity, ManagerRoleResourceMapper> implements IManagerRoleResourceService {

	// 日志记录
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(ManagerRoleResourceServiceImpl.class);

	@Autowired
	private ManagerRoleResourceMapper managerRoleResourceMapper;

	@Override
	public void deleteByRoleId(Long roleId) { 

		QueryWrapper<ManagerRoleResourceEntity> w = WrapperGenerator.build();
		w.eq("role_id", roleId);

		managerRoleResourceMapper.delete(w);
	}

	@Override
	public int saveAll(List<ManagerRoleResourceEntity> list) {
		int insert = 0;
		for (ManagerRoleResourceEntity managerRoleResourceEntity : list) {
			insert = managerRoleResourceMapper.insert(managerRoleResourceEntity);
		}
		return insert;

	}

	@Override
	public void authRole(Long roleId, List<String> resourceIds) {
		log.info("角色授权：roleId：" + roleId + ";resourceIds" + resourceIds);
	 
		// 删除权限
		RpcWrapper<ManagerRoleResourceEntity> wrapper = RpcWrapper.build();
		wrapper.eq("role_id", roleId);
		managerRoleResourceMapper.delete(wrapper.toQueryWrapper());
		if (CollectionUtils.isEmpty(resourceIds)) {
			return;
		}

		// 数据过滤
		resourceIds = resourceIds.stream().filter(item -> StrUtil.isNotEmpty(item)).distinct()
				.collect(Collectors.toList());

		// 重新授权
		List<ManagerRoleResourceEntity> list = new ArrayList<>();
		resourceIds.forEach(resourceId -> {
			ManagerRoleResourceEntity entity = new ManagerRoleResourceEntity();
			entity.setRoleId(roleId);
			entity.setResourceId(resourceId);
			list.add(entity);
		});
		if (CollectionUtils.isNotEmpty(list)) {
			saveBatch(list);
		}
	}

}
