package com.alinesno.cloud.base.boot.entity;

import java.sql.Blob;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * <p>
 * 会话监控表
 * </p>
 *
 * @author WeiXiaoJin
 * @since 2020-04-14 11:59:54
 */

@TableName("user_session")
public class UserSessionEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户会话id
	 */
	@Excel(name = "用户会话id")
//	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	@TableField("session_id")
	private String sessionId;
	/**
	 * 部门名称
	 */
	@Excel(name = "部门名称")
	@TableField("dept_name")
	private String deptName;
	/**
	 * 登录名称
	 */
	@Excel(name = "登录名称")
	@TableField("login_name")
	private String loginName;
	/**
	 * 登录IP地址
	 */
	@Excel(name = "登录IP地址")
	@TableField("ip_addr")
	private String ipaddr;
	/**
	 * 登录地址
	 */
	@Excel(name = "登录地址")
	@TableField("login_location")
	private String loginLocation;
	/**
	 * 浏览器类型
	 */
	@Excel(name = "浏览器类型")
	@TableField
	private String browser;
	/**
	 * 操作系统
	 */
	@Excel(name = "操作系统")
	@TableField
	private String os;
	/**
	 * session创建时间
	 */
	@Excel(name = "session创建时间")
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	@TableField("start_time_stamp")
	private Date startTimestamp;
	/**
	 * session最后访问时间
	 */
	@Excel(name = "session最后访问时间")
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	@TableField("last_access_time")
	private Date lastAccessTime;
	/**
	 * 超时时间，单位为分钟
	 */
	@Excel(name = "超时时间")
	private Blob expireTime;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getIpaddr() {
		return ipaddr;
	}

	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}

	public String getLoginLocation() {
		return loginLocation;
	}

	public void setLoginLocation(String loginLocation) {
		this.loginLocation = loginLocation;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public Date getStartTimestamp() {
		return startTimestamp;
	}

	public void setStartTimestamp(Date startTimestamp) {
		this.startTimestamp = startTimestamp;
	}

	public Date getLastAccessTime() {
		return lastAccessTime;
	}

	public void setLastAccessTime(Date lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}

	public Blob getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Blob expireTime) {
		this.expireTime = expireTime;
	}

	@Override
	public String toString() {
		return "UserSessionEntity{" + "sessionId=" + sessionId + ", deptName=" + deptName + ", loginName=" + loginName
				+ ", ipaddr=" + ipaddr + ", loginLocation=" + loginLocation + ", browser=" + browser + ", os=" + os
				+ ", startTimestamp=" + startTimestamp + ", lastAccessTime=" + lastAccessTime + ", expireTime="
				+ expireTime + "}";
	}
}
