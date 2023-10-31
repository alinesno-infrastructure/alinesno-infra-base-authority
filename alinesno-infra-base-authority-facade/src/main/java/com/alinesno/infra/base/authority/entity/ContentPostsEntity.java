package com.alinesno.infra.base.authority.entity;

import java.util.Date;

import javax.persistence.Lob;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnComment;
import com.gitee.sunchenbin.mybatis.actable.annotation.ColumnType;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@Data
@TableName("content_posts")
public class ContentPostsEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 文章作者
	 */
	@ColumnType(length = 50)
	@ColumnComment("文章作者")
	@TableField("post_author")
	@Excel(name = "文章作者")
	private String postAuthor;

	/**
	 * 文章日期
	 */
	@ColumnType
	@ColumnComment("文章日期")
	@TableField("post_date")
	private Date postDate;

	/**
	 * 文章内容
	 */
	@ColumnType(length = 30)
	@ColumnComment("文章内容")
	@TableField("post_content")
	@Excel(name = "文章内容", width = 30)
	private String postContent;

	/**
	 * 文章标题
	 */
	@ColumnType(length = 100)
	@ColumnComment("文章标题")
	@TableField("post_title")
	@Excel(name = "文章标题")
	private String postTitle;

	/**
	 * 当前状态(1草稿/2已发布)
	 */
	@ColumnType
	@ColumnComment("当前状态(1草稿/0已发布)")
	@TableField("post_status")
	@Excel(name = "当前状态(1草稿/0已发布)", replace = { "草稿_1", "已发布_0" })
	private Integer postStatus;

	/**
	 * 文章访问密码
	 */
	@ColumnType(length = 50)
	@ColumnComment("文章访问密码")
	@TableField("post_password")
	private String postPassword;

	/**
	 * 文章名称
	 */
	@ColumnType(length = 100)
	@ColumnComment("文章名称")
	@TableField("post_name")
	private String postName;

	/**
	 * 文章最后修改时间
	 */
	@ColumnType
	@ColumnComment("文章最后修改时间")
	@TableField("post_modifield")
	private Date postModifield;

	/**
	 * 文章类型
	 */
	@ColumnType(length = 50)
	@ColumnComment("文章类型")
	@TableField("post_type")
	private String postType;

	/**
	 * 文章分类
	 */
	@ColumnType(length = 50)
	@ColumnComment("文章分类")
	@TableField("post_mime_type")
	@Excel(name = "文章分类")
	private String postMimeType;

	/**
	 * 评论次数
	 */
	@ColumnType
	@ColumnComment("评论次数")
	@TableField("comment_count")
	private Integer commentCount;

	/**
	 * 转发
	 */
	@ColumnType(length = 255)
	@ColumnComment("转发")
	@TableField("to_ping")
	private String toPing;
}