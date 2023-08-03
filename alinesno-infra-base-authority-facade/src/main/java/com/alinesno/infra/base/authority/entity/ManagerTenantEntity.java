package com.alinesno.infra.base.authority.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * <p>
 * 
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */

@TableName("manager_tenant")
public class ManagerTenantEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 租户名称
	 */
	@Excel(name = "租户名称")
	@TableField("tenant_name")
	private String tenantName;
	/**
	 * 开始时间
	 */
	@Excel(name = "开始时间")
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	@TableField("start_time")
	private Date startTime;

	/**
	 * 结束时间
	 */
	@Excel(name = "结束时间")
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	@TableField("end_time")
	private Date endTime;
	/**
	 * 租户状态(1正常/0禁止)
	 */
//  @Excel(name = "租户状态(1正常/0禁止)")
	@TableField("tenant_status")
	private String tenantStatus;
	/**
	 * 租户账户
	 */
	@TableField("tenant_account")
	private String tenantAccount;
	/**
	 * 租房费用
	 */
	@Excel(name = "租房费用")
	@TableField("tenant_cost")
	private Integer tenantCost;
	/**
	 * 所属城市
	 */
	@TableField("city_id")
	private String cityId;
	/**
	 * 所属省份
	 */
	@TableField("province_id")
	private String provinceId;
	/**
	 * 租户地址
	 */
	@Excel(name = "租户地址")
	@TableField("tenant_address")
	private String tenantAddress;
	/**
	 * 租户联系电话
	 */
	@Excel(name = "租户联系电话")
	@TableField("tenant_phone")
	private String tenantPhone;

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getTenantStatus() {
		return tenantStatus;
	}

	public void setTenantStatus(String tenantStatus) {
		this.tenantStatus = tenantStatus;
	}

	public String getTenantAccount() {
		return tenantAccount;
	}

	public void setTenantAccount(String tenantAccount) {
		this.tenantAccount = tenantAccount;
	}

	public Integer getTenantCost() {
		return tenantCost;
	}

	public void setTenantCost(Integer tenantCost) {
		this.tenantCost = tenantCost;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getTenantAddress() {
		return tenantAddress;
	}

	public void setTenantAddress(String tenantAddress) {
		this.tenantAddress = tenantAddress;
	}

	public String getTenantPhone() {
		return tenantPhone;
	}

	public void setTenantPhone(String tenantPhone) {
		this.tenantPhone = tenantPhone;
	}

	@Override
	public String toString() {
		return "ManagerTenantEntity{" + "tenantName=" + tenantName + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", tenantStatus=" + tenantStatus + ", tenantAccount=" + tenantAccount + ", tenantCost=" + tenantCost
				+ ", cityId=" + cityId + ", provinceId=" + provinceId + ", tenantAddress=" + tenantAddress
				+ ", tenantPhone=" + tenantPhone + "}";
	}
}
