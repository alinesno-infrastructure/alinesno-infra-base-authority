package com.alinesno.infra.base.authority.gateway.controller;

import com.alinesno.infra.base.authority.entity.EnterpriseSettingEntity;
import com.alinesno.infra.base.authority.service.IEnterpriseSettingService;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.web.adapter.rest.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.servlet.http.HttpServletRequest;
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

/**
 * 
 *
 * @author luoxiaodong luoandon@gmail.com
 * @version 1.0.0
 */
@Api(tags = "企业/团队设置")
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/api/infra/base/authority/EnterpriseSetting")
public class EnterpriseSettingRest extends BaseController<EnterpriseSettingEntity, IEnterpriseSettingService> {

	// 日志记录
	private static final Logger log = LoggerFactory.getLogger(EnterpriseSettingRest.class);

	@Autowired
	private IEnterpriseSettingService enterpriseSettingService;

	@ApiOperation("分页查询") 
	@ResponseBody
	@PostMapping("/datatables")
	public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {
		log.debug("page = {}", ToStringBuilder.reflectionToString(page));
		return this.toPage(model, this.getFeign(), page);
	}

	@Override
	public IEnterpriseSettingService getFeign() {
		return this.enterpriseSettingService;
	}
}
