package com.alinesno.infra.base.authority.identity.utils;

import com.alinesno.infra.base.authority.api.identity.RegisterDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class RegisterValidator {

    // 手机号正则表达式
    private static final Pattern PHONE_PATTERN = Pattern.compile("^1[3-9]\\d{9}$");
    // 密码正则表达式（增强：包含大小写字母+数字+特殊字符）
    private static final Pattern PASSWORD_PATTERN = 
        Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");

    /**
     * 基础信息校验（手机号、密码格式、密码一致性）
     */
    public void validateBaseInfo(RegisterDto dto) {
        if (!PHONE_PATTERN.matcher(dto.getPhone()).matches()) {
            throw new IllegalArgumentException("手机号格式错误");
        }
        if (!PASSWORD_PATTERN.matcher(dto.getPassword()).matches()) {
            throw new IllegalArgumentException("密码需8-20位，包含大小写字母、数字和特殊字符");
        }
        if (!dto.getPassword().equals(dto.getConfirmPassword())) {
            throw new IllegalArgumentException("两次密码不一致");
        }
    }

    /**
     * 危险字符校验（增强版，防御SQL注入/XSS）
     */
    public boolean containsSecurityRisk(String input) {
        String riskPattern = "<|>|'|\"|;|--|\\|\\|"; // 常见攻击字符
        return Pattern.compile(riskPattern).matcher(input).find();
    }

    /**
     * 获取客户端 IP 地址
     */
    public String getClientIp(HttpServletRequest request) {
        String xffHeader = request.getHeader("X-Forwarded-For");
        if (xffHeader == null) {
            return request.getRemoteAddr();
        }
        return xffHeader.split(",")[0];
    }

    /**
     * 解析User-Agent获取浏览器和操作系统（简化实现，可使用成熟库如UA-parser）
     */
    public String[] parseUserAgent(String ua) {
        String browser = "Unknown";
        String os = "Unknown";

        if (ua != null) {
            // 浏览器检测
            if (ua.contains("Chrome")) browser = "Chrome";
            else if (ua.contains("Firefox")) browser = "Firefox";
            else if (ua.contains("Safari")) browser = "Safari";
            else if (ua.contains("Edge")) browser = "Edge";
            else if (ua.contains("Android")) browser = "Android Browser";
            else if (ua.contains("iOS")) browser = "iOS Safari";

            // 操作系统检测
            if (ua.contains("Windows")) os = "Windows";
            else if (ua.contains("Mac")) os = "macOS";
            else if (ua.contains("Linux")) os = "Linux";
            else if (ua.contains("Android")) os = "Android";
            else if (ua.contains("iOS")) os = "iOS";
        }
        return new String[]{browser, os};
    }
}    