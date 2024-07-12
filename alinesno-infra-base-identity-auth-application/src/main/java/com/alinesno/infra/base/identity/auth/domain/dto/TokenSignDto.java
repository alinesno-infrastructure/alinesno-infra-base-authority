package com.alinesno.infra.base.identity.auth.domain.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TokenSignDto implements Serializable {

    private String value;
    private String device;
    private Object tag;

}
