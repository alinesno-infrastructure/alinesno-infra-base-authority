import request from '@/utils/request'
import {parseStrEmpty} from "@/utils/ruoyi";

// 接口配置项
var prefix = '/api/infra/base/authority/enterpriseSetting/';
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
export function listSetting(query) {
    return request({
        url: managerUrl.datatables,
        method: 'post',
        params: query
    })
}

// 查询部门详细
export function getSetting(id) {
    return request({
        url: managerUrl.detailUrl + '/' + parseStrEmpty(id),
        method: 'get'
    })
}

// 新增部门
export function addSetting(data) {
    return request({
        url: managerUrl.saveUrl,
        method: 'post',
        data: data
    })
}

// 修改部门
export function updateSetting(data) {
    return request({
        url: managerUrl.updateUrl,
        method: 'put',
        data: data
    })
}

// 删除部门
export function delSetting(id) {
    return request({
        url: managerUrl.removeUrl + '/' + parseStrEmpty(id),
        method: 'delete'
    })
}

// 查询部门列表（排除节点）
export function listSettingExcludeChild(id) {
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
export function roleSettingTreeselect(roleId) {
    return request({
        url: '/system/dept/roleSettingTreeselect/' + roleId,
        method: 'get'
    })
}

