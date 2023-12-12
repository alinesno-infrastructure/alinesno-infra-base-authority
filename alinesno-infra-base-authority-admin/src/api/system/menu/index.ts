import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { MenuQuery, MenuVO, MenuForm, MenuTreeOption, RoleMenuTree } from './types';
import {parseStrEmpty} from "@/utils/ruoyi";

// 接口配置项
var prefix = '/api/infra/base/authority/manager_user/';
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

// 查询菜单列表
export const listMenu = (query?: MenuQuery): AxiosPromise<MenuVO[]> => {
  return request({
    url: managerUrl.datatables,
    method: 'post',
    params: query
  });
};

// 查询菜单详细
export const getMenu = (id: string | number): AxiosPromise<MenuVO> => {
  return request({
    url: managerUrl.detailUrl + '/' + parseStrEmpty(id),
    method: 'get'
  });
};

// 查询菜单下拉树结构
export const treeselect = (): AxiosPromise<MenuTreeOption[]> => {
  return request({
    url: '/system/menu/treeselect',
    method: 'get'
  });
};

// 根据角色ID查询菜单下拉树结构
export const roleMenuTreeselect = (roleId: string | number): AxiosPromise<RoleMenuTree> => {
  return request({
    url: '/system/menu/roleMenuTreeselect/' + roleId,
    method: 'get'
  });
};

// 根据角色ID查询菜单下拉树结构
export const tenantPackageMenuTreeselect = (packageId: string | number): AxiosPromise<RoleMenuTree> => {
  return request({
    url: '/system/menu/tenantPackageMenuTreeselect/' + packageId,
    method: 'get'
  });
};

// 新增菜单
export const addMenu = (data: MenuForm) => {
  return request({
    url: managerUrl.saveUrl,
    method: 'post',
    data: data
  });
};

// 修改菜单
export const updateMenu = (data: MenuForm) => {
  return request({
    url: managerUrl.updateUrl,
    method: 'put',
    data: data
  });
};

// 删除菜单
export const delMenu = (id: string | number) => {
  return request({
    url: managerUrl.removeUrl + '/' + parseStrEmpty(id),
    method: 'delete'
  });
};
