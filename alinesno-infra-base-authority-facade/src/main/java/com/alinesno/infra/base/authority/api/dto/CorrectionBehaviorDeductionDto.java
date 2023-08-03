package com.alinesno.infra.base.authority.api.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 操行扣分设置 数据表： correction_behavior_deduction
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class CorrectionBehaviorDeductionDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "扣分项目"
	 */
	private String deductionName;
	/**
	 * "考核内容"
	 */
	private String content;
	/**
	 * "一般扣分"
	 */
	private String normal;
	/**
	 * "严重扣分"
	 */
	private String serious;
	/**
	 * "填写人"
	 */
	private String writer;
	/**
	 * "reserved1"
	 */
	private String reserved1;
	/**
	 * "reserved2"
	 */
	private String reserved2;
	/**
	 * "reserved3"
	 */
	private String reserved3;
	/**
	 * "reserved4"
	 */
	private String reserved4;
	/**
	 * "reserved5"
	 */
	private String reserved5;

	// getter and setter
	public String getDeductionName()

	{
		return this.deductionName;
	}

	public CorrectionBehaviorDeductionDto setDeductionName(String arg) {
		this.deductionName = arg;
		return this;
	}

	public String getContent()

	{
		return this.content;
	}

	public CorrectionBehaviorDeductionDto setContent(String arg) {
		this.content = arg;
		return this;
	}

	public String getNormal()

	{
		return this.normal;
	}

	public CorrectionBehaviorDeductionDto setNormal(String arg) {
		this.normal = arg;
		return this;
	}

	public String getSerious()

	{
		return this.serious;
	}

	public CorrectionBehaviorDeductionDto setSerious(String arg) {
		this.serious = arg;
		return this;
	}

	public String getWriter()

	{
		return this.writer;
	}

	public CorrectionBehaviorDeductionDto setWriter(String arg) {
		this.writer = arg;
		return this;
	}

	public String getReserved1()

	{
		return this.reserved1;
	}

	public CorrectionBehaviorDeductionDto setReserved1(String arg) {
		this.reserved1 = arg;
		return this;
	}

	public String getReserved2()

	{
		return this.reserved2;
	}

	public CorrectionBehaviorDeductionDto setReserved2(String arg) {
		this.reserved2 = arg;
		return this;
	}

	public String getReserved3()

	{
		return this.reserved3;
	}

	public CorrectionBehaviorDeductionDto setReserved3(String arg) {
		this.reserved3 = arg;
		return this;
	}

	public String getReserved4()

	{
		return this.reserved4;
	}

	public CorrectionBehaviorDeductionDto setReserved4(String arg) {
		this.reserved4 = arg;
		return this;
	}

	public String getReserved5()

	{
		return this.reserved5;
	}

	public CorrectionBehaviorDeductionDto setReserved5(String arg) {
		this.reserved5 = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public CorrectionBehaviorDeductionDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, CorrectionBehaviorDeductionDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public CorrectionBehaviorDeductionDto fromDto(CorrectionBehaviorDeductionDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, CorrectionBehaviorDeductionDto.class);
	}

}
