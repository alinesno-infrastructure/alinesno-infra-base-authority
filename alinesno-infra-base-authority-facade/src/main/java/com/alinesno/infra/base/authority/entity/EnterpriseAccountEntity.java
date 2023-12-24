package com.alinesno.infra.base.authority.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;

/**
 * 企业信息账户管理
 * 
 * @author luoxiaodong
 * @since 2023年10月27日 下午3:05:15
 */
@Data
@SuppressWarnings("serial")
@TableName("enterprise_account")
public class EnterpriseAccountEntity extends InfraBaseEntity {

	@ColumnType(length = 50)
	@ColumnComment("企业id")
	@TableField("enterprise_id")
	private String enterpriseId; // 企业id

	@ColumnType(length = 50)
	@ColumnComment("企业信用代码")
	@TableField("credit_code")
	private String creditCode; // 企业信用代码

	@ColumnType
	@ColumnComment("账号id")
	@TableField("account_id")
	private Long accountId; // 账号id

}
