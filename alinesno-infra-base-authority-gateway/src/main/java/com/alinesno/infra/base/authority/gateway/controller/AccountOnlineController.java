package com.alinesno.infra.base.authority.gateway.controller;

import cn.dev33.satoken.util.SaResult;
import com.alinesno.infra.base.authority.adapter.IdentityAccountConsumer;
import com.alinesno.infra.base.authority.api.SaSessionInfoDto;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.web.adapter.rest.SuperController;
import io.swagger.annotations.Api;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 处理与GrantTypeEntity相关的请求的Controller。
 * 继承自BaseController类并实现IGrantTypeidentityAccountConsumer接口。
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

        List<SaSessionInfoDto> sessionList = identityAccountConsumer.getList("" , 0 , 10) ;

        tableDataInfo.setTotal(10);
        tableDataInfo.setRows(sessionList);

        return tableDataInfo ;

    }

    // 将指定账号强制注销
    @GetMapping("/kickout/logout")
    public SaResult logout(@RequestParam("userId") String userId) {
        // 调用服务层方法实现强制注销逻辑
        return identityAccountConsumer.logout(userId);
    }

    // 将指定账号踢下线
    @GetMapping("/kickout/kickout")
    public SaResult kickout(@RequestParam("userId") String userId) {
        // 调用服务层方法实现踢下线逻辑
        return identityAccountConsumer.kickout(userId);
    }

    // 根据 Token 值踢人
    @GetMapping("/kickout/kickoutByTokenValue")
    public SaResult kickoutByTokenValue(@RequestParam("tokenValue") String tokenValue) {
        // 调用服务层方法实现根据Token踢人逻辑
        return identityAccountConsumer.kickoutByTokenValue(tokenValue);
    }

    // 封禁指定账号
    @GetMapping("/disable/disable")
    public SaResult disable(@RequestParam("userId") String userId) {
        // 调用服务层方法实现封禁账号逻辑
        return identityAccountConsumer.disable(userId);
    }

    // 解封指定账号
    @GetMapping("/disable/untieDisable")
    public SaResult untieDisable(@RequestParam("userId") String userId) {
        // 调用服务层方法实现解封账号逻辑
        return identityAccountConsumer.untieDisable(userId);
    }

    // 以 lambda 表达式的方式身份切换
    @GetMapping("/switchTo/toUser")
    public SaResult toUser(@RequestParam("userId") String userId) {
        // 调用服务层方法实现身份切换逻辑
        return identityAccountConsumer.toUser(userId);
    }

}
