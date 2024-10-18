package com.alinesno.infra.common.web.adapter.exception;

import cn.dev33.satoken.exception.NotLoginException;
import com.alinesno.infra.base.authority.security.LoginAuthException;
import com.alinesno.infra.common.core.exception.DemoModeException;
import com.alinesno.infra.common.core.exception.base.BaseException;
import com.alinesno.infra.common.core.utils.StringUtils;
import com.alinesno.infra.common.facade.exception.ServiceException;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.facade.response.HttpStatus;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.ibatis.exceptions.PersistenceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.security.auth.login.AccountExpiredException;
import java.nio.file.AccessDeniedException;

/**
 * 全局异常处理器
 * 
 * @author luoxiaodong
 * @version 1.0.0
 */
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	/**
	 * 基础异常
	 */
	@ExceptionHandler(BaseException.class)
	public AjaxResult baseException(BaseException e) {
		return AjaxResult.error(e.getMessage());
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public AjaxResult handlerNoFoundException(Exception e) {
		log.error(e.getMessage(), e);
		return AjaxResult.error(HttpStatus.NOT_FOUND, "路径不存在，请检查路径是否正确");
	}

	@ExceptionHandler({LoginAuthException.class , NotLoginException.class})
	public AjaxResult handleLoginAuthorizationException(LoginAuthException e) {
		log.error(e.getMessage());
		return AjaxResult.error(HttpStatus.UNAUTHORIZED, "用户认证失败，请重新登陆");
	}

	@ExceptionHandler(AccessDeniedException.class)
	public AjaxResult handleAuthorizationException(AccessDeniedException e) {
		log.error(e.getMessage());
		return AjaxResult.error(HttpStatus.FORBIDDEN, "没有权限，请联系管理员授权");
	}

	@ExceptionHandler(AccountExpiredException.class)
	public AjaxResult handleAccountExpiredException(AccountExpiredException e) {
		log.error(e.getMessage(), e);
		return AjaxResult.error("服务器异常，请稍后重试");
	}

	/**
	 * 持久层异常处理
	 *
	 * @param e
	 * @return
	 */
	@ExceptionHandler({ PersistenceException.class, MybatisPlusException.class })
	public AjaxResult handlePersisException(Exception e) {
		log.error(e.getMessage(), e);
		return AjaxResult.error("持久层错误，请稍后联系管理员");
	}

	/**
	 * 请求方式不支持
	 */
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public AjaxResult handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e,
														  HttpServletRequest request)
	{
		String requestURI = request.getRequestURI();
		log.error("请求地址'{}',不支持'{}'请求", requestURI, e.getMethod());
		return AjaxResult.error(e.getMessage());
	}

	/**
	 * 业务异常
	 */
	@ExceptionHandler(ServiceException.class)
	public AjaxResult handleServiceException(ServiceException e, HttpServletRequest request)
	{
		log.error(e.getMessage(), e);
		Integer code = e.getCode();
		return StringUtils.isNotNull(code) ? AjaxResult.error(code, e.getMessage()) : AjaxResult.error(e.getMessage());
	}

	/**
	 * 拦截未知的运行时异常
	 */
	@ExceptionHandler(RuntimeException.class)
	public AjaxResult handleRuntimeException(RuntimeException e, HttpServletRequest request)
	{
		String requestURI = request.getRequestURI();
		log.error("请求地址'{}',发生未知异常.", requestURI, e);
		return AjaxResult.error(e.getMessage());
	}

	/**
	 * 系统异常
	 */
	@ExceptionHandler(Exception.class)
	public AjaxResult handleException(Exception e, HttpServletRequest request)
	{
		String requestURI = request.getRequestURI();
		log.error("请求地址'{}',发生系统异常.", requestURI, e);
		return AjaxResult.error(e.getMessage());
	}

	/**
	 * 自定义验证异常
	 */
	@ExceptionHandler(BindException.class)
	public AjaxResult handleBindException(BindException e)
	{
		log.error(e.getMessage(), e);
		String message = e.getAllErrors().get(0).getDefaultMessage();
		return AjaxResult.error(message);
	}

	/**
	 * 自定义验证异常
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Object handleMethodArgumentNotValidException(MethodArgumentNotValidException e)
	{
		log.error(e.getMessage(), e);
		String message = e.getBindingResult().getFieldError().getDefaultMessage();
		return AjaxResult.error(message);
	}

	/**
	 * 演示模式异常
	 */
	@ExceptionHandler(DemoModeException.class)
	public AjaxResult handleDemoModeException(DemoModeException e)
	{
		return AjaxResult.error("演示模式，不允许操作");
	}
}
