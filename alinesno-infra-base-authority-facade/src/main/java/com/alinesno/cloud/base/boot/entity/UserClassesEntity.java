package com.alinesno.cloud.base.boot.entity;

import java.util.Date;

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

@TableName("user_classes")
public class UserClassesEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	@TableField
	private String owners;

	@TableField
	private String classes;

	@TableField("collge_name")
	private String collgeName;

	@TableField
	private String education;

	@TableField("is_use")
	private String isUse;

	@TableField("professional_name")
	private String professionalName;

	@TableField("school_end_time")
	private Date schoolEndTime;

	@TableField("school_id")
	private String schoolId;

	@TableField("school_name")
	private String schoolName;

	@TableField("school_num")
	private String schoolNum;

	@TableField("school_start_time")
	private Date schoolStartTime;

	@TableField("shool_job")
	private String shoolJob;

	@TableField("use_end_time")
	private String useEndTime;

	@TableField("use_start_time")
	private String useStartTime;

	@TableField("user_id")
	private String userId;

	public String getOwners() {
		return owners;
	}

	public void setOwners(String owners) {
		this.owners = owners;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String getCollgeName() {
		return collgeName;
	}

	public void setCollgeName(String collgeName) {
		this.collgeName = collgeName;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getIsUse() {
		return isUse;
	}

	public void setIsUse(String isUse) {
		this.isUse = isUse;
	}

	public String getProfessionalName() {
		return professionalName;
	}

	public void setProfessionalName(String professionalName) {
		this.professionalName = professionalName;
	}

	public Date getSchoolEndTime() {
		return schoolEndTime;
	}

	public void setSchoolEndTime(Date schoolEndTime) {
		this.schoolEndTime = schoolEndTime;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolNum() {
		return schoolNum;
	}

	public void setSchoolNum(String schoolNum) {
		this.schoolNum = schoolNum;
	}

	public Date getSchoolStartTime() {
		return schoolStartTime;
	}

	public void setSchoolStartTime(Date schoolStartTime) {
		this.schoolStartTime = schoolStartTime;
	}

	public String getShoolJob() {
		return shoolJob;
	}

	public void setShoolJob(String shoolJob) {
		this.shoolJob = shoolJob;
	}

	public String getUseEndTime() {
		return useEndTime;
	}

	public void setUseEndTime(String useEndTime) {
		this.useEndTime = useEndTime;
	}

	public String getUseStartTime() {
		return useStartTime;
	}

	public void setUseStartTime(String useStartTime) {
		this.useStartTime = useStartTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserClassesEntity{" + "owners=" + owners + ", classes=" + classes + ", collgeName=" + collgeName
				+ ", education=" + education + ", isUse=" + isUse + ", professionalName=" + professionalName
				+ ", schoolEndTime=" + schoolEndTime + ", schoolId=" + schoolId + ", schoolName=" + schoolName
				+ ", schoolNum=" + schoolNum + ", schoolStartTime=" + schoolStartTime + ", shoolJob=" + shoolJob
				+ ", useEndTime=" + useEndTime + ", useStartTime=" + useStartTime + ", userId=" + userId + "}";
	}
}
