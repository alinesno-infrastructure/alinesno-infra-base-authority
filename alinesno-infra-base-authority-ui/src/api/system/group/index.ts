import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { DeptForm, DeptQuery, DeptVO } from './types';
import {parseStrEmpty} from "@/utils/ruoyi";

// 接口配置项
var prefix = '/api/infra/base/authority/managerTenant/';
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

// 查询部门列表
export const listDept = (query?: DeptQuery) => {
  return request({
    url: managerUrl.datatables,
    method: 'post',
    params: query
  });
};

// 查询部门列表（排除节点）
export const listDeptExcludeChild = (id: string | number): AxiosPromise<DeptVO[]> => {
  return request({
    url: '/system/dept/list/exclude/' + id,
    method: 'post'
  });
};

// 查询部门详细
export const getDept = (id: string | number): AxiosPromise<DeptVO> => {
  return request({
    url: managerUrl.detailUrl + '/' + parseStrEmpty(id),
    method: 'get'
  });
};

// 查询部门下拉树结构
export const treeselect = (): AxiosPromise<DeptVO[]> => {
  return request({
    url: '/system/dept/treeselect',
    method: 'get'
  });
};

// 新增部门
export const addDept = (data: DeptForm) => {
  return request({
    url: managerUrl.saveUrl,
    method: 'post',
    data: data
  });
};

// 修改部门
export const updateDept = (data: DeptForm) => {
  return request({
    url: managerUrl.updateUrl,
    method: 'put',
    data: data
  });
};

// 删除部门
export const delDept = (id: number | string) => {
  return request({
    url: managerUrl.removeUrl + '/' + parseStrEmpty(id),
    method: 'delete'
  });
};
