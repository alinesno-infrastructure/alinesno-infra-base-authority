package com.alinesno.infra.base.authority.gateway.controller;

import com.alinesno.infra.base.authority.api.vo.ManagerResourceVo;
import com.alinesno.infra.base.authority.entity.ManagerResourceEntity;
import com.alinesno.infra.base.authority.gateway.session.CurrentProjectSession;
import com.alinesno.infra.base.authority.service.IManagerResourceService;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.login.account.CurrentAccountBean;
import com.alinesno.infra.common.web.adapter.login.account.CurrentAccountJwt;
import com.alinesno.infra.common.web.adapter.login.annotation.CurrentAccount;
import com.alinesno.infra.common.web.adapter.rest.BaseController;
import io.swagger.annotations.Api;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.BeanUtils;
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

	@Autowired
	private CurrentProjectSession currentProjectSession ;

	@PostMapping("/datatables")
	public TableDataInfo datatables(HttpServletRequest request,
					 Model model,
					 DatatablesPageBean page ,
					 @RequestParam("projectId") Long projectId) {

		managerResourceService.initApplicationMenu(projectId)	;

		log.debug("projectId = {}" , projectId);
		log.debug("page = {}", ToStringBuilder.reflectionToString(page));

		return this.toPage(model, this.getFeign(), page);
	}

	/**
	 * 保存菜单
	 */
	@PostMapping("/saveResource")
	public AjaxResult saveResource(@RequestBody ManagerResourceVo resource ,
								   @CurrentAccount CurrentAccountBean account) {

		log.debug("resource = {}" , resource);

		ManagerResourceEntity resourceEntity = new ManagerResourceEntity() ;
		BeanUtils.copyProperties(resource, resourceEntity);
		resourceEntity.setVisible(true) ;

		if(resourceEntity.getResourceParent() == 0L){ // 为一级目录，设置为当前项目id
			resourceEntity.setComponent("Layout");
		}

		resourceEntity.setOrgId(account.getOrgId());

		managerResourceService.save(resourceEntity);

		return AjaxResult.success();
	}


	/**
	 * 保存菜单
	 */
	@PutMapping("/modifyResource")
	public AjaxResult modifyResource(@RequestBody ManagerResourceVo resource ,
									 @CurrentAccount CurrentAccountBean account) {

		log.debug("resource = {}" , resource);

		ManagerResourceEntity resourceEntity = new ManagerResourceEntity() ;
		BeanUtils.copyProperties(resource, resourceEntity);
		resourceEntity.setVisible(true) ;

		if(resourceEntity.getResourceParent() == 0L){ // 为一级目录，设置为当前项目id
			resourceEntity.setComponent("Layout");
		}

		resourceEntity.setOrgId(account.getOrgId());

		managerResourceService.update(resourceEntity);

		return AjaxResult.success();
	}

	/**
	 * 应用菜单查询
	 * @param projectId
	 * @return
	 */
	@PostMapping("/listResourceByProject")
	public TableDataInfo listResourceByProject(@RequestParam("projectId") Long projectId) {

		managerResourceService.initApplicationMenu(projectId)	;
		List<ManagerResourceEntity> list = managerResourceService.findAllByProject(projectId)  ;

        return new TableDataInfo(list , Integer.MAX_VALUE);
	}

	/**
	 * 获取菜单下拉树列表
	 */
	@GetMapping("/treeselect")
	public AjaxResult treeselect(ManagerResourceEntity menu) {
		long userId = CurrentAccountJwt.getUserId() ;
		long projectId = currentProjectSession.get().getId() ;

		List<ManagerResourceEntity> menus = managerResourceService.selectMenuList(userId , projectId);

		return AjaxResult.success(managerResourceService.buildMenuTreeSelect(menus));
	}

	@GetMapping("/roleMenuTreeselect/{roleId}")
	public AjaxResult roleMenuTreeselect(@PathVariable("roleId") Long roleId) {

		long userId = CurrentAccountJwt.getUserId() ;

		List<ManagerResourceEntity> menus = managerResourceService.selectMenuList(userId , 0L);

		AjaxResult ajax = AjaxResult.success();
		ajax.put("checkedKeys", managerResourceService.selectMenuListByRoleId(roleId));
		ajax.put("menus", managerResourceService.buildMenuTreeSelect(menus));

		return ajax;
	}
 
	@Override
	public IManagerResourceService getFeign() {
		return this.managerResourceService;
	}
}
