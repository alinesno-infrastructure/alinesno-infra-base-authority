<template>

  <el-container class="login-container" v-loading="initLoading">
  
    <!-- 头部 -->
    <HeaderPanel :identityInfoPanel="identityInfoPanel" />

    <el-main class="main-box" style="background-color: #fafafa;">

    <div class="wechat-bind-phone">
      <div class="user-info">
        <img :src="userInfo.headimgurl" alt="用户头像" class="user-avatar" />
        <p class="user-nickname">{{ userInfo.nickname }}</p>
      </div>
      <div class="phone-input">
        <!-- <label for="phone">手机号：</label> -->
        <el-input v-model="phone" size="large" id="phone" placeholder="绑定手机号，请输入系统登陆手机号" />
      </div>
      <p class="hint">初次微信登陆需要绑定系统账号</p>
      <el-button :loading="isBinding" type="primary" size="large" @click="bindPhone">提交绑定</el-button>
    </div>
    </el-main>

    <el-footer style="background: rgb(250, 250, 250);bottom: 0px;width: 100%;height: 45px;">
      <div class="copyright-text">© {{ identityInfoPanel.copyrightYear }} {{ identityInfoPanel.copyrightLabel }}</div>
    </el-footer>

    </el-container>
  </template>
  
<script setup>
import { ref, onMounted } from 'vue';
import { ElMessage } from 'element-plus';
import { useRoute, useRouter } from 'vue-router';
import { wechatCallback, wechatBindPhone } from '@/api/login';

import HeaderPanel from '@/views/common/header'

import useIdentityInfoStore from '@/store/modules/info'

const initLoading = ref(false);
const identityInfoStore = useIdentityInfoStore()

const route = useRoute();
const router = useRouter();

const redirect = ref(route.query.redirect);
const code = ref(route.query.code);
const state = ref(route.query.state);

const userInfo = ref({
  "nickname": "Switch",
  "headimgurl": "http://data.linesno.com/logo_2.png" 
});

const isBinding = ref(false);
const phone = ref('');

// 登陆信息
const identityInfoPanel = ref({
  systemName: "",
  bannerInfo: "",
  logo: "http://data.linesno.com/logo_2.png",
  version: "",
  copyrightYear: "",
  copyrightLabel: "",
  portalSite: "" 
})

// 获取到系统信息，即当前登陆界面信息
function getIdentityInfo(){
  initLoading.value = true ;

  identityInfoStore.getIdentityInfo().then(res => {
    initLoading.value = false;
    identityInfoPanel.value = res.data ;
    console.log('identityInfoPanel = ' + identityInfoPanel.value.systemName)

  }).catch((err) => {
    initLoading.value = false;
  })

}


onMounted(() => {
  initLoading.value = true;
  wechatCallback(code.value , state.value).then(response => {
    if(response.isBind){
      location.href = redirect.value ;
    }else{
      userInfo.value = response.data;
      getIdentityInfo();
    }
  }).catch(err => {
    setTimeout(() => {
      location.href = '/login?redirect=' + redirect.value;
    } , 1000)
  });
});

const bindPhone = async () => {

  //手机号不能为空
  if (!phone.value) {
    ElMessage.error('手机号不能为空');
    return;
  }

  isBinding.value = true ;
  userInfo.value.phone = phone.value ;

  wechatBindPhone(userInfo.value).then(res => {
    isBinding.value = false;
    location.href = redirect.value ;
  })

}
</script>

<style scoped lang="scss">
.wechat-bind-phone {
  text-align: center;
  padding: 20px;
  width:600px;
  margin: auto;
  margin-top: 10%;

  .user-info {
    margin-bottom: 20px;

    .user-avatar {
      width: 80px;
      height: 80px;
      border-radius: 50%;
      margin-bottom: 10px;
    }

    .user-nickname {
      font-size: 18px;
      font-weight: bold;
    }
  }

  .phone-input {
    margin-bottom: 20px;
    display: flex;
    flex-direction: row;

    // label {
    //   display: block;
    //   margin-bottom: 5px;
    // }

    // input {
      // width: 100%;
      // padding: 10px;
      // border: 1px solid #ccc;
      // border-radius: 5px;
    // }
  }

  .hint {
    color: #999;
    margin-bottom: 20px;
  }

  button {
    padding: 10px 20px;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
  }
}
</style>