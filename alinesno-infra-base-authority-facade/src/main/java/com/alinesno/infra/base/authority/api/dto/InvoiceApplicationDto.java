package com.alinesno.infra.base.authority.api.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： invoice_application
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class InvoiceApplicationDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "contractNumber"
	 */
	private String contractNumber;
	/**
	 * "identificationNumber"
	 */
	private String identificationNumber;
	/**
	 * "invoiceAmount"
	 */
	private BigDecimal invoiceAmount;
	/**
	 * "invoiceContent"
	 */
	private String invoiceContent;
	/**
	 * "invoiceIssueDate"
	 */
	private Date invoiceIssueDate;
	/**
	 * "invoiceName"
	 */
	private String invoiceName;
	/**
	 * "invoiceNumber"
	 */
	private String invoiceNumber;
	/**
	 * "invoiceReciprocal"
	 */
	private String invoiceReciprocal;
	/**
	 * "invoiceResult"
	 */
	private String invoiceResult;
	/**
	 * "invoiceStatus"
	 */
	private String invoiceStatus;
	/**
	 * "invoiceType"
	 */
	private String invoiceType;
	/**
	 * "taxPoint"
	 */
	private Long taxPoint;

	// getter and setter
	public String getContractNumber()

	{
		return this.contractNumber;
	}

	public InvoiceApplicationDto setContractNumber(String arg) {
		this.contractNumber = arg;
		return this;
	}

	public String getIdentificationNumber()

	{
		return this.identificationNumber;
	}

	public InvoiceApplicationDto setIdentificationNumber(String arg) {
		this.identificationNumber = arg;
		return this;
	}

	public BigDecimal getInvoiceAmount()

	{
		return this.invoiceAmount;
	}

	public InvoiceApplicationDto setInvoiceAmount(BigDecimal arg) {
		this.invoiceAmount = arg;
		return this;
	}

	public String getInvoiceContent()

	{
		return this.invoiceContent;
	}

	public InvoiceApplicationDto setInvoiceContent(String arg) {
		this.invoiceContent = arg;
		return this;
	}

	public Date getInvoiceIssueDate()

	{
		return this.invoiceIssueDate;
	}

	public InvoiceApplicationDto setInvoiceIssueDate(Date arg) {
		this.invoiceIssueDate = arg;
		return this;
	}

	public String getInvoiceName()

	{
		return this.invoiceName;
	}

	public InvoiceApplicationDto setInvoiceName(String arg) {
		this.invoiceName = arg;
		return this;
	}

	public String getInvoiceNumber()

	{
		return this.invoiceNumber;
	}

	public InvoiceApplicationDto setInvoiceNumber(String arg) {
		this.invoiceNumber = arg;
		return this;
	}

	public String getInvoiceReciprocal()

	{
		return this.invoiceReciprocal;
	}

	public InvoiceApplicationDto setInvoiceReciprocal(String arg) {
		this.invoiceReciprocal = arg;
		return this;
	}

	public String getInvoiceResult()

	{
		return this.invoiceResult;
	}

	public InvoiceApplicationDto setInvoiceResult(String arg) {
		this.invoiceResult = arg;
		return this;
	}

	public String getInvoiceStatus()

	{
		return this.invoiceStatus;
	}

	public InvoiceApplicationDto setInvoiceStatus(String arg) {
		this.invoiceStatus = arg;
		return this;
	}

	public String getInvoiceType()

	{
		return this.invoiceType;
	}

	public InvoiceApplicationDto setInvoiceType(String arg) {
		this.invoiceType = arg;
		return this;
	}

	public Long getTaxPoint()

	{
		return this.taxPoint;
	}

	public InvoiceApplicationDto setTaxPoint(Long arg) {
		this.taxPoint = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public InvoiceApplicationDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, InvoiceApplicationDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public InvoiceApplicationDto fromDto(InvoiceApplicationDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, InvoiceApplicationDto.class);
	}

}
