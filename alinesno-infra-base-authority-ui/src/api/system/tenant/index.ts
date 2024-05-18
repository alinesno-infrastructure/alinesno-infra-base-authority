import request from '@/utils/request';
import { TenantForm, TenantQuery, TenantVO } from './types';
import { AxiosPromise } from 'axios';

// 查询组织列表
export function listTenant(query: TenantQuery): AxiosPromise<TenantVO[]> {
  return request({
    url: '/system/group/list',
    method: 'get',
    params: query
  });
}

// 查询组织详细
export function getTenant(id: string | number): AxiosPromise<TenantVO> {
  return request({
    url: '/system/group/' + id,
    method: 'get'
  });
}

// 新增组织
export function addTenant(data: TenantForm) {
  return request({
    url: '/system/group',
    method: 'post',
    headers: {
      isEncrypt: true
    },
    data: data
  });
}

// 修改组织
export function updateTenant(data: TenantForm) {
  return request({
    url: '/system/group',
    method: 'put',
    data: data
  });
}

// 组织状态修改
export function changeTenantStatus(id: string | number, groupId: string | number, status: string) {
  const data = {
    id,
    groupId,
    status
  };
  return request({
    url: '/system/group/changeStatus',
    method: 'put',
    data: data
  });
}

// 删除组织
export function delTenant(id: string | number | Array<string | number>) {
  return request({
    url: '/system/group/' + id,
    method: 'delete'
  });
}

// 动态切换组织
export function dynamicTenant(groupId: string | number) {
  return request({
    url: '/system/group/dynamic/' + groupId,
    method: 'get'
  });
}

// 清除动态组织
export function dynamicClear() {
  return request({
    url: '/system/group/dynamic/clear',
    method: 'get'
  });
}

// 同步组织套餐
export function syncTenantPackage(groupId: string | number, packageId: string | number) {
  const data = {
    groupId,
    packageId
  };
  return request({
    url: '/system/group/syncTenantPackage',
    method: 'get',
    params: data
  });
}
