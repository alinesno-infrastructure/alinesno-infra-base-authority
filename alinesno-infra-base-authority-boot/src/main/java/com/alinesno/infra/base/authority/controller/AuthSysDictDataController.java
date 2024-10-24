package com.alinesno.infra.base.authority.controller;

import com.alinesno.infra.base.authority.entity.ManagerCodeEntity;
import com.alinesno.infra.base.authority.service.IManagerCodeService;
import com.alinesno.infra.common.facade.response.AjaxResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 数据字典信息
 *
 * @author luoxiaodong
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/dict/data")
public class AuthSysDictDataController {

    @Autowired
    private IManagerCodeService managerCodeService ;

    @Value("${spring.application.id:projectCode}")
    private String projectCode ;

    /**
     * 根据字典类型查询字典数据信息
     *
     * @param dictType 字典类型
     */
    @GetMapping(value = "/type/{dictType}")
    public AjaxResult dictType(@PathVariable String dictType) {

        log.debug("dictType = {}" , dictType);

        List<ManagerCodeEntity> codes = managerCodeService.codeListByType(dictType  , projectCode) ;

        return AjaxResult.success(codes) ;
    }

}
