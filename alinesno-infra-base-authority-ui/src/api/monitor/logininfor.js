import request from '@/utils/request'

// 接口配置项
var prefix = '/api/infra/base/authority/ManagerDepartment/';
var managerUrl = {
  datatables: prefix + "datatables",
  createUrl: prefix + 'add',
  saveUrl: prefix + 'save',
  updateUrl: prefix + "modify",
  statusUrl: prefix + "changeStatus",
  cleanUrl: prefix + "clean",
  detailUrl: prefix + "detail",
  removeUrl: prefix + "delete",
  exportUrl: prefix + "exportExcel",
  changeField: prefix + "changeField",
  downloadfile: prefix + "downloadfile"
}

// 查询登录日志列表
export function listLogininfor(query) {
  return request({
    url: managerUrl.datatables,
    method: 'post',
    params: query
  })
}

// 删除登录日志
export function delLogininfor(id) {
  return request({
    url: managerUrl.removeUrl + '/' + parseStrEmpty(id),
    method: 'delete'
  })
}

// 解锁用户登录状态
export function unlockLogininfor(userName) {
  return request({
    url: '/monitor/logininfor/unlock/' + userName,
    method: 'get'
  })
}

// 清空登录日志
export function cleanLogininfor() {
  return request({
    url: '/monitor/logininfor/clean',
    method: 'delete'
  })
}
