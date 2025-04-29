package com.alinesno.infra.base.authority.gateway.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 企业信息账户管理
 * 
 * @author luoxiaodong
 * @since 2023年10月27日 下午3:05:15
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class EnterpriseAccountDto extends BaseDto {

	private String enterpriseId; // 企业id
	private String creditCode; // 企业信用代码
	private String accountId; // 账号id

}
