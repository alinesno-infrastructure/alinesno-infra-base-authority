import request from '@/utils/request'
import { parseStrEmpty } from "@/utils/ruoyi"

// 登录方法
export function login(username, password, code, uuid , loginType , phoneNumber , phoneCode) {
  const data = {
    loginType , 
    phoneNumber , 
    phoneCode,
    username,
    password,
    code,
    uuid
  }
  return request({
    url: '/sso/doLogin',
    headers: {
      isToken: false ,
      'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
    },
    method: 'post',
    data: data
  })
}

// 注册方法
export function register(data) {
  return request({
    url: '/register',
    headers: {
      isToken: false
    },
    method: 'post',
    data: data
  })
}

// 获取用户详细信息
export function getInfo() {
  return request({
    url: '/sso/getData',
    method: 'get'
  })
}

// 获取系统详细信息
export function getIdentityInfo(){
  return request({
    url: '/identityInfo',
    method: 'get'
  })
}

// 退出方法
export function logout() {
  return request({
    url: '/logout',
    method: 'post'
  })
}

// 获取注册验证码
export function getRegistCode(phone , code , uuid) {
  return request({
    url: '/registerCode?phone=' + parseStrEmpty(phone) + '&code=' + parseStrEmpty(code) + '&uuid=' + parseStrEmpty(uuid),
    headers: {
      isToken: false
    },
    method: 'get',
    timeout: 20000
  })
}

// 获取验证码
export function getCodeImg() {
  return request({
    url: '/captchaImage',
    headers: {
      isToken: false
    },
    method: 'get',
    timeout: 20000
  })
}

// 获取信息地址
export function getRedirectUrl(pData){
  return request({
    url: '/sso/getRedirectUrl',
    headers: {
      'X-Requested-With': 'XMLHttpRequest',
			'satoken': localStorage.getItem('satoken')
    },
    method: 'post',
    data: pData 
  })
}