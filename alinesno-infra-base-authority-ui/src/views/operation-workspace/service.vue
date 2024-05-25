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
                <li class="app-items" v-for="(item,index) in apps" :key="item" style="width:calc(25% - 10px)">
                  <div class="app-icon">
                    <!-- <i :class="item.icon" :alt="item.projectName" /> -->
                    <img style="width:30px;height:30px;border-radius:4px;" :src="'http://data.linesno.com/icons/sepcialist/dataset_' + ((index + 1)%10 + 5) + '.png'" />
                  </div>
                  <div class="app-info">
                    <div class="app-item-title">{{ item.projectName }}</div>
                    <div class="app-item desc">{{ item.projectDesc }}</div>
                  </div>
                </li>
                <li class="app-items" @click="handleAdd()" style="width: calc(25% - 10px);background: #f5f5f5;border-radius: 5px;padding-left: 10px;cursor: pointer; margin-top: 10px;"> 
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

    <!-- 操作日志详细 -->
    <el-dialog :title="title" v-model="open" width="700px" append-to-body>
      <el-form ref="applicationFormRef" :model="form" :rules="rules" label-width="80px">
          <el-col :span="24">
            <el-form-item label="菜单图标" prop="projectIcons">
              <el-popover
                  placement="bottom-start"
                  :width="540"
                  trigger="click"
                  @show="showSelectIcon">
                <template #reference>
                  <el-input v-model="form.projectIcons" placeholder="点击选择图标" @click="showSelectIcon" v-click-outside="hideSelectIcon" readonly>
                    <template #prefix>
                      <svg-icon
                          v-if="form.projectIcons"
                          :icon-class="form.projectIcons"
                          class="el-input__icon"
                          style="height: 32px;width: 16px;"
                      />
                      <el-icon v-else style="height: 32px;width: 16px;"><search /></el-icon>
                    </template>
                  </el-input>
                </template>
                <icon-select ref="iconSelectRef" @selected="selected" />
              </el-popover>
            </el-form-item>
          </el-col>
        <el-form-item label="应用名称" prop="projectName">
          <el-input v-model="form.projectName" placeholder="请输入应用名称" />
        </el-form-item>
        <el-form-item label="应用描述" prop="projectDesc">
          <el-input v-model="form.projectDesc" placeholder="请输入应用描述" />
        </el-form-item>
        <el-form-item label="应用代码" prop="projectCode">
          <el-input v-model="form.projectCode" placeholder="请输入应用代码" />
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button :loading="buttonLoading" type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>

  </div>
</template>

<script setup>

const { proxy } = getCurrentInstance();

import { 
  addProject , 
  getLatestList
} from "@/api/system/project";

const opertionAssets = ref([
  {id:'1' , title:'应用统计' , count:45} ,
  {id:'2' , title:'功能统计' , count:145} ,
  {id:'3' , title:'角色统计' , count:65} ,
  {id:'4' , title:'用户统计' , count:85} ,
  {id:'5' , title:'部门统计' , count:45} ,
  {id:'6' , title:'操作统计' , count:45} ,
])

const apps = ref([
  {icon:'fa-brands fa-slack' , projectName:'自动化操作服务' , projectDesc:'自动化操作服务提供了自动化操作的功能，使您能够轻松管理您的操作任务。'},
  {icon:'fa-solid fa-list-check' , projectName:'分布式配置中心' , projectDesc:'分布式配置中心用于集中管理和分发应用程序的配置信息，帮助您简化配置管理。'},
  {icon:'fa-solid fa-at' , projectName:'审计日志服务' , projectDesc:'审计日志服务记录和监控系统中发生的各种操作，以确保系统安全和合规性。'},
  {icon:'fa-solid fa-list-check' , projectName:'容器云管理服务' , projectDesc:'容器云管理服务帮助您管理和监控容器化应用程序在云环境中的部署和运行。'},
  {icon:'fa-solid fa-file-word' , projectName:'持续集成服务' , projectDesc:'持续集成服务通过自动化构建和测试过程，帮助团队更快地交付高质量的软件。'},
  {icon:'fa-solid fa-eye-slash' , projectName:'自动化操作服务' , projectDesc:'自动化操作服务提供了自动化操作的功能，使您能够轻松管理您的操作任务。'},
  {icon:'fa-solid fa-user-shield' , projectName:'分布式配置中心' , projectDesc:'分布式配置中心用于集中管理和分发应用程序的配置信息，帮助您简化配置管理。'},
  {icon:'fa-solid fa-comment-slash' , projectName:'持续集成服务' , projectDesc:'持续集成服务通过自动化构建和测试过程，帮助团队更快地交付高质量的软件。'},
  {icon:'fa-brands fa-slack' , projectName:'容器云管理服务' , projectDesc:'容器云管理服务帮助您管理和监控容器化应用程序在云环境中的部署和运行。'},
  {icon:'fa-solid fa-file-word' , projectName:'持续集成服务' , projectDesc:'持续集成服务通过自动化构建和测试过程，帮助团队更快地交付高质量的软件。'},
  {icon:'fa-solid fa-comment-slash' , projectName:'一体化安全感触服务' , projectDesc:'一体化安全感触服务提供了全面的安全感知和响应功能，帮助您确保系统安全。'},
]);

const title = ref("");
const open = ref(false);
const loading = ref(true);

const data = reactive({
  form: {},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    title: undefined,
    operName: undefined,
    businessType: undefined,
    status: undefined
  }
});

const { queryParams, form } = toRefs(data);

/** 表单重置 */
function reset() {
  form.value = {
    id: undefined,
    parentId: undefined,
    deptName: undefined,
    orderNum: 0,
    leader: undefined,
    phone: undefined,
    email: undefined,
    status: "0"
  };
  proxy.resetForm("deptRef");
}

/** 新增按钮操作 */
function handleAdd() {
  reset();
  open.value = true;
  title.value = "添加应用";
}

/** 取消按钮 */
function cancel() {
  open.value = false;
  reset();
}

/** 查询登录日志 */
function handleLatestList() {
  loading.value = true;
  getLatestList().then(response => {
    apps.value = response.data ;
    loading.value = false;
  });
}

/** 提交按钮 */
function submitForm() {
  proxy.$refs["applicationFormRef"].validate(valid => {
    if (valid) {
        addProject(form.value).then(response => {
          proxy.$modal.msgSuccess("新增成功");
          open.value = false;
          handleLatestList();
        });
    }
  });
}

handleLatestList() ;

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
</style>@/api/system/project