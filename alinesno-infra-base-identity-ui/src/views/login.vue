<template>
  <el-container class="login-container" v-loading="initLoading">
  
    <!-- 头部 -->
    <HeaderPanel :identityInfoPanel="identityInfoPanel" />

    <el-main class="main-box" :style="identityInfoPanel.backgroundImage?'background-image: url('+ identityInfoPanel.backgroundImage +')':''">

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

                  <div class="next-loading-wrap" v-if="identityInfoPanel.enableWxLogin">
                    <div class="qrlogin-title">微信扫码登录</div>
                    <div class="qrcode-wrap app-text-wrap">
                      <div class="infra-qrcode-wrapper" id="wx_qrcode_login_container">
                      </div>
                    </div>
                  </div>

                  <div class="next-loading-wrap" style="margin-top:0px;" v-if="!identityInfoPanel.enableWxLogin">
                    <div class="qrlogin-title">单点登陆系统</div>
                    <div class="qrcode-wrap app-text-wrap" style="margin-top:40px;margin-bottom:50px">
                      <div class="infra-qrcode-wrapper" id="wx_qrcode_login_container">
                        <img class="infra-qrcode" :src="loginQrcode" alt="二维码"> 
                      </div>
                    </div>
                    <div class="methods-text">
                      请使用微微信扫描二维码登陆
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
                                      placeholder="手机号"
                                    >
                                      <template #prefix><svg-icon icon-class="user" class="el-input__icon input-icon" /></template>
                                    </el-input>
                                  </el-form-item>
                                  <el-form-item prop="password">
                                    <el-input
                                      v-model="loginForm.password"
                                      type="password"
                                      show-password
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
                              <div style="font-size: 13px;text-align: right;color: #666;">
                                <router-link :to="'/register?redirect=' + route.query.redirect">
                                  没有账号？
                                </router-link>
                              </div>
                        </div>
                      </div>
                    </div>
                    <!-- 账号密码登陆_end  -->

                  </div>
            </div>
          </div>
          <div class="protocol">
            <div class="sc-eCImPb infra-dxc">未注册手机验证码获取后自动登录，登录视为您已同意<span class="hover-orange"><a class="protocol">第三方账号绑定协议</a>、<a
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

import VueQrcode from '@chenfengyuan/vue-qrcode';
import HeaderPanel from '@/views/common/header'
import homeLogo from '@/assets/logo/logo.png'

import { setSaToken } from '@/utils/auth'

import useUserStore from '@/store/modules/user'
import useIdentityInfoStore from '@/store/modules/info'

const userStore = useUserStore()
const identityInfoStore = useIdentityInfoStore()
const loginQrcode = ref("http://alinesno-infra-smart-im-ui.beta.base.infra.linesno.com/assets/data_03.3a68d050.svg") 

const route = useRoute();
const router = useRouter();

const { proxy } = getCurrentInstance();

// 登陆方式类型
const smsLoginEnabled = ref(true);

const loginForm = ref({
  loginType: smsLoginEnabled.value  ,
  backgroundImage: "",
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

  if (!loginForm.value.phoneNumber || !loginForm.value.code ){
    proxy.$refs.loginRef.validateField("phoneNumber");
    proxy.$refs.loginRef.validateField("code");
    return;
  }

  phoneCodeEnabled.value = false ;
  // 获取验证码
  
  getRegistCode(loginForm.value.phoneNumber , loginForm.value.code , loginForm.value.uuid).then(res => {
    console.log('res = ' + res);

    loginForm.value.phoneCode = res.data ;

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

  if(tip && !identityInfoPanel.value.enableSmsLogin){
    ElMessage({
      message: '轻暂未开启短信登录功能 , 请联系管理员开启.' ,
      type: 'warning',
    })
    return ;
  }

  smsLoginEnabled.value = tip ;
  loginForm.value.code = "" ;  // 切换一次则清空验证码
  getCode();
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

    loading.value = false;

    if(res.sso_login) {
      // 已登录，并且redirect地址有效，开始跳转
      location.href = decodeURIComponent(res.data);
    } else if(res.code == 401) {
      console.log('未登录');
    } else {
      // TODO 输出异常信息
      // ElMessage.warning('未登录')
    }

  });

}

// 获取到系统信息，即当前登陆界面信息
function getIdentityInfo(){
  initLoading.value = true ;

  identityInfoStore.getIdentityInfo().then(res => {
    initLoading.value = false;

    identityInfoPanel.value = res.data ;
    console.log('identityInfoPanel = ' + identityInfoPanel.value.systemName)

    // 是否支持短信登陆
    if(identityInfoPanel.value.smsLogin){
      smsLoginEnabled.value = true ;
    }else{
      smsLoginEnabled.value = false ;
    }

    if(identityInfoPanel.value.enableWxLogin){
      getWxLoginConfig(identityInfoPanel.value) ;
    }

  }).catch((err) => {
    initLoading.value = false;
  })

}

// 引入微信登陆配置
const getWxLoginConfig = (identityInfo) => {

  const callbackUrl = identityInfo.callbackUrl + "?redirect=" + getParam('redirect', '') ;

  // 引入微信登录 JS 文件
  const script = document.createElement('script');
  script.src = 'http://res.wx.qq.com/connect/zh_CN/htmledition/js/wxLogin.js';
  script.onload = () => {
    // 实例化微信登录对象
    const obj = new WxLogin({
      self_redirect: false,
      id: 'wx_qrcode_login_container',
      appid: identityInfo.wxAppId , 
      scope: 'snsapi_login',
      redirect_uri: encodeURIComponent(callbackUrl) , 
      state: identityInfo.wxState , 
      style: 'black',
      href: 'data:text/css;base64,LmltcG93ZXJCb3ggLnFyY29kZSB7d2lkdGg6IDEwMCU7Ym9yZGVyOiAwcHg7Ym9yZGVyLXJhZGl1czogMjBweDt9Ci5pbXBvd2VyQm94IC50aXRsZSB7ZGlzcGxheTogbm9uZTt9Ci5pbXBvd2VyQm94IC5pbmZvIHt3aWR0aDogMTAwJTt9Ci5zdGF0dXNfaWNvbiB7ZGlzcGxheTogbm9uZX0KLmltcG93ZXJCb3ggLnN0YXR1cyB7dGV4dC1hbGlnbjogY2VudGVyO30gCi5xbG9naW5fbW9kIHttYXJnaW4tdG9wOiA4MHB4O30g' , 
      onReady: (isReady) => {
        console.log(isReady);
      },
    });
  };
  document.head.appendChild(script);
}

onMounted(() => {
  getIdentityInfo() ;
  getCode();
  checkHasLogin();
  getCookie();
});

</script>

<style lang="scss">
.infra-qrcode-wrapper{ 
  iframe {
    width: 100%;
  }
}
</style>
