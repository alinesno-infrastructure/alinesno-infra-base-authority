package com.alinesno.infra.base.authority.entity;

import java.util.Date;

import javax.persistence.Table;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * <p>
 *
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */

@Table(name = "content_notice")
public class ContentNoticeEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 文章作者
	 */
	@Excel(name = "作者")
	@TableField("notice_author")
	private String noticeAuthor;

	/**
	 * 文章日期
	 */
	@TableField("notice_date")
	private Date noticeDate;

	/**
	 * 文章内容
	 */
	@Excel(name = "通知内容")
	@TableField("notice_content")
	private String noticeContent;

	/**
	 * 文章标题
	 */
	@Excel(name = "标题")
	@TableField("notice_title")
	private String noticeTitle;

	/**
	 * 当前状态(1草稿/2已发布)
	 */
	@TableField("notice_status")
	private Integer noticeStatus;

	/**
	 * 文章访问密码
	 */
	@TableField("notice_password")
	private String noticePassword;

	/**
	 * 文章名称
	 */
	@TableField("notice_name")
	private String noticeName;

	/**
	 * 文章最后修改时间
	 */
	@TableField("notice_modifield")
	private Date noticeModifield;

	/**
	 * 文章类型
	 */
	@TableField("notice_type")
	private String noticeType;

	public String getNoticeAuthor() {
		return noticeAuthor;
	}

	public void setNoticeAuthor(String noticeAuthor) {
		this.noticeAuthor = noticeAuthor;
	}

	public Date getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public Integer getNoticeStatus() {
		return noticeStatus;
	}

	public void setNoticeStatus(Integer noticeStatus) {
		this.noticeStatus = noticeStatus;
	}

	public String getNoticePassword() {
		return noticePassword;
	}

	public void setNoticePassword(String noticePassword) {
		this.noticePassword = noticePassword;
	}

	public String getNoticeName() {
		return noticeName;
	}

	public void setNoticeName(String noticeName) {
		this.noticeName = noticeName;
	}

	public Date getNoticeModifield() {
		return noticeModifield;
	}

	public void setNoticeModifield(Date noticeModifield) {
		this.noticeModifield = noticeModifield;
	}

	public String getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
	}

}
