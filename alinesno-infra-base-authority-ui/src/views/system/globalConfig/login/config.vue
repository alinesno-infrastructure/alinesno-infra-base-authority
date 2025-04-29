<template>
  <div class="app-container">
    <div class="label-title">
      <div class="tip">登录配置</div>
      <div class="sub-tip">
        登录配置用于全面管理系统登录相关的各项规则与策略，确保系统登录过程的安全性、便捷性和合规性。
      </div>
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

        <el-form-item label="登录策略" prop="loginStrategies">
            <el-checkbox-group v-model="form.loginStrategies">
                <el-checkbox v-for="item in loginTypeOptions" :key="item.key" :label="item.key">
                    <div style="display: flex;align-items: center;gap: 10px;font-size: 16px;">
                        <div>
                            <i :class="item.icon"></i> 
                        </div>
                        <div style="display: flex;flex-direction: column;gap: 8px;">
                            <div style="color:#222">
                                {{ item.label }}
                            </div>
                            <div class="description" style="font-size: 13px;color:#666">
                                {{ item.description }}
                            </div>
                        </div>
                    </div>
                </el-checkbox>
            </el-checkbox-group>
        </el-form-item>

        <el-form-item label="异常登录次数" prop="abnormalLoginCount">
          <el-input-number
            v-model="form.abnormalLoginCount"
            min="1"
            placeholder="请输入异常登录次数"
          ></el-input-number>
        </el-form-item>

        <el-form-item label="登录异常封号时长" prop="blockDuration">
          <el-input-number
            v-model="form.blockDuration"
            min="1"
            placeholder="请输入登录异常封号时长"
          ></el-input-number>
        </el-form-item>

        <el-form-item label="是否关闭登录" prop="loginDisabled">
          <el-switch v-model="form.loginDisabled" active-text="关闭" inactive-text="开启"></el-switch>
        </el-form-item>

        <el-form-item label="密码强度要求" prop="passwordStrength" >
          <el-select v-model="form.passwordStrength" placeholder="请选择密码强度要求" style="width:50%">
            <el-option label="低（至少6位）" value="low"></el-option>
            <el-option label="中（至少8位，包含字母和数字）" value="medium"></el-option>
            <el-option label="高（至少10位，包含大小写字母、数字和特殊字符）" value="high"></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="记住密码有效期（天）" prop="rememberMeExpireDays">
          <el-input-number
            v-model="form.rememberMeExpireDays"
            min="1"
            placeholder="请输入记住密码有效期（天）"
          ></el-input-number>
        </el-form-item>

        <el-form-item label="是否启用验证码" prop="captchaEnabled">
          <el-switch v-model="form.captchaEnabled" active-text="启用" inactive-text="禁用"></el-switch>
        </el-form-item>

        <el-form-item label="验证码错误次数限制" prop="captchaErrorLimit">
          <el-input-number
            v-model="form.captchaErrorLimit"
            min="1"
            placeholder="请输入验证码错误次数限制"
          ></el-input-number>
        </el-form-item>

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
import { saveLoginConfig , getIdentityConfig } from "@/api/manager/identityConfig";

const form = ref({
  loginStrategies: ['account', 'wechat'],
  loginDisabled: false,
  abnormalLoginCount: 3,
  blockDuration: 24,
  loginAgreement: '',
  passwordStrength: 'low',
  captchaEnabled: false,
  captchaErrorLimit: 3,
  rememberMeExpireDays: 7,
  loginFailureMessage: '用户名或密码错误，请重新输入'
});

// 登录方式
const loginTypeOptions = ref([
    {
      key: "account",
      label: "账号密码登陆",
      description: "使用账号和密码进行登录验证",
      icon: "fa-solid fa-user-lock"
    },
    {
      key: "wechat",
      label: "微信扫码登陆",
      description: "打开微信扫描二维码完成登录",
      icon: "fa-brands fa-weixin"
    },
    {
      key: "email",
      label: "邮箱登陆",
      description: "使用注册邮箱及对应密码登录",
      icon: "fa-solid fa-envelope"
    }
])

const rules = ref({
  loginStrategies: [
    { required: true, message: '请选择登录策略', trigger: 'change' }
  ],
  abnormalLoginCount: [
    { required: true, message: '请输入异常登录次数', trigger: 'blur' },
    { type: 'number', message: '请输入正确的数字', trigger: 'blur' }
  ],
  blockDuration: [
    { required: true, message: '请输入登录异常封号时长', trigger: 'blur' },
    { type: 'number', message: '请输入正确的数字', trigger: 'blur' }
  ],
  loginAgreement: [
    { required: true, message: '请输入登录协议内容', trigger: 'blur' }
  ],
  passwordStrength: [
    { required: true, message: '请选择密码强度要求', trigger: 'change' }
  ],
  captchaEnabled: [
    { required: true, message: '请选择是否启用验证码', trigger: 'change' }
  ],
  captchaErrorLimit: [
    { required: true, message: '请输入验证码错误次数限制', trigger: 'blur' },
    { type: 'number', message: '请输入正确的数字', trigger: 'blur' }
  ],
  rememberMeExpireDays: [
    { required: true, message: '请输入记住密码有效期（天）', trigger: 'blur' },
    { type: 'number', message: '请输入正确的数字', trigger: 'blur' }
  ],
  loginFailureMessage: [
    { required: true, message: '请输入登录失败提示信息', trigger: 'blur' }
  ]
});

const loading = ref(false);
const formRef = ref(null);

const submitForm = (formName) => {
  formRef.value.validate((valid) => {
    if (valid) {
      loading.value = true;

      console.log(JSON.stringify(form.value));

      saveLoginConfig(form.value).then(response => {
        console.log('response ='+ response);
        ElMessage.success('保存成功');
      }).finally(() => {
        loading.value = false;
      });

    }
  });
};

const resetForm = () => {
  formRef.value.resetFields();
  form.value = {
    loginStrategies: ['账号', '密码'],
    loginDisabled: false,
    abnormalLoginCount: 3,
    blockDuration: 24,
    loginAgreement: '',
    passwordStrength: 'low',
    captchaEnabled: false,
    captchaErrorLimit: 3,
    rememberMeExpireDays: 7,
    loginFailureMessage: '用户名或密码错误，请重新输入'
  };
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