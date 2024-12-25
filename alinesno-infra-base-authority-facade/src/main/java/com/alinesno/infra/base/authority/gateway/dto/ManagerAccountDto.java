package com.alinesno.infra.base.authority.gateway.dto;

import com.alinesno.infra.base.authority.api.OrganizationDto;
import com.alinesno.infra.base.authority.entity.ManagerAccountEntity;
import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 功能名： 【请填写功能名称】 数据表： manager_account
 * 
 * @author luoxiaodong 
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ManagerAccountDto extends BaseDto {
	// fields
	/**
	 * "账户状态"
	 */
	private String accountStatus;
	/**
	 * "最后登陆IP"
	 */
	private String lastLoginIp;
	/**
	 * "lastLoginTime"
	 */
	private String lastLoginTime;
	/**
	 * "loginName"
	 */
	private String loginName;
	/**
	 * "name"
	 */
	private String name;
	/**
	 * "所属者"
	 */
	private String owners;
	/**
	 * "password"
	 */
	private String password;
	/**
	 * "roleId"
	 */
	private String roleId;
	/**
	 * "rolePower"
	 */
	private String rolePower;
	/**
	 * "salt"
	 */
	private String salt;
	/**
	 * "userId"
	 */
	private String userId;
	/**
	 * "department"
	 */
	private String department;
	/**
	 * "email"
	 */
	private String email;
	/**
	 * "phone"
	 */
	private String phone;
	/**
	 * "sex"
	 */
	private String sex;
	/**
	 * "hasEditor"
	 */
	private String hasEditor;
	/**
	 * "用户头像"
	 */
	private String avatarPath;
	/**
	 * "企业属性"
	 */
	private String enterpriseProperties;
	/**
	 * "portalProp"
	 */
	private String portalProp;
	/**
	 * "岗位id"
	 */
	private String positionId;

	// 默认授权信息
	private List<String> authRole;

	/**
	 * 组织岗位类型
	 */
	private Integer orgType ;

	/**
	 * 组织列表
	 */
	private List<OrganizationDto> orgList ;

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerAccountDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ManagerAccountDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerAccountDto fromDto(ManagerAccountEntity entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ManagerAccountDto.class);
	}

}
