package com.alinesno.infra.base.authority.api.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： receivable_plan_info
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ReceivablePlanInfoDto extends BaseDto {
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
	 * "planStatus"
	 */
	private String planStatus;
	/**
	 * "receivableAmount"
	 */
	private BigDecimal receivableAmount;
	/**
	 * "receivableCondition"
	 */
	private String receivableCondition;
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
	 * "receivableType"
	 */
	private String receivableType;
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

	public ReceivablePlanInfoDto setBankAccount(String arg) {
		this.bankAccount = arg;
		return this;
	}

	public String getCompanyName()

	{
		return this.companyName;
	}

	public ReceivablePlanInfoDto setCompanyName(String arg) {
		this.companyName = arg;
		return this;
	}

	public String getContactName()

	{
		return this.contactName;
	}

	public ReceivablePlanInfoDto setContactName(String arg) {
		this.contactName = arg;
		return this;
	}

	public String getContactPhone()

	{
		return this.contactPhone;
	}

	public ReceivablePlanInfoDto setContactPhone(String arg) {
		this.contactPhone = arg;
		return this;
	}

	public String getContractNumber()

	{
		return this.contractNumber;
	}

	public ReceivablePlanInfoDto setContractNumber(String arg) {
		this.contractNumber = arg;
		return this;
	}

	public String getDepositBank()

	{
		return this.depositBank;
	}

	public ReceivablePlanInfoDto setDepositBank(String arg) {
		this.depositBank = arg;
		return this;
	}

	public String getPlanStatus()

	{
		return this.planStatus;
	}

	public ReceivablePlanInfoDto setPlanStatus(String arg) {
		this.planStatus = arg;
		return this;
	}

	public BigDecimal getReceivableAmount()

	{
		return this.receivableAmount;
	}

	public ReceivablePlanInfoDto setReceivableAmount(BigDecimal arg) {
		this.receivableAmount = arg;
		return this;
	}

	public String getReceivableCondition()

	{
		return this.receivableCondition;
	}

	public ReceivablePlanInfoDto setReceivableCondition(String arg) {
		this.receivableCondition = arg;
		return this;
	}

	public String getReceivableFund()

	{
		return this.receivableFund;
	}

	public ReceivablePlanInfoDto setReceivableFund(String arg) {
		this.receivableFund = arg;
		return this;
	}

	public String getReceivableNumber()

	{
		return this.receivableNumber;
	}

	public ReceivablePlanInfoDto setReceivableNumber(String arg) {
		this.receivableNumber = arg;
		return this;
	}

	public Date getReceivablePanDate()

	{
		return this.receivablePanDate;
	}

	public ReceivablePlanInfoDto setReceivablePanDate(Date arg) {
		this.receivablePanDate = arg;
		return this;
	}

	public String getReceivableType()

	{
		return this.receivableType;
	}

	public ReceivablePlanInfoDto setReceivableType(String arg) {
		this.receivableType = arg;
		return this;
	}

	public String getRemark()

	{
		return this.remark;
	}

	public ReceivablePlanInfoDto setRemark(String arg) {
		this.remark = arg;
		return this;
	}

	public String getSignatoryContactId()

	{
		return this.signatoryContactId;
	}

	public ReceivablePlanInfoDto setSignatoryContactId(String arg) {
		this.signatoryContactId = arg;
		return this;
	}

	public Long getSortNum()

	{
		return this.sortNum;
	}

	public ReceivablePlanInfoDto setSortNum(Long arg) {
		this.sortNum = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ReceivablePlanInfoDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ReceivablePlanInfoDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ReceivablePlanInfoDto fromDto(ReceivablePlanInfoDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ReceivablePlanInfoDto.class);
	}

}
