package com.alinesno.infra.base.authority.api.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： payment_plans_info
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class PaymentPlansInfoDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "bankAccount"
	 */
	private String bankAccount;
	/**
	 * "companyName"
	 */
	private String companyName;
	/**
	 * "contactName"
	 */
	private String contactName;
	/**
	 * "contactPhone"
	 */
	private String contactPhone;
	/**
	 * "contractNumber"
	 */
	private String contractNumber;
	/**
	 * "depositBank"
	 */
	private String depositBank;
	/**
	 * "paymentAmount"
	 */
	private BigDecimal paymentAmount;
	/**
	 * "paymentNumber"
	 */
	private String paymentNumber;
	/**
	 * "paymentTerms"
	 */
	private String paymentTerms;
	/**
	 * "paymentType"
	 */
	private String paymentType;
	/**
	 * "planStatus"
	 */
	private String planStatus;
	/**
	 * "plannedPaymentDate"
	 */
	private Date plannedPaymentDate;
	/**
	 * "remark"
	 */
	private String remark;
	/**
	 * "signatoryContactId"
	 */
	private String signatoryContactId;
	/**
	 * "sortNum"
	 */
	private Long sortNum;

	// getter and setter
	public String getBankAccount()

	{
		return this.bankAccount;
	}

	public PaymentPlansInfoDto setBankAccount(String arg) {
		this.bankAccount = arg;
		return this;
	}

	public String getCompanyName()

	{
		return this.companyName;
	}

	public PaymentPlansInfoDto setCompanyName(String arg) {
		this.companyName = arg;
		return this;
	}

	public String getContactName()

	{
		return this.contactName;
	}

	public PaymentPlansInfoDto setContactName(String arg) {
		this.contactName = arg;
		return this;
	}

	public String getContactPhone()

	{
		return this.contactPhone;
	}

	public PaymentPlansInfoDto setContactPhone(String arg) {
		this.contactPhone = arg;
		return this;
	}

	public String getContractNumber()

	{
		return this.contractNumber;
	}

	public PaymentPlansInfoDto setContractNumber(String arg) {
		this.contractNumber = arg;
		return this;
	}

	public String getDepositBank()

	{
		return this.depositBank;
	}

	public PaymentPlansInfoDto setDepositBank(String arg) {
		this.depositBank = arg;
		return this;
	}

	public BigDecimal getPaymentAmount()

	{
		return this.paymentAmount;
	}

	public PaymentPlansInfoDto setPaymentAmount(BigDecimal arg) {
		this.paymentAmount = arg;
		return this;
	}

	public String getPaymentNumber()

	{
		return this.paymentNumber;
	}

	public PaymentPlansInfoDto setPaymentNumber(String arg) {
		this.paymentNumber = arg;
		return this;
	}

	public String getPaymentTerms()

	{
		return this.paymentTerms;
	}

	public PaymentPlansInfoDto setPaymentTerms(String arg) {
		this.paymentTerms = arg;
		return this;
	}

	public String getPaymentType()

	{
		return this.paymentType;
	}

	public PaymentPlansInfoDto setPaymentType(String arg) {
		this.paymentType = arg;
		return this;
	}

	public String getPlanStatus()

	{
		return this.planStatus;
	}

	public PaymentPlansInfoDto setPlanStatus(String arg) {
		this.planStatus = arg;
		return this;
	}

	public Date getPlannedPaymentDate()

	{
		return this.plannedPaymentDate;
	}

	public PaymentPlansInfoDto setPlannedPaymentDate(Date arg) {
		this.plannedPaymentDate = arg;
		return this;
	}

	public String getRemark()

	{
		return this.remark;
	}

	public PaymentPlansInfoDto setRemark(String arg) {
		this.remark = arg;
		return this;
	}

	public String getSignatoryContactId()

	{
		return this.signatoryContactId;
	}

	public PaymentPlansInfoDto setSignatoryContactId(String arg) {
		this.signatoryContactId = arg;
		return this;
	}

	public Long getSortNum()

	{
		return this.sortNum;
	}

	public PaymentPlansInfoDto setSortNum(Long arg) {
		this.sortNum = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public PaymentPlansInfoDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, PaymentPlansInfoDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public PaymentPlansInfoDto fromDto(PaymentPlansInfoDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, PaymentPlansInfoDto.class);
	}

}
