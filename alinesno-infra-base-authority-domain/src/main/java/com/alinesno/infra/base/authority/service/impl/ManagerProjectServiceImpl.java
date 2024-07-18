package com.alinesno.infra.base.authority.service.impl;

import cn.hutool.core.util.IdUtil;
import com.alinesno.infra.base.authority.constants.AuthorityConstants;
import com.alinesno.infra.base.authority.entity.*;
import com.alinesno.infra.base.authority.enums.MenuEnums;
import com.alinesno.infra.base.authority.enums.SystemInnerEnums;
import com.alinesno.infra.base.authority.mapper.ManagerProjectMapper;
import com.alinesno.infra.base.authority.service.IManagerProjectAccountService;
import com.alinesno.infra.base.authority.service.IManagerProjectService;
import com.alinesno.infra.base.authority.service.IManagerResourceService;
import com.alinesno.infra.base.authority.utils.ManagerResourceUtils;
import com.alinesno.infra.common.core.context.SpringContext;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.*;

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
public class ManagerProjectServiceImpl extends IBaseServiceImpl<ManagerProjectEntity, ManagerProjectMapper> implements IManagerProjectService {

	@Autowired
	private IManagerProjectAccountService  managerApplicationAccountService;

//	@Autowired
//	private IManagerResourceService resourceService;

	@Override
	public List<ManagerProjectEntity> findAllByAccountId(Long accountId) {
		log.debug("accountId:{}", accountId);

		return null ;
	}
 
	@Override
	public ManagerProjectEntity findByProjectCode(String projectCode) {

		Assert.hasLength(projectCode, "应用代码不能为空.");

		LambdaQueryWrapper<ManagerProjectEntity> wrapper = new LambdaQueryWrapper<>() ;
		wrapper.eq(ManagerProjectEntity::getProjectCode , projectCode);

        return getOne(wrapper);
	}

	@Override
	public ManagerProjectEntity insert(ManagerProjectEntity e) {
		save(e);
		return e;
	}

	@Override
	public List<ManagerProjectEntity> latestList(long userId) {

		LambdaQueryWrapper<ManagerProjectEntity> wrapper = new LambdaQueryWrapper<>() ;
//		wrapper.eq(ManagerProjectEntity::getOperatorId , userId) ;
		wrapper.orderByDesc(ManagerProjectEntity::getAddTime) ;

		return list(wrapper) ;
	}

	@Override
	public String getBaseAuthorityProjectCode() {
		return getBaseAuthorityProject().getProjectCode();
	}

	@Override
	public ManagerProjectEntity getBaseAuthorityProject() {
		LambdaQueryWrapper<ManagerProjectEntity> wrapper = new LambdaQueryWrapper<>() ;
		wrapper.eq(ManagerProjectEntity::getProjectCode, AuthorityConstants.BASE_AUTHORITY_PROJECT_CODE) ;
		return getOne(wrapper);
	}


	@Override
	public void initDefaultProject(long userId) {

		LambdaQueryWrapper<ManagerProjectEntity> wrapper = new LambdaQueryWrapper<>() ;
		wrapper.eq(ManagerProjectEntity::getOperatorId , userId) ;

		long count = count(wrapper) ;

		if(count == 0){  // 账户应用为空
			ManagerProjectEntity e = new ManagerProjectEntity() ;

			String defaultIcon = "fa-solid fa-file-shield" ;

			e.setProjectIcons(defaultIcon);
			e.setProjectCode(IdUtil.getSnowflakeNextIdStr());

			e.setProjectName("默认应用示例服务");
			e.setProjectDesc("默认的初始应用服务，用于默认应用示例和演示服务使用，勿使用生产");
			e.setFieldProp("default");
			e.setOperatorId(userId);
			e.setSystemInner(SystemInnerEnums.YES.getCode());

			save(e) ;

			// 初始化应用的默认应用
			LambdaQueryWrapper<ManagerProjectAccountEntity>	maaWrapper = new LambdaQueryWrapper<>() ;
			long countMaa = managerApplicationAccountService.count(maaWrapper.eq(ManagerProjectAccountEntity::getAccountId , userId)) ;

			ManagerProjectAccountEntity maa = new ManagerProjectAccountEntity() ;
			maa.setAccountId(userId);
			maa.setApplicationId(e.getId());
			maa.setAppOrder(countMaa + 1L);

			managerApplicationAccountService.save(maa) ;
		}

	}

	@Override
	public ManagerProjectEntity getApplicationByAccountId(long userId) {

		LambdaQueryWrapper<ManagerProjectAccountEntity> lambdaQueryWrapper = new LambdaQueryWrapper<>() ;

		lambdaQueryWrapper.eq(ManagerProjectAccountEntity::getAccountId , userId)
				.orderByDesc(ManagerProjectAccountEntity::getAppOrder) ;

		List<ManagerProjectAccountEntity> es = managerApplicationAccountService.list(lambdaQueryWrapper) ;

		return CollectionUtils.isEmpty(es) ? null : getById(es.get(0).getApplicationId());
	}


	@Override
	public int deleteByApplicationId(String ids) {
		Assert.hasLength(ids, "主键不能为空");

		String[] rowsIds = ids.split(",");
		// 删除菜单
		for (String id : rowsIds) {
			mapper.deleteById(id);

//			TODO
//			managerResourceService.deleteByApplicationId(id);
		}
		return 0;
	}

	@Override
	public List<ManagerProjectEntity> listByIds(Collection<? extends Serializable> idList) {
		if (null == idList || idList.isEmpty()) {
			return Collections.emptyList();
		} else {
			return super.listByIds(idList);
		}
	}
}
