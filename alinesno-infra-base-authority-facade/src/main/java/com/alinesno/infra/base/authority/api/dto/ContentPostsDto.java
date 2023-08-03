package com.alinesno.infra.base.authority.api.dto;

import java.util.Date;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： content_posts
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ContentPostsDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "commentCount"
	 */
	private Long commentCount;
	/**
	 * "postAuthor"
	 */
	private String postAuthor;
	/**
	 * "postContent"
	 */
	private String postContent;
	/**
	 * "postDate"
	 */
	private Date postDate;
	/**
	 * "postMimeType"
	 */
	private String postMimeType;
	/**
	 * "postModifield"
	 */
	private Date postModifield;
	/**
	 * "postName"
	 */
	private String postName;
	/**
	 * "postPassword"
	 */
	private String postPassword;
	/**
	 * "postStatus"
	 */
	private Long postStatus;
	/**
	 * "postTitle"
	 */
	private String postTitle;
	/**
	 * "postType"
	 */
	private String postType;
	/**
	 * "toPing"
	 */
	private String toPing;

	// getter and setter
	public Long getCommentCount()

	{
		return this.commentCount;
	}

	public ContentPostsDto setCommentCount(Long arg) {
		this.commentCount = arg;
		return this;
	}

	public String getPostAuthor()

	{
		return this.postAuthor;
	}

	public ContentPostsDto setPostAuthor(String arg) {
		this.postAuthor = arg;
		return this;
	}

	public String getPostContent()

	{
		return this.postContent;
	}

	public ContentPostsDto setPostContent(String arg) {
		this.postContent = arg;
		return this;
	}

	public Date getPostDate()

	{
		return this.postDate;
	}

	public ContentPostsDto setPostDate(Date arg) {
		this.postDate = arg;
		return this;
	}

	public String getPostMimeType()

	{
		return this.postMimeType;
	}

	public ContentPostsDto setPostMimeType(String arg) {
		this.postMimeType = arg;
		return this;
	}

	public Date getPostModifield()

	{
		return this.postModifield;
	}

	public ContentPostsDto setPostModifield(Date arg) {
		this.postModifield = arg;
		return this;
	}

	public String getPostName()

	{
		return this.postName;
	}

	public ContentPostsDto setPostName(String arg) {
		this.postName = arg;
		return this;
	}

	public String getPostPassword()

	{
		return this.postPassword;
	}

	public ContentPostsDto setPostPassword(String arg) {
		this.postPassword = arg;
		return this;
	}

	public Long getPostStatus()

	{
		return this.postStatus;
	}

	public ContentPostsDto setPostStatus(Long arg) {
		this.postStatus = arg;
		return this;
	}

	public String getPostTitle()

	{
		return this.postTitle;
	}

	public ContentPostsDto setPostTitle(String arg) {
		this.postTitle = arg;
		return this;
	}

	public String getPostType()

	{
		return this.postType;
	}

	public ContentPostsDto setPostType(String arg) {
		this.postType = arg;
		return this;
	}

	public String getToPing()

	{
		return this.toPing;
	}

	public ContentPostsDto setToPing(String arg) {
		this.toPing = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ContentPostsDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ContentPostsDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ContentPostsDto fromDto(ContentPostsDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ContentPostsDto.class);
	}

}
