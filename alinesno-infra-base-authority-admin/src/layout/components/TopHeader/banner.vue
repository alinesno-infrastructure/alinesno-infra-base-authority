<template>
  <div>
    <router-link slots="div" class="header-logo-bar" to="/index">
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
        <i class="fa-solid fa-truck-fast"></i> 请选择当前应用 
      </div>
    </router-link>
  </div>
</template>

<script setup>

const TopHeader = ref('') ;
const saasTitle = 'AIP智能设施'
const enableLogo = true;
const saasUrl = 'http://alinesno-infra-plat-console-admin.beta.plat.infra.linesno.com' ;
const saasLogoUrl = 'http://portal.infra.linesno.com/logo.png' ; 
const displayUrl = ''; 

// 进入企业官网
function enterDomain() {
  if (this.domainName) { // 跳转进入官网
    window.open(this.domainName)
  }
}

function dashboardHome() {
  window.location.href = this.saasUrl
}

function choiceCurrentApplication(){
 console.log('选择应用.') 
}

</script>
