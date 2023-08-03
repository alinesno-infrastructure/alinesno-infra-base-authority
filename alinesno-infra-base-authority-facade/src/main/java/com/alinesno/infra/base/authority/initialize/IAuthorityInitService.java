package com.alinesno.infra.base.authority.initialize;

/**
 * 初始化应用程序
 * 
 * @author LuoAnDong
 * @since 2022年3月15日 下午10:23:43
 */
public interface IAuthorityInitService {

	/**
	 * 初始化应用程序，如果初用户没有应用，则添加一些示例
	 * 
	 * @param accountId
	 */
	public void initData(Long accountId);

}
