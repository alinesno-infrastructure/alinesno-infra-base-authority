package com.alinesno.infra.base.authority.gateway.controller;

import com.alinesno.infra.base.authority.entity.ManagerResourceEntity;
import com.alinesno.infra.base.authority.service.IManagerResourceService;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.web.adapter.login.account.CurrentAccountJwt;
import com.alinesno.infra.common.web.adapter.rest.BaseController;
import io.swagger.annotations.Api;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 *
 * @author luoxiaodong 
 * @version 1.0.0
 */
@Slf4j
@Api(tags = "资源管理")
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/api/infra/base/authority/managerResource")
public class ManagerResourceRest extends BaseController<ManagerResourceEntity, IManagerResourceService> {

	@Autowired
	private IManagerResourceService managerResourceService;

	@PostMapping("/datatables")
	public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {

		String currentAppId = request.getParameter("currentAppId") ;

		// 初始化平台菜单应用
		managerResourceService.initApplicationMenu(currentAppId , CurrentAccountJwt.getUserId()) ;

		log.debug("currentAppId = {}" , currentAppId);
		log.debug("page = {}", ToStringBuilder.reflectionToString(page));

		return this.toPage(model, this.getFeign(), page);
	}


	@Override
	public IManagerResourceService getFeign() {
		return this.managerResourceService;
	}
}
