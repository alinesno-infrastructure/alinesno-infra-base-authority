package com.alinesno.infra.base.authority.service.impl;

import com.alinesno.infra.base.authority.entity.ManagerApplicationAccountEntity;
import com.alinesno.infra.base.authority.entity.ManagerApplicationEntity;
import com.alinesno.infra.base.authority.mapper.ManagerApplicationAccountMapper;
import com.alinesno.infra.base.authority.service.IManagerApplicationAccountService;
import com.alinesno.infra.base.authority.service.IManagerApplicationService;
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
public class ManagerApplicationAccountServiceImpl
		extends IBaseServiceImpl<ManagerApplicationAccountEntity, ManagerApplicationAccountMapper>
		implements IManagerApplicationAccountService {

	@Autowired
	private IManagerApplicationService applicationService ;

	@Override
	public ManagerApplicationEntity getApplicationByAccountId(long userId) {

		LambdaQueryWrapper<ManagerApplicationAccountEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>() ;

		lambdaQueryWrapper.eq(ManagerApplicationAccountEntity::getAccountId , userId)
				.orderByDesc(ManagerApplicationAccountEntity::getAppOrder) ;

		List<ManagerApplicationAccountEntity> es = list(lambdaQueryWrapper) ;

		return CollectionUtils.isEmpty(es) ? null : applicationService.getById(es.get(0).getApplicationId());
	}

	@Override
	public void initDefaultProject(long userId) {

		LambdaQueryWrapper<ManagerApplicationEntity> wrapper = new LambdaQueryWrapper<>() ;
		wrapper.eq(ManagerApplicationEntity::getOperatorId , userId) ;

		long count = applicationService.count(wrapper) ;

		if(count == 0){  // 账户应用为空
			ManagerApplicationEntity e = new ManagerApplicationEntity() ;

			String defaultIcon = "fa-solid fa-file-shield" ;

			e.setApplicationIcons(defaultIcon);
			e.setApplicationName("默认应用示例服务");
			e.setApplicationDesc("默认的初始应用服务，用于默认应用示例和演示服务使用，勿使用生产");
			e.setFieldProp("default");
			e.setOperatorId(userId);
			applicationService.save(e) ;

			// 初始化应用的默认应用

			LambdaQueryWrapper<ManagerApplicationAccountEntity>	maaWrapper = new LambdaQueryWrapper<>() ;
			long countMaa = count(maaWrapper.eq(ManagerApplicationAccountEntity::getAccountId , userId)) ;

			ManagerApplicationAccountEntity maa = new ManagerApplicationAccountEntity() ;
			maa.setAccountId(userId);
			maa.setApplicationId(e.getId());
			maa.setAppOrder(countMaa + 1L);

			this.save(maa) ;
		}

	}

}
