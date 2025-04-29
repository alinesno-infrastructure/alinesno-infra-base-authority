<template>
    <div class="app-container">
      <div class="label-title">
        <div class="tip">微信登录配置</div>
        <div class="sub-tip">设置微信登录相关的配置信息，用于与微信公众号进行对接。</div>
      </div>
      <div class="form-container">
        <el-form
          :model="form"
          :rules="rules"
          v-loading="loading"
          ref="formRef"
          size="large"
          label-width="200px"
          class="demo-form">
  
          <el-form-item label="微信公众号 AppID" prop="wxAppId">
            <el-input
              v-model="form.wxAppId"
              placeholder="请输入微信公众号 AppID"
            ></el-input>
          </el-form-item>
  
          <el-form-item label="微信公众号 AppSecret" prop="wxAppSecret">
            <el-input
                type="password"
                show-password
              v-model="form.wxAppSecret"
              placeholder="请输入微信公众号 AppSecret"
            ></el-input>
          </el-form-item>

          <!-- 回调地址 -->
          <el-form-item label="回调地址" prop="wxCallbackUrl">
            <el-input
              v-model="form.wxCallbackUrl"
              placeholder="请输入回调地址"
            ></el-input>
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
  import { onMounted, ref } from 'vue';
  import { ElMessage } from 'element-plus';

  // 模拟保存配置的接口调用，实际使用时需要替换为真实接口
  import { saveWxConfig , getIdentityConfig } from "@/api/manager/identityConfig";
  
  const form = ref({
    wxAppId: '',
    wxAppSecret: '', 
    wxCallbackUrl: ''
  });
  
  const rules = ref({
    wxAppId: [
      { required: true, message: '请输入微信公众号 AppID', trigger: 'blur' }
    ],
    wxAppSecret: [
      { required: true, message: '请输入微信公众号 AppSecret', trigger: 'blur' }
    ] , 
    wxCallbackUrl: [
      { required: true, message: '请输入回调地址', trigger: 'blur' }
    ]
  });
  
  const loading = ref(false);
  const formRef = ref(null);
  
  const submitForm = (formName) => {
    formRef.value.validate((valid) => {
      if (valid) {
        loading.value = true;
  
        console.log(JSON.stringify(form.value));
  
        // 模拟调用保存配置的接口
        saveWxConfig(form.value).then(response => {
          console.log('response ='+ response);
          ElMessage.success('保存成功');
        }).finally(() => {
          loading.value = false;
        });
  
        // 假设保存成功
        setTimeout(() => {
          ElMessage.success('保存成功');
          loading.value = false;
        }, 1000);
      }
    });
  };
  
  const resetForm = () => {
    formRef.value.resetFields();
    form.value = {
      wxAppId: '',
      wxAppSecret: ''
    };
  };

  onMounted(() => {
    getIdentityConfig().then(response => {
      console.log('response ='+ response);
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
