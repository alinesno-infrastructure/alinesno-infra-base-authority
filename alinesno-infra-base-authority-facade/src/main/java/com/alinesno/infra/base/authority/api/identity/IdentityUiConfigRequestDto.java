package com.alinesno.infra.base.authority.api.identity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

/**
 * 该类表示单点登录服务的配置数据传输对象（DTO）。
 * 包含了单点登录服务的相关配置信息，如背景图片、logo、系统名称等。
 */
@Data
public class IdentityUiConfigRequestDto {

    @NotBlank(message = "登录页面的背景图片 URL 不能为空")
    private String backgroundImage; // 登录页面的背景图片 URL

    @NotBlank(message = "系统的 logo 图片 URL 不能为空")
    private String logo; // 系统的 logo 图片 URL

    @NotBlank(message = "系统的名称不能为空")
    private String systemName; // 系统的名称，即单点登录服务的名称

    @NotBlank(message = "登录页面横幅的信息描述不能为空")
    private String bannerInfo; // 登录页面横幅的信息描述

    @NotBlank(message = "系统版本号不能为空")
    private String version; // 系统的版本号

    @NotBlank(message = "版权年份范围不能为空")
    private String copyrightYear; // 版权年份范围

    @NotBlank(message = "版权标签不能为空")
    private String copyrightLabel; // 版权标签，包含版权所有信息和 ICP 证号

    @NotBlank(message = "系统门户的站点 URL 不能为空")
    private String portalSite; // 系统门户的站点 URL

}