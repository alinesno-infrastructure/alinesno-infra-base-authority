package com.alinesno.infra.base.authority.config;

import com.alinesno.infra.base.authority.entity.ManagerAccountEntity;
import com.alinesno.infra.base.authority.service.IManagerAccountService;
import com.alinesno.infra.common.web.adapter.login.account.CurrentAccountBean;
import com.alinesno.infra.common.web.adapter.login.account.CurrentAccountJwt;
import com.alinesno.infra.common.web.adapter.login.annotation.CurrentAccount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 当前登录用户Resolver
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Slf4j
public class AuthCurrentAccountMethodArgumentResolver implements HandlerMethodArgumentResolver {

	@Autowired
	private IManagerAccountService accountService;

	@Override
	public boolean supportsParameter(MethodParameter methodParameter) {
		// 判断方法参数是否带有@CurrentUser注解且参数类型为User或其子类
		return methodParameter.hasParameterAnnotation(CurrentAccount.class);
	}

	@Override
	public CurrentAccountBean resolveArgument(MethodParameter methodParameter,
											  ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest,
											  WebDataBinderFactory webDataBinderFactory) throws Exception {

		// 获取当前登录用户
		long userId = CurrentAccountJwt.getUserId() ;

		ManagerAccountEntity account = accountService.getById(userId) ;
		if (account == null) {
			log.warn("获取当前用户信息失败:{}" , userId);
			return null ;
		}

		CurrentAccountBean currentAccountBean = new CurrentAccountBean() ;

		currentAccountBean.setId(account.getId());
		currentAccountBean.setName(account.getName());
		currentAccountBean.setPhone(account.getPhone());
		currentAccountBean.setEmail(account.getEmail());

		log.debug("当前用户ID:{}", userId);

		return currentAccountBean ;

	}

}