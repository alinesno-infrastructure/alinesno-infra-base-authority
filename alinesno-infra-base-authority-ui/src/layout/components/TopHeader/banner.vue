<template>
  <div>
    <div class="header-logo-bar">
      <div class="header-logo" v-if="enableLogo" @click="enterDomain">
        <img :src="saasLogoUrl" alt="" />
      </div>
      <a :title="saasTitle" target="_self" class="header-logo-label">
        <span>{{ saasTitle }} </span>
      </a>
      <div v-if="saasUrl" class="dashboard-home" @click="dashboardHome()">
        <i class="fa-solid fa-house"></i> 工作台
      </div>
      <div class="dashboard-home" @click="choiceCurrentApplication()">
        <i :class="applicationInfo.applicationIcons"></i> {{ applicationInfo.applicationName }}
      </div>
    </div>

    <!-- 应用选择弹窗管理 -->
    <el-dialog :title="title" v-model="open" width="1200px" append-to-body>
      <choice-application />

      <template #footer>
        <div class="dialog-footer">
          <!-- <el-button :loading="buttonLoading" type="primary" @click="submitForm">确 定</el-button> -->
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>

    </el-dialog>

  </div>
</template>

<script setup>

const TopHeader = ref('') ;
const saasTitle = 'AIP智能设施'
const enableLogo = ref(true);
const saasUrl = ref('http://alinesno-infra-plat-console-admin.beta.plat.infra.linesno.com') ;
const saasLogoUrl = 'http://portal.infra.linesno.com/logo.png' ; 

import { 
  getCurrentApplication
} from "@/api/system/application";

import ChoiceApplication from '@/views/application/choiceApplication'

/** 参数管理 */
const open = ref(false);
const loading = ref(true);
const title = ref("");
const applicationInfo = ref({
  id: 0 , 
  applicationIcons: 'fa-solid fa-lemon' ,
  applicationName: '请选择当前应用'
})

// 进入企业官网
function enterDomain() {
  if (this.domainName) { // 跳转进入官网
    window.open(this.domainName)
  }
}

function dashboardHome() {
  window.location.href = saasUrl.value
}

/** 取消按钮 */
function cancel() {
  open.value = false;
}

function choiceCurrentApplication(){
 console.log('选择应用.') 
  open.value = true;
  title.value = "请选择应用";
}

/** 获取当前应用信息 */
function handleCurrentApplication(){
  getCurrentApplication().then(res => {
    applicationInfo.value = res.data
  })
}

handleCurrentApplication() ; 

</script>

<style lang="scss" scoped>
.dashboard-home{
  cursor: pointer;
}
</style>