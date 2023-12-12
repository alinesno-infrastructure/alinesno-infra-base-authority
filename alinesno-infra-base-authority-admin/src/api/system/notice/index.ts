import request from '@/utils/request';
import { NoticeForm, NoticeQuery, NoticeVO } from './types';
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

// 查询公告列表
export function listNotice(query: NoticeQuery): AxiosPromise<NoticeVO[]> {
  return request({
    url: managerUrl.datatables,
    method: 'post',
    params: query
  });
}

// 查询公告详细
export function getNotice(id: string | number): AxiosPromise<NoticeVO> {
  return request({
    url: managerUrl.detailUrl + '/' + parseStrEmpty(id),
    method: 'get'
  });
}

// 新增公告
export function addNotice(data: NoticeForm) {
  return request({
    url: managerUrl.saveUrl,
    method: 'post',
    data: data
  });
}

// 修改公告
export function updateNotice(data: NoticeForm) {
  return request({
    url: managerUrl.updateUrl,
    method: 'put',
    data: data
  });
}

// 删除公告
export function delNotice(id: string | number | Array<string | number>) {
  return request({
    url: managerUrl.removeUrl + '/' + parseStrEmpty(id),
    method: 'delete'
  });
}
