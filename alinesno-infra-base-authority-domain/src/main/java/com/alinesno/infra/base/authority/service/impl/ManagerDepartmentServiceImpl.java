package com.alinesno.infra.base.authority.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alinesno.infra.base.authority.api.dto.AccountDeptDto;
import com.alinesno.infra.base.authority.api.dto.DeptDto;
import com.alinesno.infra.base.authority.entity.ManagerAccountEntity;
import com.alinesno.infra.base.authority.entity.ManagerApplicationEntity;
import com.alinesno.infra.base.authority.entity.ManagerDepartmentEntity;
import com.alinesno.infra.base.authority.enums.ResourceTypeEnmus;
import com.alinesno.infra.base.authority.mapper.ManagerDepartmentMapper;
import com.alinesno.infra.base.authority.service.IManagerAccountService;
import com.alinesno.infra.base.authority.service.IManagerApplicationService;
import com.alinesno.infra.base.authority.service.IManagerDepartmentService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.common.facade.constants.FieldConstants;
import com.alinesno.infra.common.facade.enums.HasStatusEnums;
import com.alinesno.infra.common.facade.wrapper.RpcWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@Service
public class ManagerDepartmentServiceImpl extends IBaseServiceImpl<ManagerDepartmentEntity, ManagerDepartmentMapper> implements IManagerDepartmentService {

	// 日志记录
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(ManagerDepartmentServiceImpl.class);

	@Autowired
	private IManagerApplicationService managerApplicationService;

	@Autowired
	private IManagerAccountService accountService;

	@Override
	public List<ManagerDepartmentEntity> findAllWithApplication(RpcWrapper<ManagerDepartmentEntity> dw,
			RpcWrapper<ManagerApplicationEntity> aw) {

		List<ManagerDepartmentEntity> list = findAll(dw);
		List<ManagerApplicationEntity> apps = managerApplicationService.findAll(aw);

		for (ManagerApplicationEntity app : apps) {
			ManagerDepartmentEntity d = new ManagerDepartmentEntity();
			d.setPid(ResourceTypeEnmus.PLATFORM_RESOURCE_PARENT.value);
			d.setId(app.getId());
			d.setFullName(app.getApplicationName());

			for (ManagerDepartmentEntity b : list) {
				if (app.getId().equals(b.getApplicationId())
						&& ResourceTypeEnmus.PLATFORM_RESOURCE_PARENT.value.equals(b.getPid())) {
					b.setPid(app.getId());
				}
			}
			list.add(d);
		}

		return list;

	}

	@Override
	public Object findDepByApplication(String applicationId, String parentDeptId) {

		QueryWrapper<ManagerDepartmentEntity> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq(FieldConstants.APPLICATION_ID, applicationId);

		if (StringUtils.isNotBlank(parentDeptId)) {
			queryWrapper.eq("pid", parentDeptId);
		} else {
			queryWrapper.apply("(pid = null or pid = '')");
		}

		List<DeptDto> deptList = new ArrayList<DeptDto>();
		List<ManagerDepartmentEntity> dep = list(queryWrapper);

		// 返回查询部门下的人
		if (CollectionUtils.isEmpty(dep)) {
			List<AccountDeptDto> accountList = new ArrayList<AccountDeptDto>();

			QueryWrapper<ManagerAccountEntity> accountWrapper = new QueryWrapper<ManagerAccountEntity>();
			accountWrapper.eq("department", parentDeptId).eq(FieldConstants.HAS_STATUS, HasStatusEnums.LEGAL.value);
			List<ManagerAccountEntity> al = accountService.list(accountWrapper);

			for (ManagerAccountEntity a : al) {
				AccountDeptDto d = new AccountDeptDto();

				d.setDeptId(a.getDepartment());
				d.setSrc(a.getAvatorPath());
				d.setUserId(a.getId());
				d.setUserName(a.getName());

				accountList.add(d);
			}

			return accountList;
		} else {
			for (ManagerDepartmentEntity d : dep) {

				DeptDto dd = new DeptDto();

				dd.setDeptId(d.getId());
				dd.setDeptName(d.getFullName());
				dd.setParentDeptId(d.getPid());

				deptList.add(dd);
			}
		}

		return deptList;
	}

	@Override
	public Object findDepByDeptId(String parentDeptId) {

		QueryWrapper<ManagerDepartmentEntity> queryWrapper = new QueryWrapper<>();
//		queryWrapper.eq(FieldConstants.APPLICATION_ID, applicationId);

		if (StringUtils.isNotBlank(parentDeptId)) {
			queryWrapper.eq("pid", parentDeptId);
		} else {
			queryWrapper.apply("(pid = null or pid = '')");
		}

		List<DeptDto> deptList = new ArrayList<DeptDto>();
		List<ManagerDepartmentEntity> dep = list(queryWrapper);

		// 返回查询部门下的人
		if (CollectionUtils.isEmpty(dep)) {
			List<AccountDeptDto> accountList = new ArrayList<AccountDeptDto>();

			QueryWrapper<ManagerAccountEntity> accountWrapper = new QueryWrapper<ManagerAccountEntity>();
			accountWrapper.eq("department", parentDeptId).eq(FieldConstants.HAS_STATUS, HasStatusEnums.LEGAL.value);
			List<ManagerAccountEntity> al = accountService.list(accountWrapper);

			for (ManagerAccountEntity a : al) {
				AccountDeptDto d = new AccountDeptDto();

				d.setDeptId(a.getDepartment());
				d.setSrc(a.getAvatorPath());
				d.setUserId(a.getId());
				d.setUserName(a.getName());

				accountList.add(d);
			}

			return accountList;
		} else {
			for (ManagerDepartmentEntity d : dep) {

				DeptDto dd = new DeptDto();

				dd.setDeptId(d.getId());
				dd.setDeptName(d.getFullName());
				dd.setParentDeptId(d.getPid());

				deptList.add(dd);
			}
		}

		return deptList;
	}

//	@Override
//	public List<ManagerDepartmentEntity> findAllWithApplication(RestWrapper restWrapper) {
//	
//		List<ManagerDepartmentEntity> list = jpa.findAll(restWrapper.toSpecification()) ; 
//		List<ManagerApplicationEntity> apps = managerApplicationService.findAll(restWrapper.toSpecification()) ; 
//		
//		for(ManagerApplicationEntity app : apps) {
//			ManagerDepartmentEntity d = new ManagerDepartmentEntity() ; 
//			d.setPid(ResourceTypeEnmus.PLATFORM_RESOURCE_PARENT.value);
//			d.setId(app.getId());
//			d.setFullName(app.getApplicationName());
//			
//			for(ManagerDepartmentEntity b : list) {
//				if(app.getId().equals(b.getApplicationId()) && ResourceTypeEnmus.PLATFORM_RESOURCE_PARENT.value.equals(b.getPid())) {
//					b.setPid(app.getId());
//				}
//			}
//			list.add(d) ; 
//		}
//		
//		return list;
//	}
//	
//	@Cacheable(value = "ManagerDepartmentEntity") 
//	@Override
//	public Optional<ManagerDepartmentEntity> findById(String id) {
//		log.debug("ManagerDepartmentEntity.findById :{}" , id);
//		return super.findById(id);
//	}

}
