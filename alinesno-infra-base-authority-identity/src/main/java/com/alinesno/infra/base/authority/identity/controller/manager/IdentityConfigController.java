package com.alinesno.infra.base.authority.identity.controller.manager;

import com.alinesno.infra.base.authority.api.identity.IdentityConfigDto;
import com.alinesno.infra.base.authority.api.identity.IdentityUiConfigRequestDto;
import com.alinesno.infra.base.authority.api.identity.LoginConfigRequestDto;
import com.alinesno.infra.base.authority.api.identity.WxConfigRequestDto;
import com.alinesno.infra.base.authority.datascope.annotation.DataPermissionScope;
import com.alinesno.infra.base.authority.identity.domain.IdentityConfigEntity;
import com.alinesno.infra.base.authority.identity.service.IIdentityConfigService;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.rest.BaseController;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 单点登陆配置
 */
@Slf4j
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/api/infra/base/authority/login/identityConfig")
public class IdentityConfigController extends BaseController<IdentityConfigEntity, IIdentityConfigService> {

	@Autowired
	private IIdentityConfigService identityConfigService;

	@DataPermissionScope
	@ResponseBody
	@PostMapping("/datatables")
	public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {
		log.debug("page = {}", ToStringBuilder.reflectionToString(page));
		return this.toPage(model, this.getFeign(), page);
	}

	/**
	 * 获取登陆配置
	 */
	@GetMapping("/getIdentityConfig")
	public AjaxResult getIdentityConfig() {
		IdentityConfigDto entity = identityConfigService.getIdentityConfigDetail();
		return AjaxResult.success(entity);
	}

	/**
	 * 保存登陆界面配置
	 * @return
	 */
	@PostMapping("/saveLoginUiConfig")
	public AjaxResult saveLoginUiConfig(@RequestBody @Validated IdentityUiConfigRequestDto dto) {
		log.debug("saveLoginUiConfig = {}", ToStringBuilder.reflectionToString(dto));
		identityConfigService.saveLoginUiConfig(dto);
		return ok();
	}

	/**
	 * 保存登陆配置
	 * @return
	 */
	@PostMapping("/saveLoginConfig")
	public AjaxResult saveLoginConfig(@RequestBody @Validated LoginConfigRequestDto dto) {
		log.debug("saveLoginConfig = {}", ToStringBuilder.reflectionToString(dto));
		identityConfigService.saveLoginConfig(dto);
		return ok();
	}

	/**
	 * 保存微信配置
	 * @return
	 */
	@PostMapping("/saveWxConfig")
	public AjaxResult saveWxConfig(@RequestBody @Validated WxConfigRequestDto dto) {
		log.debug("saveWxConfig = {}", ToStringBuilder.reflectionToString(dto));
		identityConfigService.saveWxConfig(dto);
		return ok();
	}

	@Override
	public IIdentityConfigService getFeign() {
		return this.identityConfigService;
	}
}
