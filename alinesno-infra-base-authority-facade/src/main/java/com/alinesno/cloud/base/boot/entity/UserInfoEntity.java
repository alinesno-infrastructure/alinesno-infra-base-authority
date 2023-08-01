package com.alinesno.cloud.base.boot.entity;

import java.util.Date;

import com.alinesno.infra.common.facade.mapper.entity.InfraBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 *
 * </p>
 *
 * @author WeiXiaoJin
 * @since 2018-12-16 17:53:19
 */

@TableName("user_info")
public class UserInfoEntity extends InfraBaseEntity {

	private static final long serialVersionUID = 1L;

	@TableField
	private String owners;
	/**
	 * 用户头像
	 */
	@TableField("avatar_head")
	private String avatarHead;
	/**
	 * 生日
	 */
	@TableField
	private Date birthday;
	/**
	 * 班级
	 */
	@TableField
	private String classes;
	/**
	 * 学院名称
	 */
	@TableField("collge_name")
	private String collgeName;
	/**
	 * 公司部门
	 */
	@TableField("company_dept")
	private String companyDept;
	/**
	 * 公司名称
	 */
	@TableField("company_name")
	private String companyName;
	/**
	 * 学历
	 */
	@TableField
	private String education;
	/**
	 * 邮箱
	 */
	@TableField
	private String email;
	/**
	 * 英文名称
	 */
	@TableField("english_name")
	private String englishName;
	/**
	 * 传真
	 */
	@TableField
	private String facsimile;
	/**
	 * 所属分组
	 */
	@TableField("group_name")
	private String groupName;
	/**
	 * 家庭地址
	 */
	@TableField("home_address")
	private String homeAddress;
	/**
	 * 家庭城市
	 */
	@TableField("home_city")
	private String homeCity;
	/**
	 * 工作名称
	 */
	@TableField("job_name")
	private String jobName;
	/**
	 * 当前居住地址
	 */
	@TableField("living_adress")
	private String livingAdress;
	/**
	 * 当前居住城市
	 */
	@TableField("living_city")
	private String livingCity;
	/**
	 * 主要联系方式
	 */
	@TableField("main_connection")
	private String mainConnection;
	/**
	 * 手机
	 */
	@TableField
	private String mobile;
	/**
	 * 家庭地址
	 */
	@TableField("native_address")
	private String nativeAddress;
	/**
	 * 父亲名称
	 */
	@TableField("parent_father")
	private String parentFather;
	/**
	 * 母亲名称
	 */
	@TableField("parent_mother")
	private String parentMother;
	/**
	 * 手机号
	 */
	private String phone;
	/**
	 * 专业名称
	 */
	@TableField("professional_name")
	private String professionalName;
	/**
	 * QQ号
	 */
	@TableField
	private String qq;
	/**
	 * 真名
	 */
	@TableField("really_name")
	private String reallyName;
	/**
	 * 注册IP
	 */
	@TableField("regist_ip")
	private String registIp;
	/**
	 * 注册源
	 */
	@TableField("regist_source")
	private String registSource;
	/**
	 * 备注
	 */
	@TableField
	private String remark;
	/**
	 * 大学结束时间
	 */
	@TableField("school_end_time")
	private Date schoolEndTime;
	/**
	 * 大学名称
	 */
	@TableField("school_name")
	private String schoolName;
	/**
	 * 大学年级
	 */
	@TableField("school_num")
	private String schoolNum;
	/**
	 * 学校开始时间
	 */
	@TableField("school_start_time")
	private Date schoolStartTime;
	/**
	 * 性别
	 */
	private Integer sex;
	/**
	 * 在校职位
	 */
	@TableField("shool_job")
	private String shoolJob;
	/**
	 * 用户代码
	 */
	@TableField("user_code")
	private String userCode;
	/**
	 * 用户身高
	 */
	@TableField("user_height")
	private String userHeight;
	/**
	 * 用户名称
	 */
	@TableField("user_name")
	private String userName;
	/**
	 * 用户状态
	 */
	@TableField("user_status")
	private String userStatus;
	/**
	 * 微信号
	 */
	@TableField
	private String wechat;
	/**
	 * 微博号
	 */
	@TableField
	private String weibo;
	/**
	 * 用户登陆账户
	 */
	@TableField("account_id")
	private String accountId;

	@TableField("school_id")
	private String schoolId;

	public String getOwners() {
		return owners;
	}

	public void setOwners(String owners) {
		this.owners = owners;
	}

	public String getAvatarHead() {
		return avatarHead;
	}

	public void setAvatarHead(String avatarHead) {
		this.avatarHead = avatarHead;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String getCollgeName() {
		return collgeName;
	}

	public void setCollgeName(String collgeName) {
		this.collgeName = collgeName;
	}

	public String getCompanyDept() {
		return companyDept;
	}

	public void setCompanyDept(String companyDept) {
		this.companyDept = companyDept;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getFacsimile() {
		return facsimile;
	}

	public void setFacsimile(String facsimile) {
		this.facsimile = facsimile;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getHomeCity() {
		return homeCity;
	}

	public void setHomeCity(String homeCity) {
		this.homeCity = homeCity;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getLivingAdress() {
		return livingAdress;
	}

	public void setLivingAdress(String livingAdress) {
		this.livingAdress = livingAdress;
	}

	public String getLivingCity() {
		return livingCity;
	}

	public void setLivingCity(String livingCity) {
		this.livingCity = livingCity;
	}

	public String getMainConnection() {
		return mainConnection;
	}

	public void setMainConnection(String mainConnection) {
		this.mainConnection = mainConnection;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNativeAddress() {
		return nativeAddress;
	}

	public void setNativeAddress(String nativeAddress) {
		this.nativeAddress = nativeAddress;
	}

	public String getParentFather() {
		return parentFather;
	}

	public void setParentFather(String parentFather) {
		this.parentFather = parentFather;
	}

	public String getParentMother() {
		return parentMother;
	}

	public void setParentMother(String parentMother) {
		this.parentMother = parentMother;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProfessionalName() {
		return professionalName;
	}

	public void setProfessionalName(String professionalName) {
		this.professionalName = professionalName;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getReallyName() {
		return reallyName;
	}

	public void setReallyName(String reallyName) {
		this.reallyName = reallyName;
	}

	public String getRegistIp() {
		return registIp;
	}

	public void setRegistIp(String registIp) {
		this.registIp = registIp;
	}

	public String getRegistSource() {
		return registSource;
	}

	public void setRegistSource(String registSource) {
		this.registSource = registSource;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getSchoolEndTime() {
		return schoolEndTime;
	}

	public void setSchoolEndTime(Date schoolEndTime) {
		this.schoolEndTime = schoolEndTime;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolNum() {
		return schoolNum;
	}

	public void setSchoolNum(String schoolNum) {
		this.schoolNum = schoolNum;
	}

	public Date getSchoolStartTime() {
		return schoolStartTime;
	}

	public void setSchoolStartTime(Date schoolStartTime) {
		this.schoolStartTime = schoolStartTime;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getShoolJob() {
		return shoolJob;
	}

	public void setShoolJob(String shoolJob) {
		this.shoolJob = shoolJob;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserHeight() {
		return userHeight;
	}

	public void setUserHeight(String userHeight) {
		this.userHeight = userHeight;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getWeibo() {
		return weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	@Override
	public String toString() {
		return "UserInfoEntity{" + "owners=" + owners + ", avatarHead=" + avatarHead + ", birthday=" + birthday
				+ ", classes=" + classes + ", collgeName=" + collgeName + ", companyDept=" + companyDept
				+ ", companyName=" + companyName + ", education=" + education + ", email=" + email + ", englishName="
				+ englishName + ", facsimile=" + facsimile + ", groupName=" + groupName + ", homeAddress=" + homeAddress
				+ ", homeCity=" + homeCity + ", jobName=" + jobName + ", livingAdress=" + livingAdress + ", livingCity="
				+ livingCity + ", mainConnection=" + mainConnection + ", mobile=" + mobile + ", nativeAddress="
				+ nativeAddress + ", parentFather=" + parentFather + ", parentMother=" + parentMother + ", phone="
				+ phone + ", professionalName=" + professionalName + ", qq=" + qq + ", reallyName=" + reallyName
				+ ", registIp=" + registIp + ", registSource=" + registSource + ", remark=" + remark
				+ ", schoolEndTime=" + schoolEndTime + ", schoolName=" + schoolName + ", schoolNum=" + schoolNum
				+ ", schoolStartTime=" + schoolStartTime + ", sex=" + sex + ", shoolJob=" + shoolJob + ", userCode="
				+ userCode + ", userHeight=" + userHeight + ", userName=" + userName + ", userStatus=" + userStatus
				+ ", wechat=" + wechat + ", weibo=" + weibo + ", accountId=" + accountId + ", schoolId=" + schoolId
				+ "}";
	}
}
