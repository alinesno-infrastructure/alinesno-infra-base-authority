package com.alinesno.infra.base.authority.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 用户登陆记录表
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@Data
@TableName("manager_login_record")
public class ManagerLoginRecordEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 登陆名
	 */
	@Excel(name = "登陆名")
	@TableField("login_name")
	@ColumnType(length = 255)
	@ColumnComment("登陆名")
	private String loginName;

	/**
	 * 登陆时间
	 */
	@Excel(name = "登陆时间", format = "yyyy-MM-dd HH:mm:ss")
	@TableField("login_time")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@ColumnType
	@ColumnComment("登陆时间")
	private Date loginTime;

	/**
	 * 登陆IP
	 */
	@Excel(name = "登陆IP")
	@TableField("login_ip")
	@ColumnType(length = 255)
	@ColumnComment("登陆IP")
	private String loginIp;

	/**
	 * 登陆状态(1成功|0失败)
	 */
	@Excel(name = "登陆状态", replace = { "成功_1", "失败_0", "_null" })
	@TableField("login_status")
	@ColumnType(length = 1)
	@ColumnComment("登陆状态(1成功|0失败)")
	private String loginStatus;

	/**
	 * 错误密码
	 */
	@Excel(name = "错误密码")
	@TableField("error_password")
	@ColumnType(length = 255)
	@ColumnComment("错误密码")
	private String errorPassword;

	/**
	 * 手机验证码
	 */
	@Excel(name = "手机验证码")
	@TableField("phone_code")
	@ColumnType(length = 255)
	@ColumnComment("手机验证码")
	private String phoneCode;

	/**
	 * 邮箱验证码
	 */
	@Excel(name = "邮箱验证码")
	@TableField("email_code")
	@ColumnType(length = 255)
	@ColumnComment("邮箱验证码")
	private String emailCode;

	/**
	 * 登陆来源
	 */
	@Excel(name = "登陆来源")
	@TableField("login_src")
	@ColumnType(length = 255)
	@ColumnComment("登陆来源")
	private String loginSrc;

	/**
	 * 退出时间
	 */
	@Excel(name = "退出时间", format = "yyyy-MM-dd HH:mm:ss")
	@TableField("sign_out_time")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@ColumnType
	@ColumnComment("退出时间")
	private Date signOutTime;

	/**
	 * 浏览器信息
	 */
	@Excel(name = "浏览器信息")
	@TableField("login_browser")
	@ColumnType(length = 255)
	@ColumnComment("浏览器信息")
	private String loginBrowser;

	/**
	 * 登陆备注
	 */
	@Excel(name = "登陆备注")
	@TableField("login_remark")
	@ColumnType(length = 255)
	@ColumnComment("登陆备注")
	private String loginRemark;

}
