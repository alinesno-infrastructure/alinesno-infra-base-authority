package com.alinesno.infra.base.authority.gateway.controller;

import com.alinesno.infra.base.authority.adapter.IdentityAccountConsumer;
import com.alinesno.infra.base.authority.api.SaSessionInfoDto;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.web.adapter.rest.SuperController;
import io.swagger.annotations.Api;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 处理与GrantTypeEntity相关的请求的Controller。
 * 继承自BaseController类并实现IGrantTypeService接口。
 *
 * @version 1.0.0
 * @author luoxiaodong
 */
@Slf4j
@Api(tags = "GrantType")
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/api/infra/base/identity/accountOnline")
public class AccountOnlineController extends SuperController {

    @Autowired
    private IdentityAccountConsumer identityAccountConsumer ;

    /**
     * 获取GrantTypeEntity的DataTables数据。
     *
     * @param request HttpServletRequest对象。
     * @param model Model对象。
     * @param page DatatablesPageBean对象。
     * @return 包含DataTables数据的TableDataInfo对象。
     */
    @ResponseBody
    @PostMapping("/datatables")
    public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {

        TableDataInfo tableDataInfo = new TableDataInfo() ;

        List<SaSessionInfoDto> sessionList = (List<SaSessionInfoDto>) identityAccountConsumer.getList("" , 0 , 10).get("data");

        tableDataInfo.setTotal(10);
        tableDataInfo.setRows(sessionList);

        return tableDataInfo ;

    }

}
