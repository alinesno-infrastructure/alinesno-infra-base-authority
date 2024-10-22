package com.alinesno.infra.base.authority.gateway.aspect;

import com.alinesno.infra.base.authority.annotation.DataPermissionQuery;
import com.alinesno.infra.base.authority.annotation.PermissionQuery;
import com.alinesno.infra.base.authority.enums.DataSourceScope;
import com.alinesno.infra.common.web.adapter.login.account.CurrentAccountJwt;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 数据权限过滤
 * 
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@Slf4j
@Component
@Aspect
public class DataPermissionQueryAdvice {

	@Autowired
	private HttpServletRequest request;

	// 拦截指定的方法,这里指只拦截TestService.getResultData这个方法
	@Pointcut("@annotation(com.alinesno.infra.base.authority.annotation.DataPermissionQuery)")
	public void pointcut() {

	}

	// 执行方法前的拦截方法
	@SuppressWarnings("rawtypes")
	@Before("pointcut()")
	public void doBeforeMethod(JoinPoint joinPoint) throws NoSuchMethodException, SecurityException {

		// 获取目标方法的参数信息
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs(); // 请求接收的参数args
		Class<?> targetClass = joinPoint.getTarget().getClass();
		Class[] parameterTypes = ((MethodSignature) joinPoint.getSignature()).getParameterTypes();
		Method methodClass = targetClass.getMethod(methodName, parameterTypes);

		DataPermissionQuery dataQuery = methodClass.getAnnotation(DataPermissionQuery.class); // .getAnnotations();
		DataSourceScope type = dataQuery.scope();
		log.debug("data filter type :{} , request:{}", type, request);

		for (Object argItem : args) {
			log.debug("argItem:{}", argItem);

			if (argItem instanceof PermissionQuery query) { // 分页参数
				query.setType(dataQuery.scope());
				query.setOrgId(CurrentAccountJwt.get().getOrgId());
				query.setOperatorId(CurrentAccountJwt.getUserId());
			}
		}

	}

}
