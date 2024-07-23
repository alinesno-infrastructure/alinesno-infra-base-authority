package com.alinesno.infra.base.authority.api;

import com.alinesno.infra.common.facade.base.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 组织信息数据传输对象类
 * 用于序列化和反序列化组织相关数据，便于网络传输。
 * 包含了组织的基本信息、地理位置、联系方式以及状态等。
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class OrganizationDto extends BaseDto {

    /**
     * 组织名称
     */
    private String orgName;

    /**
     * 组织备注信息
     */
    private String remark;

    /**
     * 组织logo的URL地址
     */
    private String logoUrl;

    /**
     * 组织门牌号
     */
    private String doorplateNumber;

    /**
     * 组织在系统中的唯一标识ID
     */
    private String organizationId;

    /**
     * 组织的子域名
     */
    private String subdomain;

    /**
     * 组织的工作地点
     */
    private String workLocation;

    /**
     * 组织的开始运营时间
     */
    private Date startTime;

    /**
     * 组织的结束运营时间
     */
    private Date endTime;

    /**
     * 组织的状态，如：正常、暂停、注销等
     */
    private String orgStatus;

    /**
     * 组织所在的城市ID
     */
    private String cityId;

    /**
     * 组织所在的省份ID
     */
    private String provinceId;

    /**
     * 组织的详细地址
     */
    private String orgAddress;

    /**
     * 组织的联系电话
     */
    private String orgPhone;

    /**
     * 标记组织是否为系统内部组织
     */
    private String systemInner;

    /**
     * 组织成员的数量
     */
    private long memberCount;

    /**
     * 账户所在组织角色类型
     */
    private int accountOrgType ;

}

