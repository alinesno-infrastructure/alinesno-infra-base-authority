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

import com.alinesno.infra.base.authority.entity.EnterpriseEntity;
import com.alinesno.infra.base.authority.service.IEnterpriseService;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.core.rest.BaseController;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.servlet.http.HttpServletRequest;

/**
 * ，提供 <br/>
 * 1. 企业登记接口 <br/>
 * 2. 企业logo/标题/配置名称/更新接口 <br/>
 * 3. 企业域名更新接口 <br/>
 * 4. 企业与账号关联接口 <br/>
 *
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
@Api(tags = "企业/团队配置")
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/api/infra/base/authority/Enterprise")
public class EnterpriseRest extends BaseController<EnterpriseEntity, IEnterpriseService> {

	// 日志记录
	private static final Logger log = LoggerFactory.getLogger(EnterpriseRest.class);

	@Autowired
	private IEnterpriseService enterpriseService;
  
	@ApiOperation("分页查询") 
	@ResponseBody
	@PostMapping("/datatables")
	public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {
		log.debug("page = {}", ToStringBuilder.reflectionToString(page));
		return this.toDataInfo(model, this.getFeign(), page);
	}
 
	@Override
	public IEnterpriseService getFeign() {
		return this.enterpriseService;
	}
}
