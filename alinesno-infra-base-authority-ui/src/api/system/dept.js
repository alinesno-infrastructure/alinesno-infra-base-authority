import request from '@/utils/request'
import {parseStrEmpty} from "@/utils/ruoyi";

// 接口配置项
var prefix = '/api/infra/base/authority/managerDepartment/';
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
    listExclude: prefix + "listExclude",
    roleDeptTreeselect: prefix + "roleDeptTreeselect",
    deptTree: prefix + "deptTree",
}

// 查询部门列表
export function listDept(query) {
    return request({
        url: managerUrl.datatables,
        method: 'post',
        params: query
    })
}

// 修改字段
export function changStatusField(data){
    return request({
        url: managerUrl.changeField ,
        method: 'post',
        data: data
    })
}

// 查询部门详细
export function getDept(id) {
    return request({
        url: managerUrl.detailUrl + '/' + parseStrEmpty(id),
        method: 'get'
    })
}

// 新增部门
export function addDept(data) {
    return request({
        url: managerUrl.saveUrl,
        method: 'post',
        data: data
    })
}

// 修改部门
export function updateDept(data) {
    return request({
        url: managerUrl.updateUrl,
        method: 'put',
        data: data
    })
}

// 删除部门
export function delDept(id) {
    return request({
        url: managerUrl.removeUrl + '/' + parseStrEmpty(id),
        method: 'delete'
    })
}

// 查询部门列表（排除节点）
export function listDeptExcludeChild(id) {
    return request({
        // url: '/system/dept/list/exclude/' + id,
        url: managerUrl.listExclude + '/' + parseStrEmpty(id),
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
export function roleDeptTreeselect(roleId) {
    return request({
        url: managerUrl.roleDeptTreeselect + '/' + roleId , 
        method: 'get'
    })
}

