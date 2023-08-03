package com.alinesno.infra.base.authority.api.controller;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alinesno.infra.base.authority.entity.ManagerCodeEntity;
import com.alinesno.infra.base.authority.service.IManagerCodeService;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.core.rest.BaseController;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import io.swagger.annotations.Api;
import jakarta.servlet.http.HttpServletRequest;

/**
 * 
 *
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
@Api(tags = "基础代码配置管理")
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/api/infra/base/authority/ManagerCode")
public class ManagerCodeRest extends BaseController<ManagerCodeEntity, IManagerCodeService> {

	// 日志记录
	private static final Logger log = LoggerFactory.getLogger(ManagerCodeRest.class);

	@Autowired
	private IManagerCodeService managerCodeService;

	
	@ResponseBody
	@PostMapping("/datatables")
	public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {
		log.debug("page = {}", ToStringBuilder.reflectionToString(page));
		return this.toDataInfo(model, this.getFeign(), page);
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
