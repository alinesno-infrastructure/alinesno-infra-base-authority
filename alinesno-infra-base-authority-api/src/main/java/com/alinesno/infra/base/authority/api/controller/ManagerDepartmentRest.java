package com.alinesno.infra.base.authority.api.controller;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alinesno.infra.base.authority.entity.ManagerDepartmentEntity;
import com.alinesno.infra.base.authority.service.IManagerDepartmentService;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.core.rest.BaseController;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.facade.response.AjaxResult;

import io.swagger.annotations.Api;
import jakarta.servlet.http.HttpServletRequest;

/**
 * 
 *
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
@Api(tags = "基础部门管理")
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/api/infra/base/authority/ManagerDepartment")
public class ManagerDepartmentRest extends BaseController<ManagerDepartmentEntity, IManagerDepartmentService> {

	// 日志记录
	private static final Logger log = LoggerFactory.getLogger(ManagerDepartmentRest.class);

	@Autowired
	private IManagerDepartmentService managerDepartmentService;

	
	@ResponseBody
	@PostMapping("/datatables")
	public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {
		log.debug("page = {}", ToStringBuilder.reflectionToString(page));
		return this.toDataInfo(model, this.getFeign(), page);
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
    	ManagerDepartmentEntity managerDepartmentEntity = managerDepartmentService.findEntityById(departmentId);
		return managerDepartmentEntity;
	}

	/**
	 * 通过应用id查询组织结构
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

	@Override
	public IManagerDepartmentService getFeign() {
		return this.managerDepartmentService;
	}
}
