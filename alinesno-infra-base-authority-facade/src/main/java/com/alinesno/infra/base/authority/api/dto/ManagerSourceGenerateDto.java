package com.alinesno.infra.base.authority.api.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 功能名： 【请填写功能名称】 数据表： manager_source_generate
 * 
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
public class ManagerSourceGenerateDto extends BaseDto {
	private static final long serialVersionUID = 1L;
	// fields
	/**
	 * "authorName"
	 */
	private String authorName;
	/**
	 * "dbDriver"
	 */
	private String dbDriver;
	/**
	 * "dbPwd"
	 */
	private String dbPwd;
	/**
	 * "dbUrl"
	 */
	private String dbUrl;
	/**
	 * "dbUser"
	 */
	private String dbUser;
	/**
	 * "bootPrefix"
	 */
	private String bootPrefix;
	/**
	 * "feignServerPath"
	 */
	private String feignServerPath;
	/**
	 * "packageName"
	 */
	private String packageName;
	/**
	 * "gitPassword"
	 */
	private String gitPassword;
	/**
	 * "gitRepositoryUrl"
	 */
	private String gitRepositoryUrl;
	/**
	 * "gitUserName"
	 */
	private String gitUserName;
	/**
	 * "jenkinsJobname"
	 */
	private String jenkinsJobname;
	/**
	 * "jenkinsPassword"
	 */
	private String jenkinsPassword;
	/**
	 * "jenkinsUrl"
	 */
	private String jenkinsUrl;
	/**
	 * "jenkinsUserName"
	 */
	private String jenkinsUserName;
	/**
	 * "dockerPath"
	 */
	private String dockerPath;

	// getter and setter
	public String getAuthorName()

	{
		return this.authorName;
	}

	public ManagerSourceGenerateDto setAuthorName(String arg) {
		this.authorName = arg;
		return this;
	}

	public String getDbDriver()

	{
		return this.dbDriver;
	}

	public ManagerSourceGenerateDto setDbDriver(String arg) {
		this.dbDriver = arg;
		return this;
	}

	public String getDbPwd()

	{
		return this.dbPwd;
	}

	public ManagerSourceGenerateDto setDbPwd(String arg) {
		this.dbPwd = arg;
		return this;
	}

	public String getDbUrl()

	{
		return this.dbUrl;
	}

	public ManagerSourceGenerateDto setDbUrl(String arg) {
		this.dbUrl = arg;
		return this;
	}

	public String getDbUser()

	{
		return this.dbUser;
	}

	public ManagerSourceGenerateDto setDbUser(String arg) {
		this.dbUser = arg;
		return this;
	}

	public String getBootPrefix()

	{
		return this.bootPrefix;
	}

	public ManagerSourceGenerateDto setBootPrefix(String arg) {
		this.bootPrefix = arg;
		return this;
	}

	public String getFeignServerPath()

	{
		return this.feignServerPath;
	}

	public ManagerSourceGenerateDto setFeignServerPath(String arg) {
		this.feignServerPath = arg;
		return this;
	}

	public String getPackageName()

	{
		return this.packageName;
	}

	public ManagerSourceGenerateDto setPackageName(String arg) {
		this.packageName = arg;
		return this;
	}

	public String getGitPassword()

	{
		return this.gitPassword;
	}

	public ManagerSourceGenerateDto setGitPassword(String arg) {
		this.gitPassword = arg;
		return this;
	}

	public String getGitRepositoryUrl()

	{
		return this.gitRepositoryUrl;
	}

	public ManagerSourceGenerateDto setGitRepositoryUrl(String arg) {
		this.gitRepositoryUrl = arg;
		return this;
	}

	public String getGitUserName()

	{
		return this.gitUserName;
	}

	public ManagerSourceGenerateDto setGitUserName(String arg) {
		this.gitUserName = arg;
		return this;
	}

	public String getJenkinsJobname()

	{
		return this.jenkinsJobname;
	}

	public ManagerSourceGenerateDto setJenkinsJobname(String arg) {
		this.jenkinsJobname = arg;
		return this;
	}

	public String getJenkinsPassword()

	{
		return this.jenkinsPassword;
	}

	public ManagerSourceGenerateDto setJenkinsPassword(String arg) {
		this.jenkinsPassword = arg;
		return this;
	}

	public String getJenkinsUrl()

	{
		return this.jenkinsUrl;
	}

	public ManagerSourceGenerateDto setJenkinsUrl(String arg) {
		this.jenkinsUrl = arg;
		return this;
	}

	public String getJenkinsUserName()

	{
		return this.jenkinsUserName;
	}

	public ManagerSourceGenerateDto setJenkinsUserName(String arg) {
		this.jenkinsUserName = arg;
		return this;
	}

	public String getDockerPath()

	{
		return this.dockerPath;
	}

	public ManagerSourceGenerateDto setDockerPath(String arg) {
		this.dockerPath = arg;
		return this;
	}

	/**
	 * 快速从 dto 转换成 entity
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerSourceGenerateDto mapToDto() {
		ObjectMapper toDtoMapper = new ObjectMapper();
		toDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return toDtoMapper.convertValue(this, ManagerSourceGenerateDto.class);
	}

	/**
	 * 快速从 entity 转换成 dto
	 * 
	 * @return dto 对应的 entity
	 */
	public ManagerSourceGenerateDto fromDto(ManagerSourceGenerateDto entity) {
		ObjectMapper fromDtoMapper = new ObjectMapper();
		fromDtoMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return fromDtoMapper.convertValue(entity, ManagerSourceGenerateDto.class);
	}

}
