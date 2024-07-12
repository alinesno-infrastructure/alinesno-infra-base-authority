//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.alinesno.infra.base.identity.auth.domain.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

@Data
public class SaSessionInfoDto implements Serializable {

    // 会话的一些信息
    private String id;
    private String type;
    private String loginType;
    private Object loginId;
    private String token;
    private long createTime;
    private final Map<String, Object> dataMap = new ConcurrentHashMap<>();
    private List<TokenSignDto> tokenSignList = new Vector<>();

    // 账户的一些信息
    private Long userId;
    private String loginName;
    private String name;
    private String avatorPath;
    private String accountStatus;
    private String lastLoginIp;
    private String lastLoginTime;
    private String owners;
    private String roleId;
    private String rolePower;
    private String department;
    private String email;
    private String phone;
    private String sex;
    private String hasEditor;
}
