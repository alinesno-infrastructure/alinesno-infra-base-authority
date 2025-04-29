package com.alinesno.infra.base.authority.datascope.aspect;

import com.alinesno.infra.base.authority.datascope.annotation.DataPermissionScope;
import com.alinesno.infra.base.authority.datascope.utils.RolePowerUtils;
import com.alinesno.infra.base.authority.enums.DataSourceScope;
import com.alinesno.infra.common.facade.pageable.ConditionDto;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.web.adapter.base.dto.ManagerAccountDto;
import com.alinesno.infra.common.web.adapter.login.account.CurrentAccountJwt;
import com.alinesno.infra.common.web.log.utils.SpringUtils;
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
public class DataPermissionScopeAdvice {

	@Autowired
	private HttpServletRequest request;

	// 拦截指定的方法,这里指只拦截TestService.getResultData这个方法
	@Pointcut("@annotation(com.alinesno.infra.base.authority.datascope.annotation.DataPermissionScope)")
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

		DataPermissionScope dataFilter = methodClass.getAnnotation(DataPermissionScope.class); // .getAnnotations();
		String beanName = dataFilter.roleBean();

		DataSourceScope type = dataFilter.scope();
		log.debug("data filter type :{} , request:{}", type, request);

		for (Object argItem : args) {
			log.debug("argItem:{}", argItem);

			if (argItem instanceof DatatablesPageBean page) { // 分页参数
				filterDataParams(page, type, beanName);
			}
		}

	}

	/**
	 * 添加过滤参数
	 * 
	 * @param page
	 * @param type
	 */
	private void filterDataParams(DatatablesPageBean page, DataSourceScope type, String beanName) {

		// 获取当前用户
		ManagerAccountDto account = CurrentAccountJwt.get();

		if(RolePowerUtils.isAdmin(account.getRolePower())){
			return ;
		}


		ConditionDto conditionDto = new ConditionDto();

		if (type == DataSourceScope.PERSONAL_SCOPE) { // 用户权限

			conditionDto.setColumn(type.getField());
			conditionDto.setValue(String.valueOf(account.getUserId()));

		} else if (type == DataSourceScope.DEPARTMENT_SCOPE) { // 部门权限

			conditionDto.setColumn(type.getField());
			conditionDto.setValue(String.valueOf(account.getDepartmentId()));

		} else if (type == DataSourceScope.ORGANIZATIONAL_SCOPE) { // 组织权限

			conditionDto.setColumn(type.getField());
			conditionDto.setValue(String.valueOf(account.getOrgId()));

		} else if (type == DataSourceScope.PROJECT_SCOPE) { // 应用权限

			conditionDto.setColumn(type.getField());
			conditionDto.setValue(String.valueOf(account.getApplicationId()));

		} else if (type == DataSourceScope.CUSTOM_SCOPE) { // 自定义权限
			if (beanName != null) {
				try {
					DataPermissionParent p = SpringUtils.getBean(beanName);
					p.filterMap(conditionDto, account);
				} catch (Exception e) {
					log.error("实例化对象【" + beanName + "】异常", e);
				}
			} else {
				log.warn("自定义数据过滤为空.");
			}
		}

		conditionDto.setType("eq");
		page.getConditionList().add(conditionDto);
	}

}
