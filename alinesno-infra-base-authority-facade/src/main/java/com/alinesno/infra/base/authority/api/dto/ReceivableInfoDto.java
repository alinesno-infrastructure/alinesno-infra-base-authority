package com.alinesno.infra.base.authority.api.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： receivable_info
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ReceivableInfoDto extends BaseDto {
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
	 * "paymentType"
	 */
	private String paymentType;
	/**
	 * "receivableAmount"
	 */
	private BigDecimal receivableAmount;
	/**
	 * "receivableCondition"
	 */
	private String receivableCondition;
	/**
	 * "receivableDate"
	 */
	private Date receivableDate;
	/**
	 * "receivableFund"
	 */
	private String receivableFund;
	/**
	 * "receivableNumber"
	 */
	private String receivableNumber;
	/**
	 * "receivablePanDate"
	 */
	private Date receivablePanDate;
	/**
	 * "receivablePlanId"
	 */
	private String receivablePlanId;

	// getter and setter
	public String getBankAccount()

	{
		return this.bankAccount;
	}

	public ReceivableInfoDto setBankAccount(String arg) {
		this.bankAccount = arg;
		return this;
	}

	public String getContractNumber()

	{
		return this.contractNumber;
	}

	public ReceivableInfoDto setContractNumber(String arg) {
		this.contractNumber = arg;
		return this;
	}

	public String getDepositBank()

	{
		return this.depositBank;
	}

	public ReceivableInfoDto setDepositBank(String arg) {
		this.depositBank = arg;
		return this;
	}

	public String getFinancialProof()

	{
		return this.financialProof;
	}

	public ReceivableInfoDto setFinancialProof(String arg) {
		this.financialProof = arg;
		return this;
	}

	public String getOperatorName()

	{
		return this.operatorName;
	}

	public ReceivableInfoDto setOperatorName(String arg) {
		this.operatorName = arg;
		return this;
	}

	public String getPaymentType()

	{
		return this.paymentType;
	}

	public ReceivableInfoDto setPaymentType(String arg) {
		this.paymentType = arg;
		return this;
	}

	public BigDecimal getReceivableAmount()

	{
		return this.receivableAmount;
	}

	public ReceivableInfoDto setReceivableAmount(BigDecimal arg) {
		this.receivableAmount = arg;
		return this;
	}

	public String getReceivableCondition()

	{
		return this.receivableCondition;
	}

	public ReceivableInfoDto setReceivableCondition(String arg) {
		this.receivableCondition = arg;
		return this;
	}

	public Date getReceivableDate()

	{
		return this.receivableDate;
	}

	public ReceivableInfoDto setReceivableDate(Date arg) {
		this.receivableDate = arg;
		return this;
	}

	public String getReceivableFund()

	{
		return this.receivableFund;
	}

	public ReceivableInfoDto setReceivableFund(String arg) {
		this.receivableFund = arg;
		return this;
	}

	public String getReceivableNumber()

	{
		return this.receivableNumber;
	}

	public ReceivableInfoDto setReceivableNumber(String arg) {
		this.receivableNumber = arg;
		return this;
	}

	public Date getReceivablePanDate()

	{
		return this.receivablePanDate;
	}

	public ReceivableInfoDto setReceivablePanDate(Date arg) {
		this.receivablePanDate = arg;
		return this;
	}

	public String getReceivablePlanId()

	{
		return this.receivablePlanId;
	}

	public ReceivableInfoDto setReceivablePlanId(String arg) {
		this.receivablePlanId = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ReceivableInfoDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ReceivableInfoDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ReceivableInfoDto fromDto(ReceivableInfoDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ReceivableInfoDto.class);
	}

}
