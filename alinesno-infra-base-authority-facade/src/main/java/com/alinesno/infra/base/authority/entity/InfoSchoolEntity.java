package com.alinesno.infra.base.authority.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */

@TableName("info_school")
public class InfoSchoolEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 所属者
	 */
	@TableField("owners")
	private String owners;
	/**
	 * 学校地址
	 */
	@TableField("school_address")
	private String schoolAddress;
	/**
	 * 学校名称
	 */
	@TableField("school_name")
	private String schoolName;
	/**
	 * 办学类型代码
	 */
	@TableField("school_type")
	private String schoolType;
	/**
	 * 学校代码
	 */
	@TableField("school_code")
	private String schoolCode;

	@TableField("school_province")
	private String schoolProvince;

	@TableField("school_province_code")
	private String schoolProvinceCode;

	/**
	 * 办学类型名称
	 */
	@TableField("school_type_name")
	private String schoolTypeName;
	/**
	 * 学校性质类型
	 */
	@TableField("school_properties")
	private String schoolProperties;
	/**
	 * 办学性质类型代码
	 */
	@TableField("school_properties_code")
	private String schoolPropertiesCode;
	/**
	 * 学校举办者
	 */
	@TableField("school_owner")
	private String schoolOwner;
	/**
	 * 学校举办者代码
	 */
	@TableField("school_owner_code")
	private String schoolOwnerCode;

	public String getOwners() {
		return owners;
	}

	public void setOwners(String owners) {
		this.owners = owners;
	}

	public String getSchoolAddress() {
		return schoolAddress;
	}

	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolType() {
		return schoolType;
	}

	public void setSchoolType(String schoolType) {
		this.schoolType = schoolType;
	}

	public String getSchoolCode() {
		return schoolCode;
	}

	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}

	public String getSchoolProvince() {
		return schoolProvince;
	}

	public void setSchoolProvince(String schoolProvince) {
		this.schoolProvince = schoolProvince;
	}

	public String getSchoolProvinceCode() {
		return schoolProvinceCode;
	}

	public void setSchoolProvinceCode(String schoolProvinceCode) {
		this.schoolProvinceCode = schoolProvinceCode;
	}

	public String getSchoolTypeName() {
		return schoolTypeName;
	}

	public void setSchoolTypeName(String schoolTypeName) {
		this.schoolTypeName = schoolTypeName;
	}

	public String getSchoolProperties() {
		return schoolProperties;
	}

	public void setSchoolProperties(String schoolProperties) {
		this.schoolProperties = schoolProperties;
	}

	public String getSchoolPropertiesCode() {
		return schoolPropertiesCode;
	}

	public void setSchoolPropertiesCode(String schoolPropertiesCode) {
		this.schoolPropertiesCode = schoolPropertiesCode;
	}

	public String getSchoolOwner() {
		return schoolOwner;
	}

	public void setSchoolOwner(String schoolOwner) {
		this.schoolOwner = schoolOwner;
	}

	public String getSchoolOwnerCode() {
		return schoolOwnerCode;
	}

	public void setSchoolOwnerCode(String schoolOwnerCode) {
		this.schoolOwnerCode = schoolOwnerCode;
	}

	@Override
	public String toString() {
		return "InfoSchoolEntity{" + "owners=" + owners + ", schoolAddress=" + schoolAddress + ", schoolName="
				+ schoolName + ", schoolType=" + schoolType + ", schoolCode=" + schoolCode + ", schoolProvince="
				+ schoolProvince + ", schoolProvinceCode=" + schoolProvinceCode + ", schoolTypeName=" + schoolTypeName
				+ ", schoolProperties=" + schoolProperties + ", schoolPropertiesCode=" + schoolPropertiesCode
				+ ", schoolOwner=" + schoolOwner + ", schoolOwnerCode=" + schoolOwnerCode + "}";
	}
}
