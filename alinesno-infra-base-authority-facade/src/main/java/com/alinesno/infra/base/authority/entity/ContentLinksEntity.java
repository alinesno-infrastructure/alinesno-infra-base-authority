package com.alinesno.infra.base.authority.entity;

import java.util.Date;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 *
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */

@TableName("content_links")
public class ContentLinksEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 内容链接
	 */
	@TableField("link_url")
	private String linkUrl;
	/**
	 * 内容链接名称
	 */
	@TableField("link_name")
	private String linkName;
	/**
	 * 链接图片
	 */
	@TableField("link_image")
	private String linkImage;
	/**
	 * 链接打开目标
	 */
	@TableField("link_target")
	private String linkTarget;
	/**
	 * 链接描述
	 */
	@TableField("link_description")
	private String linkDescription;
	/**
	 * 链接是否可见
	 */
	@TableField("link_visible")
	private String linkVisible;
	/**
	 * 链接作者
	 */
	@TableField("link_owner")
	private Long linkOwner;
	/**
	 * 链接评分
	 */
	@TableField("link_rating")
	private Integer linkRating;
	/**
	 * 链接更新时间
	 */
	@TableField("link_updated")
	private Date linkUpdated;
	/**
	 * 标签
	 */
	@TableField("link_notes")
	private String linkNotes;

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public String getLinkImage() {
		return linkImage;
	}

	public void setLinkImage(String linkImage) {
		this.linkImage = linkImage;
	}

	public String getLinkTarget() {
		return linkTarget;
	}

	public void setLinkTarget(String linkTarget) {
		this.linkTarget = linkTarget;
	}

	public String getLinkDescription() {
		return linkDescription;
	}

	public void setLinkDescription(String linkDescription) {
		this.linkDescription = linkDescription;
	}

	public String getLinkVisible() {
		return linkVisible;
	}

	public void setLinkVisible(String linkVisible) {
		this.linkVisible = linkVisible;
	}

	public Long getLinkOwner() {
		return linkOwner;
	}

	public void setLinkOwner(Long linkOwner) {
		this.linkOwner = linkOwner;
	}

	public Integer getLinkRating() {
		return linkRating;
	}

	public void setLinkRating(Integer linkRating) {
		this.linkRating = linkRating;
	}

	public Date getLinkUpdated() {
		return linkUpdated;
	}

	public void setLinkUpdated(Date linkUpdated) {
		this.linkUpdated = linkUpdated;
	}

	public String getLinkNotes() {
		return linkNotes;
	}

	public void setLinkNotes(String linkNotes) {
		this.linkNotes = linkNotes;
	}

	@Override
	public String toString() {
		return "ContentLinksEntity{" + "linkUrl=" + linkUrl + ", linkName=" + linkName + ", linkImage=" + linkImage
				+ ", linkTarget=" + linkTarget + ", linkDescription=" + linkDescription + ", linkVisible=" + linkVisible
				+ ", linkOwner=" + linkOwner + ", linkRating=" + linkRating + ", linkUpdated=" + linkUpdated
				+ ", linkNotes=" + linkNotes + "}";
	}
}
