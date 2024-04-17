import request from '@/utils/request'

// 接口配置项
var prefix = '/api/infra/base/authority/managerRole/';
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

// 查询角色列表
export function listRole(query) {
    return request({
        url: managerUrl.datatables,
        method: 'post',
        params: query
    })
}

// 查询角色详细
export function getRole(id) {
    return request({
        url: managerUrl.detailUrl + '/' + parseStrEmpty(id),
        method: 'get'
    })
}

// 新增角色
export function addRole(data) {
    return request({
        url: managerUrl.saveUrl,
        method: 'post',
        data: data
    })
}

// 修改角色
export function updateRole(data) {
    return request({
        url: managerUrl.updateUrl,
        method: 'put',
        data: data
    })
}

// 删除角色
export function delRole(id) {
    return request({
        url: managerUrl.removeUrl + '/' + parseStrEmpty(id),
        method: 'delete'
    })
}

// 角色数据权限
export function dataScope(data) {
    return request({
        url: '/system/role/dataScope',
        method: 'put',
        data: data
    })
}

// 角色状态修改
export function changeRoleStatus(roleId, status) {
    const data = {
        roleId,
        status
    }
    return request({
        url: '/system/role/changeStatus',
        method: 'put',
        data: data
    })
}

// 查询角色已授权用户列表
export function allocatedUserList(query) {
    return request({
        url: '/system/role/authUser/allocatedList',
        method: 'get',
        params: query
    })
}

// 查询角色未授权用户列表
export function unallocatedUserList(query) {
    return request({
        url: '/system/role/authUser/unallocatedList',
        method: 'get',
        params: query
    })
}

// 取消用户授权角色
export function authUserCancel(data) {
    return request({
        url: '/system/role/authUser/cancel',
        method: 'put',
        data: data
    })
}

// 批量取消用户授权角色
export function authUserCancelAll(data) {
    return request({
        url: '/system/role/authUser/cancelAll',
        method: 'put',
        params: data
    })
}

// 授权用户选择
export function authUserSelectAll(data) {
    return request({
        url: '/system/role/authUser/selectAll',
        method: 'put',
        params: data
    })
}
