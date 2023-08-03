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

import com.alinesno.infra.base.authority.entity.ManagerSearchEntity;
import com.alinesno.infra.base.authority.service.IManagerSearchService;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.core.rest.BaseController;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;

import jakarta.servlet.http.HttpServletRequest;

/**
 * 
 *
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/api/infra/base/authority/ManagerSearch")
public class ManagerSearchRest extends BaseController<ManagerSearchEntity, IManagerSearchService> {

	// 日志记录
	private static final Logger log = LoggerFactory.getLogger(ManagerSearchRest.class);

	@Autowired
	private IManagerSearchService managerSearchService;

	
	@ResponseBody
	@PostMapping("/datatables")
	public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {
		log.debug("page = {}", ToStringBuilder.reflectionToString(page));
		return this.toDataInfo(model, this.getFeign(), page);
	}

	@Override
	public IManagerSearchService getFeign() {
		return this.managerSearchService;
	}
}
