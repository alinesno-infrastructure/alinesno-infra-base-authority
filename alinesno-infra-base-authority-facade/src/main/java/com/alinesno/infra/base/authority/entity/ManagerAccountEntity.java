package com.alinesno.infra.base.authority.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;

import java.util.Set;

/**
 * <p>
 *
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@Data
@SuppressWarnings("serial")
@TableName("manager_account")
public class ManagerAccountEntity extends InfraBaseEntity {

	/**
	 * 所属者
	 */
	@ColumnType
	@ColumnComment("所属者")
	@TableField
	private String owners;

	/**
	 * 账户状态
	 */
	@ColumnType(length = 20)
	@ColumnComment("账户状态")
	@TableField("account_status")
	private Integer accountStatus = 1;

	/**
	 * 用户头像
	 */
	@Excel(name = "用户头像")
	@ColumnType(length = 100)
	@ColumnComment("用户头像")
	@TableField("avatar_path")
	private String avatarPath;

	/**
	 * 最后登陆ip
	 */
	@Excel(name = "最后登陆IP")
	@ColumnType(length = 20)
	@ColumnComment("最后登陆IP")
	@TableField("last_login_ip")
	private String lastLoginIp;

	/**
	 * 最后登陆时间
	 */
	@Excel(name = "最后登陆时间")
	@ColumnType(length = 20)
	@ColumnComment("最后登陆时间")
	@TableField("last_login_time")
	private String lastLoginTime;

	/**
	 * 登陆名称
	 */
	@Excel(name = "登陆名")
	@ColumnType(length = 100)
	@ColumnComment("登陆名")
	@TableField("login_name")
	private String loginName;

	/**
	 * 登陆密码
	 */
	@ColumnType(length = 100)
	@ColumnComment("登陆密码")
	@TableField("password")
	private String password;

	/**
	 * 加密字符
	 */
	@ColumnType(length = 100)
	@ColumnComment("加密字符")
	@TableField("salt")
	private String salt;

	/**
	 * 用户信息id
	 */
	@ColumnType(length = 100)
	@ColumnComment("用户信息id")
	@TableField("user_id")
	private String userId;

	/**
	 * 所属角色
	 */
	@Excel(name = "角色ID")
	@ColumnType(length = 100)
	@ColumnComment("所属角色")
	@TableField("role_id")
	private String roleId;

	/**
	 * 用户名称.
	 */
	@Excel(name = "用户名称")
	@ColumnType(length = 100)
	@ColumnComment("用户名称")
	@TableField
	private String name;

	/**
	 * 用户权限(9超级管理员/1机构权限/0用户权限)
	 */
	@Excel(name = "用户权限", replace = {"超级管理员_9", "机构权限_1", "用户权限_0"})
	@ColumnType(length = 100)
	@ColumnComment("用户权限")
	@TableField("role_power")
	private String rolePower;

	/**
	 * 用户手机号
	 */
	@Excel(name = "手机号")
	@ColumnType(length = 20)
	@ColumnComment("用户手机号")
	@TableField("phone")
	private String phone;

	/**
	 * 用户邮箱
	 */
	@Excel(name = "邮箱")
	@ColumnType(length = 100)
	@ColumnComment("用户邮箱")
	@TableField("email")
	private String email;

	/**
	 * 是否包含编辑权限
	 */
	@ColumnType(length = 1)
	@ColumnComment("是否包含编辑权限")
	@TableField("has_editor")
	private String hasEditor;

	/**
	 * 性别
	 */
	@Excel(name = "性别", replace = {"男_1", "女_0"})
	@ColumnType(length = 1)
	@ColumnComment("性别")
	@TableField("sex")
	private String sex;

//	@ColumnType(length = 100)
//	@ColumnComment("CAS账户ID")
//	@TableField("cas_account_id")
//	private String casAccountId;

	/**
	 * 所属部门
	 */
	@ColumnType(length = 100)
	@ColumnComment("所属部门")
	@TableField("department")
	private String department;

	/**
	 * 企业属性(1=企业用户|0普通用户)
	 */
	@Excel(name = "企业属性", replace = {"企业用户_1", "普通用户_0"})
	@ColumnType(length = 1)
	@ColumnComment("企业属性")
	@TableField("enterprise_properties")
	private String enterpriseProperties = "0";

	/**
	 * 委托人
	 */
	@Excel(name = "委托人")
	@ColumnType(length = 100)
	@ColumnComment("委托人")
	@TableField("bailor")
	private String bailor;

	/**
	 * 所属岗位
	 */
	@ColumnType(length = 100)
	@ColumnComment("所属岗位")
	@TableField("position_id")
	private String positionId;

	/**
	 * 首页属性(用于设置默认首页)，用于放置选择应用
	 */
	@ColumnType(length = 100)
	@ColumnComment("首页属性")
	@TableField("portal_prop")
	private String portalProp;

	@TableField(exist = false)
	private Set<String> role;

	@TableField(exist = false)
	private Set<String> permission;
}
