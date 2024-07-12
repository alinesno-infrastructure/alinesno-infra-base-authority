package com.alinesno.infra.base.identity.auth.event;

import com.alinesno.infra.base.identity.auth.event.stream.RedisStreamPushUtils;
import com.alinesno.infra.base.identity.auth.event.stream.StreamConstants;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GeneralEventListener implements ApplicationListener<BaseEvent> {

    @Autowired
    private RedisStreamPushUtils redisStreamPushUtils ;

    @Override
    public void onApplicationEvent(@NotNull BaseEvent event) {

        log.debug("GeneralEventListener name = {}" ,event.getClass().getSimpleName());
        log.debug(Thread.currentThread().getName()+" , GeneralEventListener userName="+event.getSource());

        if(event instanceof LoginTypeEvent){
            redisStreamPushUtils.pushTask(event.getSource() , StreamConstants.LOGIN_EVENT_MESSAGE);
        }else if(event instanceof LoginRecordEvent){
            redisStreamPushUtils.pushTask(event.getSource() , StreamConstants.LOGIN_RECORD_MESSAGE);
        }else if(event instanceof AuthWebLogEvent){
            log.debug("event message = {}" , event.getSource());
            redisStreamPushUtils.pushTask(event.getSource() , StreamConstants.AUTHENTICATION_PROCESS_EVENT);
        }

    }
}