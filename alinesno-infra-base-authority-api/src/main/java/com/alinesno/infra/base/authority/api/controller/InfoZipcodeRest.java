package com.alinesno.infra.base.authority.api.controller;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alinesno.infra.base.authority.entity.InfoZipcodeEntity;
import com.alinesno.infra.base.authority.service.IInfoZipcodeService;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.core.rest.BaseController;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.servlet.http.HttpServletRequest;

/**
 * 
 *
 * @author LuoAnDong luoandon@gmail.com
 * @version 1.0.0
 */
@Api(tags = "基础邮件区域信息")
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/api/infra/base/authority/InfoZipcode")
public class InfoZipcodeRest extends BaseController<InfoZipcodeEntity, IInfoZipcodeService> {

	// 日志记录
	private static final Logger log = LoggerFactory.getLogger(InfoZipcodeRest.class);

	@Autowired
	private IInfoZipcodeService infoZipcodeService;

	@ApiOperation("分页查询") 
	@ResponseBody
	@PostMapping("/datatables")
	public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {
		log.debug("page = {}", ToStringBuilder.reflectionToString(page));
		return this.toDataInfo(model, this.getFeign(), page);
	}

	@Override
	public IInfoZipcodeService getFeign() {
		return this.infoZipcodeService;
	}
}
