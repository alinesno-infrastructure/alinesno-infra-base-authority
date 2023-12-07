import { UserVO } from '@/api/system/user/types';
import { UserQuery } from '@/api/system/user/types';
import { AxiosPromise } from 'axios';
import { RoleQuery, RoleVO, RoleDeptTree } from './types';
import request from '@/utils/request';
import {parseStrEmpty} from "@/utils/ruoyi";


var prefix = '/api/infra/base/authority/manager_role/';
var managerUrl = {
  datatables : prefix +"datatables" ,
  createUrl: prefix + 'add' ,
  saveUrl: prefix + 'save' ,
  updateUrl: prefix +"modify" ,
  statusUrl: prefix +"changeStatus" ,
  cleanUrl: prefix + "clean",
  detailUrl: prefix +"detail",
  removeUrl: prefix + "delete" ,
  exportUrl: prefix + "exportExcel",
  changeField: prefix + "changeField",
  downloadfile: prefix + "downloadfile"
}

export const listRole = (query: RoleQuery): AxiosPromise<RoleVO[]> => {
  return request({
    url: managerUrl.datatables,
    method: 'post',
    params: query
  });
};

/**
 * 查询角色详细
 */
export const getRole = (id: string | number): AxiosPromise<RoleVO> => {
  return request({
    url: managerUrl.detailUrl + '/' + parseStrEmpty(id),
    method: 'get'
  });
};

/**
 * 新增角色
 */
export const addRole = (data: any) => {
  return request({
    url: managerUrl.saveUrl,
    method: 'post',
    data: data
  });
};

/**
 * 修改角色
 * @param data
 */
export const updateRole = (data: any) => {
  return request({
    url: managerUrl.updateUrl,
    method: 'put',
    data: data
  });
};

/**
 * 角色数据权限
 */
export const dataScope = (data: any) => {
  return request({
    url: '/system/role/dataScope',
    method: 'put',
    data: data
  });
};

/**
 * 角色状态修改
 */
export const changeRoleStatus = (id: string | number, status: string) => {
  const data = {
    id,
    status
  };
  return request({
    url: '/system/role/changeStatus',
    method: 'put',
    data: data
  });
};

/**
 * 删除角色
 */
export const delRole = (id: Array<string | number> | string | number) => {
  return request({
    url: managerUrl.removeUrl + '/' + parseStrEmpty(id),
    method: 'delete'
  });
};

/**
 * 查询角色已授权用户列表
 */
export const allocatedUserList = (query: UserQuery): AxiosPromise<UserVO[]> => {
  return request({
    url: '/system/role/authUser/allocatedList',
    method: 'get',
    params: query
  });
};

/**
 * 查询角色未授权用户列表
 */
export const unallocatedUserList = (query: UserQuery): AxiosPromise<UserVO[]> => {
  return request({
    url: '/system/role/authUser/unallocatedList',
    method: 'get',
    params: query
  });
};

/**
 * 取消用户授权角色
 */
export const authUserCancel = (data: any) => {
  return request({
    url: '/system/role/authUser/cancel',
    method: 'put',
    data: data
  });
};

/**
 * 批量取消用户授权角色
 */
export const authUserCancelAll = (data: any) => {
  return request({
    url: '/system/role/authUser/cancelAll',
    method: 'put',
    params: data
  });
};

/**
 * 授权用户选择
 */
export const authUserSelectAll = (data: any) => {
  return request({
    url: '/system/role/authUser/selectAll',
    method: 'put',
    params: data
  });
};
// 根据角色ID查询部门树结构
export const deptTreeSelect = (id: string | number): AxiosPromise<RoleDeptTree> => {
  return request({
    url: '/system/role/deptTree/' + id,
    method: 'get'
  });
};
