package com.alinesno.infra.base.identity.auth.event.stream;

/**
 * 消息类型（认证过程消息/登录事件消息/登录记录消息）
 */
public class StreamConstants {

    /**
     * 认证过程消息
     */
    public static final String AUTHENTICATION_PROCESS_EVENT = "stream:infra:authentication_process";

    /**
     * 登录事件消息
     */
    public static final String LOGIN_EVENT_MESSAGE = "stream:infra:login_event";

    /**
     * 登录记录消息
     */
    public static final String LOGIN_RECORD_MESSAGE = "stream:infra:login_record";

    /**
     * 运行消息
     */
    public static final String IM_MESSAGE_LOG = "stream:infra:im_message";

}