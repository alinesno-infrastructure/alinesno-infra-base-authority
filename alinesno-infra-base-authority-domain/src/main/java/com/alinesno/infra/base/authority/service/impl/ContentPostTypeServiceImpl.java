package com.alinesno.infra.base.authority.service.impl;

import com.alinesno.infra.base.authority.entity.ContentPostTypeEntity;
import com.alinesno.infra.base.authority.entity.ManagerProjectEntity;
import com.alinesno.infra.base.authority.enums.ResourceTypeEnmus;
import com.alinesno.infra.base.authority.mapper.ContentPostTypeMapper;
import com.alinesno.infra.base.authority.service.IContentPostTypeService;
import com.alinesno.infra.base.authority.service.IManagerProjectService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@Service
public class ContentPostTypeServiceImpl extends IBaseServiceImpl<ContentPostTypeEntity, ContentPostTypeMapper>
		implements IContentPostTypeService {

	// 日志记录
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(ContentPostTypeServiceImpl.class);

	@Autowired
	private IManagerProjectService managerApplicationService;

	@Override
	public List<ContentPostTypeEntity> findAllWithApplication(QueryWrapper<ContentPostTypeEntity> restWrapper) {
		List<ContentPostTypeEntity> list = findAll();

		List<ManagerProjectEntity> apps = managerApplicationService.findAll();

		for (ManagerProjectEntity app : apps) {
			ContentPostTypeEntity d = new ContentPostTypeEntity();
			d.setPid(ResourceTypeEnmus.PLATFORM_RESOURCE_PARENT.value);
			d.setId(app.getId());
			d.setTypeName(app.getApplicationName());

			for (ContentPostTypeEntity b : list) {
				if (app.getId().equals(b.getApplicationId())
						&& b.getPid().equals(ResourceTypeEnmus.PLATFORM_RESOURCE_PARENT.value)) {
					b.setPid(app.getId());
				}
			}
			list.add(d);
		}

		return list;
	}

}
