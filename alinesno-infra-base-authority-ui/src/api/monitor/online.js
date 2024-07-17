import request from '@/utils/request'
import { parseStrEmpty } from "@/utils/ruoyi";

/**
 * 数据库接口操作
 * 
 * @author luoxiaodong
 * @since 1.0.0
 */

// 接口配置项
var prefix = '/api/infra/base/identity/accountOnline/' ;
var managerUrl = {
    datatables : prefix +"datatables" ,
    createUrl: prefix + 'add' ,
    saveUrl: prefix + 'save' ,
    updateUrl: prefix +"modify" ,
    statusUrl: prefix +"changeStatus" ,
    cleanUrl: prefix + "clean",
    detailUrl: prefix +"detail",
    removeUrl: prefix + "delete" ,
    exportUrl: prefix + "exportExcel",
    changeField: prefix + "changeField",
    downloadfile: prefix + "downloadfile" , 

    // 调用配置
    kickoutLogout: prefix + 'kickout/logout',
    kickout: prefix + 'kickout/kickout',
    kickoutByTokenValue: prefix + 'kickout/kickoutByTokenValue',
    disable: prefix + 'disable/disable',
    untieDisable: prefix + 'disable/untieDisable',
    switchTo: prefix + 'switchTo/toUser',
}

// 将指定账号强制注销
export function forceLogout(userId) {
    return request({
        url: managerUrl.kickoutLogout,
        method: 'get',
        params: { userId }
    });
}

// 将指定账号踢下线
export function kickUserOffline(userId) {
    return request({
        url: managerUrl.kickout,
        method: 'get',
        params: { userId }
    });
}

// 根据 Token 值踢人
export function kickByTokenValue(tokenValue) {
    return request({
        url: managerUrl.kickoutByTokenValue,
        method: 'get',
        params: { tokenValue }
    });
}

// 封禁指定账号
export function banUser(userId) {
    return request({
        url: managerUrl.disable,
        method: 'get',
        params: { userId }
    });
}

// 解封指定账号
export function unbanUser(userId) {
    return request({
        url: managerUrl.untieDisable,
        method: 'get',
        params: { userId }
    });
}

// 以 lambda 表达式的方式身份切换
export function switchIdentity(userId) {
    return request({
        url: managerUrl.switchTo,
        method: 'get',
        params: { userId }
    });
}

// 查询数据库列表
export function listAccountOnline(query) {
  return request({
    url: managerUrl.datatables ,
    method: 'post',
    params: query
  })
}

// 查询数据库详细
export function getAccountOnline(databaseId) {
  return request({
    url: managerUrl.detailUrl + '/' + parseStrEmpty(databaseId),
    method: 'get'
  })
}

// 新增数据库
export function addAccountOnline(data) {
  return request({
    url: managerUrl.saveUrl ,
    method: 'post',
    data: data
  })
}

// 修改数据库
export function updateAccountOnline(data) {
  return request({
    url: managerUrl.updateUrl ,
    method: 'put',
    data: data
  })
}

// 删除数据库
export function delAccountOnline(databaseId) {
  return request({
    url: managerUrl.removeUrl + '/' + parseStrEmpty(databaseId),
    method: 'delete'
  })
}
