package com.alinesno.infra.base.authority.identity.aop;

import cn.hutool.json.JSONUtil;
import com.alinesno.infra.base.authority.identity.domain.dto.AuthWebLogDto;
import com.alinesno.infra.base.authority.identity.domain.dto.LoginUser;
import com.alinesno.infra.base.authority.identity.event.AuthWebLogEvent;
import com.alinesno.infra.base.authority.identity.event.PublishService;
import com.alinesno.infra.common.core.utils.ip.IPUtils;
import io.swagger.annotations.ApiOperation;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;

/**
 * 统一日志处理切面
 */
@Slf4j
@Aspect
@Component
@Order(1)
public class AuthWebLogAspect {

    private static final String SUCCESS = "success" ;
    private static final String FAIL = "fail" ;

    @Autowired
    private PublishService publishService;

    @Pointcut("execution(public * com.alinesno.infra.base.identity.auth.controller.*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
    }

    @AfterReturning(value = "webLog()", returning = "ret")
    public void doAfterReturning(Object ret) throws Throwable {
    }

    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {

        //获取当前用户信息
        LoginUser user = LoginUser.ANON_USER ;

        Date accessDate = new Date();
        try{
            Object result = joinPoint.proceed();
            Date processEndDate = new Date();

            saveAuditLog(user, joinPoint, accessDate, processEndDate, result, null);
            return result;
        }catch (Exception e){
            Date processEndDate = new Date();
            saveAuditLog(user, joinPoint, accessDate, processEndDate, null , e);
            throw e ;
        }
    }

    /**
     * 保存审计日志
     *
     * @param user           当前登录用户
     * @param point          切面
     * @param accessDate     业务处理开始时间
     * @param processEndDate 业务处理完成时间
     * @param obj            返回值
     * @param e
     */
    private void saveAuditLog(LoginUser user, ProceedingJoinPoint point, Date accessDate, Date processEndDate, Object obj, Exception e) {

        HttpServletRequest request =
                ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();

        try {

            AuthWebLogDto webLogin = new AuthWebLogDto();

            webLogin.setUserId(user.getUserId()) ;
            webLogin.setUserName(user.getUsername());

            String userIp = IPUtils.getIpAddr(request);
            webLogin.setAccessIp(userIp);

            String accessUrl = request.getServletPath();
            webLogin.setAccessUrl(accessUrl);

            webLogin.setClassName(point.getSignature().getDeclaringTypeName());
            webLogin.setMethod(point.getSignature().getName());

            //过滤掉部分请求参数，方法参数为HttpServletRequest HttpServletResponse MultipartFile
            List<Object> filterList = Arrays.stream(point.getArgs()).filter(new Predicate<Object>() {

                @Override
                public boolean test(Object obj) {

                    return !(obj instanceof ServletRequest)
                            && !(obj instanceof ServletResponse)
                            && !(obj instanceof MultipartFile);
                }
            }).toList();

            webLogin.setRequestParam(filterList.toArray());

            //设置日志描述，形如：平台端-用户管理-新增
            webLogin.setDescription(getDescription(accessUrl, point));

            webLogin.setAccessDateTime(accessDate);

            //获取处理的毫秒数
            long executeTime = getDiffMillis(processEndDate, accessDate);
            webLogin.setExecuteTime(executeTime);

            if(obj != null){
                webLogin.setResponse(obj);
                webLogin.setStatus(SUCCESS);
            }else if(e != null){
                webLogin.setResponse(e.getMessage());
                webLogin.setStatus(FAIL);
            }

            CompletableFuture.runAsync(() -> {
                log.info("webLogin:{}", JSONUtil.toJsonPrettyStr(webLogin)) ;

                AuthWebLogEvent authWebLogEvent = new AuthWebLogEvent(webLogin) ;
                publishService.publishEvent(authWebLogEvent);
            });

        } catch (Throwable e2) {
            log.error("审计url：" + request.getServletPath() + "，推送日志异常：" + e2.getMessage());
        }

    }

    private long getDiffMillis(Date processEndDate, Date accessDate) {
        if (processEndDate == null || accessDate == null) {
            throw new IllegalArgumentException("The dates must not be null");
        }
        return Math.abs(processEndDate.getTime() - accessDate.getTime());
    }

    private String getDescription(String accessUrl, ProceedingJoinPoint joinPoint) {

        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        String desc = "" ;

        if (method.isAnnotationPresent(ApiOperation.class)) {
            ApiOperation log = method.getAnnotation(ApiOperation.class);
            desc = log.notes() ;
        }

        return desc ;
    }

}
