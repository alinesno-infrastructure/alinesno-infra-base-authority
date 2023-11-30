package com.alinesno.infra.base.authority.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@Data
@TableName("manager_user")
public class ManagerUserEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 登陆账户
	 */
	@TableField("user_account")
	@ColumnType(length = 255)
	@ColumnComment("登陆账户")
	private String userAccount;

	/**
	 * 用户密码
	 */
	@TableField("user_password")
	@ColumnType(length = 255)
	@ColumnComment("用户密码")
	private String userPassword;

	/**
	 * 用户加密字段
	 */
	@TableField("user_salt")
	@ColumnType(length = 255)
	@ColumnComment("用户加密字段")
	private String userSalt;

	/**
	 * 添加时间
	 */
	@TableField("user_addtime")
	@ColumnType
	@ColumnComment("添加时间")
	private Date userAddtime;

	/**
	 * 状态(1正常/0非法)
	 */
	@TableField("user_status")
	@ColumnType(length = 1)
	@ColumnComment("状态(1正常/0非法)")
	private Boolean userStatus;

	/**
	 * 用户角色
	 */
	@TableField("user_role")
	@ColumnType(length = 255)
	@ColumnComment("用户角色")
	private String userRole;

	/**
	 * 用户类型(1超级管理员/0普通管理员)
	 */
	@TableField("user_type")
	@ColumnType(length = 1)
	@ColumnComment("用户类型(1超级管理员/0普通管理员)")
	private Boolean userType;

	/**
	 * 用户名称
	 */
	@TableField("user_name")
	@ColumnType(length = 255)
	@ColumnComment("用户名称")
	private String userName;

}