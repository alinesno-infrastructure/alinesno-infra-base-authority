package com.alinesno.infra.base.authority.gateway.controller;

import com.alinesno.infra.base.authority.datascope.annotation.DataPermissionQuery;
import com.alinesno.infra.base.authority.entity.ManagerLoginRecordEntity;
import com.alinesno.infra.base.authority.service.IManagerLoginRecordService;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.web.adapter.rest.BaseController;
import io.swagger.annotations.Api;
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
 * @author luoxiaodong 
 * @version 1.0.0
 */
@Api(tags = "账户登陆日志管理")
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/api/infra/base/authority/managerLoginRecord")
public class ManagerLoginRecordRest extends BaseController<ManagerLoginRecordEntity, IManagerLoginRecordService> {

	// 日志记录
	private static final Logger log = LoggerFactory.getLogger(ManagerLoginRecordRest.class);

	@Autowired
	private IManagerLoginRecordService managerLoginRecordService;

	@DataPermissionQuery
	@ResponseBody
	@PostMapping("/datatables")
	public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {
		log.debug("page = {}", ToStringBuilder.reflectionToString(page));
		return this.toPage(model, this.getFeign(), page);
	}

	@Override
	public IManagerLoginRecordService getFeign() {
		return this.managerLoginRecordService;
	}
}
