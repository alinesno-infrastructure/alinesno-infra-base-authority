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
      <div class="dashboard-home" @click="choiceCurrentProject()">
        <i :class="projectInfo.projectIcons"></i> {{ projectInfo.projectName }}
      </div>
    </div>

    <!-- 项目选择弹窗管理 -->
    <el-dialog :title="title" v-model="open" v-if="open" width="1200px" append-to-body>
      <choiceProject />

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
  getCurrentProject
} from "@/api/system/project";

import choiceProject from '@/views/project/choiceProject'

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

function choiceCurrentProject(){
 console.log('选择项目.') 
  open.value = true;
  title.value = "请选择项目";
}

/** 获取当前项目信息 */
function handleCurrentProject(){
  getCurrentProject().then(res => {
    projectInfo.value = res.data
  })
}

handleCurrentProject() ; 

</script>

<style lang="scss" scoped>
  .dashboard-home{
    cursor: pointer;
  }
</style>