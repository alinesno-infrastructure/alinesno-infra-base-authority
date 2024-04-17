import request from '@/utils/request';
import { OnlineQuery, OnlineVO } from './types';
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

// 查询在线用户列表
export function list(query: OnlineQuery): AxiosPromise<OnlineVO[]> {
  return request({
    url: managerUrl.datatables,
    method: 'post',
    params: query
  });
}

// 获取服务信息
export function getServer() {
  return request({
    url: '/monitor/server',
    method: 'get'
  })
}

// 强退用户
export function forceLogout(id: string) {
  return request({
    url: managerUrl.removeUrl + '/' + parseStrEmpty(id),
    method: 'delete'
  });
}
