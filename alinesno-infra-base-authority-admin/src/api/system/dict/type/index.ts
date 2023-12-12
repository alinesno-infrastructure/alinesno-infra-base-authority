import request from '@/utils/request';
import { DictTypeForm, DictTypeVO, DictTypeQuery } from './types';
import { AxiosPromise } from 'axios';
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

// 查询字典类型列表
export function listType(query: DictTypeQuery): AxiosPromise<DictTypeVO[]> {
  return request({
    url: managerUrl.datatables,
    method: 'post',
    params: query
  });
}

// 查询字典类型详细
export function getType(id: number | string): AxiosPromise<DictTypeVO> {
  return request({
    url: managerUrl.detailUrl + '/' + parseStrEmpty(id),
    method: 'get'
  });
}

// 新增字典类型
export function addType(data: DictTypeForm) {
  return request({
    url: managerUrl.saveUrl,
    method: 'post',
    data: data
  });
}

// 修改字典类型
export function updateType(data: DictTypeForm) {
  return request({
    url: managerUrl.updateUrl,
    method: 'put',
    data: data
  });
}

// 删除字典类型
export function delType(id: string | number | Array<string | number>) {
  return request({
    url: managerUrl.removeUrl + '/' + parseStrEmpty(id),
    method: 'delete'
  });
}

// 刷新字典缓存
export function refreshCache() {
  return request({
    url: '/system/dict/type/refreshCache',
    method: 'delete'
  });
}

// 获取字典选择框列表
export function optionselect(): AxiosPromise<DictTypeVO[]> {
  return request({
    url: '/system/dict/type/optionselect',
    method: 'get'
  });
}
