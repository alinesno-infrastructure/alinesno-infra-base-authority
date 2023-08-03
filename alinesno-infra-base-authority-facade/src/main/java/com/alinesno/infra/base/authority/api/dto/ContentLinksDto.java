package com.alinesno.infra.base.authority.api.dto;

import java.util.Date;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： content_links
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ContentLinksDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "linkDescription"
	 */
	private String linkDescription;
	/**
	 * "linkImage"
	 */
	private String linkImage;
	/**
	 * "linkName"
	 */
	private String linkName;
	/**
	 * "linkNotes"
	 */
	private String linkNotes;
	/**
	 * "linkOwner"
	 */
	private Long linkOwner;
	/**
	 * "linkRating"
	 */
	private Long linkRating;
	/**
	 * "linkTarget"
	 */
	private String linkTarget;
	/**
	 * "linkUpdated"
	 */
	private Date linkUpdated;
	/**
	 * "linkUrl"
	 */
	private String linkUrl;
	/**
	 * "linkVisible"
	 */
	private String linkVisible;

	// getter and setter
	public String getLinkDescription()

	{
		return this.linkDescription;
	}

	public ContentLinksDto setLinkDescription(String arg) {
		this.linkDescription = arg;
		return this;
	}

	public String getLinkImage()

	{
		return this.linkImage;
	}

	public ContentLinksDto setLinkImage(String arg) {
		this.linkImage = arg;
		return this;
	}

	public String getLinkName()

	{
		return this.linkName;
	}

	public ContentLinksDto setLinkName(String arg) {
		this.linkName = arg;
		return this;
	}

	public String getLinkNotes()

	{
		return this.linkNotes;
	}

	public ContentLinksDto setLinkNotes(String arg) {
		this.linkNotes = arg;
		return this;
	}

	public Long getLinkOwner()

	{
		return this.linkOwner;
	}

	public ContentLinksDto setLinkOwner(Long arg) {
		this.linkOwner = arg;
		return this;
	}

	public Long getLinkRating()

	{
		return this.linkRating;
	}

	public ContentLinksDto setLinkRating(Long arg) {
		this.linkRating = arg;
		return this;
	}

	public String getLinkTarget()

	{
		return this.linkTarget;
	}

	public ContentLinksDto setLinkTarget(String arg) {
		this.linkTarget = arg;
		return this;
	}

	public Date getLinkUpdated()

	{
		return this.linkUpdated;
	}

	public ContentLinksDto setLinkUpdated(Date arg) {
		this.linkUpdated = arg;
		return this;
	}

	public String getLinkUrl()

	{
		return this.linkUrl;
	}

	public ContentLinksDto setLinkUrl(String arg) {
		this.linkUrl = arg;
		return this;
	}

	public String getLinkVisible()

	{
		return this.linkVisible;
	}

	public ContentLinksDto setLinkVisible(String arg) {
		this.linkVisible = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ContentLinksDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ContentLinksDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ContentLinksDto fromDto(ContentLinksDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ContentLinksDto.class);
	}

}
