package com.alinesno.infra.base.authority.api.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： manager_files
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ManagerFilesDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "fileName"
	 */
	private String fileName;
	/**
	 * "fileRemark"
	 */
	private String fileRemark;
	/**
	 * "path"
	 */
	private String path;
	/**
	 * "size"
	 */
	private String size;
	/**
	 * "type"
	 */
	private String type;
	/**
	 * "businessKeyId"
	 */
	private String businessKeyId;

	// getter and setter
	public String getFileName()

	{
		return this.fileName;
	}

	public ManagerFilesDto setFileName(String arg) {
		this.fileName = arg;
		return this;
	}

	public String getFileRemark()

	{
		return this.fileRemark;
	}

	public ManagerFilesDto setFileRemark(String arg) {
		this.fileRemark = arg;
		return this;
	}

	public String getPath()

	{
		return this.path;
	}

	public ManagerFilesDto setPath(String arg) {
		this.path = arg;
		return this;
	}

	public String getSize()

	{
		return this.size;
	}

	public ManagerFilesDto setSize(String arg) {
		this.size = arg;
		return this;
	}

	public String getType()

	{
		return this.type;
	}

	public ManagerFilesDto setType(String arg) {
		this.type = arg;
		return this;
	}

	public String getBusinessKeyId()

	{
		return this.businessKeyId;
	}

	public ManagerFilesDto setBusinessKeyId(String arg) {
		this.businessKeyId = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerFilesDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ManagerFilesDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerFilesDto fromDto(ManagerFilesDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ManagerFilesDto.class);
	}

}
