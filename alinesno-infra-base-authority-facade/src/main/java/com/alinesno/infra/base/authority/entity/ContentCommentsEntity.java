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
@TableName("content_comments")
public class ContentCommentsEntity extends InfraBaseEntity {

	/**
	 * 评论文章
	 */
	@TableField("comment_post_id")
	private Long commentPostId;
	/**
	 * 评论作者
	 */
	@TableField("comment_author")
	private String commentAuthor;
	/**
	 * 评论作者邮箱
	 */
	@TableField("comment_author_email")
	private String commentAuthorEmail;
	/**
	 * 评论作者链接
	 */
	@TableField("comment_author_url")
	private String commentAuthorUrl;
	/**
	 * 评论作者IP
	 */
	@TableField("comment_author_ip")
	private String commentAuthorIp;
	/**
	 * 评论时间
	 */
	@TableField("comment_date")
	private Date commentDate;
	/**
	 * 评论修改时间
	 */
	@TableField("comment_date_gmt")
	private Date commentDateGmt;
	/**
	 * 评论内容
	 */
	@TableField("comment_content")
	private String commentContent;
	/**
	 * 评论用户Id
	 */
	@TableField("user_id")
	private Long userId;

	public Long getCommentPostId() {
		return commentPostId;
	}

	public void setCommentPostId(Long commentPostId) {
		this.commentPostId = commentPostId;
	}

	public String getCommentAuthor() {
		return commentAuthor;
	}

	public void setCommentAuthor(String commentAuthor) {
		this.commentAuthor = commentAuthor;
	}

	public String getCommentAuthorEmail() {
		return commentAuthorEmail;
	}

	public void setCommentAuthorEmail(String commentAuthorEmail) {
		this.commentAuthorEmail = commentAuthorEmail;
	}

	public String getCommentAuthorUrl() {
		return commentAuthorUrl;
	}

	public void setCommentAuthorUrl(String commentAuthorUrl) {
		this.commentAuthorUrl = commentAuthorUrl;
	}

	public String getCommentAuthorIp() {
		return commentAuthorIp;
	}

	public void setCommentAuthorIp(String commentAuthorIp) {
		this.commentAuthorIp = commentAuthorIp;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public Date getCommentDateGmt() {
		return commentDateGmt;
	}

	public void setCommentDateGmt(Date commentDateGmt) {
		this.commentDateGmt = commentDateGmt;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "ContentCommentsEntity{" + "commentPostId=" + commentPostId + ", commentAuthor=" + commentAuthor
				+ ", commentAuthorEmail=" + commentAuthorEmail + ", commentAuthorUrl=" + commentAuthorUrl
				+ ", commentAuthorIp=" + commentAuthorIp + ", commentDate=" + commentDate + ", commentDateGmt="
				+ commentDateGmt + ", commentContent=" + commentContent + ", userId=" + userId + "}";
	}
}
