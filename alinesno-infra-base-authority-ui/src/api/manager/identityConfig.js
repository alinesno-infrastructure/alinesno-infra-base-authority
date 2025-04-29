import request from '@/utils/request'
import {parseStrEmpty} from "@/utils/ruoyi";

// 接口配置项
var prefix = '/api/infra/base/authority/login/identityConfig' 
var managerUrl = {
  getIdentityConfig: prefix + '/getIdentityConfig',
  saveLoginUiConfig: prefix + '/saveLoginUiConfig',
  saveLoginConfig: prefix + '/saveLoginConfig',
  saveWxConfig: prefix + '/saveWxConfig'
}

// 获取登录配置
export function getIdentityConfig() {
  return request({
    url: managerUrl.getIdentityConfig,
    method: 'get'
  })
}

// 保存登录UI配置
export function saveLoginUiConfig(data) {
  return request({
    url: managerUrl.saveLoginUiConfig,
    method: 'post',
    data: data
  })
}

// 保存登录配置
export function saveLoginConfig(data) {
  return request({
    url: managerUrl.saveLoginConfig,
    method: 'post',
    data: data
  })
}

// 保存微信配置
export function saveWxConfig(data) {
  return request({
    url: managerUrl.saveWxConfig,
    method: 'post',
    data: data
  })
}