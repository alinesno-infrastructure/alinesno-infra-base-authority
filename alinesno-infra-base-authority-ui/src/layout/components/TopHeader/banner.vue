<template>
  <div>
    <div class="header-logo-bar">
      <div class="header-logo" v-if="enableLogo" @click="enterDomain">
        <img :src="saasLogoUrl" alt="" />
      </div>
      <a :title="saasTitle" target="_self" class="header-logo-label">
        <span>{{ saasTitle }} </span>
      </a>
      <div v-if="saasUrl" class="dashboard-home">
        <router-link class="header-label-text" to="/index">
          <i class="fa-solid fa-house"></i> 工作台
        </router-link>
      </div>

    </div>

    <!-- 项目选择弹窗管理 -->
    <el-dialog :title="title" v-model="open" v-if="open" width="1200px" append-to-body>
      <choiceProject />

      <template #footer>
        <div class="dialog-footer">
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>

    </el-dialog>

  </div>
</template>

<script setup>

import AIPLogo from '@/assets/logo/logo.png';

const TopHeader = ref('') ;
const saasTitle = 'AIP单点认证系统'
const enableLogo = ref(true);
const saasUrl = ref('http://alinesno-infra-plat-console-admin.beta.base.infra.linesno.com') ;
const saasLogoUrl = AIPLogo ;

// import { 
//   getCurrentProject
// } from "@/api/system/project";

// import choiceProject from '@/views/project/choiceProject'

/** 参数管理 */
const open = ref(false);
const loading = ref(true);
const title = ref("");

const projectInfo = ref({
  id: 0 , 
  projectIcons: 'fa-solid fa-lemon' ,
  projectName: '请选择当前项目'
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

// function choiceCurrentProject(){
//  console.log('选择项目.') 
//   open.value = true;
//   title.value = "请选择项目";
// }

// /** 获取当前项目信息 */
// function handleCurrentProject(){
//   getCurrentProject().then(res => {
//     if(res.data){
//       projectInfo.value = res.data
//     }
//   })
// }

// handleCurrentProject() ; 

</script>

<style lang="scss" scoped>
  .dashboard-home{
    cursor: pointer;
  }
</style>