package com.alinesno.cloud.base.boot.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 *
 * </p>
 *
 * @author WeiXiaoJin
 * @since 2018-12-16 17:53:19
 */

@TableName("info_job")
public class InfoJobEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	@TableField("owners")
	private String owners;

	@TableField("job_type")
	private String jobType;

	@TableField("job_name")
	private String jobName;

	@TableField("job_parent")
	private String jobParent;

	public String getOwners() {
		return owners;
	}

	public void setOwners(String owners) {
		this.owners = owners;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobParent() {
		return jobParent;
	}

	public void setJobParent(String jobParent) {
		this.jobParent = jobParent;
	}

	@Override
	public String toString() {
		return "InfoJobEntity{" + "owners=" + owners + ", jobType=" + jobType + ", jobName=" + jobName + ", jobParent="
				+ jobParent + "}";
	}
}
