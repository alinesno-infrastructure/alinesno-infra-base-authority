package com.alinesno.infra.base.authority.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.alinesno.infra.base.authority.entity.EnterpriseAccountEntity;
import com.alinesno.infra.base.authority.entity.EnterpriseEntity;
import com.alinesno.infra.base.authority.enums.EnterpriseRoleEnums;
import com.alinesno.infra.base.authority.mapper.EnterpriseMapper;
import com.alinesno.infra.base.authority.service.IEnterpriseAccountService;
import com.alinesno.infra.base.authority.service.IEnterpriseService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

@Service
public class EnterpriseServiceImpl extends IBaseServiceImpl<EnterpriseEntity, EnterpriseMapper> implements IEnterpriseService {

	private static final Logger log = LoggerFactory.getLogger(EnterpriseServiceImpl.class);

	@Autowired
	private IEnterpriseAccountService enterpriseAccountService;

	@Override
	public void registerEnterprise(EnterpriseEntity e) {

		log.debug("企业信息:{}", e.toString());

		// 1. 判断是否为第1个人的，即是否为超级管理员的
		QueryWrapper<EnterpriseAccountEntity> queryWrapper = new QueryWrapper<EnterpriseAccountEntity>();
		queryWrapper.apply("account_id={0} and credit_code={1}", e.getOperatorId(), e.getCreditCode());
		long count = enterpriseAccountService.count(queryWrapper);
		Assert.isTrue(count == 0, "企业已注册");

		// 2. 保存企业信息
		save(e);

		// 3. 保存企业跟个人关联
		EnterpriseAccountEntity ea = new EnterpriseAccountEntity();
		ea.setId(e.getId());
		ea.setCreditCode(e.getCreditCode());
		ea.setAccountId(e.getOperatorId());
		ea.setFieldProp(EnterpriseRoleEnums.FA_REN.getCode());
		enterpriseAccountService.save(ea);

	}

	/**
	 * 修改企业的logo和名称
	 */
	@Override
	public void modifyEnterprise(EnterpriseEntity e) {

		Assert.isTrue(e.getId() != 0, "应用主键为空");
		Assert.isTrue(e.getOperatorId() != 0, "管理用户为空");

		log.debug("企业信息:{}", e.toString());

		// TODO 判断是否为同一个企业用户的修改

		this.updateById(e);
	}
}
