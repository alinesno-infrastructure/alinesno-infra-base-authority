package com.alinesno.infra.base.authority.api.identity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WxLoginInfoDTO {
    
    /**
     * 唯一标识
     */
    private String uuid;
    /**
     * 设备号
     */
    private String device;
    
    /**
     * jwt令牌
     */
    private String token;
    
    /**
     * 扫码状态
     */
    private String status;
}