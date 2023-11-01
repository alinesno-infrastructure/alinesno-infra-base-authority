package com.alinesno.infra.base.authority.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@Data
@TableName("info_job")
public class InfoJobEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	@ColumnType
	@ColumnComment("所有者")
	@TableField("owners")
	private String owners;

	@ColumnType(length = 100)
	@ColumnComment("工作类型")
	@TableField("job_type")
	private String jobType;

	@ColumnType(length = 100)
	@ColumnComment("工作名称")
	@TableField("job_name")
	private String jobName;

	@ColumnType(length = 100)
	@ColumnComment("上级工作")
	@TableField("job_parent")
	private String jobParent;

}
