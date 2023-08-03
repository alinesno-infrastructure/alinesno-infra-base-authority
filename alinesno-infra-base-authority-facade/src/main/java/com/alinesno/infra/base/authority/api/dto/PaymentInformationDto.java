package com.alinesno.infra.base.authority.api.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： payment_information
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class PaymentInformationDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "bankAccount"
	 */
	private String bankAccount;
	/**
	 * "contractNumber"
	 */
	private String contractNumber;
	/**
	 * "depositBank"
	 */
	private String depositBank;
	/**
	 * "financialProof"
	 */
	private String financialProof;
	/**
	 * "operatorName"
	 */
	private String operatorName;
	/**
	 * "paymentAmount"
	 */
	private BigDecimal paymentAmount;
	/**
	 * "paymentMode"
	 */
	private String paymentMode;
	/**
	 * "paymentNumber"
	 */
	private String paymentNumber;
	/**
	 * "paymentPlansId"
	 */
	private String paymentPlansId;
	/**
	 * "paymentTerms"
	 */
	private String paymentTerms;
	/**
	 * "paymentTime"
	 */
	private Date paymentTime;
	/**
	 * "paymentType"
	 */
	private String paymentType;
	/**
	 * "plannedPaymentDate"
	 */
	private Date plannedPaymentDate;

	// getter and setter
	public String getBankAccount()

	{
		return this.bankAccount;
	}

	public PaymentInformationDto setBankAccount(String arg) {
		this.bankAccount = arg;
		return this;
	}

	public String getContractNumber()

	{
		return this.contractNumber;
	}

	public PaymentInformationDto setContractNumber(String arg) {
		this.contractNumber = arg;
		return this;
	}

	public String getDepositBank()

	{
		return this.depositBank;
	}

	public PaymentInformationDto setDepositBank(String arg) {
		this.depositBank = arg;
		return this;
	}

	public String getFinancialProof()

	{
		return this.financialProof;
	}

	public PaymentInformationDto setFinancialProof(String arg) {
		this.financialProof = arg;
		return this;
	}

	public String getOperatorName()

	{
		return this.operatorName;
	}

	public PaymentInformationDto setOperatorName(String arg) {
		this.operatorName = arg;
		return this;
	}

	public BigDecimal getPaymentAmount()

	{
		return this.paymentAmount;
	}

	public PaymentInformationDto setPaymentAmount(BigDecimal arg) {
		this.paymentAmount = arg;
		return this;
	}

	public String getPaymentMode()

	{
		return this.paymentMode;
	}

	public PaymentInformationDto setPaymentMode(String arg) {
		this.paymentMode = arg;
		return this;
	}

	public String getPaymentNumber()

	{
		return this.paymentNumber;
	}

	public PaymentInformationDto setPaymentNumber(String arg) {
		this.paymentNumber = arg;
		return this;
	}

	public String getPaymentPlansId()

	{
		return this.paymentPlansId;
	}

	public PaymentInformationDto setPaymentPlansId(String arg) {
		this.paymentPlansId = arg;
		return this;
	}

	public String getPaymentTerms()

	{
		return this.paymentTerms;
	}

	public PaymentInformationDto setPaymentTerms(String arg) {
		this.paymentTerms = arg;
		return this;
	}

	public Date getPaymentTime()

	{
		return this.paymentTime;
	}

	public PaymentInformationDto setPaymentTime(Date arg) {
		this.paymentTime = arg;
		return this;
	}

	public String getPaymentType()

	{
		return this.paymentType;
	}

	public PaymentInformationDto setPaymentType(String arg) {
		this.paymentType = arg;
		return this;
	}

	public Date getPlannedPaymentDate()

	{
		return this.plannedPaymentDate;
	}

	public PaymentInformationDto setPlannedPaymentDate(Date arg) {
		this.plannedPaymentDate = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public PaymentInformationDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, PaymentInformationDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public PaymentInformationDto fromDto(PaymentInformationDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, PaymentInformationDto.class);
	}

}
