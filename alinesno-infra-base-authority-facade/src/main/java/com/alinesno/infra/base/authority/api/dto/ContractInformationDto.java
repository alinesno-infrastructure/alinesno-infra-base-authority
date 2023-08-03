package com.alinesno.infra.base.authority.api.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： contract_information
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ContractInformationDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "applicationDate"
	 */
	private Date applicationDate;
	/**
	 * "approvalProgress"
	 */
	private String approvalProgress;
	/**
	 * "contractAmount"
	 */
	private BigDecimal contractAmount;
	/**
	 * "contractAttachmentId"
	 */
	private String contractAttachmentId;
	/**
	 * "contractBackgroud"
	 */
	private String contractBackgroud;
	/**
	 * "contractBeginTime"
	 */
	private Date contractBeginTime;
	/**
	 * "contractEndTime"
	 */
	private Date contractEndTime;
	/**
	 * "contractName"
	 */
	private String contractName;
	/**
	 * "contractNumber"
	 */
	private String contractNumber;
	/**
	 * "contractStatus"
	 */
	private String contractStatus;
	/**
	 * "contractType"
	 */
	private String contractType;
	/**
	 * "departmentName"
	 */
	private String departmentName;
	/**
	 * "examineMaterialId"
	 */
	private String examineMaterialId;
	/**
	 * "filingDate"
	 */
	private Date filingDate;
	/**
	 * "finalAppealDate"
	 */
	private Date finalAppealDate;
	/**
	 * "legalOpinionId"
	 */
	private String legalOpinionId;
	/**
	 * "operatorName"
	 */
	private String operatorName;
	/**
	 * "ortherMaterialId"
	 */
	private String ortherMaterialId;
	/**
	 * "performPeriod"
	 */
	private Long performPeriod;
	/**
	 * "periodUnit"
	 */
	private String periodUnit;

	// getter and setter
	public Date getApplicationDate()

	{
		return this.applicationDate;
	}

	public ContractInformationDto setApplicationDate(Date arg) {
		this.applicationDate = arg;
		return this;
	}

	public String getApprovalProgress()

	{
		return this.approvalProgress;
	}

	public ContractInformationDto setApprovalProgress(String arg) {
		this.approvalProgress = arg;
		return this;
	}

	public BigDecimal getContractAmount()

	{
		return this.contractAmount;
	}

	public ContractInformationDto setContractAmount(BigDecimal arg) {
		this.contractAmount = arg;
		return this;
	}

	public String getContractAttachmentId()

	{
		return this.contractAttachmentId;
	}

	public ContractInformationDto setContractAttachmentId(String arg) {
		this.contractAttachmentId = arg;
		return this;
	}

	public String getContractBackgroud()

	{
		return this.contractBackgroud;
	}

	public ContractInformationDto setContractBackgroud(String arg) {
		this.contractBackgroud = arg;
		return this;
	}

	public Date getContractBeginTime()

	{
		return this.contractBeginTime;
	}

	public ContractInformationDto setContractBeginTime(Date arg) {
		this.contractBeginTime = arg;
		return this;
	}

	public Date getContractEndTime()

	{
		return this.contractEndTime;
	}

	public ContractInformationDto setContractEndTime(Date arg) {
		this.contractEndTime = arg;
		return this;
	}

	public String getContractName()

	{
		return this.contractName;
	}

	public ContractInformationDto setContractName(String arg) {
		this.contractName = arg;
		return this;
	}

	public String getContractNumber()

	{
		return this.contractNumber;
	}

	public ContractInformationDto setContractNumber(String arg) {
		this.contractNumber = arg;
		return this;
	}

	public String getContractStatus()

	{
		return this.contractStatus;
	}

	public ContractInformationDto setContractStatus(String arg) {
		this.contractStatus = arg;
		return this;
	}

	public String getContractType()

	{
		return this.contractType;
	}

	public ContractInformationDto setContractType(String arg) {
		this.contractType = arg;
		return this;
	}

	public String getDepartmentName()

	{
		return this.departmentName;
	}

	public ContractInformationDto setDepartmentName(String arg) {
		this.departmentName = arg;
		return this;
	}

	public String getExamineMaterialId()

	{
		return this.examineMaterialId;
	}

	public ContractInformationDto setExamineMaterialId(String arg) {
		this.examineMaterialId = arg;
		return this;
	}

	public Date getFilingDate()

	{
		return this.filingDate;
	}

	public ContractInformationDto setFilingDate(Date arg) {
		this.filingDate = arg;
		return this;
	}

	public Date getFinalAppealDate()

	{
		return this.finalAppealDate;
	}

	public ContractInformationDto setFinalAppealDate(Date arg) {
		this.finalAppealDate = arg;
		return this;
	}

	public String getLegalOpinionId()

	{
		return this.legalOpinionId;
	}

	public ContractInformationDto setLegalOpinionId(String arg) {
		this.legalOpinionId = arg;
		return this;
	}

	public String getOperatorName()

	{
		return this.operatorName;
	}

	public ContractInformationDto setOperatorName(String arg) {
		this.operatorName = arg;
		return this;
	}

	public String getOrtherMaterialId()

	{
		return this.ortherMaterialId;
	}

	public ContractInformationDto setOrtherMaterialId(String arg) {
		this.ortherMaterialId = arg;
		return this;
	}

	public Long getPerformPeriod()

	{
		return this.performPeriod;
	}

	public ContractInformationDto setPerformPeriod(Long arg) {
		this.performPeriod = arg;
		return this;
	}

	public String getPeriodUnit()

	{
		return this.periodUnit;
	}

	public ContractInformationDto setPeriodUnit(String arg) {
		this.periodUnit = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ContractInformationDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ContractInformationDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ContractInformationDto fromDto(ContractInformationDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ContractInformationDto.class);
	}

}
