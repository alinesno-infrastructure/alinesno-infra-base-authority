package com.alinesno.infra.base.authority.gateway.controller;

import com.alinesno.infra.base.authority.entity.ManagerDepartmentEntity;
import com.alinesno.infra.base.authority.gateway.session.CurrentProjectSession;
import com.alinesno.infra.base.authority.service.IManagerDepartmentService;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.core.utils.StringUtils;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.rest.BaseController;
import io.swagger.annotations.Api;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 
 *
 * @author luoxiaodong 
 * @version 1.0.0
 */
@Slf4j
@Api(tags = "基础部门管理")
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/api/infra/base/authority/managerDepartment")
public class ManagerDepartmentRest extends BaseController<ManagerDepartmentEntity, IManagerDepartmentService> {

	@Autowired
	private IManagerDepartmentService managerDepartmentService;

	@Autowired
	private CurrentProjectSession currentProjectSession ;
	
	@PostMapping("/datatables")
	public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {
		log.debug("page = {}", ToStringBuilder.reflectionToString(page));

		// 初始化应用部门
		managerDepartmentService.initDept(currentProjectSession.get().getId()) ;

		return this.toPage(model, this.getFeign(), page);
	}
	
	//工作流使用，查看部门所有信息	
    @GetMapping("findAllWrapperByAppIdDeptId")
    public AjaxResult findAllWrapperByAppIdDeptId(String applicationId,String departmentId) {
		Object data = managerDepartmentService.findDepByDeptId(departmentId);
		return AjaxResult.success(data);
	}
    
  	//工作流使用，查看部门所有信息
    @GetMapping("detailById")
    public ManagerDepartmentEntity detailById(String departmentId) {
        return managerDepartmentService.findEntityById(departmentId);
	}

	/**
	 * 查询部门列表（排除节点）
	 */
	@GetMapping("/listExclude/{id}")
	public AjaxResult excludeChild(@PathVariable(value = "id", required = false) Long id) {
		long projectId = currentProjectSession.get().getId();

		List<ManagerDepartmentEntity> depts = managerDepartmentService.selectDeptList(new ManagerDepartmentEntity() , projectId);
		depts.removeIf(d -> d.getId().intValue() == id || ArrayUtils.contains(StringUtils.split(d.getAncestors(), ","), id + ""));

		return AjaxResult.success(depts);
	}

	/**
	 * 通过应用id查询机构结构
	 * 
	 * @param applicationId
	 * @return
	 */
	@GetMapping("findDepByApplication")
	public AjaxResult findDepByApplication(String applicationId, String parentDeptId) {

		Assert.hasLength(applicationId, "应用id为空");

		Object data = managerDepartmentService.findDepByApplication(applicationId, parentDeptId);

		return AjaxResult.success(data);
	}

	/**
	 * 获取部门树列表
	 */
	@GetMapping("/roleDeptTreeselect/{roleId}")
	public AjaxResult roleDeptTreeselect(@PathVariable("roleId") Long roleId) {

		AjaxResult ajax = AjaxResult.success();

		ajax.put("checkedKeys", managerDepartmentService.selectDeptListByRoleId(roleId));
		ajax.put("depts", managerDepartmentService.selectDeptTreeList());

		return ajax;
	}

	@Override
	public IManagerDepartmentService getFeign() {
		return this.managerDepartmentService;
	}
}
