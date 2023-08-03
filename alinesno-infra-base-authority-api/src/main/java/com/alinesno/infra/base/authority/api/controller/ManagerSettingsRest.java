package com.alinesno.infra.base.authority.api.controller;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alinesno.infra.base.authority.entity.ManagerSettingsEntity;
import com.alinesno.infra.base.authority.service.IManagerSettingsService;
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
@Api(tags = "基础配置管理")
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/api/infra/base/authority/ManagerSettings")
public class ManagerSettingsRest extends BaseController<ManagerSettingsEntity, IManagerSettingsService> {

	// 日志记录
	private static final Logger log = LoggerFactory.getLogger(ManagerSettingsRest.class);

	@Autowired
	private IManagerSettingsService managerSettingsService;

	
	@ResponseBody
	@PostMapping("/datatables")
	public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {
		log.debug("page = {}", ToStringBuilder.reflectionToString(page));
		return this.toDataInfo(model, this.getFeign(), page);
	}

	@GetMapping("getConfigByKey/{key}")
	public AjaxResult getConfigByKey(@PathVariable String key) {
		List<ManagerSettingsEntity> list = managerSettingsService.findByConfigKey(key);
		return AjaxResult.success(list != null && list.size() > 0 ? list.get(0) : null);
	}

	@Override
	public IManagerSettingsService getFeign() {
		return this.managerSettingsService;
	}
}
