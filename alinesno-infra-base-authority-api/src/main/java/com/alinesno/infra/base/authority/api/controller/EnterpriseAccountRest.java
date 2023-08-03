package com.alinesno.infra.base.authority.api.controller;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alinesno.infra.base.authority.entity.EnterpriseAccountEntity;
import com.alinesno.infra.base.authority.service.IEnterpriseAccountService;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.core.rest.BaseController;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.servlet.http.HttpServletRequest;

/**
 * 
 *
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
@Api(tags = "用户企业配置关联")
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/api/infra/base/authority/EnterpriseAccount")
public class EnterpriseAccountRest extends BaseController<EnterpriseAccountEntity, IEnterpriseAccountService> {

	// 日志记录
	private static final Logger log = LoggerFactory.getLogger(EnterpriseAccountRest.class);

	@Autowired
	private IEnterpriseAccountService enterpriseAccountService;

	@ApiOperation("分页查询") 
	@ResponseBody
	@PostMapping("/datatables")
	public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {
		log.debug("page = {}", ToStringBuilder.reflectionToString(page));
		return this.toDataInfo(model, this.getFeign(), page);
	}

	@Override
	public IEnterpriseAccountService getFeign() {
		return this.enterpriseAccountService;
	}
}
