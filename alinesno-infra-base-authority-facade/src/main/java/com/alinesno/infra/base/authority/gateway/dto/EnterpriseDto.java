package com.alinesno.infra.base.authority.gateway.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 企业信息管理
 * 
 * @author luoxiaodong
 * @since 2023年10月27日 下午3:05:15
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class EnterpriseDto extends BaseDto {

	private String name; // 企业名称
	private String logo; // 企业logo
	private String enDesc; // 企业描述
	private String domainName; // 企业域名
	private String creditCode; // 企业信用代码
	private String saasUrl; // 工作台地址

}
