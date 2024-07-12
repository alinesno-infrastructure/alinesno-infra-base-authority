package com.alinesno.infra.base.authority.api;

import lombok.Data;

import java.io.Serializable;

@Data
public class TokenSignDto implements Serializable {

    private String value;
    private String device;
    private Object tag;

}
