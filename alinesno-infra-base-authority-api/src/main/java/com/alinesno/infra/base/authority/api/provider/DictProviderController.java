package com.alinesno.infra.base.authority.api.provider;

import com.alinesno.infra.base.authority.api.dto.ManagerCodeDto;
import com.alinesno.infra.base.authority.api.dto.ManagerSettingsDto;
import com.alinesno.infra.base.authority.entity.ManagerSettingsEntity;
import com.alinesno.infra.common.facade.response.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/api/base/authority/dict")
public class DictProviderController extends BaseProvider {
    /**
     * 通过代码类型查询代码
     *
     * @return
     */
    public List<ManagerCodeDto> codeListByType(String codeType) {
        return null ;
    }

    /**
     * 通过代码类型查询代码
     *
     * @return
     */
    public List<ManagerCodeDto> codeListByType(String codeType,String applicationId){
        return null ;
    }

    /**
     * 代码查询
     *
     * @param codeType
     * @param codeValue
     * @return
     */
    public ManagerCodeDto codeByType(Object codeType, Object codeValue){
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
