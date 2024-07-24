package com.alinesno.infra.base.authority.service.impl;

import com.alinesno.infra.base.authority.constants.AuthorityConstants;
import com.alinesno.infra.base.authority.entity.*;
import com.alinesno.infra.base.authority.mapper.ManagerProjectMapper;
import com.alinesno.infra.base.authority.service.IManagerProjectAccountService;
import com.alinesno.infra.base.authority.service.IManagerProjectService;
import com.alinesno.infra.base.authority.sample.SampleProjectHandle;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.*;
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
public class ManagerProjectServiceImpl extends IBaseServiceImpl<ManagerProjectEntity, ManagerProjectMapper> implements IManagerProjectService {

	@Autowired
	private IManagerProjectAccountService  managerApplicationAccountService;

	@Autowired
	private SampleProjectHandle demoPlatformUtils ;

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
	public void initDefaultProject(long userId , long orgId) {

		LambdaQueryWrapper<ManagerProjectEntity> wrapper = new LambdaQueryWrapper<>() ;
		wrapper.eq(ManagerProjectEntity::getOperatorId , userId) ;

		long count = count(wrapper) ;

		if(count == 0){
			demoPlatformUtils.genSimpleProjectData(this , userId , orgId);
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
