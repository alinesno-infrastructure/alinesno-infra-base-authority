package com.alinesno.infra.base.authority.identity.controller.manager;

import com.alinesno.infra.base.authority.datascope.annotation.DataPermissionScope;
import com.alinesno.infra.base.authority.identity.domain.LoginEventEntity;
import com.alinesno.infra.base.authority.identity.service.ILoginEventService;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.web.adapter.rest.BaseController;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/api/infra/base/authority/notices/loginEvent")
public class LoginEventController extends BaseController<LoginEventEntity, ILoginEventService> {

	@Autowired
	private ILoginEventService enterpriseSettingService;

	@DataPermissionScope
	@ResponseBody
	@PostMapping("/datatables")
	public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {
		log.debug("page = {}", ToStringBuilder.reflectionToString(page));
		return this.toPage(model, this.getFeign(), page);
	}

	@Override
	public ILoginEventService getFeign() {
		return this.enterpriseSettingService;
	}
}
