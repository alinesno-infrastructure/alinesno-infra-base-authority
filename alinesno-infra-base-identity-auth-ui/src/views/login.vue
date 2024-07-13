<template>
  <el-container class="login-container" v-loading="initLoading">
    <el-header style="z-index: 100;height: 45px;background: #fff;border-bottom: 1px solid #e5e5e5;">
      <div>
        <div style="float: left;font-size: 30px;color:#fff;margin-top: 5px;">
          <img :src="identityInfoPanel.logo" style="width:35px" alt="">
        </div>
        <div class="banner-text">
          {{ identityInfoPanel.systemName }}
        </div>
        <a :href="identityInfoPanel.portalSite"
           target="_blank"
           style="float: right;font-weight: 500;font-size: 13px;margin-top: 14px;color:#222;">
          <i class="fas fa-link"></i> 官网
        </a>
      </div>
    </el-header>
    <el-main class="main-box" style="">

      <div class="login-content">

        <div class="marketing-wrapper">
          <div class="title-header">
            <span class="main-title">
              {{ identityInfoPanel.bannerInfo }}
            </span>
            <span class="sub-title">可安全访问多个相关的应用和服务
            
            </span>
          </div>
        </div>

        <div class="logo-box">
          <div class="wrapper">
            <div class="qr-method method ">
              <div class="alipay-channel">
                <div class="next-loading next-loading-inline" style="display: block; height: 100%;">
                  <div class="next-loading-wrap">
                    <div class="qrlogin-title">扫码登录</div>
                    <div class="qrcode-wrap app-text-wrap">
                      <div class="infra-qrcode-wrapper ">
                        <img class="infra-qrcode" :src="loginQrcode" alt="二维码">
                      </div>
                      <div class="methods-text">使用
                        <span class="methods">二维码登陆</span>
                      </div>
                      <div class="methods-text hover-orange">使用OTLP绑定登陆</div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="password-and-mobile-method method">
                  <div class="tabs-nav">
                    <div class="tabs-item" @click="loginType(true)" :class="smsLoginEnabled?'active':''">
                      <div class="tabs-item-text">验证码登陆</div>
                    </div>
                    <div class="tabs-item" @click="loginType(false)" :class="!smsLoginEnabled?'active':''" style="margin-left:30px;">
                      <div class="tabs-item-text">账号登录</div>
                    </div>
                  </div>
                  <div class="tab-content">

                    <!-- 验证码登陆_start  -->
                    <div class="tab-content-item" v-if="smsLoginEnabled" >
                      <div>
                        <div id="infra-login-iframe" class="password-login-wrapper iframe-loaded">

                              <div class="login">
                                <el-form ref="loginRef" :model="loginForm" :rules="loginRules" class="login-form">

                                  <el-form-item prop="phoneNumber">
                                    <el-input
                                      v-model="loginForm.phoneNumber"
                                      type="text"
                                      size="large"
                                      auto-complete="off"
                                      placeholder="你的手机号"
                                    >
                                      <template #prefix><svg-icon icon-class="user" class="el-input__icon input-icon" /></template>
                                    </el-input>
                                  </el-form-item>

                                  <el-form-item prop="code" v-if="captchaEnabled">
                                    <el-input
                                      v-model="loginForm.code"
                                      size="large"
                                      auto-complete="off"
                                      placeholder="验证码"
                                      style="width: calc(100% - 120px)"
                                      @keyup.enter="handleLogin"
                                    >
                                      <template #prefix><svg-icon icon-class="validCode" class="el-input__icon input-icon" /></template>
                                    </el-input>
                                    <div class="login-code">
                                      <img :src="codeUrl" @click="getCode" class="login-code-img"/>
                                    </div>
                                  </el-form-item>

                                  <el-form-item prop="phoneCode">
                                    <el-input
                                      v-model="loginForm.phoneCode"
                                      type="password"
                                      size="large"
                                      auto-complete="off"
                                      placeholder="手机验证码"
                                      @keyup.enter="handleLogin"
                                    >
                                      <template #prefix><svg-icon icon-class="password" class="el-input__icon input-icon" /></template>
                                      <template #append>
                                        <el-button v-if="phoneCodeEnabled" type="primary" @click="getPhoneCode()" icon-class="search">获取验证码</el-button>
                                        <el-button v-if="!phoneCodeEnabled" type="primary" icon-class="search">{{ timer>=10?timer:'0'+timer }}秒后重发</el-button>
                                      </template>
                                    </el-input>
                                  </el-form-item>

                                  <el-checkbox v-model="loginForm.rememberMe" style="margin:0px 0px 25px 0px;">记住密码</el-checkbox>
                                  <el-form-item style="width:100%;">
                                    <el-button
                                      :loading="loading"
                                      size="large"
                                      type="primary"
                                      style="width:100%;border:0px;background:#3b5998;"
                                      @click.prevent="handleLogin"
                                    >
                                      <span v-if="!loading">登 录</span>
                                      <span v-else>登 录 中...</span>
                                    </el-button>
                                  </el-form-item>
                                </el-form>
                              </div>
                        </div>
                      </div>
                    </div>
                    <!-- 验证码登陆_end  -->


                    <!-- 账号密码登陆_start  -->
                    <div class="tab-content-item" v-if="!smsLoginEnabled" >
                      <div>
                        <div id="infra-login-iframe" class="password-login-wrapper iframe-loaded">

                              <div class="login">
                                <el-form ref="loginRef" :model="loginForm" :rules="loginRules" class="login-form">

                                  <el-form-item prop="username">
                                    <el-input
                                      v-model="loginForm.username"
                                      type="text"
                                      size="large"
                                      auto-complete="off"
                                      placeholder="账号"
                                    >
                                      <template #prefix><svg-icon icon-class="user" class="el-input__icon input-icon" /></template>
                                    </el-input>
                                  </el-form-item>
                                  <el-form-item prop="password">
                                    <el-input
                                      v-model="loginForm.password"
                                      type="password"
                                      size="large"
                                      auto-complete="off"
                                      placeholder="密码"
                                      @keyup.enter="handleLogin"
                                    >
                                      <template #prefix><svg-icon icon-class="password" class="el-input__icon input-icon" /></template>
                                    </el-input>
                                  </el-form-item>


                                  <el-form-item prop="code" v-if="captchaEnabled">
                                    <el-input
                                      v-model="loginForm.code"
                                      size="large"
                                      auto-complete="off"
                                      placeholder="验证码"
                                      style="width: calc(100% - 120px)"
                                      @keyup.enter="handleLogin"
                                    >
                                      <template #prefix><svg-icon icon-class="validCode" class="el-input__icon input-icon" /></template>
                                    </el-input>
                                    <div class="login-code">
                                      <img :src="codeUrl" @click="getCode" class="login-code-img"/>
                                    </div>
                                  </el-form-item>
                                  <el-checkbox v-model="loginForm.rememberMe" style="margin:0px 0px 25px 0px;">记住密码</el-checkbox>

                                  <el-form-item style="width:100%;">
                                    <el-button
                                      :loading="loading"
                                      size="large"
                                      type="primary"
                                      style="width:100%;border:0px;background:#3b5998;"
                                      @click.prevent="handleLogin"
                                    >
                                      <span v-if="!loading">登 录</span>
                                      <span v-else>登 录 中...</span>
                                    </el-button>
                                  </el-form-item>
                                </el-form>
                              </div>
                        </div>
                      </div>
                    </div>
                    <!-- 账号密码登陆_end  -->

                  </div>
            </div>
          </div>
          <div class="protocol">
            <div class="sc-eCImPb infra-dxc">未注册手机验证后自动登录，登录视为您已同意<span class="hover-orange"><a class="protocol">第三方账号绑定协议</a>、<a
                  class="protocol">服务条款</a>、<a class="protocol">隐私政策</a></span></div>
          </div>

        </div>
      </div>
    </el-main>
    <el-footer style="background: rgb(250, 250, 250);bottom: 0px;width: 100%;height: 45px;">
      <div class="copyright-text">© {{ identityInfoPanel.copyrightYear }} {{ identityInfoPanel.copyrightLabel }}</div>
    </el-footer>
  </el-container>
</template>

<script setup>
import { ElMessage } from 'element-plus'
import { getCodeImg ,login , getRedirectUrl , getRegistCode } from "@/api/login";
import Cookies from "js-cookie";
import { encrypt, decrypt } from "@/utils/jsencrypt";
import { getParam } from "@/utils/ruoyi" ;

import homeLogo from '@/assets/logo/logo.png'
import loginQrcode from '@/assets/logo/loginQrcode.png'

import { setSaToken } from '@/utils/auth'

import useUserStore from '@/store/modules/user'
import useIdentityInfoStore from '@/store/modules/info'

const userStore = useUserStore()
const identityInfoStore = useIdentityInfoStore()

const router = useRouter();

const { proxy } = getCurrentInstance();

// 登陆方式类型
const smsLoginEnabled = ref(true);

const loginForm = ref({
  loginType: smsLoginEnabled.value  ,
  phoneNumber: "",
  phoneCode: "",
  username: "",
  password: "",
  rememberMe: false,
  code: "",
  uuid: ""
});

// 登陆信息
const identityInfoPanel = ref({
  systemName: "",
  bannerInfo: "",
  logo: homeLogo ,
  version: "",
  copyrightYear: "",
  copyrightLabel: "",
  portalSite: "" 
})

const loginRules = {
  phoneCode: [{ required: true, trigger: "blur", message: "请输入您的手机验证码" }],
  phoneNumber: [{ required: true, trigger: "blur", message: "请输入您的手机号" }],
  username: [{ required: true, trigger: "blur", message: "请输入您的账号" }],
  password: [{ required: true, trigger: "blur", message: "请输入您的密码" }],
  code: [{ required: true, trigger: "change", message: "请输入验证码" }]
};

const codeUrl = ref("");
const initLoading = ref(false);
const loading = ref(false);
// 验证码开关
const captchaEnabled = ref(true);
// 注册开关
// const register = ref(true);

// 控制发送验证码的倒计时效果
const timer = ref(0)
const phoneCodeEnabled = ref(true) ;

// 定时器id
let clearId ;

const redirect = ref(undefined);

// 点击获取手机验证码
const getPhoneCode = async() => {

  if (timer.value > 0){
    return;
  }

  if (!loginForm.value.phoneNumber){
    proxy.$refs.loginRef.validateField("phoneNumber");
    return;
  }

  phoneCodeEnabled.value = false ;
  // 获取验证码
  
  getRegistCode(loginForm.value.phoneNumber , loginForm.value.code , loginForm.value.uuid).then(res => {
    console.log('res = ' + res);

    ElMessage({
      message: '验证码发送成功，请注意查收短信.',
      type: 'success',
    })
    getCode();

    timer.value = 60 ;

    if(clearId){
      clearInterval(clearId) ;
    }

    clearId = setInterval(() => {
      timer.value--;
      if (timer.value == 0) {
        clearInterval(clearId);
        phoneCodeEnabled.value = true;
      }
    }, 1000);
  }).catch(err => {
      phoneCodeEnabled.value = true;
      // ElMessage.error('验证码发送异常，请一分钟后重试.') ; 
  })

}


function handleLogin() {
  proxy.$refs.loginRef.validate(valid => {
    if (valid) {
      loading.value = true;

      // 勾选了需要记住密码设置在 cookie 中设置记住用户名和密码
      if (loginForm.value.rememberMe) {
        Cookies.set("username", loginForm.value.username, { expires: 30 });
        Cookies.set("password", encrypt(loginForm.value.password), { expires: 30 });
        Cookies.set("rememberMe", loginForm.value.rememberMe, { expires: 30 });

        Cookies.set("phoneNumber", encrypt(loginForm.value.phoneNumber), { expires: 30 });
        Cookies.set("phoneCode", loginForm.value.phoneCode, { expires: 30 });
      } else {
        // 否则移除
        Cookies.remove("username");
        Cookies.remove("password");
        Cookies.remove("rememberMe");

        Cookies.remove("phoneNumber");
        Cookies.remove("phoneCode");
      }
      loginForm.value.loginType = smsLoginEnabled.value?'sms':'account' ;

      console.log('loginForm.value = ' + JSON.stringify(loginForm.value));

      // 调用action的登录方法
      userStore.login(loginForm.value).then((res) => {

        console.log('res = ' + res) ;
        // 登陆成功，则刷新界面
        checkHasLogin();

      }).catch((err) => {
        console.log('error = ' + err) ;
        loading.value = false;
        // 重新获取验证码
        if (captchaEnabled.value) {
          getCode();
        }
      });

    }
  });
}

// 离开界面方法
onMounted(() => {
  clearInterval(clearId) ;
})

function loginType(tip) {
  smsLoginEnabled.value = tip ;
}

function getHomeLogo(){

  return homeLogo ;
}

function getCode() {
  getCodeImg().then(res => {
    captchaEnabled.value = res.captchaEnabled === undefined ? true : res.captchaEnabled;
    if (captchaEnabled.value) {
      codeUrl.value = "data:image/gif;base64," + res.img;
      loginForm.value.uuid = res.uuid;
    }
  });
}

function getCookie() {

  const phoneNumber = Cookies.get("phoneNumber");
  const phoneCode = Cookies.get("phoneCode");

  const username = Cookies.get("username");
  const password = Cookies.get("password");
  const rememberMe = Cookies.get("rememberMe");

  loginForm.value = {
    phoneNumber: phoneNumber === undefined ? loginForm.value.phoneNumber : decrypt(phoneNumber),
    phoneCode: phoneCode === undefined ? loginForm.value.phoneCode : phoneCode,

    username: username === undefined ? loginForm.value.username : username,
    password: password === undefined ? loginForm.value.password : decrypt(password),
    rememberMe: rememberMe === undefined ? false : Boolean(rememberMe)
  };
}

// 检查当前是否已经登录，如果已登录则直接开始跳转，如果未登录则等待用户输入账号密码
function checkHasLogin(){
  var pData = {
    client: getParam('client', ''),
    redirect: getParam('redirect', ''),
    mode: getParam('mode', '')
  };

  console.log('pData = ' + JSON.stringify(pData)) ;

  getRedirectUrl(pData).then(res => {
    console.log('res = ' + res) ;

    if(res.sso_login) {
      // 已登录，并且redirect地址有效，开始跳转
      location.href = decodeURIComponent(res.data);
    } else if(res.code == 401) {
      console.log('未登录');
    } else {
      // TODO 输出异常信息
    }

  });

}

// 获取到系统信息，即当前登陆界面信息
function getIdentityInfo(){
  initLoading.value = true ;

  identityInfoStore.getIdentityInfo().then(res => {
    initLoading.value = false;

    console.log('res--> = ' + res) ;

    identityInfoPanel.value = res.data ;
    console.log('identityInfoPanel = ' + identityInfoPanel.value.systemName)

  }).catch((err) => {
    initLoading.value = false;
  })

}

getIdentityInfo() ;
getCode();
getCookie();
checkHasLogin();

</script>

<style lang="scss">
</style>
