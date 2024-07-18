package com.alinesno.infra.base.authority.gateway.session;

import com.alinesno.infra.base.authority.entity.ManagerProjectAccountEntity;
import com.alinesno.infra.base.authority.entity.ManagerProjectEntity;
import com.alinesno.infra.base.authority.service.IManagerProjectAccountService;
import com.alinesno.infra.base.authority.service.IManagerProjectService;
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
public class CurrentProjectSession {

	@Autowired
	private IManagerProjectAccountService managerApplicationAccountService ;

	@Autowired
	private IManagerProjectService managerProjectService ;

	public ManagerProjectEntity get() {
		long userId = CurrentAccountJwt.getUserId();
		return managerProjectService.getApplicationByAccountId(userId) ;
	}

	public void set(long applicationId) {

		long userId = CurrentAccountJwt.getUserId();

		// 查询当前用户配置记录
		long count = managerApplicationAccountService.count(new LambdaQueryWrapper<ManagerProjectAccountEntity>()
				.eq(ManagerProjectAccountEntity::getAccountId , userId)) ;

		ManagerProjectAccountEntity e = new ManagerProjectAccountEntity() ;

		e.setAccountId(userId);
		e.setApplicationId(applicationId);
		e.setAppOrder(count+1);

		managerApplicationAccountService.save(e);
	}

}
