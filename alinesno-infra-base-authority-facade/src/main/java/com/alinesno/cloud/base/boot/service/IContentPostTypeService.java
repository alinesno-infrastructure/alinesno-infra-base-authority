package com.alinesno.cloud.base.boot.service;

import java.util.List;

import com.alinesno.cloud.base.boot.entity.ContentPostTypeEntity;
import com.alinesno.infra.common.facade.services.IBaseService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author WeiXiaoJin
 * @since 2018-12-16 17:53:19
 */

public interface IContentPostTypeService extends IBaseService<ContentPostTypeEntity> {

	List<ContentPostTypeEntity> findAllWithApplication(QueryWrapper<ContentPostTypeEntity> restWrapper);

}
