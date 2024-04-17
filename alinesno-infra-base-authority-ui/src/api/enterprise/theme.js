import request from '@/utils/request'
import {parseStrEmpty} from "@/utils/ruoyi";

// 接口配置项
var prefix = '/api/infra/base/authority/enterpriseTheme/';
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
    downloadfile: prefix + "downloadfile",
    deptTree: prefix + "deptTree",
}

// 查询部门列表
export function listTheme(query) {
    return request({
        url: managerUrl.datatables,
        method: 'post',
        params: query
    })
}

// 查询部门详细
export function getTheme(id) {
    return request({
        url: managerUrl.detailUrl + '/' + parseStrEmpty(id),
        method: 'get'
    })
}

// 新增部门
export function addTheme(data) {
    return request({
        url: managerUrl.saveUrl,
        method: 'post',
        data: data
    })
}

// 修改部门
export function updateTheme(data) {
    return request({
        url: managerUrl.updateUrl,
        method: 'put',
        data: data
    })
}

// 删除部门
export function delTheme(id) {
    return request({
        url: managerUrl.removeUrl + '/' + parseStrEmpty(id),
        method: 'delete'
    })
}

// 查询部门列表（排除节点）
export function listThemeExcludeChild(id) {
    return request({
        url: '/system/dept/list/exclude/' + id,
        method: 'get'
    })
}

// 查询部门下拉树结构
export function treeselect() {
    return request({
        url: managerUrl.deptTree ,
        method: 'get'
    })
}

// 根据角色ID查询部门树结构
export function roleThemeTreeselect(roleId) {
    return request({
        url: '/system/dept/roleThemeTreeselect/' + roleId,
        method: 'get'
    })
}

