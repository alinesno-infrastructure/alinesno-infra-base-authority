<template>
  <div class="app-container acp-dashboard">

    <el-row>
      <el-col :span="24">
        <div class="aip-appinfo-header">
          <div class="header-icon-banner">
            <i class="fas fa-laptop-code"></i>
          </div>
          <div class="icon">
            <div class="title">
              当前应用 
              <div class="cluster-info">
                <span
                  ><i class="el-icon-monitor"></i>
                  {{ currentEnvClusterObj.clusterName }}</span
                >
                <span>
                  <i class="el-icon-link"></i> 
                  应用地址: {{ currentEnvClusterObj.apiServerUrl }}
                </span>
              </div>
            </div>
            <div class="title-desc">
              集群状态展示集群资源的概览和详情，您可以查看集群资源的监控数据和用量排行情况。
            </div>
          </div>
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
        </div>
      </el-col>
    </el-row>

    <!-- 应用统计 -->
    <!-- <OperationWorkspaceCountStaitcs /> -->

    <!-- 应用套件和状态 -->
    <OperationWorkspaceService />

    <!-- 运行应用列表 -->
    <OperationWorkspaceApps />

  </div>
</template>

<script setup name="Index">

import OperationWorkspaceApps from './operation-workspace/apps.vue'
import OperationWorkspaceService from './operation-workspace/service.vue'

const directContent = ref([
  { icon: 'assets/icons/ability/backup.png', name: '集成数据备份', desc: 'With Route 53 (3 分钟)' },
  { icon: 'assets/icons/ability/logback.png', name: '集成审计日志', desc: 'With Route 53 (3 分钟)' },
  { icon: 'assets/icons/ability/jenkins.png', name: '集成持续集成', desc: 'With Route 53 (3 分钟)' },
  { icon: 'assets/icons/ability/hadoop.png', name: '集成数据治理', desc: 'With Route 53 (3 分钟)' },
  { icon: 'assets/icons/ability/opentelemetry.png', name: '集成OpenTelemetry', desc: 'With Route 53 (3 分钟)' },
  { icon: 'assets/icons/ability/security.png', name: '集成安全扫描', desc: 'With Route 53 (3 分钟)' },
  { icon: 'assets/icons/ability/kubernetes.png', name: '集成发布到K8S', desc: 'With EC2 (2 分钟)' },
]);

const currentEnvClusterObj = ref({
  clusterName: '统一权限管理服务'  , 
  apiServerUrl: 'http://portal.infra.linesno.com'
}) 

// 获取assets静态资源
const getAssetsFile = (name) => {
   return new URL(`../` + name, import.meta.url).href
}

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