package com.alinesno.infra.base.authority.service.impl;

import cn.hutool.core.util.IdUtil;
import com.alinesno.infra.base.authority.entity.ManagerProjectAccountEntity;
import com.alinesno.infra.base.authority.entity.ManagerProjectEntity;
import com.alinesno.infra.base.authority.enums.SystemInnerEnums;
import com.alinesno.infra.base.authority.mapper.ManagerProjectAccountMapper;
import com.alinesno.infra.base.authority.service.IManagerProjectAccountService;
import com.alinesno.infra.base.authority.service.IManagerProjectService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
public class ManagerProjectAccountServiceImpl
		extends IBaseServiceImpl<ManagerProjectAccountEntity, ManagerProjectAccountMapper>
		implements IManagerProjectAccountService {




}
