package com.alinesno.infra.base.authority.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("manager_files")
public class ManagerFilesEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 文件类型
	 */
	@TableField("type")
	private String type;
	/**
	 * 文件存储路径
	 */
	@TableField("path")
	private String path;
	/**
	 * 文件长度
	 */
	@TableField("size")
	private String size;
	/**
	 * 文件名称
	 */
	@TableField("file_name")
	private String fileName;

	/**
	 * 文件备注，比如用于身份证或者头像
	 */
	@TableField("file_remark")
	private String fileRemark;

	/**
	 * 业务id
	 */
	@TableField("business_key_id")
	private String businessKeyId;

	public String getBusinessKeyId() {
		return businessKeyId;
	}

	public void setBusinessKeyId(String businessKeyId) {
		this.businessKeyId = businessKeyId;
	}

	public String getFileRemark() {
		return fileRemark;
	}

	public void setFileRemark(String fileRemark) {
		this.fileRemark = fileRemark;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "CorrectionFilesEntity{" + "type=" + type + ", path=" + path + ", size=" + size + ", fileName="
				+ fileName + "}";
	}
}
