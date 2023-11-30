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
@TableName("content_links")
public class ContentLinksEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 内容链接
	 */
	@ColumnType(length = 255)
	@ColumnComment("内容链接")
	@TableField("link_url")
	private String linkUrl;

	/**
	 * 内容链接名称
	 */
	@ColumnType(length = 100)
	@ColumnComment("内容链接名称")
	@TableField("link_name")
	private String linkName;

	/**
	 * 链接图片
	 */
	@ColumnType(length = 255)
	@ColumnComment("链接图片")
	@TableField("link_image")
	private String linkImage;

	/**
	 * 链接打开目标
	 */
	@ColumnType(length = 20)
	@ColumnComment("链接打开目标")
	@TableField("link_target")
	private String linkTarget;

	/**
	 * 链接描述
	 */
	@ColumnType(length = 500)
	@ColumnComment("链接描述")
	@TableField("link_description")
	private String linkDescription;

	/**
	 * 链接是否可见
	 */
	@ColumnType(length = 1)
	@ColumnComment("链接是否可见")
	@TableField("link_visible")
	private String linkVisible;

	/**
	 * 链接作者
	 */
	@ColumnType
	@ColumnComment("链接作者")
	@TableField("link_owner")
	private Long linkOwner;

	/**
	 * 链接评分
	 */
	@ColumnType
	@ColumnComment("链接评分")
	@TableField("link_rating")
	private Integer linkRating;

	/**
	 * 链接更新时间
	 */
	@ColumnType
	@ColumnComment("链接更新时间")
	@TableField("link_updated")
	private Date linkUpdated;

	/**
	 * 标签
	 */
	@ColumnType(length = 1000)
	@ColumnComment("标签")
	@TableField("link_notes")
	private String linkNotes;

}
