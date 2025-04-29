package com.alinesno.infra.base.authority.identity.controller.manager;

import com.alinesno.infra.base.authority.api.identity.RegisterDto;
import com.alinesno.infra.base.authority.gateway.dto.AuthManagerAccountDto;
import com.alinesno.infra.base.authority.identity.service.IRegisterLogService;
import com.alinesno.infra.base.authority.identity.utils.RegisterValidator;
import com.alinesno.infra.base.authority.service.IManagerAccountService;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.facade.response.AjaxResult;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * 用户注册（参数完全匹配版）
 */
@Slf4j
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
public class RegisterController {

    @Autowired
    private IManagerAccountService managerAccountService;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private IRegisterLogService registerLogService;

    @Autowired
    private RegisterValidator registerValidator;

    // 限流配置
    private static final int RATE_LIMIT_TIME = 60;
    private static final int RATE_LIMIT_COUNT = 5;

    @PostMapping("/identityRegister")
    public AjaxResult register(@RequestBody @Validated RegisterDto dto, HttpServletRequest request) {
        String clientIp = registerValidator.getClientIp(request);
        String userAgent = request.getHeader("User-Agent");
        String sourceChannel = request.getHeader("Source-Channel");

        try {
            // 1. 限流校验（失败场景：传递 errorDetail=null，exceptionStack=null）
            if (!isRateLimited(clientIp)) {
                String errorMsg = "请求过于频繁，请稍后再试（IP:" + clientIp + "）";
                logRegisterLog(
                        dto, request, false, errorMsg,
                        errorMsg,  // errorDetail 为具体错误信息
                        null,      // exceptionStack 无异常堆栈（业务限流，非异常）
                        userAgent,
                        sourceChannel
                );
                return AjaxResult.error(errorMsg);
            }

            // 2. 基础信息校验（可能抛出业务异常）
            registerValidator.validateBaseInfo(dto);

            // 3. 手机号唯一性校验（失败场景：传递 errorDetail=错误信息，exceptionStack=null）
            if (managerAccountService.isPhoneExists(dto.getPhone())) {
                String errorMsg = "手机号已注册：" + dto.getPhone();
                logRegisterLog(
                        dto, request, false, errorMsg,
                        errorMsg,  // errorDetail
                        null,      // exceptionStack 无异常
                        userAgent,
                        sourceChannel
                );
                return AjaxResult.error(errorMsg);
            }

            // 4. 危险字符校验（失败场景：传递 errorDetail=错误信息，exceptionStack=null）
            if (registerValidator.containsSecurityRisk(dto.getPhone()) ||
                    registerValidator.containsSecurityRisk(dto.getPassword())) {
                String errorMsg = "输入包含危险字符";
                logRegisterLog(
                        dto, request, false, errorMsg,
                        errorMsg,  // errorDetail
                        null,      // exceptionStack 无异常
                        userAgent,
                        sourceChannel
                );
                return AjaxResult.error(errorMsg);
            }

            // 5. 业务处理（注册逻辑，可能抛出业务异常）
            AuthManagerAccountDto account = managerAccountService.findByLoginNameWithRegister(
                    dto.getPhone(),
                    dto.getPassword() ,
                    "account");

            log.debug("注册成功：{}" , account);

            // 6. 成功日志（传递 errorDetail=null，exceptionStack=null）
            logRegisterLog(
                    dto, request, true, "注册成功",
                    null,      // errorDetail 无
                    null,      // exceptionStack 无
                    userAgent,
                    sourceChannel
            );
            return AjaxResult.success();

        } catch (Exception e) {  // 7. 全局异常捕获（技术异常，记录堆栈）
            String errorMsg = "注册失败：" + e.getMessage();
            log.error("注册异常", e);
            logRegisterLog(
                    dto, request, false, errorMsg,
                    e.getMessage(),          // errorDetail 为异常信息
                    getStackTrace(e),        // exceptionStack 为堆栈字符串
                    userAgent,
                    sourceChannel
            );
            return AjaxResult.error(errorMsg);
        }
    }

    /**
     * 限流验证
     */
    private boolean isRateLimited(String clientIp) {
        String key = "rate_limit:" + clientIp;
        Integer count = (Integer) redisTemplate.opsForValue().get(key);
        if (count == null) {
            redisTemplate.opsForValue().set(key, 1, RATE_LIMIT_TIME, TimeUnit.SECONDS);
            return true;
        }
        if (count < RATE_LIMIT_COUNT) {
            redisTemplate.opsForValue().increment(key);
            return true;
        }
        return false;
    }

    /**
     * 记录注册日志（严格匹配 8 个参数）
     */
    private void logRegisterLog(
            RegisterDto dto,
            HttpServletRequest request,
            boolean isSuccess,
            String message,
            String errorDetail,    // 第 5 个参数：错误详情（业务/技术错误）
            String exceptionStack, // 第 6 个参数：异常堆栈（仅技术异常时有值）
            String userAgent,      // 第 7 个参数：原始 User-Agent
            String sourceChannel   // 第 8 个参数：来源渠道
    ) {
        // 解析客户端信息（浏览器/操作系统）
        String[] clientInfo = registerValidator.parseUserAgent(userAgent);
        String browserInfo = clientInfo[0];
        String osInfo = clientInfo[1];

        // 调用日志服务（参数顺序与实体类字段严格对应）
        registerLogService.saveRegisterLog(
                dto.getPhone(),
                registerValidator.getClientIp(request),
                isSuccess,
                message,
                errorDetail != null ? errorDetail : "",
                exceptionStack != null ? exceptionStack : "",
                browserInfo,
                osInfo,
                sourceChannel != null ? sourceChannel : "UNKNOWN"
        );
    }

    /**
     * 获取异常堆栈字符串（避免直接使用 e.getStackTrace().toString()）
     */
    private String getStackTrace(Exception e) {
        StringBuilder stackTrace = new StringBuilder();
        for (StackTraceElement element : e.getStackTrace()) {
            stackTrace.append(element.toString()).append("\n");
        }
        return stackTrace.toString();
    }
}