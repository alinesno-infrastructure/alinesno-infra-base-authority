package com.alinesno.infra.base.authority.service.impl;

import com.alinesno.infra.base.authority.api.dto.TreeSelect;
import com.alinesno.infra.base.authority.entity.ManagerAccountEntity;
import com.alinesno.infra.base.authority.entity.ManagerDepartmentEntity;
import com.alinesno.infra.base.authority.entity.ManagerProjectEntity;
import com.alinesno.infra.base.authority.enums.MenuEnums;
import com.alinesno.infra.base.authority.gateway.dto.AccountDeptDto;
import com.alinesno.infra.base.authority.gateway.dto.DeptDto;
import com.alinesno.infra.base.authority.mapper.ManagerDepartmentMapper;
import com.alinesno.infra.base.authority.service.IManagerAccountService;
import com.alinesno.infra.base.authority.service.IManagerDepartmentService;
import com.alinesno.infra.base.authority.service.IManagerProjectService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import com.alinesno.infra.common.core.utils.StringUtils;
import com.alinesno.infra.common.facade.constants.FieldConstants;
import com.alinesno.infra.common.facade.enums.HasStatusEnums;
import com.alinesno.infra.common.facade.wrapper.RpcWrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
public class ManagerDepartmentServiceImpl extends IBaseServiceImpl<ManagerDepartmentEntity, ManagerDepartmentMapper> implements IManagerDepartmentService {

	@Autowired
	private IManagerAccountService accountService;

	private final IManagerProjectService managerProjectService ;

	public ManagerDepartmentServiceImpl(@Lazy IManagerProjectService managerProjectService) {
		this.managerProjectService = managerProjectService;
	}


	@Override
	public List<ManagerDepartmentEntity> findAllWithApplication(RpcWrapper<ManagerDepartmentEntity> dw,
			RpcWrapper<ManagerProjectEntity> aw) {

		List<ManagerDepartmentEntity> list = findAll(dw);
		List<ManagerProjectEntity> apps = managerProjectService.findAll(aw);

		for (ManagerProjectEntity app : apps) {
			ManagerDepartmentEntity d = new ManagerDepartmentEntity();
			d.setPid(Long.parseLong(MenuEnums.MENU_PLATFORM.value));
			d.setId(app.getId());
			d.setFullName(app.getApplicationName());

			for (ManagerDepartmentEntity b : list) {
                app.getId();
                b.getApplicationId();
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
				d.setSrc(a.getAvatarPath());
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
				d.setSrc(a.getAvatarPath());
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
	public void initDept(Long projectId) {

//		LambdaQueryWrapper<ManagerDepartmentEntity> wrapper = new LambdaQueryWrapper<>() ;
//		wrapper.eq(ManagerDepartmentEntity::getProjectId , projectId);
//
//		long count = count(wrapper) ;
//		if(count > 0){
//			return ;
//		}
//
//		ManagerDepartmentEntity d = new ManagerDepartmentEntity() ;
//
//		d.setProjectId(projectId);
//
//		d.setSimpleName("父类部门");
//		d.setLeader("AIP管理员");
//		d.setEmail("aip@gmail.com");
//		d.setPhone("15578777777");
//		d.setPid(0L);
//
//		save(d) ;

	}

	@Override
	public List<TreeSelect> selectDeptTreeList() {

		// 查询出用户所有数据权限项目
		LambdaQueryWrapper<ManagerProjectEntity> projectionWrapper =  new LambdaQueryWrapper<>() ;
		List<ManagerProjectEntity> projects = managerProjectService.list(projectionWrapper) ;

		List<Long> projectIds = projects.stream().map(ManagerProjectEntity::getId).toList() ;

		LambdaQueryWrapper<ManagerDepartmentEntity> wrapper = new LambdaQueryWrapper<>() ;
		wrapper.in(ManagerDepartmentEntity::getProjectId , projectIds) ;

		List<ManagerDepartmentEntity> depts = list(wrapper) ;

		// 将三个项目放到主菜单当中
		for(ManagerProjectEntity p : projects){
			ManagerDepartmentEntity dept = new ManagerDepartmentEntity() ;

			dept.setId(p.getId()) ;
			dept.setPid(0L);
			dept.setFullName(p.getProjectName()) ;
			dept.setSimpleName(p.getProjectName()) ;
			dept.setDescription(p.getProjectDesc()) ;

			depts.add(dept) ;
		}

		return TreeSelect.buildDeptTree(depts);
	}

	@Override
	public List<ManagerDepartmentEntity> selectDeptList(ManagerDepartmentEntity managerDepartmentEntity, long projectId) {
		return list() ;
	}

	@Override
	public List<Long> selectDeptListByRoleId(Long roleId) {

		return null;
	}

	/**
	 * 构建前端所需要下拉树结构
	 *
	 * @param depts 部门列表
	 * @return 下拉树结构列表
	 */
	public List<TreeSelect> buildDeptTreeSelect(List<ManagerDepartmentEntity> depts) {
		List<ManagerDepartmentEntity> deptTrees = buildDeptTree(depts);
		return deptTrees.stream().map(TreeSelect::new).collect(Collectors.toList());
	}

	/**
	 * 构建前端所需要树结构
	 *
	 * @param depts 部门列表
	 * @return 树结构列表
	 */
	public List<ManagerDepartmentEntity> buildDeptTree(List<ManagerDepartmentEntity> depts) {

		List<ManagerDepartmentEntity> returnList = new ArrayList<>();
		List<Long> tempList = depts.stream().map(ManagerDepartmentEntity::getId).toList();

		for (ManagerDepartmentEntity dept : depts) {
			// 如果是顶级节点, 遍历该父节点的所有子节点
			if (!tempList.contains(dept.getPid())) {
				recursionFn(depts, dept);
				returnList.add(dept);
			}
		}if (returnList.isEmpty()) {
			returnList = depts;
		}

		return returnList;
	}

	/**
	 * 递归列表
	 */
	private void recursionFn(List<ManagerDepartmentEntity> list, ManagerDepartmentEntity t) {

		// 得到子节点列表
		List<ManagerDepartmentEntity> childList = getChildList(list, t);
		t.setChildren(childList);

		for (ManagerDepartmentEntity tChild : childList) {
			if (hasChild(list, tChild)) {
				recursionFn(list, tChild);
			}
		}

	}

	/**
	 * 得到子节点列表
	 */
	private List<ManagerDepartmentEntity> getChildList(List<ManagerDepartmentEntity> list, ManagerDepartmentEntity t) {

		List<ManagerDepartmentEntity> tlist = new ArrayList<>();

        for (ManagerDepartmentEntity n : list) {
            if (StringUtils.isNotNull(n.getPid()) && n.getPid().longValue() == t.getId().longValue()) {
                tlist.add(n);
            }
        }

		return tlist;
	}

	/**
	 * 判断是否有子节点
	 */
	private boolean hasChild(List<ManagerDepartmentEntity> list, ManagerDepartmentEntity t) {
		return !getChildList(list, t).isEmpty();
	}

}
