package com.alinesno.infra.base.authority.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.common.facade.mapper.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("organization")
public class OrganizationEntity extends BaseEntity {

	/**
	 * 机构名称
	 */
	@Excel(name = "机构名称")
	@TableField("org_name")
	@ColumnType(length = 32)
	@ColumnComment("机构名称")
	private String orgName;

	@Excel(name = "机构描述")
	@TableField("remark")
	@ColumnType(length = 255)
	@ColumnComment("机构描述")
	private String remark;

	/**
	 * LOGO 图片路径或URL
	 */
	@TableField("logo_path")
	@ColumnType(MySqlTypeConstant.BLOB)
	@ColumnComment("组织LOGO,推荐尺寸 400*180 px，显示在工作台、打印、分享和企业域名页面，大小建议在512KB以内")
	private String logoPath;

//	/**
//	 * 组织门牌号
//	 */
//	@TableField("doorplate_number")
//	@ColumnType(length = 255)
//	@ColumnComment("成员可输入组织门牌号加入组织")
//	private String doorplateNumber;

	/**
	 * 组织唯一身份编号
	 */
	@TableField("organization_id")
	@ColumnType(length = 255)
	@ColumnComment("组织唯一身份编号,组织唯一身份编号，用于沟通反馈问题时使用")
	private String organizationId;

	/**
	 * 二级域名(可自定义访问链接和登录背景图片)
	 */
	@TableField("subdomain")
	@ColumnType(length = 255)
	@ColumnComment("二级域名(可自定义访问链接和登录背景图片)")
	private String subdomain;

	/**
	 * 工作地点
	 */
	@TableField("work_location")
	@ColumnType(length = 255)
	@ColumnComment("工作地点")
	private String workLocation;

	/**
	 * 开始时间
	 */
	@Excel(name = "开始时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@TableField("start_time")
	@ColumnType
	@ColumnComment("开始时间")
	private Date startTime;

	/**
	 * 结束时间
	 */
	@Excel(name = "结束时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@TableField("end_time")
	@ColumnType
	@ColumnComment("结束时间")
	private Date endTime;

	/**
	 * 机构状态(1正常/0禁止)
	 */
	@TableField("org_status")
	@ColumnType(length = 1)
	@ColumnComment("机构状态(1正常/0禁止)")
	private String orgStatus;

	/**
	 * 所属城市
	 */
	@TableField("city_id")
	@ColumnType(length = 255)
	@ColumnComment("所属城市")
	private String cityId;

	/**
	 * 所属省份
	 */
	@TableField("province_id")
	@ColumnType(length = 255)
	@ColumnComment("所属省份")
	private String provinceId;

	/**
	 * 机构地址
	 */
	@Excel(name = "机构地址")
	@TableField("org_address")
	@ColumnType(length = 255)
	@ColumnComment("机构地址")
	private String orgAddress;

	/**
	 * 机构联系电话
	 */
	@Excel(name = "机构联系电话")
	@TableField("org_phone")
	@ColumnType(length = 255)
	@ColumnComment("机构联系电话")
	private String orgPhone;

	@TableField
	@ColumnType(length = 255)
	@ColumnComment("系统内置(Y是|N否)")
	private String systemInner;

}
