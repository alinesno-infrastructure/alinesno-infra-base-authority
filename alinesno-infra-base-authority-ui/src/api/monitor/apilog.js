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

// 查询接口日志列表
export function listApilog(query) {
    return request({
        url: managerUrl.datatables,
        method: 'post',
        params: query
    })
}

// 删除接口日志
export function delApilog(id) {
    return request({
        url: managerUrl.removeUrl + '/' + parseStrEmpty(id),
        method: 'delete'
    })
}

// 清空接口日志
export function cleanApilog() {
    return request({
        url: '/monitor/Apilog/clean',
        method: 'delete'
    })
}
