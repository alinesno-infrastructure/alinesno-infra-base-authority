package com.alinesno.infra.base.authority.security;

import cn.hutool.core.util.ReUtil;
import com.alinesno.infra.common.web.log.utils.SpringUtils;
import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.*;
import java.util.regex.Pattern;

/**
 * 获取所有Url配置
 *
 * @author Lion Li
 */
@Data
@Component
public class AllUrlHandler implements InitializingBean {

    /**
     * 配置常量，用于匹配路径中的占位符。
     */
    private static final Pattern PATTERN = Pattern.compile("\\{(.*?)\\}");

    /**
     * 存储处理的URL路径。
     */
    private List<String> urls = new ArrayList<>();

    /**
     * 初始化方法，用于收集所有映射的URL路径。
     * 该方法会遍历所有的@RequestMapping注解，将路径中占位符替换为通配符"*"，
     * 并将处理后的URL路径存储到urls列表中。
     */
    @Override
    public void afterPropertiesSet() {
        Set<String> set = new HashSet<>();

        // 通过SpringUtils获取RequestMappingHandlerMapping实例
        RequestMappingHandlerMapping mapping = SpringUtils.getBean("requestMappingHandlerMapping", RequestMappingHandlerMapping.class);

        // 获取所有映射方法的信息
        Map<RequestMappingInfo, HandlerMethod> map = mapping.getHandlerMethods();

        // 遍历所有映射信息，提取URL路径
        map.keySet().forEach(info -> {

            // 断言PathPatternsCondition不为空
            // 获取注解上边的 path 替代 path variable 为 *
            // assert info.getPathPatternsCondition() != null;

            if(info.getPathPatternsCondition() != null){
                // 遍历每个路径模式，替换占位符为通配符
                Objects.requireNonNull(info.getPathPatternsCondition().getPatterns())
                        .forEach(url -> set.add(ReUtil.replaceAll(url.getPatternString(), PATTERN, "*")));
            }

        });

        // 将处理后的URL路径添加到列表中
        urls.addAll(set);

    }


}
