package com.alinesno.infra.base.authority.gateway.provider;

import cn.hutool.core.util.IdUtil;
import com.alinesno.infra.base.authority.api.OrganizationDto;
import com.alinesno.infra.base.authority.entity.OrganizationEntity;
import com.alinesno.infra.base.authority.service.IOrganizationService;
import com.alinesno.infra.common.facade.response.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/api/base/authority/organize")
public class OrganizeProviderController extends BaseProvider {

    @Autowired
    private IOrganizationService organizationService ;

    /**
     * 查询组织信息
     * @return
     */
    @GetMapping("/findOrg")
    public R<OrganizationDto> findOrg(long id){

        OrganizationEntity entity = organizationService.getById(id) ;
        Assert.notNull(entity , "组织信息不存在");

        OrganizationDto dto = new OrganizationDto() ;
        BeanUtils.copyProperties(entity,dto);

        return R.ok(dto);
    }

    /**
     * 更新组织信息
     */
    @PostMapping("/updateOrg")
    public R<OrganizationDto> updateOrg(@RequestBody OrganizationDto dto){

        OrganizationEntity entity = new OrganizationEntity() ;
        Assert.notNull(dto.getId(),"id不能为空") ;

        BeanUtils.copyProperties(dto,entity);

        entity.setOrganizationId(IdUtil.getSnowflakeNextIdStr());
        entity.setDoorplateNumber(IdUtil.nanoId(8));

        boolean b = organizationService.saveOrUpdate(entity);

        return b?R.ok():R.fail();
    }

}
