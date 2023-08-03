package com.alinesno.infra.base.authority.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * <p>
 * 区域表
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */

@TableName("info_address")
public class InfoAddressEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 父ID
	 */
	@TableField("parent_id")
	private Long parentId;
	/**
	 * 区域名称
	 */
	@Excel(name = "区域名称")
	@TableField("district_name")
	private String districtName;
	/**
	 * 简称
	 */
	@Excel(name = "简称")
	@TableField("short_name")
	private String shortName;
	/**
	 * 经度
	 */
	@Excel(name = "经度")
	@TableField
	private BigDecimal longitude;
	/**
	 * 维度
	 */
	@Excel(name = "维度")
	@TableField
	private BigDecimal latitude;
	/**
	 * 等级
	 */
	@Excel(name = "等级")
	@TableField
	private Integer level;
	/**
	 * 排序
	 */
	@Excel(name = "排序")
	@TableField
	private Integer sort;
	/**
	 * 删除标志: 0未删除，1已删除
	 */
	@TableField("is_deleted")
	private Integer isDeleted;
	/**
	 * 创建时间
	 */
	@Excel(name = "创建时间")
	@TableField("create_time")
	private Date createTime;

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "InfoAddressEntity{" + "parentId=" + parentId + ", districtName=" + districtName + ", shortName="
				+ shortName + ", longitude=" + longitude + ", latitude=" + latitude + ", level=" + level + ", sort="
				+ sort + ", isDeleted=" + isDeleted + ", createTime=" + createTime + "}";
	}
}
