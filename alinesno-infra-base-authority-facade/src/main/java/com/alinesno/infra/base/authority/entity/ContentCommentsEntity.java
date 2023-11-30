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
@TableName("content_comments")
public class ContentCommentsEntity extends InfraBaseEntity {

	/**
	 * 评论文章
	 */
	@ColumnType(length = 20)
	@ColumnComment("评论文章")
	@TableField("comment_post_id")
	private Long commentPostId;

	/**
	 * 评论作者
	 */
	@ColumnType(length = 50)
	@ColumnComment("评论作者")
	@TableField("comment_author")
	private String commentAuthor;

	/**
	 * 评论作者邮箱
	 */
	@ColumnType(length = 100)
	@ColumnComment("评论作者邮箱")
	@TableField("comment_author_email")
	private String commentAuthorEmail;

	/**
	 * 评论作者链接
	 */
	@ColumnType(length = 200)
	@ColumnComment("评论作者链接")
	@TableField("comment_author_url")
	private String commentAuthorUrl;

	/**
	 * 评论作者IP
	 */
	@ColumnType(length = 50)
	@ColumnComment("评论作者IP")
	@TableField("comment_author_ip")
	private String commentAuthorIp;

	/**
	 * 评论时间
	 */
	@ColumnType
	@ColumnComment("评论时间")
	@TableField("comment_date")
	private Date commentDate;

	/**
	 * 评论修改时间
	 */
	@ColumnType
	@ColumnComment("评论修改时间")
	@TableField("comment_date_gmt")
	private Date commentDateGmt;

	/**
	 * 评论内容
	 */
	@ColumnType
	@ColumnComment("评论内容")
	@TableField("comment_content")
	private String commentContent;

	/**
	 * 评论用户Id
	 */
	@ColumnType
	@ColumnComment("评论用户Id")
	@TableField("user_id")
	private Long userId;

}
