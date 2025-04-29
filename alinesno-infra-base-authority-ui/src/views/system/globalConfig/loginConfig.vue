<template>
  <div class="app-container config-login-container">
      <el-page-header @back="goBack" style="margin-bottom: 20px;">
          <template #content>
              <span class="text-default font-600 mr-3" style="font-size:16px"> 登陆配置</span>
          </template>
      </el-page-header>

      <el-tabs :tab-position="tabPosition" style="height: calc(100vh - 160px)" class="demo-tabs" v-model="activeTab" @tab-click="handleTabClick">

      <el-tab-pane label="全局配置" name="globalConfig">
        <template #label>
          <i class="fa-solid fa-globe"></i> 全局配置
        </template>
        <el-scrollbar style="height: calc(100vh - 160px);">
          <LoginConfigPanel />
        </el-scrollbar>
      </el-tab-pane>

      <el-tab-pane label="微信登陆配置" name="wechatLoginConfig">
        <template #label>
          <i class="fa-brands fa-weixin"></i> 微信配置
        </template>
        <el-scrollbar style="height: calc(100vh - 160px);">
          <LoginWechatConfigPanel />
        </el-scrollbar>
      </el-tab-pane>

      <el-tab-pane label="短信配置" name="smsConfig">
        <template #label>
          <i class="fa-solid fa-comment-sms"></i> 短信配置
        </template>
        短信配置
      </el-tab-pane>

      <el-tab-pane label="邮件登陆配置" name="emailLoginConfig">
        <template #label>
          <i class="fa-solid fa-envelope"></i> 邮件配置
        </template>
        邮件登陆配置
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';

import LoginConfigPanel from './login/config.vue';
import LoginWechatConfigPanel from './login/wechat.vue';

const tabPosition = ref('right');

// 获取存储的激活标签页
const getStoredActiveTab = () => {
  return localStorage.getItem('activeTab') || 'globalConfig';
};

// 保存激活标签页到本地存储
const saveActiveTab = (tabName) => {
  localStorage.setItem('activeTab', tabName);
};

const activeTab = ref(getStoredActiveTab());

const goBack = () => {
  console.log('go back')
  router.go(-1);
}

// 处理标签页点击事件
const handleTabClick = (tab) => {
  activeTab.value = tab.props.name;
  saveActiveTab(tab.props.name);
};

// 页面加载时恢复标签页状态
onMounted(() => {
  activeTab.value = getStoredActiveTab();
});
</script>

<style scoped lang="scss">
.config-login-container {
  padding: 10px 20px !important;
}
</style>    