package com.alinesno.infra.base.authority.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;

@Data
@TableName("manager_files")
public class ManagerFilesEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 文件类型
	 */
	@TableField("type")
	@ColumnType(length = 255)
	@ColumnComment("文件类型")
	private String type;

	/**
	 * 文件存储路径
	 */
	@TableField("path")
	@ColumnType(length = 255)
	@ColumnComment("文件存储路径")
	private String path;

	/**
	 * 文件长度
	 */
	@TableField("size")
	@ColumnType(length = 255)
	@ColumnComment("文件长度")
	private String size;

	/**
	 * 文件名称
	 */
	@TableField("file_name")
	@ColumnType(length = 255)
	@ColumnComment("文件名称")
	private String fileName;

	/**
	 * 文件备注，比如用于身份证或者头像
	 */
	@TableField("file_remark")
	@ColumnType(length = 255)
	@ColumnComment("文件备注，比如用于身份证或者头像")
	private String fileRemark;

	/**
	 * 业务id
	 */
	@TableField("business_key_id")
	@ColumnType(length = 255)
	@ColumnComment("业务id")
	private String businessKeyId;

}