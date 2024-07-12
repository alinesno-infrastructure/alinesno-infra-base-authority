package com.alinesno.infra.base.identity.auth.event.stream;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.stream.Record;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RedisStreamPushUtils {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 推送消息内容
     * @param msgContext
     * @param topic
     */
    public void pushTask(Object msgContext , String topic){
        stringRedisTemplate.opsForStream().add(Record.of(JSONObject.toJSONString(msgContext)).withStreamKey(topic));
        log.info("{}已发送消息:{}", topic,msgContext);
    }

}
