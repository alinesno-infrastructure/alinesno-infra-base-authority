package com.alinesno.infra.base.authority.gateway.controller;

import com.alinesno.infra.base.authority.api.dto.CacheListInfoVo;
import com.alinesno.infra.base.authority.api.dto.SysCacheVo;
import com.alinesno.infra.common.core.constants.CacheConstants;
import com.alinesno.infra.common.core.utils.StringUtils;
import com.alinesno.infra.common.facade.response.AjaxResult;
import lombok.RequiredArgsConstructor;
import org.redisson.spring.data.connection.RedissonConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 缓存监控
 *
 * @author Lion Li
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/monitor/cache")
public class CacheController {

    private final RedissonConnectionFactory connectionFactory;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private final static List<SysCacheVo> caches = new ArrayList<SysCacheVo>();{
        caches.add(new SysCacheVo(CacheConstants.SYS_CONFIG_KEY, "配置信息"));
        caches.add(new SysCacheVo(CacheConstants.SYS_DICT_KEY, "数据字典"));
        caches.add(new SysCacheVo(CacheConstants.CAPTCHA_CODE_KEY, "验证码"));
        caches.add(new SysCacheVo(CacheConstants.REPEAT_SUBMIT_KEY, "防重提交"));
        caches.add(new SysCacheVo(CacheConstants.RATE_LIMIT_KEY, "限流处理"));
        caches.add(new SysCacheVo(CacheConstants.PWD_ERR_CNT_KEY, "密码错误次数"));
    }

    /**
     * 获取缓存监控列表
     */
//    @SaCheckPermission("monitor:cache:list")
    @GetMapping()
    public AjaxResult getInfo() throws Exception {
        RedisConnection connection = connectionFactory.getConnection();
        Properties commandStats = connection.commands().info("commandstats");

        List<Map<String, String>> pieList = new ArrayList<>();
        if (commandStats != null) {
            commandStats.stringPropertyNames().forEach(key -> {
                Map<String, String> data = new HashMap<>(2);
                String property = commandStats.getProperty(key);
                data.put("name", StringUtils.removeStart(key, "cmdstat_"));
                data.put("value", StringUtils.substringBetween(property, "calls=", ",usec"));
                pieList.add(data);
            });
        }

        CacheListInfoVo infoVo = new CacheListInfoVo();
        infoVo.setInfo(connection.commands().info());
        infoVo.setDbSize(connection.commands().dbSize());
        infoVo.setCommandStats(pieList);

        return AjaxResult.success(infoVo);
    }

    @GetMapping("/getNames")
    public AjaxResult cache()
    {
        return AjaxResult.success(caches);
    }

    @GetMapping("/getKeys/{cacheName}")
    public AjaxResult getCacheKeys(@PathVariable String cacheName)
    {
        Set<String> cacheKeys = redisTemplate.keys(cacheName + "*");
        return AjaxResult.success(cacheKeys);
    }

    @GetMapping("/getValue/{cacheName}/{cacheKey}")
    public AjaxResult getCacheValue(@PathVariable String cacheName, @PathVariable String cacheKey)
    {
        String cacheValue = redisTemplate.opsForValue().get(cacheKey);
        SysCacheVo sysCache = new SysCacheVo(cacheName, cacheKey, cacheValue);
        return AjaxResult.success(sysCache);
    }

    @DeleteMapping("/clearCacheName/{cacheName}")
    public AjaxResult clearCacheName(@PathVariable String cacheName)
    {
        Collection<String> cacheKeys = redisTemplate.keys(cacheName + "*");
        redisTemplate.delete(cacheKeys);
        return AjaxResult.success();
    }

    @DeleteMapping("/clearCacheKey/{cacheKey}")
    public AjaxResult clearCacheKey(@PathVariable String cacheKey)
    {
        redisTemplate.delete(cacheKey);
        return AjaxResult.success();
    }

    @DeleteMapping("/clearCacheAll")
    public AjaxResult clearCacheAll()
    {
        Collection<String> cacheKeys = redisTemplate.keys("*");
        redisTemplate.delete(cacheKeys);
        return AjaxResult.success();
    }

}
