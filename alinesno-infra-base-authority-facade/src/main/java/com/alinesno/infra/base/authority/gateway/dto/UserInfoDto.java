package com.alinesno.infra.base.authority.gateway.dto;

import java.util.Date;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： user_info
 * 
 * @author LuoAnDong ${authorEmail}
 * @date 2023-08-04 19:24:39
 */
public class UserInfoDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "accountId"
	 */
	private String accountId;
	/**
	 * "avatarHead"
	 */
	private String avatarHead;
	/**
	 * "birthday"
	 */
	private Date birthday;
	/**
	 * "classes"
	 */
	private String classes;
	/**
	 * "collgeName"
	 */
	private String collgeName;
	/**
	 * "companyDept"
	 */
	private String companyDept;
	/**
	 * "companyName"
	 */
	private String companyName;
	/**
	 * "education"
	 */
	private String education;
	/**
	 * "email"
	 */
	private String email;
	/**
	 * "englishName"
	 */
	private String englishName;
	/**
	 * "facsimile"
	 */
	private String facsimile;
	/**
	 * "groupName"
	 */
	private String groupName;
	/**
	 * "homeAddress"
	 */
	private String homeAddress;
	/**
	 * "homeCity"
	 */
	private String homeCity;
	/**
	 * "jobName"
	 */
	private String jobName;
	/**
	 * "livingAdress"
	 */
	private String livingAdress;
	/**
	 * "livingCity"
	 */
	private String livingCity;
	/**
	 * "mainConnection"
	 */
	private String mainConnection;
	/**
	 * "mobile"
	 */
	private String mobile;
	/**
	 * "nativeAddress"
	 */
	private String nativeAddress;
	/**
	 * "owners"
	 */
	private String owners;
	/**
	 * "parentFather"
	 */
	private String parentFather;
	/**
	 * "parentMother"
	 */
	private String parentMother;
	/**
	 * "professionalName"
	 */
	private String professionalName;
	/**
	 * "qq"
	 */
	private String qq;
	/**
	 * "reallyName"
	 */
	private String reallyName;
	/**
	 * "registIp"
	 */
	private String registIp;
	/**
	 * "registSource"
	 */
	private String registSource;
	/**
	 * "remark"
	 */
	private String remark;
	/**
	 * "schoolEndTime"
	 */
	private Date schoolEndTime;
	/**
	 * "schoolId"
	 */
	private String schoolId;
	/**
	 * "schoolName"
	 */
	private String schoolName;
	/**
	 * "schoolNum"
	 */
	private String schoolNum;
	/**
	 * "schoolStartTime"
	 */
	private Date schoolStartTime;
	/**
	 * "shoolJob"
	 */
	private String shoolJob;
	/**
	 * "userCode"
	 */
	private String userCode;
	/**
	 * "userHeight"
	 */
	private String userHeight;
	/**
	 * "userName"
	 */
	private String userName;
	/**
	 * "userStatus"
	 */
	private String userStatus;
	/**
	 * "wechat"
	 */
	private String wechat;
	/**
	 * "weibo"
	 */
	private String weibo;

	// getter and setter
	public String getAccountId()

	{
		return this.accountId;
	}

	public UserInfoDto setAccountId(String arg) {
		this.accountId = arg;
		return this;
	}

	public String getAvatarHead()

	{
		return this.avatarHead;
	}

	public UserInfoDto setAvatarHead(String arg) {
		this.avatarHead = arg;
		return this;
	}

	public Date getBirthday()

	{
		return this.birthday;
	}

	public UserInfoDto setBirthday(Date arg) {
		this.birthday = arg;
		return this;
	}

	public String getClasses()

	{
		return this.classes;
	}

	public UserInfoDto setClasses(String arg) {
		this.classes = arg;
		return this;
	}

	public String getCollgeName()

	{
		return this.collgeName;
	}

	public UserInfoDto setCollgeName(String arg) {
		this.collgeName = arg;
		return this;
	}

	public String getCompanyDept()

	{
		return this.companyDept;
	}

	public UserInfoDto setCompanyDept(String arg) {
		this.companyDept = arg;
		return this;
	}

	public String getCompanyName()

	{
		return this.companyName;
	}

	public UserInfoDto setCompanyName(String arg) {
		this.companyName = arg;
		return this;
	}

	public String getEducation()

	{
		return this.education;
	}

	public UserInfoDto setEducation(String arg) {
		this.education = arg;
		return this;
	}

	public String getEmail()

	{
		return this.email;
	}

	public UserInfoDto setEmail(String arg) {
		this.email = arg;
		return this;
	}

	public String getEnglishName()

	{
		return this.englishName;
	}

	public UserInfoDto setEnglishName(String arg) {
		this.englishName = arg;
		return this;
	}

	public String getFacsimile()

	{
		return this.facsimile;
	}

	public UserInfoDto setFacsimile(String arg) {
		this.facsimile = arg;
		return this;
	}

	public String getGroupName()

	{
		return this.groupName;
	}

	public UserInfoDto setGroupName(String arg) {
		this.groupName = arg;
		return this;
	}

	public String getHomeAddress()

	{
		return this.homeAddress;
	}

	public UserInfoDto setHomeAddress(String arg) {
		this.homeAddress = arg;
		return this;
	}

	public String getHomeCity()

	{
		return this.homeCity;
	}

	public UserInfoDto setHomeCity(String arg) {
		this.homeCity = arg;
		return this;
	}

	public String getJobName()

	{
		return this.jobName;
	}

	public UserInfoDto setJobName(String arg) {
		this.jobName = arg;
		return this;
	}

	public String getLivingAdress()

	{
		return this.livingAdress;
	}

	public UserInfoDto setLivingAdress(String arg) {
		this.livingAdress = arg;
		return this;
	}

	public String getLivingCity()

	{
		return this.livingCity;
	}

	public UserInfoDto setLivingCity(String arg) {
		this.livingCity = arg;
		return this;
	}

	public String getMainConnection()

	{
		return this.mainConnection;
	}

	public UserInfoDto setMainConnection(String arg) {
		this.mainConnection = arg;
		return this;
	}

	public String getMobile()

	{
		return this.mobile;
	}

	public UserInfoDto setMobile(String arg) {
		this.mobile = arg;
		return this;
	}

	public String getNativeAddress()

	{
		return this.nativeAddress;
	}

	public UserInfoDto setNativeAddress(String arg) {
		this.nativeAddress = arg;
		return this;
	}

	public String getOwners()

	{
		return this.owners;
	}

	public UserInfoDto setOwners(String arg) {
		this.owners = arg;
		return this;
	}

	public String getParentFather()

	{
		return this.parentFather;
	}

	public UserInfoDto setParentFather(String arg) {
		this.parentFather = arg;
		return this;
	}

	public String getParentMother()

	{
		return this.parentMother;
	}

	public UserInfoDto setParentMother(String arg) {
		this.parentMother = arg;
		return this;
	}

	public String getProfessionalName()

	{
		return this.professionalName;
	}

	public UserInfoDto setProfessionalName(String arg) {
		this.professionalName = arg;
		return this;
	}

	public String getQq()

	{
		return this.qq;
	}

	public UserInfoDto setQq(String arg) {
		this.qq = arg;
		return this;
	}

	public String getReallyName()

	{
		return this.reallyName;
	}

	public UserInfoDto setReallyName(String arg) {
		this.reallyName = arg;
		return this;
	}

	public String getRegistIp()

	{
		return this.registIp;
	}

	public UserInfoDto setRegistIp(String arg) {
		this.registIp = arg;
		return this;
	}

	public String getRegistSource()

	{
		return this.registSource;
	}

	public UserInfoDto setRegistSource(String arg) {
		this.registSource = arg;
		return this;
	}

	public String getRemark()

	{
		return this.remark;
	}

	public UserInfoDto setRemark(String arg) {
		this.remark = arg;
		return this;
	}

	public Date getSchoolEndTime()

	{
		return this.schoolEndTime;
	}

	public UserInfoDto setSchoolEndTime(Date arg) {
		this.schoolEndTime = arg;
		return this;
	}

	public String getSchoolId()

	{
		return this.schoolId;
	}

	public UserInfoDto setSchoolId(String arg) {
		this.schoolId = arg;
		return this;
	}

	public String getSchoolName()

	{
		return this.schoolName;
	}

	public UserInfoDto setSchoolName(String arg) {
		this.schoolName = arg;
		return this;
	}

	public String getSchoolNum()

	{
		return this.schoolNum;
	}

	public UserInfoDto setSchoolNum(String arg) {
		this.schoolNum = arg;
		return this;
	}

	public Date getSchoolStartTime()

	{
		return this.schoolStartTime;
	}

	public UserInfoDto setSchoolStartTime(Date arg) {
		this.schoolStartTime = arg;
		return this;
	}

	public String getShoolJob()

	{
		return this.shoolJob;
	}

	public UserInfoDto setShoolJob(String arg) {
		this.shoolJob = arg;
		return this;
	}

	public String getUserCode()

	{
		return this.userCode;
	}

	public UserInfoDto setUserCode(String arg) {
		this.userCode = arg;
		return this;
	}

	public String getUserHeight()

	{
		return this.userHeight;
	}

	public UserInfoDto setUserHeight(String arg) {
		this.userHeight = arg;
		return this;
	}

	public String getUserName()

	{
		return this.userName;
	}

	public UserInfoDto setUserName(String arg) {
		this.userName = arg;
		return this;
	}

	public String getUserStatus()

	{
		return this.userStatus;
	}

	public UserInfoDto setUserStatus(String arg) {
		this.userStatus = arg;
		return this;
	}

	public String getWechat()

	{
		return this.wechat;
	}

	public UserInfoDto setWechat(String arg) {
		this.wechat = arg;
		return this;
	}

	public String getWeibo()

	{
		return this.weibo;
	}

	public UserInfoDto setWeibo(String arg) {
		this.weibo = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public UserInfoDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, UserInfoDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public UserInfoDto fromDto(UserInfoDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, UserInfoDto.class);
	}

}
