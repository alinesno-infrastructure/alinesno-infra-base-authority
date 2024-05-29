package com.alinesno.infra.base.authority.gateway.controller;

import com.alinesno.infra.base.authority.entity.ManagerSettingsEntity;
import com.alinesno.infra.base.authority.service.IManagerSettingsService;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.rest.BaseController;
import io.swagger.annotations.Api;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Api(tags = "基础配置管理")
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/api/infra/base/authority/managerSettings")
public class ManagerSettingsRest extends BaseController<ManagerSettingsEntity, IManagerSettingsService> {

	@Autowired
	private IManagerSettingsService managerSettingsService;

	@ResponseBody
	@PostMapping("/datatables")
	public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {
		log.debug("page = {}", ToStringBuilder.reflectionToString(page));
		return this.toPage(model, this.getFeign(), page);
	}

	@GetMapping("getConfigByKey/{key}")
	public AjaxResult getConfigByKey(@PathVariable String key) {
		List<ManagerSettingsEntity> list = managerSettingsService.findByConfigKey(key);
		return AjaxResult.success(list != null && !list.isEmpty() ? list.get(0) : null);
	}

	/**
	 * 刷新参数缓存
	 */
	@DeleteMapping("/refreshCache")
	public AjaxResult refreshCache() {
		managerSettingsService.resetConfigCache();
		return ok();
	}

	@Override
	public IManagerSettingsService getFeign() {
		return this.managerSettingsService;
	}
}
