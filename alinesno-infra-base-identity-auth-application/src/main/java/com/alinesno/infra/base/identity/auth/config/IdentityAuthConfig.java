package com.alinesno.infra.base.identity.auth.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 读取项目相关配置
 * 
 * @author luoxiaodong
 */
@Component
@Data
@ConfigurationProperties(prefix = "identity.auth")
public class IdentityAuthConfig {

    /** 系统logo */
    private String logo ;

    /** 系统名称 */
    private String systemName;

    /** 系统描述 */
    private String bannerInfo ;

    /** 版本 */
    private String version;

    /** 版权年份 */
    private String copyrightYear;

    /** 权限说明 */
    private String copyrightLabel ;

    /** 官网地址 */
    private String portalSite ;

}
