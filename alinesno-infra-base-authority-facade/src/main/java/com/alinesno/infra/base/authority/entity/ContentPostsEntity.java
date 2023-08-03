package com.alinesno.infra.base.authority.entity;

import java.util.Date;

import javax.persistence.Lob;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * <p>
 *
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */

@TableName("content_posts")
public class ContentPostsEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 文章作者
	 */
	@Excel(name = "文章作者")
	@TableField("post_author")
	private String postAuthor;
	/**
	 * 文章日期
	 */
	@TableField("post_date")
	private Date postDate;
	/**
	 * 文章内容
	 */
	@Lob
	@Excel(name = "文章内容 ", width = 30)
	@TableField("post_content")
	private String postContent;
	/**
	 * 文章标题
	 */
	@Excel(name = "文章标题 ")
	@TableField("post_title")
	private String postTitle;
	/**
	 * 当前状态(1草稿/2已发布)
	 */
	@Excel(name = "当前状态(1草稿/0已发布) ", replace = { "草稿_1", "已发布_0" })
	@TableField("post_status")
	private Integer postStatus;
	/**
	 * 文章访问密码
	 */
	@TableField("post_password")
	private String postPassword;
	/**
	 * 文章名称
	 */
	@TableField("post_name")
	private String postName;
	/**
	 * 文章最后修改时间
	 */
	@TableField("post_modifield")
	private Date postModifield;
	/**
	 * 文章类型
	 */
	@TableField("post_type")
	private String postType;
	/**
	 * 文章分类
	 */
	@Excel(name = "文章分类")
	@TableField("post_mime_type")
	private String postMimeType;
	/**
	 * 评论次数
	 */
	@TableField("comment_count")
	private Integer commentCount;
	/**
	 * 转发
	 */
	@TableField("to_ping")
	private String toPing;

	public String getPostAuthor() {
		return postAuthor;
	}

	public void setPostAuthor(String postAuthor) {
		this.postAuthor = postAuthor;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public Integer getPostStatus() {
		return postStatus;
	}

	public void setPostStatus(Integer postStatus) {
		this.postStatus = postStatus;
	}

	public String getPostPassword() {
		return postPassword;
	}

	public void setPostPassword(String postPassword) {
		this.postPassword = postPassword;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public Date getPostModifield() {
		return postModifield;
	}

	public void setPostModifield(Date postModifield) {
		this.postModifield = postModifield;
	}

	public String getPostType() {
		return postType;
	}

	public void setPostType(String postType) {
		this.postType = postType;
	}

	public String getPostMimeType() {
		return postMimeType;
	}

	public void setPostMimeType(String postMimeType) {
		this.postMimeType = postMimeType;
	}

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	public String getToPing() {
		return toPing;
	}

	public void setToPing(String toPing) {
		this.toPing = toPing;
	}

	@Override
	public String toString() {
		return "ContentPostsEntity{" + "postAuthor=" + postAuthor + ", postDate=" + postDate + ", postContent="
				+ postContent + ", postTitle=" + postTitle + ", postStatus=" + postStatus + ", postPassword="
				+ postPassword + ", postName=" + postName + ", postModifield=" + postModifield + ", postType="
				+ postType + ", postMimeType=" + postMimeType + ", commentCount=" + commentCount + ", toPing=" + toPing
				+ "}";
	}
}
