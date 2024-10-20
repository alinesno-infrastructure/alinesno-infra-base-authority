package com.alinesno.infra.base.authority.gateway.provider;

import com.alinesno.infra.base.authority.entity.ManagerCodeEntity;
import com.alinesno.infra.base.authority.entity.ManagerSettingsEntity;
import com.alinesno.infra.base.authority.gateway.dto.ManagerCodeDto;
import com.alinesno.infra.base.authority.gateway.dto.ManagerSettingsDto;
import com.alinesno.infra.base.authority.service.IManagerCodeService;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.facade.response.R;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/api/base/authority/dict")
public class DictProviderController extends BaseProvider {

    @Autowired
    private IManagerCodeService managerCodeService ;

    /**
     * 通过代码类型查询代码
     *
     * @return
     */
    public R<List<ManagerCodeDto>> codeListByType(String dictType) {
        return null ;
    }

    /**
     * 通过代码类型查询代码
     *
     * @return
     */
    @GetMapping("/codeListByType")
    public R<List<ManagerCodeDto>> codeListByType(String dictType,String projectCode){

        LambdaQueryWrapper<ManagerCodeEntity> queryWrapper = new LambdaQueryWrapper<>() ;
        queryWrapper.eq(ManagerCodeEntity::getCodeTypeValue , dictType) ;

        List<ManagerCodeEntity> codes = managerCodeService.list(queryWrapper) ;
        List<ManagerCodeDto> dtoList = codes.stream().map(ManagerCodeEntity::mapToDto).toList() ;
        
        return R.ok(dtoList) ;
    }

    /**
     * 代码查询
     *
     * @param dictType
     * @param codeValue
     * @return
     */
    public ManagerCodeDto codeByType(Object dictType, Object codeValue){
        return null ;
    }

    /**
     * 通过id查询配置信息
     * @param configId
     * @return
     */
    public ManagerSettingsEntity getById(String configId){

        return null ;
    }

    /**
     * 通过key获取配置
     * @param configKey
     * @return
     */
    public ManagerSettingsEntity getConfigByKey(String configKey) {

        return null ;
    }

    /**
     * 获取配置值
     * @param configKey
     * @return
     */
    public String getConfigValueByKey(String configKey) {

        return null ;
    }

    /**
     * 更新值配置状态
     * @param dto
     * @return
     */
    public AjaxResult updateConfigValueByKey(ManagerSettingsDto dto) {
        return null ;
    }

}
