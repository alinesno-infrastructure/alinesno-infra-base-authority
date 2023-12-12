import request from '@/utils/request';
import { PostForm, PostQuery, PostVO } from './types';
import { AxiosPromise } from 'axios';
import {parseStrEmpty} from "@/utils/ruoyi";

// 接口配置项
var prefix = '/api/infra/base/authority/manager_position/';
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

// 查询岗位列表
export function listPost(query: PostQuery): AxiosPromise<PostVO[]> {
  return request({
    url: managerUrl.datatables,
    method: 'post',
    params: query
  });
}

// 查询岗位详细
export function getPost(id: string | number): AxiosPromise<PostVO> {
  return request({
    url: managerUrl.detailUrl + '/' + parseStrEmpty(id),
    method: 'get'
  });
}

// 新增岗位
export function addPost(data: PostForm) {
  return request({
    url: managerUrl.saveUrl,
    method: 'post',
    data: data
  });
}

// 修改岗位
export function updatePost(data: PostForm) {
  return request({
    url: managerUrl.updateUrl,
    method: 'put',
    data: data
  });
}

// 删除岗位
export function delPost(id: string | number | (string | number)[]) {
  return request({
    url: managerUrl.removeUrl + '/' + parseStrEmpty(id),
    method: 'delete'
  });
}
