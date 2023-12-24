package com.alinesno.infra.base.authority.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;

/**
 * 企业信息管理
 * 
 * @author luoxiaodong
 * @since 2023年10月27日 下午3:05:15
 */
@Data
@SuppressWarnings("serial")
@TableName("enterprise")
public class EnterpriseEntity extends InfraBaseEntity {

	@ColumnType(length = 100)
	@ColumnComment("企业名称")
	@TableField("name")
	private String name; // 企业名称

	@ColumnType(length = 100)
	@ColumnComment("企业logo")
	@TableField("logo")
	private String logo; // 企业logo

	@ColumnType(length = 1000)
	@ColumnComment("企业描述")
	@TableField("en_desc")
	private String enDesc; // 企业描述

	@ColumnType(length = 100)
	@ColumnComment("企业域名")
	@TableField("domain_name")
	private String domainName; // 企业域名

	@ColumnType(length = 50)
	@ColumnComment("企业信用代码")
	@TableField("credit_code")
	private String creditCode; // 企业信用代码

	@ColumnType(length = 100)
	@ColumnComment("工作台地址")
	@TableField("saas_url")
	private String saasUrl; // 工作台地址

}
