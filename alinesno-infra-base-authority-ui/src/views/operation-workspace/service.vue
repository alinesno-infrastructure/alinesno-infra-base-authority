<template>
  <div>
    <el-row class="acp-dashboard-panel" :gutter="20">
      <el-col class="panel-col" :span="19">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title"><i class="fa-solid fa-file-waveform"></i> 新最应用列表</div>
          </div>
          <div class="panel-body acp-height-auto" >
            <div class="acp-app-list">
              <ul>
                <li class="app-items" v-for="item in apps" :key="item" style="width:calc(25% - 10px)">
                  <div class="app-icon">
                    <i :class="item.icon" :alt="item.name" />
                  </div>
                  <div class="app-info">
                    <div class="app-item-title">{{ item.name }}</div>
                    <div class="app-item desc">{{ item.desc }}</div>
                  </div>
                </li>
                <li class="app-items" style="width: calc(25% - 10px);background: #f5f5f5;border-radius: 5px;padding-left: 10px;cursor: pointer; margin-top: 10px;"> 
                  <div class="app-icon" style="margin-top: 0px;">
                    <i class="fa-solid fa-plus" />
                  </div>
                  <div class="app-info">
                    <div class="app-item-title">增加应用</div>
                  </div>
                </li>
              </ul>
            </div>
          </div>
          <div class="panel-footer">
            <div class="footer-link">
            </div>
          </div>
        </div>
      </el-col>

      <el-col :span="5">
        <div class="grid-content">
          <div class="panel-header">
            <div class="header-title"><i class="fa-solid fa-tv"></i> 权限服务统计</div>
          </div>
          <div class="panel-body acp-height-auto">
            <ul class="panel-item-text">
              <li style="width:50%;padding:4px;border-bottom: 0px;" v-for="item in opertionAssets" :key="item.id">
                <div class="item-health-box">
                  <div class="item-health-title">{{ item.title }}</div>
                  <div class="item-health-count">{{ item.count }}</div>
                </div>
              </li>
            </ul>
          </div>
          <div class="panel-footer">
            <div class="footer-link">
            </div>
          </div>
        </div>
      </el-col>

    </el-row>
  </div>
</template>

<script setup>

const opertionAssets = ref([
  {id:'1' , title:'应用统计' , count:45} ,
  {id:'2' , title:'功能统计' , count:145} ,
  {id:'3' , title:'角色统计' , count:65} ,
  {id:'4' , title:'用户统计' , count:85} ,
  {id:'5' , title:'部门统计' , count:45} ,
  {id:'6' , title:'操作统计' , count:45} ,
])

const apps = ref([
  {icon:'fa-brands fa-slack' , name:'自动化操作服务' , desc:'自动化操作服务提供了自动化操作的功能，使您能够轻松管理您的操作任务。'},
  {icon:'fa-solid fa-list-check' , name:'分布式配置中心' , desc:'分布式配置中心用于集中管理和分发应用程序的配置信息，帮助您简化配置管理。'},
  {icon:'fa-solid fa-at' , name:'审计日志服务' , desc:'审计日志服务记录和监控系统中发生的各种操作，以确保系统安全和合规性。'},
  {icon:'fa-solid fa-list-check' , name:'容器云管理服务' , desc:'容器云管理服务帮助您管理和监控容器化应用程序在云环境中的部署和运行。'},
  {icon:'fa-solid fa-file-word' , name:'持续集成服务' , desc:'持续集成服务通过自动化构建和测试过程，帮助团队更快地交付高质量的软件。'},
  {icon:'fa-solid fa-eye-slash' , name:'自动化操作服务' , desc:'自动化操作服务提供了自动化操作的功能，使您能够轻松管理您的操作任务。'},
  {icon:'fa-solid fa-user-shield' , name:'分布式配置中心' , desc:'分布式配置中心用于集中管理和分发应用程序的配置信息，帮助您简化配置管理。'},
  {icon:'fa-solid fa-comment-slash' , name:'持续集成服务' , desc:'持续集成服务通过自动化构建和测试过程，帮助团队更快地交付高质量的软件。'},
  {icon:'fa-brands fa-slack' , name:'容器云管理服务' , desc:'容器云管理服务帮助您管理和监控容器化应用程序在云环境中的部署和运行。'},
  {icon:'fa-solid fa-file-word' , name:'持续集成服务' , desc:'持续集成服务通过自动化构建和测试过程，帮助团队更快地交付高质量的软件。'},
  {icon:'fa-solid fa-comment-slash' , name:'一体化安全感触服务' , desc:'一体化安全感触服务提供了全面的安全感知和响应功能，帮助您确保系统安全。'},
]);

</script>

<style lang="scss" scoped>
.item-health-title{
  margin-bottom: 5px !important;
}
.item-health-count{
  margin-bottom: 5px;
}

.app-icon{
    font-size: 20px;
    color: #3b5998 ;
}
</style>