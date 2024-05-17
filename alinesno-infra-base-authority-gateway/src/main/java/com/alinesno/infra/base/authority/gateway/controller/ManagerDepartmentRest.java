package com.alinesno.infra.base.authority.gateway.controller;

import cn.hutool.json.JSONUtil;
import com.alinesno.infra.base.authority.entity.ManagerDepartmentEntity;
import com.alinesno.infra.base.authority.service.IManagerDepartmentService;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.rest.BaseController;
import io.swagger.annotations.Api;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

/**
 * 
 *
 * @author luoxiaodong 
 * @version 1.0.0
 */
@Api(tags = "基础部门管理")
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/api/infra/base/authority/managerDepartment")
public class ManagerDepartmentRest extends BaseController<ManagerDepartmentEntity, IManagerDepartmentService> {

	// 日志记录
	private static final Logger log = LoggerFactory.getLogger(ManagerDepartmentRest.class);

	@Autowired
	private IManagerDepartmentService managerDepartmentService;

	
	@ResponseBody
	@PostMapping("/datatables")
	public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {
		log.debug("page = {}", ToStringBuilder.reflectionToString(page));
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

	/**
	 * 获取部门树列表
	 */
	@GetMapping("/deptTree")
	public AjaxResult deptTree() {
		String data = "[\n" +
				"        {\n" +
				"            \"id\": 100,\n" +
				"            \"label\": \"AIP科技\",\n" +
				"            \"children\": [\n" +
				"                {\n" +
				"                    \"id\": 101,\n" +
				"                    \"label\": \"深圳总公司\",\n" +
				"                    \"children\": [\n" +
				"                        {\n" +
				"                            \"id\": 103,\n" +
				"                            \"label\": \"研发部门\"\n" +
				"                        },\n" +
				"                        {\n" +
				"                            \"id\": 104,\n" +
				"                            \"label\": \"市场部门\"\n" +
				"                        },\n" +
				"                        {\n" +
				"                            \"id\": 105,\n" +
				"                            \"label\": \"测试部门\"\n" +
				"                        },\n" +
				"                        {\n" +
				"                            \"id\": 106,\n" +
				"                            \"label\": \"财务部门\"\n" +
				"                        },\n" +
				"                        {\n" +
				"                            \"id\": 107,\n" +
				"                            \"label\": \"运维部门\"\n" +
				"                        }\n" +
				"                    ]\n" +
				"                },\n" +
				"                {\n" +
				"                    \"id\": 102,\n" +
				"                    \"label\": \"长沙分公司\",\n" +
				"                    \"children\": [\n" +
				"                        {\n" +
				"                            \"id\": 108,\n" +
				"                            \"label\": \"市场部门\"\n" +
				"                        },\n" +
				"                        {\n" +
				"                            \"id\": 109,\n" +
				"                            \"label\": \"财务部门\"\n" +
				"                        }\n" +
				"                    ]\n" +
				"                }\n" +
				"            ]\n" +
				"        }\n" +
				"    ]" ;

		return AjaxResult.success(JSONUtil.parse(data)) ;
	}

	@Override
	public IManagerDepartmentService getFeign() {
		return this.managerDepartmentService;
	}
}
