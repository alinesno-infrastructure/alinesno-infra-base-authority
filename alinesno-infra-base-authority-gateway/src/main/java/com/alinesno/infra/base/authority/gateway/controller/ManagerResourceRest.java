package com.alinesno.infra.base.authority.gateway.controller;

import com.alinesno.infra.base.authority.entity.ManagerResourceEntity;
import com.alinesno.infra.base.authority.service.IManagerResourceService;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.login.account.CurrentAccountJwt;
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

import java.util.List;

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

	
	@ResponseBody
	@PostMapping("/datatables")
	public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {
		log.debug("page = {}", ToStringBuilder.reflectionToString(page));
		return this.toPage(model, this.getFeign(), page);
	}

	/**
	 * 获取菜单下拉树列表
	 */
	@GetMapping("/treeselect")
	public AjaxResult treeselect(ManagerResourceEntity menu) {
		long userId = CurrentAccountJwt.getUserId() ;

		List<ManagerResourceEntity> menus = managerResourceService.selectMenuList(menu, userId);

		return AjaxResult.success(managerResourceService.buildMenuTreeSelect(menus));
	}
 
	@Override
	public IManagerResourceService getFeign() {
		return this.managerResourceService;
	}
}
