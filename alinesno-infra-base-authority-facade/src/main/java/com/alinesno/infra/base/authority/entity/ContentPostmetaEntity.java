package com.alinesno.infra.base.authority.entity;

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

@TableName("content_postmeta")
public class ContentPostmetaEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 所属文章
	 */
	@TableField("post_id")
	private Long postId;
	/**
	 * 元素key
	 */
	@TableField("meta_key")
	private String metaKey;
	/**
	 * 元素值
	 */
	@TableField("meta_value")
	private String metaValue;

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getMetaKey() {
		return metaKey;
	}

	public void setMetaKey(String metaKey) {
		this.metaKey = metaKey;
	}

	public String getMetaValue() {
		return metaValue;
	}

	public void setMetaValue(String metaValue) {
		this.metaValue = metaValue;
	}

	@Override
	public String toString() {
		return "ContentPostmetaEntity{" + "postId=" + postId + ", metaKey=" + metaKey + ", metaValue=" + metaValue
				+ "}";
	}
}
