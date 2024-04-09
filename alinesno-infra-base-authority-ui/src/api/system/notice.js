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

// 查询公告列表
export function listNotice(query) {
    return request({
        url: managerUrl.datatables,
        method: 'post',
        params: query
    })
}

// 查询公告详细
export function getNotice(id) {
    return request({
        url: managerUrl.detailUrl + '/' + parseStrEmpty(id),
        method: 'get'
    })
}

// 新增公告
export function addNotice(data) {
    return request({
        url: managerUrl.saveUrl,
        method: 'post',
        data: data
    })
}

// 修改公告
export function updateNotice(data) {
    return request({
        url: managerUrl.updateUrl,
        method: 'put',
        data: data
    })
}

// 删除公告
export function delNotice(id) {
    return request({
        url: managerUrl.removeUrl + '/' + parseStrEmpty(id),
        method: 'delete'
    })
}