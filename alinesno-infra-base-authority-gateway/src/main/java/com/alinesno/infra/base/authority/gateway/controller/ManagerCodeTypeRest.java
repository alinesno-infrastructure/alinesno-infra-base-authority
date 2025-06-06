package com.alinesno.infra.base.authority.gateway.controller;

import com.alinesno.infra.base.authority.datascope.annotation.DataPermissionScope;
import com.alinesno.infra.base.authority.entity.ManagerCodeTypeEntity;
import com.alinesno.infra.base.authority.service.IManagerCodeTypeService;
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
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 
 *
 * @author luoxiaodong 
 * @version 1.0.0
 */
@Api(tags = "基础代码配置类型管理")
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/api/infra/base/authority/managerCodeType")
public class ManagerCodeTypeRest extends BaseController<ManagerCodeTypeEntity, IManagerCodeTypeService> {

	// 日志记录
	private static final Logger log = LoggerFactory.getLogger(ManagerCodeTypeRest.class);

	@Autowired
	private IManagerCodeTypeService managerCodeTypeService;


	@DataPermissionScope
	@ResponseBody
	@PostMapping("/datatables")
	public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {
		log.debug("page = {}", ToStringBuilder.reflectionToString(page));
		return this.toPage(model, this.getFeign(), page);
	}

	/**
	 * 获取字典选择框列表
	 */
	@GetMapping("/optionSelect")
	public AjaxResult optionselect() {
		List<ManagerCodeTypeEntity> dictTypes = managerCodeTypeService.list();
		return AjaxResult.success(dictTypes);
	}

	@Override
	public IManagerCodeTypeService getFeign() {
		return this.managerCodeTypeService;
	}
}
