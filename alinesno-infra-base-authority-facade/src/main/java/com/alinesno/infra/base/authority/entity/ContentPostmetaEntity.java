package com.alinesno.infra.base.authority.entity;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("content_postmeta")
public class ContentPostmetaEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 所属文章
	 */
	@ColumnType
	@ColumnComment("所属文章")
	@TableField("post_id")
	private Long postId;

	/**
	 * 元素key
	 */
	@ColumnType(length = 100)
	@ColumnComment("元素key")
	@TableField("meta_key")
	private String metaKey;

	/**
	 * 元素值
	 */
	@ColumnType(length = 1000)
	@ColumnComment("元素值")
	@TableField("meta_value")
	private String metaValue;

}
