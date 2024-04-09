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

// 查询菜单列表
export function listMenu(query) {
    return request({
        url: managerUrl.datatables,
        method: 'post',
        params: query
    })
}

// 查询菜单详细
export function getMenu(id) {
    return request({
        url: managerUrl.detailUrl + '/' + parseStrEmpty(id),
        method: 'get'
    })
}

// 新增菜单
export function addMenu(data) {
    return request({
        url: managerUrl.saveUrl,
        method: 'post',
        data: data
    })
}

// 修改菜单
export function updateMenu(data) {
    return request({
        url: managerUrl.updateUrl,
        method: 'put',
        data: data
    })
}

// 删除菜单
export function delMenu(id) {
    return request({
        url: managerUrl.removeUrl + '/' + parseStrEmpty(id),
        method: 'delete'
    })
}

// 查询菜单下拉树结构
export function treeselect() {
    return request({
        url: '/system/menu/treeselect',
        method: 'get'
    })
}

// 根据角色ID查询菜单下拉树结构
export function roleMenuTreeselect(roleId) {
    return request({
        url: '/system/menu/roleMenuTreeselect/' + roleId,
        method: 'get'
    })
}
