package com.alinesno.infra.base.authority.gateway.controller;

import cn.hutool.json.JSONUtil;
import com.alinesno.infra.base.authority.entity.ManagerAccountEntity;
import com.alinesno.infra.base.authority.service.IManagerAccountService;
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
import org.checkerframework.checker.index.qual.SameLen;
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
@Api(tags = "账号管理")
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/api/infra/base/authority/managerAccount")
public class ManagerAccountRest extends BaseController<ManagerAccountEntity, IManagerAccountService> {

	@Autowired
	private IManagerAccountService managerAccountService;
 
	@ApiOperation("分页查询账户") 
	@ResponseBody
	@PostMapping("/datatables")
	public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {
		log.debug("page = {}", ToStringBuilder.reflectionToString(page));
		return this.toPage(model, this.getFeign(), page);
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

	@Override
	public IManagerAccountService getFeign() {
		return this.managerAccountService;
	}
 
}
