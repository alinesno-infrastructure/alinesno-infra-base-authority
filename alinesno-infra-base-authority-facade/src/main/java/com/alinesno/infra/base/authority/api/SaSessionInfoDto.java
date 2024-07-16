//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.alinesno.infra.base.authority.api;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 会话信息数据传输对象，用于封装会话相关的详细信息。
 * 包括会话ID、类型、登录类型、登录ID、令牌等基本信息，
 * 以及与登录账户相关的详细信息，如用户ID、登录名、姓名、头像等。
 * 同时，还记录了会话相关的数据映射、令牌签名列表，以及浏览器、操作系统、登录IP等相关信息。
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Data
public class SaSessionInfoDto implements Serializable {

    // 会话ID，用于唯一标识一个会话。
    private String id;
    // 会话类型，用于区分不同类型的会话。
    private String type;
    // 登录类型，指示用户是如何登录的，例如密码登录、验证码登录等。
    private String loginType;
    // 登录ID，用于标识成功登录的用户或系统的唯一标识。
    private Object loginId;
    // 令牌，用于验证请求的合法性。
    private String token;
    // 会话的创建时间，以毫秒为单位的UNIX时间戳。
    private long createTime;
    // 会话数据映射，用于存储会话期间的临时数据。
    private final Map<String, Object> dataMap = new ConcurrentHashMap<>();
    // 令牌签名列表，用于会话的安全验证。
    private List<TokenSignDto> tokenSignList = new Vector<>();

    // 用户ID，标识登录用户的唯一标识。
    private Long userId;
    // 登录名，用户登录时使用的名称。
    private String loginName;
    // 用户姓名。
    private String name;
    // 头像路径。
    private String avatorPath;
    // 账户状态，指示账户是否可用。
    private String accountStatus;
    // 上次登录的IP地址。
    private String lastLoginIp;
    // 上次登录的时间。
    private String lastLoginTime;
    // 账户所有者信息。
    private String owners;
    // 用户角色ID。
    private String roleId;
    // 角色权限字符串。
    private String rolePower;
    // 部门名称。
    private String department;
    // 用户邮箱。
    private String email;
    // 用户电话号码。
    private String phone;
    // 用户性别。
    private String sex;
    // 是否有编辑权限。
    private String hasEditor;

    // 浏览器信息
    private String browser ;
    // 操作系统名称。
    private String osName ;
    // 登录IP地址。
    private String loginIP ;
    // 登录地区。
    private String loginArea ;

    // 令牌有效期
    private long tokenTimeout ;
    // 会话有效期
    private long sessionTimeout;
    // 账号禁封锁时间
    private long disableTime ;

}

