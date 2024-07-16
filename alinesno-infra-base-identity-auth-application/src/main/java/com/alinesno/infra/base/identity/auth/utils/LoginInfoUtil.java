package com.alinesno.infra.base.identity.auth.utils;

import cn.dev33.satoken.session.SaSession;
import com.alinesno.infra.base.identity.auth.constants.AuthConstants;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.util.StringUtils;

/**
 * 登录信息工具类
 * 该类提供了一系列方法来处理和管理用户的登录信息。
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
public class LoginInfoUtil {

    /**
     * 处理登录信息，记录用户登录时的浏览器名称、操作系统名称和IP地址。
     * 这些信息对于安全审计和用户行为分析是有用的。
     *
     * @param session           用户的会话对象，用于存储会话级别的信息。
     * @param request           HTTP请求对象，从中提取浏览器、操作系统和IP地址信息。
     */
    public static void handleLoginInfo(SaSession session, HttpServletRequest request) {

        // 获取用户使用的浏览器名称
        String browserName = browserName(request) ;
        // 获取用户操作系统的名称
        String osName = osName(request) ;
        // 获取用户的IP地址
        String ipAddress = getIpAddress(request) ;
        String ipArea = "" ;

        // 将浏览器名称、操作系统名称和IP地址保存到用户的会话中
        session.set(AuthConstants.browser , browserName) ;
        session.set(AuthConstants.osName, osName) ;
        session.set(AuthConstants.loginIP, ipAddress) ;
        session.set(AuthConstants.loginIP_AREA, StringUtils.hasLength(ipArea)?ipArea:"未知区域") ;

    }

    /**
     * 获取浏览器名称及版本
     * @param request
     * @return
     */
    public static String browserName(HttpServletRequest request){
        String userAgent = request.getHeader("User-Agent");
        UserAgent ua = UserAgent.parseUserAgentString(userAgent);
        Browser browser = ua.getBrowser();
        return browser.getName() + "-" + browser.getVersion(userAgent);
    }

    /**
     * 获取操作系统名称
     * @param request
     * @return
     */
    public static String osName(HttpServletRequest request){
        String userAgent = request.getHeader("User-Agent");
        UserAgent ua = UserAgent.parseUserAgentString(userAgent);
        OperatingSystem os = ua.getOperatingSystem();
        return os.getName() + "/" + os.getDeviceType() + "/" + os.getManufacturer();
    }

    /**
     * 获取IP地址
     * @param request
     * @return
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_CLUSTER_CLIENT_IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_FORWARDED_FOR");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_FORWARDED");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_VIA");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("REMOTE_ADDR");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.contains(",")) {
            return ip.split(",")[0];
        } else {
            return ip;
        }
    }
}
