package com.alinesno.infra.common.web.adapter.dto.menus;

import lombok.Data;

import java.util.List;

/**
 * 菜单信息类
 * 用于表示系统的菜单结构，包含菜单的基本属性以及子菜单的列表。
 */
@Data
public class Menu {

    private String name; // 菜单名称
    private String path; // 菜单路径
    private boolean hidden; // 是否隐藏菜单
    private String redirect; // 重定向路径
    private String component; // 组件路径
    private boolean alwaysShow; // 是否总是显示
    private Meta meta; // 菜单元信息
    private String perms ; // 权限标识
    private List<Menu> children; // 子菜单列表

    /**
     * 构造方法
     * 创建一个具有基本属性的菜单对象。
     *
     * @param name 菜单名称
     * @param component 组件路径
     * @param hidden 是否隐藏菜单
     * @param path 菜单路径
     * @param meta 菜单元信息
     */
    public Menu(String name, String component, boolean hidden, String path, Meta meta) {
        this.name = name;
        this.path = path;
        this.hidden = hidden;
        this.component = component;
        this.alwaysShow = true;
        this.meta = meta;
    }

    public Menu(String perms , Meta meta) {
        this.perms = perms;
        this.alwaysShow = true;
        this.meta = meta;
    }

    /**
     * 构造方法
     * 创建一个具有基本属性和是否总是显示属性的菜单对象。
     *
     * @param name 菜单名称
     * @param component 组件路径
     * @param hidden 是否隐藏菜单
     * @param alwaysShow 是否总是显示
     * @param path 菜单路径
     * @param meta 菜单元信息
     */
    public Menu(String name, String component, boolean hidden, boolean alwaysShow , String path, Meta meta) {
        this.name = name;
        this.path = path;
        this.hidden = hidden;
        this.component = component;
        this.alwaysShow = alwaysShow;
        this.meta = meta;
    }

    /**
     * 构造方法
     * 创建一个具有基本属性、是否总是显示属性和子菜单列表的菜单对象。
     *
     * @param name 菜单名称
     * @param component 组件路径
     * @param hidden 是否隐藏菜单
     * @param alwaysShow 是否总是显示
     * @param path 菜单路径
     * @param meta 菜单元信息
     * @param children 子菜单列表
     */
    public Menu(String name, String component, boolean hidden, boolean alwaysShow , String path, Meta meta, List<Menu> children) {
        this.name = name;
        this.path = path;
        this.hidden = hidden;
        this.component = component;
        this.alwaysShow = alwaysShow;
        this.meta = meta;
        this.children = children;
    }

    /**
     * 构造方法
     * 创建一个具有完整属性的菜单对象。
     *
     * @param name 菜单名称
     * @param path 菜单路径
     * @param hidden 是否隐藏菜单
     * @param redirect 重定向路径
     * @param component 组件路径
     * @param alwaysShow 是否总是显示
     * @param meta 菜单元信息
     * @param children 子菜单列表
     */
    public Menu(String name, String path, boolean hidden, String redirect, String component, boolean alwaysShow, Meta meta, List<Menu> children) {
        this.name = name;
        this.path = path;
        this.hidden = hidden;
        this.redirect = redirect;
        this.component = component;
        this.alwaysShow = alwaysShow;
        this.meta = meta;
        this.children = children;
    }

    /**
     * 构造方法
     * 创建一个具有完整属性的菜单对象。
     *
     * @param name 菜单名称
     * @param path 菜单路径
     * @param hidden 是否隐藏菜单
     * @param redirect 重定向路径
     * @param component 组件路径
     * @param alwaysShow 是否总是显示
     * @param meta 菜单元信息
     */
    public Menu(String name, String path, boolean hidden, String redirect, String component, boolean alwaysShow, Meta meta) {
        this.name = name;
        this.path = path;
        this.hidden = hidden;
        this.redirect = redirect;
        this.component = component;
        this.alwaysShow = alwaysShow;
        this.meta = meta;
    }

    @Data
    public static class Meta {
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
}
