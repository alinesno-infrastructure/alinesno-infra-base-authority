package com.alinesno.infra.base.authority.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;

/**
 * <p>
 * 企业配置
 * </p>
 *
 * @author ${author}
 * @version 1.0.0
 */
@Data
@TableName("enterprise_setting")
public class EnterpriseSettingEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	@ColumnType(length = 100)
	@ColumnComment("配置名称")
	@TableField("config_name")
	@Excel(name = "配置名称")
	private String configName;

	@ColumnType(length = 100)
	@ColumnComment("所属公司")
	@TableField("company")
	@Excel(name = "所属公司")
	private String company;

	@ColumnType(length = 200)
	@ColumnComment("公司地址")
	@TableField("company_address")
	@Excel(name = "公司地址")
	private String companyAddress;

	@ColumnType(length = 20)
	@ColumnComment("公司电话")
	@TableField("company_phone")
	@Excel(name = "公司电话")
	private String companyPhone;

	@ColumnType(length = 100)
	@ColumnComment("公司二维码")
	@TableField("company_qrcode")
	@Excel(name = "公司二维码")
	private String companyQrcode;

	@ColumnComment("公司二维码路径")
	@TableField(exist = false)
	private String companyQrcodePath;

	@ColumnType(length = 20)
	@ColumnComment("客服QQ")
	@TableField("service_qq")
	@Excel(name = "客服QQ")
	private String serviceQq;

	@ColumnType(length = 100)
	@ColumnComment("logo")
	@TableField("logo")
	@Excel(name = "logo")
	private String logo;

	@ColumnComment("logo路径")
	@TableField(exist = false)
	private String logoPath;

	@ColumnType(length = 50)
	@ColumnComment("公司邮箱")
	@TableField("company_email")
	@Excel(name = "公司邮箱")
	private String companyEmail;

	@ColumnType(length = 100)
	@ColumnComment("版权所有")
	@TableField("copy_right")
	@Excel(name = "版权所有")
	private String copyRight;

	@ColumnType(length = 100)
	@ColumnComment("技术支持")
	@TableField("tech_support")
	@Excel(name = "技术支持")
	private String techSupport;

	@ColumnType(length = 100)
	@ColumnComment("企业官网")
	@TableField("website")
	private String website;

}
