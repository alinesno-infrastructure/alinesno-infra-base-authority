package com.alinesno.infra.base.authority.gateway.controller;

import com.alinesno.infra.base.authority.entity.ManagerApplicationEntity;
import com.alinesno.infra.base.authority.gateway.session.CurrentApplicationSession;
import com.alinesno.infra.base.authority.service.IManagerApplicationAccountService;
import com.alinesno.infra.base.authority.service.IManagerApplicationService;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.login.account.CurrentAccountJwt;
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
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 
 *
 * @author luoxiaodong 
 * @version 1.0.0
 */
@Api(tags = "应用信息")
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/api/infra/base/authority/managerApplication")
public class ManagerApplicationRest extends BaseController<ManagerApplicationEntity, IManagerApplicationService> {

	// 日志记录
	private static final Logger log = LoggerFactory.getLogger(ManagerApplicationRest.class);

	@Autowired
	private IManagerApplicationService managerApplicationService;

	@Autowired
	private IManagerApplicationAccountService  managerApplicationAccountService;

	@Autowired
	private CurrentApplicationSession currentApplicationSession ;

	@ApiOperation("分页查询") 
	@ResponseBody
	@PostMapping("/datatables")
	public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {
		log.debug("page = {}", ToStringBuilder.reflectionToString(page));
		return this.toPage(model, this.getFeign(), page);
	}

	/**
	 * 获取当前应用
	 * @return
	 */
	@GetMapping("/currentApplication")
	public AjaxResult currentApplication() {

		// 初始化应用
		managerApplicationAccountService.initDefaultProject(CurrentAccountJwt.getUserId()) ;

		ManagerApplicationEntity e =  currentApplicationSession.get() ;

		String defaultIcon = "fa-solid fa-file-shield" ;
		e.setApplicationIcons(defaultIcon);

		return AjaxResult.success(e);
	}

	/**
	 * 获取最新的应用
	 * @return
	 */
	@GetMapping("/latestList")
	public AjaxResult latestList() {
		long userId = CurrentAccountJwt.getUserId() ;
		List<ManagerApplicationEntity> es =  managerApplicationService.latestList(userId);
		return AjaxResult.success(es) ;
	}

	/**
	 * 选择应用
	 * @return
	 */
	@GetMapping("/choiceApplication")
	public AjaxResult choiceApplication(Long applicationId) {
		currentApplicationSession.set(applicationId);
		return ok() ;
	}

	@Override
	public IManagerApplicationService getFeign() {
		return this.managerApplicationService;
	}
}
