package com.alinesno.infra.base.authority.gateway.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 功能名： 【请填写功能名称】 数据表： manager_code
 * 
 * @author luoxiaodong 
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ManagerCodeDto extends BaseDto {
	/**
	 * "codeName"
	 */
	private String codeName;
	/**
	 * "codeTypeName"
	 */
	private String codeTypeName;
	/**
	 * "codeTypeValue"
	 */
	private String codeTypeValue;
	/**
	 * "codeValue"
	 */
	private String codeValue;
	/**
	 * "codeDesc"
	 */
	private String codeDesc;

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerCodeDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ManagerCodeDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerCodeDto fromDto(ManagerCodeDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ManagerCodeDto.class);
	}

}
