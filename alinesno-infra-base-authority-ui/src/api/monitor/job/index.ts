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

// 查询定时任务调度列表
export function listJob(query: string) {
  return request({
    url: '/monitor/job/list',
    method: 'get',
    params: query
  })
}

// 强退用户
export function forceLogout(id: string) {
  return request({
    url: managerUrl.removeUrl + '/' + parseStrEmpty(id),
    method: 'delete'
  });
}


// 查询定时任务调度详细
export function getJob(jobId: string) {
  return request({
    url: '/monitor/job/' + jobId,
    method: 'get'
  })
}

// 新增定时任务调度
export function addJob(data: object) {
  return request({
    url: '/monitor/job',
    method: 'post',
    data: data
  })
}

// 修改定时任务调度
export function updateJob(data: object) {
  return request({
    url: '/monitor/job',
    method: 'put',
    data: data
  })
}

// 删除定时任务调度
export function delJob(jobId: string) {
  return request({
    url: '/monitor/job/' + jobId,
    method: 'delete'
  })
}

// 任务状态修改
export function changeJobStatus(jobId: string, status: string) {
  const data = {
    jobId,
    status
  }
  return request({
    url: '/monitor/job/changeStatus',
    method: 'put',
    data: data
  })
}


// 定时任务立即执行一次
export function runJob(jobId: string, jobGroup: string) {
  const data = {
    jobId,
    jobGroup
  }
  return request({
    url: '/monitor/job/run',
    method: 'put',
    data: data
  })
}