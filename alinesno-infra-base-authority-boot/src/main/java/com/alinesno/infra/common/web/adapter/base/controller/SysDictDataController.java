package com.alinesno.infra.common.web.adapter.base.controller;

import com.alinesno.infra.base.authority.entity.ManagerCodeEntity;
import com.alinesno.infra.base.authority.service.IManagerCodeService;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 数据字典信息
 *
 * @author Lion Li
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/system/dict/data")
public class SysDictDataController {

    @Autowired
    private IManagerCodeService managerCodeService ;

    /**
     * 根据字典类型查询字典数据信息
     *
     * @param dictType 字典类型
     */
    @GetMapping(value = "/type/{dictType}")
    public AjaxResult dictType(@PathVariable String dictType) {

        log.debug("dictType = {}" , dictType);

        LambdaQueryWrapper<ManagerCodeEntity>  queryWrapper = new LambdaQueryWrapper<>() ;
        queryWrapper.eq(ManagerCodeEntity::getCodeTypeValue , dictType) ;

        List<ManagerCodeEntity> codes = managerCodeService.list(queryWrapper) ;

        return AjaxResult.success(codes) ;
    }

}
