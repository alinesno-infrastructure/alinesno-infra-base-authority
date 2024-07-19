package com.alinesno.infra.base.identity.auth.domain;

import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;
import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * <p>
 * 用户登陆记录表
 * </p>
 *
 * @author luoxiaondg
 * @version 1.0.0
 */

@EqualsAndHashCode(callSuper = true)
@TableName("login_record")
@Data
public class LoginRecordEntity extends InfraBaseEntity {

	/**
	 * 登陆名
	 */
	@Excel(name = "登陆名")
	@TableField("login_name")
	@ColumnType(length=20)
	@ColumnComment("登陆名")
	private String loginName;

	/**
	 * 登陆时间
	 */
	@Excel(name = "登陆时间", format = "yyyy-MM-dd HH:mm:ss")
	@TableField("login_time")
	@ColumnType(length=19)
	@ColumnComment("登陆时间")
	private Date loginTime;

	@TableField("userId")
	@ColumnType(length=11)
	@ColumnComment("用户ID")
	private Long userId;

	@TableField("accToken")
	@ColumnType(length=36)
	@ColumnComment("访问令牌")
	private String accToken;

	@TableField("loginIp")
	@ColumnType(length=15)
	@ColumnComment("登录IP")
	private String loginIp;

	@TableField("loginAddress")
	@ColumnType(length=50)
	@ColumnComment("登录地址")
	private String loginAddress;

	@TableField("loginDevice")
	@ColumnType(length=20)
	@ColumnComment("登录设备")
	private String loginDevice;

	@TableField("loginSystem")
	@ColumnType(length=20)
	@ColumnComment("登录系统")
	private String loginSystem;

	@TableField("clientId")
	@ColumnType(length=11)
	@ColumnComment("客户端ID")
	private Integer clientId;

	@TableField("clientDomain")
	@ColumnType(length=100)
	@ColumnComment("客户端域名")
	private String clientDomain;

	@TableField("sysUserUsername")
	@ColumnType(length=20)
	@ColumnComment("系统用户用户名")
	private String sysUserUsername;

	@TableField("sysUserAvatar")
	@ColumnType(length=200)
	@ColumnComment("系统用户头像")
	private String sysUserAvatar;

	@TableField("sysClientName")
	@ColumnType(length=50)
	@ColumnComment("系统客户端名称")
	private String sysClientName;

	@TableField("sysClientLogo")
	@ColumnType(length=200)
	@ColumnComment("系统客户端标识")
	private String sysClientLogo;

}