package com.alinesno.infra.base.authority.core.utils;

import jakarta.servlet.http.HttpServletRequest;

import java.util.regex.Pattern;

public class DeviceTypeUtils {

    public static final String DEVICE_PC = "PC";
    public static final String DEVICE_IPAD = "IPad";
    public static final String DEVICE_IPHONE = "IPhone";
    public static final String DEVICE_ANDROID = "Android";
    public static final String DEVICE_WINDOWS = "Windows";
    public static final String DEVICE_MACOS = "MacOS";
    public static final String DEVICE_LINUX = "Linux";

    // 简单的移动网络 IP 段正则匹配，实际应用中需要更完善的规则
    private static final Pattern MOBILE_IP_PATTERN = Pattern.compile("^(10\\.|172\\.(1[6-9]|2[0-9]|3[0-1])\\.|192\\.168\\.)");

    /**
     * 根据请求头中的 User-Agent 和 IP 地址判断设备类型
     *
     * @param request HttpServletRequest 对象
     * @return 设备类型字符串
     */
    public static String getDeviceType(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        String ipAddress = getClientIpAddress(request);

        if (userAgent == null) {
            return DEVICE_PC;
        }
        userAgent = userAgent.toLowerCase();

        if (userAgent.contains("ipad")) {
            return DEVICE_IPAD;
        } else if (userAgent.contains("iphone")) {
            return DEVICE_IPHONE;
        } else if (userAgent.contains("android")) {
            return DEVICE_ANDROID;
        } else if (userAgent.contains("windows")) {
            return DEVICE_WINDOWS;
        } else if (userAgent.contains("mac os")) {
            return DEVICE_MACOS;
        } else if (userAgent.contains("linux")) {
            return DEVICE_LINUX;
        }

        // 如果 User-Agent 判断不出来，尝试根据 IP 地址判断
        if (MOBILE_IP_PATTERN.matcher(ipAddress).find()) {
            return DEVICE_ANDROID; // 这里只是简单示例，实际可能是其他移动设备
        }

        return DEVICE_PC;
    }

    /**
     * 获取客户端 IP 地址
     *
     * @param request HttpServletRequest 对象
     * @return 客户端 IP 地址
     */
    private static String getClientIpAddress(HttpServletRequest request) {
        String xffHeader = request.getHeader("X-Forwarded-For");
        if (xffHeader == null) {
            return request.getRemoteAddr();
        }
        return xffHeader.split(",")[0];
    }
}    