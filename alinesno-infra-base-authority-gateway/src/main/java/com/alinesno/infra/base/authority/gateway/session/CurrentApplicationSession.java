package com.alinesno.infra.base.authority.gateway.session;

import com.alinesno.infra.base.authority.entity.ManagerApplicationAccountEntity;
import com.alinesno.infra.base.authority.entity.ManagerApplicationEntity;
import com.alinesno.infra.base.authority.service.IManagerApplicationAccountService;
import com.alinesno.infra.common.web.adapter.login.account.CurrentAccountJwt;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 获取当前应用
 *
 * @author luoxiaodong
 * @since 1.0.0
 */
@Slf4j
@Component
public class CurrentApplicationSession {

	@Autowired
	private IManagerApplicationAccountService managerApplicationAccountService ;

	public ManagerApplicationEntity get() {

		long userId = CurrentAccountJwt.getUserId();

		return managerApplicationAccountService.getApplicationByAccountId(userId) ;
	}

	public void set(long applicationId) {

		long userId = CurrentAccountJwt.getUserId();

		// 查询当前用户配置记录
		long count = managerApplicationAccountService.count(new LambdaQueryWrapper<ManagerApplicationAccountEntity>()
				.eq(ManagerApplicationAccountEntity::getAccountId , userId)) ;

		ManagerApplicationAccountEntity e = new ManagerApplicationAccountEntity() ;

		e.setAccountId(userId);
		e.setApplicationId(applicationId);
		e.setAppOrder(count+1);

		managerApplicationAccountService.save(e);
	}

}
