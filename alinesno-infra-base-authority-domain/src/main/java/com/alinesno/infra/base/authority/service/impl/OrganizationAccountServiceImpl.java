package com.alinesno.infra.base.authority.service.impl;

import com.alinesno.infra.base.authority.api.OrganizationDto;
import com.alinesno.infra.base.authority.entity.OrganizationAccountEntity;
import com.alinesno.infra.base.authority.entity.OrganizationEntity;
import com.alinesno.infra.base.authority.mapper.OrganizationAccountMapper;
import com.alinesno.infra.base.authority.mapper.OrganizationMapper;
import com.alinesno.infra.base.authority.service.IOrganizationAccountService;
import com.alinesno.infra.base.authority.service.IOrganizationService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@Slf4j
@Service
public class OrganizationAccountServiceImpl extends IBaseServiceImpl<OrganizationAccountEntity, OrganizationAccountMapper> implements IOrganizationAccountService {

    @Autowired
    private OrganizationMapper organizationMapper ;

    @Override
    public OrganizationAccountEntity getByAccountIdAndOrgId(Long id, long orgId) {

        LambdaQueryWrapper<OrganizationAccountEntity> queryWrapper = new LambdaQueryWrapper<>() ;
        queryWrapper.eq(OrganizationAccountEntity::getAccountId, id)
                .eq(OrganizationAccountEntity::getOrgId, orgId) ;

        return getOne(queryWrapper) ;
    }

    @Override
    public List<OrganizationDto> listByAccountId(Long id) {

        LambdaQueryWrapper<OrganizationAccountEntity> queryWrapper = new LambdaQueryWrapper<>() ;
        queryWrapper.eq(OrganizationAccountEntity::getAccountId, id) ;

        List<OrganizationAccountEntity> list = list(queryWrapper) ;

        LambdaQueryWrapper<OrganizationEntity> orgQueryWrapper = new LambdaQueryWrapper<>() ;
        orgQueryWrapper.in(OrganizationEntity::getId, list.stream().map(OrganizationAccountEntity::getOrgId).toList()) ;

        List<OrganizationEntity> orgList = organizationMapper.selectList(orgQueryWrapper) ;

        List<OrganizationDto>  orgDtoList = new ArrayList<>() ;

        if(!orgList.isEmpty()){
            orgList.forEach(org -> {
                OrganizationDto dto = new OrganizationDto() ;
                BeanUtils.copyProperties(org, dto);

                // 设置组织角色类型
                int accountType = list.stream().filter(item -> item.getOrgId().equals(org.getId())).findFirst().get().getOrgType() ;

                orgDtoList.add(dto) ;
            });
        }

        return orgDtoList ;
    }

}
