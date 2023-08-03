package com.alinesno.infra.base.authority.api.dto;

import java.util.Date;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： content_comments
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ContentCommentsDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "评论作者"
	 */
	private String commentAuthor;
	/**
	 * "评论作者邮箱"
	 */
	private String commentAuthorEmail;
	/**
	 * "评论作者IP"
	 */
	private String commentAuthorIp;
	/**
	 * "评论作者链接"
	 */
	private String commentAuthorUrl;
	/**
	 * "评论内容"
	 */
	private String commentContent;
	/**
	 * "commentDate"
	 */
	private Date commentDate;
	/**
	 * "commentDateGmt"
	 */
	private Date commentDateGmt;
	/**
	 * "评论文章"
	 */
	private Long commentPostId;
	/**
	 * "评论用户Id"
	 */
	private Long userId;

	// getter and setter
	public String getCommentAuthor()

	{
		return this.commentAuthor;
	}

	public ContentCommentsDto setCommentAuthor(String arg) {
		this.commentAuthor = arg;
		return this;
	}

	public String getCommentAuthorEmail()

	{
		return this.commentAuthorEmail;
	}

	public ContentCommentsDto setCommentAuthorEmail(String arg) {
		this.commentAuthorEmail = arg;
		return this;
	}

	public String getCommentAuthorIp()

	{
		return this.commentAuthorIp;
	}

	public ContentCommentsDto setCommentAuthorIp(String arg) {
		this.commentAuthorIp = arg;
		return this;
	}

	public String getCommentAuthorUrl()

	{
		return this.commentAuthorUrl;
	}

	public ContentCommentsDto setCommentAuthorUrl(String arg) {
		this.commentAuthorUrl = arg;
		return this;
	}

	public String getCommentContent()

	{
		return this.commentContent;
	}

	public ContentCommentsDto setCommentContent(String arg) {
		this.commentContent = arg;
		return this;
	}

	public Date getCommentDate()

	{
		return this.commentDate;
	}

	public ContentCommentsDto setCommentDate(Date arg) {
		this.commentDate = arg;
		return this;
	}

	public Date getCommentDateGmt()

	{
		return this.commentDateGmt;
	}

	public ContentCommentsDto setCommentDateGmt(Date arg) {
		this.commentDateGmt = arg;
		return this;
	}

	public Long getCommentPostId()

	{
		return this.commentPostId;
	}

	public ContentCommentsDto setCommentPostId(Long arg) {
		this.commentPostId = arg;
		return this;
	}

	public Long getUserId()

	{
		return this.userId;
	}

	public ContentCommentsDto setUserId(Long arg) {
		this.userId = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ContentCommentsDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ContentCommentsDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ContentCommentsDto fromDto(ContentCommentsDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ContentCommentsDto.class);
	}

}
