package com.alinesno.infra.base.authority.service.impl;

import cn.hutool.core.util.IdUtil;
import com.alinesno.infra.base.authority.entity.ManagerProjectAccountEntity;
import com.alinesno.infra.base.authority.entity.ManagerProjectEntity;
import com.alinesno.infra.base.authority.enums.SystemInnerEnums;
import com.alinesno.infra.base.authority.mapper.ManagerProjectAccountMapper;
import com.alinesno.infra.base.authority.service.IManagerProjectAccountService;
import com.alinesno.infra.base.authority.service.IManagerProjectService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
public class ManagerProjectAccountServiceImpl
		extends IBaseServiceImpl<ManagerProjectAccountEntity, ManagerProjectAccountMapper>
		implements IManagerProjectAccountService {

	@Autowired
	private IManagerProjectService applicationService ;

	@Override
	public ManagerProjectEntity getApplicationByAccountId(long userId) {

		LambdaQueryWrapper<ManagerProjectAccountEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>() ;

		lambdaQueryWrapper.eq(ManagerProjectAccountEntity::getAccountId , userId)
				.orderByDesc(ManagerProjectAccountEntity::getAppOrder) ;

		List<ManagerProjectAccountEntity> es = list(lambdaQueryWrapper) ;

		return CollectionUtils.isEmpty(es) ? null : applicationService.getById(es.get(0).getApplicationId());
	}

	@Override
	public void initDefaultProject(long userId) {

		LambdaQueryWrapper<ManagerProjectEntity> wrapper = new LambdaQueryWrapper<>() ;
		wrapper.eq(ManagerProjectEntity::getOperatorId , userId) ;

		long count = applicationService.count(wrapper) ;

		if(count == 0){  // 账户应用为空
			ManagerProjectEntity e = new ManagerProjectEntity() ;

			String defaultIcon = "fa-solid fa-file-shield" ;

			e.setProjectIcons(defaultIcon);
			e.setProjectCode(IdUtil.getSnowflakeNextIdStr());

			e.setProjectName("默认应用示例服务");
			e.setProjectDesc("默认的初始应用服务，用于默认应用示例和演示服务使用，勿使用生产");
			e.setFieldProp("default");
			e.setOperatorId(userId);
			e.setSystemInner(SystemInnerEnums.YES.getCode());

			applicationService.save(e) ;

			// 初始化应用的默认应用

			LambdaQueryWrapper<ManagerProjectAccountEntity>	maaWrapper = new LambdaQueryWrapper<>() ;
			long countMaa = count(maaWrapper.eq(ManagerProjectAccountEntity::getAccountId , userId)) ;

			ManagerProjectAccountEntity maa = new ManagerProjectAccountEntity() ;
			maa.setAccountId(userId);
			maa.setApplicationId(e.getId());
			maa.setAppOrder(countMaa + 1L);

			this.save(maa) ;
		}

	}

}
