package com.alinesno.infra.base.authority.gateway.controller;

import cn.hutool.core.util.IdUtil;
import com.alinesno.infra.base.authority.entity.ManagerProjectEntity;
import com.alinesno.infra.base.authority.gateway.session.CurrentProjectSession;
import com.alinesno.infra.base.authority.service.IManagerProjectAccountService;
import com.alinesno.infra.base.authority.service.IManagerProjectService;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.login.account.CurrentAccountJwt;
import com.alinesno.infra.common.web.adapter.rest.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.builder.ToStringBuilder;
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
@Slf4j
@Api(tags = "应用信息")
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/api/infra/base/authority/managerProject")
public class ManagerProjectRest extends BaseController<ManagerProjectEntity, IManagerProjectService> {

	@Autowired
	private IManagerProjectService managerProjectService;

	@Autowired
	private IManagerProjectAccountService  managerApplicationAccountService;

	@Autowired
	private CurrentProjectSession currentProjectSession ;

	@ApiOperation("分页查询") 
	@ResponseBody
	@PostMapping("/datatables")
	public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {
		log.debug("page = {}", ToStringBuilder.reflectionToString(page));
		return this.toPage(model, this.getFeign(), page);
	}

	@ResponseBody
	@PostMapping("/saveProject")
	public AjaxResult save(@RequestBody ManagerProjectEntity entity) throws Exception {

		entity.setProjectCode(IdUtil.getSnowflakeNextIdStr());

		managerProjectService.save(entity);
		return this.ok();
	}

	/**
	 * 获取当前应用
	 * @return
	 */
	@GetMapping("/currentProject")
	public AjaxResult currentApplication() {

		long userId = CurrentAccountJwt.getUserId() ;
		long orgId = 1L ;

		managerProjectService.initDefaultProject(userId , orgId) ;

		ManagerProjectEntity e =  currentProjectSession.get() ;

		String defaultIcon = "fa-solid fa-file-shield" ;
		e.setProjectIcons(defaultIcon);

		return AjaxResult.success(e);
	}

	/**
	 * 获取最新的应用
	 * @return
	 */
	@GetMapping("/latestList")
	public AjaxResult latestList() {

		long userId = CurrentAccountJwt.getUserId() ;

		List<ManagerProjectEntity> es =  managerProjectService.latestList(userId);
		return AjaxResult.success(es) ;
	}

	/**
	 * 选择应用
	 * @return
	 */
	@GetMapping("/choiceProject")
	public AjaxResult choiceProject(Long projectId) {
		currentProjectSession.set(projectId);
		return ok() ;
	}

	@Override
	public IManagerProjectService getFeign() {
		return this.managerProjectService;
	}
}
