package com.alinesno.infra.base.authority.gateway.controller;

import com.alinesno.infra.base.authority.entity.ManagerCodeEntity;
import com.alinesno.infra.base.authority.service.IManagerCodeService;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.facade.pageable.ConditionDto;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.rest.BaseController;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
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
@Api(tags = "基础代码配置管理")
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/api/infra/base/authority/managerCode")
public class ManagerCodeRest extends BaseController<ManagerCodeEntity, IManagerCodeService> {

	@Autowired
	private IManagerCodeService managerCodeService;

	@ResponseBody
	@PostMapping("/datatables")
	public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {

		String codeTypeId = request.getParameter("codeTypeId") ;
		if (codeTypeId != null) {

			List<ConditionDto> conditionList = new ArrayList<>() ;

			ConditionDto dto = new ConditionDto() ;
			dto.setValue(codeTypeId);
			dto.setColumn("code_type_id");

			conditionList.add(dto) ;

			page.setConditionList(conditionList);
		}

		log.debug("page = {}", ToStringBuilder.reflectionToString(page));

		return this.toPage(model, this.getFeign(), page);
	}

	/**
	 * 通过类型查询代码
	 * 
	 * @param type
	 * @return
	 */
	@GetMapping("codeListByType")
	public AjaxResult codeListByType(String type, String applicationId) {
		Assert.hasLength(type, "代码类型为空");

		List<ManagerCodeEntity> data = managerCodeService.codeListByType(type, applicationId);
		return AjaxResult.success(data);
	}

	/**
	 * 通过类型和代码查询代码信息
	 * 
	 * @param type
	 * @return
	 */
	@GetMapping("codeByType")
	public AjaxResult codeByType(String type, String code) {

		Assert.hasLength(type, "代码类型为空");
		Assert.hasLength(code, "代码为空");

		QueryWrapper<ManagerCodeEntity> queryWrapper = new QueryWrapper<ManagerCodeEntity>();
		queryWrapper.apply("code_type_value={0} and code_value={1}", type, code);
		ManagerCodeEntity data = managerCodeService.getOne(queryWrapper);

		return AjaxResult.success(data);
	}

	@Override
	public IManagerCodeService getFeign() {
		return this.managerCodeService;
	}
}
