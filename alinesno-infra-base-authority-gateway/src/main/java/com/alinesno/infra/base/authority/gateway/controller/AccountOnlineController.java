package com.alinesno.infra.base.authority.gateway.controller;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.session.TokenSign;
import cn.dev33.satoken.stp.StpUtil;
import com.alinesno.infra.base.authority.api.SaSessionInfoDto;
import com.alinesno.infra.base.authority.api.TokenSignDto;
import com.alinesno.infra.base.authority.constants.AuthConstants;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.rest.SuperController;
import io.swagger.annotations.Api;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

//    @Autowired
//    private IdentityAccountConsumer identityAccountConsumer ;

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

        List<SaSessionInfoDto> sessionList = getList(0 , 10 , "") ;

        tableDataInfo.setTotal(10);
        tableDataInfo.setRows(sessionList);

        return tableDataInfo ;

    }

    // 将指定账号强制注销
    @GetMapping("/kickout/logout")
    public AjaxResult logout(@RequestParam("userId") long userId) {
        // 调用服务层方法实现强制注销逻辑
        StpUtil.logout(userId);
        return ok() ;
    }

    // 将指定账号踢下线
    @GetMapping("/kickout/kickout")
    public AjaxResult kickout(@RequestParam("userId") long userId) {
        // 调用服务层方法实现踢下线逻辑
        // 踢人下线不会清除Token信息，而是将其打上特定标记，再次访问会提示：Token已被踢下线。
        StpUtil.kickout(userId);

        // 返回
        return ok();
    }

    // 根据 Token 值踢人
    @GetMapping("/kickout/kickoutByTokenValue")
    public AjaxResult kickoutByTokenValue(@RequestParam("tokenValue") String tokenValue) {
        // 调用服务层方法实现根据Token踢人逻辑
        StpUtil.kickoutByTokenValue(tokenValue);

        // 返回
        return ok();
    }

    // 封禁指定账号
    @GetMapping("/disable/disable")
    public AjaxResult disable(@RequestParam("userId") long userId) {
        // 调用服务层方法实现封禁账号逻辑
        StpUtil.disable(userId, 86400);
        return ok("账号 " + userId + " 封禁成功");
    }

    // 解封指定账号
    @GetMapping("/disable/untieDisable")
    public AjaxResult untieDisable(@RequestParam("userId") long userId) {
        // 调用服务层方法实现解封账号逻辑
        StpUtil.untieDisable(userId);
        return ok("账号 " + userId + " 解封成功");
    }

    // 以 lambda 表达式的方式身份切换
    @GetMapping("/switchTo/toUser")
    public AjaxResult toUser(@RequestParam("userId") long userId) {
        // 调用服务层方法实现身份切换逻辑
        // 输出 10001
        log.debug("------- [身份临时切换] 调用前，当前登录账号id是：" + StpUtil.getLoginId());

        // 以 lambda 表达式的方式身份切换，作用范围只在这个 lambda 表达式内有效
        StpUtil.switchTo(userId, () -> {
            log.debug("是否正在身份临时切换中: " + StpUtil.isSwitch());  // 输出 true
            log.debug("获取当前登录账号id: " + StpUtil.getLoginId());   // 输出 10044
        });

        // 结束后，再次获取当前登录账号，输出10001
        log.debug("------- [身份临时切换] 调用结束，当前登录账号id是：" + StpUtil.getLoginId());

        return ok();
    }

//    // 以lambda表达式的方式身份切换    ---- http://localhost:8081/SwitchTo/switchTo2?userId=10044
//    @GetMapping("toUser")
//    public SaResult toUser(long userId) {
//
//        // 输出 10001
//        log.debug("------- [身份临时切换] 调用前，当前登录账号id是：" + StpUtil.getLoginId());
//
//        // 以 lambda 表达式的方式身份切换，作用范围只在这个 lambda 表达式内有效
//        StpUtil.switchTo(userId, () -> {
//            log.debug("是否正在身份临时切换中: " + StpUtil.isSwitch());  // 输出 true
//            log.debug("获取当前登录账号id: " + StpUtil.getLoginId());   // 输出 10044
//        });
//
//        // 结束后，再次获取当前登录账号，输出10001
//        log.debug("------- [身份临时切换] 调用结束，当前登录账号id是：" + StpUtil.getLoginId());
//
//        return SaResult.ok();
//    }

    // 会话查询接口
    @GetMapping("getList")
    public List<SaSessionInfoDto> getList(int start, int size , String keyword) {

        keyword = StringUtils.isNotBlank(keyword)?keyword:"" ;

        // 创建集合
        List<SaSessionInfoDto> sessionList = new ArrayList<>();

        // 分页查询数据
        List<String> sessionIdList = StpUtil.searchSessionId(keyword, start, size, false);
        for (String sessionId: sessionIdList) {

            SaSession session = StpUtil.getSessionBySessionId(sessionId);

            if(session.get(AuthConstants.currentAccountDto) != null){
                SaSessionInfoDto sessionDto = getSaSessionInfoDto(session);
                sessionList.add(sessionDto);
            }
        }

        // 返回
        return sessionList ;
    }

    @NotNull
    private static SaSessionInfoDto getSaSessionInfoDto(SaSession session) {
        com.alinesno.infra.common.web.adapter.base.dto.ManagerAccountDto managerAccountDto = (com.alinesno.infra.common.web.adapter.base.dto.ManagerAccountDto) session.get(AuthConstants.currentAccountDto);
//		log.debug("-->>> managerAccountDto = {}" , JSONObject.toJSONString(managerAccountDto));

        SaSessionInfoDto sessionDto = new SaSessionInfoDto() ;
        BeanUtils.copyProperties(managerAccountDto , sessionDto);
        BeanUtils.copyProperties(session, sessionDto);
        sessionDto.setUserId(managerAccountDto.getId());

        List<TokenSign> signs = session.getTokenSignList() ;
        List<TokenSignDto> signDtos = new ArrayList<>() ;

        for(TokenSign tokenSign : signs){
            TokenSignDto signDto = new TokenSignDto() ;
            BeanUtils.copyProperties(tokenSign, signDto);
            signDtos.add(signDto) ;
        }

        String token = session.getToken() ;
        long tokenTimeout = StpUtil.getTokenTimeout(token) ;
        long sessionTimeout = session.getTimeout() ;
        long disableTime = StpUtil.getDisableTime(token) ;

        String browser = session.getString(AuthConstants.browser) ;
        String osName =  session.getString(AuthConstants.osName) ;
        String loginIP = session.getString(AuthConstants.loginIP) ;
        String loginArea = session.getString(AuthConstants.loginIP_AREA) ;

        // 登陆信息
        sessionDto.setBrowser(browser);
        sessionDto.setOsName(osName);
        sessionDto.setLoginIP(loginIP);
        sessionDto.setLoginArea(loginArea);

        // 浏览器信息
        sessionDto.setTokenTimeout(tokenTimeout);
        sessionDto.setSessionTimeout(sessionTimeout);
        sessionDto.setDisableTime(disableTime);

        sessionDto.setTokenSignList(signDtos);

        return sessionDto;
    }

//    // 将指定账号踢下线   ---- http://localhost:8081/kickout/kickout?userId=10001
//    @GetMapping("kickout")
//    public SaResult kickout(long userId) {
//
//        // 踢人下线不会清除Token信息，而是将其打上特定标记，再次访问会提示：Token已被踢下线。
//        StpUtil.kickout(userId);
//
//        // 返回
//        return SaResult.ok();
//    }
//
//    // 根据Token值踢人    ---- http://localhost:8081/kickout/kickoutByTokenValue?tokenValue=xxxx-xxxx-xxxx-xxxx已登录账号的token值
//    @GetMapping("kickoutByTokenValue")
//    public SaResult kickoutByTokenValue(String tokenValue) {
//
//        StpUtil.kickoutByTokenValue(tokenValue);
//
//        // 返回
//        return SaResult.ok();
//    }

//    /*
//     * 测试步骤：
//         1、访问登录接口，可以正常登录    ---- http://localhost:8081/disable/login?userId=10001
//         2、注销登录    ---- http://localhost:8081/disable/logout
//         3、禁用账号    ---- http://localhost:8081/disable/disable?userId=10001
//         4、再次访问登录接口，登录失败    ---- http://localhost:8081/disable/login?userId=10001
//         5、解封账号    ---- http://localhost:8081/disable/untieDisable?userId=10001
//         6、再次访问登录接口，登录成功    ---- http://localhost:8081/disable/login?userId=10001
//     */
//    // 封禁指定账号  ---- http://localhost:8081/disable/disable?userId=10001
//    @GetMapping("disable")
//    public SaResult disable(long userId) {
//        /*
//         * 账号封禁：
//         * 	参数1：要封禁的账号id
//         * 	参数2：要封禁的时间，单位：秒，86400秒=1天
//         */
//        StpUtil.disable(userId, 86400);
//        return SaResult.ok("账号 " + userId + " 封禁成功");
//    }
//
//    // 解封指定账号  ---- http://localhost:8081/disable/untieDisable?userId=10001
//    @GetMapping("untieDisable")
//    public SaResult untieDisable(long userId) {
//        StpUtil.untieDisable(userId);
//        return SaResult.ok("账号 " + userId + " 解封成功");
//    }


}
