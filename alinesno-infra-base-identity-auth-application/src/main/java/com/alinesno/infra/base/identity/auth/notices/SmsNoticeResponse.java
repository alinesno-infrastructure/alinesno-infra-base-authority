package com.alinesno.infra.base.identity.auth.notices;

import lombok.Data;

import java.io.Serializable;

/**
 * 短信返回信息
 */
@Data
public class SmsNoticeResponse implements Serializable {

    private boolean success;
    private Object data;
    private String configId;

}
