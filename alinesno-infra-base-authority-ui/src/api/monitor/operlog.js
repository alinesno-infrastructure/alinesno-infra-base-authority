import request from '@/utils/request'

// 接口配置项
var prefix = '/api/infra/base/authority/apiRecord/';
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

// 查询操作日志列表
export function listOperlog(query) {
  return request({
    url: managerUrl.datatables,
    method: 'post',
    params: query
  })
}

// 删除操作日志
export function delOperlog(id) {
  return request({
    url: managerUrl.removeUrl + '/' + parseStrEmpty(id),
    method: 'delete'
  })
}

// 清空操作日志
export function cleanOperlog() {
  return request({
    url: '/monitor/operlog/clean',
    method: 'delete'
  })
}
