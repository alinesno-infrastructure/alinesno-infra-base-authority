package com.alinesno.infra.base.authority.gateway.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.alinesno.infra.base.authority.entity.ManagerRoleEntity;
import com.alinesno.infra.base.authority.service.IManagerRoleService;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.rest.BaseController;
import io.swagger.annotations.Api;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 
 *
 * @author luoxiaodong 
 * @version 1.0.0
 */
@Slf4j
@Api(tags = "角色管理")
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/api/infra/base/authority/managerRole")
public class ManagerRoleRest extends BaseController<ManagerRoleEntity, IManagerRoleService> {

	@Autowired
	private IManagerRoleService managerRoleService;
 
	@ResponseBody
	@PostMapping("/datatables")
	public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {
		log.debug("page = {}", ToStringBuilder.reflectionToString(page));
		return this.toPage(model, this.getFeign(), page);
	}

	/**
	 * 状态修改
	 */
	@PutMapping("/changeRoleStatus")
	public AjaxResult changeRoleStatus(@RequestBody ManagerRoleEntity role) {

		managerRoleService.checkRoleAllowed(role);
		managerRoleService.checkRoleDataScope(role.getId());

		return AjaxResult.success(managerRoleService.updateRoleStatus(role.getId(), role.getHasStatus()));
	}
 
	@Override
	public IManagerRoleService getFeign() {
		return this.managerRoleService;
	}
}
