package com.alinesno.infra.base.authority.gateway.controller;

import com.alinesno.infra.base.authority.api.OrganizationDto;
import com.alinesno.infra.base.authority.datascope.annotation.DataPermissionScope;
import com.alinesno.infra.base.authority.entity.ManagerAccountEntity;
import com.alinesno.infra.base.authority.entity.OrganizationAccountEntity;
import com.alinesno.infra.base.authority.gateway.dto.AuthManagerAccountDto;
import com.alinesno.infra.base.authority.service.IManagerAccountService;
import com.alinesno.infra.base.authority.service.IOrganizationService;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.rest.BaseController;
import com.alinesno.infra.common.web.log.annotation.Log;
import com.alinesno.infra.common.web.log.enums.BusinessType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.servlet.http.HttpServletRequest;
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
@Api(tags = "账号管理")
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/api/infra/base/authority/managerAccount")
public class ManagerAccountRest extends BaseController<ManagerAccountEntity, IManagerAccountService> {

	@Autowired
	private IManagerAccountService managerAccountService;

	@Autowired
	private IOrganizationService orgService ;

	@DataPermissionScope
	@ApiOperation("分页查询账户") 
	@ResponseBody
	@PostMapping("/datatables")
	public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {
		log.debug("page = {}", ToStringBuilder.reflectionToString(page));

		TableDataInfo tableDataInfo = this.toPage(model, this.getFeign(), page);

		List<AuthManagerAccountDto> listDtos = new ArrayList<>() ;
		List<ManagerAccountEntity> list = (List<ManagerAccountEntity>) tableDataInfo.getRows() ;

		list.forEach(item -> {
			AuthManagerAccountDto dto = new AuthManagerAccountDto() ;
			dto = dto.fromDto(item) ;

			List<OrganizationDto> orgList = orgService.listByAccountId(item.getId()) ;
			dto.setOrgList(orgList);

			listDtos.add(dto);
		});

		tableDataInfo.setRows(listDtos);

		return tableDataInfo ;
	}

	@PostMapping("/listOrgUser")
	public TableDataInfo listOrgUser(HttpServletRequest request, Model model, DatatablesPageBean page) {
		log.debug("page = {}", ToStringBuilder.reflectionToString(page));

		String orgId = request.getParameter("orgId") ;
		TableDataInfo tableDataInfo = this.toPage(model, this.getFeign(), page);

		List<AuthManagerAccountDto> listDtos = new ArrayList<>() ;
		List<ManagerAccountEntity> list = (List<ManagerAccountEntity>) tableDataInfo.getRows() ;

		list.forEach(item -> {
			AuthManagerAccountDto dto = new AuthManagerAccountDto() ;
			dto = dto.fromDto(item) ;

			OrganizationAccountEntity orgAccount = orgService.getByAccountIdAndOrgId(item.getId() , Long.parseLong(orgId)) ;
			dto.setOrgType(orgAccount.getOrgType());

			listDtos.add(dto);
		});

		tableDataInfo.setRows(listDtos);

		return tableDataInfo ;
	}

	/**
	 * 状态修改
	 */
	@Log(title = "用户管理", businessType = BusinessType.UPDATE)
	@PutMapping("/changeAccountStatus")
	public AjaxResult changeAccountStatus(@RequestBody ManagerAccountEntity user) {

		managerAccountService.checkUserAllowed(user);
		managerAccountService.checkUserDataScope(user.getUserId());

		return toAjax(managerAccountService.updateUserStatus(user));
	}

	/**
	 * 重置密码
	 * @return
	 */
	@GetMapping("/resetUserPwd")
	public AjaxResult resetUserPwd(@RequestParam Long userId) {
		return toAjax(managerAccountService.resetUserPwd(userId));
	}

	@Override
	public IManagerAccountService getFeign() {
		return this.managerAccountService;
	}



}
