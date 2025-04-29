package com.alinesno.infra.base.authority.gateway.controller;

import com.alinesno.infra.base.authority.entity.ManagerAccountEntity;
import com.alinesno.infra.base.authority.entity.OrganizationAccountEntity;
import com.alinesno.infra.base.authority.gateway.dto.AuthManagerAccountDto;
import com.alinesno.infra.base.authority.service.IManagerAccountService;
import com.alinesno.infra.base.authority.service.IOrganizationAccountService;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.web.adapter.rest.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
@RequestMapping("/api/infra/base/authority/organizationAccount")
public class OrganizationAccountRest extends BaseController<OrganizationAccountEntity, IOrganizationAccountService> {

	@Autowired
	private IOrganizationAccountService orgAccountService ;

	@Autowired
	private IManagerAccountService managerAccountService ;

	@ApiOperation("分页查询")
	
	@PostMapping("/datatables")
	public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {
		log.debug("page = {}", ToStringBuilder.reflectionToString(page));
		TableDataInfo tableDataInfo = this.toPage(model, this.getFeign(), page);

		List<OrganizationAccountEntity> accountlist = (List<OrganizationAccountEntity>) tableDataInfo.getRows();

		List<AuthManagerAccountDto> listDtos = new ArrayList<>() ;
		List<Long> ids = accountlist.stream().map(OrganizationAccountEntity::getAccountId).toList() ;

		List<ManagerAccountEntity> listAccountEntity =  managerAccountService.listByIds(ids) ;
		listAccountEntity.forEach(item -> {
			AuthManagerAccountDto dto = new AuthManagerAccountDto() ;
			dto = dto.fromDto(item) ;

			OrganizationAccountEntity orgAccount = accountlist.stream().filter(item1 -> item1.getAccountId().equals(item.getId())).findFirst().orElse(null) ;
			if(orgAccount != null){
				dto.setOrgType(orgAccount.getOrgType());
			}

			listDtos.add(dto);
		});

		tableDataInfo.setRows(listDtos);

		return tableDataInfo ;

	}

	@Override
	public IOrganizationAccountService getFeign() {
		return this.orgAccountService;
	}
}
