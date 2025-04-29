package com.alinesno.infra.base.authority.gateway.controller;

import cn.hutool.core.util.IdUtil;
import com.alinesno.infra.base.authority.api.OrganizationDto;
import com.alinesno.infra.base.authority.datascope.annotation.DataPermissionScope;
import com.alinesno.infra.base.authority.entity.OrganizationEntity;
import com.alinesno.infra.base.authority.service.IOrganizationService;
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

/**
 * 
 *
 * @author luoxiaodong 
 * @version 1.0.0
 */
@Slf4j
@Api(tags = "机构管理")
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/api/infra/base/authority/organization")
public class OrganizationRest extends BaseController<OrganizationEntity, IOrganizationService> {

	@Autowired
	private IOrganizationService orgService;

	@ApiOperation("分页查询")

	@DataPermissionScope
	@PostMapping("/datatables")
	public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {
		log.debug("page = {}", ToStringBuilder.reflectionToString(page));
		// return this.toPage(model, this.getFeign(), page);

        return orgService.queryOrganization(page , CurrentAccountJwt.getUserId());
	}

	/**
	 * 创建组织(createOrg)
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/createOrg")
	public AjaxResult createOrg(@RequestBody OrganizationDto dto) {

		dto.setOrganizationId(IdUtil.getSnowflakeNextIdStr());

		orgService.createOrJoinOrg(dto , CurrentAccountJwt.getUserId());
		return ok();
	}

	@ResponseBody
	@PostMapping("saveOrg")
	public AjaxResult saveOrg(@RequestBody OrganizationEntity entity) throws Exception {

		entity.setOrganizationId(IdUtil.getSnowflakeNextIdStr());
		orgService.save(entity);
		return ok();
	}

	@Override
	public IOrganizationService getFeign() {
		return this.orgService;
	}
}
