package com.alinesno.infra.base.authority.service;

/**
 * @Description: 根据用户角色进行数据过滤处理
 * @date: 2023年01月29日 15:16
 */
public interface IContractDataFiltersService {
	/**
	 * @Description: 根据用户角色取数据过滤拼接语句
	 * @param filterType 通过什么来过滤，暂定部门或者用户id，目前都走部门，参数只是预留暂不做实现
	 * @param tableAlias 语句中要过滤表的别名
	 */
	String getFilterString(String filterType, String tableAlias);
}