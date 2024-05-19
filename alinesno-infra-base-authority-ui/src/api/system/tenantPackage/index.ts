import request from '@/utils/request';
import { TenantPkgForm, TenantPkgQuery, TenantPkgVO } from './types';
import { AxiosPromise } from 'axios';

// 查询机构套餐列表
export function listTenantPackage(query?: TenantPkgQuery): AxiosPromise<TenantPkgVO[]> {
  return request({
    url: '/system/group/package/list',
    method: 'get',
    params: query
  });
}

// 查询机构套餐下拉选列表
export function selectTenantPackage(): AxiosPromise<TenantPkgVO[]> {
  return request({
    url: '/system/group/package/selectList',
    method: 'get'
  });
}

// 查询机构套餐详细
export function getTenantPackage(packageId: string | number): AxiosPromise<TenantPkgVO> {
  return request({
    url: '/system/group/package/' + packageId,
    method: 'get'
  });
}

// 新增机构套餐
export function addTenantPackage(data: TenantPkgForm) {
  return request({
    url: '/system/group/package',
    method: 'post',
    data: data
  });
}

// 修改机构套餐
export function updateTenantPackage(data: TenantPkgForm) {
  return request({
    url: '/system/group/package',
    method: 'put',
    data: data
  });
}

// 机构套餐状态修改
export function changePackageStatus(packageId: number | string, status: string) {
  const data = {
    packageId,
    status
  };
  return request({
    url: '/system/group/package/changeStatus',
    method: 'put',
    data: data
  });
}

// 删除机构套餐
export function delTenantPackage(packageId: string | number | Array<string | number>) {
  return request({
    url: '/system/group/package/' + packageId,
    method: 'delete'
  });
}
