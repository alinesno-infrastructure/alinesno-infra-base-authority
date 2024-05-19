<template>
  <div class="app-container acp-dashboard">

    <el-row>
      <el-col :span="24">
        <div class="aip-appinfo-header">
          <div class="header-icon-banner">
            <i :class="currentEnvClusterObj.applicationIcons"></i>
          </div>
          <div class="icon">
            <div class="title">
              {{ currentEnvClusterObj.applicationName }}
              <div class="cluster-info">
                <span>
                  {{ currentEnvClusterObj.applicationDesc }}
                </span>
              </div>
            </div>
            <div class="title-desc">
              多应用管理机构灵活配置和管理系统中的权限，确保用户只能访问其具备权限的功能和资源
            </div>
          </div>

          <!-- 
          <div class="head-app-status">
            应用集成套件
            <div class="integrated-item-box">
              <ul>
                <li v-for="item in directContent" :key="item.icon" style="font-size: 1.4rem;color:#3b5998">
                  <img :src="getAssetsFile(item.icon)" />
                </li>
              </ul>
            </div>
          </div> 
          -->

        </div>
      </el-col>
    </el-row>

    <!-- 应用套件和状态 -->
    <OperationWorkspaceService />

    <!-- 运行应用列表 -->
    <OperationWorkspaceApps />

  </div>
</template>

<script setup name="Index">

import { 
  getCurrentApplication
} from "@/api/system/application";

import OperationWorkspaceApps from './operation-workspace/apps.vue'
import OperationWorkspaceService from './operation-workspace/service.vue'

const currentEnvClusterObj = ref({
  applicationIcons: 'fa-solid fa-user-shield' ,
  applicationName: '统一权限管理服务'  , 
  applicationDesc: '应用业务服务描述，描述业务服务的大致情况'  , 
  apiServerUrl: 'http://portal.infra.linesno.com' ,
  desc: ''
}) 

/** 获取当前应用信息 */
function handleCurrentApplication(){
  getCurrentApplication().then(res => {
    currentEnvClusterObj.value = res.data
  })
}

handleCurrentApplication() ; 

</script>

<style lang="scss" scoped>
.aip-appinfo-header{
  position: relative;
  padding: 20px;
  overflow: hidden;

  .header-icon-banner {
    float: left;
    font-size: 2.4rem;
    margin-right: 10px;
    color: #3b5998;
  }

  .head-app-status{
    float: right;
    font-size: 14px;
    line-height: 1.7rem;
    margin-bottom: 10px;

    .integrated-item-box {

      margin-left: 10px;
      float: right;

      ul , li {
        margin: 0px;
        padding: 0px;
        list-style: none;
      }
      li {
        float:right ;
        margin-right: 10px;

        img {
          border-radius: 5px;
          width: 25px;
        }
      }

    }
  }

  .cluster-info {
    float: right;
    position: relative;
    font-size: 14px;
    margin-left: 10px;
    font-weight: bold;
    margin-top: 10px;
    color: #3b5998;

    span {
      margin-left: 20px;
    }
  }

  .icon {
    float: left;
  }

  .title {
    display: block;
    font-weight: 600;
    font-style: normal;
    font-size: 24px;
    color: #242e42;
    text-shadow: 0 4px 8px rgba(36, 46, 66, 0.1);
    margin-bottom: 10px;
  }

  .title-desc {
    color: #79879c !important;
    font-size: 12px;
  }
}
</style>