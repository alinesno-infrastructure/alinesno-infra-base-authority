package com.alinesno.infra.base.authority.security.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Security 配置属性
 *
 * @author Lion Li
 */
@Data
@ConfigurationProperties(prefix = "alinesno.security")
public class SecurityProperties {

    /**
     * 排除路径
     */
    private String[] excludes;


}
