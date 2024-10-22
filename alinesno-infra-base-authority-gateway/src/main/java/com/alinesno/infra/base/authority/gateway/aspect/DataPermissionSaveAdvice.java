package com.alinesno.infra.base.authority.gateway.aspect;

import com.alinesno.infra.base.authority.annotation.DataPermissionSave;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
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
public class DataPermissionSaveAdvice {

	@Autowired
	private HttpServletRequest request;

	// 拦截指定的方法,这里指只拦截TestService.getResultData这个方法
	@Pointcut("@annotation(com.alinesno.infra.base.authority.annotation.DataPermissionSave)")
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

		DataPermissionSave dataSave = methodClass.getAnnotation(DataPermissionSave.class); // .getAnnotations();

		for (Object argItem : args) {
			log.debug("argItem:{}", argItem);

			if (argItem instanceof InfraBaseEntity entity) { // 分页参数
				entity.setOrgId(CurrentAccountJwt.get().getOrgId());
				entity.setOperatorId(CurrentAccountJwt.getUserId());
			}
		}

	}

}
