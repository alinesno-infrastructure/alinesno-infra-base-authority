package com.alinesno.infra.base.authority.service.impl;

import com.alinesno.infra.base.authority.entity.ManagerProjectAccountEntity;
import com.alinesno.infra.base.authority.entity.ManagerProjectEntity;
import com.alinesno.infra.base.authority.mapper.ManagerProjectAccountMapper;
import com.alinesno.infra.base.authority.mapper.ManagerProjectMapper;
import com.alinesno.infra.base.authority.service.IManagerProjectAccountService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@Slf4j
@Service
public class ManagerProjectAccountServiceImpl  extends IBaseServiceImpl<ManagerProjectAccountEntity, ManagerProjectAccountMapper>  implements IManagerProjectAccountService {

	@Autowired
	private ManagerProjectMapper managerProjectMapper ;

	@Override
	public void setCurrentProject(long projectId, long userId) {

		// 查询当前用户配置记录
		long count = count(new LambdaQueryWrapper<ManagerProjectAccountEntity>()
				.eq(ManagerProjectAccountEntity::getAccountId , userId)) ;

		ManagerProjectAccountEntity e = new ManagerProjectAccountEntity() ;

		e.setAccountId(userId);
		e.setApplicationId(projectId);
		e.setAppOrder(count+1);

		save(e);
	}

	@Override
	public ManagerProjectEntity getCurrentProject(long userId) {

		List<ManagerProjectAccountEntity> es = list(new LambdaQueryWrapper<ManagerProjectAccountEntity>()
				.eq(ManagerProjectAccountEntity::getAccountId , userId)
				.orderByDesc(ManagerProjectAccountEntity::getAppOrder));

		if(es != null && !es.isEmpty()){
			return managerProjectMapper.selectById(es.get(0).getApplicationId()) ;
		}

		return null;
	}
}
