package com.alinesno.infra.base.authority.gateway.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Meta implements Serializable {

    private String title; // 菜单标题
    private String icon; // 菜单图标
    private boolean noCache; // 是否不缓存
    private String link; // 链接

    /**
     * 构造方法
     * 创建一个具有基本属性的菜单元信息对象。
     *
     * @param title 菜单标题
     * @param icon 菜单图标
     * @param noCache 是否不缓存
     * @param link 链接
     */
    public Meta(String title, String icon, boolean noCache, String link) {
        this.title = title;
        this.icon = icon;
        this.noCache = noCache;
        this.link = link;
    }
}
