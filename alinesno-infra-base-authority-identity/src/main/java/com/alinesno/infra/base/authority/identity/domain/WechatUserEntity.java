package com.alinesno.infra.base.authority.identity.domain;

import com.alibaba.fastjson.JSONArray;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * 微信用户信息实体类，用于存储微信用户的相关信息
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@TableName("identity_wechat_user")
@Table(comment = "微信用户信息表")
public class WechatUserEntity extends InfraBaseEntity {

    /**
     * 与账号关联的ID
     */
    @TableField("account_id")
    @Column(name = "account_id", type = MySqlTypeConstant.BIGINT, comment = "账号ID")
    private Long accountId ;

    /**
     * 普通用户的标识，对当前开发者账号唯一
     */
    @TableField("openid")
    @Column(name = "openid", type = MySqlTypeConstant.VARCHAR, length = 100, comment = "普通用户的标识，对当前开发者账号唯一")
    private String openid;

    /**
     * 普通用户昵称
     */
    @TableField("nickname")
    @Column(name = "nickname", type = MySqlTypeConstant.VARCHAR, length = 50, comment = "普通用户昵称")
    private String nickname;

    /**
     * 手机号
     */
    @TableField("phone")
    @Column(name = "phone", type = MySqlTypeConstant.VARCHAR, length = 20, comment = "手机号")
    private String phone ;

    /**
     * 普通用户性别，1为男性，2为女性
     */
    @TableField("sex")
    @Column(name = "sex", type = MySqlTypeConstant.INT, comment = "普通用户性别，1为男性，2为女性")
    private int sex;

    /**
     * 普通用户个人资料填写的省份
     */
    @TableField("province")
    @Column(name = "province", type = MySqlTypeConstant.VARCHAR, length = 50, comment = "普通用户个人资料填写的省份")
    private String province;

    /**
     * 普通用户个人资料填写的城市
     */
    @TableField("city")
    @Column(name = "city", type = MySqlTypeConstant.VARCHAR, length = 50, comment = "普通用户个人资料填写的城市")
    private String city;

    /**
     * 国家，如中国为CN
     */
    @TableField("country")
    @Column(name = "country", type = MySqlTypeConstant.VARCHAR, length = 20, comment = "国家，如中国为CN")
    private String country;

    /**
     * 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空
     */
    @TableField("headimgurl")
    @Column(name = "headimgurl", type = MySqlTypeConstant.VARCHAR, length = 255, comment = "用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空")
    private String headimgurl;

    /**
     * 用户特权信息，json数组，如微信沃卡用户为（chinaunicom）
     */
    @TableField("privilege")
    @Column(name = "privilege", type = MySqlTypeConstant.VARCHAR, length = 255, comment = "用户特权信息，json数组，如微信沃卡用户为（chinaunicom）")
    private String privilege;

    /**
     * 用户统一标识。针对一个微信开放平台账号下的应用，同一用户的unionid是唯一的。
     */
    @TableField("unionid")
    @Column(name = "unionid", type = MySqlTypeConstant.VARCHAR, length = 100, comment = "用户统一标识。针对一个微信开放平台账号下的应用，同一用户的unionid是唯一的。")
    private String unionid;


    public WechatUserEntity(String openid, String nickname, Integer sex, String province, String city, String country, String headimgurl, JSONArray privilege, String unionid) {
        this.openid = openid;
        this.nickname = nickname;
        this.sex = sex;
        this.province = province;
        this.city = city;
        this.country = country;
        this.headimgurl = headimgurl;
        this.privilege = privilege.toString();
        this.unionid = unionid;
    }
}