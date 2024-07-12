package com.alinesno.infra.base.identity.auth.notices;

import org.dromara.sms4j.api.entity.SmsResponse;

/**
 * 短信服务接口定义了发送短信的方法。
 */
public interface SmsService {

    /**
     * 发送固定消息模板的短信到指定的手机号码。
     * <p>
     * 此方法会使用配置文件中预设的短信模板来进行短信发送。
     * 若使用的短信服务商允许的话，可以在消息内容中包含多个参数，用'&'符号分隔。
     * 例如："1234" + "&" + "5" 会被解析成 "您的验证码为{1}在{2}分钟内有效" 的格式。
     *
     * @param phone 接收短信的手机号码
     * @param message 要发送的文本消息内容
     * @return 短信发送响应对象
     */
    SmsResponse sendMessage(String phone, String message , String configId);
}
