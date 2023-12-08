import request from '@/utils/request';
import { ConfigForm, ConfigQuery, ConfigVO } from './types';
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

// 查询参数列表
export function listConfig(query: ConfigQuery): AxiosPromise<ConfigVO[]> {
  return request({
    url: managerUrl.datatables,
    method: 'post',
    params: query
  });
}

// 查询参数详细
export function getConfig(id: string | number): AxiosPromise<ConfigVO> {
  return request({
    url: managerUrl.detailUrl + '/' + parseStrEmpty(id),
    method: 'get'
  });
}

// 根据参数键名查询参数值
export function getConfigKey(configKey: string): AxiosPromise<String> {
  return request({
    url: '/system/config/configKey/' + configKey,
    method: 'get'
  });
}

// 新增参数配置
export function addConfig(data: ConfigForm) {
  return request({
    url: managerUrl.saveUrl,
    method: 'post',
    data: data
  });
}

// 修改参数配置
export function updateConfig(data: ConfigForm) {
  return request({
    url: managerUrl.updateUrl,
    method: 'put',
    data: data
  });
}

// 修改参数配置
export function updateConfigByKey(key: string, value: any) {
  return request({
    url: '/system/config/updateByKey',
    method: 'put',
    data: {
      configKey: key,
      configValue: value
    }
  });
}

// 删除参数配置
export function delConfig(id: string | number | Array<string | number>) {
  return request({
    url: managerUrl.removeUrl + '/' + parseStrEmpty(id),
    method: 'delete'
  });
}

// 刷新参数缓存
export function refreshCache() {
  return request({
    url: '/system/config/refreshCache',
    method: 'delete'
  });
}
