import request from '@/utils/request'

// 接口配置项
var prefix = '/api/infra/base/authority/managerSettings/';
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

// 查询参数列表
export function listConfig(query) {
    return request({
        url: managerUrl.datatables,
        method: 'post',
        params: query
    })
}

// 查询参数详细
export function getConfig(id) {
    return request({
        url: managerUrl.detailUrl + '/' + parseStrEmpty(id),
        method: 'get'
    })
}

// 新增参数
export function addConfig(data) {
    return request({
        url: managerUrl.saveUrl,
        method: 'post',
        data: data
    })
}

// 修改参数
export function updateConfig(data) {
    return request({
        url: managerUrl.updateUrl,
        method: 'put',
        data: data
    })
}

// 删除参数
export function delConfig(id) {
    return request({
        url: managerUrl.removeUrl + '/' + parseStrEmpty(id),
        method: 'delete'
    })
}

// 根据参数键名查询参数值
export function getConfigKey(configKey) {
    return request({
        url: '/system/config/configKey/' + configKey,
        method: 'get'
    })
}

// 刷新参数缓存
export function refreshCache() {
    return request({
        url: '/system/config/refreshCache',
        method: 'delete'
    })
}
