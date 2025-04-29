<template>
  <div class="app-container">
    <div class="label-title">
      <div class="tip">单点登陆界面配置</div>
      <div class="sub-tip">针对企业和团队在单点登陆方面的差异化需求，打造契合自身发展的专属平台环境。</div>
    </div>
    <div class="form-container">
      <el-form
        :model="form"
        :rules="rules"
        v-loading="loading"
        ref="formRef"
        size="large"
        label-width="180px"
        class="demo-form">
        <el-form-item label="系统名称" prop="systemName">
          <el-row style="width:100%">
            <el-col :span="24">
              <el-input
                type="input"
                maxlength="50"
                size="large"
                show-word-limit
                v-model="form.systemName"
                placeholder="请输入系统名称"
              ></el-input>
            </el-col>
          </el-row>
        </el-form-item>
        <el-form-item label="背景图片" prop="backgroundImage">
          <el-row style="width:100%">
            <el-col :span="24">
              <el-input
                type="input"
                maxlength="500"
                size="large"
                show-word-limit
                v-model="form.backgroundImage"
                placeholder="请输入背景图片链接"
              ></el-input>
            </el-col>
          </el-row>
        </el-form-item>
        <el-form-item label="系统logo" prop="logo">
          <el-row style="width:100%">
            <el-col :span="24">
              <el-input
                type="input"
                maxlength="500"
                size="large"
                show-word-limit
                v-model="form.logo"
                placeholder="请输入系统logo链接"
              ></el-input>
            </el-col>
          </el-row>
        </el-form-item>
        <el-form-item label="横幅信息" prop="bannerInfo">
          <el-row style="width:100%">
            <el-col :span="24">
              <el-input
                maxlength="500"
                size="large"
                show-word-limit
                v-model="form.bannerInfo"
                placeholder="请输入横幅信息"
              ></el-input>
            </el-col>
          </el-row>
        </el-form-item>
        <el-row style="width:100%">
          <el-col :span="12">
            <el-form-item label="版本号" prop="version">
              <el-row style="width:100%">
                <el-col :span="24">
                  <el-input
                    type="input"
                    maxlength="50"
                    size="large"
                    show-word-limit
                    v-model="form.version"
                    placeholder="请输入版本号"
                  ></el-input>
                </el-col>
              </el-row>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="版权年份" prop="copyrightYear">
              <el-row style="width:100%">
                <el-col :span="24">
                  <el-input
                    type="input"
                    maxlength="50"
                    size="large"
                    show-word-limit
                    v-model="form.copyrightYear"
                    placeholder="请输入版权年份"
                    disabled
                  ></el-input>
                </el-col>
              </el-row>
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item label="版权声明" prop="copyrightLabel">
          <el-row style="width:100%">
            <el-col :span="24">
              <el-input
                type="input"
                maxlength="500"
                size="large"
                show-word-limit
                v-model="form.copyrightLabel"
                placeholder="请输入版权声明"
              ></el-input>
            </el-col>
          </el-row>
        </el-form-item>
        <el-form-item label="门户站点" prop="portalSite">
          <el-row style="width:100%">
            <el-col :span="24">
              <el-input
                type="input"
                maxlength="500"
                size="large"
                show-word-limit
                v-model="form.portalSite"
                placeholder="请输入门户站点链接"
              ></el-input>
            </el-col>
          </el-row>
        </el-form-item>
        <br />
        <el-form-item>
          <el-button type="primary" @click="submitForm('form')">
            保存
          </el-button>
          <el-button @click="resetForm">
            重置
          </el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script setup>
import { ref, reactive, onMounted } from 'vue';
import { getToken } from "@/utils/auth";
import { ElMessage, ElDialog } from 'element-plus';

import { saveLoginUiConfig , getIdentityConfig } from "@/api/manager/identityConfig";

const getCopyrightYear = () => {
  const currentYear = new Date().getFullYear();
  return `${currentYear}-${currentYear + 2}`;
};

const form = ref({
  backgroundImage: "" , 
  logo: "" , 
  systemName: "" , 
  bannerInfo: "" , 
  version: "" , 
  copyrightYear: "" , 
  copyrightLabel: "" , 
  portalSite: "" 
});

const rules = ref({
  systemName: [
    { required: true, message: '请输入系统名称', trigger: 'blur' },
    { min: 1, max: 50, message: '系统名称长度在1到50之间', trigger: 'blur' }
  ],
  backgroundImage: [
    { required: true, message: '请输入背景图片链接', trigger: 'blur' },
    { min: 1, max: 500, message: '背景图片链接长度在1到500之间', trigger: 'blur' }
  ],
  logo: [
    { required: true, message: '请输入系统logo链接', trigger: 'blur' },
    { min: 1, max: 500, message: '系统logo链接长度在1到500之间', trigger: 'blur' }
  ],
  bannerInfo: [
    { required: true, message: '请输入横幅信息', trigger: 'blur' },
    { min: 1, max: 500, message: '横幅信息长度在1到500之间', trigger: 'blur' }
  ],
  version: [
    { required: true, message: '请输入版本号', trigger: 'blur' },
    { min: 1, max: 50, message: '版本号长度在1到50之间', trigger: 'blur' }
  ],
  copyrightYear: [
    { required: true, message: '请输入版权年份', trigger: 'blur' },
    { min: 1, max: 50, message: '版权年份长度在1到50之间', trigger: 'blur' }
  ],
  copyrightLabel: [
    { required: true, message: '请输入版权声明', trigger: 'blur' },
    { min: 1, max: 500, message: '版权声明长度在1到500之间', trigger: 'blur' }
  ],
  portalSite: [
    { required: true, message: '请输入门户站点链接', trigger: 'blur' },
    { min: 1, max: 500, message: '门户站点链接长度在1到500之间', trigger: 'blur' }
  ]
});

const loading = ref(false);
const formRef = ref(null);

const submitForm = (formName) => {
  formRef.value.validate((valid) => {
    if (valid) {
      loading.value = true;

      console.log(JSON.stringify(form.value))

      saveLoginUiConfig(form.value).then(response => {
        console.log('response = ' + response);
        ElMessage.success('保存成功');
      });

      loading.value = false;
    }
  });
};

const resetForm = () => {
  formRef.value.resetFields();
  form.value = {}
};

onMounted(() => {
  getIdentityConfig().then(response => {
    form.value = response.data;
  });
});

</script>

<style scoped lang="scss">
.app-container {

 .label-title {
    text-align: center;
    max-width: 960px;
    margin: 10px auto 0;

   .tip {
      padding-bottom: 10px;
      font-size: 26px;
      font-weight: bold;
    }

   .sub-tip {
      font-size: 13px;
      text-align: center;
      padding: 10px;
    }
  }

 .form-container {
    max-width: 960px;
    margin: 20px auto 0;

   .demo-form {
     .image {
        width: 100%;
        height: 130px;
      }

     .select-card {
        border: 1px solid rgb(0, 91, 212);
      }
    }
  }
}
</style>    