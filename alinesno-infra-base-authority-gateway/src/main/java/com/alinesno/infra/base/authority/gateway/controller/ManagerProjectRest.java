package com.alinesno.infra.base.authority.gateway.controller;

import cn.hutool.core.util.IdUtil;
import com.alinesno.infra.base.authority.api.PermissionQuery;
import com.alinesno.infra.base.authority.datascope.annotation.DataPermissionQuery;
import com.alinesno.infra.base.authority.datascope.annotation.DataPermissionSave;
import com.alinesno.infra.base.authority.datascope.annotation.DataPermissionScope;
import com.alinesno.infra.base.authority.entity.*;
import com.alinesno.infra.base.authority.gateway.dto.ManagerProjectDto;
import com.alinesno.infra.base.authority.gateway.session.CurrentProjectSession;
import com.alinesno.infra.base.authority.service.*;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.rest.BaseController;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.annotations.Api;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
	private IManagerResourceService resourceService;

	@Autowired
	private IManagerRoleService roleService;

	@Autowired
	private IManagerAccountService accountService;

	@Autowired
	private IManagerDepartmentService departmentService;

	@Autowired
	private IManagerProjectAccountService  managerApplicationAccountService;

	@Autowired
	private CurrentProjectSession currentProjectSession ;

	@DataPermissionScope
	@ResponseBody
	@PostMapping("/datatables")
	public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {
		log.debug("page = {}", ToStringBuilder.reflectionToString(page));
		return this.toPage(model, this.getFeign(), page);
	}

	@DataPermissionSave
	@ResponseBody
	@PostMapping("/saveProject")
	public AjaxResult save(@RequestBody ManagerProjectDto dto) throws Exception {

		dto.setProjectCode(IdUtil.getSnowflakeNextIdStr());

//		dto.setOperatorId(CurrentAccountJwt.getUserId());
//		dto.setOrgId(CurrentAccountJwt.getAccount().getOrgId());

		managerProjectService.genProject(dto);

		return this.ok();
	}

	/**
	 * 获取当前应用
	 * @return
	 */
	@GetMapping("/currentProject")
	public AjaxResult currentApplication() {

//		long userId = CurrentAccountJwt.getUserId() ;
//		long orgId = CurrentAccountJwt.get().getOrgId() ;
//		managerProjectService.initDefaultProject(userId , orgId) ;

		ManagerProjectEntity e = currentProjectSession.get() ;

		if(e != null){
			String defaultIcon = "fa-solid fa-file-shield" ;
			e.setProjectIcons(defaultIcon);

			return AjaxResult.success(e);
		}

		return AjaxResult.success();
	}

	/**
	 * 获取最新的应用
	 * @return
	 */
	@DataPermissionQuery
	@GetMapping("/latestList")
	public AjaxResult latestList(PermissionQuery query) {
		List<ManagerProjectEntity> es =  managerProjectService.latestList(query);
		return AjaxResult.success(es) ;
	}

	/**
	 * 应用状态统计
	 */
	@DataPermissionQuery
	@GetMapping("/statusCount")
	public AjaxResult statusCount(PermissionQuery query) {

		log.debug("query = {}" , query);

		long projectCount = 0 ;  // 项目数量
		long functionCount = 0 ;  // 功能数量
		long roleCount = 0 ;  // 角色数量
		long accountCount = 0 ;  // 账号数量
		long deptCount = 0 ;  // 部门数量

		// 项目数量统计
		LambdaQueryWrapper<ManagerProjectEntity> wrapper = new LambdaQueryWrapper<>();
		wrapper.setEntityClass(ManagerProjectEntity.class) ;
		query.toWrapper(wrapper);
		projectCount = managerProjectService.count(wrapper);

		// 功能数量统计
		LambdaQueryWrapper<ManagerResourceEntity> resourceWrapper = new LambdaQueryWrapper<>();
		resourceWrapper.setEntityClass(ManagerResourceEntity.class) ;
		query.toWrapper(resourceWrapper);
		functionCount = resourceService.count(resourceWrapper);

		// 角色统计
		LambdaQueryWrapper<ManagerRoleEntity> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.setEntityClass(ManagerRoleEntity.class) ;
		query.toWrapper(queryWrapper);
		roleCount = roleService.count(queryWrapper) ;

		// 账号数量
		LambdaQueryWrapper<ManagerAccountEntity> accountWrapper = new LambdaQueryWrapper<>();
		accountWrapper.setEntityClass(ManagerAccountEntity.class) ;
		query.toWrapper(accountWrapper);
		accountCount = accountService.count(accountWrapper) ;

		// 部门数量
		LambdaQueryWrapper<ManagerDepartmentEntity> departmentWrapper = new LambdaQueryWrapper<>();
		departmentWrapper.setEntityClass(ManagerDepartmentEntity.class) ;
		query.toWrapper(departmentWrapper);
		deptCount = departmentService.count(departmentWrapper) ;

		List<CountBean> list = new ArrayList<>() ;
		list.add(new CountBean(projectCount, "项目数量", projectCount)) ;
		list.add(new CountBean(functionCount, "功能数量", functionCount)) ;
		list.add(new CountBean(roleCount,"角色统计" , roleCount)) ;
		list.add(new CountBean(accountCount,"账号数量" , accountCount)) ;
		list.add(new CountBean(deptCount , "部门数量" , deptCount)) ;

		return AjaxResult.success(list) ;
	}

	@Data
	static class CountBean {

		private long id ;
		private String name ;
		private long count ;

		public CountBean(long id, String name, long count) {
			this.id = id;
			this.name = name;
			this.count = count;
		}
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
