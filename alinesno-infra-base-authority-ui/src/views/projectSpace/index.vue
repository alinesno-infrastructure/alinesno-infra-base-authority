<template>
    <div class="app-container project-space-container">

        <el-page-header @back="goBack" style="margin-bottom: 20px;">
            <template #content>
                <span class="text-default font-600 mr-3" style="font-size:16px"> 项目空间</span>
            </template>
        </el-page-header>

        <el-tabs :tab-position="tabPosition" style="height: calc(100vh - 160px)" class="demo-tabs" v-model="activeTab" @tab-click="handleTabClick">
            <el-tab-pane name="departmentManagement" label="departmentManagement">
                <template #label>
                    <i class="fa-solid fa-building"></i> 部门管理
                </template>
                <ProjectDeptPanel />
            </el-tab-pane>
            <el-tab-pane name="positionManagement">
                <template #label>
                    <i class="fa-solid fa-user-tie"></i> 岗位管理
                </template>
                <ProjectPostPanel />
            </el-tab-pane>
            <el-tab-pane name="dictionaryManagement">
                <template #label>
                    <i class="fa-solid fa-book"></i> 字典管理
                </template>
                <ProjectDictPanel />
            </el-tab-pane>
            <el-tab-pane name="parameterDesign">
                <template #label>
                    <i class="fa-solid fa-sliders"></i> 参数设计
                </template>
                <ProjectConfigPanel />
            </el-tab-pane>
            <el-tab-pane name="systemTheme">
                <template #label>
                    <i class="fa-solid fa-palette"></i> 系统主题
                </template>
                <ProjectEnterpriseSettingPanel />
            </el-tab-pane>
            <el-tab-pane name="loginTheme">
                <template #label>
                    <i class="fa-solid fa-key"></i> 登陆主题
                </template>
                <ProjectEnterprisethemePanel />
            </el-tab-pane> 
        </el-tabs>
    </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { useRouter } from 'vue-router';
import { getCurrentInstance } from 'vue';

import ProjectDeptPanel from '@/views/system/dept/index';
import ProjectPostPanel from '@/views/system/post/index';
import ProjectDictPanel from '@/views/system/dict/index';
import ProjectConfigPanel from '@/views/system/config/index';
import ProjectEnterpriseSettingPanel from '@/views/enterprise/setting/index';
import ProjectEnterprisethemePanel from '@/views/enterprise/theme/index';

const router = useRouter();
const { proxy } = getCurrentInstance();
const projectId = router.currentRoute.value.params.projectId;
const tabPosition = ref('right');

// 根据项目 ID 获取存储的激活标签页
const getStoredActiveTab = () => {
    return localStorage.getItem(`activeTab_${projectId}`);
};

// 保存激活标签页到本地存储
const saveActiveTab = (tabName) => {
    console.log('saveActiveTab = ' + tabName);
    localStorage.setItem(`activeTab_${projectId}`, tabName);
};

// 初始化 activeTab，若本地存储没有记录则默认显示第一个标签页
const defaultActiveTab = 'departmentManagement';
const storedTab = getStoredActiveTab();
const activeTab = ref(storedTab || defaultActiveTab);

const goBack = () => {
  console.log('go back')
  router.go(-1);
}

// 处理标签页点击事件
const handleTabClick = (tab , event) => {
    console.log('handleTabClick = ' + JSON.stringify(tab) + ' , event = ' + JSON.stringify(event));
    activeTab.value = tab.props.name ;
    saveActiveTab(tab.props.name);
};

// 页面加载时恢复标签页状态
onMounted(() => {
    const stored = getStoredActiveTab();
    console.log('stored = ' + stored);
    if (stored) {
        activeTab.value = stored;
    } else {
        activeTab.value = defaultActiveTab;
        console.log('activeTab.value = ' + activeTab.value);
        saveActiveTab(defaultActiveTab); // 若没有存储记录，保存默认选中项
    }
});
</script>

<style scoped lang="scss">
.project-space-container {
    padding: 10px 20px !important;
}
</style>    